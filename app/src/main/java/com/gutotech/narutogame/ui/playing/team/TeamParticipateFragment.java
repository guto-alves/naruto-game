package com.gutotech.narutogame.ui.playing.team;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentTeamParticipateBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.ui.adapter.TeamsParticipateAdapter;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SoundUtil;

public class TeamParticipateFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TeamParticipateViewModel viewModel = new ViewModelProvider(this)
                .get(TeamParticipateViewModel.class);

        FragmentTeamParticipateBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_team_participate, container, false);

        binding.setViewModel(viewModel);

        binding.msgLayout.titleTextView.setText(R.string.to_be_a_member);
        binding.msgLayout.descriptionTextView.setText(R.string.to_be_a_member_description);

        binding.teamsRecyclerView.setHasFixedSize(true);
        TeamsParticipateAdapter adapter = new TeamsParticipateAdapter(getContext(), viewModel);
        binding.teamsRecyclerView.setAdapter(adapter);

        viewModel.getTeams().observe(getViewLifecycleOwner(), adapter::setTeams);

        viewModel.getShowWarningDialogEvent().observe(getViewLifecycleOwner(), resid -> {
            WarningDialogFragment warningDialogFragment = WarningDialogFragment.newInstance(
                    getContext(), resid);
            warningDialogFragment.openDialog(getParentFragmentManager());
            SoundUtil.play(getContext(), R.raw.sound_pop);
        });

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_join_a_team);

        binding.adView.loadAd(new AdRequest.Builder().build());

        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.participate;
    }
}
