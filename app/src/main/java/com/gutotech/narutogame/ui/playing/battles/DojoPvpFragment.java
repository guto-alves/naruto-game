package com.gutotech.narutogame.ui.playing.battles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.GraduationUtils;
import com.gutotech.narutogame.databinding.FragmentDojoPvpBinding;

public class DojoPvpFragment extends Fragment {

    public DojoPvpFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDojoPvpBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_dojo_pvp, container, false);

        if (CharOn.character.getGraduationId() == 0) {
            binding.dojoPvpWarningTextView.setText(getString(R.string.dojo_pvp_warnings,
                    getString(GraduationUtils.getName(1))));
        } else {
            binding.dojoPvpWarningTextView.setText(R.string.dojo_pvp_warnings1);
            binding.goToTheQueueButton.setVisibility(View.VISIBLE);
            binding.goToTheQueueButton.setOnClickListener(v ->
                    CharOn.character.setDojoWaitQueue(true));
        }

        DojoPvpViewModel viewModel = new ViewModelProvider(getActivity())
                .get(DojoPvpViewModel.class);

        viewModel.getTotalPlayers()
                .observe(getViewLifecycleOwner(),
                        (totalPlayers) -> {
                            binding.totalPlayersTextView.setText(getString(R.string.total_players_in_queue, totalPlayers));
                        });

        return binding.getRoot();
    }

}
