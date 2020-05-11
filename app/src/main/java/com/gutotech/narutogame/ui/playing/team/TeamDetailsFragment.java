package com.gutotech.narutogame.ui.playing.team;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.databinding.FragmentTeamDetailsBinding;
import com.gutotech.narutogame.ui.QuestionDialogFragment;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.TeamMembersAdapter;
import com.gutotech.narutogame.ui.adapter.TeamRequestersAdapter;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.data.firebase.StorageUtils;
import com.gutotech.narutogame.utils.SoundUtil;

import es.dmoral.toasty.Toasty;

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

        mViewModel = new ViewModelProvider(this).get(TeamDetailsViewModel.class);

        mViewModel.getTeam().observe(getViewLifecycleOwner(), team -> {
            if (team.getLeaderId().equals(CharOn.character.getId())) {
                binding.changeImageLinearLayout.setVisibility(View.VISIBLE);
            }
            if (TextUtils.isEmpty(team.getImage())) {
                binding.teamImageView.setBackgroundResource(R.drawable.layout_foto_equipe);
                binding.removeImageButton.setVisibility(View.GONE);
            } else {
                StorageUtils.downloadTeamImage(getContext(), binding.teamImageView, team.getImage());
                binding.removeImageButton.setVisibility(View.VISIBLE);
            }

            binding.teamNameTextView.setText(getString(R.string.team_members, team.getName()));
            binding.levelTextView.setText(String.valueOf(team.getLevel()));
            binding.expTextView.setText(getString(
                    R.string.team_exp_progress, team.getCurrentExp(), team.getMaxExp()));
            binding.expProgressBar.setMax(team.getMaxExp());
            binding.expProgressBar.setProgress(team.getCurrentExp());
        });

        binding.setViewModel(mViewModel);

        TeamMembersAdapter membersAdapter = new TeamMembersAdapter(getContext(), mViewModel);
        binding.membersRecyclerView.setHasFixedSize(true);
        binding.membersRecyclerView.setAdapter(membersAdapter);
        mViewModel.getMembers().observe(getViewLifecycleOwner(),
                members -> {
                    String leaderId = mViewModel.getTeam().getValue().getLeaderId();
                    if (leaderId.equals(CharOn.character.getId())) {
                        if (members.size() == 1) {
                            binding.deleteTeamButton.setVisibility(View.VISIBLE);
                        } else {
                            binding.deleteTeamButton.setVisibility(View.GONE);
                        }

                        binding.requestersConstraintLayout.setVisibility(View.VISIBLE);
                    } else {
                        binding.leaveTeamButton.setVisibility(View.VISIBLE);
                    }

                    membersAdapter.setMembers(members, leaderId);
                });

        binding.requestersRecyclerView.setHasFixedSize(true);
        TeamRequestersAdapter requestersAdapter = new TeamRequestersAdapter(
                getContext(), mViewModel);
        binding.requestersRecyclerView.setAdapter(requestersAdapter);
        mViewModel.getRequesters().observe(getViewLifecycleOwner(),
                requestersAdapter::setRequesters);

        mViewModel.getShowQuestionDialogEvent().observe(getViewLifecycleOwner(), aVoid -> {
            QuestionDialogFragment questionDialogFragment = QuestionDialogFragment.newInstance(
                    this, R.string.question_leave_the_team);
            questionDialogFragment.openDialog(getParentFragmentManager());
            SoundUtil.play(requireContext(), R.raw.attention2);
        });

        binding.changeImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivityForResult(intent, 200);
            }
        });

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_team);

        binding.adView.loadAd(new AdRequest.Builder().build());

        return binding.getRoot();
    }

    @Override
    public void onPositiveClick() {
        mViewModel.leaveTeam(CharOn.character.getId());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            Bitmap bitmap = null;

            try {
                if (requestCode == 200) {
                    Uri uri = data.getData();

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        bitmap = ImageDecoder.decodeBitmap(
                                ImageDecoder.createSource(
                                        getActivity().getContentResolver(), uri
                                ));
                    } else {
                        bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                    }
                }

                if (bitmap != null) {
                    StorageUtils.uploadTeamImage(bitmap, mViewModel::setTeamImage,
                            exception ->
                                    Toasty.error(getActivity(),
                                            R.string.error_uploading_image,
                                            Toasty.LENGTH_SHORT)
                                            .show()
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getDescription() {
        return R.string.details;
    }
}
