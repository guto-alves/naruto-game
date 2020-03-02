package com.gutotech.narutogame.ui.adapter;

import android.app.AlertDialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.GraduationUtils;

public class GraduationsRecyclerAdapter extends RecyclerView.Adapter<GraduationsRecyclerAdapter.MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView descriptionTextView;
        private ImageView requerImageView;
        private Button graduateButton;
        private ConstraintLayout bgConstraint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            requerImageView = itemView.findViewById(R.id.requerImageView);
            graduateButton = itemView.findViewById(R.id.graduateButton);
            bgConstraint = itemView.findViewById(R.id.bgConstraint);
        }
    }

    private Context context;

    public GraduationsRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.recycler_graduation_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int i) {
        int idGraduacao = i + 1;

        holder.nameTextView.setText(GraduationUtils.getGraducao(idGraduacao));
        holder.descriptionTextView.setText(GraduationUtils.getDescricao(idGraduacao));

        holder.requerImageView.setOnClickListener(v ->
                Toast.makeText(context, "Nenhum requerimento", Toast.LENGTH_SHORT).show());

        holder.graduateButton.setOnClickListener(v -> {

        });

        if (i % 2 == 0)
            holder.bgConstraint.setBackgroundColor(context.getResources().getColor(R.color.colorItem1));
        else
            holder.bgConstraint.setBackgroundColor(context.getResources().getColor(R.color.colorItem2));
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
}
