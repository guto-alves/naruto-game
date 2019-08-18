package com.gutotech.narutogame.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.config.ConfigFirebase;
import com.gutotech.narutogame.model.Personagem;
import com.gutotech.narutogame.model.PersonagemOn;

import java.util.List;

public class MapaGridAdapter extends BaseAdapter {
    private int tamanho;
    private Context context;
    private List<Personagem> personagensNoMapa;

    public MapaGridAdapter(Context context, int tamanho, List<Personagem> personagens) {
        this.context = context;
        this.tamanho = tamanho;
        this.personagensNoMapa = personagens;
    }

    @Override
    public int getCount() {
        return tamanho;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.adapter_mapa, null, false);
        }

        ImageView fundoImageView = convertView.findViewById(R.id.fundoImageView);
        ImageView spriteImageView = convertView.findViewById(R.id.spriteImageView);

        for (int i = 0; i < personagensNoMapa.size(); i++) {
            Personagem personagem = personagensNoMapa.get(i);

            if (personagem.getMapa_posicao() == position) {
                if (personagem.getVila().equals(PersonagemOn.personagem.getVila())) {
                    if (personagem.getNick().equals(PersonagemOn.personagem.getNick()))
                        fundoImageView.setImageResource(R.drawable.layout_map_me2);
                    else
                        fundoImageView.setImageResource(R.drawable.layout_map_green2);
                } else
                    fundoImageView.setImageResource(R.drawable.layout_map_red2);

                StorageReference imagemRef = ConfigFirebase.getStorage()
                        .child("images")
                        .child("sprites")
                        .child(personagem.getIdProfile() + ".png");

                Glide.with(context)
                        .using(new FirebaseImageLoader())
                        .load(imagemRef)
                        .into(spriteImageView);

                spriteImageView.setVisibility(View.VISIBLE);
                break;
            }
        }

        return convertView;
    }
}
