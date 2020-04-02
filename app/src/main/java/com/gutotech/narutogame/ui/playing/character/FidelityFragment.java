package com.gutotech.narutogame.ui.playing.character;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentFidelityBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.FidelityRewardsAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;

public class FidelityFragment extends Fragment implements SectionFragment {

    public FidelityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFidelityBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_fidelity, container, false);

        binding.sectionMessage.titleTextView.setText(R.string.fidelity_rewards);
        binding.sectionMessage.descriptionTextView.setText(R.string.fidelity_rewards_description);

        FidelityViewModel viewModel = new ViewModelProvider(this).get(FidelityViewModel.class);

        FidelityRewardsAdapter adapter = new FidelityRewardsAdapter(getActivity(), viewModel);
        binding.fidelityRewardsRecyclerView.setAdapter(adapter);

        viewModel.getRewards().observe(getViewLifecycleOwner(), adapter::setRewards);

        viewModel.getUpdateFidelityRewards().observe(getViewLifecycleOwner(), aVoid ->
                adapter.notifyDataSetChanged());

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_ninja_fidelity);
        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.ninja_fidelity;
    }
}
