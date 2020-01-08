package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.util.StorageUtil;
import com.gutotech.narutogame.data.model.PersonagemOn;
import com.gutotech.narutogame.data.model.Ramen;

public class BolsaRamensAdapter extends RecyclerView.Adapter<BolsaRamensAdapter.MyViewHolder> {
    private Context context;

    public BolsaRamensAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_shop_item, viewGroup, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        Ramen ramen = PersonagemOn.personagem.getBolsa().getRamensList().get(i);

        StorageUtil.baixarRamenImage(context, myViewHolder.itemImageView, ramen.getImage());
        myViewHolder.itemImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        myViewHolder.quantidadeTextView.setText("x" + ramen.getInventario());
    }

    @Override
    public int getItemCount() {
        return PersonagemOn.personagem.getBolsa().getRamensList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;
        private TextView quantidadeTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImageView = itemView.findViewById(R.id.itemImageView);
            quantidadeTextView = itemView.findViewById(R.id.quantidadeTextView);
        }
    }
}
