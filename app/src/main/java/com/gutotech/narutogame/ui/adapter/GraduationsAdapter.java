package com.gutotech.narutogame.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Graduation;
import com.gutotech.narutogame.data.model.GraduationUtils;
import com.gutotech.narutogame.data.model.Requirement;
import com.gutotech.narutogame.ui.playing.RequirementDialogFragment;

import java.util.List;

public class GraduationsAdapter extends RecyclerView.Adapter<GraduationsAdapter.MyViewHolder> {

    public interface OnGraduateClickListener {
        void onGraduateClick(int graduationId, Graduation graduation);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView descriptionTextView;
        private ImageView requerImageView;
        private Button graduateButton;
        private ConstraintLayout bgConstraint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            requerImageView = itemView.findViewById(R.id.requerImageView);
            graduateButton = itemView.findViewById(R.id.graduateButton);
            bgConstraint = itemView.findViewById(R.id.bgConstraint);
        }
    }

    private Context mContext;
    private Graduation[] mGraduations;
    private OnGraduateClickListener mOnGraduateClickListener;
    private FragmentManager mFragmentManager;

    public GraduationsAdapter(Context context, FragmentManager fragmentManager,
                              OnGraduateClickListener listener) {
        mContext = context;
        mGraduations = Graduation.values();
        mOnGraduateClickListener = listener;
        mFragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_graduation_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int i) {
        int graduationId = i + 1;
        Graduation graduation = mGraduations[graduationId];

        holder.nameTextView.setText(GraduationUtils.getName(graduationId));
        holder.descriptionTextView.setText(GraduationUtils.getDescription(graduationId));

        holder.requerImageView.setOnClickListener(v -> {
            DialogFragment dialog = new RequirementDialogFragment(graduation.requirements);
            dialog.show(mFragmentManager, "RequirementDialogFragment");
        });

        if (validateRequirements(graduation.requirements)) {
            holder.graduateButton.setEnabled(true);
        } else {
            holder.graduateButton.setEnabled(false);
        }

        if (graduationId <= CharOn.character.getGraduationId()) {
            holder.graduateButton.setText(R.string.button_graduated);
            holder.graduateButton.setEnabled(false);
            holder.graduateButton.setBackgroundColor(mContext.getResources().getColor(R.color.colorGreen));
        } else {
            holder.graduateButton.setText(R.string.button_graduate);
        }

        holder.graduateButton.setOnClickListener(v -> mOnGraduateClickListener.onGraduateClick(
                graduationId, graduation));

        if (i % 2 == 0) {
            holder.bgConstraint.setBackgroundColor(mContext.getResources().getColor(R.color.colorItem1));
        } else {
            holder.bgConstraint.setBackgroundColor(mContext.getResources().getColor(R.color.colorItem2));
        }
    }

    @Override
    public int getItemCount() {
        return 6;
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
