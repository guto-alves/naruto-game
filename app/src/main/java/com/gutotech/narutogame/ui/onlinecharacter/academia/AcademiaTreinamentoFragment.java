package com.gutotech.narutogame.ui.onlinecharacter.academia;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.adapter.PontosDistribuitosRecyclerAdapter;
import com.gutotech.narutogame.data.model.Atributo;
import com.gutotech.narutogame.myinterface.MyListener;
import com.gutotech.narutogame.data.model.PersonagemOn;

import java.util.ArrayList;
import java.util.List;

public class AcademiaTreinamentoFragment extends Fragment implements MyListener {
    private PontosDistribuitosRecyclerAdapter pontosDistribuitosAdapter;

    private TextView gastaraChakraTextView;
    private TextView gastaraStaminaTextView;

    private TextView limeteTreinamentoSemanalTextView;
    private ProgressBar limeteTreinamentoSemanalProgressBar;

    public AcademiaTreinamentoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_academia_treinamento, container, false);

        gastaraChakraTextView = view.findViewById(R.id.gastaraChakraTextView);
        gastaraStaminaTextView = view.findViewById(R.id.gastaraStaminaTextView);

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

        Button treinarButton = view.findViewById(R.id.treinarButton);
        treinarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

//        limeteTreinamentoSemanalTextView = view.findViewById(R.id.limeteTreinamentoSemanalTextView);
//        limeteTreinamentoSemanalProgressBar = view.findViewById(R.id.limeteTreinamentoSemanalProgressBar);

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
        List<Atributo> atributosDistribuidos = PersonagemOn.character.getAtributosDistribuitos();

        final int SIZE = atributosDistribuidos.size();

        for (int i = 0; i < SIZE; i++)
            atributosDistribuidos.get(i).setListener(this);
    }

    @Override
    public void callback(int position) {
        Atributo atributo = PersonagemOn.character.getAtributosDistribuitos().get(position);

        atributo.setQuantidade(atributo.getQuantidade() + 1);
        PersonagemOn.character.salvar();

        pontosDistribuitosAdapter.notifyDataSetChanged();
    }
}
