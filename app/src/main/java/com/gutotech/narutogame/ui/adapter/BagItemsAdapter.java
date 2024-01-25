package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.StorageUtils;
import com.gutotech.narutogame.data.model.Ramen;
import com.gutotech.narutogame.data.model.ShopItem;

import java.util.List;

public class BagItemsAdapter extends RecyclerView.Adapter<BagItemsAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(ShopItem itemClicked, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;
        private TextView quantityTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.itemImageView);
            quantityTextView = itemView.findViewById(R.id.quantityTextView);
        }
    }

    private Context mContext;
    private List<ShopItem> mItems;
    private OnItemClickListener mOnItemClickListener;

    public BagItemsAdapter(Context context, OnItemClickListener listener) {
        mContext = context;
        mOnItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_bag_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {
        if (mItems != null) {
            ShopItem item = mItems.get(i);

            if (item instanceof Ramen) {
                StorageUtils.loadRamen(mContext, holder.itemImageView, item.getImage());
            } else {
                StorageUtils.loadScroll(mContext, holder.itemImageView, item.getImage());
            }

            holder.quantityTextView.setText(
                    mContext.getString(R.string.item_quantity, item.getInventory())
            );

            holder.itemView.setOnClickListener(v ->
                    mOnItemClickListener.onItemClick(item, i)
            );
        }
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    public void setItems(List<ShopItem> items) {
        mItems = items;
        notifyDataSetChanged();
    }
}
