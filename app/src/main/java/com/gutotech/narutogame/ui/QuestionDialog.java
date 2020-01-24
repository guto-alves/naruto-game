package com.gutotech.narutogame.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.gutotech.narutogame.R;

public class QuestionDialog extends DialogFragment {
    private String mQuestion = "";

    private View.OnClickListener mOnOkButton;
    private View.OnClickListener mOnCancelButton;

    public QuestionDialog() {
    }

    public QuestionDialog(String question) {
        mQuestion = question;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View root = requireActivity().getLayoutInflater().inflate(R.layout.dialog_question, null);
        builder.setView(root);

        TextView textView = root.findViewById(R.id.questionTextView);
        textView.setText(mQuestion);

        Button okButton = root.findViewById(R.id.okButton);
        okButton.setOnClickListener(v -> {
            if (mOnOkButton != null) {
                mOnOkButton.onClick(v);
            }
            dismiss();
        });

        Button cancelButton = root.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(v -> {
            if (mOnCancelButton != null) {
                mOnCancelButton.onClick(v);
            }
            dismiss();
        });

        return builder.create();
    }

    public void setOnCancelButton(View.OnClickListener onCancelButton) {
        mOnCancelButton = onCancelButton;
    }

    public void setOnOkButton(View.OnClickListener onOkButton) {
        mOnOkButton = onOkButton;
    }
}
