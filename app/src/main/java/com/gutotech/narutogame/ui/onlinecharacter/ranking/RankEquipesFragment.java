package com.gutotech.narutogame.ui.onlinecharacter.ranking;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.SectionFragment;


public class RankEquipesFragment extends Fragment implements SectionFragment {


    public RankEquipesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the l/**
        // * A simple {@link Fragment} subclass.
        // */ayout for this fragment
        return inflater.inflate(R.layout.fragment_rank_equipes, container, false);
    }

    @Override
    public int getDescription() {
        return 0;
    }
}
