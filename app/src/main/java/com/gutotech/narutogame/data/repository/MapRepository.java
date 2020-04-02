package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.CharOn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapRepository {
    private static MapRepository sInstance = new MapRepository();

    private MapRepository() {
    }

    public static MapRepository getInstance() {
        return sInstance;
    }

    public void enter(int villageId) {
        DatabaseReference mapReference = FirebaseConfig.getDatabase()
                .child("village-map")
                .child(String.valueOf(villageId))
                .child(CharOn.character.getId());

        mapReference.setValue(CharOn.character);
    }

    public void exit(int villageId, String charId) {
        DatabaseReference mapReference = FirebaseConfig.getDatabase()
                .child("village-map")
                .child(String.valueOf(villageId))
                .child(charId);

        mapReference.removeValue();
    }

    private DatabaseReference mMapReference;
    private ValueEventListener mMapValueEventListener;

    public LiveData<Map<Integer, List<Character>>> load(int villageId) {
        MutableLiveData<Map<Integer, List<Character>>> data = new MutableLiveData<>();

        Map<Integer, List<Character>> map = new HashMap<>();

        mMapReference = FirebaseConfig.getDatabase()
                .child("village-map")
                .child(String.valueOf(villageId));

        mMapValueEventListener = mMapReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                map.clear();

                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    Character newCharacter = snap.getValue(Character.class);

                    if (map.get(newCharacter.getMapPosition()) != null) {
                        map.get(newCharacter.getMapPosition()).add(newCharacter);
                    } else {
                        List<Character> characterList = new ArrayList<>();
                        characterList.add(newCharacter);
                        map.put(newCharacter.getMapPosition(), characterList);
                    }
                }

                data.postValue(map);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        return data;
    }

    public void close() {
        if (mMapValueEventListener != null) {
            mMapReference.removeEventListener(mMapValueEventListener);
            mMapValueEventListener = null;
        }
    }
}
