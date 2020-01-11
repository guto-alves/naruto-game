package com.gutotech.narutogame.data.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.ui.loggedout.AuthListener;
import com.gutotech.narutogame.ui.loggedout.registration.RegistrationListener;

public class AuthRepository {
    private static AuthRepository instance;

    private static FirebaseAuth mAuth;

    private AuthRepository() {
        mAuth = FirebaseConfig.getAuth();
    }

    public static AuthRepository getInstance() {
        if (instance == null)
            instance = new AuthRepository();
        return instance;
    }

    public void registerPlayer(String email, String password, RegistrationListener listener) {
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

    private void sendEmailVerification() {
        mAuth.useAppLanguage();
        FirebaseUser user = mAuth.getCurrentUser();

        user.sendEmailVerification()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {

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

    public void sendPasswordResetEmail(String emailAddress, AuthListener listener) {
        mAuth.useAppLanguage();
        mAuth.sendPasswordResetEmail(emailAddress).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
//                            Log.d(TAG, "Email sent.");
                listener.onSuccess();
            }
        });
    }

    public void changePassword(String newPassword) {
        FirebaseUser user = mAuth.getCurrentUser();

        user.updatePassword(newPassword).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
//                Log.d(TAG, "User password updated.");
            }
        });
    }


    public void updateProfile(String newName) {
        FirebaseUser user = mAuth.getCurrentUser();

        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(newName).build();

        user.updateProfile(profileUpdates).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {

            }
        });
    }

    public void signOut() {
        mAuth.signOut();
    }
}
