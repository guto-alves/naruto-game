package com.gutotech.narutogame.view.fragment.personagemlogado.combates;

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

public class DojoFragment extends Fragment {

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

        return view;
    }

    private void changeToFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteiner, fragment);
        transaction.commit();
    }

}
