package com.gutotech.narutogame.ui.playing.battles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.SectionFragment;

public class LogBatalhaFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_log_batalha, container, false);
    }

    @Override
    public int getDescription() {
        return R.string.battle_log;
    }
}
