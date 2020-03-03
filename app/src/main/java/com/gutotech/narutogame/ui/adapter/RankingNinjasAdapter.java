package com.gutotech.narutogame.ui.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.utils.StorageUtil;

import java.util.List;

public class RankingNinjasAdapter extends RecyclerView.Adapter<RankingNinjasAdapter.MyViewHolder> {
    private Context mContext;
    private List<Character> mNinjas;

    public RankingNinjasAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.adapter_ninja_item,
                viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {
        if (mNinjas != null) {
            final Character character = mNinjas.get(i);

            StorageUtil.downloadDojo(mContext, holder.characterImageView, character.getNinja().getId());

            holder.positionTextView.setText(String.format("%dº", i + 1));
            holder.nickTextView.setText(character.getNick());
            holder.levelTextView.setText(String.valueOf(character.getLevel()));
            holder.scoreTextView.setText(String.valueOf(character.getScore()));

            holder.nickTextView.setOnClickListener(v -> showDetails(character));

            if (character.getTitle() != 0) {
                holder.titleTextView.setVisibility(View.VISIBLE);
                holder.titleTextView.setText(mContext.getString(character.getTitle()));
            } else {
                holder.titleTextView.setVisibility(View.GONE);
            }

            if (character.isOnline()) {
                holder.nickTextView.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.layout_on, 0, 0, 0);
            } else {
                holder.nickTextView.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.layout_off, 0, 0, 0);
            }

            holder.villageImageView.setImageResource(character.getVillage().bandanaResId);

            if (i < 3) {
                holder.positionTextView.setTypeface(null, Typeface.BOLD);
                holder.nickTextView.setTypeface(null, Typeface.BOLD);
                holder.positionTextView.setTextColor(mContext.getResources().getColor(R.color.colorYellowLight));
                holder.nickTextView.setTextColor(mContext.getResources().getColor(R.color.colorYellowLight));
            } else {
                holder.positionTextView.setTypeface(null, Typeface.NORMAL);
                holder.nickTextView.setTypeface(null, Typeface.NORMAL);
                holder.positionTextView.setTextColor(mContext.getResources().getColor(R.color.colorText));
                holder.nickTextView.setTextColor(mContext.getResources().getColor(android.R.color.holo_blue_light));
            }

            if (character.equals(CharOn.character)) {
                holder.bgConstraint.setBackgroundColor(mContext.getResources().getColor(R.color.colorLogPurple));
            } else if (i % 2 == 0) {
                holder.bgConstraint.setBackgroundColor(mContext.getResources().getColor(R.color.colorItem1));
            } else {
                holder.bgConstraint.setBackgroundColor(mContext.getResources().getColor(R.color.colorItem2));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mNinjas != null ? mNinjas.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView positionTextView;
        private TextView nickTextView;
        private TextView titleTextView;
        private TextView levelTextView;
        private TextView scoreTextView;

        private ImageView villageImageView;
        private ImageView characterImageView;
        private ConstraintLayout bgConstraint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            positionTextView = itemView.findViewById(R.id.positionTextView);
            nickTextView = itemView.findViewById(R.id.nickTextView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            levelTextView = itemView.findViewById(R.id.levelTextView);
            scoreTextView = itemView.findViewById(R.id.scoreTextView);
            villageImageView = itemView.findViewById(R.id.villageImageView);
            characterImageView = itemView.findViewById(R.id.characterImageView);
            bgConstraint = itemView.findViewById(R.id.bgConstraint);
        }
    }

    public void setNinjas(List<Character> ninjas) {
        mNinjas = ninjas;
        notifyDataSetChanged();
    }

    private void showDetails(Character character) {
        Dialog profileDialog = new Dialog(mContext);
        profileDialog.setContentView(R.layout.dialog_acao_profile);

        ImageView profileLogadoimageView = profileDialog.findViewById(R.id.profilePersonagemOnImageView);
        StorageUtil.downloadProfile(mContext, profileLogadoimageView, character.getProfilePath());

        TextView nickPersonagemOnTextView = profileDialog.findViewById(R.id.nickPersonagemOnTextView);
        nickPersonagemOnTextView.setText(character.getNick());

        TextView classe = profileDialog.findViewById(R.id.classeTextView);
        classe.setText(String.valueOf(character.getClasse()));

        TextView vila = profileDialog.findViewById(R.id.vilaTextView);
        vila.setText(String.valueOf(character.getVillage()));

        TextView level = profileDialog.findViewById(R.id.levelTextView);
        level.setText(String.valueOf(character.getLevel()));

        profileDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        profileDialog.show();
    }
}
