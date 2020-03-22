package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.CharOn;

public class DojoRandomWaitRepository {
    private static final DojoRandomWaitRepository ourInstance = new DojoRandomWaitRepository();

    public static DojoRandomWaitRepository getInstance() {
        return ourInstance;
    }

    private DojoRandomWaitRepository() {
    }

    public void goToQueue() {
        isQueue(isQueue -> {
            if (!isQueue) {
                DatabaseReference waitQueueReference = FirebaseConfig.getDatabase()
                        .child("dojo-random-wait")
                        .child(CharOn.character.getId());

                waitQueueReference.setValue(CharOn.character);
            }
        });
    }

    private void isQueue(Callback<Boolean> callback) {
        DatabaseReference waitQueueReference = FirebaseConfig.getDatabase()
                .child("dojo-random-wait")
                .child(CharOn.character.getId());

        waitQueueReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                callback.call(dataSnapshot.exists());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void exit() {
        DatabaseReference waitQueueReference = FirebaseConfig.getDatabase()
                .child("dojo-random-wait")
                .child(CharOn.character.getId());

        waitQueueReference.removeValue();
    }

    private DatabaseReference battleIdReference;
    private ValueEventListener valueEventListener;

    public void observe(Callback<String> callback) {
        battleIdReference = FirebaseConfig.getDatabase()
                .child("dojo-pvp-ids")
                .child(CharOn.character.getId())
                .child("battleId");

        removeObserver();

        valueEventListener = battleIdReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String battleId = dataSnapshot.getValue(String.class);

                if (battleId != null) {
                    callback.call(battleId);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void removeObserver() {
        if (valueEventListener != null) {
            battleIdReference.removeEventListener(valueEventListener);
        }
    }

    public void removeId() {
        DatabaseReference battleIdReference = FirebaseConfig.getDatabase()
                .child("dojo-pvp-ids")
                .child(CharOn.character.getId());

        battleIdReference.removeValue();
    }
}
