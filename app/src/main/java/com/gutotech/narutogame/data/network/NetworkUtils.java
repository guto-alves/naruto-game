package com.gutotech.narutogame.data.network;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.repository.Callback;

public class NetworkUtils {
    private static final NetworkUtils sInstance = new NetworkUtils();

    private NetworkUtils() {
    }

    public static NetworkUtils getInstance() {
        return sInstance;
    }

    public static boolean CONNECTED = false;
    private DatabaseReference mConnectedRef;
    private ValueEventListener mConnectedEventListener;

    public void addListener(Callback<Boolean> callback) {
        removeListener();
        mConnectedRef = FirebaseDatabase.getInstance().getReference(".info/connected");
        mConnectedEventListener = mConnectedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                CONNECTED = snapshot.getValue(Boolean.class);
                if (callback != null) {
                    callback.call(CONNECTED);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void removeListener() {
        if (mConnectedEventListener != null) {
            mConnectedRef.removeEventListener(mConnectedEventListener);
            mConnectedEventListener = null;
        }
    }
}
