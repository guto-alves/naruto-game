package com.gutotech.narutogame.fragment.personagemlogado.vilaatual;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.adapter.RamensRecyclerAdapter;
import com.gutotech.narutogame.helper.RecyclerItemClickListener;
import com.gutotech.narutogame.model.Ramen;

import java.util.ArrayList;
import java.util.List;

public class RamenShopFragment extends Fragment {
    private RecyclerView ramensRecyclerView;
    private List<Ramen> ramenList = new ArrayList<>();

    private RamensRecyclerAdapter adapter;

    public RamenShopFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ramem_shop, container, false);

        ramensRecyclerView = view.findViewById(R.id.ramensRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ramensRecyclerView.setLayoutManager(layoutManager);
        inicializarRamens();
        ramensRecyclerView.setHasFixedSize(true);
        adapter = new RamensRecyclerAdapter(getActivity(), ramenList);
        ramensRecyclerView.setAdapter(adapter);

        return view;
    }

    private void inicializarRamens() {
        ramenList.add(new Ramen(R.drawable.layout_comidas_nissin, "Merenda Ninja",
                "Super macarrão reforçado para uso nos intervalos das tarefas ninjas",
                100, 25, 1));

        ramenList.add(new Ramen(R.drawable.layout_comidas_ramen, "Misso Gyoza-Ramen",
                "Ramen de frutos do mar, com pasta de soja",
                150, 35, 1));

        ramenList.add(new Ramen(R.drawable.layout_comidas_ramen_duplo, "Shoyu Gyoza-Ramen",
                "Ramen de frutos do mar, temperado especialmente com molho de soja",
                175, 70, 1));

        ramenList.add(new Ramen(R.drawable.layout_comidas_ramen_g, "Shio Gyoza-Ramen",
                "Ramen de frutos do mar, temperado com sal",
                450, 105, 1));

        ramenList.add(new Ramen(R.drawable.layout_comidas_shio_tyashu_ramen, "Shio Tyashu-Ramen",
                "Ramen com carne de porco, temperado com sal",
                600, 150, 1));
        ramenList.add(new Ramen(R.drawable.layout_comidas_shoyu_tyashu_ramen, "Shoyu Tyashu-Ramen ",
                "Ramen com carne de porco, temperado com sal",
                750, 175, 1));

        ramenList.add(new Ramen(R.drawable.layout_comidas_misso_tyashu_ramen, "Misso Tyashu-Ramen",
                "Ramen com carne de porco, acompanhando pasta de soja",
                900, 210, 1));
        ramenList.add(new Ramen(R.drawable.layout_comidas_shio_yasai_ramen, "Shio Yasai-Ramen",
                "Ramen com carne de porco, acompanhando pasta de soja",
                1050, 245, 1));

        ramenList.add(new Ramen(R.drawable.layout_comidas_shio_ebi_ramen, "Shoyu Ebi-Ramen",
                "amen de camarão, temperado especialmente com molho de soja",
                1650, 385, 1));

        ramenList.add(new Ramen(R.drawable.layout_comidas_misso_ebi_ramen, "Misso Ebi-Ramen",
                "Ramen de camarão, com pasta de soja",
                1800, 420, 1));
    }
}
