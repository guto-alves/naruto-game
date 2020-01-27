package com.gutotech.narutogame.utils;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.material.textfield.TextInputEditText;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;

public class BindingUtil {

    @BindingAdapter(value = "loadProfile")
    public static void loadImage(ImageView imageView, int ninjaId) {
        StorageUtil.downloadProfile(imageView.getContext(), imageView, ninjaId);
    }

    @BindingAdapter(value = {"ninjaId", "currentProfile"})
    public static void loadImage(ImageView imageView, int ninjaId, int profile) {
        StorageUtil.downloadProfile(imageView.getContext(), imageView, ninjaId, profile);
    }

    @BindingAdapter("mask")
    public static void setMask(TextInputEditText textView, String mask) {
        textView.addTextChangedListener(new MaskTextWatcher(
                textView, new SimpleMaskFormatter(mask)));
    }

    @BindingAdapter("text")
    public static void setText(TextView textView, String text) {
        textView.setText(text);
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
        StorageUtil.downloadProfileForMsg(imageView.getContext(), imageView,
                CharOn.character.getVillage().id);
    }
}
