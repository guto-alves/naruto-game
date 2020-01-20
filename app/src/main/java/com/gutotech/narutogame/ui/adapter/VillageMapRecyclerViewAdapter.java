package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.ui.playing.currentvillage.VillageMapViewModel;
import com.gutotech.narutogame.utils.StorageUtil;

import java.util.List;

public class VillageMapRecyclerViewAdapter extends RecyclerView.Adapter<VillageMapRecyclerViewAdapter.ViewHolder> {

    public interface OnMapClickListener {
        void onSingleClick(int position);

        void onDoubleClick(int newPosition);
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

    private Context context;
    private final int length;
    private List<Character> charactersOnTheMapList;
    private OnMapClickListener onMapClickListener;

    private PopupWindow popupWindow;

    public VillageMapRecyclerViewAdapter(Context context, int length, OnMapClickListener onMapClickListener) {
        this.context = context;
        this.length = length;
        this.onMapClickListener = onMapClickListener;

        popupWindow = new PopupWindow(context);
        View view = LayoutInflater.from(context).inflate(R.layout.popup_village_map, null);
        popupWindow.setContentView(view);
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

                    if (character.getNick().equals(CharOn.character.getNick())) {
                        holder.backgroundImageView.setImageResource(R.drawable.layout_map_me2);
                    } else if (character.getVillage() == CharOn.character.getVillage()) {
                        holder.backgroundImageView.setImageResource(R.drawable.layout_map_green2);
                    } else {
                        holder.backgroundImageView.setImageResource(R.drawable.layout_map_red2);
                    }

                    holder.spriteImageView.setVisibility(View.VISIBLE);
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

        holder.itemView.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetectorCompat mDetector = new GestureDetectorCompat(context,
                    new GestureDetector.SimpleOnGestureListener() {
                        @Override
                        public boolean onDown(MotionEvent e) {
                            return true;
                        }

                        @Override
                        public boolean onSingleTapUp(MotionEvent e) {
                            onMapClickListener.onSingleClick(position);

                            if (popupWindow.isShowing()) {
                                popupWindow.dismiss();
                            }

                            if (position % VillageMapViewModel.TOTAL_COLUMNS < 5) {
                                popupWindow.showAsDropDown(holder.itemView,
                                        holder.itemView.getWidth(),
                                        -holder.itemView.getHeight() + 5);
                            } else {
                                popupWindow.showAsDropDown(holder.itemView,
                                        -popupWindow.getContentView().getWidth() - 10,
                                        -holder.itemView.getHeight() + 5);
                            }

                            return true;
                        }

                        @Override
                        public boolean onDoubleTap(MotionEvent e) {
                            onMapClickListener.onDoubleClick(position);
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
        return length;
    }

    public void setCharactersOnTheMapList(List<Character> charactersOnTheMapList) {
        this.charactersOnTheMapList = charactersOnTheMapList;
        notifyDataSetChanged();
    }
}
