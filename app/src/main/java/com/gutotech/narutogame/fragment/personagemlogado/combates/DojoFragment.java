package com.gutotech.narutogame.fragment.personagemlogado.combates;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class DojoFragment extends Fragment {
    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;

    public DojoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dojo, container, false);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getActivity().getSupportFragmentManager(), FragmentPagerItems.with(getActivity())
                .add("Batalhas do Dojo NPC", BatalhasDojoNPCFragment.class)
                .add("Batalhas do Dojo PVP", BatalhasDojoPVPFragment.class)
                .create()
        );

        viewPager = view.findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        smartTabLayout = view.findViewById(R.id.smarttablayout);
        smartTabLayout.setViewPager(viewPager);

        return view;
    }

}
