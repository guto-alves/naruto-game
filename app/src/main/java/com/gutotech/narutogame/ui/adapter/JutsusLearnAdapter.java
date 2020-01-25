package com.gutotech.narutogame.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.utils.StorageUtil;
import com.gutotech.narutogame.data.model.Jutsu;

import java.util.List;

public class JutsusLearnAdapter extends RecyclerView.Adapter<JutsusLearnAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView jutsuImageView;
        private TextView nameTextView;
        private TextView descriptionTextView;
        private ImageView requerImageView;
        private Button trainButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            jutsuImageView = itemView.findViewById(R.id.jutsuImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            requerImageView = itemView.findViewById(R.id.requerImageView);
            trainButton = itemView.findViewById(R.id.trainButton);
        }
    }

    private Context context;
    private List<Jutsu> mJutsusList;

    public JutsusLearnAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.recycler_jutsu_learn_item, viewGroup, false);
        return new ViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {
        if (mJutsusList != null) {
            final Jutsu jutsu = mJutsusList.get(i);

            StorageUtil.downloadJutsu(context, holder.jutsuImageView, jutsu.getImage());
            holder.nameTextView.setText(jutsu.getName());
            holder.descriptionTextView.setText(jutsu.getDescription());

            holder.jutsuImageView.setOnClickListener(v -> {

            });

            holder.requerImageView.setOnClickListener(v -> {
                Toast.makeText(context, jutsu.getName(), Toast.LENGTH_SHORT).show();
            });

            holder.trainButton.setOnClickListener(v -> {

            });
        }
    }

    @Override
    public int getItemCount() {
        return mJutsusList != null ? mJutsusList.size() : 0;
    }

    public void setJutsusList(List<Jutsu> jutsusList) {
        mJutsusList = jutsusList;
        notifyDataSetChanged();
    }
}
