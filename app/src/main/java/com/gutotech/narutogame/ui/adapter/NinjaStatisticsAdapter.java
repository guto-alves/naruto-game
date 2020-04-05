package com.gutotech.narutogame.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.firebase.StorageUtils;
import com.gutotech.narutogame.data.model.NinjaStatistics;

import java.util.List;

public class NinjaStatisticsAdapter extends RecyclerView.Adapter<NinjaStatisticsAdapter.MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout bgLinear;
        private ImageView imageView;
        private TextView nameTextView;
        private TextView totalPlayersTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            totalPlayersTextView = itemView.findViewById(R.id.totalPlayersTextView);
            bgLinear = itemView.findViewById(R.id.bgLinear);
        }
    }

    private Context mContext;
    private List<NinjaStatistics> mNinjaStatisticsList;

    public NinjaStatisticsAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_ninja_statistics_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        if (mNinjaStatisticsList != null) {
            NinjaStatistics ninjaStatistics = mNinjaStatisticsList.get(i);

            StorageReference imageRef = FirebaseConfig.getStorage()
                    .child("images/home")
                    .child(ninjaStatistics.ninjaId + ".jpg");
            StorageUtils.downloadImage(mContext, imageRef, myViewHolder.imageView);

            myViewHolder.nameTextView.setText(ninjaStatistics.name);
            myViewHolder.totalPlayersTextView.setText(mContext.getString(R.string.players,
                    ninjaStatistics.totalPlayers));

            if (i / 2 % 2 == 1) {
                myViewHolder.bgLinear.setBackgroundColor(
                        mContext.getResources().getColor(R.color.colorItem2));
            } else {
                myViewHolder.bgLinear.setBackgroundColor(
                        mContext.getResources().getColor(R.color.colorItem1));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mNinjaStatisticsList != null ? mNinjaStatisticsList.size() : 0;
    }

    public void setNinjaStatisticsList(List<NinjaStatistics> ninjaStatistics) {
        mNinjaStatisticsList = ninjaStatistics;
        notifyDataSetChanged();
    }
}
