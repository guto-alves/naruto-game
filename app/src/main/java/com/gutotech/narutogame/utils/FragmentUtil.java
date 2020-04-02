package com.gutotech.narutogame.utils;

import android.app.Activity;
import android.widget.TextView;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.gutotech.narutogame.R;

public class FragmentUtil {

    public static void setSectionTitle(Activity activity, @StringRes int resId) {
        TextView sectionTitleTextView = activity.findViewById(R.id.sectionTitleTextView);
        sectionTitleTextView.setText(resId);
    }

    public static void goTo(FragmentActivity activity, Fragment fragment) {
        goTo(activity, fragment, false);
    }

    public static void goTo(FragmentActivity activity, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }

    public static void popBackStack(FragmentActivity activity, Fragment current, Fragment fragment) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.remove(current);
        transaction.commit();
        fragmentManager.popBackStack();
        goTo(activity, fragment);
    }
}
