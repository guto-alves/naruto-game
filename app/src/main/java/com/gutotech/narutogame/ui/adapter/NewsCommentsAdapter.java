package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Comment;

import java.util.List;

public class NewsCommentsAdapter extends RecyclerView.Adapter<NewsCommentsAdapter.MyViewHolder> {
    private Context mContext;
    private List<Comment> mComments;

    public NewsCommentsAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(
                R.layout.adapter_news_comment, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        if (mComments != null) {
            Comment comment = mComments.get(i);

            holder.byTextView.setText(comment.getBy());
            holder.messageTextView.setText(comment.getMessage());
            holder.dateTextView.setText(comment.getDate());

            if (i % 2 == 0) {
                holder.linearLayout.setBackgroundColor(
                        mContext.getResources().getColor(R.color.colorItem1));
            } else {
                holder.linearLayout.setBackgroundColor(
                        mContext.getResources().getColor(R.color.colorItem2));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mComments != null ? mComments.size() : 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView byTextView;
        private TextView messageTextView;
        private TextView dateTextView;
        private LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            byTextView = itemView.findViewById(R.id.byTextView);
            messageTextView = itemView.findViewById(R.id.messageTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }

    public void setComments(List<Comment> comments) {
        mComments = comments;
        notifyDataSetChanged();
    }
}
