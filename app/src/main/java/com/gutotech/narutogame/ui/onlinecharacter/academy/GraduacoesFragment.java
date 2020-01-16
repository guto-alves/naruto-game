package com.gutotech.narutogame.ui.onlinecharacter.academy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.GraduacoesRecyclerAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;

public class GraduacoesFragment extends Fragment implements SectionFragment {

    public GraduacoesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_graduacoes, container, false);

        RecyclerView graduacoesRecyclerView = view.findViewById(R.id.graduacoesRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        graduacoesRecyclerView.setLayoutManager(layoutManager);
        graduacoesRecyclerView.setHasFixedSize(true);
        graduacoesRecyclerView.setAdapter(new GraduacoesRecyclerAdapter(getActivity()));

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_graduations);
        return view;
    }

    @Override
    public int getDescription() {
        return R.string.grades;
    }
}
