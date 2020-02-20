package com.gutotech.narutogame.ui.playing.battles;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import androidx.databinding.DataBindingUtil;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.model.JutsuInfo;
import com.gutotech.narutogame.databinding.PopupBuffDebuffInfoBinding;

public class BuffDebuffInfoPopupWindow extends PopupWindow {
    private Context mContext;
    private PopupBuffDebuffInfoBinding mBinding;

    public BuffDebuffInfoPopupWindow(Context context) {
        super(context);

        mContext = context;

        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.popup_buff_debuff_info, null, false);

        setContentView(mBinding.getRoot());

        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(true);
    }

    public void setBuffOrDebuff(Jutsu jutsu) {
        JutsuInfo jutsuInfo = jutsu.getJutsuInfo();

        mBinding.setJutsu(jutsu);
        mBinding.setJutsuInfo(jutsuInfo);

        if (jutsuInfo.type == Jutsu.Type.BUFF) {
            mBinding.effectsTextView.setText(R.string.effects_on_your_character);
        } else {
            mBinding.effectsTextView.setText(R.string.effects_on_your_enemy);
        }

        if (jutsu.getBaseDefense() != 0) {
            mBinding.atkOrDefTextView.setText(mContext.getString(R.string.label_base_defense,
                    jutsu.getBaseDefense()));

            mBinding.atkOrDefTextView.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.layout_icones_defense, 0, 0, 0);
        } else {
            mBinding.atkTextView2.setVisibility(View.VISIBLE);

            mBinding.atkOrDefTextView.setText(mContext.getString(R.string.label_atk_tai_buk,
                    jutsu.getAtk()));

            mBinding.atkTextView2.setText(mContext.getString(R.string.label_atk_nin_gen,
                    jutsu.getAtk()));
        }
    }
}
