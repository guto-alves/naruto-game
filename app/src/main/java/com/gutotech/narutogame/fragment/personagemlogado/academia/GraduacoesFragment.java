package com.gutotech.narutogame.fragment.personagemlogado.academia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;

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


        return view;
    }

}
