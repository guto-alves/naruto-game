package com.gutotech.narutogame.data.model;

import android.content.Context;

public interface Reward {

    int value();

    void receive();

    CharSequence toString(Context context);
}
