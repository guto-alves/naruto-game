package com.gutotech.narutogame.fragment.personagemlogado.academia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.gutotech.narutogame.R;

import java.util.ArrayList;

public class AcademiaTreinamentoFragment extends Fragment {

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
        qtdTreinoSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        return view;
    }

}
