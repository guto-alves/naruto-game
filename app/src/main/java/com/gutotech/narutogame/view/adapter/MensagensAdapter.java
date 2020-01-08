package com.gutotech.narutogame.view.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.model.Mensagem;

import java.util.List;

public class MensagensAdapter extends RecyclerView.Adapter<MensagensAdapter.MyViewHolder> {
    private List<Mensagem> mensagensList;

    public MensagensAdapter(List<Mensagem> mensagensList) {
        this.mensagensList = mensagensList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_mensagens, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.quemMandouTextView.setText(mensagensList.get(i).getQuemMandou() + ":");
        myViewHolder.oQueMandouTextView.setText(mensagensList.get(i).getoQueMandou());
    }

    @Override
    public int getItemCount() {
        return mensagensList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView quemMandouTextView;
        private TextView oQueMandouTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            quemMandouTextView = itemView.findViewById(R.id.quemMandouTextView);
            oQueMandouTextView = itemView.findViewById(R.id.oqueMandouTextView);
        }
    }
}
