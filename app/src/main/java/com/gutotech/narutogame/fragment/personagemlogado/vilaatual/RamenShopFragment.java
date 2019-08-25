package com.gutotech.narutogame.fragment.personagemlogado.vilaatual;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.adapter.ItemShopRecyclerAdapter;
import com.gutotech.narutogame.model.ItemShop;
import com.gutotech.narutogame.model.Ramen;
import com.gutotech.narutogame.model.Shop;

import java.util.ArrayList;
import java.util.List;

public class RamenShopFragment extends Fragment {

    public RamenShopFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ramem_shop, container, false);

        RecyclerView ramensRecyclerView = view.findViewById(R.id.ramensRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ramensRecyclerView.setLayoutManager(layoutManager);
        ramensRecyclerView.setHasFixedSize(true);
        ItemShopRecyclerAdapter adapter = new ItemShopRecyclerAdapter(getActivity(), new Shop().getRamens());
        ramensRecyclerView.setAdapter(adapter);

        return view;
    }
}
