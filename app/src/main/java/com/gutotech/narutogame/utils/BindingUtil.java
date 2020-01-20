package com.gutotech.narutogame.utils;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LiveData;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.material.textfield.TextInputEditText;

public class BindingUtil {

//    public static String convertToRyous(long ryous) {
//        return String.format("%s %d", "RY$", ryous);
//    }

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
}
