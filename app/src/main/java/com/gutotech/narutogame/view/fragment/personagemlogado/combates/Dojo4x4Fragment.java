package com.gutotech.narutogame.view.fragment.personagemlogado.combates;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.config.StorageUtil;
import com.gutotech.narutogame.model.PersonagemOn;

public class Dojo4x4Fragment extends Fragment {

    public Dojo4x4Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dojo4x4, container, false);

        ImageView personagemMsgImagem = view.findViewById(R.id.personagemMsgImagem);
        StorageUtil.baixarImagemParaMsg(getActivity(), personagemMsgImagem, PersonagemOn.personagem.getNumVila());

        return view;
    }

}
