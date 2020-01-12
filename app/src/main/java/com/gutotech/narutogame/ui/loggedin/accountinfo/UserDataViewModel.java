package com.gutotech.narutogame.ui.loggedin.accountinfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.Player;
import com.gutotech.narutogame.data.repository.PlayerRepository;

public class UserDataViewModel extends ViewModel {
    private MutableLiveData<Player> player;

    private PlayerRepository mRepository;

    public UserDataViewModel() {
        player = new MutableLiveData<>();

        mRepository = PlayerRepository.getInstance();
        mRepository.getCurrentPlayer(player -> {
            this.player.setValue(player);
        });
    }

    public LiveData<Player> getPlayer() {
        return player;
    }

    public void submitChanges() {
        if (validatePlayer()) {
            mRepository.insertPlayer(player.getValue());

//            StorageUtil.downloadProfileForMsg(getActivity(), personagemMsg2);
//            mgsSucessoConstraintLayout.setVisibility(View.VISIBLE);
        }
    }

    private boolean validatePlayer() {
        if (player.getValue().getName().isEmpty())
            return false;

        if (player.getValue().getDateOfBirth().isEmpty())
            return false;

        return true;
    }
}
