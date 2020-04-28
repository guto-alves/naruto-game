package com.gutotech.narutogame.ui.home.passwordrecovery;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.ui.ResultListener;

public class PasswordRecoveryViewModel extends ViewModel {
    public final ObservableField<String> emailAddress = new ObservableField<>("");

    private AuthRepository mAuthRepository;
    private ResultListener mAuthListener;

    public PasswordRecoveryViewModel() {
        mAuthRepository = AuthRepository.getInstance();
    }

    void setAuthListener(ResultListener authListener) {
        mAuthListener = authListener;
    }

    public void onRecoverPasswordButtonPressed() {
        if (emailAddress.get().trim().isEmpty()) {
            return;
        }

        mAuthListener.onStarted();

        mAuthRepository.sendPasswordResetEmail(emailAddress.get(), new ResultListener() {

            @Override
            public void onSuccess() {
                emailAddress.set("");
                mAuthListener.onSuccess();
            }

            @Override
            public void onFailure(int resId) {
                mAuthListener.onFailure(resId);
            }
        });
    }
}
