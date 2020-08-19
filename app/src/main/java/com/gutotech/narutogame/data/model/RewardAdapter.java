package com.gutotech.narutogame.data.model;

import android.content.Context;

public abstract class RewardAdapter implements Reward {
    @Override
    public int value() {
        return 0;
    }

    @Override
    public void receive() {
    }

    @Override
    public CharSequence toString(Context context) {
        return String.valueOf(value());
    }
}
