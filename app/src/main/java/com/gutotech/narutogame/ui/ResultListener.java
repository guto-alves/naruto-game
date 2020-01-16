package com.gutotech.narutogame.ui;

import androidx.annotation.StringRes;

public interface ResultListener {
    void onStarted();

    void onSuccess();

    void onFailure(@StringRes int resId);
}
