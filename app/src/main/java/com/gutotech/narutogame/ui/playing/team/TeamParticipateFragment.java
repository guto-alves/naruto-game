package com.gutotech.narutogame.ui.playing.team;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtil;

public class TeamParticipateFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_team_participate, container, false);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_join_a_team);
        return root;
    }

    @Override
    public int getDescription() {
        return R.string.participate;
    }
}
