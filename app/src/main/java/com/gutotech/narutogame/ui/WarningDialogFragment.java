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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.gutotech.narutogame.R;

public class WarningDialogFragment extends DialogFragment {

    public interface WarningDialogListener {
        void onCloseClick(int requestCode);
    }

    private static final String TAG = "WarningDialogFragment";
    private static final String EXTRA_TITLE = "title";
    private static final String EXTRA_MESSAGE = "message";
    private static final String EXTRA_BUTTON_TEXT = "buttonText";
    private static final String EXTRA_REQUEST_CODE = "requestCode";
    private WarningDialogListener mListener;

    public static WarningDialogFragment newInstance(Context context, String message) {
        return newInstance(context.getString(R.string.warning), message, context.getString(R.string.close),
                null, 0);
    }

    public static WarningDialogFragment newInstance(Context context, @StringRes int messageId) {
        return newInstance(context.getString(R.string.warning), context.getString(messageId),
                context.getString(R.string.close), null, 0);
    }

    // hospital two warnings
    public static WarningDialogFragment newInstance(Context context, @StringRes int messageId,
                                                    Fragment targetFragment, int requestCode) {
        return newInstance(context.getString(R.string.warning), context.getString(messageId),
                context.getString(R.string.close), targetFragment, requestCode);
    }

    public static WarningDialogFragment newInstance(Context context, @StringRes int titleId,
                                                    @StringRes int messageId, Fragment targetFragment,
                                                    int requestCode) {
        return newInstance(context.getString(titleId), context.getString(messageId),
                context.getString(R.string.close), targetFragment, requestCode);
    }

    // connection state activity
    public static WarningDialogFragment newInstance(Context context, @StringRes int titleId,
                                                    @StringRes int messageId, @StringRes int buttonTextId,
                                                    int requestCode) {
        return newInstance(context.getString(titleId), context.getString(messageId),
                context.getString(buttonTextId), null, requestCode);
    }

    public static WarningDialogFragment newInstance(Context context, @StringRes int titleId,
                                                    @StringRes int messageId, @StringRes int buttonTextId,
                                                    Fragment targetFragment) {
        return newInstance(context.getString(titleId), context.getString(messageId),
                context.getString(buttonTextId), targetFragment, 0);
    }

    public static WarningDialogFragment newInstance(String warningTitle, String warningMessage,
                                                    String buttonText,
                                                    Fragment fragment, int requestCode) {
        Bundle args = new Bundle();
        args.putString(EXTRA_TITLE, warningTitle);
        args.putString(EXTRA_MESSAGE, warningMessage);
        args.putString(EXTRA_BUTTON_TEXT, buttonText);
        args.putInt(EXTRA_REQUEST_CODE, requestCode);

        WarningDialogFragment warningDialog = new WarningDialogFragment();
        warningDialog.setArguments(args);
        warningDialog.setTargetFragment(fragment, 1);
        warningDialog.setCancelable(false);
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

        int requestCode = getArguments().getInt(EXTRA_REQUEST_CODE);

        Button closeButton = view.findViewById(R.id.closeButton);
        closeButton.setText(args.getString(EXTRA_BUTTON_TEXT));
        closeButton.setOnClickListener(v -> {
            dismiss();

            if (mListener != null) {
                mListener.onCloseClick(requestCode);
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            int requestCode = getArguments().getInt(EXTRA_REQUEST_CODE);
            if (requestCode < 10){
                mListener = (WarningDialogListener) getTargetFragment();
            }else{
                mListener = (WarningDialogListener) getActivity();
            }
        } catch (ClassCastException ignored) {
        }
    }

}
