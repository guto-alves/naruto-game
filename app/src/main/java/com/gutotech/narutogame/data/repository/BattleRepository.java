package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Battle;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;

public class BattleRepository {
    private static final BattleRepository ourInstance = new BattleRepository();

    public static BattleRepository getInstance() {
        return ourInstance;
    }

    private BattleRepository() {
    }

    public String generateId(String label) {
        return label + "-" + FirebaseConfig.getDatabase().child("battles").push().getKey();
    }

    public void create(Character player, Character opponent) {
        String id = generateId("VILLAGEMAP-PVP");

        Battle battle = new Battle(player, opponent);
        battle.setId(id);

        saveId(battle.getPlayer1().getNick(), id);
        saveId(battle.getPlayer2().getNick(), id);

        save(battle);
    }

    private void saveId(String nick, String id) {
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("battle-id")
                .child(nick)
                .child("id");

        battleReference.setValue(id);
    }

    public void removeId(String nick) {
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("battle-id")
                .child(nick);

        battleReference.removeValue();
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

    public void observeIds(Callback<String> callback) {
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("battle-id")
                .child(CharOn.character.getNick())
                .child("id");

        battleReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String battleId = dataSnapshot.getValue(String.class);

                if (battleId == null) {
                    return;
                }

                callback.call(battleId);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
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

    private DatabaseReference battleReference;
    private ValueEventListener battleEventListener;

    public void observeBattle(String battleId, Callback<Battle> callback) {
        battleReference = FirebaseConfig.getDatabase()
                .child("battles")
                .child(battleId);

        battleEventListener = battleReference.addValueEventListener(new ValueEventListener() {
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
        if (battleEventListener != null) {
            battleReference.removeEventListener(battleEventListener);
            battleEventListener = null;
        }
    }
}
