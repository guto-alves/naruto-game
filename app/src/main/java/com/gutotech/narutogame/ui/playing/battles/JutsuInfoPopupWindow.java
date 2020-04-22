package com.gutotech.narutogame.ui.playing.battles;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import androidx.databinding.DataBindingUtil;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.BattleLog;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.model.JutsuInfo;
import com.gutotech.narutogame.databinding.PopupJutsuInfoBinding;
import com.gutotech.narutogame.utils.SoundUtil;
import com.gutotech.narutogame.utils.SpannableStringBuilderCustom;

public class JutsuInfoPopupWindow extends PopupWindow {
    private Context mContext;

    private PopupJutsuInfoBinding mBinding;

    JutsuInfoPopupWindow(Context context) {
        super(context);
        mContext = context;

        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.popup_jutsu_info, null, false);

        setContentView(mBinding.getRoot());

        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(true);
    }

    void setJutsu(Jutsu jutsu, int chanceOfSuccess) {
        JutsuInfo jutsuInfo = jutsu.getJutsuInfo();

        mBinding.setJutsu(jutsu);
        mBinding.setJutsuInfo(jutsuInfo);

        if (jutsuInfo.type == Jutsu.Type.DEF) {
            mBinding.atkOrDefTextView.setText(mContext.getString(
                    R.string.label_base_defense, jutsu.getBaseDefense()));

            mBinding.atkOrDefTextView.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.layout_icones_shield_fisico, 0, 0, 0);

            SpannableStringBuilderCustom builder = new SpannableStringBuilderCustom(mContext);
            builder.append("100%", R.color.colorGreen);
            mBinding.accChanceTextView.setText(builder.getString());
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

            SpannableStringBuilderCustom spannableBuilder = new SpannableStringBuilderCustom(mContext);

            spannableBuilder.append(chanceOfSuccess + "%", R.color.colorGreen);

            if (chanceOfSuccess < 100) {
                spannableBuilder.append(" (");
                spannableBuilder.append((100 - chanceOfSuccess) + "% ", android.R.color.holo_red_light);
                spannableBuilder.append(R.string.chance_of_error);
            }

            mBinding.accChanceTextView.setText(spannableBuilder.getString());
        } else {
            mBinding.accTextView.setVisibility(View.VISIBLE);
            mBinding.accLinearLayout.setVisibility(View.GONE);

            mBinding.effectsTextView.setVisibility(View.VISIBLE);

            if (jutsuInfo.type == Jutsu.Type.BUFF) {
                mBinding.effectsTextView.setText(R.string.effects_on_your_character);
            } else {
                mBinding.effectsTextView.setText(R.string.effects_on_your_enemy);
            }

            if (jutsu.getBaseDefense() != 0) {
                mBinding.atkOrDefTextView.setText(mContext.getString(
                        R.string.label_base_defense, jutsu.getBaseDefense()));

                mBinding.atkOrDefTextView.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.layout_icones_defense, 0, 0, 0);
            } else {
                mBinding.atkOrDefTextView2.setVisibility(View.VISIBLE);

                mBinding.atkOrDefTextView.setText(mContext.getString(R.string.label_atk_tai_buk,
                        jutsu.getAtk()));

                mBinding.atkOrDefTextView2.setText(mContext.getString(R.string.label_atk_nin_gen,
                        jutsu.getAtk()));
            }
        }
    }

    void setBattleLog(BattleLog battleLog) {
        setJutsu(battleLog.getJutsu(), battleLog.getChanceOfSuccess());
    }

    @Override
    public void showAsDropDown(View anchor) {
        super.showAsDropDown(anchor);
        SoundUtil.play(mContext, R.raw.sound_pop);
    }
}
