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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharacterRepository {
    private static CharacterRepository sInstance = new CharacterRepository();

    private CharacterRepository() {
    }

    public static CharacterRepository getInstance() {
        return sInstance;
    }

    public void save(Character character) {
        DatabaseReference characterRef = FirebaseConfig.getDatabase()
                .child("characters")
                .child(character.getNick());

        characterRef.setValue(character);
    }

    public void delete(String nick) {
        DatabaseReference characterRef = FirebaseConfig.getDatabase()
                .child("characters")
                .child(nick);

        characterRef.removeValue();
    }

    public void getChar(String nick, Callback<Character> callback) {
        DatabaseReference reference = FirebaseConfig.getDatabase()
                .child("characters")
                .child(nick);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                callback.call(dataSnapshot.getValue(Character.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void checkByRepeatedNick(String nick, Callback<Boolean> callback) {
        DatabaseReference charactersRef = FirebaseConfig.getDatabase()
                .child("characters");

        Query query = charactersRef.orderByKey().equalTo(nick);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getChildrenCount() == 0) {
                    callback.call(true);
                } else {
                    callback.call(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public LiveData<List<Character>> getMyCharacters() {
        MutableLiveData<List<Character>> data = new MutableLiveData<>();

        Query personagensQuery = FirebaseConfig.getDatabase()
                .child("characters").orderByChild("playerId")
                .equalTo(AuthRepository.getInstance().getUid());

        personagensQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Character> characterList = new ArrayList<>();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Character character = data.getValue(Character.class);
                    characterList.add(character);
                }

                sortCharsByLevel(characterList);

                data.postValue(characterList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        return data;
    }

    private void sortCharsByLevel(List<Character> characterList) {
        Collections.sort(characterList, (char1, char2) -> {
            if (char1.getLevel() == char2.getLevel()) {
                return 0;
            }

            return char1.getLevel() > char2.getLevel() ? 1 : -1;
        });
    }
}
