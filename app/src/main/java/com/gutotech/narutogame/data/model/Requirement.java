package com.gutotech.narutogame.data.model;


import android.content.Context;

public class Requirement implements Require {

    @Override
    public int value(boolean folded) {
        return folded ? (int) value() * 2 : (int) value();
    }

    @Override
    public Object value() {
        return null;
    }

    public int getValue() {
        return 0;
    }

    @Override
    public boolean check() {
        return check(false);
    }

    @Override
    public boolean check(boolean folded) {
        return false;
    }

    @Override
    public String toString(Context context) {
        return toString(context, false);
    }

    @Override
    public String toString(Context context, boolean folded) {
        return null;
    }
}
