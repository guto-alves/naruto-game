package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.NinjaStatistics;

import java.util.ArrayList;
import java.util.List;

public class NinjaStatisticsRepository {
    private static NinjaStatisticsRepository sInstance;

    private DatabaseReference ninjaStatisticsRef;
    private ValueEventListener valueEventListener;

    private NinjaStatisticsRepository() {
        ninjaStatisticsRef = FirebaseConfig.getDatabase().child("ninja-statistics");

    }

    public static NinjaStatisticsRepository getInstance() {
        if (sInstance == null) {
            sInstance = new NinjaStatisticsRepository();
        }
        return sInstance;
    }

    public void updateNinjaStatistics(NinjaStatistics ninjaStatistics) {

    }

    public LiveData<List<NinjaStatistics>> getAllNinjaStatistics() {
        MutableLiveData<List<NinjaStatistics>> data = new MutableLiveData<>();
        List<NinjaStatistics> ninjaStatisticsList = new ArrayList<>();

        valueEventListener = ninjaStatisticsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ninjaStatisticsList.clear();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    NinjaStatistics ninjaStatistics = data.getValue(NinjaStatistics.class);
                    ninjaStatisticsList.add(ninjaStatistics);
                }

                data.postValue(ninjaStatisticsList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        return data;
    }
}
