package com.gutotech.narutogame.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.StringRes;
import androidx.databinding.BindingAdapter;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.material.textfield.TextInputEditText;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.StorageUtils;
import com.gutotech.narutogame.data.model.GraduationUtils;
import com.gutotech.narutogame.data.model.Village;

public class BindingAdapters {

    @BindingAdapter("jutsu_image")
    public static void setJutsuImage(ImageView imageView, String path) {
        if (!TextUtils.isEmpty(path)) {
            StorageUtils.loadJutsu(imageView, path);
        }
    }

    @BindingAdapter("loadProfile")
    public static void setLoadProfile(ImageView imageView, String path) {
        if (!TextUtils.isEmpty(path)) {
            StorageUtils.loadProfile(imageView.getContext(), imageView, path);
        }
    }

    @BindingAdapter("loadTopImage")
    public static void setLoadTopImage(ImageView imageView, int ninjaId) {
        StorageUtils.loadTopImage(imageView.getContext(), imageView, ninjaId);
    }

    @BindingAdapter("stringRes")
    public static void setStringRes(TextView textView, @StringRes int resid) {
        String text = "";

        if (resid != 0) {
            text = textView.getContext().getString(resid);
        }

        textView.setText(text);
    }

    @BindingAdapter({"graduationId", "village", "level"})
    public static void setFighterInfo(TextView textView, int graduationId, Village village, int level) {
        if (village == null || level == 0) {
            return;
        }

        Context context = textView.getContext();
        String graduation = context.getString(GraduationUtils.getName(graduationId, village));
        textView.setText(context.getString(R.string.label_graduation_and_lvl,
                graduation, level));
    }

    @BindingAdapter("mask")
    public static void setMask(TextInputEditText textView, String mask) {
        textView.addTextChangedListener(new MaskTextWatcher(
                textView, new SimpleMaskFormatter(mask)));
    }

    @BindingAdapter("background_play_mode")
    public static void setBackgroundPlayMode(Button button, Boolean selected) {
        if (selected) {
            button.setBackgroundResource(R.drawable.layout_luck_button_normal);
        } else {
            button.setBackgroundResource(R.drawable.layout_luck_button_selected);
        }
    }

    @BindingAdapter("profileForMsg")
    public static void setProfileForMsg(ImageView imageView, Integer i) {
        StorageUtils.loadProfileForMsg(imageView.getContext(), imageView);
    }

    @BindingAdapter("visibleGone")
    public static void showHide(View view, Boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
