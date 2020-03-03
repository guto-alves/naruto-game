package com.gutotech.narutogame.utils;

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

public class BindingUtil {

    @BindingAdapter(value = "loadProfile")
    public static void setLoadProfile(ImageView imageView, String path) {
        if (!TextUtils.isEmpty(path)) {
            StorageUtil.downloadProfile(imageView.getContext(), imageView, path);
        }
    }

    @BindingAdapter("loadTopImage")
    public static void setLoadTopImage(ImageView imageView, int ninjaId) {
        StorageUtil.downloadTopImage(imageView.getContext(), imageView, ninjaId);
    }

    @BindingAdapter("stringRes")
    public static void setStringRes(TextView textView, @StringRes int resId) {
        String text = "";

        if (resId != 0) {
            text = textView.getContext().getString(resId);
        }

        textView.setText(text);
    }

    @BindingAdapter("mask")
    public static void setMask(TextInputEditText textView, String mask) {
        textView.addTextChangedListener(new MaskTextWatcher(
                textView, new SimpleMaskFormatter(mask)));
    }

    @BindingAdapter("show")
    public static void setShow(View view, Boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
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
        StorageUtil.downloadProfileForMsg(imageView.getContext(), imageView);
    }
}
