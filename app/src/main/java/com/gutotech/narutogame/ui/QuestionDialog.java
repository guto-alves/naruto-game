package com.gutotech.narutogame.ui;

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

public class QuestionDialog extends DialogFragment {
    private static final String EXTRA_QUESTION = "question";
    private static final String DIALOG_TAG = "QuestionDialog";

    public interface OnButtonsClickListener {
        void onPositiveClick();

        void onCancelClick();
    }

    public static QuestionDialog newInstance(@StringRes int questionId) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_QUESTION, questionId);

        QuestionDialog questionDialog = new QuestionDialog();
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

        int resid = getArguments().getInt(EXTRA_QUESTION);

        TextView textView = view.findViewById(R.id.questionTextView);
        textView.setText(resid);

        Button okButton = view.findViewById(R.id.okButton);
        okButton.setOnClickListener(v -> {
            OnButtonsClickListener clickListener = (OnButtonsClickListener) getTargetFragment();

            if (clickListener != null) {
                clickListener.onPositiveClick();
            }

            dismiss();
        });

        Button cancelButton = view.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(v -> {
            OnButtonsClickListener clickListener = (OnButtonsClickListener) getActivity();

            if (clickListener != null) {
                clickListener.onCancelClick();
            }

            dismiss();
        });

        return view;
    }
}
