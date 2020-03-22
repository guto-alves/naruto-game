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
    private Context mContext;
    private List<Ticket> mTicketList;

    private String[] mCategories;

    public TicketsAdapter(Context context) {
        mContext = context;
        mCategories = mContext.getResources().getStringArray(R.array.ticket_categories_list);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(
                R.layout.recycler_tickets, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        if (mTicketList != null) {
            Ticket ticket = mTicketList.get(i);


            myViewHolder.titleTextView.setText(ticket.getTitle());
            myViewHolder.categoryTextView.setText(mCategories[ticket.getCategory()]);
            myViewHolder.statusTextView.setText(ticket.getStatus().statusId);
            myViewHolder.updatedAtTextView.setText(ticket.getDateUpdated());

            myViewHolder.titleTextView.setOnClickListener(v -> {

            });

            if (i % 2 == 0) {
                myViewHolder.bgTickets.setBackgroundColor(
                        mContext.getResources().getColor(R.color.colorItem1));
            } else {
                myViewHolder.bgTickets.setBackgroundColor(
                        mContext.getResources().getColor(R.color.colorItem2));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mTicketList != null ? mTicketList.size() : 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView categoryTextView;
        private TextView statusTextView;
        private TextView updatedAtTextView;
        private ConstraintLayout bgTickets;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
            categoryTextView = itemView.findViewById(R.id.categoryTextView);
            statusTextView = itemView.findViewById(R.id.statusTextView);
            updatedAtTextView = itemView.findViewById(R.id.updatedAtTextView);
            bgTickets = itemView.findViewById(R.id.bgTictkes);
        }
    }

    public void setTicketList(List<Ticket> ticketList) {
        mTicketList = ticketList;
        notifyDataSetChanged();
    }
}
