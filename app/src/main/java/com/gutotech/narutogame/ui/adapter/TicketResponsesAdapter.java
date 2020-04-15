package com.gutotech.narutogame.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.TicketResponse;
import com.gutotech.narutogame.databinding.AdapterTicketResponseBinding;

import java.util.List;

public class TicketResponsesAdapter extends RecyclerView.Adapter<TicketResponsesAdapter.MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private AdapterTicketResponseBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    private List<TicketResponse> mTicketResponses;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        AdapterTicketResponseBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()), R.layout.adapter_ticket_response,
                viewGroup, false);
        return new MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        if (mTicketResponses != null) {
            TicketResponse ticketResponse = mTicketResponses.get(i);
            holder.binding.setResponse(ticketResponse);
        }
    }

    @Override
    public int getItemCount() {
        return mTicketResponses != null ? mTicketResponses.size() : 0;
    }

    public void setTicketResponses(List<TicketResponse> responses) {
        mTicketResponses = responses;
        notifyDataSetChanged();
    }
}
