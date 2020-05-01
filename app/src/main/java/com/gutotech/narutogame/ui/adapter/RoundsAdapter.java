package com.gutotech.narutogame.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;

import java.util.List;

public class RoundsAdapter extends RecyclerView.Adapter<RoundsAdapter.MyViewHolder> {

    public interface RoundClickListener {
        void onRoundClick(String round);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private Button roundTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            roundTextView = itemView.findViewById(R.id.roundTextView);
        }
    }

    private List<String> mRounds;
    private RoundClickListener mTicketClickListener;
    private int mRoundSelectedIndex;

    public RoundsAdapter(RoundClickListener clickListener) {
        mTicketClickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_round_label, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        if (mRounds != null) {
            String round = mRounds.get(i);

            holder.roundTextView.setText(round);

            holder.roundTextView.setOnClickListener(v -> {
                mTicketClickListener.onRoundClick(round);
                mRoundSelectedIndex = i;
                notifyDataSetChanged();
            });

            if (mRoundSelectedIndex == i) {
                holder.roundTextView.setBackgroundResource(R.drawable.bg_green_button);
            } else {
                holder.roundTextView.setBackgroundResource(R.drawable.bg_button);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mRounds != null ? mRounds.size() : 0;
    }

    public void setRounds(List<String> rounds) {
        mRounds = rounds;
        notifyDataSetChanged();
    }
}
