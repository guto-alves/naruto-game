package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.NinjaLucky;

public class NinjaLuckyRepository {
    private static NinjaLuckyRepository sInstance;

    private NinjaLuckyRepository() {
    }

    public static NinjaLuckyRepository getInstance() {
        if (sInstance == null) {
            sInstance = new NinjaLuckyRepository();
        }
        return sInstance;
    }


    public void save(NinjaLucky ninjaLucky, String charNick) {
        DatabaseReference ninjaLuckyRef = FirebaseConfig.getDatabase()
                .child("ninja-lucky")
                .child(charNick);

        ninjaLuckyRef.setValue(ninjaLucky);
    }

    public void delete(String charNick) {
        DatabaseReference ninjaLuckyRef = FirebaseConfig.getDatabase()
                .child("ninja-lucky")
                .child(charNick);

        ninjaLuckyRef.removeValue();
    }

    private DatabaseReference ninjaLuckyRef;
    private ValueEventListener ninjaLuckyListener;

    public void get(String charNick, Listener<NinjaLucky> listener) {
        MutableLiveData k;

        ninjaLuckyRef = FirebaseConfig.getDatabase()
                .child("ninja-lucky")
                .child(charNick);

        ninjaLuckyListener = ninjaLuckyRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                NinjaLucky ninjaLucky = dataSnapshot.getValue(NinjaLucky.class);
                listener.onDataChange(ninjaLucky);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void removeEventListener() {
        if (ninjaLuckyListener != null) {
            ninjaLuckyRef.removeEventListener(ninjaLuckyListener);
        }
    }

    public interface Listener<T> {
        void onDataChange(T data);
    }
}
