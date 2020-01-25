package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Jutsu;

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
                .child(jutsuList.get(i).getName() + ".jpg");

        Glide.with(context)
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
