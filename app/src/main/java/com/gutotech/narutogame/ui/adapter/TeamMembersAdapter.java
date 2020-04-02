package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.GraduationUtils;
import com.gutotech.narutogame.data.model.Member;
import com.gutotech.narutogame.data.repository.TeamRepository;
import com.gutotech.narutogame.data.firebase.StorageUtils;

import java.util.List;

public class TeamMembersAdapter extends RecyclerView.Adapter<TeamMembersAdapter.ViewHolder> {

    public interface RemoveMemberClickListener {
        void onRemoveMemberClick(String memberId);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nickTextView;
        private ImageView profileImageView;
        private TextView infoTextView;
        private TextView leaderOrMemberTextView;
        private ProgressBar expProgressBar;
        private TextView expTextView;
        private Button removeMemberButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImageView = itemView.findViewById(R.id.profileImageView);
            nickTextView = itemView.findViewById(R.id.nickTextView);
            infoTextView = itemView.findViewById(R.id.infoTextView);
            leaderOrMemberTextView = itemView.findViewById(R.id.leaderOrMemberTextView);
            expProgressBar = itemView.findViewById(R.id.expProgressBar);
            expTextView = itemView.findViewById(R.id.expTextView);
            removeMemberButton = itemView.findViewById(R.id.removeMemberButton);
        }
    }

    private Context mContext;
    private List<Member> mMembers;
    private String mLeaderId;
    private RemoveMemberClickListener mRemoveMemberClickListener;

    public TeamMembersAdapter(Context context, RemoveMemberClickListener listener) {
        mContext = context;
        mRemoveMemberClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_team_member, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mMembers != null) {
            Member member = mMembers.get(position);

            holder.removeMemberButton.setVisibility(View.INVISIBLE);

            TeamRepository.getInstance().getMemberChar(member.getMemberId(), character -> {
                StorageUtils.downloadProfile(holder.profileImageView.getContext(),
                        holder.profileImageView, character.getProfilePath());

                holder.nickTextView.setText(character.getNick());
                holder.infoTextView.setText(mContext.getString(R.string.label_graduation_and_lvl,
                        mContext.getString(GraduationUtils.getName(character.getGraduationId(), character.getVillage())),
                        character.getLevel()));

                if (character.isOnline()) {
                    holder.nickTextView.setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.layout_on, 0, 0, 0);
                } else {
                    holder.nickTextView.setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.layout_off, 0, 0, 0);
                }

                if (mLeaderId.equals(CharOn.character.getId())) {
                    holder.removeMemberButton.setVisibility(View.VISIBLE);
                }

                if (mLeaderId.equals(character.getId())) {
                    holder.removeMemberButton.setVisibility(View.INVISIBLE);
                    holder.leaderOrMemberTextView.setText(R.string.leader);
                } else {
                    holder.leaderOrMemberTextView.setText(R.string.member);
                }

                holder.removeMemberButton.setOnClickListener(v ->
                        mRemoveMemberClickListener.onRemoveMemberClick(character.getId()));
            });

            holder.expProgressBar.setMax(member.getMaxExp());
            holder.expProgressBar.setProgress(member.getCurrentExp());
            holder.expTextView.setText(mContext.getString(
                    R.string.member_exp_progress, member.getCurrentExp(), member.getMaxExp()));
        }
    }

    @Override
    public int getItemCount() {
        return mMembers != null ? mMembers.size() : 0;
    }

    public void setMembers(List<Member> members, String leaderId) {
        mMembers = members;
        mLeaderId = leaderId;
        notifyDataSetChanged();
    }
}
