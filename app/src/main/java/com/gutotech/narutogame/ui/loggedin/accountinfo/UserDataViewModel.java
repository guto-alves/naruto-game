package com.gutotech.narutogame.ui.loggedin.accountinfo;

import android.text.TextUtils;

import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Player;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.PlayerRepository;
import com.gutotech.narutogame.ui.ResultListener;

public class UserDataViewModel extends ViewModel {
    private Player mPlayer;

    private PlayerRepository mPlayerRepository;

    private ResultListener mResultListener;

    UserDataViewModel(Player player) {
        mPlayer = player;
        mPlayerRepository = PlayerRepository.getInstance();
    }

    public Player getPlayer() {
        return mPlayer;
    }

    void setResultListener(ResultListener resultListener) {
        mResultListener = resultListener;
    }

    public void onSubmitChangesButtonPressed() {
        if (validatePlayer()) {
            AuthRepository.getInstance().updateProfile(AuthRepository.getInstance().getCurrentUser(),
                    mPlayer.getName(), null, false);
            mPlayerRepository.savePlayer(mPlayer);
            mResultListener.onSuccess();
        }
    }

    private boolean validatePlayer() {
        if (TextUtils.isEmpty(mPlayer.getName())) {
            mResultListener.onFailure(R.string.name_field_requered);
            return false;
        }

        return true;
    }
}
