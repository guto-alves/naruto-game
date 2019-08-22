package com.gutotech.narutogame.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.model.PersonagemOn;
import com.gutotech.narutogame.model.Ramen;

public class RamensBolsaRecyclerAdapter extends RecyclerView.Adapter<RamensBolsaRecyclerAdapter.MyViewHolder> {
    private Context context;

    public RamensBolsaRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_ramens, viewGroup, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        Ramen ramen = PersonagemOn.personagem.getBolsa().getRamensList().get(i);

        myViewHolder.itemImageView.setImageResource(ramen.getResIdImagem());
        myViewHolder.itemImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        myViewHolder.quantidadeTextView.setText("x" + ramen.getQuantidade());
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
