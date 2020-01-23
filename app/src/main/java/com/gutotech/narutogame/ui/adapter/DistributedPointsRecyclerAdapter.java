package com.gutotech.narutogame.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Attribute;
import com.gutotech.narutogame.data.model.Attributes;
import com.gutotech.narutogame.data.model.CharOn;

import java.util.ArrayList;
import java.util.List;

public class DistributedPointsRecyclerAdapter extends RecyclerView.Adapter<DistributedPointsRecyclerAdapter.MyViewHolder> {

    public interface OnTrainButtonListener {
        void onTrainButtonClick(int attributePosition, int quantitySelectec);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private ImageView iconImageView;
        private TextView totalTextView;
        private ProgressBar totalProgressBar;
        private Spinner quantitySpinner;
        private Button trainButton;
        private ConstraintLayout bgConstraint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextView);
            iconImageView = itemView.findViewById(R.id.iconImageView);
            totalTextView = itemView.findViewById(R.id.totalTextView);
            totalProgressBar = itemView.findViewById(R.id.totalProgressBar);
            quantitySpinner = itemView.findViewById(R.id.freePointsSpinner);
            trainButton = itemView.findViewById(R.id.trainButton);
            bgConstraint = itemView.findViewById(R.id.bgConstraint);
        }
    }

    private Context mContext;
    private List<Integer> mDistributedPoints;
    private OnTrainButtonListener mListener;

    private Attribute[] attributes;
    private int max;
    private int freePoints;
    private ArrayAdapter<Integer> adapterSpinner;

    public DistributedPointsRecyclerAdapter(Context context, OnTrainButtonListener listener) {
        mContext = context;
        mListener = listener;
        attributes = Attribute.values();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.recycler_distributed_points, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        if (mDistributedPoints != null) {
            Attribute attribute = attributes[position];
            final int total = mDistributedPoints.get(position);

            holder.nameTextView.setText(attribute.name);
            holder.iconImageView.setImageResource(attribute.icon);
            holder.totalTextView.setText(String.valueOf(total));
            holder.totalProgressBar.setMax(max);
            holder.totalProgressBar.setProgress(total);
            holder.quantitySpinner.setAdapter(adapterSpinner);

            if (freePoints > 0) {
                holder.trainButton.setEnabled(true);
                holder.quantitySpinner.setVisibility(View.VISIBLE);
            } else {
                holder.trainButton.setEnabled(false);
                holder.quantitySpinner.setVisibility(View.GONE);
            }

            holder.trainButton.setOnClickListener(v -> {
                if (freePoints > 0) {
                    mListener.onTrainButtonClick(position, (Integer) holder.quantitySpinner.getSelectedItem());
                } else {
                    mListener.onTrainButtonClick(position, 1);
                }
            });

            if (position % 2 == 0) {
                holder.bgConstraint.setBackgroundColor(mContext.getResources()
                        .getColor(R.color.colorItem1));
            } else {
                holder.bgConstraint.setBackgroundColor(mContext.getResources()
                        .getColor(R.color.colorItem2));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDistributedPoints != null ? mDistributedPoints.size() : 0;
    }

    public void setDistributedPoints(List<Integer> distributedPoints) {
        mDistributedPoints = distributedPoints;
        freePoints = CharOn.character.getAttributes().getTotalFreePoints();

        List<Integer> spinnerItems = new ArrayList<>();

        for (int i = 0; i < freePoints; i++) {
            spinnerItems.add(i + 1);
        }

        adapterSpinner = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_item, spinnerItems);

        calculteMax();
        notifyDataSetChanged();
    }

    private void calculteMax() {
        max = mDistributedPoints.get(0);

        for (int i = 1; i < Attributes.TOTAL_ATTRIBUTES; i++) {
            int total = mDistributedPoints.get(i);
            if (total > max) {
                max = total;
            }
        }
    }
}
