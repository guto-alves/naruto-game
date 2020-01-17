package com.gutotech.narutogame.ui.playing.character;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.PersonagemOn;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.ItensSorteNinjaRecyclerAdapter;
import com.gutotech.narutogame.data.model.LotteryItem;
import com.gutotech.narutogame.utils.FragmentUtil;

import java.util.ArrayList;
import java.util.List;

public class NinjaLuckyFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ninja_lucky, container, false);

        RecyclerView itensSorteNinjaRecyclerView = view.findViewById(R.id.itensSorteNinjaRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        itensSorteNinjaRecyclerView.setLayoutManager(layoutManager);
        itensSorteNinjaRecyclerView.setHasFixedSize(true);
        itensSorteNinjaRecyclerView.setAdapter(new ItensSorteNinjaRecyclerAdapter(getActivity(), buildItens()));

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_ninja_lucky);

        return view;
    }

    private List<LotteryItem> buildItens() {
        List<LotteryItem> lotteryItems = new ArrayList<>();

        lotteryItems.add(new LotteryItem("1", "1 Ryou", 1,
                () -> PersonagemOn.character.addRyous(1)));
        lotteryItems.add(new LotteryItem("3", "2000 Ryous", 50,
                () -> PersonagemOn.character.addRyous(2000)));
        lotteryItems.add(new LotteryItem("4", "5000 Ryous", 20,
                () -> PersonagemOn.character.addRyous(5000)));
        lotteryItems.add(new LotteryItem("5", "10000 Ryous", 10,
                () -> PersonagemOn.character.addRyous(10000)));
        lotteryItems.add(new LotteryItem("6", "25000 Ryous", 5,
                () -> PersonagemOn.character.addRyous(25000)));
        lotteryItems.add(new LotteryItem("7", "50000 Ryous", 1,
                () -> PersonagemOn.character.addRyous(50000)));

        lotteryItems.add(new LotteryItem("9", "1 Experience Points", 1,
                () -> PersonagemOn.character.addExp(1)));
        lotteryItems.add(new LotteryItem("11", "1500 Experience Points", 50,
                () -> PersonagemOn.character.addExp(1500)));
        lotteryItems.add(new LotteryItem("12", "2000 Experience Points", 40,
                () -> PersonagemOn.character.addExp(2000)));
        lotteryItems.add(new LotteryItem("13", "2500 Experience Points", 30,
                () -> PersonagemOn.character.addExp(2500)));
        lotteryItems.add(new LotteryItem("14", "3000 Experience Points", 20,
                () -> PersonagemOn.character.addExp(3000)));
        lotteryItems.add(new LotteryItem("15", "15000 Experience Points", 1,
                () -> PersonagemOn.character.addExp(15000)));

        return lotteryItems;
    }

    @Override
    public int getDescription() {
        return R.string.ninja_lucky;
    }
}
