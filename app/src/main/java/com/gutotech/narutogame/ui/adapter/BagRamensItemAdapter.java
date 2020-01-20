package com.gutotech.narutogame.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.utils.StorageUtil;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Ramen;

public class BagRamensItemAdapter extends RecyclerView.Adapter<BagRamensItemAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;
        private TextView quantityTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImageView = itemView.findViewById(R.id.itemImageView);
            quantityTextView = itemView.findViewById(R.id.quantityTextView);
        }
    }

    private Context context;

    public BagRamensItemAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.recycler_bag_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {
        if (CharOn.character.getBag().getRamensList() != null) {
            Ramen ramen = CharOn.character.getBag().getRamensList().get(i);

            StorageUtil.downloadRamen(context, holder.itemImageView, ramen.getImage());

            holder.quantityTextView.setText(context.getString(
                    R.string.bag_item_quantity, ramen.getInventario()));

            holder.itemView.setOnClickListener(v -> {

            });
        }
    }

    @Override
    public int getItemCount() {
        return CharOn.character.getBag().getRamensList() != null ?
                CharOn.character.getBag().getRamensList().size() : 0;
    }
}
