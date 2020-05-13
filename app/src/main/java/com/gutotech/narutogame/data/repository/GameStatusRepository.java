package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;

import java.util.HashMap;
import java.util.Map;

public class GameStatusRepository {
    public static String VERSION_NAME = "2.2";

    private static final GameStatusRepository sInstance = new GameStatusRepository();

    private GameStatusRepository() {
    }

    public static GameStatusRepository getInstance() {
        return sInstance;
    }

    public void getGameStatus(Callback<Map<String, String>> callback) {
        DatabaseReference gameStatusReference = FirebaseConfig.getDatabase()
                .child("game-status");

        Map<String, String> map = new HashMap<>();

        gameStatusReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                map.clear();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    map.put(data.getKey(), data.getValue(String.class));
                }

                callback.call(map);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private DatabaseReference mGameStatusReference;
    private ValueEventListener mStatusEventListener;

    public void registerGameStatusListener(Callback<String> callback) {
        mGameStatusReference = FirebaseConfig.getDatabase()
                .child("game-status/status");

        mStatusEventListener = mGameStatusReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                callback.call(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void removeGameStatusListener() {
        if (mStatusEventListener != null) {
            mGameStatusReference.removeEventListener(mStatusEventListener);
            mStatusEventListener = null;
        }
    }

    public void getStatus(Callback<String> callback) {
        DatabaseReference gameStatusReference = FirebaseConfig.getDatabase()
                .child("game-status/status");

        gameStatusReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                callback.call(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
