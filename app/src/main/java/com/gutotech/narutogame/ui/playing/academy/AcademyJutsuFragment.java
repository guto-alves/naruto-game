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
import com.gutotech.narutogame.databinding.FragmentAcademyJutsuBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.JutsusLearnAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;

public class AcademyJutsuFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AcademyJutsuViewModel viewModel = ViewModelProviders.of(this)
                .get(AcademyJutsuViewModel.class);

        FragmentAcademyJutsuBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_academy_jutsu, container, false);
        binding.setViewModel(viewModel);

        binding.msgConstraint2.setVisibility(View.GONE);

        binding.jutsusRecyclerView.setHasFixedSize(true);
        JutsusLearnAdapter adapter = new JutsusLearnAdapter(getActivity());
        binding.jutsusRecyclerView.setAdapter(adapter);

        viewModel.getJutsus().observe(this, adapter::setJutsusList);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_learned_jutsus);
        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.leaned_jutsus;
    }
}
