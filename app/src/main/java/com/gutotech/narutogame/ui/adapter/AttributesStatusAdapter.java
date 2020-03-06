package com.gutotech.narutogame.ui.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Attribute;

import java.util.List;

public class AttributesStatusAdapter extends RecyclerView.Adapter<AttributesStatusAdapter.MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private ImageView iconImageView;
        private TextView totalTextView;
        private ProgressBar totalProgressBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            iconImageView = itemView.findViewById(R.id.iconImageView);
            totalTextView = itemView.findViewById(R.id.totalTextView);
            totalProgressBar = itemView.findViewById(R.id.totalProgressBar);
        }
    }

    private Attribute[] mAttributes;
    private List<Integer> mTotalPointsForEachAttribute;

    public AttributesStatusAdapter(List<Integer> attributes) {
        mTotalPointsForEachAttribute = attributes;
        mAttributes = Attribute.values();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_attribute_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Attribute attribute = mAttributes[i];
        Integer total = mTotalPointsForEachAttribute.get(i);

        myViewHolder.nameTextView.setText(attribute.name);
        myViewHolder.iconImageView.setImageResource(attribute.icon);
        myViewHolder.totalTextView.setText(String.valueOf(total));
        myViewHolder.totalProgressBar.setProgress(total);
    }

    @Override
    public int getItemCount() {
        return mAttributes.length;
    }
}
