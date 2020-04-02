package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;

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
import java.util.List;

public class RankNinjasRepository {
    private static final RankNinjasRepository ourInstance = new RankNinjasRepository();

    public static RankNinjasRepository getInstance() {
        return ourInstance;
    }

    private RankNinjasRepository() {
    }

    public void filter(Village village, String nick, boolean online, Callback<List<Character>> callback) {
        getByNick(nick, characters -> {
            List<Character> characterList = new ArrayList<>(characters);

            for (Character character : characters) {
                if (village != null && character.getVillage() != village) {
                    characterList.remove(character);
                } else if (online && !character.isOnline()) {
                    characterList.remove(character);
                }
            }

            sortByLevel(characterList);

            callback.call(characterList);
        });
    }

    private void getByNick(String nick, Callback<List<Character>> callback) {
        DatabaseReference databaseReference = FirebaseConfig.getDatabase()
                .child("characters");

        Query query = databaseReference.orderByChild("nick").startAt(nick).endAt(nick + "\uf8ff");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Character> characterList = new ArrayList<>();

                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    Character character = snap.getValue(Character.class);

                    if (character == null) {
                        continue;
                    }

                    if (character.getGraduationId() > 0) {
                        characterList.add(character);
                    }
                }

                callback.call(characterList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void sortByLevel(List<Character> characterList) {
        Collections.sort(characterList, (char1, char2) -> {
            if (char1.getScore() == char2.getScore()) {
                return 0;
            }

            return char1.getScore() > char2.getScore() ? -1 : 1;
        });
    }
}
