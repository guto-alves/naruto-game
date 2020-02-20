package com.gutotech.narutogame.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.JutsuInfo;
import com.gutotech.narutogame.data.model.Requirement;
import com.gutotech.narutogame.databinding.PopupLearnJutsuInfoBinding;
import com.gutotech.narutogame.ui.playing.RequirementDialogFragment;
import com.gutotech.narutogame.utils.StorageUtil;
import com.gutotech.narutogame.data.model.Jutsu;

import java.util.List;

public class JutsusLearnAdapter extends RecyclerView.Adapter<JutsusLearnAdapter.ViewHolder> {

    public interface OnTrainClickListener {
        void onTrainClick(Jutsu jutsu);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView jutsuImageView;
        private TextView nameTextView;
        private TextView descriptionTextView;
        private ImageView requerImageView;
        private Button trainButton;
        private ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            jutsuImageView = itemView.findViewById(R.id.jutsuImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            requerImageView = itemView.findViewById(R.id.requerImageView);
            trainButton = itemView.findViewById(R.id.trainButton);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }

    private Context mContext;
    private List<Jutsu> mJutsusList;
    private FragmentManager mFragmentManager;
    private OnTrainClickListener mOnTrainClickListener;

    public JutsusLearnAdapter(Context context,
                              FragmentManager fragmentManager,
                              OnTrainClickListener trainClickListener) {
        mContext = context;
        mFragmentManager = fragmentManager;
        mOnTrainClickListener = trainClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.recycler_jutsu_learn_item, viewGroup, false);
        return new ViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {
        if (mJutsusList != null) {
            final Jutsu jutsu = mJutsusList.get(i);
            JutsuInfo jutsuInfo = jutsu.getJutsuInfo();

            StorageUtil.downloadJutsu(holder.jutsuImageView, jutsuInfo.image);
            holder.nameTextView.setText(jutsuInfo.name);
            holder.descriptionTextView.setText(jutsuInfo.description);

            holder.jutsuImageView.setOnClickListener(v -> showJutsuInfo(v, jutsu, jutsuInfo));

            boolean folded = jutsu.getClasse() != CharOn.character.getClasse();

            if (validateRequirements(jutsuInfo.requirements, folded)) {
                holder.trainButton.setEnabled(true);
            } else {
                holder.trainButton.setEnabled(false);
            }

            holder.requerImageView.setOnClickListener(v -> {
                DialogFragment dialog = new RequirementDialogFragment(jutsuInfo.requirements, folded);
                dialog.show(mFragmentManager, "RequirementDialogFragment");
            });

            holder.trainButton.setOnClickListener(v -> mOnTrainClickListener.onTrainClick(jutsu));

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

    public void setJutsusList(List<Jutsu> jutsuInfoList) {
        mJutsusList = jutsuInfoList;
        notifyDataSetChanged();
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
        PopupWindow popupWindow = new PopupWindow(mContext);

        PopupLearnJutsuInfoBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.popup_learn_jutsu_info, null, false);

        popupWindow.setContentView(binding.getRoot());

        binding.setJutsu(jutsu);
        binding.setJutsuInfo(jutsuInfo);

        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(anchor);
    }
}
