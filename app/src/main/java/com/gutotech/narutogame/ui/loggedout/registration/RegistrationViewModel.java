package com.gutotech.narutogame.ui.loggedout.registration;

import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Player;
import com.gutotech.narutogame.data.repository.AuthRepository;

public class RegistrationViewModel extends ViewModel {
    private Player player;
    public String confirmaSenha;

    private RegistrationListener mRegistrationListener;

    public AuthRepository mRepository;

    public RegistrationViewModel() {
        player = new Player();
        mRepository = AuthRepository.getInstance();
    }

    public Player getPlayer() {
        return player;
    }


    public void setRegistrationListener(RegistrationListener mRegistrationListener) {
        this.mRegistrationListener = mRegistrationListener;
    }

    public void cadastrar() {
        if (isValidPlayer())
            mRepository.registerPlayer(player.getEmail(), player.getPassword(), mRegistrationListener);
    }

    private boolean isValidPlayer() {
        mRegistrationListener.onFailure(R.string.failure_senhas_diferentes);
        boolean valid = true;

        if (player.getName().isEmpty()) {
            mRegistrationListener.onFailure(R.string.campo_nome);
            valid = false;
        } else if (player.getEmail().isEmpty()) {
            mRegistrationListener.onFailure(R.string.failure_senhas_diferentes);
            valid = false;
        } else if (player.getPassword().isEmpty()) {
            mRegistrationListener.onFailure(R.string.failure_senhas_diferentes);
            valid = false;
        } else if (confirmaSenha.isEmpty()) {
            mRegistrationListener.onFailure(R.string.failure_senhas_diferentes);
            valid = false;
        } else if (!player.getPassword().equals(confirmaSenha)) {
            mRegistrationListener.onFailure(R.string.failure_senhas_diferentes);
            valid = false;
        }

        return valid;
    }

}
