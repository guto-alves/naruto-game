package com.gutotech.narutogame.data.model;

import android.content.Context;

public interface Require {

    int value(boolean folded);

    Object value();

    boolean check();

    boolean check(boolean folded);

    String toString(Context context);

    String toString(Context context, boolean folded);
}
