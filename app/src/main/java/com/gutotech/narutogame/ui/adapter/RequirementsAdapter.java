package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Requirement;

import java.util.List;

public class RequirementsAdapter extends RecyclerView.Adapter<RequirementsAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView requirementTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            requirementTextView = itemView.findViewById(R.id.requirementTextView);
        }
    }

    private Context mContext;
    private List<Requirement> mRequirements;

    public RequirementsAdapter(Context context, List<Requirement> requirements) {
        mContext = context;
        mRequirements = requirements;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycler_requirement_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Requirement requirement = mRequirements.get(position);

        holder.requirementTextView.setText(requirement.show(mContext));

        if (requirement.check()) {
            holder.requirementTextView.setPaintFlags(
                    holder.requirementTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.requirementTextView.setTextColor(Color.WHITE);
        } else {
            holder.requirementTextView.setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return mRequirements.size();
    }
}
