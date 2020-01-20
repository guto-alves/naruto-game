package com.gutotech.narutogame.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.AttributeItem;

import java.util.ArrayList;
import java.util.List;

public class DistributedPointsRecyclerAdapter extends RecyclerView.Adapter<DistributedPointsRecyclerAdapter.MyViewHolder> {

    public interface OnTrainButtonListener {
        void onTrainButtonClick(AttributeItem attribute);
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
    private List<AttributeItem> distributedAttributes;
    private int max = 0;

    private OnTrainButtonListener mListener;

    public DistributedPointsRecyclerAdapter(Context context) {
        mContext = context;
        distributedAttributes = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.recycler_distributed_points, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {
        if (distributedAttributes != null) {
            final AttributeItem attribute = distributedAttributes.get(i);

            holder.nameTextView.setText(attribute.getAttribute().name);
            holder.iconImageView.setImageResource(attribute.getAttribute().icon);
            holder.totalTextView.setText(String.valueOf(attribute.getTotal()));
            holder.totalProgressBar.setMax(max);
            holder.totalProgressBar.setProgress(attribute.getTotal());
            holder.quantitySpinner.getSelectedItem();

            holder.trainButton.setOnClickListener(v -> {
                mListener.onTrainButtonClick(attribute);
            });

//            if (PersonagemOn.character.getAttributes().get > 0) {
//                holder.trainButton.setVisibility(View.VISIBLE);
//            } else {
//                holder.trainButton.setVisibility(View.GONE);
//            }

            if (i % 2 == 0) {
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
        return distributedAttributes != null ? distributedAttributes.size() : 0;
    }

    public void setDistributedAttributes(List<AttributeItem> distributedAttributes) {
        this.distributedAttributes = distributedAttributes;

        max = distributedAttributes.get(0).getTotal();

        for (int i = 1; i < 10; i++) {
            int total = distributedAttributes.get(i).getTotal();
            if (total > max) {
                max = total;
            }
        }

        notifyDataSetChanged();
    }
}
