package com.gutotech.narutogame.ui.loggedin.selectcharacter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.PersonagemOn;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.List;

public class CharacterSelectViewModel extends ViewModel {
    private Character mCharacterSelected;

    private CharacterRepository mRepository;

    private ResultListener mListener;
    private SingleLiveEvent<String> event = new SingleLiveEvent<>();

    public CharacterSelectViewModel() {
        mCharacterSelected = new Character(AuthRepository.getInstance().getUid());

        mRepository = CharacterRepository.getInstance();
    }

    public LiveData<List<Character>> getCharactersList() {
        return mRepository.getAllMyCharacters();
    }

    public Character getCharacterSelected() {
        return mCharacterSelected;
    }

    public void setCharacterSelected(Character characterSelected) {
        this.mCharacterSelected = characterSelected;
    }

    public LiveData<String> getEvent() {
        return event;
    }

    public void setListener(ResultListener listener) {
        mListener = listener;
    }

    public void onPlayButtonPressed() {
        if (mCharacterSelected != null) {
            PersonagemOn.character = mCharacterSelected;
            mListener.onSuccess();
        } else {
            mListener.onFailure(R.string.no_characters_selected);
        }
    }

    public void onRemoveButtonPressed() {
        if (mCharacterSelected != null) {
            event.call();
            mRepository.deleteCharacter(mCharacterSelected.getNick());
        }
    }
}
