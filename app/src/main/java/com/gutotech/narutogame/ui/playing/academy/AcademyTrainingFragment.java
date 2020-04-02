package com.gutotech.narutogame.ui.playing.academy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.databinding.FragmentAcademyTrainningBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.DistributedPointsAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.data.firebase.StorageUtils;

public class AcademyTrainingFragment extends Fragment implements SectionFragment {
    private FragmentAcademyTrainningBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AcademyTrainingViewModel viewModel = new ViewModelProvider(this)
                .get(AcademyTrainingViewModel.class);

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_academy_trainning,
                container, false);
        mBinding.setLifecycleOwner(this);
        mBinding.setViewModel(viewModel);

        mBinding.msgLayout.titleTextView.setText(R.string.attribute_training_title);
        mBinding.msgLayout.descriptionTextView.setText(R.string.attribute_training_description);

        viewModel.getTrainingCompletedEvent().observe(getViewLifecycleOwner(), trainingPointsEarned ->
                showTrainingResult(R.string.training_completed,
                        getString(R.string.you_earned_ability_points, trainingPointsEarned))
        );

        viewModel.getTrainingErrorEvent().observe(getViewLifecycleOwner(), v -> {
            showTrainingResult(R.string.problem, getString(R.string.you_dont_have_chakra_for_this_training));
            Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.problem_shake);
            animation.setRepeatCount(3);
            mBinding.trainingResult.msgConstraintLayout.startAnimation(animation);
        });

        mBinding.distributedPointsRecyclerView.setHasFixedSize(true);
        DistributedPointsAdapter adapter = new DistributedPointsAdapter(
                getContext(), viewModel);
        adapter.setDistributedPoints(CharOn.character.getAttributes().getDistributedPoints());
        mBinding.distributedPointsRecyclerView.setAdapter(adapter);

        viewModel.getUpdateDistributedPointsEvent().observe(getViewLifecycleOwner(), aVoid ->
                adapter.setDistributedPoints(CharOn.character.getAttributes().getDistributedPoints())
        );

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_attribute_training);

        return mBinding.getRoot();
    }

    private void showTrainingResult(@StringRes int titleId, String description) {
        StorageUtils.downloadProfileForMsg(getContext(), mBinding.trainingResult.profileImageView);
        mBinding.trainingResult.titleTextView.setText(titleId);
        mBinding.trainingResult.descriptionTextView.setText(description);
        mBinding.trainingResult.msgConstraintLayout.setVisibility(View.VISIBLE);

        mBinding.scrollView.post(() ->
                mBinding.scrollView.smoothScrollTo(0, mBinding.trainingResult.getRoot().getTop()));
    }

    @Override
    public int getDescription() {
        return R.string.attribute_training;
    }
}
