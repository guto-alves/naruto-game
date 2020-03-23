package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Team;
import com.gutotech.narutogame.data.repository.TeamRepository;

import java.util.List;

public class TeamsParticipateAdapter extends RecyclerView.Adapter<TeamsParticipateAdapter.ViewHolder> {

    public interface OnParticipateClickListener {
        void onParticipateClick(Team team);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView teamNameTextView;
        private TextView leaderNameTextView;
        private TextView membersQuantityTextView;
        private Button participateButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teamNameTextView = itemView.findViewById(R.id.teamNameTextView);
            leaderNameTextView = itemView.findViewById(R.id.leaderNameTextView);
            membersQuantityTextView = itemView.findViewById(R.id.membersQuantityTextView);
            participateButton = itemView.findViewById(R.id.participateButton);
        }
    }

    private Context mContext;
    private List<Team> mTeams;
    private OnParticipateClickListener mOnParticipateClickListener;

    public TeamsParticipateAdapter(Context context, OnParticipateClickListener l) {
        mContext = context;
        mOnParticipateClickListener = l;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_team_participate_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {
        if (mTeams != null) {
            Team team = mTeams.get(i);

            holder.teamNameTextView.setText(team.getName());

            TeamRepository.getInstance().getMember(team.getMemberIds().get(0),
                    leader -> holder.leaderNameTextView.setText(leader.getNick()));

            holder.membersQuantityTextView.setText(String.valueOf(team.getMemberIds().size()));

            holder.participateButton.setOnClickListener(v ->
                    mOnParticipateClickListener.onParticipateClick(team));

            if (i % 2 == 0) {
                holder.itemView.setBackgroundColor(mContext.getResources().getColor(R.color.colorItem1));
            } else {
                holder.itemView.setBackgroundColor(mContext.getResources().getColor(R.color.colorItem2));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mTeams != null ? mTeams.size() : 0;
    }

    public void setTeams(List<Team> teams) {
        mTeams = teams;
        notifyDataSetChanged();
    }
}
