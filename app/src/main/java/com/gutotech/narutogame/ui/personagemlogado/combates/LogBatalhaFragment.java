package com.gutotech.narutogame.ui.personagemlogado.combates;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;

public class LogBatalhaFragment extends Fragment {

    public LogBatalhaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_log_batalha, container, false);
    }

}
