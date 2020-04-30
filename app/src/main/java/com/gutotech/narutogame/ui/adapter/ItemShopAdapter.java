package com.gutotech.narutogame.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Requirement;
import com.gutotech.narutogame.data.model.ShopItem;
import com.gutotech.narutogame.ui.playing.RequirementDialogFragment;
import com.gutotech.narutogame.data.firebase.StorageUtils;
import com.gutotech.narutogame.data.model.Ramen;
import com.gutotech.narutogame.ui.playing.currentvillage.RamenInfoPopupWindow;

import java.util.List;

public class ItemShopAdapter extends RecyclerView.Adapter<ItemShopAdapter.ViewHolder> {

    public interface OnBuyClickListener {
        void onBuyButtonClick(ShopItem item, int quantity);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;
        private TextView nameTextView;
        private TextView descriptionTextView;
        private TextView valueTextView;
        private ImageView requerImageView;
        private EditText quantityEditText;
        private Button buyButton;
        private ConstraintLayout bgLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            requerImageView = itemView.findViewById(R.id.requerImageView);
            valueTextView = itemView.findViewById(R.id.valueTextView);
            quantityEditText = itemView.findViewById(R.id.quantityEditText);
            buyButton = itemView.findViewById(R.id.buyButton);
            bgLayout = itemView.findViewById(R.id.bgLayout);
        }
    }

    private Context mContext;
    private List<ShopItem> mShopItems;
    private FragmentManager mFragmentManager;
    private OnBuyClickListener mOnBuyButtonListener;
    private RamenInfoPopupWindow mRamenInfoPopupWindow;

    public ItemShopAdapter(Context context, FragmentManager fragmentManager,
                           OnBuyClickListener onBuyButtonListener) {
        mContext = context;
        mFragmentManager = fragmentManager;
        mOnBuyButtonListener = onBuyButtonListener;
        mRamenInfoPopupWindow = new RamenInfoPopupWindow(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_shop_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {
        if (mShopItems != null) {
            ShopItem itemShop = mShopItems.get(i);

            if (itemShop instanceof Ramen) {
                StorageUtils.downloadRamen(mContext, holder.itemImageView, itemShop.getImage());
            } else {
                StorageUtils.downloadScroll(mContext, holder.itemImageView, itemShop.getImage());
            }

            holder.itemImageView.setOnClickListener(v -> {
                if (itemShop instanceof Ramen) {
                    showRamenInfo((Ramen) itemShop, holder.itemImageView);
                }
            });

            holder.nameTextView.setText(itemShop.getName());
            holder.descriptionTextView.setText(itemShop.getDescription());
            holder.valueTextView.setText(mContext.getString(R.string.ry, itemShop.getValue()));

            holder.requerImageView.setOnClickListener(v ->
                    RequirementDialogFragment.getInstance(itemShop.getRequirements())
                            .openDialog(mFragmentManager, mContext)
            );

            if (validateRequirements(itemShop.getRequirements())) {
                holder.buyButton.setEnabled(true);
            } else {
                holder.buyButton.setEnabled(false);
            }

            holder.quantityEditText.setOnKeyListener((v, keyCode, event) -> {
                int quantity = getInput(holder.quantityEditText);

                int newValue = itemShop.getValue() * quantity;

                holder.valueTextView.setText(mContext.getString(R.string.ry, newValue));
                return false;
            });

            holder.buyButton.setOnClickListener(v ->
                    mOnBuyButtonListener.onBuyButtonClick(itemShop, getInput(holder.quantityEditText))
            );

            if (i % 2 == 0) {
                holder.bgLayout.setBackgroundColor(
                        ContextCompat.getColor(mContext, R.color.colorItem1)
                );
            } else {
                holder.bgLayout.setBackgroundColor(
                        ContextCompat.getColor(mContext, R.color.colorItem2)
                );
            }
        }
    }

    @Override
    public int getItemCount() {
        return mShopItems != null ? mShopItems.size() : 0;
    }

    public void setItemsList(List<ShopItem> items) {
        mShopItems = items;
        notifyDataSetChanged();
    }

    private boolean validateRequirements(List<Requirement> requirements) {
        if (requirements == null) {
            return true;
        }

        for (Requirement requirement : requirements) {
            if (!requirement.check()) {
                return false;
            }
        }

        return true;
    }

    private void showRamenInfo(Ramen ramen, View anchor) {
        mRamenInfoPopupWindow.setRamen(ramen);
        mRamenInfoPopupWindow.showAsDropDown(anchor);
    }

    private int getInput(EditText editText) {
        int quantity = 1;

        String input = editText.getText().toString().trim()
                .replaceAll("[^\\d]", "");

        if (!input.isEmpty()) {
            quantity = Math.abs(Integer.parseInt(input));
        }

        return quantity;
    }

}
