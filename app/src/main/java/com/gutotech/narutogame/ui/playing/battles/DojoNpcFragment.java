package com.gutotech.narutogame.ui.playing.battles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.databinding.FragmentDojoNpcFightersBinding;
import com.gutotech.narutogame.ui.ProgressDialogFragment;

public class DojoNpcFragment extends Fragment {

    public DojoNpcFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDojoNpcFightersBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_dojo_npc_fighters, container, false);

        DojoNpcViewModel viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()))
                .get(DojoNpcViewModel.class);

        binding.setViewModel(viewModel);

        binding.npcDailyCombatProgressBar.setMax(DojoNpcViewModel.MAX_DAILY_COMBAT);
        binding.npcDailyCombatProgressBar.setProgress(CharOn.character.getNpcDailyCombat());
        binding.npcDailyCombatTextView.setText(getString(R.string.npc_daily_combat,
                CharOn.character.getNpcDailyCombat()));

        binding.fightersLinearLayout.setVisibility(View.GONE);

        viewModel.getShowProgressBar().observe(getViewLifecycleOwner(), aVoid ->
                binding.statusProgressBar.setVisibility(View.VISIBLE)
        );

        viewModel.getShowStatusEvent().observe(getViewLifecycleOwner(), resId -> {
            binding.statusTextView.setText(resId);
            binding.statusTextView.setVisibility(View.VISIBLE);
            binding.statusProgressBar.setVisibility(View.GONE);
        });

        viewModel.getShowFightersEvent().observe(getViewLifecycleOwner(), npc -> {
            binding.fightersLinearLayout.setVisibility(View.VISIBLE);
            binding.statusTextView.setVisibility(View.GONE);
            binding.statusProgressBar.setVisibility(View.GONE);
        });

        ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
        viewModel.getProgressDialogEvent().observe(getViewLifecycleOwner(), visible -> {
            if (visible) {
                progressDialogFragment.openDialog(getFragmentManager());
            } else {
                progressDialogFragment.dismiss();
            }
        });

        viewModel.init();

        YoYo.with(Techniques.RubberBand)
                .duration(2000)
                .repeat(YoYo.INFINITE)
                .playOn(binding.vsImageView);

        return binding.getRoot();
    }

}
