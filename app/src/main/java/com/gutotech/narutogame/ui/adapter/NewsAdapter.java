package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    public interface OnNewsClickListener {
        void onNewsClicked(News news);
    }

    private final int LATEST_NEWS = 0;

    private Context mContext;
    private List<News> mNewsList;
    private OnNewsClickListener mOnNewsClickListener;

    public NewsAdapter(Context context, OnNewsClickListener listener) {
        mContext = context;
        mOnNewsClickListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == LATEST_NEWS) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(
                    R.layout.adapter_lastest_news, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(
                    R.layout.adapter_news, viewGroup, false);
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        if (mNewsList != null) {
            News news = mNewsList.get(position);
            myViewHolder.dateTextView.setText(news.getDate());
            myViewHolder.titleTextView.setText(news.getTitle());
            myViewHolder.postedByTextView.setText(mContext.getString(R.string.posted_by, news.getBy()));

            if (position == LATEST_NEWS) {
                myViewHolder.messageTextView.setText(news.getMessage());
            }

            myViewHolder.itemView.setOnClickListener(v -> mOnNewsClickListener.onNewsClicked(news));

            if (position % 2 == 0) {
                myViewHolder.detailImageView.setImageResource(R.drawable.layout_home_detalhe);
                myViewHolder.linearLayout.setBackgroundColor(
                        mContext.getResources().getColor(R.color.colorItem1));
            } else {
                myViewHolder.detailImageView.setImageResource(R.drawable.layout_home_detalhe1);
                myViewHolder.linearLayout.setBackgroundColor(
                        mContext.getResources().getColor(R.color.colorItem2));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mNewsList != null ? mNewsList.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == LATEST_NEWS) {
            return LATEST_NEWS;
        } else {
            return 1;
        }
    }

    public void setNewsList(List<News> newsList) {
        mNewsList = newsList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView dateTextView;
        private TextView titleTextView;
        private TextView messageTextView;
        private TextView postedByTextView;
        private ImageView detailImageView;
        private LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            messageTextView = itemView.findViewById(R.id.messageTextView);
            postedByTextView = itemView.findViewById(R.id.postedByTextView);
            detailImageView = itemView.findViewById(R.id.detailImageView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
