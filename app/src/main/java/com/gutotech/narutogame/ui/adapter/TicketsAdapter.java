package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Ticket;

import java.util.List;

public class TicketsAdapter extends RecyclerView.Adapter<TicketsAdapter.MyViewHolder> {
    private Context context;
    private List<Ticket> ticketList;

    public TicketsAdapter(Context context, List<Ticket> ticketList) {
        this.context = context;
        this.ticketList = ticketList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(context).inflate(R.layout.recycler_tickets, viewGroup, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Ticket ticket = ticketList.get(i);

        myViewHolder.tituloTextView.setText(ticket.getTitulo());
        myViewHolder.tituloTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myViewHolder.categoriaTextView.setText(ticket.getCategoria());
        myViewHolder.statusTextView.setText(ticket.getStatus());
        myViewHolder.criacaoTextView.setText(ticket.getDataCriacao());
        myViewHolder.atualizacaoTextView.setText(ticket.getDataAtualizacao());

        if (i % 2 == 0)
            myViewHolder.bgTickets.setBackgroundColor(context.getResources().getColor(R.color.colorItem1));
        else
            myViewHolder.bgTickets.setBackgroundColor(context.getResources().getColor(R.color.colorItem2));
    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tituloTextView;
        private TextView categoriaTextView;
        private TextView statusTextView;
        private TextView criacaoTextView;
        private TextView atualizacaoTextView;
        private ConstraintLayout bgTickets;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tituloTextView = itemView.findViewById(R.id.tituloTextView);
            categoriaTextView = itemView.findViewById(R.id.categoriaTextView);
            statusTextView = itemView.findViewById(R.id.statusTextView);
            criacaoTextView = itemView.findViewById(R.id.criacaoTextView);
            atualizacaoTextView = itemView.findViewById(R.id.atualizacaoTextView);
            bgTickets = itemView.findViewById(R.id.bgTictkes);
        }
    }
}
