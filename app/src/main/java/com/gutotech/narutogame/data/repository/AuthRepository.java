package com.gutotech.narutogame.data.repository;

import android.util.Log;

import androidx.annotation.StringRes;

import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.loggedout.AuthListener;

public class AuthRepository {
    private static AuthRepository sInstance;

    private static FirebaseAuth mAuth;

    private AuthRepository() {
        mAuth = FirebaseAuth.getInstance();
    }

    public static AuthRepository getInstance() {
        if (sInstance == null)
            sInstance = new AuthRepository();
        return sInstance;
    }

    public void registerPlayer(String name, String email, String password, Completable emitter) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                emitter.onComplete();
                updateProfile(name, null);
            } else {
                int resId;

                try {
                    throw task.getException();
                } catch (FirebaseAuthWeakPasswordException e) {
                    resId = R.string.weak_password;
                } catch (FirebaseAuthInvalidCredentialsException e) {
                    resId = R.string.invalid_email;
                } catch (FirebaseAuthUserCollisionException e) {
                    resId = R.string.email_already_exists;
                } catch (Exception e) {
                    resId = R.string.error_to_the_signup;
                }

                emitter.onError(resId);
            }
        });
    }

    public void loginPlayer(String email, String password, final Completable emitter) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                emitter.onComplete();
            } else {
                int resId;

                try {
                    throw task.getException();
                } catch (FirebaseAuthInvalidUserException e) {
                    resId = R.string.account_is_not_registered;
                } catch (FirebaseAuthInvalidCredentialsException e) {
                    resId = "Email e senha não correspendem";
                } catch (Exception e) {
                    resId = "Erro ao entrar: " + e.getMessage();
                    e.printStackTrace();
                }

                emitter.onError(resId);
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

    public void updatePassword(String newPassword, Completable emitter) {
        getCurrentUser().updatePassword(newPassword).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                emitter.onComplete();
//                Log.d(TAG, "User password updated.");
            } else {
                emitter.onError(R.string.invalid_password);
            }
        });
    }


    public void updateProfile(String newName, final Completable emitter) {
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(newName).build();

        getCurrentUser().updateProfile(profileUpdates).addOnCompleteListener(task -> {
            if (emitter != null) {
                if (task.isSuccessful()) {
                    emitter.onComplete();
                } else {
                    emitter.onError(R.string.action_error);
                }
            } else {
                sendEmailVerification();
            }
        });
    }

    private void sendEmailVerification() {
        mAuth.useAppLanguage();

        String url = "https://gutotech.page.link/Fc4u/verify?uid=" + getUid();
        ActionCodeSettings actionCodeSettings = ActionCodeSettings.newBuilder()
                .setUrl(url)
                .setAndroidPackageName("com.gutotech.narutogame", false, null)
                .setDynamicLinkDomain("gutotech.page.link")
                .setHandleCodeInApp(true)
                .build();

        getCurrentUser().sendEmailVerification(actionCodeSettings)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.d("AuthRepository", "Email sent.");
                    }
                });
    }

    public FirebaseUser getCurrentUser() {
        return mAuth.getCurrentUser();
    }

    public String getUid() {
        return getCurrentUser().getUid();
    }

    public boolean isSignedin() {
        return getCurrentUser() != null;
    }

    public void signOut() {
        mAuth.signOut();
    }

    public interface Completable {
        void onComplete();

        void onError(@StringRes int resId);
    }
}
