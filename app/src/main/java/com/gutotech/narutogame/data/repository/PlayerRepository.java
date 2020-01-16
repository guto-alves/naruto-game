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

    /*
    private void writeNewPost(String userId, String username, String title, String body) {
        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously
        String key = mDatabase.child("posts").push().getKey();
        Post post = new Post(userId, username, title, body);
        Map<String, Object> postValues = post.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/posts/" + key, postValues);
        childUpdates.put("/user-posts/" + userId + "/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
    }
    */

    public void getCurrentPlayer(CallBack callBack) {
        DatabaseReference playerReference = FirebaseConfig.getDatabase()
                .child("players")
                .child(AuthRepository.getInstance().getUid());

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

    public void updatePassword(String newPassword) {
        DatabaseReference playerReference = FirebaseConfig.getDatabase()
                .child("players")
                .child(AuthRepository.getInstance().getUid())
                .child("password");

        playerReference.setValue(newPassword);
    }

    public void isValidCurrentPassword(String currentPassword, ResultListener emitter) {
        DatabaseReference playerRef = FirebaseConfig.getDatabase()
                .child("players")
                .child(AuthRepository.getInstance().getUid())
                .child("password");

        playerRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String password = dataSnapshot.getValue(String.class);

                if (TextUtils.equals(password, currentPassword)) {
                    emitter.onResult(true);
                } else
                    emitter.onResult(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public interface ResultListener {
        void onResult(boolean b);
    }

    public interface CallBack {
        void onPlayerReceived(Player player);
    }
}
