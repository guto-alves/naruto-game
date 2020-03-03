package com.gutotech.narutogame.ui.loggedin.selectcharacter;

import android.content.DialogInterface;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.data.repository.NinjaLuckyRepository;
import com.gutotech.narutogame.data.repository.NinjaStatisticsRepository;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.List;

public class CharacterSelectViewModel extends ViewModel {
    private Character mCharacterSelected;

    private CharacterRepository mRepository;

    private ResultListener mListener;

    private SingleLiveEvent<DialogInterface.OnClickListener> showQuestionDialog =
            new SingleLiveEvent<>();

    private SingleLiveEvent<Void> showErrorDialog = new SingleLiveEvent<>();

    public CharacterSelectViewModel() {
        mRepository = CharacterRepository.getInstance();
    }

    LiveData<List<Character>> getCharactersList() {
        return mRepository.getMyCharacters(AuthRepository.getInstance().getUid());
    }

    private Character getCharacterSelected() {
        return mCharacterSelected;
    }

    void setCharacterSelected(Character characterSelected) {
        this.mCharacterSelected = characterSelected;
    }

    SingleLiveEvent<DialogInterface.OnClickListener> getRemoveCharacterEvent() {
        return showQuestionDialog;
    }

    SingleLiveEvent<Void> getShowRemovingErrorDialog() {
        return showErrorDialog;
    }

    public void setListener(ResultListener listener) {
        mListener = listener;
    }

    public void onPlayButtonPressed() {
        if (mCharacterSelected != null) {
            CharOn.character = mCharacterSelected;
            mListener.onSuccess();
        } else {
            mListener.onFailure(R.string.no_characters_selected);
        }
    }

    public void onRemoveCharacterButtonPressed() {
        if (mCharacterSelected != null) {
            showQuestionDialog.setValue((dialog, which) -> {
                if (CharOn.character == null) {
                    deleteCharacterSelected();
                } else {
                    if (getCharacterSelected().getNick().equals(CharOn.character.getNick())) {
                        showErrorDialog.call();
                    } else {
                        deleteCharacterSelected();
                    }
                }
            });
        }
    }

    private void deleteCharacterSelected() {
        mRepository.delete(mCharacterSelected.getId());
        NinjaLuckyRepository.getInstance().delete(mCharacterSelected.getNick());
        NinjaStatisticsRepository.getInstance().remove(mCharacterSelected.getNinja().getId());
    }
}
