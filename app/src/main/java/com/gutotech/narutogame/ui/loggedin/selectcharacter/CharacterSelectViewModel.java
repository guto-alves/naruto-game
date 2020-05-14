package com.gutotech.narutogame.ui.loggedin.selectcharacter;

import android.content.DialogInterface;
import android.text.TextUtils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Mission;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.data.repository.MissionRepository;
import com.gutotech.narutogame.data.repository.NinjaLuckyRepository;
import com.gutotech.narutogame.data.repository.NinjaStatisticsRepository;
import com.gutotech.narutogame.data.repository.PlayerRepository;
import com.gutotech.narutogame.data.repository.TeamRepository;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.List;

public class CharacterSelectViewModel extends ViewModel {
    private CharacterRepository mCharRepository;
    private MutableLiveData<List<Character>> mCharacters = new MutableLiveData<>();

    private ResultListener mListener;

    private SingleLiveEvent<DialogInterface.OnClickListener> mShowQuestionDialogEvent =
            new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> mShowErrorDialogEvent = new SingleLiveEvent<>();

    public CharacterSelectViewModel() {
        mCharRepository = CharacterRepository.getInstance();
        getCharacters();
    }

    public synchronized void onPlayButtonPressed(Character character) {
        if (character != null) {
            TeamRepository.getInstance().removeMyTeamChangeListener();
            CharOn.character = character;
            mListener.onSuccess();
        } else {
            mListener.onFailure(R.string.no_characters_selected);
        }
    }

    public void onRemoveCharacterButtonPressed(Character character) {
        if (character == null) {
            mListener.onFailure(R.string.no_characters_selected);
            return;
        }

        if (!TextUtils.isEmpty(character.getTeam())) {
            mShowErrorDialogEvent.setValue(R.string.error_remove_character_member_of_a_team);
            return;
        }

        mShowQuestionDialogEvent.setValue((dialog, which) -> {
            if (character.equals(CharOn.character)) {
                mShowErrorDialogEvent.setValue(R.string.remove_character_while_logged_in);
            } else {
                deleteCharacterSelected(character);
            }
        });
    }

    private void deleteCharacterSelected(Character character) {
        mCharRepository.remove(character.getId());
        getCharacters();
        NinjaLuckyRepository.getInstance().delete(character.getId());
        NinjaStatisticsRepository.getInstance().remove(character.getNinja().getId());
        MissionRepository.getInstance().finishMission(Mission.Type.SPECIAL, character.getId());
        MissionRepository.getInstance().finishMission(Mission.Type.TIME, character.getId());
        PlayerRepository.getInstance().setTotalCharacters(false);
    }

    private void getCharacters() {
        mCharRepository.getAllCharacters(AuthRepository.getInstance().getUid(),
                mCharacters::setValue);
    }

    public void setListener(ResultListener listener) {
        mListener = listener;
    }

    LiveData<List<Character>> getCharactersList() {
        return mCharacters;
    }


    LiveData<DialogInterface.OnClickListener> getShowQuestionDialogEvent() {
        return mShowQuestionDialogEvent;
    }

    LiveData<Integer> getShowErrorDialogEvent() {
        return mShowErrorDialogEvent;
    }
}
