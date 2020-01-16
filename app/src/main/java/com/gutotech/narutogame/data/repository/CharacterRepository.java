package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepository {
    private static CharacterRepository instance;

    private ValueEventListener valueEventListenerPersonagens;

    private CharacterRepository() {
    }

    public static CharacterRepository getInstance() {
        if (instance == null)
            instance = new CharacterRepository();
        return instance;
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

    public void getAllMyCharacters(AllMyCharactersListener listener) {
        List<Character> characterList = new ArrayList<>();
        Query personagensQuery = FirebaseConfig.getDatabase()
                .child("characters");

        valueEventListenerPersonagens = personagensQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                characterList.clear();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Character character = data.getValue(Character.class);
                    characterList.add(character);
                }

//                personagensQuery.removeEventListener(valueEventListenerPersonagens);

                listener.onResult(characterList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
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

    public interface AllMyCharactersListener {
        void onResult(List<Character> characterList);
    }
}
