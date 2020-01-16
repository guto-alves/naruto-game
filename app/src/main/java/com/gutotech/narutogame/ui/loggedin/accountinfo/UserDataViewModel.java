package com.gutotech.narutogame.ui.loggedin.accountinfo;

import android.text.TextUtils;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Player;
import com.gutotech.narutogame.data.repository.PlayerRepository;
import com.gutotech.narutogame.ui.ResultListener;

public class UserDataViewModel extends ViewModel {
    private MutableLiveData<Player> player;

    private PlayerRepository mPlayerRepository;

    private ResultListener mResultListener;

    public UserDataViewModel() {
        mPlayerRepository = PlayerRepository.getInstance();

        mPlayerRepository.getCurrentPlayer(player -> {
                    this.player = new MutableLiveData<>(player);
                    Log.i("userdataviewmodel", player.getName());
                }
        );
    }

    public LiveData<Player> getPlayer() {
        return player;
    }

    public void setResultListener(ResultListener mResultListener) {
        this.mResultListener = mResultListener;
    }

    public void onSubmitChangesButtonPressed() {
        if (validatePlayer()) {
            mPlayerRepository.savePlayer(player.getValue());
            mResultListener.onSuccess();
        }
    }

    private boolean validatePlayer() {
        if (TextUtils.isEmpty(player.getValue().getName())) {
            mResultListener.onFailure(R.string.name_field_requered);
            return false;
        }

        return true;
    }
}
