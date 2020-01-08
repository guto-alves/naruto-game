package com.gutotech.narutogame.data.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Player;
import com.gutotech.narutogame.ui.deslogado.cadastro.CadastroListener;

public class PlayerRepository {

    public PlayerRepository() {
    }

    public void registerPlayer(final Player player, CadastroListener listener) {
        final FirebaseAuth mAuth = FirebaseConfig.getAuth();

        mAuth.createUserWithEmailAndPassword(player.getEmail(), player.getSenha()
        ).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                player.setId(mAuth.getCurrentUser().getUid());
                player.salvar();
                listener.onSuccess(R.string.cadastro_concluido);
            } else {
                int resId;

                try {
                    throw task.getException();
                } catch (FirebaseAuthWeakPasswordException e) {
                    resId = R.string.failure_senha_invalida;
                } catch (FirebaseAuthInvalidCredentialsException e) {
                    resId = R.string.failure_email_invalido;
                } catch (FirebaseAuthUserCollisionException e) {
                    resId = R.string.failure_email_ja_existe;
                } catch (Exception e) {
                    resId = R.string.failure_error_ao_cadastrar;
                }

                listener.onFailure(resId);
            }
        });
    }
}
