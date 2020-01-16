package com.gutotech.narutogame.ui.onlinecharacter.character;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.ItensSorteNinjaRecyclerAdapter;
import com.gutotech.narutogame.data.model.ItemLoteria;
import com.gutotech.narutogame.utils.FragmentUtil;

import java.util.ArrayList;
import java.util.List;

public class SorteNinjaFragment extends Fragment implements SectionFragment {

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

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_ninja_lucky);

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

    @Override
    public int getDescription() {
        return R.string.ninja_lucky;
    }
}
