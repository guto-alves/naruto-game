package com.gutotech.narutogame.ui.playing.academy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
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
    private FragmentCharacterJutsusBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_character_jutsus, container, false);
        mBinding.setLifecycleOwner(this);

        mViewModel = new ViewModelProvider(this).get(CharacterJutsusViewModel.class);
        mBinding.setViewModel(mViewModel);

        LearnedJutsusAdapter adapter = new LearnedJutsusAdapter(getContext(), mViewModel);
        mBinding.jutsusRecyclerView.setHasFixedSize(true);
        mBinding.jutsusRecyclerView.setAdapter(adapter);
        mViewModel.getJutsusFiltered().observe(getViewLifecycleOwner(), adapter::setJutsusList);

        mViewModel.getJutsuSelected().observe(getViewLifecycleOwner(), jutsu -> {
            mBinding.setJutsu(jutsu);

            mBinding.enhancementImageView1.setOnClickListener(v -> onSlotClick(jutsu, Jutsu.SLOT_1));
            mBinding.enhancementImageView2.setOnClickListener(v -> onSlotClick(jutsu, Jutsu.SLOT_2));
            mBinding.enhancementImageView3.setOnClickListener(v -> onSlotClick(jutsu, Jutsu.SLOT_3));

            mBinding.scrollView.post(() ->
                    mBinding.scrollView.smoothScrollTo(0, mBinding.scrollView.getBottom() + 1000)
            );
        });

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_jutsu_training);

        mBinding.adView.loadAd(new AdRequest.Builder().build());

        return mBinding.getRoot();
    }

    private void onSlotClick(Jutsu jutsu, String slot) {
        if (CharOn.character.getSkillPoints() >= 5 || jutsu.getEnhancements().containsKey(slot)) {
            EnhanceJutsuDialogFragment dialog = EnhanceJutsuDialogFragment.getInstance(
                    jutsu, slot, () -> {
                        mViewModel.updateJutsus();
                        mBinding.scrollView.post(() ->
                                mBinding.scrollView.smoothScrollTo(0, mBinding.scrollView.getBottom() + 1000)
                        );
                    });
            dialog.show(getParentFragmentManager(), "EnhanceJutsuDialogFragment");
            SoundUtil.play(getContext(), R.raw.sound_pop);
        } else {
            WarningDialogFragment.newInstance(getContext(), R.string.you_dont_have_enough_skill_points)
                    .openDialog(getParentFragmentManager());
            SoundUtil.play(getContext(), R.raw.attention2);
        }
    }

    @Override
    public int getDescription() {
        return R.string.jutsu_training;
    }
}
