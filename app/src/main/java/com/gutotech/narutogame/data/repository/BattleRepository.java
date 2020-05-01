package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.firebase.FirebaseFunctionsUtils;
import com.gutotech.narutogame.data.model.Battle;
import com.gutotech.narutogame.data.model.Character;

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

    public void exit(String battleId) {
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("battles")
                .child(battleId);

        battleReference.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                Battle battle1 = mutableData.getValue(Battle.class);

                if (battle1 == null) {
                    return Transaction.success(mutableData);
                }

                int playersInBattle = battle1.getPlayersInBattle() - 1;
                if (playersInBattle == 0) {
                    mutableData.setValue(null);
                } else {
                    battle1.setPlayersInBattle(playersInBattle);
                    mutableData.setValue(battle1);
                }

                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b,
                                   @Nullable DataSnapshot dataSnapshot) {
            }
        });
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

    public void addBattleListener(String battleId, Callback<Battle> callback) {
        removeBattleListener();
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
}
