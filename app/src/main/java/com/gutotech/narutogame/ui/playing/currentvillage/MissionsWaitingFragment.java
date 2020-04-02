package com.gutotech.narutogame.ui.playing.currentvillage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentMissionsWaitingBinding;
import com.gutotech.narutogame.ui.QuestionDialogFragment;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtil;

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
            mBinding.rewardExpTextView.setText(String.valueOf(rewards.get(0)));
            mBinding.rewardRyousTextView.setText(getString(R.string.ry, rewards.get(1)));
            mBinding.missionCompletedLayout.setVisibility(View.VISIBLE);
        });

        mBinding.cancelButton.setOnClickListener(v -> showQuestionDialog());

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_mission_status);

        return mBinding.getRoot();
    }

    private void showQuestionDialog() {
        QuestionDialogFragment questionDialog = QuestionDialogFragment.newInstance(
                this, R.string.question_cancel_mission);
        questionDialog.openDialog(getParentFragmentManager());
    }

    @Override
    public void onPositiveClick() {
        mViewModel.onCancelMissionButtonPressed();
    }

    @Override
    public void onCancelClick() {
    }

    @Override
    public int getDescription() {
        return R.string.mission_status;
    }
}
