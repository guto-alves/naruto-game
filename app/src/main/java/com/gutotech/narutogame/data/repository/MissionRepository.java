package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.TimeMission;

public class MissionRepository {
    private static final MissionRepository ourInstance = new MissionRepository();

    public static MissionRepository getInstance() {
        return ourInstance;
    }

    private MissionRepository() {
    }

    public void acceptTimeMission(TimeMission timeMission) {
        DatabaseReference missionReference = FirebaseConfig.getDatabase()
                .child("missions")
                .child(CharOn.character.getNick())
                .child("time-mission");

        missionReference.setValue(timeMission);
    }

    public void getMissionTime(Callback<TimeMission> callback) {
        DatabaseReference missionReference = FirebaseConfig.getDatabase()
                .child("missions")
                .child(CharOn.character.getNick())
                .child("time-mission");

        missionReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                callback.call(dataSnapshot.getValue(TimeMission.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void finishTimeMission() {
        DatabaseReference missionReference = FirebaseConfig.getDatabase()
                .child("missions")
                .child(CharOn.character.getNick())
                .child("time-mission");

        missionReference.removeValue();
    }

}
