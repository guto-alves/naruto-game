package com.gutotech.narutogame.ui.playing.team;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.repository.TeamRepository;
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

        TeamRepository.getInstance().getTeam(CharOn.character.getTeam(), team -> {
            TeamDetailsViewModel viewModel = new ViewModelProvider(
                    this, new TeamDetailsViewModelFactory(team))
                    .get(TeamDetailsViewModel.class);

            binding.setViewModel(viewModel);
        });

     /*
       Você realmente quer sair dessa Equipe? Serão necessário 0 ryous para
       sair. Lembrando que esse jogador não poderá mais participar dessa equipe.
    */

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_team);

        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.details;
    }
}
