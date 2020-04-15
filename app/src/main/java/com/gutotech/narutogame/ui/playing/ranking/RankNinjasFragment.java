package com.gutotech.narutogame.ui.playing.ranking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentRankNinjasBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.RankingNinjasAdapter;
import com.gutotech.narutogame.utils.FragmentUtils;

public class RankNinjasFragment extends Fragment implements SectionFragment {

    public RankNinjasFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentRankNinjasBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_rank_ninjas, container, false);

        RankNinjasViewModel viewModel = new ViewModelProvider(this)
                .get(RankNinjasViewModel.class);

        binding.setViewModel(viewModel);

        binding.rankNinjasRecyclerView.setHasFixedSize(true);
        RankingNinjasAdapter adapter = new RankingNinjasAdapter(getContext());
        binding.rankNinjasRecyclerView.setAdapter(adapter);

        viewModel.getNinjas().observe(getViewLifecycleOwner(), adapter::setNinjas);

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_ninjas_ranking);

        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.ninjas;
    }
}
