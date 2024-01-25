package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Enhancement;
import com.gutotech.narutogame.utils.SoundUtil;

import java.util.List;

public class EnhancementsAdapter extends RecyclerView.Adapter<EnhancementsAdapter.ViewHolder> {

    public interface OnEnhancementClickListener {
        void onEnhancementClick(Enhancement enhancement);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.itemImageView);
        }
    }

    private List<Enhancement> mEnhancements;
    private Context mContext;
    private OnEnhancementClickListener mOnEnhencementClickListener;
    private int mItemSelectedIndex;

    public EnhancementsAdapter(Context context, OnEnhancementClickListener listener) {
        mContext = context;
        mOnEnhencementClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_enhancement, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        if (mEnhancements != null) {
            Enhancement enhancement = mEnhancements.get(i);

            holder.itemImageView.setImageResource(enhancement.getImage());

            if (i == mItemSelectedIndex) {
                holder.itemImageView.setAlpha(1.0f);
            } else {
                holder.itemImageView.setAlpha(0.5f);
            }

            holder.itemView.setOnClickListener(v -> {
                mItemSelectedIndex = i;
                mOnEnhencementClickListener.onEnhancementClick(enhancement);
                SoundUtil.play(mContext, R.raw.sound_btn);
                notifyDataSetChanged();
            });
        }
    }

    @Override
    public int getItemCount() {
        return mEnhancements != null ? mEnhancements.size() : 0;
    }

    public void setEnhancements(List<Enhancement> jutsusList) {
        mEnhancements = jutsusList;
        notifyDataSetChanged();
    }

    public List<Enhancement> getEnhancements() {
        return mEnhancements;
    }
}
