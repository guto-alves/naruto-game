package com.gutotech.narutogame.ui.loggedout.cadastro;

import androidx.annotation.StringRes;

public interface CadastroListener {
    void onSuccess(@StringRes int resId);

    void onFailure(@StringRes int resId);
}
