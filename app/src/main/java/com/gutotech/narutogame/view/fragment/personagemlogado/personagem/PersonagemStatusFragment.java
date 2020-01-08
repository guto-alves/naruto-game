package com.gutotech.narutogame.view.fragment.personagemlogado.personagem;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.model.Atributos;
import com.gutotech.narutogame.model.Formulas;
import com.gutotech.narutogame.model.Personagem;
import com.gutotech.narutogame.model.ResumoCombates;
import com.gutotech.narutogame.model.ResumoMissoes;
import com.gutotech.narutogame.model.PersonagemOn;

public class PersonagemStatusFragment extends Fragment {
    private Personagem personagem;

    // Resumo combates
    private TextView vitNPCTextView;
    private TextView vitDojoTextView;
    private TextView vitMapaTextView;
    private TextView vit4x4TextView;
    private TextView derNPCTextView;
    private TextView derDojoTextView;
    private TextView derMapaTextView;
    private TextView der4x4TextView;
    private TextView empPVP;
    private TextView empNPC;

    // Resumo missões
    private TextView rankSTextView;
    private TextView rankATextView;
    private TextView rankBTextView;
    private TextView rankCTextView;
    private TextView rankDTextView;
    private TextView tarefasTextView;

    private RecyclerView atributosRecyclerView;
    private RecyclerView formulasRecyclerView;

    public PersonagemStatusFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personagem_status, container, false);

        personagem = PersonagemOn.personagem;

        // combates e missões
        vitNPCTextView = view.findViewById(R.id.vitNPCTextView);
        vitDojoTextView = view.findViewById(R.id.vitDojoTextView);
        vitMapaTextView = view.findViewById(R.id.vitMapaTextView);
        vit4x4TextView = view.findViewById(R.id.vit4x4TextView);

        derNPCTextView = view.findViewById(R.id.derNPCTextView);
        derDojoTextView = view.findViewById(R.id.derDojoTextView);
        derMapaTextView = view.findViewById(R.id.derMapaTextView);
        der4x4TextView = view.findViewById(R.id.der4x4TextView);

        empNPC = view.findViewById(R.id.empNPCTextView);
        empPVP = view.findViewById(R.id.empPVPTextView);

        rankSTextView = view.findViewById(R.id.rankSTextView);
        rankATextView = view.findViewById(R.id.rankATextView);
        rankBTextView = view.findViewById(R.id.rankBTextView);
        rankCTextView = view.findViewById(R.id.rankCTextView);
        rankDTextView = view.findViewById(R.id.rankDTextView);
        tarefasTextView = view.findViewById(R.id.tarefasTextView);

        atributosRecyclerView = view.findViewById(R.id.atributosRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        atributosRecyclerView.setLayoutManager(layoutManager);
        atributosRecyclerView.setHasFixedSize(true);
        //atributosRecyclerView.setAdapter();
        formulasRecyclerView = view.findViewById(R.id.formulasRecyclerView);

        carregarResumos();

        return view;
    }

    private void carregarResumos() {
        ResumoCombates resumoCombates = personagem.getResumoCombates();
        ResumoMissoes resumoMissoes = personagem.getResumoMissoes();

        vitNPCTextView.setText(String.valueOf(resumoCombates.getVitNPC()));
        vitDojoTextView.setText(String.valueOf(resumoCombates.getVitDojo()));
        vitMapaTextView.setText(String.valueOf(resumoCombates.getVitMapa()));
        vit4x4TextView.setText(String.valueOf(resumoCombates.getVit4x4()));

        derNPCTextView.setText(String.valueOf(resumoCombates.getDerNPC()));
        derDojoTextView.setText(String.valueOf(resumoCombates.getDerDojo()));
        derMapaTextView.setText(String.valueOf(resumoCombates.getDerMapa()));
        der4x4TextView.setText(String.valueOf(resumoCombates.getDer4x4()));

        empNPC.setText(String.valueOf(resumoCombates.getEmpNPC()));
        empPVP.setText(String.valueOf(resumoCombates.getEmpPVP()));

        rankSTextView.setText(String.valueOf(resumoMissoes.getRankS()));
        rankATextView.setText(String.valueOf(resumoMissoes.getRankA()));
        rankBTextView.setText(String.valueOf(resumoMissoes.getRankB()));
        rankCTextView.setText(String.valueOf(resumoMissoes.getRankC()));
        rankDTextView.setText(String.valueOf(resumoMissoes.getRankD()));
        tarefasTextView.setText(String.valueOf(resumoMissoes.getTarefas()));
    }

    private void carregarAtribuitos() {
        Atributos atributos = personagem.getAtributos();
        Formulas formulas = personagem.getAtributos().getFormulas();

    }

    private void carregarFormulas() {

    }
}
