package com.gutotech.narutogame.ui.playing.academy;

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
import com.gutotech.narutogame.databinding.FragmentGradesBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.GraduationsAdapter;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SoundUtil;

public class GraduationsFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentGradesBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_grades, container, false);

        GraduationsViewModel viewModel = new ViewModelProvider(this)
                .get(GraduationsViewModel.class);

        binding.graduationsRecyclerView.setHasFixedSize(true);
        GraduationsAdapter adapter = new GraduationsAdapter(getActivity(),
                getChildFragmentManager(), viewModel);
        binding.graduationsRecyclerView.setAdapter(adapter);

        viewModel.getUpdateGraduationsEvent().observe(getViewLifecycleOwner(), aVoid -> {
            adapter.notifyDataSetChanged();
            SoundUtil.play(getContext(), R.raw.yon);
        });

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_graduations);

        binding.adView.loadAd(new AdRequest.Builder().build());

        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.grades;
    }
}
