package com.gutotech.narutogame.ui.loggedin.selectcharacter;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.PersonagemOn;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.ui.adapter.CharacterSelectRecyclerViewAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.List;

public class CharacterSelectViewModel extends AndroidViewModel implements CharacterSelectRecyclerViewAdapter.CharacterSelecetedListener {
    private MutableLiveData<List<Character>> mCharactersList;
    private MutableLiveData<Character> mCharacterSelected;

    private CharacterRepository mRepository;

    private ResultListener mListener;

    private SingleLiveEvent<String> event = new SingleLiveEvent<>();

    public MutableLiveData<String> nick = new MutableLiveData<>();
    public MutableLiveData<String> level = new MutableLiveData<>();
    public MutableLiveData<String> grade = new MutableLiveData<>();
    public MutableLiveData<String> ryous = new MutableLiveData<>();
    public MutableLiveData<String> village = new MutableLiveData<>();


    public CharacterSelectViewModel(@NonNull Application application) {
        super(application);

        mCharactersList = new MutableLiveData<>();

        mCharacterSelected = new MutableLiveData<>();

        mRepository = CharacterRepository.getInstance();
        mRepository.getAllMyCharacters(characterList -> {
            mCharactersList.setValue(characterList);

            if (characterList.size() != 0) {
                mCharacterSelected.setValue(characterList.get(0));
            }
        });
    }

    public LiveData<List<Character>> getCharactersList() {
        return mCharactersList;
    }

    public LiveData<Character> getCharacterSelected() {
        return mCharacterSelected;
    }


    public LiveData<String> getEvent() {
        return event;
    }

    public void setListener(ResultListener listener) {
        mListener = listener;
    }

    public void onPlayButtonPressed() {
        if (mCharacterSelected != null) {
            PersonagemOn.character = mCharacterSelected.getValue();
            mListener.onSuccess();
        } else {
            mListener.onFailure(R.string.no_characters_selected);
        }
    }

    public void onRemoveButtonPressed() {
        if (mCharacterSelected != null) {
            event.call();
            mRepository.deleteCharacter(mCharacterSelected.getValue().getNick());
        }
    }

    @Override
    public void onCharacterSelected(Character character) {
        mCharacterSelected.setValue(character);
    }
}
