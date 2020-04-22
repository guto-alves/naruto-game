package com.gutotech.narutogame.ui.playing;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Requirement;
import com.gutotech.narutogame.ui.adapter.RequirementsAdapter;
import com.gutotech.narutogame.utils.SoundUtil;

import java.util.List;

public class RequirementDialogFragment extends DialogFragment {
    private static final String DIALOG_TAG = "RequirementDialogFragment";

    private boolean folded;
    private List<Requirement> requirements;

    public RequirementDialogFragment() {
    }

    public static RequirementDialogFragment getInstance(List<Requirement> requirements) {
        return getInstance(requirements, false);
    }

    public static RequirementDialogFragment getInstance(List<Requirement> requirements, boolean folded) {
        RequirementDialogFragment dialog = new RequirementDialogFragment();
        dialog.requirements = requirements;
        dialog.folded = folded;
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View root = requireActivity().getLayoutInflater().inflate(R.layout.dialog_requirements, null);
        builder.setView(root);

        RecyclerView requirementsRecyclerView = root.findViewById(R.id.requirementsRecyclerView);
        requirementsRecyclerView.setHasFixedSize(true);
        requirementsRecyclerView.setAdapter(new RequirementsAdapter(getContext(), requirements, folded));

        return builder.create();
    }

    public void openDialog(FragmentManager fragmentManager, Context context) {
        if (fragmentManager.findFragmentByTag(DIALOG_TAG) == null) {
            show(fragmentManager, DIALOG_TAG);
        }
        SoundUtil.play(context, R.raw.sound_pop);
    }

}
