package com.gutotech.narutogame.ui.adapter;

import android.app.AlertDialog;
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
import com.gutotech.narutogame.ui.onlinecharacter.academy.AcademiaJustuFragment;
import com.gutotech.narutogame.data.model.Jutsu;

import java.util.List;

public class JutsusAprenderAdapter extends RecyclerView.Adapter<JutsusAprenderAdapter.MyViewHolder> {
    private Context context;
    private List<Jutsu> jutsusList;

    public JutsusAprenderAdapter(Context context, List<Jutsu> jutsusList) {
        this.jutsusList = jutsusList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_jutsu_aprender, viewGroup, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        final Jutsu jutsu = jutsusList.get(i);

        StorageUtil.baixarJutsu(context, myViewHolder.jutsuImageView, jutsu.getClasse(), jutsu.getNomeImagem());

        myViewHolder.jutsuImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        myViewHolder.nomeTextView.setText(jutsu.getNome());
        myViewHolder.descricaoTextView.setText(jutsu.getDescricao());

        myViewHolder.requerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, jutsu.getNome(), Toast.LENGTH_SHORT).show();
            }
        });

        myViewHolder.treinarJutsuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AcademiaJustuFragment.jutsuAprendidoTextView.setText(jutsu.getNome());
                AcademiaJustuFragment.msgConstraintLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    private void exibirAlerta(String message) {
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
        return jutsusList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView jutsuImageView;
        private TextView nomeTextView;
        private TextView descricaoTextView;
        private ImageView requerImageView;
        private Button treinarJutsuButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            jutsuImageView = itemView.findViewById(R.id.jutsuImageView);
            nomeTextView = itemView.findViewById(R.id.nomeJutsuTextView);
            descricaoTextView = itemView.findViewById(R.id.descriJutsuTextView);
            requerImageView = itemView.findViewById(R.id.requerImageView);
            treinarJutsuButton = itemView.findViewById(R.id.treinarJutsuButton);
        }
    }
}
