package com.gutotech.narutogame.ui.home.recuperarsenha;

import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.ui.ResultListener;

public class RecuperarSenhaViewModel extends ViewModel {
    public String emailAddress = "";

    public AuthRepository mAuthRepository;
    private ResultListener mAuthListener;

    public RecuperarSenhaViewModel() {
        mAuthRepository = AuthRepository.getInstance();
    }

    public void setAuthListener(ResultListener mAuthListener) {
        this.mAuthListener = mAuthListener;
    }

    public void onRecoverPasswordButtonPressed() {
        mAuthRepository.sendPasswordResetEmail(emailAddress, mAuthListener);
    }
}
