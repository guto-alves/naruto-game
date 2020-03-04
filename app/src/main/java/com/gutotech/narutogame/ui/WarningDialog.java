package com.gutotech.narutogame.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.gutotech.narutogame.R;

public class WarningDialog extends DialogFragment {
    private static final String EXTRA_WARNING = "warning";
    private static final String DIALOG_TAG = "DialogFragment";

    private View.OnClickListener mOnClickListener;

    public static WarningDialog newInstance(@StringRes int warningId) {
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_WARNING, warningId);

        WarningDialog warningDialog = new WarningDialog();
        warningDialog.setArguments(bundle);
        return warningDialog;
    }

    public void openDialog(FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag(DIALOG_TAG) == null) {
            show(fragmentManager, DIALOG_TAG);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        int warningId = getArguments().getInt(EXTRA_WARNING);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);

        View root = requireActivity().getLayoutInflater().inflate(R.layout.dialog_warning, null);
        builder.setView(root);

        TextView textView = root.findViewById(R.id.warningTextView);
        textView.setText(warningId);

        Button closeButton = root.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> {
            if (mOnClickListener != null) {
                mOnClickListener.onClick(v);
            }

            dismiss();
        });

        return builder.create();
    }

    public void setOnCloseListener(View.OnClickListener listener) {
        mOnClickListener = listener;
    }
}
