package com.gutotech.narutogame.fragment.personagemlogado.ranking;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.adapter.RankingNinjasRecyclerAdapter;
import com.gutotech.narutogame.config.ConfigFirebase;
import com.gutotech.narutogame.model.Graduacao;
import com.gutotech.narutogame.model.Personagem;

import java.util.ArrayList;
import java.util.List;

public class RankNinjasFragment extends Fragment {
    private List<Personagem> ninjasResult = new ArrayList<>();
    private RankingNinjasRecyclerAdapter adapter;

    private DatabaseReference ninjasReference;
    private ValueEventListener valueEventListenerNinjas;

    public RankNinjasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rank_ninjas, container, false);

        // Graduações Spinner
        Spinner graducaoSpinner = view.findViewById(R.id.graduacaoSpinner);
        ArrayList<String> graduacoes = new ArrayList<>();
        graduacoes.add("Geral");
        graduacoes.add(Graduacao.getGraducao(0));
        graduacoes.add(Graduacao.getGraducao(1));
        graduacoes.add(Graduacao.getGraducao(2));
        graduacoes.add(Graduacao.getGraducao(3));
        graduacoes.add(Graduacao.getGraducao(4));
        graduacoes.add(Graduacao.getGraducao(5));
        graduacoes.add(Graduacao.getGraducao(6));
        ArrayAdapter<String> arrayAdapterGraduacoes = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, graduacoes);
        arrayAdapterGraduacoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        graducaoSpinner.setAdapter(arrayAdapterGraduacoes);

        // Online Spinner
        Spinner onlineSpinner = view.findViewById(R.id.onlineSpinner);
        ArrayList<String> onlineArray = new ArrayList<>();
        onlineArray.add("Todos");
        onlineArray.add("Online");
        ArrayAdapter<String> arrayAdapterOnline = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, onlineArray);
        arrayAdapterOnline.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        onlineSpinner.setAdapter(arrayAdapterOnline);

        Button filtrarButton = view.findViewById(R.id.filtrarButton);
        filtrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        RecyclerView rankingNinjasRecyclerView = view.findViewById(R.id.rankNinjasRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rankingNinjasRecyclerView.setLayoutManager(layoutManager);
        rankingNinjasRecyclerView.setHasFixedSize(true);
        adapter = new RankingNinjasRecyclerAdapter(getActivity(), ninjasResult);
        rankingNinjasRecyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        recuperarNinjas();
    }

    private void recuperarNinjas() {
        ninjasReference = ConfigFirebase.getDatabase().child("personagem");

        valueEventListenerNinjas = ninjasReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ninjasResult.clear();

                for (DataSnapshot data : dataSnapshot.getChildren())
                    ninjasResult.add(data.getValue(Personagem.class));

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        ninjasReference.removeEventListener(valueEventListenerNinjas);
    }
}
