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

public class SignUpViewModel extends ViewModel {
    public String confirmPassword;
    private MutableLiveData<Player> mPlayer;

    private AuthRepository mAuthRepository;
    private ResultListener mAuthListener;

    public SignUpViewModel() {
        mPlayer = new MutableLiveData<>(new Player());
        mAuthRepository = AuthRepository.getInstance();
    }

    public LiveData<Player> getPlayer() {
        return mPlayer;
    }

    void setAuthListener(ResultListener authListener) {
        mAuthListener = authListener;
    }

    public void onSignupButtonPressed() {
        mAuthListener.onStarted();

        if (isValidPlayer()) {
            mAuthRepository.register(
                    mPlayer.getValue().getName(),
                    mPlayer.getValue().getEmail(),
                    mPlayer.getValue().getPassword(),
                    new AuthRepository.Completable() {
                        @Override
                        public void onComplete() {
                            mPlayer.getValue().setId(mAuthRepository.getUid());

                            PlayerRepository.getInstance().savePlayer(mPlayer.getValue());

                            mPlayer.setValue(new Player());
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

        if (TextUtils.isEmpty(mPlayer.getValue().getName())) {
            mAuthListener.onFailure(R.string.name_field_requered);
            valid = false;
        } else if (TextUtils.isEmpty(mPlayer.getValue().getEmail())) {
            mAuthListener.onFailure(R.string.email_field_requered);
            valid = false;
        } else if (TextUtils.isEmpty(mPlayer.getValue().getPassword())) {
            mAuthListener.onFailure(R.string.password_field_requered);
            valid = false;
        } else if (TextUtils.isEmpty(confirmPassword)) {
            mAuthListener.onFailure(R.string.the_passwords_do_not_match);
            valid = false;
        } else if (!mPlayer.getValue().getPassword().equals(confirmPassword)) {
            mAuthListener.onFailure(R.string.different_passwords);
            valid = false;
        }

        return valid;
    }
}
