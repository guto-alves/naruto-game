package com.gutotech.narutogame.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import com.gutotech.narutogame.model.Personagem;
import com.gutotech.narutogame.model.Vilas;

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

        StorageReference imageReference = ConfigFirebase.getStorage()
                .child("images").child("dojo").child(personagem.getIdProfile() + ".png");

        Storage.downloadImage(context, imageReference, myViewHolder.personagemImageView);

        myViewHolder.posicaoTextView.setText(1 + "°");
        myViewHolder.nickTextView.setText(personagem.getNick());
        myViewHolder.nickTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirProfile(personagem);
            }
        });
        myViewHolder.tituloTextView.setText(personagem.getTitulo());
        myViewHolder.pontosTextView.setText(String.valueOf(personagem.getPontos()));
        myViewHolder.levelTextView.setText(String.valueOf(personagem.getLevel()));

        if (personagem.isOn())
            myViewHolder.onlineImageView.setImageResource(R.drawable.layout_on);
        else
            myViewHolder.onlineImageView.setImageResource(R.drawable.layout_off);

        switch (personagem.getVila()) {
            case Vilas.FOLHA:
                myViewHolder.vilaImageView.setImageResource(R.drawable.layout_bandanas_1);
                break;
            case Vilas.AREIA:
                myViewHolder.vilaImageView.setImageResource(R.drawable.layout_bandanas_2);
                break;
            case Vilas.NEVOA:
                myViewHolder.vilaImageView.setImageResource(R.drawable.layout_bandanas_3);
                break;
            case Vilas.PEDRA:
                myViewHolder.vilaImageView.setImageResource(R.drawable.layout_bandanas_4);
                break;
            case Vilas.NUVEM:
                myViewHolder.vilaImageView.setImageResource(R.drawable.layout_bandanas_5);
                break;
            case Vilas.AKATSUKI:
                myViewHolder.vilaImageView.setImageResource(R.drawable.layout_bandanas_6);
                break;
            case Vilas.SOM:
                myViewHolder.vilaImageView.setImageResource(R.drawable.layout_bandanas_7);
                break;
            case Vilas.CHUVA:
                myViewHolder.vilaImageView.setImageResource(R.drawable.layout_bandanas_8);
                break;
        }

        if (i % 2 == 0)
            myViewHolder.bgConstraint.setBackgroundColor(context.getResources().getColor(R.color.colorItem1));
        else
            myViewHolder.bgConstraint.setBackgroundColor(context.getResources().getColor(R.color.colorItem2));
    }

    private void exibirProfile(Personagem personagem) {
        Dialog profileDialog = new Dialog(context);
        profileDialog.setContentView(R.layout.dialog_acao_profile);

        ImageView profileLogadoimageView = profileDialog.findViewById(R.id.profilePersonagemOnImageView);
        Storage.baixarProfile(context, profileLogadoimageView, personagem.getIdProfile(), personagem.getFotoAtual());

        TextView nickPersonagemOnTextView = profileDialog.findViewById(R.id.nickPersonagemOnTextView);
        nickPersonagemOnTextView.setText(personagem.getNick());

        TextView classe = profileDialog.findViewById(R.id.classeTextView);
        classe.setText(String.valueOf(personagem.getClasse()));

        TextView vila = profileDialog.findViewById(R.id.vilaTextView);
        vila.setText(String.valueOf(personagem.getVila()));

        TextView level = profileDialog.findViewById(R.id.levelTextView);
        level.setText(String.valueOf(personagem.getLevel()));

        profileDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        profileDialog.show();
    }

    @Override
    public int getItemCount() {
        return ninjas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView posicaoTextView;
        private ImageView onlineImageView;
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
            onlineImageView = itemView.findViewById(R.id.onlineImageView);
            levelTextView = itemView.findViewById(R.id.levelTextView);
            pontosTextView = itemView.findViewById(R.id.pontosTextView);
            vilaImageView = itemView.findViewById(R.id.vilaImageView);
            personagemImageView = itemView.findViewById(R.id.personagemImageView);
            bgConstraint = itemView.findViewById(R.id.bgConstraint);
        }
    }
}
