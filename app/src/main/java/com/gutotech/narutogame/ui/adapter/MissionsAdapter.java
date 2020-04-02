package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Mission;
import com.gutotech.narutogame.data.model.MissionInfo;
import com.gutotech.narutogame.data.model.Requirement;
import com.gutotech.narutogame.data.model.TimeMission;

import java.util.List;

public class MissionsAdapter extends RecyclerView.Adapter<MissionsAdapter.MyViewHolder> {

    public interface OnAcceptClickListener {
        void onAcceptClick(Mission missions);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView descriptionTextView;
        private TextView rewardsTextView;
        private TextView requirementsTextView;
        private Button acceptButton;
        private ConstraintLayout bgLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            rewardsTextView = itemView.findViewById(R.id.rewardsTextView);
            requirementsTextView = itemView.findViewById(R.id.requirementsTextView);
            acceptButton = itemView.findViewById(R.id.acceptButton);
            bgLayout = itemView.findViewById(R.id.bgLayout);
        }
    }

    private Context mContext;
    private List<Mission> mMissions;
    private OnAcceptClickListener mOnAcceptClickListener;

    public MissionsAdapter(Context context, OnAcceptClickListener listener) {
        mContext = context;
        mOnAcceptClickListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_mission_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {
        if (mMissions != null) {
            final TimeMission missions = (TimeMission) mMissions.get(i);

            MissionInfo info = missions.missionInfo();

            holder.titleTextView.setText(info.title);
            holder.descriptionTextView.setText(info.description);
            holder.rewardsTextView.setText(info.getRewards(mContext));
            holder.requirementsTextView.setText(info.getRequirements(mContext));

            if (validateRequirements(info.requirements)) {
                holder.acceptButton.setEnabled(true);
                holder.acceptButton.setOnClickListener(v -> mOnAcceptClickListener.onAcceptClick(missions));
            } else {
                holder.acceptButton.setEnabled(false);
                holder.acceptButton.setOnClickListener(null);
            }

            if (i % 2 == 0) {
                holder.bgLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorItem1));
            } else {
                holder.bgLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorItem2));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mMissions != null ? mMissions.size() : 0;
    }

    public void setMissions(List<Mission> missions) {
        mMissions = missions;
        notifyDataSetChanged();
    }

    private boolean validateRequirements(List<Requirement> requirements) {
        for (Requirement requirement : requirements) {
            if (!requirement.check()) {
                return false;
            }
        }

        return true;
    }


}
