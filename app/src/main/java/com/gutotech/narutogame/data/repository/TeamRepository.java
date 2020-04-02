package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Query;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Member;
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

    // Team
    public void save(Team team) {
        DatabaseReference teamReference = FirebaseConfig.getDatabase()
                .child("teams")
                .child(team.getName());

        teamReference.setValue(team);
    }

    public void remove(String teamName) {
        DatabaseReference teamReference = FirebaseConfig.getDatabase()
                .child("teams")
                .child(teamName);

        teamReference.removeValue();
    }

    public void getTeam(String teamName, Callback<Team> callback) {
        DatabaseReference teamReference = FirebaseConfig.getDatabase()
                .child("teams")
                .child(teamName);

        teamReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Team team = dataSnapshot.getValue(Team.class);

                if (team == null) {
                    return;
                }

                callback.call(team);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void filterTeams(String teamName, int villageId, Callback<List<Team>> callback) {
        DatabaseReference teamReference = FirebaseConfig.getDatabase()
                .child("teams");

        Query query = teamReference.orderByChild("name").startAt(teamName)
                .endAt(teamName + "\uf8ff");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Team> teams = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Team team = snapshot.getValue(Team.class);

                    if (villageId == -1) {
                        teams.add(team);
                    } else if (team != null && team.getVillageId() == villageId) {
                        teams.add(team);
                    }
                }

                callback.call(teams);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void incrementTeamExp(String teamName, int expEarned) {
        DatabaseReference teamReference = FirebaseConfig.getDatabase()
                .child("teams")
                .child(teamName);

        teamReference.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                Team team = mutableData.getValue(Team.class);

                if (team == null) {
                    return Transaction.success(mutableData);
                }

                team.incrementExp(expEarned);
                mutableData.setValue(team);

                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b,
                                   @Nullable DataSnapshot dataSnapshot) {
            }
        });
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

    public void getLeaderName(String leaderId, Callback<String> callback) {
        DatabaseReference leaderNameReference = FirebaseConfig.getDatabase()
                .child("characters")
                .child(leaderId)
                .child("nick");

        leaderNameReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                callback.call(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private DatabaseReference mCharTeamReference;
    private ValueEventListener mCharTeamEventListener;

    public void registerMyTeamChangeListener() {
        mCharTeamReference = FirebaseConfig.getDatabase()
                .child("characters")
                .child(CharOn.character.getId())
                .child("team");

        mCharTeamEventListener = mCharTeamReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String teamName = dataSnapshot.getValue(String.class);

                if (teamName == null) {
                    return;
                }

                if (!teamName.equals(CharOn.character.getTeam())) {
                    CharOn.character.setTeam(teamName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void removeMyTeamChangeListener() {
        if (mCharTeamEventListener != null) {
            mCharTeamReference.removeEventListener(mCharTeamEventListener);
            mCharTeamEventListener = null;
        }
    }


    // Members
    public void saveMember(Member member, String teamName) {
        DatabaseReference memberReference = FirebaseConfig.getDatabase()
                .child("teams-members")
                .child(teamName)
                .child(member.getMemberId());

        memberReference.setValue(member);
    }

    public void removeMember(String memberId, String teamName) {
        DatabaseReference memberReference = FirebaseConfig.getDatabase()
                .child("teams-members")
                .child(teamName)
                .child(memberId);

        memberReference.removeValue();
    }

    public void getMember(String memberId, String teamName, Callback<Member> callback) {
        DatabaseReference memberReference = FirebaseConfig.getDatabase()
                .child("teams-members")
                .child(teamName)
                .child(memberId);

        memberReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                callback.call(dataSnapshot.getValue(Member.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void getMembers(String teamName, Callback<List<Member>> callback) {
        DatabaseReference membersReference = FirebaseConfig.getDatabase()
                .child("teams-members")
                .child(teamName);

        List<Member> members = new ArrayList<>();

        membersReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                members.clear();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    members.add(data.getValue(Member.class));
                }

                callback.call(members);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void getMemberChar(String memberId, Callback<Character> callback) {
        CharacterRepository.getInstance().getChar(memberId, callback);
    }

    public void notifyMember(String memberId, String newTeamName) {
        DatabaseReference charReference = FirebaseConfig.getDatabase()
                .child("characters")
                .child(memberId)
                .child("team");

        charReference.setValue(newTeamName);
    }


    // Requesters
    public void saveRequester(String requesterId, String teamName) {
        DatabaseReference memberReference = FirebaseConfig.getDatabase()
                .child("teams-requesters")
                .child(teamName)
                .child(requesterId);

        memberReference.setValue(true);
    }

    public void removeRequester(String requesterId, String teamName) {
        DatabaseReference memberReference = FirebaseConfig.getDatabase()
                .child("teams-requesters")
                .child(teamName)
                .child(requesterId);

        memberReference.removeValue();
    }

    public void removeAllRequests(String requesterId) {
        DatabaseReference requestsReference = FirebaseConfig.getDatabase()
                .child("teams-requesters");

        Query query = requestsReference.orderByChild(requesterId);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String key = snapshot.getKey();
                    removeRequester(requesterId, key);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void requested(String requesterId, String teamName, Callback<Boolean> callback) {
        DatabaseReference requestersReference = FirebaseConfig.getDatabase()
                .child("teams-requesters")
                .child(teamName)
                .child(requesterId);

        requestersReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                callback.call(dataSnapshot.exists());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void onRequestersChangeListener(String teamName, Callback<List<String>> callback) {
        DatabaseReference requestersReference = FirebaseConfig.getDatabase()
                .child("teams-requesters")
                .child(teamName);

        List<String> requesters = new ArrayList<>();

        requestersReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String requesterId = dataSnapshot.getKey();

                if (requesterId == null) {
                    return;
                }

                requesters.add(requesterId);
                callback.call(requesters);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                String requesterId = dataSnapshot.getKey();

                if (requesterId == null) {
                    return;
                }

                requesters.remove(requesterId);
                callback.call(requesters);
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

}
