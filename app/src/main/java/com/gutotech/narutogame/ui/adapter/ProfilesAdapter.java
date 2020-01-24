package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Ninja;
import com.gutotech.narutogame.utils.StorageUtil;

public class ProfilesAdapter extends RecyclerView.Adapter<ProfilesAdapter.ViewHolder> {

    public interface OnProfileClickListener {
        void onProfileClick(int profile);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView profileImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profileImageView = itemView.findViewById(R.id.profileImageView);
        }
    }

    private Ninja mNinja;
    private OnProfileClickListener mOnProfileClickListener;

    public ProfilesAdapter(Ninja ninja, OnProfileClickListener onProfileClickListener) {
        mNinja = ninja;
        mOnProfileClickListener = onProfileClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_profile, null, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StorageUtil.downloadProfile(holder.profileImageView.getContext(), holder.profileImageView,
                mNinja.getId(), position + 1);

        holder.itemView.setOnClickListener(v ->
                mOnProfileClickListener.onProfileClick(position + 1));
    }

    @Override
    public int getItemCount() {
        return mNinja.getTotalProfiles();
    }
}
