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

        mBinding.atkNinGenTextView.setVisibility(View.VISIBLE);
        mBinding.atkTaiBukTextView.setVisibility(View.VISIBLE);
        mBinding.defTextView.setVisibility(View.VISIBLE);
        mBinding.accTextView.setVisibility(View.GONE);
        mBinding.effectsTextView.setVisibility(View.GONE);

        if (jutsu.getBaseDefense() == 0) {
            mBinding.defTextView.setVisibility(View.GONE);
        }

        if (jutsu.getAtk() == 0) {
            mBinding.atkNinGenTextView.setVisibility(View.GONE);
            mBinding.atkTaiBukTextView.setVisibility(View.GONE);
        }

        if (jutsuInfo.type == Jutsu.Type.DEF) {
            SpannableStringBuilderCustom builder = new SpannableStringBuilderCustom(mContext);
            builder.append("100%", R.color.colorGreen);
            mBinding.accChanceTextView.setText(builder.getString());
        } else if (jutsuInfo.type == Jutsu.Type.ATK) {
            if (jutsu.getClasse() == Classe.NIN || jutsu.getClasse() == Classe.GEN) {
                mBinding.atkTaiBukTextView.setVisibility(View.GONE);
            } else {
                mBinding.atkNinGenTextView.setVisibility(View.GONE);
            }

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

                if (jutsu.getClasse() == Classe.NIN || jutsu.getClasse() == Classe.GEN) {
                    mBinding.atkTaiBukTextView.setVisibility(View.GONE);
                } else {
                    mBinding.atkNinGenTextView.setVisibility(View.GONE);
                }
            } else {
                mBinding.effectsTextView.setText(R.string.effects_on_your_enemy);
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
