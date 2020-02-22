package com.gutotech.narutogame.ui.playing.ranking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentRankNinjasBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.RankingNinjasAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;

public class RankNinjasFragment extends Fragment implements SectionFragment {

    public RankNinjasFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentRankNinjasBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_rank_ninjas, container, false);

        RankNinjasViewModel viewModel = ViewModelProviders.of(this)
                .get(RankNinjasViewModel.class);

        binding.setViewModel(viewModel);

//        // Graduações Spinner
//        Spinner graducaoSpinner = view.findViewById(R.id.graduacaoSpinner);
//        ArrayList<String> graduacoes = new ArrayList<>();
//        graduacoes.add("Geral");
//        graduacoes.add(Graduacao.getGraducao(0));
//        graduacoes.add(Graduacao.getGraducao(1));
//        graduacoes.add(Graduacao.getGraducao(2));
//        graduacoes.add(Graduacao.getGraducao(3));
//        graduacoes.add(Graduacao.getGraducao(4));
//        graduacoes.add(Graduacao.getGraducao(5));
//        graduacoes.add(Graduacao.getGraducao(6));
//        ArrayAdapter<String> arrayAdapterGraduacoes = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, graduacoes);
//        arrayAdapterGraduacoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        graducaoSpinner.setAdapter(arrayAdapterGraduacoes);

        binding.rankNinjasRecyclerView.setHasFixedSize(true);
        RankingNinjasAdapter adapter = new RankingNinjasAdapter(getContext());
        binding.rankNinjasRecyclerView.setAdapter(adapter);

        viewModel.getNinjas().observe(this, adapter::setNinjas);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_ninjas_ranking);

        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.ninjas;
    }
}
