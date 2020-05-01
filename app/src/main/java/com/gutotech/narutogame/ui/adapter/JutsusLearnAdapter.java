package com.gutotech.narutogame.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.ElementalJutsu;
import com.gutotech.narutogame.data.model.GraduationUtils;
import com.gutotech.narutogame.data.model.JutsuInfo;
import com.gutotech.narutogame.data.model.Requirement;
import com.gutotech.narutogame.ui.playing.RequirementDialogFragment;
import com.gutotech.narutogame.ui.playing.academy.LearnJutsuInfoPopupWindow;
import com.gutotech.narutogame.data.firebase.StorageUtils;
import com.gutotech.narutogame.data.model.Jutsu;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JutsusLearnAdapter extends RecyclerView.Adapter<JutsusLearnAdapter.ViewHolder> {

    public interface OnTrainClickListener {
        void onTrainClick(Jutsu jutsu);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView jutsuImageView;
        private TextView nameTextView;
        private TextView descriptionTextView;
        private ImageView requerImageView;
        private Button trainButton;
        private ConstraintLayout constraintLayout;
        private LinearLayout sectionLinearLayout;
        private TextView sectionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            jutsuImageView = itemView.findViewById(R.id.jutsuImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            requerImageView = itemView.findViewById(R.id.requerImageView);
            trainButton = itemView.findViewById(R.id.trainButton);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
            sectionLinearLayout = itemView.findViewById(R.id.sectionLinearLayout);
            sectionTextView = itemView.findViewById(R.id.sectionTextView);
        }
    }

    private Context mContext;
    private List<Jutsu> mJutsusList;
    private FragmentManager mFragmentManager;
    private OnTrainClickListener mOnTrainClickListener;
    private Set<String> mSections = new HashSet<>();
    private int mGraduationRequirementIndex;

    public JutsusLearnAdapter(Context context, FragmentManager fragmentManager,
                              OnTrainClickListener trainClickListener) {
        mContext = context;
        mFragmentManager = fragmentManager;
        mOnTrainClickListener = trainClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_jutsu_learn_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {
        if (mJutsusList != null) {
            final Jutsu jutsu = mJutsusList.get(i);
            JutsuInfo jutsuInfo = jutsu.getJutsuInfo();

            StorageUtils.downloadJutsu(holder.jutsuImageView, jutsuInfo.image);
            holder.nameTextView.setText(jutsuInfo.name);
            holder.descriptionTextView.setText(jutsuInfo.description);

            holder.jutsuImageView.setOnClickListener(v -> showJutsuInfo(v, jutsu, jutsuInfo));

            boolean folded = jutsu.getClasse() != CharOn.character.getClasse();

            if (validateRequirements(jutsuInfo.requirements, folded)) {
                holder.trainButton.setEnabled(true);
                holder.trainButton.setAlpha(1.0f);
            } else {
                holder.trainButton.setEnabled(false);
                holder.trainButton.setAlpha(0.5f);
            }

            holder.requerImageView.setOnClickListener(v -> {
                RequirementDialogFragment dialog = RequirementDialogFragment.getInstance(
                        jutsuInfo.requirements, folded);
                dialog.openDialog(mFragmentManager, mContext);
            });

            holder.trainButton.setOnClickListener(v -> mOnTrainClickListener.onTrainClick(jutsu));

            if (mSections.contains(jutsu.getName())) {
                holder.sectionLinearLayout.setVisibility(View.VISIBLE);
                holder.sectionTextView.setText(mContext.getString(GraduationUtils.getName(
                        jutsu.getJutsuInfo().requirements.get(mGraduationRequirementIndex).getValue()
                )).toUpperCase());
            } else {
                holder.sectionLinearLayout.setVisibility(View.GONE);
            }

            if (jutsuInfo.toString().contains("SENSEI")) {
                holder.constraintLayout.setBackgroundResource(R.color.colorSensei);
            } else if (i % 2 == 0) {
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
        mGraduationRequirementIndex = mJutsusList.get(0) instanceof ElementalJutsu ? 1 : 0;

        for (int i = 0; i < len; i++) {
            Jutsu jutsu = mJutsusList.get(i);
            int graduationId = jutsu.getJutsuInfo().requirements
                    .get(mGraduationRequirementIndex).getValue();

            if (c != graduationId) {
                mSections.add(jutsu.getName());
                c = graduationId;
            }
        }
    }

    private boolean validateRequirements(List<Requirement> requirements, boolean folded) {
        for (Requirement requirement : requirements) {
            if (!requirement.check(folded)) {
                return false;
            }
        }
        return true;
    }

    private void showJutsuInfo(View anchor, Jutsu jutsu, JutsuInfo jutsuInfo) {
        LearnJutsuInfoPopupWindow popupWindow = new LearnJutsuInfoPopupWindow(mContext);
        popupWindow.setJutsu(jutsu, jutsuInfo);
        popupWindow.showAsDropDown(anchor);
    }
}
