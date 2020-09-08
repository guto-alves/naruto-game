package com.gutotech.narutogame.ui.playing.currentvillage;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdRequest;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentSpecialMissionsStatusBinding;
import com.gutotech.narutogame.ui.QuestionDialogFragment;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SoundUtil;

public class SpecialMissionsStatusFragment extends Fragment implements SectionFragment,
        QuestionDialogFragment.QuestionDialogListener {
    private SpecialMissionsStatusViewModel mViewModel;
    private FragmentSpecialMissionsStatusBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_special_missions_status,
                container, false);

        mBinding.cancelButton.setOnClickListener(v -> showQuestionDialog());

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_mission_status);

        mBinding.adView.loadAd(new AdRequest.Builder().build());

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SpecialMissionsStatusViewModel.class);
        mBinding.setViewModel(mViewModel);

        mViewModel.getMissionInfo().observe(getViewLifecycleOwner(), missionInfo -> {
            mBinding.titleTextView.setText(missionInfo.title);
            mBinding.descriptionTextView.setText(missionInfo.description);
            mBinding.descriptionTextView2.setText(missionInfo.msgFinished);
            mBinding.defeatedTextView.setText(getString(R.string.label_n_from_n_times,
                    mViewModel.getSpecialMission().getDefeated(),
                    mViewModel.getSpecialMission().getDefeat()));
            mBinding.defeatedProgressBar.setMax(mViewModel.getSpecialMission().getDefeat());
            mBinding.defeatedProgressBar.setProgress(mViewModel.getSpecialMission().getDefeated());
        });

        mViewModel.getShowMissionCompletedMsg().observe(getViewLifecycleOwner(), ryous -> {
            mBinding.cancelButton.setVisibility(View.GONE);
            mBinding.msgConstraintLayout.setVisibility(View.GONE);
            mBinding.rewardRyousTextView.setText(getString(R.string.ry, ryous));
            mBinding.missionCompletedLayout.setVisibility(View.VISIBLE);

            YoYo.with(Techniques.RubberBand)
                    .duration(1200)
                    .playOn(mBinding.missionCompletedLayout);

            SoundUtil.play(getContext(), R.raw.yon);
        });
    }

    private void showQuestionDialog() {
        QuestionDialogFragment.newInstance(
                getString(R.string.question_cancel_mission), this)
                .openDialog(getChildFragmentManager());
        SoundUtil.play(requireContext(), R.raw.sound_pop);
    }

    @Override
    public void onPositiveClick(int requestCode) {
        mViewModel.onCancelMissionButtonPressed();
    }

    @Override
    public int getDescription() {
        return R.string.special_mission_status;
    }
}
