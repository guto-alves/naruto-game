package com.gutotech.narutogame.ui.playing.battles;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentDojoRandomWaitBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtils;

public class DojoRandomWaitFragment extends Fragment implements SectionFragment {

    public DojoRandomWaitFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDojoRandomWaitBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_dojo_random_wait, container, false);

        DojoRandomWaitViewModel viewModel = new ViewModelProvider(getActivity())
                .get(DojoRandomWaitViewModel.class);

        binding.setViewModel(viewModel);

        viewModel.init();

        FragmentUtils.setSectionTitle(getActivity(), R.string.looking_for_opponents);

        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.waiting_room;
    }
}
