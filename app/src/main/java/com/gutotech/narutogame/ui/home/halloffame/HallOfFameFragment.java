package com.gutotech.narutogame.ui.home.halloffame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.ads.AdRequest;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentHallOfFameBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.HallOfFameAdapter;
import com.gutotech.narutogame.ui.adapter.RoundsAdapter;
import com.gutotech.narutogame.utils.FragmentUtils;

public class HallOfFameFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentHallOfFameBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_hall_of_fame, container, false);

        HallOfFameViewModel viewModel = new ViewModelProvider(this)
                .get(HallOfFameViewModel.class);
        binding.setViewModel(viewModel);

        RoundsAdapter roundsAdapter = new RoundsAdapter(viewModel);
        binding.roundsRecyclerView.setHasFixedSize(true);
        binding.roundsRecyclerView.setAdapter(roundsAdapter);
        viewModel.getRounds().observe(getViewLifecycleOwner(), roundsAdapter::setRounds);

        HallOfFameAdapter hallOfFameAdapter = new HallOfFameAdapter(getContext());
        binding.kagesRecyclerView.setHasFixedSize(true);
        binding.kagesRecyclerView.setAdapter(hallOfFameAdapter);
        viewModel.getKages().observe(getViewLifecycleOwner(), hallOfFameAdapter::setKages);

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_hall_of_fame);

        binding.adView.loadAd(new AdRequest.Builder().build());

        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.hall_da_fama;
    }
}
