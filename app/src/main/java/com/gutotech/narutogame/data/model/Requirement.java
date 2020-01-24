package com.gutotech.narutogame.data.model;

import android.content.Context;

public interface Requirement {

    boolean check();

    String show(Context context);
}
