package com.gutotech.narutogame.ui.playing.team;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentTeamCreateBinding;
import com.gutotech.narutogame.ui.ProgressDialogFragment;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.utils.FragmentUtils;

public class TeamCreateFragment extends Fragment implements SectionFragment {
    private ProgressDialogFragment mProgressDialog = new ProgressDialogFragment();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTeamCreateBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_team_create, container, false);

        TeamCreateViewModel viewModel = new ViewModelProvider(this)
                .get(TeamCreateViewModel.class);

        binding.setViewModel(viewModel);

        binding.msgLayout.titleTextView.setText(R.string.be_a_team_leader_title);
        binding.msgLayout.descriptionTextView.setText(R.string.be_a_team_leader_description);

        viewModel.getShowWarningDialogEvent().observe(getViewLifecycleOwner(), this::showDialog);

        viewModel.getShowProgressDialogEvent().observe(getViewLifecycleOwner(), aVoid ->
                mProgressDialog.openDialog(getParentFragmentManager())
        );

        viewModel.getDismissProgressDialogEvent().observe(getViewLifecycleOwner(), aVoid ->
                mProgressDialog.dismiss()
        );

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_create_a_team);
        return binding.getRoot();
    }

    private void showDialog(@StringRes int resid) {
        WarningDialogFragment dialog = WarningDialogFragment.newInstance(resid);
        dialog.openDialog(getParentFragmentManager());
    }

    @Override
    public int getDescription() {
        return R.string.being_a_leader;
    }
}
