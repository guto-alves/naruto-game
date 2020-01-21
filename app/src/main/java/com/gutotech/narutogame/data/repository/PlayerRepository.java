package com.gutotech.narutogame.data.repository;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Player;

public class PlayerRepository {
    private static PlayerRepository sInstance;

    private PlayerRepository() {
    }

    public static PlayerRepository getInstance() {
        if (sInstance == null)
            sInstance = new PlayerRepository();
        return sInstance;
    }

    public void savePlayer(Player player) {
        DatabaseReference playerRef = FirebaseConfig.getDatabase()
                .child("players")
                .child(player.getId());

        playerRef.setValue(player);
    }

    public void getCurrentPlayer(Callback<Player> callBack) {
        DatabaseReference playerReference = FirebaseConfig.getDatabase()
                .child("players")
                .child(AuthRepository.getInstance().getUid());

        playerReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Player player = dataSnapshot.getValue(Player.class);
                callBack.call(player);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void updatePassword(String newPassword) {
        DatabaseReference playerReference = FirebaseConfig.getDatabase()
                .child("players")
                .child(AuthRepository.getInstance().getUid())
                .child("password");

        playerReference.setValue(newPassword);
    }

    public void isValidCurrentPassword(String currentPassword, Callback<Boolean> callback) {
        DatabaseReference playerRef = FirebaseConfig.getDatabase()
                .child("players")
                .child(AuthRepository.getInstance().getUid())
                .child("password");

        playerRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String password = dataSnapshot.getValue(String.class);

                if (TextUtils.equals(password, currentPassword)) {
                    callback.call(true);
                } else {
                    callback.call(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
