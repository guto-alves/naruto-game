package com.gutotech.narutogame.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.config.ConfigFirebase;

import java.util.List;

public class ProfilesPequenasAdapter extends RecyclerView.Adapter<ProfilesPequenasAdapter.MyViewHolder> {
    private List<Integer> pequenasList;
    private Context context;

    public ProfilesPequenasAdapter(Context context, List<Integer> pequenasList) {
        this.context = context;
        this.pequenasList = pequenasList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_pequenas, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        StorageReference imagemRef = ConfigFirebase.getStorage()
                .child("images")
                .child("criacao")
                .child("pequenas")
                .child(pequenasList.get(i) + ".png");

        Glide.with(context)
                .using(new FirebaseImageLoader())
                .load(imagemRef)
                .into(myViewHolder.pequenaImageView);
    }

    @Override
    public int getItemCount() {
        return pequenasList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView pequenaImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pequenaImageView = itemView.findViewById(R.id.pequenaImageView);
        }
    }
}
