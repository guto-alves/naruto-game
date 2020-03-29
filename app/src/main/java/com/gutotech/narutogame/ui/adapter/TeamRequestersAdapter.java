package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.utils.StorageUtil;

import java.util.List;

public class TeamRequestersAdapter extends RecyclerView.Adapter<TeamRequestersAdapter.MyViewHolder> {

    public interface RequestersClickListener {
        void onAcceptClick(String requesterId, boolean checked);

        void onRefuseClick(String requesterId, boolean checked);
    }

    private Context mContext;
    private List<Character> mRequesters;
    private RequestersClickListener mRequestersClickListener;

    public TeamRequestersAdapter(Context context, RequestersClickListener listener) {
        mContext = context;
        mRequestersClickListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(
                R.layout.adapter_team_requester, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {
        if (mRequesters != null) {
            final Character character = mRequesters.get(i);

            StorageUtil.downloadDojo(mContext, holder.characterImageView, character.getNinja().getId());

            holder.nickTextView.setText(character.getNick());
            holder.levelTextView.setText(String.valueOf(character.getLevel()));

            if (character.isOnline()) {
                holder.nickTextView.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.layout_on, 0, 0, 0);
            } else {
                holder.nickTextView.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.layout_off, 0, 0, 0);
            }

            holder.acceptCheckBox.setOnClickListener(v ->
                    mRequestersClickListener.onAcceptClick(
                            character.getId(), holder.acceptCheckBox.isChecked()));

            holder.refuseCheckBox.setOnClickListener(v ->
                    mRequestersClickListener.onRefuseClick(
                            character.getId(), holder.refuseCheckBox.isChecked()));

            if (i % 2 == 0) {
                holder.bgConstraint.setBackgroundColor(
                        mContext.getResources().getColor(R.color.colorItem1));
            } else {
                holder.bgConstraint.setBackgroundColor(
                        mContext.getResources().getColor(R.color.colorItem2));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mRequesters != null ? mRequesters.size() : 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView characterImageView;
        private TextView nickTextView;
        private TextView levelTextView;
        private CheckBox acceptCheckBox;
        private CheckBox refuseCheckBox;
        private ConstraintLayout bgConstraint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nickTextView = itemView.findViewById(R.id.nickTextView);
            levelTextView = itemView.findViewById(R.id.levelTextView);
            characterImageView = itemView.findViewById(R.id.characterImageView);
            acceptCheckBox = itemView.findViewById(R.id.acceptCheckBox);
            refuseCheckBox = itemView.findViewById(R.id.refuseCheckBox);
            bgConstraint = itemView.findViewById(R.id.bgConstraint);
        }
    }

    public void setRequesters(List<Character> requesters) {
        mRequesters = requesters;
        notifyDataSetChanged();
    }
}
