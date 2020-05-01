package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;

import java.util.HashMap;
import java.util.Map;

public class GlobalAlertRepository {
    private static final GlobalAlertRepository sInstance = new GlobalAlertRepository();

    private GlobalAlertRepository() {
    }

    public static GlobalAlertRepository getInstance() {
        return sInstance;
    }

    public void showAlert(Map<String, String> messageMap) {
        FirebaseConfig.getDatabase()
                .child("global-alert")
                .runTransaction(new Transaction.Handler() {
                    @NonNull
                    @Override
                    public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                        Map<String, String> map = (HashMap<String, String>) mutableData.getValue();

                        if (map == null) {
                            return Transaction.success(mutableData);
                        }

                        mutableData.setValue(messageMap);
                        return Transaction.success(mutableData);
                    }

                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, boolean b,
                                           @Nullable DataSnapshot dataSnapshot) {
                    }
                });
    }

    private DatabaseReference mGlobalAlertReference;
    private ValueEventListener mGlobalAlertEventListener;

    private long mInitialTime;

    public void addListener(Callback<Map<String, String>> callback) {
        mInitialTime = System.currentTimeMillis();

        mGlobalAlertReference = FirebaseConfig.getDatabase()
                .child("global-alert");

        mGlobalAlertEventListener = mGlobalAlertReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long currentTime = System.currentTimeMillis();

                if (currentTime - mInitialTime < 20 * 1000) {
                    mInitialTime = 0;
                    return;
                }

                Map<String, String> map = (HashMap<String, String>) dataSnapshot.getValue();

                callback.call(map);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void removeListener() {
        if (mGlobalAlertEventListener != null) {
            mGlobalAlertReference.removeEventListener(mGlobalAlertEventListener);
            mGlobalAlertEventListener = null;
        }
    }
}
