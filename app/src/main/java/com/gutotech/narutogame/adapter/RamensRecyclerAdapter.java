package com.gutotech.narutogame.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.model.Ramen;
import com.gutotech.narutogame.publicentities.PersonagemOn;

import java.util.List;

public class RamensRecyclerAdapter extends RecyclerView.Adapter<RamensRecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<Ramen> ramenList;

    public RamensRecyclerAdapter(Context context, List<Ramen> ramenList) {
        this.ramenList = ramenList;
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
        final Ramen ramen = ramenList.get(i);
        myViewHolder.ramenImageView.setImageResource(ramen.getResIdImagem());
        myViewHolder.ramenImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myViewHolder.nomeTextView.setText(ramen.getNome());
        myViewHolder.requerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Nenhum requerimento", Toast.LENGTH_SHORT).show();
            }
        });
        myViewHolder.descricaoTextView.setText(ramen.getDescricao());
        myViewHolder.valorTextView.setText("RY$ " + ramen.getValor());
        myViewHolder.qtdeEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (!myViewHolder.qtdeEditText.getText().toString().isEmpty()) {
                    int quantidade = Integer.parseInt(myViewHolder.qtdeEditText.getText().toString());
                    myViewHolder.valorTextView.setText("RY$ " + ramen.getValor() * quantidade);
                }
                return false;
            }
        });
        myViewHolder.comprarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myViewHolder.qtdeEditText.getText().toString().isEmpty()) {


                } else {
                    int quantidade = Integer.parseInt(myViewHolder.qtdeEditText.getText().toString());

                    if (PersonagemOn.personagem.getRyous() >= ramen.getValor() * quantidade) {
                        exibirAlerta("Item(s) comprado(s) com sucesso");
                    } else {
                        exibirAlerta("Você não tem ryous suficientes para comprar essa quantidade");
                    }
                }
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
        return ramenList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ramenImageView;
        private TextView nomeTextView;
        private TextView descricaoTextView;
        private TextView valorTextView;
        private ImageView requerImageView;
        private EditText qtdeEditText;
        private Button comprarButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ramenImageView = itemView.findViewById(R.id.ramenImageView);
            nomeTextView = itemView.findViewById(R.id.nomeRamenTextView);
            descricaoTextView = itemView.findViewById(R.id.descriRamenTextView);
            requerImageView = itemView.findViewById(R.id.requerImageView);
            valorTextView = itemView.findViewById(R.id.ryousTextView);
            qtdeEditText = itemView.findViewById(R.id.qtdEditText);
            comprarButton = itemView.findViewById(R.id.comprarRamenButton);
        }
    }
}
