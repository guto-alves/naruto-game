package com.gutotech.narutogame.ui.onlinecharacter.currentvillage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.ItemShopRecyclerAdapter;
import com.gutotech.narutogame.data.model.Shop;
import com.gutotech.narutogame.utils.FragmentUtil;

public class RamenShopFragment extends Fragment implements SectionFragment {

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

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_ramen_shop);

        return view;
    }

    @Override
    public int getDescription() {
        return R.string.ramen_shop;
    }
}
