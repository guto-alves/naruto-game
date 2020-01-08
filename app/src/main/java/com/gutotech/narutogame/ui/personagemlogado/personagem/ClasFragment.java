package com.gutotech.narutogame.ui.personagemlogado.personagem;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClasFragment extends Fragment {


    public ClasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clas, container, false);
    }

}
