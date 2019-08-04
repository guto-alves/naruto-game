package com.gutotech.narutogame.fragment.personagemlogado.academia;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.adapter.JutsusAprenderAdapter;
import com.gutotech.narutogame.model.Jutsu;

import java.util.ArrayList;
import java.util.List;

public class AcademiaJustuFragment extends Fragment {
    private RecyclerView jutsusRecyclerView;
    private JutsusAprenderAdapter adapter;

    private List<Jutsu> jutsusList = new ArrayList<>();

    public static ConstraintLayout msgConstraintLayout;
    public static TextView jutsuAprendidoTextView;

    public AcademiaJustuFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_academia_jutsu, container, false);

        msgConstraintLayout = view.findViewById(R.id.msgConstraint);
        jutsuAprendidoTextView = view.findViewById(R.id.jutsuAprendidoTextView);

        jutsusRecyclerView = view.findViewById(R.id.jutsusAprenderRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        jutsusRecyclerView.setLayoutManager(layoutManager);
        jutsusRecyclerView.setHasFixedSize(true);
        carregarTaijutsus();
        adapter = new JutsusAprenderAdapter(getActivity(), jutsusList);
        jutsusRecyclerView.setAdapter(adapter);

        Button taijutsusButton = view.findViewById(R.id.taibutton);
        taijutsusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jutsusList.clear();
                carregarTaijutsus();
                adapter.notifyDataSetChanged();
            }
        });


        Button ninjutsusButton = view.findViewById(R.id.ninbutton);
        ninjutsusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jutsusList.clear();
                carregarNinjutsus();
                adapter.notifyDataSetChanged();
            }
        });

        Button genjutsusButton = view.findViewById(R.id.genbutton);
        genjutsusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jutsusList.clear();
                carregarGenjutsus();
                adapter.notifyDataSetChanged();
            }
        });

        Button bukijutsusButton = view.findViewById(R.id.bukbutton);
        bukijutsusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jutsusList.clear();
                carregarBukijutsus();
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    private void carregarTaijutsus() {
        jutsusList.add(new Jutsu("Dynamic Kick", "chute_dinamico", "Um chute fortíssimo, capaz de esmagar uma pedra.",
                1, 16, 0, 0, 6, 2, 5, 32,
                "atk", "tai"));

        jutsusList.add(new Jutsu("Hariitsuba ", "agulhas_sopranas", "Expele agulhas escondidas em sua boca",
                1, 29, 0, 0, 6, 2, 11, 59,
                "atk", "tai"));
    }

    private void carregarNinjutsus() {
        jutsusList.add(new Jutsu("Henge no Jutsu", "transformacao", "Jutsu de cópia, o usuário utiliza esse jutsu para copiar qualquer coisa (pessoas, objetos etc..) e assim utilizar desse método para atacar o oponente que fica distraído.",
                1, 0, 16, 0, 6, 2, 32, 5,
                "atk", "nin"));
    }

    private void carregarGenjutsus() {
        jutsusList.add(new Jutsu("Kishibari no Jutsu ", "Kishibari_no_Jutsu", "Esse genjutsu faz ninja sumir por alguns poucos instantes, dando à  sua vítima a idéia de que fora extremamente veloz, enquanto isso ele pode se esconder ou até mesmo atacar o alvo.",
                1, 0, 16, 0, 6, 2, 32, 5,
                "atk", "gen"));
    }

    private void carregarBukijutsus() {
        jutsusList.add(new Jutsu("Soufuushasan no Tachi", "soufuushasan-no-tachi", "O ninja prende shurikens com linhas e as controla para atacar o inimigo.",
                1, 16, 0, 0, 6, 2, 5, 32,
                "atk", "buk"));
    }
}
