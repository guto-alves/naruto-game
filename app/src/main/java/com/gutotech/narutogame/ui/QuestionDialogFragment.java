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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.gutotech.narutogame.R;

public class QuestionDialogFragment extends DialogFragment {

    public interface QuestionDialogListener {
        void onPositiveClick(int requestCode);

        default void onNegativeClick(int requestCode) {
        }
    }

    private static final String DIALOG_TAG = "QuestionDialogFragment";
    private static final String EXTRA_QUESTION = "question";
    private static final String EXTRA_REQUEST_CODE = "requestCode";

    private QuestionDialogListener mListener;

    public static QuestionDialogFragment newInstance(String question) {
        return newInstance(question, null, 0);
    }

    public static QuestionDialogFragment newInstance(String question, Fragment targetFragment) {
        return newInstance(question, targetFragment, 0);
    }

    public static QuestionDialogFragment newInstance(String question, Fragment targetFragment, int requestCode) {
        Bundle args = new Bundle();
        args.putString(EXTRA_QUESTION, question);
        args.putInt(EXTRA_REQUEST_CODE, requestCode);

        QuestionDialogFragment questionDialog = new QuestionDialogFragment();
        questionDialog.setArguments(args);
        questionDialog.setCancelable(false);
        questionDialog.setTargetFragment(targetFragment, 0);
        return questionDialog;
    }

    public void openDialog(FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag(DIALOG_TAG) == null) {
            show(fragmentManager, DIALOG_TAG);
        }
    }

    public void show(FragmentManager fragmentManager) {
        show(fragmentManager, DIALOG_TAG);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_question, container, false);

        TextView textView = view.findViewById(R.id.questionTextView);
        textView.setText(getArguments().getString(EXTRA_QUESTION));

        int requestCode = getArguments().getInt(EXTRA_REQUEST_CODE);

        Button okButton = view.findViewById(R.id.okButton);
        okButton.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onPositiveClick(requestCode);
            }

            dismiss();
        });

        Button cancelButton = view.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onNegativeClick(requestCode);
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
            ignored.printStackTrace();
            try {
                mListener = (QuestionDialogListener) getActivity();
            } catch (ClassCastException ignored1) {
            }
        }
    }
}
