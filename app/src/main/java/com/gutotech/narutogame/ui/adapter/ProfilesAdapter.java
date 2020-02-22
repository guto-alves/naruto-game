package com.gutotech.narutogame.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.utils.StorageUtil;

import java.util.List;

public class ProfilesAdapter extends RecyclerView.Adapter<ProfilesAdapter.ViewHolder> {

    public interface OnProfileClickListener {
        void onProfileClick(String profilePath);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView profileImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profileImageView = itemView.findViewById(R.id.profileImageView);
        }
    }

    private List<StorageReference> mProfileList;
    private OnProfileClickListener mOnProfileClickListener;

    public ProfilesAdapter(List<StorageReference> references,
                           OnProfileClickListener onProfileClickListener) {
        mProfileList = references;
        mOnProfileClickListener = onProfileClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_profile,
                null, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StorageReference storageReference = mProfileList.get(position);
        StorageUtil.downloadImage(holder.profileImageView.getContext(), storageReference,
                holder.profileImageView);

        holder.itemView.setOnClickListener(v ->
                mOnProfileClickListener.onProfileClick(storageReference.getPath()));
    }

    @Override
    public int getItemCount() {
        return mProfileList.size();
    }
}
