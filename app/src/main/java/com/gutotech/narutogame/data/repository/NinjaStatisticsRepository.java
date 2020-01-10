package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.NinjaStatistics;

import java.util.ArrayList;
import java.util.List;

public class NinjaStatisticsRepository {
    private DatabaseReference ninjaStatisticsRef;
    private ValueEventListener valueEventListener;

    private List<NinjaStatistics> ninjaStatisticsList;

    public NinjaStatisticsRepository() {
        ninjaStatisticsRef = FirebaseConfig.getDatabase().child("ninja-statistics");
        ninjaStatisticsList = new ArrayList<>();
    }

    public void getAllNinjaStatistics(CallBack callBack) {
        valueEventListener = ninjaStatisticsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ninjaStatisticsList.clear();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    NinjaStatistics ninjaStatistics = data.getValue(NinjaStatistics.class);
                    ninjaStatisticsList.add(ninjaStatistics);
                }

                callBack.onNinjaStatisticsReceived(ninjaStatisticsList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public interface CallBack {
        void onNinjaStatisticsReceived(List<NinjaStatistics> ninjaStatisticsList);
    }
}
