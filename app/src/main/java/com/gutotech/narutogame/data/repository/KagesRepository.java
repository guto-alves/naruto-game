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
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class KagesRepository {
    private static KagesRepository sInstance = new KagesRepository();

    public static KagesRepository getInstance() {
        return sInstance;
    }

    private KagesRepository() {
    }

    public LiveData<List<Character>> getKages() {
        MutableLiveData<List<Character>> data = new MutableLiveData<>();
        List<Character> kages = new ArrayList<>();

        for (Village village : EnumSet.range(Village.FOLHA, Village.CHUVA)) {
            getKage(village, kage -> {
                if (kage != null) {
                    kages.add(kage);
                    sortByVillage(kages);
                    data.postValue(kages);
                }
            });
        }

        return data;
    }

    private void getKage(Village village, Callback<Character> callback) {
        DatabaseReference charactersRef = FirebaseConfig.getDatabase()
                .child("characters");

        Query query = charactersRef.orderByChild("village").equalTo(village.name());

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    List<Character> characters = new ArrayList<>();

                    for (DataSnapshot snap : dataSnapshot.getChildren()) {
                        Character character = snap.getValue(Character.class);

                        if (character == null) {
                            continue;
                        }

                        if (character.getGraduationId() > 0) {
                            characters.add(snap.getValue(Character.class));
                        }
                    }

                    if (characters.size() > 0) {
                        sortByLevel(characters);
                        callback.call(characters.get(0));
                        return;
                    }
                }

                callback.call(null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void sortByLevel(List<Character> characterList) {
        Collections.sort(characterList, (char1, char2) -> {
            if (char1.getLevel() == char2.getLevel()) {
                return 0;
            }

            return char1.getLevel() > char2.getLevel() ? -1 : 1;
        });
    }

    private void sortByVillage(List<Character> charactersList) {
        Collections.sort(charactersList, (char1, char2) -> {
            if (char1.getVillage().ordinal() == char2.getVillage().ordinal()) {
                return 0;
            }

            return char1.getVillage().ordinal() > char2.getVillage().ordinal() ? 1 : -1;
        });
    }
}
