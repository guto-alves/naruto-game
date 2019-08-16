package com.gutotech.narutogame.fragment.personagemlogado.ranking;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.config.ConfigFirebase;
import com.gutotech.narutogame.model.Personagem;

import java.util.ArrayList;
import java.util.List;

public class RankNinjasFragment extends Fragment {
    private List<Personagem> ninjasResult = new ArrayList<>();

    public RankNinjasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rank_ninjas, container, false);

        Button filtrarButton = view.findViewById(R.id.filtrarButton);
        filtrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Spinner graducaoSpinner = view.findViewById(R.id.graduacaoSpinner);

        RecyclerView rankingNinjasRecyclerView = view.findViewById(R.id.rankNinjasRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rankingNinjasRecyclerView.setLayoutManager(layoutManager);
        rankingNinjasRecyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        recuperarNinjas();
    }

    private void recuperarNinjas() {
        DatabaseReference ninjasReference = ConfigFirebase.getDatabase().child("personagem");
    }
}
