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
import com.gutotech.narutogame.data.firebase.StorageUtils;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

public class VillageMapAdapter extends RecyclerView.Adapter<VillageMapAdapter.ViewHolder> {

    public interface OnMapClickListener {
        void onDoubleClick(int newPosition);

        void onBattleClick(Character opponent);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView backgroundImageView;
        private ImageView spriteImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            backgroundImageView = itemView.findViewById(R.id.backgroundImageView);
            spriteImageView = itemView.findViewById(R.id.spriteImageView);
        }
    }

    private static final SecureRandom random = new SecureRandom();
    private Context mContext;
    private List<Integer> mPlaceEntries;
    private Map<Integer, List<Character>> mMap;
    private OnMapClickListener mOnMapClickListener;

    private VillageMapPopupWindow mPopupWindow;

    public VillageMapAdapter(Context context, List<Integer> placeEntries,
                             OnMapClickListener listener) {
        mContext = context;
        mPlaceEntries = placeEntries;
        mOnMapClickListener = listener;

        mPopupWindow = new VillageMapPopupWindow(context);
        mPopupWindow.setBattleClickListener(opponent ->
                mOnMapClickListener.onBattleClick(opponent));
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
        final boolean IS_PLACE_ENTRY = mPlaceEntries.contains(position);

        if (IS_PLACE_ENTRY) {
            holder.spriteImageView.setImageResource(R.drawable.layout_ico_mapa_vila);
            holder.spriteImageView.setVisibility(View.VISIBLE);
        }

        if (mMap != null) {
            List<Character> characterList = mMap.get(position);

            if (characterList != null) {
                if (IS_PLACE_ENTRY && characterList.contains(CharOn.character)) {
                    holder.backgroundImageView.setImageResource(R.drawable.layout_map_me2);
                } else if (!IS_PLACE_ENTRY) {
                    final int TOTAL_CHARS = characterList.size();

                    Character character = characterList.get(random.nextInt(TOTAL_CHARS));

                    if (character.getNick().equals(CharOn.character.getNick())) {
                        holder.backgroundImageView.setImageResource(R.drawable.layout_map_me2);
                    } else if (character.getVillage() == CharOn.character.getVillage()) {
                        holder.backgroundImageView.setImageResource(R.drawable.layout_map_green2);
                    } else {
                        holder.backgroundImageView.setImageResource(R.drawable.layout_map_red2);
                    }

                    StorageUtils.downloadSprite(holder.spriteImageView, character.getNinja().getId());
                    holder.spriteImageView.setVisibility(View.VISIBLE);
                }
            } else if (!IS_PLACE_ENTRY) {
                holder.backgroundImageView.setImageResource(R.drawable.layout_map_blank2);
                holder.spriteImageView.setVisibility(View.GONE);
            }
        }

        if (mPopupWindow.isShowing() && mPopupWindow.getPosition() == position) {
            mPopupWindow.setCharactersList(mMap.get(position), position);
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
                            mPopupWindow.setCharactersList(mMap.get(position), position);

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
        return VillageMapViewModel.MAP_SIZE;
    }

    public void setMap(Map<Integer, List<Character>> map) {
        mMap = map;
        notifyDataSetChanged();
    }

    public void dismissPopupWindow(){
        mPopupWindow.dismiss();
    }
}
