package com.gutotech.narutogame.ui.playing;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Requirement;
import com.gutotech.narutogame.ui.adapter.RequirementsAdapter;

import java.util.List;

public class RequirementDialogFragment extends DialogFragment {
    private boolean mFolded;
    private List<Requirement> mRequirements;

    public RequirementDialogFragment(List<Requirement> requirements) {
        mRequirements = requirements;
    }

    public RequirementDialogFragment(List<Requirement> requirements, boolean folded) {
        mRequirements = requirements;
        mFolded = folded;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View root = requireActivity().getLayoutInflater().inflate(R.layout.dialog_requirements, null);
        builder.setView(root);

        RecyclerView requirementsRecyclerView = root.findViewById(R.id.requirementsRecyclerView);
        requirementsRecyclerView.setHasFixedSize(true);
        requirementsRecyclerView.setAdapter(new RequirementsAdapter(getContext(), mRequirements, mFolded));

        return builder.create();
    }
}
