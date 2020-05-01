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

        if (jutsuInfo.type == Jutsu.Type.DEF) {
            mBinding.atkOrDefTextView.setText(mContext.getString(
                    R.string.label_base_defense, jutsu.getBaseDefense()));

            mBinding.atkOrDefTextView.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.layout_icones_shield, 0, 0, 0);
        } else if (jutsuInfo.type == Jutsu.Type.ATK) {
            int drawable;

            if (jutsu.getClasse() == Classe.TAI || jutsu.getClasse() == Classe.BUK) {
                drawable = (R.drawable.layout_icones_atk_fisico);
                mBinding.atkOrDefTextView.setText(mContext.getString(R.string.label_atk_tai_buk, jutsu.getAtk()));
            } else {
                drawable = (R.drawable.layout_icones_atk_magico);
                mBinding.atkOrDefTextView.setText(mContext.getString(R.string.label_atk_nin_gen, jutsu.getAtk()));
            }

            mBinding.atkOrDefTextView.setCompoundDrawablesWithIntrinsicBounds(
                    drawable, 0, 0, 0);
        } else {
            mBinding.effectsTextView.setVisibility(View.VISIBLE);
            mBinding.accTextView.setVisibility(View.VISIBLE);

            if (jutsuInfo.type == Jutsu.Type.BUFF) {
                mBinding.effectsTextView.setText(R.string.effects_on_your_character);
            } else {
                mBinding.effectsTextView.setText(R.string.effects_on_your_enemy);
            }

            if (jutsu.getBaseDefense() != 0) {
                mBinding.atkOrDefTextView.setText(mContext.getString(
                        R.string.label_base_defense, jutsu.getBaseDefense()));

                mBinding.atkOrDefTextView.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.layout_icones_shield, 0, 0, 0);
            } else {
                if (jutsuInfo.type == Jutsu.Type.BUFF) {
                    int drawable;

                    if (jutsu.getClasse() == Classe.TAI || jutsu.getClasse() == Classe.BUK) {
                        drawable = (R.drawable.layout_icones_atk_fisico);
                        mBinding.atkOrDefTextView.setText(mContext.getString(R.string.label_atk_tai_buk, jutsu.getAtk()));
                    } else {
                        drawable = (R.drawable.layout_icones_atk_magico);
                        mBinding.atkOrDefTextView.setText(mContext.getString(R.string.label_atk_nin_gen, jutsu.getAtk()));
                    }

                    mBinding.atkOrDefTextView.setCompoundDrawablesWithIntrinsicBounds(
                            drawable, 0, 0, 0);
                } else {
                    mBinding.atkOrDefTextView2.setVisibility(View.VISIBLE);
                    mBinding.atkOrDefTextView.setText(mContext.getString(R.string.label_atk_tai_buk, jutsu.getAtk()));
                    mBinding.atkOrDefTextView2.setText(mContext.getString(R.string.label_atk_nin_gen, jutsu.getAtk()));
                }
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
