package com.gutotech.narutogame.view.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.config.FirebaseConfig;
import com.gutotech.narutogame.model.Jutsu;

import java.util.List;

public class JutsusAdapter extends RecyclerView.Adapter<JutsusAdapter.MyViewHolder> {
    private List<Jutsu> jutsuList;
    private Context context;

    public JutsusAdapter(Context context, List<Jutsu> jutsuList) {
        this.context = context;
        this.jutsuList = jutsuList;
    }

    @NonNull
    @Override
    public JutsusAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_batalha_jutsu, viewGroup, false);
        return new JutsusAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JutsusAdapter.MyViewHolder myViewHolder, int i) {
        StorageReference imagemRef = FirebaseConfig.getStorage()
                .child("images")
                .child("jutsu")
                .child(jutsuList.get(i).getNome() + ".jpg");

        Glide.with(context)
                .using(new FirebaseImageLoader())
                .load(imagemRef)
                .into(myViewHolder.jutsuImageView);
    }

    @Override
    public int getItemCount() {
        return jutsuList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView jutsuImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            jutsuImageView = itemView.findViewById(R.id.jutsuImageView);
        }
    }
}
