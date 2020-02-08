package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.ui.playing.currentvillage.VillageMapPopupWindow;
import com.gutotech.narutogame.ui.playing.currentvillage.VillageMapViewModel;
import com.gutotech.narutogame.utils.StorageUtil;

import java.util.List;
import java.util.Map;

public class VillageMapRecyclerViewAdapter extends RecyclerView.Adapter<VillageMapRecyclerViewAdapter.ViewHolder> {

    public interface OnMapClickListener {
        void onDoubleClick(int newPosition);

        void onBattleClick(Character opp);
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

    private Context mContext;
    private final int MAP_LENGTH;
    private Map<Integer, List<Character>> mMap;
    private OnMapClickListener mOnMapClickListener;

    private VillageMapPopupWindow mPopupWindow;

    public VillageMapRecyclerViewAdapter(Context context, int length, OnMapClickListener listener) {
        mContext = context;
        MAP_LENGTH = length;
        mOnMapClickListener = listener;
        mPopupWindow = new VillageMapPopupWindow(context);
        mPopupWindow.setBattleClickListener(opponent -> mOnMapClickListener.onBattleClick(opponent));
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
        if (mMap != null) {
            List<Character> characterList = mMap.get(position);

            if (characterList != null) {
                final int SIZE = characterList.size();

                for (int i = 0; i < SIZE; i++) {
                    Character character = characterList.get(i);

                    if (character.getNick().equals(CharOn.character.getNick())) {
                        holder.backgroundImageView.setImageResource(R.drawable.layout_map_me2);
                    } else if (character.getVillage() == CharOn.character.getVillage()) {
                        holder.backgroundImageView.setImageResource(R.drawable.layout_map_green2);
                    } else {
                        holder.backgroundImageView.setImageResource(R.drawable.layout_map_red2);
                    }

                    holder.spriteImageView.setVisibility(View.VISIBLE);
                    StorageUtil.downloadSprite(holder.spriteImageView, character.getNinja().getId());
                }
            } else {
                holder.backgroundImageView.setImageResource(R.drawable.layout_map_blank2);
                holder.spriteImageView.setVisibility(View.GONE);
            }
        }

        holder.itemView.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetectorCompat mDetector = new GestureDetectorCompat(mContext,
                    new GestureDetector.SimpleOnGestureListener() {
                        @Override
                        public boolean onDown(MotionEvent e) {
                            return true;
                        }

                        @Override
                        public boolean onSingleTapUp(MotionEvent e) {
                            mPopupWindow.setCharactersList(mMap.get(position));

                            int xoff;
                            int yoff;

                            if (position % VillageMapViewModel.TOTAL_COLUMNS < 5) {
                                xoff = holder.itemView.getWidth() + 5;
                            } else {
                                xoff = -(mPopupWindow.getContentView().getWidth() + 5);
                            }

                            yoff = -holder.itemView.getHeight() + 5;

                            mPopupWindow.showAsDropDown(holder.itemView, xoff, yoff);

                            return true;
                        }

                        @Override
                        public boolean onDoubleTap(MotionEvent e) {
                            mOnMapClickListener.onDoubleClick(position);
                            return true;
                        }
                    });

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mDetector.onTouchEvent(event);
            }
        });
    }

    @Override
    public int getItemCount() {
        return MAP_LENGTH;
    }

    public void setMap(Map<Integer, List<Character>> map) {
        mMap = map;
        notifyDataSetChanged();
    }
}
