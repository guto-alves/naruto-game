package com.gutotech.narutogame.fragment.personagemlogado.personagem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

    // Atributos
    private TextView taijutsu;
    private TextView bukijutsu;
    private TextView ninjutsu;
    private TextView genjutsu;
    private TextView forca;
    private TextView agilidade;
    private TextView inteligencia;
    private TextView selo;
    private TextView resistencia;
    private TextView energia;

    // Fórmulas
    private TextView vida;
    private TextView chakra;
    private TextView stamina;
    private TextView atkTaiBuki;
    private TextView atkNinGen;
    private TextView defTaiBuki;
    private TextView defNinGen;
    private TextView precisao;
    private TextView concentracao;
    private TextView percepcao;
    private TextView conviccao;
    private TextView esquiva;
    private TextView determinacao;

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

        // atributos e fórmulas
        taijutsu = view.findViewById(R.id.taiTextView);
        bukijutsu = view.findViewById(R.id.bukTextView);
        ninjutsu = view.findViewById(R.id.ninTextView);
        genjutsu = view.findViewById(R.id.genTextView);
        forca = view.findViewById(R.id.forcTextView);
        agilidade = view.findViewById(R.id.agiTextView);
        inteligencia = view.findViewById(R.id.inteTextView);
        selo = view.findViewById(R.id.seloTextView);
        resistencia = view.findViewById(R.id.resTextView);
        energia = view.findViewById(R.id.eneTextView);

        vida = view.findViewById(R.id.hpTextView);
        chakra = view.findViewById(R.id.chakTextView);
        stamina = view.findViewById(R.id.staTextView);
        atkTaiBuki = view.findViewById(R.id.atkTaiBukTextView);
        atkNinGen = view.findViewById(R.id.atkNinGenTextView);
        defTaiBuki = view.findViewById(R.id.defTaiBukTextView);
        defNinGen = view.findViewById(R.id.defNinGenTextView);
        precisao = view.findViewById(R.id.precisaoTextView);
        concentracao = view.findViewById(R.id.concTextView);
        percepcao = view.findViewById(R.id.percTextView);
        conviccao = view.findViewById(R.id.convTextView);
        esquiva = view.findViewById(R.id.esquivaTextView);
        determinacao = view.findViewById(R.id.deterTextView);

        carregarResumos();
        carregarAtribuitos();

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

        taijutsu.setText(String.valueOf(atributos.getTaijutsu()));
        bukijutsu.setText(String.valueOf(atributos.getBukijutsu()));
        ninjutsu.setText(String.valueOf(atributos.getNinjutsu()));
        genjutsu.setText(String.valueOf(atributos.getGenjutsu()));
        forca.setText(String.valueOf(atributos.getForca()));
        agilidade.setText(String.valueOf(atributos.getAgilidade()));
        inteligencia.setText(String.valueOf(atributos.getInteligencia()));
        selo.setText(String.valueOf(atributos.getSelo()));
        resistencia.setText(String.valueOf(atributos.getResistencia()));
        energia.setText(String.valueOf(atributos.getEnergia()));

        vida.setText(String.valueOf(formulas.getVida()));
        chakra.setText(String.valueOf(formulas.getChakra()));
        stamina.setText(String.valueOf(formulas.getStamina()));
        atkTaiBuki.setText(String.valueOf(formulas.getAtkTaiBuki()));
        atkNinGen.setText(String.valueOf(formulas.getAtkNinGen()));
        defTaiBuki.setText(String.valueOf(formulas.getDefTaiBuki()));
        defNinGen.setText(String.valueOf(formulas.getDefNinGen()));
        precisao.setText(String.valueOf(formulas.getPrecisao()));
        concentracao.setText(String.valueOf(formulas.getConcentracao()));
        percepcao.setText(String.valueOf(formulas.getPercepcao()));
        conviccao.setText(String.valueOf(formulas.getConviccao()));
        esquiva.setText(String.valueOf(formulas.getEsquiva()));
        determinacao.setText(String.valueOf(formulas.getDeterminacao()));
    }
}
