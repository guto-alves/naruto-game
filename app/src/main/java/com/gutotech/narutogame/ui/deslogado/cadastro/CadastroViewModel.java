package com.gutotech.narutogame.ui.deslogado.cadastro;

import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Player;
import com.gutotech.narutogame.data.repository.PlayerRepository;

public class CadastroViewModel extends ViewModel {
    private Player player;
    public String confirmaSenha;

    private CadastroListener mCadastroListener;

    public PlayerRepository mRepository;

    public CadastroViewModel() {
        player = new Player();
        mRepository = new PlayerRepository();
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

        if (player.getNome().isEmpty()) {
            mCadastroListener.onFailure(R.string.campo_nome);
            valid = false;
        } else if (player.getEmail().isEmpty()) {
            mCadastroListener.onFailure(R.string.failure_senhas_diferentes);
            valid = false;
        } else if (player.getSenha().isEmpty()) {
            mCadastroListener.onFailure(R.string.failure_senhas_diferentes);
            valid = false;
        } else if (confirmaSenha.isEmpty()) {
            mCadastroListener.onFailure(R.string.failure_senhas_diferentes);
            valid = false;
        } else if (!player.getSenha().equals(confirmaSenha)) {
            mCadastroListener.onFailure(R.string.failure_senhas_diferentes);
            valid = false;
        }

        return valid;
    }

}
