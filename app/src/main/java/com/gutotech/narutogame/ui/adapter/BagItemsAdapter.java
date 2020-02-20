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
import com.gutotech.narutogame.data.model.ShopItem;
import com.gutotech.narutogame.utils.StorageUtil;
import com.gutotech.narutogame.data.model.Ramen;

import java.util.List;

public class BagItemsAdapter extends RecyclerView.Adapter<BagItemsAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(ShopItem itemClicked, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;
        private TextView quantityTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImageView = itemView.findViewById(R.id.itemImageView);
            quantityTextView = itemView.findViewById(R.id.quantityTextView);
        }
    }

    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private List<ShopItem> mItems;

    public BagItemsAdapter(Context context, List<ShopItem> items, OnItemClickListener l) {
        mContext = context;
        mItems = items;
        mOnItemClickListener = l;
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
        if (mItems != null) {
            ShopItem item = mItems.get(i);

            if (item instanceof Ramen) {
                StorageUtil.downloadRamen(mContext, holder.itemImageView, item.getImage());
            } else {
                StorageUtil.downloadScroll(mContext, holder.itemImageView, item.getImage());
            }

            holder.quantityTextView.setText(mContext.getString(
                    R.string.item_quantity, item.getInventory())
            );

            holder.itemView.setOnClickListener(v -> mOnItemClickListener.onItemClick(item, i));
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
