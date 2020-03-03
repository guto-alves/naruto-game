package com.gutotech.narutogame.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.TimeMission;
import com.gutotech.narutogame.data.model.Mission;
import com.gutotech.narutogame.data.model.MissionInfo;
import com.gutotech.narutogame.data.model.Requirement;

import java.util.List;

public class TasksRecyclerViewAdapter extends RecyclerView.Adapter<TasksRecyclerViewAdapter.MyViewHolder> {

    public interface OnAcceptClickListener {
        void onAcceptClick(Mission task);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView descriptionTextView;
        private TextView requirementsTextView;
        private Button acceptButton;
        private ConstraintLayout bgLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            requirementsTextView = itemView.findViewById(R.id.requirementsTextView);
            acceptButton = itemView.findViewById(R.id.acceptButton);
            bgLayout = itemView.findViewById(R.id.bgLayout);
        }
    }

    private Context mContext;
    private List<TimeMission> mTasks;
    private OnAcceptClickListener mOnAcceptClickListener;

    public TasksRecyclerViewAdapter(Context context, OnAcceptClickListener listener) {
        mContext = context;
        mOnAcceptClickListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_initial_task, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {
        if (mTasks != null) {
            final TimeMission task = mTasks.get(i);

            MissionInfo info = task.missionInfo();

            holder.titleTextView.setText(info.title);
            holder.descriptionTextView.setText(info.description);
            holder.requirementsTextView.setText(info.requirements.get(0).toString(mContext));

            if (validateRequirements(info.requirements)) {
                holder.acceptButton.setEnabled(true);
                holder.acceptButton.setOnClickListener(v -> mOnAcceptClickListener.onAcceptClick(task));
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
        return mTasks != null ? mTasks.size() : 0;
    }

    public void setTasks(List<TimeMission> tasks) {
        mTasks = tasks;
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
