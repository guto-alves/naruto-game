package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Player;

public class PlayerRepository {
    private static PlayerRepository instance;

    private PlayerRepository() {
    }

    public static PlayerRepository getInstance() {
        if (instance == null)
            instance = new PlayerRepository();
        return instance;
    }

    public void savePlayer(Player player) {
        DatabaseReference playerRef = FirebaseConfig.getDatabase()
                .child("players").child(FirebaseConfig.getAuth().getCurrentUser().getUid());

        playerRef.setValue(player);
    }

    public void getCurrentPlayer(CallBack callBack) {
        DatabaseReference playerReference = FirebaseConfig.getDatabase()
                .child("players")
                .child(FirebaseConfig.getAuth().getCurrentUser().getUid());

        playerReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Player player = dataSnapshot.getValue(Player.class);
                callBack.onPlayerReceived(player);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public interface CallBack {
        void onPlayerReceived(Player player);
    }
}
