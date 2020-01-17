package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.utils.StorageUtil;
import com.gutotech.narutogame.data.model.LotteryItem;

import java.util.List;

public class ItensSorteNinjaRecyclerAdapter extends RecyclerView.Adapter<ItensSorteNinjaRecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<LotteryItem> itensLoteria;

    public ItensSorteNinjaRecyclerAdapter(Context context, List<LotteryItem> itensLoteria) {
        this.context = context;
        this.itensLoteria = itensLoteria;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item_loteria, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        LotteryItem item = itensLoteria.get(i);

        myViewHolder.nomeTextView.setText(item.getDescription());
        myViewHolder.chanceTextView.setText(String.valueOf(item.getChancesOfWin()));

        StorageReference imageRef = FirebaseConfig.getStorage()
                .child("images")
                .child("loteria")
                .child(item.getImage() + ".png");
        StorageUtil.downloadImage(context, imageRef, myViewHolder.itemImageView);

        if (i % 2 == 0)
            myViewHolder.bgConstraint.setBackgroundColor(context.getResources().getColor(R.color.colorItem1));
        else
            myViewHolder.bgConstraint.setBackgroundColor(context.getResources().getColor(R.color.colorItem2));
    }

    @Override
    public int getItemCount() {
        return itensLoteria.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;
        private TextView nomeTextView;
        private TextView chanceTextView;
        private TextView qtdGanhaTextView;
        private ConstraintLayout bgConstraint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImageView = itemView.findViewById(R.id.itemImageView);
            nomeTextView = itemView.findViewById(R.id.nomeItemTextView);
            chanceTextView = itemView.findViewById(R.id.chanceTextView);
            qtdGanhaTextView = itemView.findViewById(R.id.qtdGanhaTextView);
            bgConstraint = itemView.findViewById(R.id.bgConstraint);
        }
    }
}
