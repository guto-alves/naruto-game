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
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.utils.DateCustom;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CharacterRepository {
    private static CharacterRepository sInstance;

    private ValueEventListener valueEventListenerPersonagens;

    private CharacterRepository() {
    }

    public static CharacterRepository getInstance() {
        if (sInstance == null)
            sInstance = new CharacterRepository();
        return sInstance;
    }

    public void saveCharacter(Character character) {
        DatabaseReference characterRef = FirebaseConfig.getDatabase()
                .child("characters")
                .child(character.getNick());

        characterRef.setValue(character);
    }

    public void deleteCharacter(String nick) {
        DatabaseReference characterRef = FirebaseConfig.getDatabase()
                .child("characters")
                .child(nick);

        characterRef.removeValue();
    }

    public boolean checkByRepeatedNick(String nick) {
        DatabaseReference characterRef = FirebaseConfig.getDatabase()
                .child("characters")
                .child(nick);

        return true;
    }

    public void observeCharOn() {
        DatabaseReference characterRef = FirebaseConfig.getDatabase()
                .child("characters")
                .child(CharOn.character.getNick());

        characterRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public LiveData<List<Character>> getMyCharacters() {
        MutableLiveData<List<Character>> data = new MutableLiveData<>();

        List<Character> characterList = new ArrayList<>();

        Query personagensQuery = FirebaseConfig.getDatabase()
                .child("characters").orderByChild("playerId")
                .equalTo(AuthRepository.getInstance().getUid());

        valueEventListenerPersonagens = personagensQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                characterList.clear();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Character character = data.getValue(Character.class);
                    characterList.add(character);
                }

                data.postValue(characterList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        return data;
    }

    public void singOut() {
        CharOn.character.setOnline(false);
        CharOn.character.setLastLogin(String.format(Locale.getDefault(),
                "%s às %s", DateCustom.getDate(), DateCustom.getTime()));
        CharacterRepository.getInstance().saveCharacter(CharOn.character);
    }

    private void classificarPersonagensPorLvl(List<Character> personagensList) {
        final int QTD_PERSONAGENS = personagensList.size();

        for (int i = 0; i < QTD_PERSONAGENS - 1; i++) {
            for (int j = i + 1; j < QTD_PERSONAGENS; j++) {
                if (personagensList.get(i).getLevel() < personagensList.get(j).getLevel()) {
                    Character temp_character = personagensList.get(i);
                    personagensList.set(i, personagensList.get(j));
                    personagensList.set(j, temp_character);
                }
            }
        }
    }
}
