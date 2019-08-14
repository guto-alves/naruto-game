package com.gutotech.narutogame.fragment.personagemlogado.personagem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.adapter.ItensSorteNinjaRecyclerAdapter;
import com.gutotech.narutogame.model.ItemLoteria;

import java.util.ArrayList;
import java.util.List;

public class SorteNinjaFragment extends Fragment {

    public SorteNinjaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sorte_ninja, container, false);

        RecyclerView itensSorteNinjaRecyclerView = view.findViewById(R.id.itensSorteNinjaRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        itensSorteNinjaRecyclerView.setLayoutManager(layoutManager);
        itensSorteNinjaRecyclerView.setHasFixedSize(true);
        itensSorteNinjaRecyclerView.setAdapter(new ItensSorteNinjaRecyclerAdapter(getActivity(), buildItens()));

        Button jogarSorteButton = view.findViewById(R.id.jogarSorteButton);
        jogarSorteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    private List<ItemLoteria> buildItens() {
        List<ItemLoteria> itens = new ArrayList<>();

        itens.add(new ItemLoteria("1", "1 Ryou", 1));
        itens.add(new ItemLoteria("3", "2000 Ryous", 1));
        itens.add(new ItemLoteria("4", "5000 Ryous", 1));
        itens.add(new ItemLoteria("5", "10000 Ryous", 1));
        itens.add(new ItemLoteria("6", "25000 Ryous", 1));
        itens.add(new ItemLoteria("7", "50000 Ryous", 1));

        return itens;
    }

}
