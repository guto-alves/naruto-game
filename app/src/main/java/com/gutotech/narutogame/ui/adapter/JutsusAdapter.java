package com.gutotech.narutogame.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.model.JutsuInfo;
import com.gutotech.narutogame.data.firebase.StorageUtils;
import com.gutotech.narutogame.utils.SoundUtil;

import java.util.List;

public class JutsusAdapter extends RecyclerView.Adapter<JutsusAdapter.ViewHolder> {

    public interface OnJutsuClickListener {
        void onJutsuClick(Jutsu jutsu);

        void onJutsuInfoClick(View anchor, Jutsu jutsu);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView jutsuImageView;
        private TextView remainingIntervals;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            jutsuImageView = itemView.findViewById(R.id.jutsuImageView);
            remainingIntervals = itemView.findViewById(R.id.remainingIntervals);
        }
    }

    private List<Jutsu> mJutsusList;
    private Context mContext;
    private OnJutsuClickListener mOnJutsuClickListener;
    private boolean mAnimationRunning;
    private boolean mUpdateJutsus;

    public JutsusAdapter(Context context, OnJutsuClickListener jutsuClickListener) {
        mContext = context;
        mOnJutsuClickListener = jutsuClickListener;
    }

    @NonNull
    @Override
    public JutsusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_battle_jutsu_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        if (mJutsusList != null) {
            Jutsu jutsu = mJutsusList.get(i);

            StorageUtils.loadJutsu(holder.jutsuImageView, JutsuInfo.valueOf(jutsu.getName()).image);

            if (jutsu.getRemainingIntervals() > 0) {
                holder.jutsuImageView.setAlpha(0.5f);
                holder.remainingIntervals.setText(String.valueOf(jutsu.getRemainingIntervals()));
                holder.remainingIntervals.setVisibility(View.VISIBLE);
            } else {
                holder.jutsuImageView.setAlpha(1.0f);
                holder.remainingIntervals.setVisibility(View.GONE);
            }

            holder.itemView.setOnTouchListener(new View.OnTouchListener() {
                private GestureDetectorCompat gesture = new GestureDetectorCompat(mContext,
                        new GestureDetector.SimpleOnGestureListener() {
                            @Override
                            public boolean onDown(MotionEvent e) {
                                return true;
                            }

                            @Override
                            public boolean onSingleTapUp(MotionEvent e) {
                                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.fade_out);
                                animation.setAnimationListener(mAnimationListener);
                                holder.itemView.startAnimation(animation);
                                mAnimationRunning = true;
                                mOnJutsuClickListener.onJutsuClick(jutsu);
                                SoundUtil.play(mContext, R.raw.sound_btn);
                                return super.onSingleTapUp(e);
                            }

                            @Override
                            public void onLongPress(MotionEvent e) {
                                mOnJutsuClickListener.onJutsuInfoClick(holder.itemView, jutsu);
                            }
                        });

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    gesture.onTouchEvent(event);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mJutsusList != null ? mJutsusList.size() : 0;
    }

    public void setJutsusList(List<Jutsu> jutsusList) {
        mJutsusList = jutsusList;
        if (!mAnimationRunning) {
            notifyDataSetChanged();
        } else {
            mUpdateJutsus = true;
        }
    }

    private final Animation.AnimationListener mAnimationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            mAnimationRunning = false;
            if (mUpdateJutsus) {
                notifyDataSetChanged();
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    };
}
