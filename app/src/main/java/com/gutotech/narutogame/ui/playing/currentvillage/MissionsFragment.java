package com.gutotech.narutogame.ui.playing.currentvillage;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentMissionsBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtil;

public class MissionsFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMissionsBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_missions, container, false);

        MissionsViewModel viewModel = new ViewModelProvider(this)
                .get(MissionsViewModel.class);

        binding.setViewModel(viewModel);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_missions);

        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.missions;
    }
}
