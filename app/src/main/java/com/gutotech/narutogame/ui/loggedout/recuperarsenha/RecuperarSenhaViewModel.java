package com.gutotech.narutogame.ui.loggedout.recuperarsenha;

import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.ui.loggedout.AuthListener;

public class RecuperarSenhaViewModel extends ViewModel {
    public String emailAddress = "";

    public AuthRepository mAuthRepository;
    private AuthListener mAuthListener;

    public RecuperarSenhaViewModel() {
        mAuthRepository = AuthRepository.getInstance();
    }

    public void setAuthListener(AuthListener mAuthListener) {
        this.mAuthListener = mAuthListener;
    }

    public void recoverPassword() {
        mAuthRepository.recoverPassword(emailAddress, mAuthListener);
    }
}
