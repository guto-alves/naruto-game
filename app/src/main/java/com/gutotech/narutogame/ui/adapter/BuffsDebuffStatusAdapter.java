package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.model.JutsuInfo;
import com.gutotech.narutogame.ui.playing.battles.BuffDebuffInfoPopupWindow;
import com.gutotech.narutogame.data.firebase.StorageUtils;

import java.util.List;

public class BuffsDebuffStatusAdapter
        extends RecyclerView.Adapter<BuffsDebuffStatusAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView buffDebuffImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            buffDebuffImageView = itemView.findViewById(R.id.buffDebuffImageView);
        }
    }

    private Context mContext;
    private List<Jutsu> mBuffsDebuffsList;

    public BuffsDebuffStatusAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_buff_debuff_status, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mBuffsDebuffsList != null) {
            Jutsu jutsu = mBuffsDebuffsList.get(position);
            JutsuInfo jutsuInfo = jutsu.getJutsuInfo();

            StorageUtils.downloadJutsu(holder.buffDebuffImageView, jutsuInfo.image);

            holder.itemView.setOnClickListener(v -> showBuffDebuffInfo(v, jutsu));
        }
    }

    @Override
    public int getItemCount() {
        return mBuffsDebuffsList != null ? mBuffsDebuffsList.size() : 0;
    }

    public void setBuffsDebuffsList(List<Jutsu> buffsDebuffsList) {
        mBuffsDebuffsList = buffsDebuffsList;
        notifyDataSetChanged();
    }

    private void showBuffDebuffInfo(View anchor, Jutsu jutsu) {
        BuffDebuffInfoPopupWindow popupWindow = new BuffDebuffInfoPopupWindow(mContext);
        popupWindow.setBuffOrDebuff(jutsu);
        popupWindow.showAsDropDown(anchor);
    }
}
