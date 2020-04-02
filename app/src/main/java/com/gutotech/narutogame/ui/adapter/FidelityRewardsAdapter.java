package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Reward;
import com.gutotech.narutogame.data.firebase.StorageUtils;

import java.util.List;

public class FidelityRewardsAdapter extends RecyclerView.Adapter<FidelityRewardsAdapter.ViewModel> {

    public interface OnReceiveClickListener {
        void onReceiveClick(Reward reward);
    }

    private Context mContext;
    private List<Reward> mRewards;
    private OnReceiveClickListener mOnReceiveClickListener;

    public FidelityRewardsAdapter(Context context, OnReceiveClickListener listener) {
        mContext = context;
        mOnReceiveClickListener = listener;
    }

    public class ViewModel extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView nameTextView;
        private TextView descriptionTextView;
        private Button receiveButton;

        public ViewModel(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            receiveButton = itemView.findViewById(R.id.receiveButton);
        }
    }

    @NonNull
    @Override
    public ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_loyalty_reward_item, parent, false);
        return new ViewModel(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewModel holder, int position) {
        if (mRewards != null) {
            final Reward reward = mRewards.get(position);
            final int DAY = position + 1;

            StorageUtils.downloadFidelityImage(mContext, holder.imageView, DAY);

            holder.nameTextView.setText(mContext.getString(
                    R.string.logar_days_followed, DAY));
            holder.descriptionTextView.setText(reward.toString(mContext));

            int daysOfFidelity = CharOn.character.getDaysOfFidelity();

            if (DAY == daysOfFidelity && CharOn.character.hasFidelityReward()) {
                holder.receiveButton.setText(R.string.receive);
                holder.receiveButton.setOnClickListener(v ->
                        mOnReceiveClickListener.onReceiveClick(reward));
            } else {
                holder.receiveButton.setOnClickListener(null);

                if (DAY > daysOfFidelity) {
                    holder.receiveButton.setText(R.string.button_not_received);
                    holder.receiveButton.setBackgroundResource(R.drawable.bg_red_button);
                } else {
                    holder.receiveButton.setText(R.string.received);
                    holder.receiveButton.setBackgroundResource(R.drawable.bg_green_button);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return mRewards != null ? mRewards.size() : 0;
    }

    public void setRewards(List<Reward> rewards) {
        mRewards = rewards;
        notifyDataSetChanged();
    }
}
