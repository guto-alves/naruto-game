package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.BattleLog;
import com.gutotech.narutogame.utils.SpannableStringBuilderCustom;

import java.util.List;

public class BattleLogAdapter extends RecyclerView.Adapter<BattleLogAdapter.ViewHolder> {

    public interface OnJutsuInfoClickListener {
        void onJutsuClick(View anchor, BattleLog battleLog);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private View divider;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            divider = itemView.findViewById(R.id.divider);
        }
    }

    private Context mContext;
    private List<BattleLog> mBattleLogs;
    private OnJutsuInfoClickListener mOnJutsuInfoClickListener;

    public BattleLogAdapter(Context context, OnJutsuInfoClickListener jutsuInfoClickListener) {
        mContext = context;
        mOnJutsuInfoClickListener = jutsuInfoClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_battle_log, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mBattleLogs != null) {
            BattleLog battleLog = mBattleLogs.get(position);

            holder.divider.setVisibility(View.GONE);
            holder.textView.setVisibility(View.VISIBLE);

            SpannableStringBuilderCustom logBuilder = new SpannableStringBuilderCustom(mContext);

            if (battleLog.getType() == BattleLog.Type.USES) {
                logBuilder.append(battleLog.getNick());
                logBuilder.append();
                logBuilder.append(R.string.uses, R.color.colorLogBlue);
                logBuilder.append();
                logBuilder.append(battleLog.getAction());
                logBuilder.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        mOnJutsuInfoClickListener.onJutsuClick(widget, battleLog);
                    }
                });
                logBuilder.setForegroundColor(R.color.colorLogAction);
            } else if (battleLog.getType() == BattleLog.Type.RECEIVES) {
                logBuilder.append(battleLog.getNick());
                logBuilder.append();
                logBuilder.append(R.string.receives, R.color.colorLogBlue);
                logBuilder.append();
                logBuilder.append(mContext.getString(R.string.of_damage, battleLog.getAction()));
                logBuilder.setSpan(new ForegroundColorSpan(Color.RED));
            } else if (battleLog.getType() == BattleLog.Type.BUFF_DEBUFF_WEAPON) {
                logBuilder.append(battleLog.getNick());
                logBuilder.append();
                logBuilder.append(R.string.uses, R.color.colorLogPurple);
                logBuilder.append();
                logBuilder.append(battleLog.getAction());
                logBuilder.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        mOnJutsuInfoClickListener.onJutsuClick(widget, battleLog);
                    }
                });
                logBuilder.setForegroundColor(R.color.colorLogPurple);
            } else if (battleLog.getType() == BattleLog.Type.MISSED) {
                logBuilder.append(battleLog.getNick());
                logBuilder.append();
                logBuilder.append(mContext.getString(R.string.missed));
                logBuilder.setForegroundColor(android.R.color.holo_orange_dark);
            } else {
                holder.divider.setVisibility(View.VISIBLE);
                holder.textView.setVisibility(View.GONE);
            }

            holder.textView.setText(logBuilder.getString());
            holder.textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    @Override
    public int getItemCount() {
        return mBattleLogs != null ? mBattleLogs.size() : 0;
    }

    public void setBattleLogs(List<BattleLog> logs) {
        mBattleLogs = logs;
        notifyDataSetChanged();
    }


}
