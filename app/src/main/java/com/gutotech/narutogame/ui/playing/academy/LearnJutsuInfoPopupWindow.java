package com.gutotech.narutogame.ui.playing.academy;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import androidx.core.widget.PopupWindowCompat;
import androidx.databinding.DataBindingUtil;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.model.JutsuInfo;
import com.gutotech.narutogame.databinding.PopupLearnJutsuInfoBinding;
import com.gutotech.narutogame.utils.SoundUtil;

public class LearnJutsuInfoPopupWindow extends PopupWindow {
    private Context mContext;

    private PopupLearnJutsuInfoBinding mBinding;

    public LearnJutsuInfoPopupWindow(Context context) {
        super(context);
        mContext = context;

        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.popup_learn_jutsu_info, null, false);

        setContentView(mBinding.getRoot());

        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(true);
    }

    public void setJutsu(Jutsu jutsu, JutsuInfo jutsuInfo) {
        mBinding.setJutsu(jutsu);
        mBinding.setJutsuInfo(jutsuInfo);

        mBinding.effectsTextView.setVisibility(View.GONE);
        mBinding.atkNinGenTextView.setVisibility(View.VISIBLE);
        mBinding.atkTaiBukTextView.setVisibility(View.VISIBLE);
        mBinding.defTextView.setVisibility(View.VISIBLE);
        mBinding.accTextView.setVisibility(View.VISIBLE);

        if (jutsu.getBaseDefense() == 0) {
            mBinding.defTextView.setVisibility(View.GONE);
        }

        if (jutsu.getAtk() == 0) {
            mBinding.atkNinGenTextView.setVisibility(View.GONE);
            mBinding.atkTaiBukTextView.setVisibility(View.GONE);
        }

        if (jutsuInfo.type == Jutsu.Type.ATK) {
            mBinding.accTextView.setVisibility(View.GONE);
        }

        if (jutsuInfo.type == Jutsu.Type.ATK || jutsuInfo.type == Jutsu.Type.BUFF) {
            if (jutsu.getClasse() == Classe.NIN || jutsu.getClasse() == Classe.GEN) {
                mBinding.atkTaiBukTextView.setVisibility(View.GONE);
            } else {
                mBinding.atkNinGenTextView.setVisibility(View.GONE);
            }
        }

        if (jutsu.isBuffOrDebuff(jutsuInfo)) {
            mBinding.effectsTextView.setVisibility(View.VISIBLE);
            mBinding.accTextView.setVisibility(View.VISIBLE);

            if (jutsuInfo.type == Jutsu.Type.BUFF) {
                mBinding.effectsTextView.setText(R.string.effects_on_your_character);
            } else {
                mBinding.effectsTextView.setText(R.string.effects_on_your_enemy);
            }
        }
    }

    @Override
    public void showAsDropDown(View anchor) {
        PopupWindowCompat.showAsDropDown(this, anchor, 0, 0,
                Gravity.TOP | Gravity.END);
        SoundUtil.play(mContext, R.raw.sound_pop);
    }
}
