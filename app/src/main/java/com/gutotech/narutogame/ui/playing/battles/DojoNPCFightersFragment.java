package com.gutotech.narutogame.ui.playing.battles;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentDojoNpcFightersBinding;
import com.gutotech.narutogame.data.model.CharOn;

public class DojoNPCFightersFragment extends Fragment {

    public DojoNPCFightersFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDojoNpcFightersBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_dojo_npc_fighters, container, false);

        DojoNpcFightersViewModel viewModel = ViewModelProviders.of(this)
                .get(DojoNpcFightersViewModel.class);

        binding.setViewModel(viewModel);

        binding.npcDailyCombatProgressBar.setMax(DojoNpcFightersViewModel.MAX_DAILY_COMBAT);
        binding.npcDailyCombatProgressBar.setProgress(CharOn.character.getNpcDailyCombat());
        binding.npcDailyCombatTextView.setText(getString(R.string.npc_daily_combat,
                CharOn.character.getNpcDailyCombat()));

        viewModel.init();

        binding.fightersLinearLayout.setVisibility(View.GONE);

        viewModel.getShowProgressBar().observe(this, aVoid ->
                binding.statusProgressBar.setVisibility(View.VISIBLE));

        viewModel.getShowStatusEvent().observe(this, resId -> {
            binding.statusTextView.setText(resId);
            binding.statusTextView.setVisibility(View.VISIBLE);
            binding.statusProgressBar.setVisibility(View.GONE);
        });

        viewModel.getShowFightersEvent().observe(this, npc -> {
            binding.fightersLinearLayout.setVisibility(View.VISIBLE);
            binding.statusTextView.setVisibility(View.GONE);
            binding.statusProgressBar.setVisibility(View.GONE);
        });

        return binding.getRoot();
    }
}
