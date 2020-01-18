package com.gutotech.narutogame.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.utils.StorageUtil;
import com.gutotech.narutogame.data.model.LotteryItem;

import java.util.List;
import java.util.Locale;

public class LotteryItemsRecyclerAdapter extends RecyclerView.Adapter<LotteryItemsRecyclerAdapter.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;
        private TextView descriptionTextView;
        private TextView chanceTextView;
        private ConstraintLayout bgConstraint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImageView = itemView.findViewById(R.id.itemImageView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            chanceTextView = itemView.findViewById(R.id.chanceTextView);
            bgConstraint = itemView.findViewById(R.id.bgConstraint);
        }
    }

    private Context context;
    private List<LotteryItem> lotteryItems;

    public LotteryItemsRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.recycler_lottery_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int i) {
        if (lotteryItems != null) {
            LotteryItem item = lotteryItems.get(i);

            StorageUtil.downloadLotteryItem(holder.itemImageView, item.getImage());
            holder.descriptionTextView.setText(item.getDescription());
            holder.chanceTextView.setText(String.format(Locale.getDefault(),
                    "%d%%", item.getChancesOfWin()));

            if (i % 2 == 0) {
                holder.bgConstraint.setBackgroundColor(
                        context.getResources().getColor(R.color.colorItem1));
            } else {
                holder.bgConstraint.setBackgroundColor(
                        context.getResources().getColor(R.color.colorItem2));
            }
        }
    }

    @Override
    public int getItemCount() {
        return lotteryItems != null ? lotteryItems.size() : 0;
    }

    public void setLotteryItems(List<LotteryItem> lotteryItems) {
        this.lotteryItems = lotteryItems;
        notifyDataSetChanged();
    }
}
