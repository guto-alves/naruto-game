package com.gutotech.narutogame.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
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

import java.io.Serializable;

public class WarningDialogFragment extends DialogFragment {

    public interface WarningDialogListener extends Serializable {
        void onCloseClick();
    }

    private static final String TAG = "WarningDialogFragment";
    private static final String EXTRA_TITLE = "title";
    private static final String EXTRA_MESSAGE = "message";
    private static final String EXTRA_BUTTON_TEXT = "button_text";
    private static final String EXTRA_LISTENER = "listener";

    public static WarningDialogFragment newInstance(Context context, String message) {
        return newInstance(context.getString(R.string.warning), message,
                context.getString(R.string.close), true, null);
    }

    public static WarningDialogFragment newInstance(Context context, @StringRes int messageId) {
        return newInstance(context.getString(R.string.warning), context.getString(messageId),
                context.getString(R.string.close), true, null);
    }

    public static WarningDialogFragment newInstance(Context context, @StringRes int titleId,
                                                    @StringRes int messageId,
                                                    WarningDialogListener listener) {
        return newInstance(context.getString(titleId), context.getString(messageId),
                context.getString(R.string.close), false, listener);
    }

    public static WarningDialogFragment newInstance(Context context, @StringRes int messageId,
                                                    WarningDialogListener listener) {
        return newInstance(context.getString(R.string.warning), context.getString(messageId),
                context.getString(R.string.close), false, listener);
    }

    public static WarningDialogFragment newInstance(Context context, @StringRes int messageId,
                                                    boolean cancelable, WarningDialogListener listener) {
        return newInstance(context.getString(R.string.warning), context.getString(messageId),
                context.getString(R.string.close), cancelable, listener);
    }

    public static WarningDialogFragment newInstance(Context context, @StringRes int titleId,
                                                    @StringRes int messageId, @StringRes int buttonTextId,
                                                    WarningDialogListener listener) {
        return newInstance(context.getString(titleId), context.getString(messageId),
                context.getString(buttonTextId), false, listener);
    }

    public static WarningDialogFragment newInstance(String warningTitle, String warningMessage,
                                                    String buttonText, boolean cancelable,
                                                    WarningDialogListener listener) {
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TITLE, warningTitle);
        bundle.putString(EXTRA_MESSAGE, warningMessage);
        bundle.putString(EXTRA_BUTTON_TEXT, buttonText);
        bundle.putSerializable(EXTRA_LISTENER, listener);

        WarningDialogFragment warningDialog = new WarningDialogFragment();
        warningDialog.setArguments(bundle);
        warningDialog.setCancelable(cancelable);
        return warningDialog;
    }

    public void openDialog(FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag(TAG) == null) {
            show(fragmentManager, TAG);
        }
    }

    public void show(FragmentManager fragmentManager) {
        show(fragmentManager, TAG);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = requireActivity().getLayoutInflater().inflate(R.layout.dialog_warning, null);
        builder.setView(view);

        Bundle args = getArguments();

        TextView titleTextView = view.findViewById(R.id.titleTextView);
        titleTextView.setText(getArguments().getString(EXTRA_TITLE));

        TextView messageTextView = view.findViewById(R.id.messageTextView);
        messageTextView.setText(getArguments().getString(EXTRA_MESSAGE));

        Button closeButton = view.findViewById(R.id.closeButton);
        closeButton.setText(args.getString(EXTRA_BUTTON_TEXT));
        closeButton.setOnClickListener(v -> {
            dismiss();

            WarningDialogListener listener = (WarningDialogListener)
                    args.getSerializable(EXTRA_LISTENER);
            if (listener != null) {
                listener.onCloseClick();
            }
        });

        return builder.create();
    }
}
