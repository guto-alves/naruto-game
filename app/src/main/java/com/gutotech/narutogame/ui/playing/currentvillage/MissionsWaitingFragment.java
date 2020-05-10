package com.gutotech.narutogame.ui.playing.currentvillage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdRequest;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentMissionsWaitingBinding;
import com.gutotech.narutogame.ui.QuestionDialogFragment;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SoundUtil;

public class MissionsWaitingFragment extends Fragment implements SectionFragment,
        QuestionDialogFragment.QuestionDialogListener {
    private MissionsWaitingViewModel mViewModel;
    private FragmentMissionsWaitingBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_missions_waiting,
                container, false);

        mViewModel = new ViewModelProvider(this).get(MissionsWaitingViewModel.class);
        mBinding.setViewModel(mViewModel);

        mViewModel.getMissionInfo().observe(getViewLifecycleOwner(), missionInfo -> {
            mBinding.titleTextView.setText(missionInfo.title);
            mBinding.descriptionTextView.setText(missionInfo.description);
            mBinding.descriptionTextView2.setText(missionInfo.msgFinished);
        });

        mViewModel.getShowMissionCompletedMsg().observe(getViewLifecycleOwner(), rewards -> {
            mBinding.msgConstraintLayout.setVisibility(View.GONE);
            mBinding.cancelButton.setVisibility(View.GONE);
            mBinding.rewardExpTextView.setText(String.valueOf(rewards.get(1)));
            mBinding.rewardRyousTextView.setText(getString(R.string.ry, rewards.get(0)));
            mBinding.missionCompletedLayout.setVisibility(View.VISIBLE);

            YoYo.with(Techniques.RubberBand)
                    .duration(1200)
                    .playOn(mBinding.missionCompletedLayout);

            SoundUtil.play(getContext(), R.raw.yon);
        });

        mBinding.cancelButton.setOnClickListener(v -> showQuestionDialog());

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_mission_status);

        mBinding.adView.loadAd(new AdRequest.Builder().build());

        return mBinding.getRoot();
    }

    private void showQuestionDialog() {
        QuestionDialogFragment questionDialog = QuestionDialogFragment.newInstance(
                this, R.string.question_cancel_mission);
        questionDialog.openDialog(getParentFragmentManager());
        SoundUtil.play(requireContext(), R.raw.sound_pop);
    }

    @Override
    public void onPositiveClick() {
        mViewModel.onCancelMissionButtonPressed();
    }

    @Override
    public int getDescription() {
        return R.string.mission_status;
    }
}
