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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.config.ConfigFirebase;
import com.gutotech.narutogame.config.Storage;
import com.gutotech.narutogame.helper.Helper;
import com.gutotech.narutogame.model.EstatisticaNinja;
import com.gutotech.narutogame.model.Graduacao;

public class EstatisticasNinjaRecyclerAdapter extends RecyclerView.Adapter<EstatisticasNinjaRecyclerAdapter.MyViewHolder> {
    private Context context;
    private EstatisticaNinja[] estatisticasNinja;

    public EstatisticasNinjaRecyclerAdapter(Context context, EstatisticaNinja[] estatisticasNinja) {
        this.context = context;
        this.estatisticasNinja = estatisticasNinja;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_estatisca_ninja, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        i *= 2;

        int idProfile;
        StorageReference imageRef;

        if (i < 121) {
            EstatisticaNinja estatisticaNinja1 = estatisticasNinja[i];
            idProfile = estatisticaNinja1.getIdProfile();
            imageRef = ConfigFirebase.getStorage().child("images").child("home")
                    .child(idProfile + ".jpg");
            Storage.downloadImage(context, imageRef, myViewHolder.imageView1);
            myViewHolder.nomeTextView1.setText(Helper.nomeDoPersonagem(idProfile));
            myViewHolder.qtdJogadoresTextView1.setText(estatisticaNinja1.getFrequencia() + " Jogadores");
        }

        if (i + 1 < 121) {
            EstatisticaNinja estatisticaNinja2 = estatisticasNinja[i + 1];
            idProfile = estatisticaNinja2.getIdProfile();
            imageRef = ConfigFirebase.getStorage().child("images").child("home")
                    .child(idProfile + ".jpg");
            Storage.downloadImage(context, imageRef, myViewHolder.imageView2);
            myViewHolder.nomeTextView2.setText(Helper.nomeDoPersonagem(idProfile));
            myViewHolder.qtdJogadoresTextView2.setText(estatisticaNinja2.getFrequencia() + " Jogadores");
        }

        if (i / 2 % 2 == 1)
            myViewHolder.bgLinear.setBackgroundColor(context.getResources().getColor(R.color.colorItem2));
    }

    @Override
    public int getItemCount() {
        return estatisticasNinja.length / 2 + 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView1;
        private TextView nomeTextView1;
        private TextView qtdJogadoresTextView1;

        private ImageView imageView2;
        private TextView nomeTextView2;
        private TextView qtdJogadoresTextView2;

        private ConstraintLayout bgLinear;
        private LinearLayout bgNinja2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView1 = itemView.findViewById(R.id.imageView1);
            nomeTextView1 = itemView.findViewById(R.id.nomeTextView1);
            qtdJogadoresTextView1 = itemView.findViewById(R.id.qtdJogadoresTextView1);

            imageView2 = itemView.findViewById(R.id.imageView2);
            nomeTextView2 = itemView.findViewById(R.id.nomeTextView2);
            qtdJogadoresTextView2 = itemView.findViewById(R.id.qtdJogadoresTextView2);

            bgLinear = itemView.findViewById(R.id.bgLinear);
            bgNinja2 = itemView.findViewById(R.id.bgNinja2);
        }
    }
}
