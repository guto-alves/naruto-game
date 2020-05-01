package com.gutotech.narutogame.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
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
import com.gutotech.narutogame.data.model.CharOn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistributedPointsAdapter extends RecyclerView.Adapter<DistributedPointsAdapter.MyViewHolder> {

    public interface OnTrainButtonListener {
        void onTrainButtonClick(int attributePosition, int quantitySelected);

        void onRemoveButtonClick(int attributePosition, int quantitySelected);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private ImageView iconImageView;
        private TextView totalTextView;
        private ProgressBar totalProgressBar;
        private Spinner quantitySpinner;
        private Spinner redistributeQuantitySpinner;
        private Button trainButton;
        private Button removeButton;
        private ConstraintLayout bgConstraint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            iconImageView = itemView.findViewById(R.id.iconImageView);
            totalTextView = itemView.findViewById(R.id.totalTextView);
            totalProgressBar = itemView.findViewById(R.id.totalProgressBar);
            quantitySpinner = itemView.findViewById(R.id.freePointsSpinner);
            redistributeQuantitySpinner = itemView.findViewById(R.id.redistributeQuantitySpinner);
            trainButton = itemView.findViewById(R.id.trainButton);
            removeButton = itemView.findViewById(R.id.removeButton);
            bgConstraint = itemView.findViewById(R.id.bgConstraint);
        }
    }

    private Context mContext;
    private List<Integer> mDistributedPoints;
    private OnTrainButtonListener mListener;

    private Attribute[] mAttributes;
    private int mMax;
    private int mFreePoints;
    private int mRedistributePoints;
    private ArrayAdapter<Integer> mRedistributePointsAdapter;
    private ArrayAdapter<Integer> mTrainPointsAdapter;

    public DistributedPointsAdapter(Context context, OnTrainButtonListener listener) {
        mContext = context;
        mListener = listener;
        mAttributes = Attribute.values();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_distributed_points, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        if (mDistributedPoints != null) {
            Attribute attribute = mAttributes[position];
            int points = mDistributedPoints.get(position);

            holder.nameTextView.setText(attribute.name);
            holder.iconImageView.setImageResource(attribute.icon);
            holder.totalTextView.setText(String.valueOf(points));
            holder.totalProgressBar.setMax(0);
            holder.totalProgressBar.setProgress(0);
            holder.totalProgressBar.setMax(mMax);
            holder.totalProgressBar.setProgress(points);
            holder.quantitySpinner.setAdapter(mTrainPointsAdapter);
            holder.redistributeQuantitySpinner.setAdapter(mRedistributePointsAdapter);

            if (mFreePoints > 0) {
                holder.trainButton.setOnClickListener(v ->
                        mListener.onTrainButtonClick(position,
                                (Integer) holder.quantitySpinner.getSelectedItem())
                );
                holder.trainButton.setEnabled(true);
                holder.trainButton.setAlpha(1f);
                holder.quantitySpinner.setVisibility(View.VISIBLE);
            } else {
                holder.trainButton.setOnClickListener(null);
                holder.trainButton.setEnabled(false);
                holder.trainButton.setAlpha(0.7f);
                holder.quantitySpinner.setVisibility(View.GONE);
            }

            if (mRedistributePoints > 0 && points > 0) {
                holder.removeButton.setOnClickListener(v ->
                        mListener.onRemoveButtonClick(position,
                                (Integer) holder.redistributeQuantitySpinner.getSelectedItem())
                );
                holder.removeButton.setVisibility(View.VISIBLE);
                holder.redistributeQuantitySpinner.setVisibility(View.VISIBLE);
            } else {
                holder.removeButton.setOnClickListener(null);
                holder.removeButton.setVisibility(View.GONE);
                holder.redistributeQuantitySpinner.setVisibility(View.GONE);
            }

            if (position % 2 == 0) {
                holder.bgConstraint.setBackgroundColor(
                        ContextCompat.getColor(mContext, R.color.colorItem1)
                );
            } else {
                holder.bgConstraint.setBackgroundColor(
                        ContextCompat.getColor(mContext, R.color.colorItem2)
                );
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDistributedPoints != null ? mDistributedPoints.size() : 0;
    }

    public void setDistributedPoints(List<Integer> distributedPoints) {
        mDistributedPoints = distributedPoints;
        mFreePoints = CharOn.character.getAttributes().getTotalFreePoints();
        mRedistributePoints = CharOn.character.getAttributes().getTotalRedistributePoints();
        mMax = Collections.max(mDistributedPoints);
        setUpSpinnerAdapters();
        notifyDataSetChanged();
    }

    private void setUpSpinnerAdapters() {
        List<Integer> spinnerItems = new ArrayList<>();

        for (int i = 0; i < mFreePoints; i++) {
            spinnerItems.add(i + 1);
        }

        mTrainPointsAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_item, spinnerItems);
        mTrainPointsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerItems = new ArrayList<>();

        for (int i = 0; i < mRedistributePoints; i++) {
            spinnerItems.add(i + 1);
        }

        mRedistributePointsAdapter = new ArrayAdapter<>(
                mContext, android.R.layout.simple_spinner_item, spinnerItems
        );
    }
}
