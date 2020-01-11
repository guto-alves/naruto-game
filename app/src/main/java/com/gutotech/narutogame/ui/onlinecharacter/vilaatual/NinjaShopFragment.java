package com.gutotech.narutogame.ui.onlinecharacter.vilaatual;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.adapter.ItemShopRecyclerAdapter;
import com.gutotech.narutogame.util.StorageUtil;
import com.gutotech.narutogame.data.model.ItemShop;
import com.gutotech.narutogame.data.model.PersonagemOn;
import com.gutotech.narutogame.data.model.Shop;

import java.util.ArrayList;
import java.util.List;

public class NinjaShopFragment extends Fragment {
    private Button armasLongoAlcanceButton, armasCurtoAlcanceButton, pergaminhosButton;

    private ItemShopRecyclerAdapter adapter;
    private List<ItemShop> itensList = new ArrayList<>();

    private Shop shop = new Shop();

    public NinjaShopFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ninja_shop, container, false);

        ImageView imagemMsg2 = view.findViewById(R.id.imagemMsg2);
        StorageUtil.downloadProfileForMsg(getActivity(), imagemMsg2, PersonagemOn.character.getNumVila());

        ProgressBar armasQuinzenalProgressBar = view.findViewById(R.id.armasQuinzenalProgressBar);
        TextView armasQuinzenalTextView = view.findViewById(R.id.armasQuinzenalTextView);

        armasLongoAlcanceButton = view.findViewById(R.id.armasLongoAlcanceButton);
        armasLongoAlcanceButton.setBackgroundColor(getActivity().getResources().getColor(android.R.color.holo_orange_dark));
        armasLongoAlcanceButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itensList = shop.getArmasLongoAlcance();
                        adapter.notifyDataSetChanged();
                        armasLongoAlcanceButton.setBackgroundColor(getActivity().getResources().getColor(android.R.color.holo_orange_dark));
                        armasCurtoAlcanceButton.setBackgroundColor(getActivity().getResources().getColor(R.color.colorBgButton));
                        pergaminhosButton.setBackgroundColor(getActivity().getResources().getColor(R.color.colorBgButton));
                    }
                }
        );

        armasCurtoAlcanceButton = view.findViewById(R.id.armasCurtoAlcanceButton);
        armasCurtoAlcanceButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itensList = shop.getArmasCurtoAlcance();
                        adapter.notifyDataSetChanged();
                        armasLongoAlcanceButton.setBackgroundColor(getActivity().getResources().getColor(R.color.colorBgButton));
                        armasCurtoAlcanceButton.setBackgroundColor(getActivity().getResources().getColor(android.R.color.holo_orange_dark));
                        pergaminhosButton.setBackgroundColor(getActivity().getResources().getColor(R.color.colorBgButton));
                    }
                }
        );

        pergaminhosButton = view.findViewById(R.id.pergaminhosButton);
        pergaminhosButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itensList = shop.getPergaminhos();
                        adapter.notifyDataSetChanged();
                        armasLongoAlcanceButton.setBackgroundColor(getActivity().getResources().getColor(R.color.colorBgButton));
                        armasCurtoAlcanceButton.setBackgroundColor(getActivity().getResources().getColor(R.color.colorBgButton));
                        pergaminhosButton.setBackgroundColor(getActivity().getResources().getColor(android.R.color.holo_orange_dark));
                    }
                }
        );

        RecyclerView itensShopRecyclerView = view.findViewById(R.id.itensShopRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        itensShopRecyclerView.setLayoutManager(layoutManager);
        itensShopRecyclerView.setHasFixedSize(true);
        itensList = shop.getArmasLongoAlcance();
        adapter = new ItemShopRecyclerAdapter(getActivity(), itensList);
        itensShopRecyclerView.setAdapter(adapter);

        return view;
    }

}
