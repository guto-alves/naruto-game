package com.gutotech.narutogame.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.model.Atributo;

import java.util.List;

public class AtributosStatusAdapter extends RecyclerView.Adapter<AtributosStatusAdapter.MyViewHolder> {
    private Context context;
    private List<Atributo> atributosList;

    public AtributosStatusAdapter(Context context, List<Atributo> atributosList) {
        this.atributosList = atributosList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_atributo_list_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Atributo atributo = atributosList.get(i);

        myViewHolder.nomeAtributo.setText(atributo.getNome());
        myViewHolder.imagemAtributo.setImageResource(atributo.getImagem());
        myViewHolder.totalTextView.setText(String.valueOf(atributo.getQuantidade()));
        myViewHolder.totalProgressBar.setMax(10);
        myViewHolder.totalProgressBar.setProgress(atributo.getQuantidade());
    }

    @Override
    public int getItemCount() {
        return atributosList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nomeAtributo;
        private ImageView imagemAtributo;
        private TextView totalTextView;
        private ProgressBar totalProgressBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeAtributo = itemView.findViewById(R.id.nomeAtributoTextView);
            imagemAtributo = itemView.findViewById(R.id.imagemAtributo);
            totalTextView = itemView.findViewById(R.id.qtdAtributoTextView);
            totalProgressBar = itemView.findViewById(R.id.qtdAtributoProgressBar);
        }
    }
}
