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
import com.gutotech.narutogame.utils.StorageUtil;
import com.gutotech.narutogame.data.model.NinjaStatistics;

import java.util.List;

public class NinjaStatisticsRecyclerViewAdapter extends RecyclerView.Adapter<NinjaStatisticsRecyclerViewAdapter.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder {
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

    private Context context;
    private List<NinjaStatistics> ninjaStatisticsList;

    public NinjaStatisticsRecyclerViewAdapter(Context context) {
        this.context = context;
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
        if (ninjaStatisticsList != null) {
            NinjaStatistics ninjaStatistics = ninjaStatisticsList.get(i);

            StorageReference imageRef = FirebaseConfig.getStorage().child("images").child("home")
                    .child(ninjaStatistics.getNinjaId() + ".jpg");
            StorageUtil.downloadImage(context, imageRef, myViewHolder.imageView);

//            myViewHolder.nameTextView.setText(Helper.nomeDoPersonagem(ninjaStatistics.getNinjaId()));
            myViewHolder.totalPlayersTextView.setText(ninjaStatistics.getTotalPlayers() + " Jogadores");

            if (i / 2 % 2 == 1) {
                myViewHolder.bgLinear.setBackgroundColor(context.getResources().getColor(R.color.colorItem2));
            }
        }
    }

    @Override
    public int getItemCount() {
        return ninjaStatisticsList != null ? ninjaStatisticsList.size() : 0;
    }

    public void setNinjaStatisticsList(List<NinjaStatistics> ninjaStatisticsList) {
        this.ninjaStatisticsList = ninjaStatisticsList;
        notifyDataSetChanged();
    }
}
