package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamRepository {
    private static final TeamRepository ourInstance = new TeamRepository();

    public static TeamRepository getInstance() {
        return ourInstance;
    }

    private TeamRepository() {
    }

    public String generateId() {
        return FirebaseConfig.getDatabase().child("teams").push().getKey();
    }

    public void save(Team team) {
        DatabaseReference teamReference = FirebaseConfig.getDatabase()
                .child("teams")
                .child(String.valueOf(team.getVillageId()))
                .child(team.getId());

        teamReference.setValue(team);
    }

    public void remove(Team team) {
        DatabaseReference teamReference = FirebaseConfig.getDatabase()
                .child("teams")
                .child(String.valueOf(team.getVillageId()))
                .child(team.getId());

        teamReference.removeValue();
    }

    public void leaveTeam(String memberId) {
        DatabaseReference teamReference = FirebaseConfig.getDatabase()
                .child("characters")
                .child(memberId)
                .child("team");

        teamReference.setValue("");
    }

    public void getTeam(String teamName, Callback<Team> callback) {
        DatabaseReference teamReference = FirebaseConfig.getDatabase()
                .child("teams")
                .child(String.valueOf(CharOn.character.getVillage().ordinal()));

        Query query = teamReference.orderByChild("name").equalTo(teamName);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    callback.call(snap.getValue(Team.class));
                    break;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void filterTeams(String teamName, int villageId, Callback<List<Team>> callback) {
        DatabaseReference teamReference = FirebaseConfig.getDatabase()
                .child("teams")
                .child(String.valueOf(villageId));

        Query query = teamReference.orderByChild("name").startAt(teamName)
                .endAt(teamName + "\uf8ff");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Team> teams = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    teams.add(snapshot.getValue(Team.class));
                }

                callback.call(teams);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void getMember(String memberId, Callback<Character> callback) {
        CharacterRepository.getInstance().getChar(memberId, callback);
    }

    public void isValidName(String teamName, Callback<Boolean> callback) {
        DatabaseReference teamReference = FirebaseConfig.getDatabase()
                .child("teams");

        Query query = teamReference.orderByChild("name").equalTo(teamName);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                callback.call(dataSnapshot.getChildrenCount() == 0);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

}
