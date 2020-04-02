package com.gutotech.narutogame.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.StorageUtils;

import java.util.List;

public class ProfilesAdapter extends RecyclerView.Adapter<ProfilesAdapter.ViewHolder> {

    public interface OnProfileClickListener {
        void onProfileClick(String profilePath);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView profileImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImageView = itemView.findViewById(R.id.profileImageView);
        }
    }

    private List<StorageReference> mProfileList;
    private OnProfileClickListener mOnProfileClickListener;

    public ProfilesAdapter(OnProfileClickListener onProfileClickListener) {
        mOnProfileClickListener = onProfileClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_profile,
                parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mProfileList != null) {
            StorageReference storageReference = mProfileList.get(position);
            StorageUtils.downloadImage(holder.profileImageView.getContext(), storageReference,
                    holder.profileImageView);

            holder.itemView.setOnClickListener(v ->
                    mOnProfileClickListener.onProfileClick(storageReference.getPath()));
        }
    }

    @Override
    public int getItemCount() {
        return mProfileList != null ? mProfileList.size() : 0;
    }

    public void setProfileList(List<StorageReference> profileList) {
        mProfileList = profileList;
        notifyDataSetChanged();
    }
}
