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
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Mission;
import com.gutotech.narutogame.data.model.SpecialMission;
import com.gutotech.narutogame.data.model.TimeMission;

public class MissionRepository {
    private static final MissionRepository ourInstance = new MissionRepository();

    public static MissionRepository getInstance() {
        return ourInstance;
    }

    private MissionRepository() {
    }

    public void acceptMission(Mission mission, Mission.Type type) {
        DatabaseReference missionReference = FirebaseConfig.getDatabase()
                .child("missions")
                .child(CharOn.character.getId())
                .child(type == Mission.Type.TIME ? "time-mission" : "special-mission");

        missionReference.setValue(mission);
    }

    public void getMission(Mission.Type type, Callback<Mission> callback) {
        DatabaseReference missionReference = FirebaseConfig.getDatabase()
                .child("missions")
                .child(CharOn.character.getId())
                .child(type == Mission.Type.TIME ? "time-mission" : "special-mission");

        missionReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (type == Mission.Type.TIME) {
                    callback.call(dataSnapshot.getValue(TimeMission.class));
                } else {
                    callback.call(dataSnapshot.getValue(SpecialMission.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void finishMission(Mission.Type type) {
        finishMission(type, CharOn.character.getId());
    }

    public void finishMission(Mission.Type type, String charId) {
        DatabaseReference missionReference = FirebaseConfig.getDatabase()
                .child("missions")
                .child(charId)
                .child(type == Mission.Type.TIME ? "time-mission" : "special-mission");

        missionReference.removeValue();
    }

    public void increaseDefeated() {
        DatabaseReference missionReference = FirebaseConfig.getDatabase()
                .child("missions")
                .child(CharOn.character.getId())
                .child("special-mission");

        missionReference.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                SpecialMission specialMission = mutableData.getValue(SpecialMission.class);

                if (specialMission == null) {
                    return Transaction.success(mutableData);
                }

                if (specialMission.getDefeated() < specialMission.getDefeat()) {
                    specialMission.setDefeated(specialMission.getDefeated() + 1);
                }

                mutableData.setValue(specialMission);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b,
                                   @Nullable DataSnapshot dataSnapshot) {
            }
        });
    }

}
