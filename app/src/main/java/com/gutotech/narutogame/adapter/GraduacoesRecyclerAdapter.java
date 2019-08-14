package com.gutotech.narutogame.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.config.Storage;
import com.gutotech.narutogame.fragment.personagemlogado.academia.AcademiaJustuFragment;
import com.gutotech.narutogame.model.Graduacao;
import com.gutotech.narutogame.model.Jutsu;

import java.util.List;

public class GraduacoesRecyclerAdapter extends RecyclerView.Adapter<GraduacoesRecyclerAdapter.MyViewHolder> {
    private Context context;

    public GraduacoesRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_graducao, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        int idGraduacao = i + 1;

        myViewHolder.nomeTextView.setText(Graduacao.getGraducao(idGraduacao));
        myViewHolder.descricaoTextView.setText(Graduacao.getDescricao(idGraduacao));

        myViewHolder.requerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Nenhum requerimento", Toast.LENGTH_SHORT).show();
            }
        });

        myViewHolder.graduarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        if (i % 2 == 0)
            myViewHolder.bgConstraint.setBackgroundColor(context.getResources().getColor(R.color.colorItem1));
        else
            myViewHolder.bgConstraint.setBackgroundColor(context.getResources().getColor(R.color.colorItem2));
    }

    private void exibirRequerimentos(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Aviso!");
        builder.setMessage(message);
        builder.setPositiveButton("Fechar", null);
        builder.setCancelable(false);
        builder.create();
        builder.show();
    }

    @Override
    public int getItemCount() {
        return 6; // total de graduações
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nomeTextView;
        private TextView descricaoTextView;
        private ImageView requerImageView;
        private Button graduarButton;
        private ConstraintLayout bgConstraint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeTextView = itemView.findViewById(R.id.nomeGraduacaoTextView);
            descricaoTextView = itemView.findViewById(R.id.descriGraduacaoTextView);
            requerImageView = itemView.findViewById(R.id.requerImageView);
            graduarButton = itemView.findViewById(R.id.graduarButton);
            bgConstraint = itemView.findViewById(R.id.bgConstraint);
        }
    }
}
