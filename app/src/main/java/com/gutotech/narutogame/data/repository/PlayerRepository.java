package com.gutotech.narutogame.data.repository;

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

    public void insertPlayer(Player player) {
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
                .child(AuthRepository.getInstance().getCurrentUser().getUid());

        playerReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//
//                }

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
