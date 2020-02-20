package com.gutotech.narutogame.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Ninja;
import com.gutotech.narutogame.utils.StorageUtil;

import java.util.List;

public class ChooseNinjaRecyclerViewAdapter extends RecyclerView.Adapter<ChooseNinjaRecyclerViewAdapter.ViewHolder> {

    public interface NinjaListener {
        void onNinjaClick(Ninja ninja);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ninjaImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ninjaImageView = itemView.findViewById(R.id.profileImageView);
        }
    }

    private List<Ninja> mNinjasList;
    private NinjaListener mListener;
    private int positionSelected;

    public ChooseNinjaRecyclerViewAdapter(NinjaListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_profile_pequena, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mNinjasList != null) {
            Ninja ninja = mNinjasList.get(position);

            StorageUtil.downloadSmallProfile(holder.ninjaImageView.getContext(),
                    holder.ninjaImageView, ninja.getId());

            if (positionSelected == position) {
                holder.ninjaImageView.setAlpha(1f);
            } else {
                holder.ninjaImageView.setAlpha(0.5f);
            }

            holder.ninjaImageView.setOnClickListener(v -> {
                mListener.onNinjaClick(ninja);
                positionSelected = position;
                notifyDataSetChanged();
            });
        }
    }

    @Override
    public int getItemCount() {
        return mNinjasList != null ? mNinjasList.size() : 0;
    }

    public void setNinjasId(List<Ninja> ninjasList) {
        mNinjasList = ninjasList;
        positionSelected = 0;
        mListener.onNinjaClick(mNinjasList.get(0));
        notifyDataSetChanged();
    }
}
