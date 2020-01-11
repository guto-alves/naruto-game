package com.gutotech.narutogame.util;

import android.app.Activity;
import android.widget.TextView;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.gutotech.narutogame.R;

public class FragmentUtil {

    public static void setSectionTitle(Activity activity, @StringRes int resId) {
        TextView sectionTitleTextView = activity.findViewById(R.id.sectionTitleTextView);
        sectionTitleTextView.setText(resId);
    }

    public static void changeToFragment(FragmentActivity activity, Fragment fragment) {
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}
