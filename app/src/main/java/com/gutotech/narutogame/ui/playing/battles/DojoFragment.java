package com.gutotech.narutogame.ui.playing.battles;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtil;

public class DojoFragment extends Fragment implements SectionFragment {

    public DojoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dojo, container, false);

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_batalhas_dojo_npc:
                        changeToFragment(new BatalhasDojoNPCFragment());
                        break;
                    case R.id.action_batalhas_dojo_pvp:
                        changeToFragment(new BatalhasDojoPVPFragment());
                        break;
                }
                return true;
            }
        });

        changeToFragment(new BatalhasDojoNPCFragment());

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_dojo);

        return view;
    }

    private void changeToFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteiner, fragment);
        transaction.commit();
    }

    @Override
    public int getDescription() {
        return R.string.dojo;
    }
}
