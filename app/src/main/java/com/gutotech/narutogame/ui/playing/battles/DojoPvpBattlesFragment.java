package com.gutotech.narutogame.ui.playing.battles;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.GraduationUtils;
import com.gutotech.narutogame.databinding.FragmentDojoPvpBattlesBinding;

public class DojoPvpBattlesFragment extends Fragment {

    public DojoPvpBattlesFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDojoPvpBattlesBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_dojo_pvp_battles, container, false);

        if (CharOn.character.getGraduationId() == 0) {
            binding.dojoPvpWarningTextView.setText(getString(R.string.dojo_pvp_warnings,
                    getString(GraduationUtils.getName(1))));
        } else {
            binding.dojoPvpWarningTextView.setText(R.string.dojo_pvp_warnings1);
            binding.goToTheQueueButton.setVisibility(View.VISIBLE);
            binding.goToTheQueueButton.setOnClickListener(v ->
                    CharOn.character.setDojoWaitQueue(true));
        }

        return binding.getRoot();
    }

}
