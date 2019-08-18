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
import com.gutotech.narutogame.model.PersonagemOn;

public class ProfilesAdapter extends BaseAdapter {
    private int tamanho;
    private Context context;

    public ProfilesAdapter(Context context, int tamanho) {
        this.context = context;
        this.tamanho = tamanho;
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
            convertView = layoutInflater.inflate(R.layout.adapter_profile, null, false);
        }

        ImageView profileImageView = convertView.findViewById(R.id.profilesImageView);

        StorageReference imagemRef = ConfigFirebase.getStorage()
                .child("images")
                .child("profile")
                .child(String.valueOf(PersonagemOn.personagem.getIdProfile()))
                .child((position + 1) + ".png");

        Glide.with(context)
                .using(new FirebaseImageLoader())
                .load(imagemRef)
                .into(profileImageView);

        return convertView;
    }
}
