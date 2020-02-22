package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Village;

import java.util.ArrayList;
import java.util.List;

public class RankNinjasRepository {
    private static final RankNinjasRepository ourInstance = new RankNinjasRepository();

    public static RankNinjasRepository getInstance() {
        return ourInstance;
    }

    private RankNinjasRepository() {
    }

    private void getAll(String nick, Callback<List<Character>> callback) {
        DatabaseReference databaseReference = FirebaseConfig.getDatabase()
                .child("characters");

        Query query = databaseReference.orderByKey().startAt(nick).endAt(nick + "\uf8ff");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Character> characterList = new ArrayList<>();

                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    characterList.add(snap.getValue(Character.class));
                }

                callback.call(characterList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public LiveData<List<Character>> filter(Village village, String nick, boolean online) {
        MutableLiveData<List<Character>> data = new MutableLiveData<>();

        getAll(nick, characters -> {
            List<Character> characterList = new ArrayList<>();

            characterList.addAll(characters);

            for (Character character : characters) {
                if (character.getVillage() != village) {
                    characterList.remove(character);
                }

                if (online) {
                    if (character.isOnline()) {
                        characterList.remove(character);
                    }
                }
            }

            data.setValue(characterList);
        });

        return data;
    }
}
