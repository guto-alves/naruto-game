package com.gutotech.narutogame.ui.loggedout.registration;

import androidx.annotation.StringRes;

public interface RegistrationListener {
    void onSuccess(@StringRes int resId);

    void onFailure(@StringRes int resId);
}
