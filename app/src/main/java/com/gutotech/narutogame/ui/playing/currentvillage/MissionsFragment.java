package com.gutotech.narutogame.ui.playing.currentvillage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentMissionsBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.ui.adapter.MissionsAdapter;
import com.gutotech.narutogame.utils.FragmentUtils;

public class MissionsFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMissionsBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_missions, container, false);

        MissionsViewModel viewModel = new ViewModelProvider(this)
                .get(MissionsViewModel.class);

        binding.setViewModel(viewModel);

        binding.missionsRecyclerView.setHasFixedSize(true);
        MissionsAdapter adapter = new MissionsAdapter(getContext(), viewModel);
        binding.missionsRecyclerView.setAdapter(adapter);

        viewModel.getMissions().observe(getViewLifecycleOwner(), adapter::setMissions);

        viewModel.getShowWarningDialogEvent().observe(getViewLifecycleOwner(), aVoid -> {
            WarningDialogFragment warningDialog = WarningDialogFragment.newInstance(
                    getContext(), R.string.reached_the_limit_of_daily_time_missions);
            warningDialog.openDialog(getParentFragmentManager());
        });

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_missions);
        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.missions;
    }
}
