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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCharacterJutsusBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_character_jutsus, container, false);
        binding.setLifecycleOwner(this);

        CharacterJutsusViewModel viewModel = new ViewModelProvider(this)
                .get(CharacterJutsusViewModel.class);
        binding.setViewModel(viewModel);

        LearnedJutsusAdapter adapter = new LearnedJutsusAdapter(getContext(), viewModel);
        binding.jutsusRecyclerView.setHasFixedSize(true);
        binding.jutsusRecyclerView.setAdapter(adapter);
        viewModel.getJutsusFiltered().observe(getViewLifecycleOwner(), adapter::setJutsusList);

        viewModel.getJutsuSelected().observe(getViewLifecycleOwner(), jutsu -> {
            binding.setJutsu(jutsu);

            binding.enhancementImageView1.setOnClickListener(v -> {
                if (CharOn.character.getSkillPoints() >= 5 ||
                        jutsu.getEnhancements().containsKey(Jutsu.SLOT_1)) {
                    EnhanceJutsuDialogFragment dialog = EnhanceJutsuDialogFragment.getInstance(
                            jutsu, enhancement -> {
                                if (!jutsu.getEnhancements().containsKey(Jutsu.SLOT_1)) {
                                    CharOn.character.removeSkillPoints();
                                }

                                jutsu.activate(enhancement, Jutsu.SLOT_1);
                                int index = CharOn.character.getJutsus().indexOf(jutsu);
                                CharOn.character.getJutsus().set(index, jutsu);
                                binding.setJutsu(jutsu);
                                adapter.notifyDataSetChanged();
                            });
                    dialog.show(getParentFragmentManager(), "EnhanceJutsuDialogFragment");
                    SoundUtil.play(getContext(), R.raw.sound_pop);
                } else {
                    showWarningDialog();
                }
            });
            binding.enhancementImageView2.setOnClickListener(v -> {
                if (CharOn.character.getSkillPoints() >= 5 ||
                        jutsu.getEnhancements().containsKey(Jutsu.SLOT_2)) {
                    EnhanceJutsuDialogFragment dialog = EnhanceJutsuDialogFragment.getInstance(
                            jutsu, enhancement -> {
                                if (!jutsu.getEnhancements().containsKey(Jutsu.SLOT_2)) {
                                    CharOn.character.removeSkillPoints();
                                }

                                jutsu.activate(enhancement, Jutsu.SLOT_2);
                                int index = CharOn.character.getJutsus().indexOf(jutsu);
                                CharOn.character.getJutsus().set(index, jutsu);
                                binding.setJutsu(jutsu);
                                adapter.notifyDataSetChanged();
                            });
                    dialog.show(getParentFragmentManager(), "EnhanceJutsuDialogFragment");
                    SoundUtil.play(getContext(), R.raw.sound_pop);
                } else {
                    showWarningDialog();
                }
            });
            binding.enhancementImageView3.setOnClickListener(v -> {
                if (CharOn.character.getSkillPoints() >= 5 ||
                        jutsu.getEnhancements().containsKey(Jutsu.SLOT_3)) {
                    EnhanceJutsuDialogFragment dialog = EnhanceJutsuDialogFragment.getInstance(
                            jutsu, enhancement -> {
                                if (!jutsu.getEnhancements().containsKey(Jutsu.SLOT_3)) {
                                    CharOn.character.removeSkillPoints();
                                }

                                jutsu.activate(enhancement, Jutsu.SLOT_3);
                                int index = CharOn.character.getJutsus().indexOf(jutsu);
                                CharOn.character.getJutsus().set(index, jutsu);
                                binding.setJutsu(jutsu);
                                adapter.notifyDataSetChanged();
                            });
                    dialog.show(getParentFragmentManager(), "EnhanceJutsuDialogFragment");
                    SoundUtil.play(getContext(), R.raw.sound_pop);
                } else {
                    showWarningDialog();
                }
            });

            binding.scrollView.post(() ->
                    binding.scrollView.smoothScrollTo(0, binding.scrollView.getBottom() + 1000)
            );
        });

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_jutsu_training);
        return binding.getRoot();
    }

    private void showWarningDialog() {
        WarningDialogFragment.newInstance(R.string.you_dont_have_enough_skill_points)
                .openDialog(getParentFragmentManager());
        SoundUtil.play(getContext(), R.raw.sound_pop);
    }

    @Override
    public int getDescription() {
        return R.string.jutsu_training;
    }
}
