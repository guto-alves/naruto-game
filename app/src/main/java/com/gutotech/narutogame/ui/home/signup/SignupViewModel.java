package com.gutotech.narutogame.ui.home.signup;

import android.text.TextUtils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Player;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.PlayerRepository;
import com.gutotech.narutogame.ui.ResultListener;

public class SignupViewModel extends ViewModel {
    private MutableLiveData<Player> player;
    public String confirmPassword;

    private AuthRepository mAuthRepository;
    private ResultListener mAuthListener;

    public SignupViewModel() {
        player = new MutableLiveData<>(new Player());

        mAuthRepository = AuthRepository.getInstance();
    }

    public LiveData<Player> getPlayer() {
        return player;
    }

    public void setAuthListener(ResultListener authListener) {
        mAuthListener = authListener;
    }

    public void onSignupButtonPressed() {
        mAuthListener.onStarted();

        if (isValidPlayer()) {
            mAuthRepository.registerPlayer(
                    player.getValue().getName(),
                    player.getValue().getEmail(),
                    player.getValue().getPassword(),
                    new AuthRepository.Completable() {
                        @Override
                        public void onComplete() {
                            player.getValue().setId(mAuthRepository.getUid());
                            player.getValue().setVipCredits(20);

                            PlayerRepository.getInstance().savePlayer(player.getValue());

                            player.setValue(new Player());
                            confirmPassword = "";

                            mAuthRepository.signOut();
                            mAuthListener.onSuccess();
                        }

                        @Override
                        public void onError(int resId) {
                            mAuthListener.onFailure(resId);
                        }
                    }
            );
        }
    }

    private boolean isValidPlayer() {
        boolean valid = true;

        if (TextUtils.isEmpty(player.getValue().getName())) {
            mAuthListener.onFailure(R.string.name_field_requered);
            valid = false;
        } else if (TextUtils.isEmpty(player.getValue().getEmail())) {
            mAuthListener.onFailure(R.string.email_field_requered);
            valid = false;
        } else if (TextUtils.isEmpty(player.getValue().getPassword())) {
            mAuthListener.onFailure(R.string.password_field_requered);
            valid = false;
        } else if (TextUtils.isEmpty(confirmPassword)) {
            mAuthListener.onFailure(R.string.the_passwords_do_not_match);
            valid = false;
        } else if (!player.getValue().getPassword().equals(confirmPassword)) {
            mAuthListener.onFailure(R.string.different_passwords);
            valid = false;
        }

        return valid;
    }
}
