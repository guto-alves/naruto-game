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
import com.gutotech.narutogame.data.model.MissionInfo;
import com.gutotech.narutogame.data.repository.MissionRepository;
import com.gutotech.narutogame.databinding.FragmentMissionsWaitingBinding;
import com.gutotech.narutogame.ui.QuestionDialog;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtil;

public class MissionsWaitingFragment extends Fragment implements SectionFragment {
    private MissionsWaitingViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMissionsWaitingBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_missions_waiting, container, false);

        MissionRepository.getInstance().getMissionTime(mission -> {
            mViewModel = new ViewModelProvider(this, new MissionsWaitingViewModelFactory(mission))
                    .get(MissionsWaitingViewModel.class);
            binding.setViewModel(mViewModel);

            MissionInfo info = mission.missionInfo();
            binding.titleTextView.setText(info.title);
            binding.descriptionTextView.setText(info.description);
            binding.descriptionTextView2.setText(info.msgFinished);

            mViewModel.getShowMissionCompletedMsg().observe(getViewLifecycleOwner(), rewards -> {
                binding.msgConstraintLayout.setVisibility(View.GONE);
                binding.cancelButton.setVisibility(View.GONE);
                binding.rewardExpTextView.setText(String.valueOf(rewards.get(0)));
                binding.rewardRyousTextView.setText(getString(R.string.ry, rewards.get(1)));
                binding.missionCompletedLayout.setVisibility(View.VISIBLE);
            });
        });

        binding.cancelButton.setOnClickListener(v -> showQuestionDialog());

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_mission_status);

        return binding.getRoot();
    }

    private void showQuestionDialog() {
        QuestionDialog dialog = new QuestionDialog(getString(R.string.question_cancel_mission));
        dialog.setOnOkButton(v -> mViewModel.onCancelButtonPressed());
        dialog.show(getParentFragmentManager(), "QuestionDialog");
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
