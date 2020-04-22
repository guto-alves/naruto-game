package com.gutotech.narutogame.ui.playing.academy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Enhancement;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.databinding.DialogEnhanceJutsuBinding;
import com.gutotech.narutogame.ui.adapter.EnhancementsAdapter;
import com.gutotech.narutogame.utils.SoundUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EnhanceJutsuDialogFragment extends DialogFragment {

    public interface EnhancementDialogListener extends Serializable {
        void onUpgradeClick(Enhancement enhancement);
    }

    public static EnhanceJutsuDialogFragment getInstance(Jutsu jutsu, EnhancementDialogListener listener) {
        Bundle args = new Bundle();
        args.putSerializable("jutsu", jutsu);
        args.putSerializable("listener", listener);

        EnhanceJutsuDialogFragment dialog = new EnhanceJutsuDialogFragment();
        dialog.setArguments(args);
        return dialog;
    }

    private Enhancement mEnhancementSelected;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        DialogEnhanceJutsuBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.dialog_enhance_jutsu, container, false);

        Jutsu jutsu = (Jutsu) getArguments().getSerializable("jutsu");
        binding.setJutsu(jutsu);

        binding.enhancementsRecyclerView.setHasFixedSize(true);
        EnhancementsAdapter adapter = new EnhancementsAdapter(getContext(), enhancement -> {
            binding.setEnhancement(enhancement);
            mEnhancementSelected = enhancement;
        });
        binding.enhancementsRecyclerView.setAdapter(adapter);

        List<Enhancement> enhancements = new ArrayList<>();
        if (jutsu.isBuffOrDebuff()) {
            if (jutsu.getJutsuInfo().type == Jutsu.Type.BUFF) {
                if (jutsu.getClasse() == Classe.NIN || jutsu.getClasse() == Classe.GEN) {
                    enhancements.add(new Enhancement(R.drawable.layout_enhancement_kunai_energia_up,
                            2, 0, 0, 0, 0));
                } else {
                    enhancements.add(new Enhancement(R.drawable.layout_enhancements_kunai_up,
                            2, 0, 0, 0, 0));
                }

                enhancements.add(new Enhancement(R.drawable.layout_enhancements_shield_up,
                        0, 2, 0, 0, 0));
                enhancements.add(new Enhancement(R.drawable.layout_enhancement_acc_up,
                        0, 0, 2, 0, 0));
            } else { // DEBUFF
                if (jutsu.getClasse() == Classe.NIN || jutsu.getClasse() == Classe.GEN) {
                    enhancements.add(new Enhancement(R.drawable.layout_enhancement_kunai_energia_up,
                            -2, 0, 0, 0, 0));
                } else {
                    enhancements.add(new Enhancement(R.drawable.layout_enhancements_kunai_up,
                            -2, 0, 0, 0, 0));
                }

                enhancements.add(new Enhancement(R.drawable.layout_enhancements_shield_up,
                        0, -2, 0, 0, 0));
                enhancements.add(new Enhancement(R.drawable.layout_enhancement_acc_up,
                        0, 0, -2, 0, 0));
            }
        } else {
            binding.defTableRow.setVisibility(View.GONE);
            if (jutsu.getClasse() == Classe.NIN || jutsu.getClasse() == Classe.GEN) {
                binding.atkTaiBukTableRow.setVisibility(View.GONE);
                enhancements.add(
                        new Enhancement(R.drawable.layout_enhancements_nin_gen_up,
                                5, 0, 0, 0, 0)
                );
            } else {
                binding.atkNinGenTableRow.setVisibility(View.GONE);
                enhancements.add(
                        new Enhancement(R.drawable.layout_enhancements_tai_buk_up,
                                5, 0, 0, 0, 0)
                );
            }

            enhancements.add(new Enhancement(R.drawable.layout_enhancements_acc_down_up,
                    0, 0, -2, 0, 0));
        }

        enhancements.add(new Enhancement(R.drawable.layout_enhancements_chakra_down_up,
                0, 0, 0, -10, 0));
        enhancements.add(new Enhancement(R.drawable.layout_enhancements_stamina_down_up,
                0, 0, 0, 0, -10));

        adapter.setEnhancements(enhancements);
        mEnhancementSelected = enhancements.get(0);
        binding.setEnhancement(mEnhancementSelected);

        binding.upgradeButton.setOnClickListener(v -> {
            if (mEnhancementSelected == null) {
                mEnhancementSelected = adapter.getEnhancements().get(0);
            }

            SoundUtil.play(getContext(), R.raw.aim);
            ((EnhancementDialogListener) getArguments().getSerializable("listener"))
                    .onUpgradeClick(mEnhancementSelected);

            dismiss();
        });

        return binding.getRoot();
    }
}
