package com.gutotech.narutogame.ui.loggedin.changepassword;

import android.text.TextUtils;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.PlayerRepository;
import com.gutotech.narutogame.ui.ResultListener;

public class PasswordChangeViewModel extends ViewModel {
    public final ObservableField<String> currentPassword = new ObservableField<>("");
    public final ObservableField<String> newPassword = new ObservableField<>("");
    public final ObservableField<String> newPassword2 = new ObservableField<>("");

    private ResultListener mResultListener;

    public void setListener(ResultListener listener) {
        mResultListener = listener;
    }

    public void onChangePasswordButtonPressed() {
        if (validatePassword()) {
            mResultListener.onStarted();
            PlayerRepository.getInstance().isValidCurrentPassword(currentPassword.get(),
                    result -> {
                        if (result) {
                            updatePassword();
                        } else {
                            mResultListener.onFailure(R.string.password_isnt_valid);
                        }
                    });
        }
    }

    private boolean validatePassword() {
        if (TextUtils.isEmpty(currentPassword.get()) || TextUtils.isEmpty(newPassword.get()) ||
                TextUtils.isEmpty(newPassword2.get())) {
            mResultListener.onFailure(R.string.please_fill_all_the_fields);
            return false;
        } else if (!TextUtils.equals(newPassword.get(), newPassword2.get())) {
            mResultListener.onFailure(R.string.the_passwords_do_not_match);
            return false;
        }

        return true;
    }

    private void updatePassword() {
        AuthRepository.getInstance().updatePassword(newPassword.get(),
                new AuthRepository.Completable() {
                    @Override
                    public void onComplete() {
                        PlayerRepository.getInstance().updatePassword(newPassword.get());

                        currentPassword.set("");
                        newPassword.set("");
                        newPassword2.set("");

                        mResultListener.onSuccess();
                    }

                    @Override
                    public void onError(int resId) {
                        mResultListener.onFailure(resId);
                    }
                });
    }
}
