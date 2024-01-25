package com.gutotech.narutogame.ui.playing.ranking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtils;

public class RankEquipesFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_rank_equipes, container, false);

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_teams_ranking);

        return root;
    }

    @Override
    public int getDescription() {
        return R.string.teams;
    }
}
