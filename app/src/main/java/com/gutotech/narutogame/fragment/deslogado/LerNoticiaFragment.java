package com.gutotech.narutogame.fragment.deslogado;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.model.Noticia;
import com.gutotech.narutogame.publicentities.CurrentFragment;
import com.gutotech.narutogame.publicentities.NewsPublic;

public class LerNoticiaFragment extends Fragment {

    public LerNoticiaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ler_noticia, container, false);

        CurrentFragment.LER_NOTICIA = 1;

        TextView title = view.findViewById(R.id.titleTextView);
        TextView date = view.findViewById(R.id.dateTextView);
        TextView author = view.findViewById(R.id.authorTextView);
        EditText message = view.findViewById(R.id.messageEditText);

        Noticia noticia = NewsPublic.getNoticia();

        title.setText(noticia.getTitulo());
        date.setText(" em " + noticia.getData());
        author.setText(noticia.getPor());
        message.setText(noticia.getMensagem());

        NewsPublic.setNoticia(null);

        return view;
    }
}
