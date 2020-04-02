package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.NinjaLucky;

public class NinjaLuckyRepository {
    private static NinjaLuckyRepository sInstance = new NinjaLuckyRepository();

    private NinjaLuckyRepository() {
    }

    public static NinjaLuckyRepository getInstance() {
        return sInstance;
    }

    public void save(String charId, NinjaLucky ninjaLucky) {
        DatabaseReference ninjaLuckyRef = FirebaseConfig.getDatabase()
                .child("ninja-lucky")
                .child(charId);

        ninjaLuckyRef.setValue(ninjaLucky);
    }

    public void delete(String charId) {
        DatabaseReference ninjaLuckyRef = FirebaseConfig.getDatabase()
                .child("ninja-lucky")
                .child(charId);

        ninjaLuckyRef.removeValue();
    }

    private DatabaseReference mNinjaLuckyRef;
    private ValueEventListener mNinjaLuckyListener;

    public void get(String charId, Callback<NinjaLucky> listener) {
        mNinjaLuckyRef = FirebaseConfig.getDatabase()
                .child("ninja-lucky")
                .child(charId);

        mNinjaLuckyListener = mNinjaLuckyRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                NinjaLucky ninjaLucky = dataSnapshot.getValue(NinjaLucky.class);
                listener.call(ninjaLucky);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void removeEventListener() {
        if (mNinjaLuckyListener != null) {
            mNinjaLuckyRef.removeEventListener(mNinjaLuckyListener);
        }
    }
}
