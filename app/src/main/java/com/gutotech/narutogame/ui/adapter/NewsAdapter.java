package com.gutotech.narutogame.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView dateTextView;
        private TextView titleTextView;
        private TextView messageTextView;
        private TextView postedByTextView;
        private ImageView detalheImageView;
        private LinearLayout bg_linear;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            dateTextView = itemView.findViewById(R.id.dateTextView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            messageTextView = itemView.findViewById(R.id.messageTextView);
            postedByTextView = itemView.findViewById(R.id.postedByTextView);
            detalheImageView = itemView.findViewById(R.id.detalheImageView);
            bg_linear = itemView.findViewById(R.id.linearbgnoticia);
        }
    }

    private final int TROPHY_NEWS = 0;

    private Context context;
    private List<News> newsList;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == TROPHY_NEWS)
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_noticias_trofeu, viewGroup, false);
        else
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_news_item, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        if (newsList != null) {
            News news = newsList.get(position);
            myViewHolder.dateTextView.setText(news.getDate());
            myViewHolder.titleTextView.setText(news.getTitle());
            myViewHolder.postedByTextView.setText("postado por " + news.getBy());

            if (position == 0)
                myViewHolder.messageTextView.setText(news.getMessage());

            if (position % 2 == 0) {
                myViewHolder.detalheImageView.setImageResource(R.drawable.layout_home_detalhe);
                myViewHolder.bg_linear.setBackgroundColor(context.getResources().getColor(R.color.colorItem1));
            } else {
                myViewHolder.detalheImageView.setImageResource(R.drawable.layout_home_detalhe1);
                myViewHolder.bg_linear.setBackgroundColor(context.getResources().getColor(R.color.colorItem2));
            }
        }

    }

    @Override
    public int getItemCount() {
        return newsList != null ? newsList.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == TROPHY_NEWS)
            return TROPHY_NEWS;
        else
            return 1;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }
}
