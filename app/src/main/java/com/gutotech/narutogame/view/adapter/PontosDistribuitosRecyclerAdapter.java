package com.gutotech.narutogame.view.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.model.Atributo;
import com.gutotech.narutogame.model.PersonagemOn;

import java.util.List;

public class PontosDistribuitosRecyclerAdapter extends RecyclerView.Adapter<PontosDistribuitosRecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<Atributo> atributosDistribuidos;
    private int max = 0;

    public PontosDistribuitosRecyclerAdapter(Context context) {
        this.context = context;
        atributosDistribuidos = PersonagemOn.personagem.getAtributosDistribuitos();

        for (Atributo atributo : atributosDistribuidos) {
            if (atributo.getQuantidade() > max)
                max = atributo.getQuantidade();
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_ponto_distribuido, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        final Atributo atributo = atributosDistribuidos.get(i);

        myViewHolder.nomeAtributo.setText(atributo.getNome());
        myViewHolder.imagemAtributo.setImageResource(atributo.getImagem());
        myViewHolder.totalTextView.setText(String.valueOf(atributo.getQuantidade()));
        myViewHolder.totalProgressBar.setMax(max);
        myViewHolder.totalProgressBar.setProgress(atributo.getQuantidade());

        myViewHolder.treinarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atributo.treinarAtributo(i);
            }
        });

        if (i % 2 == 0)
            myViewHolder.bgConstraint.setBackgroundColor(context.getResources().getColor(R.color.colorItem1));
        else
            myViewHolder.bgConstraint.setBackgroundColor(context.getResources().getColor(R.color.colorItem2));
    }

    @Override
    public int getItemCount() {
        return atributosDistribuidos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nomeAtributo;
        private ImageView imagemAtributo;
        private TextView totalTextView;
        private ProgressBar totalProgressBar;
        private Spinner qtdTreinarSpinner;
        private Button treinarButton;
        private ConstraintLayout bgConstraint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeAtributo = itemView.findViewById(R.id.nomeAtributoTextView);
            imagemAtributo = itemView.findViewById(R.id.imagemAtributo);
            totalTextView = itemView.findViewById(R.id.qtdAtributoTextView);
            totalProgressBar = itemView.findViewById(R.id.qtdAtributoProgressBar);
            treinarButton = itemView.findViewById(R.id.treinarAtributoButton);
            bgConstraint = itemView.findViewById(R.id.bgConstraint);
        }
    }

}
