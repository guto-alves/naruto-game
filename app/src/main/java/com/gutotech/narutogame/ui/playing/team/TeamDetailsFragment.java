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
import com.gutotech.narutogame.ui.QuestionDialogFragment;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.TeamMembersAdapter;
import com.gutotech.narutogame.ui.adapter.TeamRequestersAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;

public class TeamDetailsFragment extends Fragment implements SectionFragment,
        QuestionDialogFragment.QuestionDialogListener {
    private TeamDetailsViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTeamDetailsBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_team_details, container, false);

        binding.teamInfoLayout.titleTextView.setText(R.string.team_information);
        binding.teamInfoLayout.descriptionTextView.setText(R.string.team_info_description);

        TeamRepository.getInstance().getTeam(CharOn.character.getTeam(), team -> {
            mViewModel = new ViewModelProvider(
                    this, new TeamDetailsViewModelFactory(team))
                    .get(TeamDetailsViewModel.class);

            binding.setViewModel(mViewModel);

            TeamMembersAdapter membersAdapter = new TeamMembersAdapter(getContext(), mViewModel);
            binding.membersRecyclerView.setHasFixedSize(true);
            binding.membersRecyclerView.setAdapter(membersAdapter);
            mViewModel.getMembers().observe(getViewLifecycleOwner(), membersAdapter::setMembers);

            if (team.getMemberIds().get(0).equals(CharOn.character.getId())) {
                if (team.getMemberIds().size() == 1) {
                    binding.deleteTeamButton.setVisibility(View.VISIBLE);
                }

                binding.requestersConstraintLayout.setVisibility(View.VISIBLE);

                TeamRequestersAdapter requestersAdapter = new TeamRequestersAdapter(
                        getContext(), mViewModel);
                binding.requestersRecyclerView.setHasFixedSize(true);
                binding.requestersRecyclerView.setAdapter(requestersAdapter);
                mViewModel.getRequesters().observe(getViewLifecycleOwner(),
                        requestersAdapter::setRequesters);
            } else {
                binding.leaveTeamButton.setVisibility(View.VISIBLE);
            }

            mViewModel.getShowQuestionDialogEvent().observe(getViewLifecycleOwner(), aVoid -> {
                QuestionDialogFragment questionDialogFragment = QuestionDialogFragment.newInstance(
                        this, R.string.question_leave_the_team);
                questionDialogFragment.openDialog(getParentFragmentManager());
            });

            mViewModel.loadMembers();
            mViewModel.loadRequesters();
        });

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_team);

        return binding.getRoot();
    }

    @Override
    public void onPositiveClick() {
        mViewModel.leaveTeam(CharOn.character.getId());
    }

    @Override
    public void onCancelClick() {
    }

    @Override
    public int getDescription() {
        return R.string.details;
    }
}
