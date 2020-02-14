package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Battle;
import com.gutotech.narutogame.data.model.CharOn;

public class BattleRepository {
    private static final BattleRepository ourInstance = new BattleRepository();

    public static BattleRepository getInstance() {
        return ourInstance;
    }

    private BattleRepository() {
    }

    public String generateId(String label) {
        return label + "-" + FirebaseConfig.getDatabase().push().getKey();
    }

    public String create(Battle battle) {
        String id = generateId("MAPA");

        battle.setId(id);

        saveId(battle.getPlayer1().getNick(), id);
        saveId(battle.getPlayer2().getNick(), id);

        save(battle);

        return id;
    }

    private void saveId(String nick, String id) {
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("battle-id")
                .child(nick)
                .child(id);

        battleReference.setValue(true);
    }

    private void removeId(String nick, String id) {
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("battle-id")
                .child(nick)
                .child(id);

        battleReference.removeValue();
    }

    public void save(Battle battle) {
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("battles")
                .child(battle.getId());

        battleReference.setValue(battle);
    }

    public void remove(String battleId){
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("battles")
                .child(battleId);

        battleReference.setValue(battleId);
    }

    public void observeIds(Callback<String> callback) {
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("battle-id");

        battleReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String key = dataSnapshot.getKey();

                if (key.contains(CharOn.character.getNick())) {
                    callback.call(key);
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

    public void observeBattle(String battleId, Callback<Battle> callback) {
        DatabaseReference battleReference = FirebaseConfig.getDatabase()
                .child("battles")
                .child(battleId);

        battleReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                callback.call(dataSnapshot.getValue(Battle.class));
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
}
