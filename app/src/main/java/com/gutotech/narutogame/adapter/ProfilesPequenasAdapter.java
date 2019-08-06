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

import java.util.List;

public class ProfilesPequenasAdapter extends BaseAdapter {
    private Context context;
    private List<Integer> profilesPequenasList;

    public ProfilesPequenasAdapter(Context context, List<Integer> profilesPequenasList) {
        this.context = context;
        this.profilesPequenasList = profilesPequenasList;
    }

    @Override
    public int getCount() {
        return profilesPequenasList.size();
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
            convertView = layoutInflater.inflate(R.layout.adapter_profile_pequena, null, false);
        }

        ImageView profilePequenaImageView = convertView.findViewById(R.id.pequenaImageView);

        StorageReference imagemRef = ConfigFirebase.getStorage()
                .child("images")
                .child("criacao")
                .child("pequenas")
                .child(profilesPequenasList.get(position) + ".png");

        Glide.with(context)
                .using(new FirebaseImageLoader())
                .load(imagemRef)
                .into(profilePequenaImageView);

        return convertView;
    }
}
