package com.gutotech.narutogame.ui.playing.academy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.databinding.FragmentCharacterJutsusBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.ui.adapter.LearnedJutsusAdapter;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SoundUtil;

public class CharacterJutsusFragment extends Fragment implements SectionFragment {
    private CharacterJutsusViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCharacterJutsusBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_character_jutsus, container, false);
        binding.setLifecycleOwner(this);

        mViewModel = new ViewModelProvider(this)
                .get(CharacterJutsusViewModel.class);
        binding.setViewModel(mViewModel);

        LearnedJutsusAdapter adapter = new LearnedJutsusAdapter(getContext(), mViewModel);
        binding.jutsusRecyclerView.setHasFixedSize(true);
        binding.jutsusRecyclerView.setAdapter(adapter);
        mViewModel.getJutsusFiltered().observe(getViewLifecycleOwner(), adapter::setJutsusList);

        mViewModel.getJutsuSelected().observe(getViewLifecycleOwner(), jutsu -> {
            binding.setJutsu(jutsu);

            binding.enhancementImageView1.setOnClickListener(v -> onSlotClick(jutsu, Jutsu.SLOT_1));
            binding.enhancementImageView2.setOnClickListener(v -> onSlotClick(jutsu, Jutsu.SLOT_2));
            binding.enhancementImageView3.setOnClickListener(v -> onSlotClick(jutsu, Jutsu.SLOT_3));

            binding.scrollView.post(() ->
                    binding.scrollView.smoothScrollTo(0, binding.scrollView.getBottom() + 1000)
            );
        });

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_jutsu_training);
        return binding.getRoot();
    }

    private void onSlotClick(Jutsu jutsu, String slot) {
        if (CharOn.character.getSkillPoints() >= 5 || jutsu.getEnhancements().containsKey(slot)) {
            EnhanceJutsuDialogFragment dialog = EnhanceJutsuDialogFragment.getInstance(
                    jutsu, slot, mViewModel::updateJutsus);
            dialog.show(getParentFragmentManager(), "EnhanceJutsuDialogFragment");
            SoundUtil.play(getContext(), R.raw.sound_pop);
        } else {
            WarningDialogFragment.newInstance(R.string.you_dont_have_enough_skill_points)
                    .openDialog(getParentFragmentManager());
            SoundUtil.play(getContext(), R.raw.sound_pop);
        }
    }

    @Override
    public int getDescription() {
        return R.string.jutsu_training;
    }
}
