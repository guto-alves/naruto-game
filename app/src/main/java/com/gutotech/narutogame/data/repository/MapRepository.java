package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.PersonagemOn;

import java.util.ArrayList;
import java.util.List;

public class MapRepository {
    private static MapRepository sInstance;

    private MapRepository() {
    }

    public static MapRepository getInstance() {
        if (sInstance == null) {
            sInstance = new MapRepository();
        }
        return sInstance;
    }

    private ChildEventListener childEventListenerMapa;

    public void enterTheMap(String villageName) {
        DatabaseReference mapReference = FirebaseConfig.getDatabase()
                .child("village-map")
                .child(villageName)
                .child(PersonagemOn.character.getNick());

        mapReference.setValue(PersonagemOn.character);
    }

    public void exitVillageMap(String villageName) {
        DatabaseReference mapReference = FirebaseConfig.getDatabase()
                .child("village-map")
                .child(villageName)
                .child(PersonagemOn.character.getNick());

        mapReference.removeValue();
    }

    private ValueEventListener valueEventListenerMapa;

    public LiveData<List<Character>> loadCharactersOnTheMap(String villageName) {
        MutableLiveData<List<Character>> data = new MutableLiveData<>();

        List<Character> personagensNoMapa = new ArrayList<>();

        DatabaseReference mapReference = FirebaseConfig.getDatabase()
                .child("village-map").child(villageName);

        valueEventListenerMapa = mapReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                personagensNoMapa.clear();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Character character = data.getValue(Character.class);
                    personagensNoMapa.add(character);
                }

                data.postValue(personagensNoMapa);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        return data;
    }

    private void atualizar(String villageName) {
        DatabaseReference mapReference = FirebaseConfig.getDatabase()
                .child("village-map").child(villageName);

        childEventListenerMapa = mapReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

//                Character character = dataSnapshot.getValue(Character.class);
//                for (int i = 0; i < personagensNoMapa.size(); i++) {
//                    if (character.getNick().equals(personagensNoMapa.get(i).getNick())) {
//                        personagensNoMapa.remove(i);
//                        personagensNoMapa.add(i, character);
//                        mapaAdapter.notifyDataSetChanged();
//
//                        break;
//                    }
//                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void close(){

    }
}
