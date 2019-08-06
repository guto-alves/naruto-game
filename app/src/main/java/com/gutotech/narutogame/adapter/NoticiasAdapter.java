package com.gutotech.narutogame.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.model.Noticia;

import java.util.List;

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.MyViewHolder> {
    private List<Noticia> noticiaList;
    private Context context;

    private final int NOTICIA_TROFEU = 1;

    public NoticiasAdapter(Context context, List<Noticia> noticiaList) {
        this.noticiaList = noticiaList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == 0)
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_noticias_trofeu, viewGroup, false);
        else
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_noticias, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.dateTextView.setText(noticiaList.get(i).getData());
        myViewHolder.titleTextView.setText(noticiaList.get(i).getTitulo());
        myViewHolder.postedByTextView.setText("postado por " + noticiaList.get(i).getPor());

        if (i == 0)
            myViewHolder.messageTextView.setText(noticiaList.get(i).getMensagem());

        if (i % 2 == 0) {
            myViewHolder.detalheImageView.setImageResource(R.drawable.layout_home_detalhe);
            myViewHolder.bg_linear.setBackgroundColor(context.getResources().getColor(R.color.colorItem1));
        } else {
            myViewHolder.detalheImageView.setImageResource(R.drawable.layout_home_detalhe1);
            myViewHolder.bg_linear.setBackgroundColor(context.getResources().getColor(R.color.colorItem2));
        }
    }

    @Override
    public int getItemCount() {
        return noticiaList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return 0;
        else
            return 1;
    }

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
}
