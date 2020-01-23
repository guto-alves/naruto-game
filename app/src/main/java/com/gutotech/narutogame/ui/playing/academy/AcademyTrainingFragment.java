package com.gutotech.narutogame.ui.playing.academy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.databinding.FragmentAcademyTrainningBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.DistributedPointsRecyclerAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.StorageUtil;

public class AcademyTrainingFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AcademyTrainingViewModel viewModel = ViewModelProviders.of(this)
                .get(AcademyTrainingViewModel.class);

        FragmentAcademyTrainningBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_academy_trainning, container, false);
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);

        binding.msgLayout.titleTextView.setText(R.string.attribute_training_title);
        binding.msgLayout.descriptionTextView.setText(R.string.attribute_training_description);
        StorageUtil.downloadProfileForMsg(getContext(), binding.msgLayout.profileImageView,
                CharOn.character.getVillage().id);

        binding.trainingResult.msgConstraintLayout.setVisibility(View.GONE);

        viewModel.trainingCompletedEvent.observe(this, trainingPointsEarned -> {
            StorageUtil.downloadProfileForMsg(getContext(), binding.trainingResult.profileImageView,
                    CharOn.character.getVillage().id);
            binding.trainingResult.titleTextView.setText(R.string.training_completed);
            binding.trainingResult.descriptionTextView.setText(
                    getString(R.string.you_earned_ability_points, trainingPointsEarned));
            binding.trainingResult.msgConstraintLayout.setVisibility(View.VISIBLE);
        });
        viewModel.trainingErrorEvent.observe(this, v -> {
            StorageUtil.downloadProfileForMsg(getContext(), binding.trainingResult.profileImageView,
                    CharOn.character.getVillage().id);
            binding.trainingResult.titleTextView.setText(R.string.problem);
            binding.trainingResult.descriptionTextView.setText(
                    R.string.you_dont_have_chakra_for_this_training);
            binding.trainingResult.msgConstraintLayout.setVisibility(View.VISIBLE);
        });

        binding.limitOfTrainingProgressBar.setMax(CharOn.character.getGraduation().dailyTrainingLimit);

        binding.distributedPointsRecyclerView.setHasFixedSize(true);
        DistributedPointsRecyclerAdapter adapter = new DistributedPointsRecyclerAdapter(
                getContext(), viewModel);
        adapter.setDistributedPoints(CharOn.character.getAttributes().getDistributedPoints());
        binding.distributedPointsRecyclerView.setAdapter(adapter);

        viewModel.getUpdateDistributedPointsEvent().observe(this, aVoid ->
                adapter.setDistributedPoints(CharOn.character.getAttributes().getDistributedPoints())
        );

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_attribute_training);

        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.attribute_training;
    }
}
