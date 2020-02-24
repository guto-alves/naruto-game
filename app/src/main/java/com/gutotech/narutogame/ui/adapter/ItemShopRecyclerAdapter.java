package com.gutotech.narutogame.ui.adapter;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
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
import com.gutotech.narutogame.utils.StorageUtil;
import com.gutotech.narutogame.data.model.Ramen;

import java.util.List;
import java.util.Locale;

public class ItemShopRecyclerAdapter extends RecyclerView.Adapter<ItemShopRecyclerAdapter.ViewHolder> {

    public interface OnBuyClickListener {
        void onBuyButtonClick(ShopItem item, int quantity);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
    private List<ShopItem> mItemsList;
    private FragmentManager mFragmentManager;
    private OnBuyClickListener mOnBuyButtonListener;

    public ItemShopRecyclerAdapter(Context context, FragmentManager fragmentManager,
                                   OnBuyClickListener onBuyButtonListener) {
        mContext = context;
        mFragmentManager = fragmentManager;
        mOnBuyButtonListener = onBuyButtonListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.recycler_shop_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {
        if (mItemsList != null) {
            final ShopItem itemShop = mItemsList.get(i);

            if (itemShop instanceof Ramen) {
                StorageUtil.downloadRamen(mContext, holder.itemImageView, itemShop.getImage());
            } else {
                StorageUtil.downloadScroll(mContext, holder.itemImageView, itemShop.getImage());
            }

            holder.nameTextView.setText(itemShop.getName());
            holder.descriptionTextView.setText(itemShop.getDescription());
            holder.valueTextView.setText(mContext.getString(R.string.ry, itemShop.getValue()));

            if (validateRequirements(itemShop.getRequirements())) {
                holder.buyButton.setEnabled(true);
            } else {
                holder.buyButton.setEnabled(false);
            }

            holder.quantityEditText.setOnKeyListener((v, keyCode, event) -> {
                int quantity = 1;

                if (!holder.quantityEditText.getText().toString().isEmpty()) {
                    quantity = Integer.parseInt(holder.quantityEditText.getText().toString());
                }

                int newValue = itemShop.getValue() * quantity;

                holder.valueTextView.setText(mContext.getString(R.string.ry, newValue));
                return false;
            });

            holder.itemImageView.setOnClickListener(v -> {
                // show dialog with info about item
            });

            holder.requerImageView.setOnClickListener(v -> {
                DialogFragment dialog = new RequirementDialogFragment(itemShop.getRequirements());
                dialog.show(mFragmentManager, "RequirementDialogFragment");
            });

            holder.buyButton.setOnClickListener(v -> {
                int quantity = 1;

                if (!holder.quantityEditText.getText().toString().isEmpty()) {
                    quantity = Integer.parseInt(holder.quantityEditText.getText().toString());
                }

                mOnBuyButtonListener.onBuyButtonClick(itemShop, quantity);
            });

            if (i % 2 == 0) {
                holder.bgLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorItem1));
            } else {
                holder.bgLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorItem2));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mItemsList != null ? mItemsList.size() : 0;
    }

    public void setItemsList(List<ShopItem> items) {
        mItemsList = items;
        notifyDataSetChanged();
    }

    private boolean validateRequirements(List<Requirement> requirements) {
        for (Requirement requirement : requirements) {
            if (!requirement.check()) {
                return false;
            }
        }

        return true;
    }

    private void exibirRecuperaRamen(Ramen ramen) {
        Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.dialog_info_ramen);

        TextView nomeTextView = dialog.findViewById(R.id.nomeTextView);
        TextView recuperaHp = dialog.findViewById(R.id.recuperaHpTextView);
        TextView recuperaChak = dialog.findViewById(R.id.recuperaChakraTextView);
        TextView recuperaSta = dialog.findViewById(R.id.recuperaStaminaTextView);

        nomeTextView.setText(ramen.getName());

        recuperaHp.setText(String.format(Locale.getDefault(), "Recupera %d ponto(s)", ramen.getRecovers()));
        recuperaChak.setText(String.format(Locale.getDefault(), "Recupera %d ponto(s)", ramen.getRecovers()));
        recuperaSta.setText(String.format(Locale.getDefault(), "Recupera %d ponto(s)", ramen.getRecovers()));
        dialog.show();
    }

}
