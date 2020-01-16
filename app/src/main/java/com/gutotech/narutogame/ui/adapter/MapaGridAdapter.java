package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.PersonagemOn;

import java.util.List;

public class MapaGridAdapter extends BaseAdapter {
    private int tamanho;
    private Context context;
    private List<Character> personagensNoMapa;

    public MapaGridAdapter(Context context, int tamanho, List<Character> personagens) {
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
            Character character = personagensNoMapa.get(i);

//            if (character.getMapa_posicao() == position) {
//                if (character.getVillage().equals(PersonagemOn.character.getVillage())) {
//                    if (character.getNick().equals(PersonagemOn.character.getNick()))
//                        fundoImageView.setImageResource(R.drawable.layout_map_me2);
//                    else
//                        fundoImageView.setImageResource(R.drawable.layout_map_green2);
//                } else
//                    fundoImageView.setImageResource(R.drawable.layout_map_red2);
//
//                StorageReference imagemRef = FirebaseConfig.getStorage()
//                        .child("images")
//                        .child("sprites")
//                        .child(character.getNinja().getId() + ".png");
//
//                Glide.with(context)
//                        .load(imagemRef)
//                        .into(spriteImageView);
//
//                spriteImageView.setVisibility(View.VISIBLE);
//                break;
//            }
        }

        return convertView;
    }
}
