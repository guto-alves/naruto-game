package com.gutotech.narutogame.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.gutotech.narutogame.R;

import java.io.Serializable;

public class QuestionDialogFragment extends DialogFragment {

    public interface QuestionDialogListener extends Serializable {
        void onPositiveClick();

        default void onCancelClick() {
        }
    }

    private static final String EXTRA_QUESTION = "question";
    private static final String EXTRA_LISTENER = "listener";
    private static final String DIALOG_TAG = "QuestionDialogFragment";

    private QuestionDialogListener mListener;

    public static QuestionDialogFragment newInstance(@StringRes int questionId) {
        return newInstance(null, questionId);
    }

    public static QuestionDialogFragment newInstance(Fragment targetFragment, @StringRes int questionId) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_QUESTION, questionId);

        QuestionDialogFragment questionDialog = new QuestionDialogFragment();
        questionDialog.setCancelable(false);
        questionDialog.setArguments(args);
        questionDialog.setTargetFragment(targetFragment, 1);
        return questionDialog;
    }

    public static QuestionDialogFragment newInstance(Fragment targetFragment, String question) {
        Bundle args = new Bundle();
        args.putString(EXTRA_QUESTION, question);

        QuestionDialogFragment questionDialog = new QuestionDialogFragment();
        questionDialog.setCancelable(false);
        questionDialog.setArguments(args);
        questionDialog.setTargetFragment(targetFragment, 1);
        return questionDialog;
    }

    public static QuestionDialogFragment newInstance(@StringRes int questionId, QuestionDialogListener listener) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_QUESTION, questionId);
        args.putSerializable(EXTRA_LISTENER, listener);

        QuestionDialogFragment questionDialog = new QuestionDialogFragment();
        questionDialog.setCancelable(false);
        questionDialog.setArguments(args);
        return questionDialog;
    }

    public static QuestionDialogFragment newInstance(String question, QuestionDialogListener listener) {
        Bundle args = new Bundle();
        args.putString(EXTRA_QUESTION, question);
        args.putSerializable(EXTRA_LISTENER, listener);

        QuestionDialogFragment questionDialog = new QuestionDialogFragment();
        questionDialog.setCancelable(false);
        questionDialog.setArguments(args);
        return questionDialog;
    }

    public void openDialog(FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag(DIALOG_TAG) == null) {
            show(fragmentManager, DIALOG_TAG);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_question, container, false);

        TextView textView = view.findViewById(R.id.questionTextView);

        int resid = getArguments().getInt(EXTRA_QUESTION);

        if (resid != 0) {
            textView.setText(resid);
        } else {
            textView.setText(getArguments().getString(EXTRA_QUESTION));
        }

        Button okButton = view.findViewById(R.id.okButton);
        okButton.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onPositiveClick();
            } else {
                QuestionDialogListener listener = (QuestionDialogListener) getArguments()
                        .getSerializable(EXTRA_LISTENER);
                if (listener != null) {
                    listener.onPositiveClick();
                }
            }

            dismiss();
        });

        Button cancelButton = view.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onCancelClick();
            }

            dismiss();
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mListener = (QuestionDialogListener) getTargetFragment();
        } catch (ClassCastException ignored) {
        }
    }
}
