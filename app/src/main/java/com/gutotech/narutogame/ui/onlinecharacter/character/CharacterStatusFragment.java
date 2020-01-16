package com.gutotech.narutogame.ui.onlinecharacter.character;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Atributos;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.CombatOverview;
import com.gutotech.narutogame.data.model.ResumeOfMissions;
import com.gutotech.narutogame.data.model.PersonagemOn;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtil;

public class CharacterStatusFragment extends Fragment implements SectionFragment {
    private Character character;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personagem_status, container, false);

        character = PersonagemOn.character;

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

//        carregarResumos();

        return view;
    }

    private void carregarResumos() {
        CombatOverview resumoCombates = character.getCombatOverview();
        ResumeOfMissions resumoMissoes = character.getResumeOfMissions();

        vitNPCTextView.setText(String.valueOf(resumoCombates.getWinsNpc()));
        vitDojoTextView.setText(String.valueOf(resumoCombates.getWinsDojoPvp()));
        vitMapaTextView.setText(String.valueOf(resumoCombates.getWinsMapPvp()));
        vit4x4TextView.setText(String.valueOf(resumoCombates.getWins4x4()));

        derNPCTextView.setText(String.valueOf(resumoCombates.getLossesNpc()));
        derDojoTextView.setText(String.valueOf(resumoCombates.getLossesDojoPvp()));
        derMapaTextView.setText(String.valueOf(resumoCombates.getLossesMapPvp()));
        der4x4TextView.setText(String.valueOf(resumoCombates.getLosses4x4()));

        empNPC.setText(String.valueOf(resumoCombates.getDrawsNpc()));
        empPVP.setText(String.valueOf(resumoCombates.getDrawsPvp()));

        rankSTextView.setText(String.valueOf(resumoMissoes.getRankS()));
        rankATextView.setText(String.valueOf(resumoMissoes.getRankA()));
        rankBTextView.setText(String.valueOf(resumoMissoes.getRankB()));
        rankCTextView.setText(String.valueOf(resumoMissoes.getRankC()));
        rankDTextView.setText(String.valueOf(resumoMissoes.getRankD()));
        tarefasTextView.setText(String.valueOf(resumoMissoes.getTasks()));

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_character_status);
    }

    private void carregarAtribuitos() {
//        Atributos atributos = character.getAtributos();
//        Formulas formulas = character.getAtributos().getFormulas();

    }

    private void carregarFormulas() {

    }

    @Override
    public int getDescription() {
        return R.string.status;
    }
}
