package com.gutotech.narutogame.ui.onlinecharacter.battles;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gutotech.narutogame.R;

public class BatalhasDojoPVPFragment extends Fragment {

    public BatalhasDojoPVPFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_batalhas_dojo_pvp, container, false);

        Button irParaFilaButton = view.findViewById(R.id.irParaFilaButton);
        irParaFilaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToFragment(new DojoRandomWaitFragment());
            }
        });

        return view;
    }

    private void changeToFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment).commit();
    }
}
