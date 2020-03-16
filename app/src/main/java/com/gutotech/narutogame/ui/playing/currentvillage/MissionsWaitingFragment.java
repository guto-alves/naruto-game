package com.gutotech.narutogame.ui.playing.currentvillage;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.MissionInfo;
import com.gutotech.narutogame.data.repository.MissionRepository;
import com.gutotech.narutogame.databinding.FragmentMissionsWaitingBinding;
import com.gutotech.narutogame.ui.QuestionDialog;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtil;

public class MissionsWaitingFragment extends Fragment implements SectionFragment,
        QuestionDialog.OnButtonsClickListener {
    private MissionsWaitingViewModel mViewModel;
    private FragmentMissionsWaitingBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_missions_waiting,
                container, false);

        mBinding.cancelButton.setOnClickListener(v -> showQuestionDialog());

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_mission_status);

        return mBinding.getRoot();
    }

    private void showQuestionDialog() {
        QuestionDialog questionDialog = QuestionDialog.newInstance(
                R.string.question_cancel_mission);
        questionDialog.setTargetFragment(this, 300);
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
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MissionRepository.getInstance().getMissionTime(mission -> {
            mViewModel = new ViewModelProvider(this, new MissionsWaitingViewModelFactory(mission))
                    .get(MissionsWaitingViewModel.class);
            mBinding.setViewModel(mViewModel);

            MissionInfo info = mission.missionInfo();
            mBinding.titleTextView.setText(info.title);
            mBinding.descriptionTextView.setText(info.description);
            mBinding.descriptionTextView2.setText(info.msgFinished);

            mViewModel.getShowMissionCompletedMsg().observe(getViewLifecycleOwner(), rewards -> {
                mBinding.msgConstraintLayout.setVisibility(View.GONE);
                mBinding.cancelButton.setVisibility(View.GONE);
                mBinding.rewardExpTextView.setText(String.valueOf(rewards.get(0)));
                mBinding.rewardRyousTextView.setText(getString(R.string.ry, rewards.get(1)));
                mBinding.missionCompletedLayout.setVisibility(View.VISIBLE);
            });
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mViewModel != null) {
            mViewModel.init();
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        if (mViewModel != null) {
            mViewModel.stop();
        }
    }

    @Override
    public int getDescription() {
        return R.string.mission_status;
    }
}
