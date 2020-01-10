package com.gutotech.narutogame.ui.onlinecharacter.academia;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.adapter.GraduacoesRecyclerAdapter;

public class GraduacoesFragment extends Fragment {

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

        return view;
    }

}
