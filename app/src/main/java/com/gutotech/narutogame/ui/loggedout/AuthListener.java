package com.gutotech.narutogame.ui.loggedout;

import androidx.annotation.StringRes;

public interface AuthListener {
    void onStarted();

    void onSuccess();

    void onFailure(@StringRes int resId);
}
