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
import androidx.fragment.app.FragmentManager;

import com.gutotech.narutogame.R;

public class QuestionDialogFragment extends DialogFragment {

    public interface QuestionDialogListener {
        void onPositiveClick();
        void onCancelClick();
    }

    private static final String EXTRA_QUESTION = "question";
    private static final String DIALOG_TAG = "QuestionDialogFragment";

    private QuestionDialogListener mListener;

    public static QuestionDialogFragment newInstance(@StringRes int questionId) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_QUESTION, questionId);

        QuestionDialogFragment questionDialog = new QuestionDialogFragment();
        questionDialog.setArguments(args);
        return questionDialog;
    }

    public void openDialog(FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag(DIALOG_TAG) == null) {
            setCancelable(false);
            show(fragmentManager, DIALOG_TAG);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_question, container, false);

        int resid = getArguments().getInt(EXTRA_QUESTION);

        TextView textView = view.findViewById(R.id.questionTextView);
        textView.setText(resid);

        Button okButton = view.findViewById(R.id.okButton);
        okButton.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onPositiveClick();
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
            mListener = (QuestionDialogListener) context;
        } catch (ClassCastException ignored) {
        }
    }
}
