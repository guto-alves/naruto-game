package com.gutotech.narutogame.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.gutotech.narutogame.R;

public class ProgressDialogFragment extends DialogFragment {
    private static final String DIALOG_TAG = "ProgressDialogFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        return inflater.inflate(R.layout.dialog_progress, container, false);
    }

    public void openDialog(FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag(DIALOG_TAG) == null) {
            setCancelable(false);
            show(fragmentManager, DIALOG_TAG);
        }
    }

    public void show(FragmentManager fragmentManager) {
        setCancelable(false);
        show(fragmentManager, DIALOG_TAG);
    }

    public void close() {
        if (isVisible()) {
            dismiss();
        }
    }
}
