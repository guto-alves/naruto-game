package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.StorageUtils;
import com.gutotech.narutogame.data.model.ElementalJutsu;
import com.gutotech.narutogame.data.model.GraduationUtils;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.model.JutsuInfo;
import com.gutotech.narutogame.ui.playing.academy.LearnedJutsuInfoPopupWindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LearnedJutsusAdapter extends RecyclerView.Adapter<LearnedJutsusAdapter.ViewHolder> {

    public interface LearnedJutsusListener {
        void onVisibilityChanged(Jutsu jutsu);

        void onJutsuSelected(Jutsu jutsu);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView jutsuImageView;
        private TextView nameTextView;
        private TextView descriptionTextView;
        private CheckBox visibleCheckBox;
        private ConstraintLayout constraintLayout;
        private LinearLayout sectionLinearLayout;
        private TextView sectionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            jutsuImageView = itemView.findViewById(R.id.jutsuImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            visibleCheckBox = itemView.findViewById(R.id.visibleCheckBox);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
            sectionLinearLayout = itemView.findViewById(R.id.sectionLinearLayout);
            sectionTextView = itemView.findViewById(R.id.sectionTextView);
        }
    }

    private Context mContext;
    private List<Jutsu> mJutsusList;
    private Map<String, Integer> mSections = new HashMap<>();
    private LearnedJutsuInfoPopupWindow mPopupWindow;
    private LearnedJutsusListener mLearnedJutsusListener;

    public LearnedJutsusAdapter(Context context, LearnedJutsusListener learnedJutsusListener) {
        mContext = context;
        mLearnedJutsusListener = learnedJutsusListener;
        mPopupWindow = new LearnedJutsuInfoPopupWindow(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_learned_jutsu, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {
        if (mJutsusList != null) {
            Jutsu jutsu = mJutsusList.get(i);
            JutsuInfo jutsuInfo = jutsu.getJutsuInfo();

            holder.visibleCheckBox.setChecked(jutsu.isVisible());
            holder.visibleCheckBox.setOnClickListener(v -> {
                jutsu.setVisible(!jutsu.isVisible());
                mLearnedJutsusListener.onVisibilityChanged(jutsu);
            });

            StorageUtils.downloadJutsu(holder.jutsuImageView, jutsuInfo.image);
            holder.jutsuImageView.setOnClickListener(v -> showJutsuInfo(v, jutsu, jutsuInfo));

            String name = mContext.getString(jutsuInfo.name);
            if (jutsu.getLevel() > 0) {
                name += " - Lvl " + jutsu.getLevel();
            }
            holder.nameTextView.setText(name);
            holder.descriptionTextView.setText(jutsuInfo.description);

            if (mSections.containsKey(jutsu.getName())) {
                holder.sectionLinearLayout.setVisibility(View.VISIBLE);
                holder.sectionTextView.setText(mContext.getString(GraduationUtils.getName(
                        jutsu.getJutsuInfo().requirements.get(mSections.get(jutsu.getName()))
                                .getValue())).toUpperCase());
            } else {
                holder.sectionLinearLayout.setVisibility(View.GONE);
            }

            holder.constraintLayout.setOnClickListener(v -> mLearnedJutsusListener.onJutsuSelected(jutsu));

            if (i % 2 == 0) {
                holder.constraintLayout.setBackgroundResource(R.color.colorItem1);
            } else {
                holder.constraintLayout.setBackgroundResource(R.color.colorItem2);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mJutsusList != null ? mJutsusList.size() : 0;
    }

    public void setJutsusList(List<Jutsu> jutsus) {
        mJutsusList = jutsus;
        updateFirstJutsusOfEachGraduation();
        notifyDataSetChanged();
    }

    private void updateFirstJutsusOfEachGraduation() {
        mSections.clear();

        int len = mJutsusList.size();
        if (len == 0) {
            return;
        }

        int c = -1;

        for (int i = 0; i < len; i++) {
            Jutsu jutsu = mJutsusList.get(i);

            int graduationRequirementIndex = jutsu instanceof ElementalJutsu ? 1 : 0;

            int graduationId = jutsu.getJutsuInfo().requirements.get(graduationRequirementIndex).getValue();

            if (c != graduationId) {
                mSections.put(jutsu.getName(), graduationRequirementIndex);
                c = graduationId;
            }
        }
    }

    private void showJutsuInfo(View anchor, Jutsu jutsu, JutsuInfo jutsuInfo) {
        mPopupWindow.setJutsu(jutsu, jutsuInfo);
        mPopupWindow.showAsDropDown(anchor);
    }
}
