package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Character;

import java.util.ArrayList;
import java.util.List;

public class HallOfFameRepository {
    private static final HallOfFameRepository sInstance = new HallOfFameRepository();

    private HallOfFameRepository() {
    }

    public static HallOfFameRepository getInstance() {
        return sInstance;
    }

    public void getRounds(Callback<List<String>> callback) {
        DatabaseReference databaseReference = FirebaseConfig.getDatabase()
                .child("rounds");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> rounds = new ArrayList<>();

                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    rounds.add(snap.getValue(String.class));
                }

                callback.call(rounds);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void get(String round, Callback<List<Character>> callback) {
        DatabaseReference hallOfFameReference = FirebaseConfig.getDatabase()
                .child("hall-of-fame")
                .child(String.valueOf(round));

        hallOfFameReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Character> kages = new ArrayList<>();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    kages.add(data.getValue(Character.class));
                }

                callback.call(kages);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
