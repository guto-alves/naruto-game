package com.gutotech.narutogame.ui.adapter;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.PersonagemOn;
import com.gutotech.narutogame.utils.StorageUtil;

import java.util.List;

public class VillageMapRecyclerViewAdapter extends RecyclerView.Adapter<VillageMapRecyclerViewAdapter.ViewHolder> {

    public interface OnMapClickListener {
        void onClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView backgroundImageView;
        private ImageView spriteImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            backgroundImageView = itemView.findViewById(R.id.backgroundImageView);
            spriteImageView = itemView.findViewById(R.id.spriteImageView);
        }
    }

    private final int length;
    private List<Character> charactersOnTheMapList;

    public VillageMapRecyclerViewAdapter(int length) {
        this.length = length;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_village_map, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (charactersOnTheMapList != null) {

            boolean emptyPosition = true;

            final int SIZE = charactersOnTheMapList.size();

            for (int i = 0; i < SIZE; i++) { // check for someone in that position
                Character character = charactersOnTheMapList.get(i);

                if (character.getMapPosition() == position) {

                    if (character.getNick().equals(PersonagemOn.character.getNick())) {
                        holder.backgroundImageView.setImageResource(R.drawable.layout_map_me2);
                    } else if (character.getVillage() == PersonagemOn.character.getVillage()) {
                        holder.backgroundImageView.setImageResource(R.drawable.layout_map_green2);
                    } else {
                        holder.backgroundImageView.setImageResource(R.drawable.layout_map_red2);
                    }

                    StorageUtil.downloadSprite(holder.spriteImageView, character.getNinja().getId());

                    emptyPosition = false;

                    break;
                }
            }

            if (emptyPosition) {
                holder.spriteImageView.setVisibility(View.GONE);
                holder.backgroundImageView.setImageResource(R.drawable.layout_map_blank2);
            }
        }
    }


    @Override
    public int getItemCount() {
        return length;
    }

    public void setCharactersOnTheMapList(List<Character> charactersOnTheMapList) {
        this.charactersOnTheMapList = charactersOnTheMapList;
        notifyDataSetChanged();
    }
}
