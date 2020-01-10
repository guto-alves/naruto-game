package com.gutotech.narutogame.ui.loggedout.cadastro;

import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Player;
import com.gutotech.narutogame.data.repository.AuthRepository;

public class CadastroViewModel extends ViewModel {
    private Player player;
    public String confirmaSenha;

    private CadastroListener mCadastroListener;

    public AuthRepository mRepository;

    public CadastroViewModel() {
        player = new Player();
        mRepository = new AuthRepository();
    }

    public Player getPlayer() {
        return player;
    }

    public void setCadastroListener(CadastroListener mCadastroListener) {
        this.mCadastroListener = mCadastroListener;
    }

    public void cadastrar() {
        if (isValidPlayer())
            mRepository.registerPlayer(player, mCadastroListener);
    }

    private boolean isValidPlayer() {
        mCadastroListener.onFailure(R.string.failure_senhas_diferentes);
        boolean valid = true;

        if (player.getName().isEmpty()) {
            mCadastroListener.onFailure(R.string.campo_nome);
            valid = false;
        } else if (player.getEmail().isEmpty()) {
            mCadastroListener.onFailure(R.string.failure_senhas_diferentes);
            valid = false;
        } else if (player.getPassword().isEmpty()) {
            mCadastroListener.onFailure(R.string.failure_senhas_diferentes);
            valid = false;
        } else if (confirmaSenha.isEmpty()) {
            mCadastroListener.onFailure(R.string.failure_senhas_diferentes);
            valid = false;
        } else if (!player.getPassword().equals(confirmaSenha)) {
            mCadastroListener.onFailure(R.string.failure_senhas_diferentes);
            valid = false;
        }

        return valid;
    }

}
