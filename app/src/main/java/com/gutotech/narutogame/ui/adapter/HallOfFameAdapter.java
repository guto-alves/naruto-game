package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.StorageUtils;
import com.gutotech.narutogame.data.model.Character;

import java.util.List;

public class HallOfFameAdapter extends RecyclerView.Adapter<HallOfFameAdapter.MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nickTextView;
        private TextView levelTextView;
        private TextView scoreTextView;
        private ImageView villageImageView;
        private ImageView characterImageView;
        private ConstraintLayout bgConstraint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nickTextView = itemView.findViewById(R.id.nickTextView);
            levelTextView = itemView.findViewById(R.id.levelTextView);
            scoreTextView = itemView.findViewById(R.id.scoreTextView);
            villageImageView = itemView.findViewById(R.id.villageImageView);
            characterImageView = itemView.findViewById(R.id.characterImageView);
            bgConstraint = itemView.findViewById(R.id.bgConstraint);
        }
    }

    private Context mContext;
    private List<Character> mKages;

    public HallOfFameAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_hall_of_fame_kage, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {
        if (mKages != null) {
            final Character character = mKages.get(i);

            StorageUtils.downloadDojo(mContext, holder.characterImageView, character.getNinja().getId());

            holder.nickTextView.setText(character.getNick());
            holder.levelTextView.setText(String.valueOf(character.getLevel()));
            holder.scoreTextView.setText(String.valueOf(character.getScore()));

            holder.villageImageView.setImageResource(character.getVillage().bandanaResId);

            if (i == 0) {
                holder.nickTextView.setTypeface(null, Typeface.BOLD);
                holder.nickTextView.setTextColor(
                        ContextCompat.getColor(mContext, R.color.colorYellowLight));
            } else {
                holder.nickTextView.setTypeface(null, Typeface.NORMAL);
                holder.nickTextView.setTextColor(
                        ContextCompat.getColor(mContext, android.R.color.holo_blue_light));
            }

            if (i % 2 == 0) {
                holder.bgConstraint.setBackgroundColor(
                        ContextCompat.getColor(mContext, R.color.colorItem1));
            } else {
                holder.bgConstraint.setBackgroundColor(
                        ContextCompat.getColor(mContext, R.color.colorItem2));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mKages != null ? mKages.size() : 0;
    }

    public void setKages(List<Character> kages) {
        mKages = kages;
        notifyDataSetChanged();
    }
}
