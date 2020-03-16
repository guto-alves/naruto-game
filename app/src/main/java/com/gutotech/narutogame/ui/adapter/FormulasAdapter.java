package com.gutotech.narutogame.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Formula;

import java.util.List;

public class FormulasAdapter extends RecyclerView.Adapter<FormulasAdapter.MyViewHolder> {

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

    private Formula[] mFormulas;
    private List<Integer> mTotalPointsForEachAttribute;

    public FormulasAdapter(List<Integer> formulas) {
        mTotalPointsForEachAttribute = formulas;
        mFormulas = Formula.values();
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
        Formula formula = mFormulas[i];
        Integer total = mTotalPointsForEachAttribute.get(i);

        myViewHolder.nameTextView.setText(formula.name);
        myViewHolder.iconImageView.setImageResource(formula.icon);
        myViewHolder.totalTextView.setText(String.valueOf(total));
        myViewHolder.totalProgressBar.setProgress(total);
    }

    @Override
    public int getItemCount() {
        return mFormulas.length;
    }
}
