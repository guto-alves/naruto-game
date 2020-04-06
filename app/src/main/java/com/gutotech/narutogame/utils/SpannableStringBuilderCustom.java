package com.gutotech.narutogame.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;

import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;

public class SpannableStringBuilderCustom {
    private Context mContext;
    private SpannableStringBuilder mStringBuilder;

    private int index;

    public SpannableStringBuilderCustom(Context context) {
        mContext = context;
        mStringBuilder = new SpannableStringBuilder();
    }

    public SpannableStringBuilderCustom(Context context, String text, @ColorRes int color) {
        mContext = context;
        mStringBuilder = new SpannableStringBuilder();
        append(text, color);
    }

    public SpannableStringBuilderCustom(Context context, @StringRes int text, @ColorRes int color) {
        mContext = context;
        mStringBuilder = new SpannableStringBuilder();
        append(text, color);
    }


    public void append(String text) {
        index = mStringBuilder.length();
        mStringBuilder.append(text);
    }

    public void append(@StringRes int resId) {
        append(mContext.getString(resId));
    }

    public void append(@StringRes int resId, @ColorRes int color) {
        append(mContext.getString(resId));
        setForegroundColor(color);
    }

    public void append(String text, @ColorRes int color) {
        append(text);
        setForegroundColor(color);
    }

    public void appendln() {
        append("\n");
    }

    public void append() {
        append(" ");
    }

    public void append(@StringRes int resId, CharacterStyle... styles) {
        append(resId);
        for (CharacterStyle style : styles) {
            setSpan(style);
        }
    }

    public void setSpan(CharacterStyle span) {
        mStringBuilder.setSpan(span, index, mStringBuilder.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
    }

    public void setForegroundColor(@ColorRes int color) {
        setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext, color)));
    }

    public SpannableStringBuilder getStringBuilder() {
        return mStringBuilder;
    }
}
