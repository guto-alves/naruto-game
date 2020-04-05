package com.gutotech.narutogame.data.repository;

import android.util.Log;

import androidx.annotation.StringRes;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.ResultListener;

public class AuthRepository {
    private static AuthRepository sInstance;

    private static FirebaseAuth mAuth;

    private AuthRepository() {
        mAuth = FirebaseAuth.getInstance();
    }

    public static AuthRepository getInstance() {
        if (sInstance == null) {
            sInstance = new AuthRepository();
        }
        return sInstance;
    }

    public void register(String name, String email, String password, Completable emitter) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                updateProfile(getCurrentUser(), name, null, true);
                emitter.onComplete();
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
                    e.printStackTrace();
                }

                emitter.onError(resId);
            }
        });
    }

    public void signIn(String email, String password, final Completable emitter) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            int resId;

            if (task.isSuccessful()) {
                if (getCurrentUser().isEmailVerified()) {
                    emitter.onComplete();
                } else {
                    emitter.onError(R.string.email_isnt_verified);
                    signOut();
                }
            } else {
                try {
                    throw task.getException();
                } catch (FirebaseAuthInvalidUserException e) {
                    resId = R.string.account_is_not_registered;
                } catch (FirebaseAuthInvalidCredentialsException e) {
                    resId = R.string.email_and_password_not_found;
                } catch (Exception e) {
                    resId = R.string.error_to_the_sign_in;
                    e.printStackTrace();
                }

                emitter.onError(resId);
            }
        });
    }

    public void sendPasswordResetEmail(String emailAddress, ResultListener listener) {
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
            } else {
                try {
                    throw task.getException();
                } catch (FirebaseAuthWeakPasswordException e) {
                    emitter.onError(R.string.new_invalid_password);
                    e.printStackTrace();
                } catch (FirebaseAuthRecentLoginRequiredException e) {
                    emitter.onError(R.string.error_requires_recent_athentication);
                    e.printStackTrace();
                } catch (Exception e) {
                    emitter.onError(R.string.error_updating_password);
                    Log.d("AuthRepository", task.getException().toString());
                    e.printStackTrace();
                }
            }
        });
    }

    public void updateProfile(FirebaseUser user, String newName, final Completable emitter,
                              boolean sendEmailVerification) {
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(newName).build();

        user.updateProfile(profileUpdates).addOnCompleteListener(task -> {
            if (emitter != null) {
                if (task.isSuccessful()) {
                    emitter.onComplete();
                } else {
                    emitter.onError(R.string.error_updating_name);
                }
            } else if (sendEmailVerification) {
                sendEmailVerification(user);
            }
        });
    }

    private void sendEmailVerification(FirebaseUser user) {
        mAuth.useAppLanguage();

        user.sendEmailVerification()
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

    public boolean isSignedIn() {
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
