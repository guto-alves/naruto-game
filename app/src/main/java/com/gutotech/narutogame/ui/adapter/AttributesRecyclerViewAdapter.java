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
import com.gutotech.narutogame.data.model.AttributeItem;

import java.util.List;

public class AttributesRecyclerViewAdapter extends RecyclerView.Adapter<AttributesRecyclerViewAdapter.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder {
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

    private List<AttributeItem> attributeItems;

    public AttributesRecyclerViewAdapter(List<AttributeItem> attributeItems) {
        this.attributeItems = attributeItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.recycler_attribute_list_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final AttributeItem atributo = attributeItems.get(i);

        myViewHolder.nameTextView.setText(atributo.getAttribute().name);
        myViewHolder.iconImageView.setImageResource(atributo.getAttribute().icon);
        myViewHolder.totalTextView.setText(String.valueOf(atributo.getTotal()));
        myViewHolder.totalProgressBar.setProgress(atributo.getTotal());
    }

    @Override
    public int getItemCount() {
        return attributeItems.size();
    }
}
