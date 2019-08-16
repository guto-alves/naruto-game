package com.gutotech.narutogame.fragment.personagemlogado.academia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.adapter.PontosDistribuitosRecyclerAdapter;
import com.gutotech.narutogame.model.Atributo;
import com.gutotech.narutogame.myinterface.MyListener;
import com.gutotech.narutogame.publicentities.PersonagemOn;

import java.util.ArrayList;
import java.util.List;

public class AcademiaTreinamentoFragment extends Fragment implements MyListener {
    private PontosDistribuitosRecyclerAdapter pontosDistribuitosAdapter;

    public AcademiaTreinamentoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_academia_treinamento, container, false);

        Spinner qtdTreinoSpinner = view.findViewById(R.id.qtdTreinoSpinner);

        ArrayList<String> treinos = new ArrayList<>();
        for (int i = 0; i < 15; i++)
            treinos.add(++i + "");

        treinos.add(20 + "");
        treinos.add(25 + "");
        treinos.add(30 + "");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, treinos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qtdTreinoSpinner.setAdapter(adapter);
        qtdTreinoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        RecyclerView pontosDistribuidosRecyclerView = view.findViewById(R.id.pontosDistribuidosRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        pontosDistribuidosRecyclerView.setLayoutManager(layoutManager);
        pontosDistribuidosRecyclerView.setHasFixedSize(true);
        addListener();
        pontosDistribuitosAdapter = new PontosDistribuitosRecyclerAdapter(getActivity());
        pontosDistribuidosRecyclerView.setAdapter(pontosDistribuitosAdapter);
        return view;
    }

    private void addListener() {
        List<Atributo> atributosDistribuidos = PersonagemOn.personagem.getAtributosDistribuitos();

        final int SIZE = atributosDistribuidos.size();

        for (int i = 0; i < SIZE; i++)
            atributosDistribuidos.get(i).setListener(this);
    }

    @Override
    public void callback(int position) {
        Atributo atributo = PersonagemOn.personagem.getAtributosDistribuitos().get(position);

        atributo.setQuantidade(atributo.getQuantidade() + 1);
        PersonagemOn.personagem.salvar();

        pontosDistribuitosAdapter.notifyDataSetChanged();
    }
}
