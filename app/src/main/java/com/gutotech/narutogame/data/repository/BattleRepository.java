package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.firebase.FirebaseFunctionsUtils;
import com.gutotech.narutogame.data.model.Battle;
import com.gutotech.narutogame.data.model.BattleRequest;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.MapRequests;

import java.util.ArrayList;
import java.util.Arrays;

public class BattleRepository {
    private static final BattleRepository ourInstance = new BattleRepository();

    public static BattleRepository getInstance() {
        return ourInstance;
    }

    private BattleRepository() {
    }

    public String generateId(String label) {
        return label + FirebaseConfig.getDatabase().child("battles").push().getKey();
    }

    public void create(String battleId, Character player, Character opponent) {
        FirebaseFunctionsUtils.getServerTime(currentTimestamp -> {
            Battle battle = new Battle(battleId, player, opponent, currentTimestamp);
            save(battle);
        });
    }

    public void save(Battle battle) {
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("battles")
                .child(battle.getId());

        battleReference.setValue(battle);
    }

    public void delete(String battleId) {
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("battles")
                .child(battleId);

        battleReference.removeValue();
    }

    public void get(String battleId, Callback<Battle> callback) {
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("battles")
                .child(battleId);

        battleReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                callback.call(dataSnapshot.getValue(Battle.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private DatabaseReference mBattleReference;
    private ValueEventListener mBattleEventListener;

    public void observeBattle(String battleId, Callback<Battle> callback) {
        mBattleReference = FirebaseConfig.getDatabase()
                .child("battles")
                .child(battleId);

        mBattleEventListener = mBattleReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    callback.call(dataSnapshot.getValue(Battle.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void removeBattleListener() {
        if (mBattleEventListener != null) {
            mBattleReference.removeEventListener(mBattleEventListener);
            mBattleEventListener = null;
        }
    }


    // Map battles requests
    public void requestBattle(String battleId, String playerId, String oppId, int villageId,
                              Callback<Boolean> callback) {
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("map-battle-requests")
                .child(String.valueOf(villageId));

        final boolean[] result = {false};
        battleReference.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                MapRequests mapRequests = new MapRequests(villageId, new ArrayList<>());

                if (mutableData.getValue() != null) {
                    mapRequests = mutableData.getValue(MapRequests.class);
                }

                if (mapRequests == null) {
                    return Transaction.success(mutableData);
                }

                if (mapRequests.requests == null) {
                    mapRequests.requests = new ArrayList<>();
                }

                boolean noRequest = true;

                for (BattleRequest battleRequest : mapRequests.requests) {
                    if (battleRequest.fightersIds.contains(playerId) ||
                            battleRequest.fightersIds.contains(oppId)) {
                        noRequest = false;
                        break;
                    }
                }

                if (noRequest) {
                    mapRequests.requests.add(new BattleRequest(
                            battleId, Arrays.asList(playerId, oppId)));
                }

                result[0] = noRequest;

                mutableData.setValue(mapRequests);

                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b,
                                   @Nullable DataSnapshot dataSnapshot) {
                callback.call(result[0]);
            }
        });
    }

    public void addOnBattleRequestChangeListener(String playerId, int villageId,
                                                 Callback<String> callback) {
        DatabaseReference battleRequestsReference = FirebaseConfig.getDatabase()
                .child("map-battle-requests")
                .child(String.valueOf(villageId))
                .child("requests");

        battleRequestsReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                BattleRequest battleRequest = dataSnapshot.getValue(BattleRequest.class);

                if (battleRequest == null || battleRequest.fightersIds == null) {
                    return;
                }

                if (battleRequest.fightersIds.contains(playerId)) {
                    battleRequestsReference.removeEventListener(this);
                    removeBattleRequest(villageId, playerId);
                    callback.call(battleRequest.battleId);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void removeBattleRequest(int villageId, String playerId) {
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("map-battle-requests")
                .child(String.valueOf(villageId));

        battleReference.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                MapRequests mapRequests = mutableData.getValue(MapRequests.class);

                if (mapRequests == null) {
                    return Transaction.success(mutableData);
                }

                if (mapRequests.requests == null) {
                    return Transaction.success(mutableData);
                }

                for (int i = 0; i < mapRequests.requests.size(); i++) {
                    BattleRequest battleRequest = mapRequests.requests.get(i);
                    if (battleRequest.fightersIds.contains(playerId)) {
                        battleRequest.fightersIds.remove(playerId);

                        if (battleRequest.fightersIds.size() == 0) {
                            battleRequest = null;
                        }

                        mapRequests.requests.set(i, battleRequest);
                        break;
                    }
                }

                mutableData.setValue(mapRequests);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b,
                                   @Nullable DataSnapshot dataSnapshot) {
            }
        });
    }
}
