package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;

import java.util.HashMap;
import java.util.Map;

public class DojoWaitingRoomRepository {
    private static final DojoWaitingRoomRepository ourInstance = new DojoWaitingRoomRepository();
    private Character mOpponent;
    private DatabaseReference mBattleIdReference;
    private ValueEventListener mEventListener;

    private DojoWaitingRoomRepository() {
    }

    public static DojoWaitingRoomRepository getInstance() {
        return ourInstance;
    }

    public void isWaitingRoom(Callback<Boolean> callback) {
        DatabaseReference waitQueueReference = FirebaseConfig.getDatabase()
                .child("dojo-waiting-room")
                .child(CharOn.character.getId());

        waitQueueReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                callback.call(dataSnapshot.exists());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void findOpponent(Callback<Character> callback) {
        mOpponent = null;

        DatabaseReference waitingRoomReference = FirebaseConfig.getDatabase()
                .child("dojo-waiting-room");

        waitingRoomReference.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                Map<String, Character> waitingRoom = new HashMap<>();

                for (MutableData data : mutableData.getChildren()) {
                    waitingRoom.put(data.getKey(), data.getValue(Character.class));
                }

                for (String key : waitingRoom.keySet()) {
                    Character character = waitingRoom.get(key);
                    if (Math.abs(character.getLevel() - CharOn.character.getLevel()) <= 1 &&
                            !character.getPlayerId().equals(CharOn.character.getPlayerId())) {
                        mOpponent = character;
                        break;
                    }
                }

                if (mOpponent != null) {
                    waitingRoom.remove(mOpponent.getId());
                } else {
                    waitingRoom.put(CharOn.character.getId(), CharOn.character);
                }

                mutableData.setValue(waitingRoom);

                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                callback.call(mOpponent);
            }
        });
    }

    public void getOut() {
        DatabaseReference waitingRoomReference = FirebaseConfig.getDatabase()
                .child("dojo-waiting-room")
                .child(CharOn.character.getId());

        waitingRoomReference.removeValue();
    }

    public MutableLiveData<Long> getTotalPlayersInQueue() {
        MutableLiveData<Long> totalPlayers = new MutableLiveData<>(0L);

        FirebaseConfig.getDatabase()
                .child("dojo-waiting-room")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        totalPlayers.setValue(dataSnapshot.getChildrenCount());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });

        return totalPlayers;
    }

    public void saveBattleIdForListeners(String battleId, String playerId, String oppId) {
        DatabaseReference databaseReference = FirebaseConfig.getDatabase()
                .child("dojo-pvp-battles-id");

        Map<String, Object> map = new HashMap<>();
        map.put(playerId, battleId);
        map.put(oppId, battleId);
        databaseReference.updateChildren(map);
    }

    public void removeBattleId() {
        DatabaseReference battleIdReference = FirebaseConfig.getDatabase()
                .child("dojo-pvp-battles-id")
                .child(CharOn.character.getId());

        battleIdReference.removeValue();
    }

    public void addListener(Callback<String> callback) {
        removeListener();

        mBattleIdReference = FirebaseConfig.getDatabase()
                .child("dojo-pvp-battles-id")
                .child(CharOn.character.getId());

        mEventListener = mBattleIdReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    callback.call(dataSnapshot.getValue(String.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void removeListener() {
        if (mEventListener != null) {
            mBattleIdReference.removeEventListener(mEventListener);
            mEventListener = null;
        }
    }

}
