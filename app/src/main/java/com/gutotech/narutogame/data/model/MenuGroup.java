package com.gutotech.narutogame.data.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

public class MenuGroup {
    @StringRes
    public final int name;

    @DrawableRes
    public final int resId;

    public MenuGroup(@StringRes int name, @DrawableRes int resId) {
        this.name = name;
        this.resId = resId;
    }
}
