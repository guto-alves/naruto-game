package com.gutotech.narutogame.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
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
import com.gutotech.narutogame.model.Personagem;
import com.gutotech.narutogame.publicentities.PersonagemOn;

import java.util.List;

public class RankingNinjasRecyclerAdapter extends RecyclerView.Adapter<RankingNinjasRecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<Personagem> ninjas;

    public RankingNinjasRecyclerAdapter(Context context, List<Personagem> ninjas) {
        this.context = context;
        this.ninjas = ninjas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_ranking_ninjas, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        final Personagem personagem = ninjas.get(i);

        myViewHolder.posicaoTextView.setText(personagem.getRankGeral());
        myViewHolder.nickTextView.setText(personagem.getNick());
        myViewHolder.pontosTextView.setText(personagem.getPontos());


        if (i % 2 == 0)
            myViewHolder.bgConstraint.setBackgroundColor(context.getResources().getColor(R.color.colorItem1));
        else
            myViewHolder.bgConstraint.setBackgroundColor(context.getResources().getColor(R.color.colorItem2));
    }

    @Override
    public int getItemCount() {
        return ninjas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView posicaoTextView;
        private TextView nickTextView;
        private TextView tituloTextView;
        private TextView levelTextView;
        private TextView pontosTextView;

        private ImageView vilaImageView;
        private ImageView personagemImageView;
        private ConstraintLayout bgConstraint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            posicaoTextView = itemView.findViewById(R.id.posicaoTextView);
            nickTextView = itemView.findViewById(R.id.nickTextView);
            tituloTextView = itemView.findViewById(R.id.tituloTextView);
            levelTextView = itemView.findViewById(R.id.levelTextView);
            pontosTextView = itemView.findViewById(R.id.pontosTextView);
            vilaImageView = itemView.findViewById(R.id.vilaImageView);
            personagemImageView = itemView.findViewById(R.id.personagemImageView);
            bgConstraint = itemView.findViewById(R.id.bgConstraint);
        }
    }
}
