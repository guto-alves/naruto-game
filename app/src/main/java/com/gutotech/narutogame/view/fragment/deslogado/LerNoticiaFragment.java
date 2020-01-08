package com.gutotech.narutogame.view.fragment.deslogado;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.model.Noticia;

import java.util.Locale;

public class LerNoticiaFragment extends Fragment {

    public LerNoticiaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ler_noticia, container, false);

        Bundle bundle = getArguments();

        if (bundle != null) {
            Noticia noticia = (Noticia) bundle.getSerializable("noticia");

            TextView title = view.findViewById(R.id.titleTextView);
            TextView date = view.findViewById(R.id.dateTextView);
            TextView author = view.findViewById(R.id.authorTextView);
            EditText message = view.findViewById(R.id.messageEditText);

            title.setText(noticia.getTitulo());
            date.setText(String.format(Locale.getDefault(), " em %s", noticia.getData()));
            author.setText(noticia.getPor());
            message.setText(noticia.getMensagem());
        }

        return view;
    }
}
