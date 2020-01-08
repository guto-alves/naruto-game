package com.gutotech.narutogame.view.fragment.personagemlogado.vilaatual;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.view.adapter.ItemShopRecyclerAdapter;
import com.gutotech.narutogame.model.Shop;

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
