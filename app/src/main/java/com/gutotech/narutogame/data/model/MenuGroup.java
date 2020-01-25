package com.gutotech.narutogame.data.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import com.gutotech.narutogame.ui.SectionFragment;

import java.util.List;

public class MenuGroup {
    @DrawableRes
    public final int resId;

    @StringRes
    public final int name;

    public List<SectionFragment> sections;

    public MenuGroup(@DrawableRes int resId, List<SectionFragment> sections) {
        this(0, resId, sections);
    }

    public MenuGroup(@StringRes int name, @DrawableRes int resId, List<SectionFragment> sections) {
        this.name = name;
        this.resId = resId;
        this.sections = sections;
    }
}
