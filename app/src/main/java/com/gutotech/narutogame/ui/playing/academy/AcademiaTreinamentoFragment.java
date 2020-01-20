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

public class AcademiaTreinamentoFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AcademyTrainningViewModel viewModel = ViewModelProviders.of(this)
                .get(AcademyTrainningViewModel.class);

        FragmentAcademyTrainningBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_academy_trainning, container, false);
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);

        binding.msgLayout.titleTextView.setText(R.string.attribute_training_title);
        binding.msgLayout.descriptionTextView.setText(R.string.attribute_training_description);
        StorageUtil.downloadProfileForMsg(getContext(), binding.msgLayout.profileImageView,
                CharOn.character.getVillage().id);

        if (CharOn.character.getAttributes().getDailyTrainingPoints() ==
                CharOn.character.getGraduation().dailyTrainingLimit) {
            binding.trainButton.setEnabled(false);
        }

        binding.trainingResult.msgConstraintLayout.setVisibility(View.GONE);
        viewModel.trainingCompletedEvent.observe(this, trainingPointsEarned -> {
            binding.trainingResult.titleTextView.setText(R.string.training_completed);
            binding.trainingResult.descriptionTextView.setText(
                    getString(R.string.you_earned_ability_points, trainingPointsEarned));
        });
        viewModel.trainingErrorEvent.observe(this, v -> {
            binding.trainingResult.titleTextView.setText(R.string.problem);
            binding.trainingResult.descriptionTextView.setText(
                    R.string.you_dont_have_chakra_for_this_training);
        });

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, treinos);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.limitOfTrainingProgressBar.setMax(CharOn.character.getGraduation().dailyTrainingLimit);

        binding.distributedPointsRecyclerView.setHasFixedSize(true);
        DistributedPointsRecyclerAdapter adapter = new DistributedPointsRecyclerAdapter(getContext());
        adapter.setDistributedAttributes(CharOn.character.getAttributes().asList());
        binding.distributedPointsRecyclerView.setAdapter(adapter);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_attribute_training);

        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.attribute_training;
    }
}
