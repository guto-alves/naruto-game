package com.gutotech.narutogame.data.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.ui.loggedout.AuthListener;
import com.gutotech.narutogame.ui.loggedout.cadastro.CadastroListener;

public class AuthRepository {
    private static AuthRepository instance;

    private FirebaseAuth mAuth;

    private AuthRepository() {
        mAuth = FirebaseConfig.getAuth();
    }

    public static AuthRepository getInstance() {
        if (instance == null)
            instance = new AuthRepository();
        return instance;
    }

    public void registerPlayer(String email, String password, CadastroListener listener) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                mAuth.getCurrentUser().getUid();
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

    public void loginPlayer(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {

            } else {
                String excecao;

                try {
                    throw task.getException();
                } catch (FirebaseAuthInvalidUserException e) {
                    excecao = "Conta não está cadastrada";
                } catch (FirebaseAuthInvalidCredentialsException e) {
                    excecao = "Email e senha não correspendem";
                } catch (Exception e) {
                    excecao = "Erro ao entrar: " + e.getMessage();
                    e.printStackTrace();
                }
            }
        });
    }

    public void recoverPassword(String emailAddress, AuthListener listener) {
        mAuth.sendPasswordResetEmail(emailAddress).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
//                            Log.d(TAG, "Email sent.");
                listener.onSuccess();
            }
        });
    }

    public void changePassword(String newPassword) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.updatePassword(newPassword).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
//                Log.d(TAG, "User password updated.");
            }
        });
    }
}
