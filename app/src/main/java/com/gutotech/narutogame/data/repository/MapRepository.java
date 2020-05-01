package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.CharOn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapRepository {
    private static MapRepository sInstance = new MapRepository();

    private MapRepository() {
    }

    public static MapRepository getInstance() {
        return sInstance;
    }

    public void move(int villageId) {
        DatabaseReference mapReference = FirebaseConfig.getDatabase()
                .child("village-map")
                .child(String.valueOf(villageId))
                .child(CharOn.character.getId());

        mapReference.setValue(CharOn.character);
    }

    public void exit(int villageId, String charId) {
        DatabaseReference mapReference = FirebaseConfig.getDatabase()
                .child("village-map")
                .child(String.valueOf(villageId))
                .child(charId);

        mapReference.removeValue();
    }

    private DatabaseReference mMapReference;
    private ValueEventListener mMapValueEventListener;

    public LiveData<Map<Integer, List<Character>>> load(int villageId) {
        close();

        MutableLiveData<Map<Integer, List<Character>>> data = new MutableLiveData<>();
        Map<Integer, List<Character>> map = new HashMap<>();

        mMapReference = FirebaseConfig.getDatabase()
                .child("village-map")
                .child(String.valueOf(villageId));

        mMapValueEventListener = mMapReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                map.clear();

                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    Character newCharacter = snap.getValue(Character.class);

                    if (map.get(newCharacter.getMapPosition()) != null) {
                        map.get(newCharacter.getMapPosition()).add(newCharacter);
                    } else {
                        List<Character> characterList = new ArrayList<>();
                        characterList.add(newCharacter);
                        map.put(newCharacter.getMapPosition(), characterList);
                    }
                }

                data.postValue(map);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        return data;
    }

    public void close() {
        if (mMapValueEventListener != null) {
            mMapReference.removeEventListener(mMapValueEventListener);
            mMapValueEventListener = null;
        }
    }


    // Map battle requests
    private boolean mRequestResult;

    public synchronized void requestBattle(String battleId, String playerId, String oppId,
                                           Callback<Boolean> callback) {
        DatabaseReference requestsReference = FirebaseConfig.getDatabase()
                .child("map-battle-requests");

        requestsReference.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                HashMap<String, String> requests = (HashMap<String, String>) mutableData.getValue();

                if (requests == null) {
                    return Transaction.success(mutableData);
                }

                if (requests.containsKey("playerId") && !requests.containsKey(playerId) &&
                        !requests.containsKey(oppId)) {
                    requests.put(playerId, battleId);
                    requests.put(oppId, battleId);
                    mutableData.setValue(requests);
                    mRequestResult = true;
                } else {
                    mRequestResult = false;
                }

                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b,
                                   @Nullable DataSnapshot dataSnapshot) {
                callback.call(mRequestResult);
            }
        });
    }

    public void removeBattleRequest(String playerId) {
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("map-battle-requests")
                .child(playerId);

        battleReference.removeValue();
    }

    private DatabaseReference mBattleRequestsReference;
    private ValueEventListener mBattleRequestsEventListener;

    public void addBattleRequestListener(String playerId, Callback<String> callback) {
        removeBattleRequestsListener();

        mBattleRequestsReference = FirebaseConfig.getDatabase()
                .child("map-battle-requests")
                .child(playerId);

        mBattleRequestsEventListener = mBattleRequestsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String battleId = dataSnapshot.getValue(String.class);

                    if (battleId == null) {
                        return;
                    }

                    callback.call(battleId);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void removeBattleRequestsListener() {
        if (mBattleRequestsEventListener != null) {
            mBattleRequestsReference.removeEventListener(mBattleRequestsEventListener);
            mBattleRequestsEventListener = null;
        }
    }


    public void getDuelCounters(String playerId, Callback<Map<String, Integer>> callback) {
        DatabaseReference databaseReference = FirebaseConfig.getDatabase()
                .child("duel-counters")
                .child(playerId);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String, Integer> map = new HashMap<>();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    map.put(data.getKey(), data.getValue(Integer.class));
                }

                callback.call(map);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void incrementDuelCount(String playerId, String opponentId) {
        DatabaseReference databaseReference = FirebaseConfig.getDatabase()
                .child("duel-counters")
                .child(playerId)
                .child(opponentId);

        databaseReference.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                int count = 0;

                if (mutableData.getValue() != null) {
                    count = mutableData.getValue(Integer.class);
                }

                mutableData.setValue(count + 1);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b,
                                   @Nullable DataSnapshot dataSnapshot) {
            }
        });
    }

    public void clearDuelsCount() {
        DatabaseReference databaseReference = FirebaseConfig.getDatabase()
                .child("duel-counters")
                .child(CharOn.character.getId());

        databaseReference.removeValue();
    }
}
