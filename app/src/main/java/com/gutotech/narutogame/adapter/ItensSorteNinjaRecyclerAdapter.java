package com.gutotech.narutogame.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.config.ConfigFirebase;
import com.gutotech.narutogame.config.Storage;
import com.gutotech.narutogame.model.ItemLoteria;

import java.util.List;

public class ItensSorteNinjaRecyclerAdapter extends RecyclerView.Adapter<ItensSorteNinjaRecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<ItemLoteria> itensLoteria;

    public ItensSorteNinjaRecyclerAdapter(Context context, List<ItemLoteria> itensLoteria) {
        this.context = context;
        this.itensLoteria = itensLoteria;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item_loteria, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        ItemLoteria item = itensLoteria.get(i);

        myViewHolder.nomeTextView.setText(item.getNome());
        myViewHolder.chanceTextView.setText(String.valueOf(item.getChanceDeGanhar()));

        StorageReference imageRef = ConfigFirebase.getStorage()
                .child("images")
                .child("loteria")
                .child(item.getImage() + ".png");
        Storage.downloadImage(context, imageRef, myViewHolder.itemImageView);

        if (i % 2 == 0)
            myViewHolder.bgConstraint.setBackgroundColor(context.getResources().getColor(R.color.colorItem1));
        else
            myViewHolder.bgConstraint.setBackgroundColor(context.getResources().getColor(R.color.colorItem2));
    }

    @Override
    public int getItemCount() {
        return itensLoteria.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;
        private TextView nomeTextView;
        private TextView chanceTextView;
        private TextView qtdGanhaTextView;
        private ConstraintLayout bgConstraint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImageView = itemView.findViewById(R.id.itemImageView);
            nomeTextView = itemView.findViewById(R.id.nomeItemTextView);
            chanceTextView = itemView.findViewById(R.id.chanceTextView);
            qtdGanhaTextView = itemView.findViewById(R.id.qtdGanhaTextView);
            bgConstraint = itemView.findViewById(R.id.bgConstraint);
        }
    }
}
