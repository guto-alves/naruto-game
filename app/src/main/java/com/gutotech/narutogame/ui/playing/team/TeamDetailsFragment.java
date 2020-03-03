package com.gutotech.narutogame.ui.playing.team;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentTeamDetailsBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtil;

public class TeamDetailsFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTeamDetailsBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_team_details, container, false);

        binding.teamInfoLayout.titleTextView.setText(R.string.team_information);
        binding.teamInfoLayout.descriptionTextView.setText(R.string.team_info_description);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_team);

        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.details;
    }
}
