package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.GraduationUtils;
import com.gutotech.narutogame.utils.StorageUtil;

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
        private Button removeMemberButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImageView = itemView.findViewById(R.id.profileImageView);
            nickTextView = itemView.findViewById(R.id.nickTextView);
            infoTextView = itemView.findViewById(R.id.infoTextView);
            leaderOrMemberTextView = itemView.findViewById(R.id.leaderOrMemberTextView);
            removeMemberButton = itemView.findViewById(R.id.removeMemberButton);
        }
    }

    private Context mContext;
    private List<Character> mMembers;
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
            Character character = mMembers.get(position);

            StorageUtil.downloadProfile(holder.profileImageView.getContext(),
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

            if (mMembers.get(0).getId().equals(CharOn.character.getId())) {
                holder.removeMemberButton.setVisibility(View.VISIBLE);
            } else {
                holder.removeMemberButton.setVisibility(View.INVISIBLE);
            }

            if (mMembers.get(0).getId().equals(character.getId())) {
                holder.leaderOrMemberTextView.setText(R.string.leader);
                holder.removeMemberButton.setVisibility(View.GONE);
            } else {
                holder.leaderOrMemberTextView.setText(R.string.member);
            }

            holder.removeMemberButton.setOnClickListener(v ->
                    mRemoveMemberClickListener.onRemoveMemberClick(character.getId()));
        }
    }

    @Override
    public int getItemCount() {
        return mMembers != null ? mMembers.size() : 0;
    }

    public void setMembers(List<Character> members) {
        mMembers = members;
        notifyDataSetChanged();
    }
}
