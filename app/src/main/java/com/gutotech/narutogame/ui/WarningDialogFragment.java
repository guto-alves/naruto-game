package com.gutotech.narutogame.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.gutotech.narutogame.R;

public class WarningDialogFragment extends DialogFragment {

    public interface WarningDialogListener {
        void onCloseClick();
    }

    private static final String EXTRA_WARNING = "warning";
    private static final String DIALOG_TAG = "WarningDialog";

    private WarningDialogListener mListener;

    public static WarningDialogFragment newInstance(String warning) {
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_WARNING, warning);

        WarningDialogFragment warningDialog = new WarningDialogFragment();
        warningDialog.setArguments(bundle);
        return warningDialog;
    }

    public static WarningDialogFragment newInstance(@StringRes int warningId) {
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_WARNING, warningId);

        WarningDialogFragment warningDialog = new WarningDialogFragment();
        warningDialog.setArguments(bundle);
        return warningDialog;
    }

    public void openDialog(FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag(DIALOG_TAG) == null) {
            setCancelable(false);
            show(fragmentManager, DIALOG_TAG);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = requireActivity().getLayoutInflater().inflate(R.layout.dialog_warning, null);
        builder.setView(view);

        TextView textView = view.findViewById(R.id.warningTextView);

        String warning = getArguments().getString(EXTRA_WARNING);

        if (TextUtils.isEmpty(warning)) {
            textView.setText(getArguments().getInt(EXTRA_WARNING));
        } else {
            textView.setText(warning);
        }

        Button closeButton = view.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onCloseClick();
            }

            dismiss();
        });

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mListener = (WarningDialogListener) context;
        } catch (ClassCastException ignored) {
        }
    }
}
