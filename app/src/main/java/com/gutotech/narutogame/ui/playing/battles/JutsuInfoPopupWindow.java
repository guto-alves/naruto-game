package com.gutotech.narutogame.ui.playing.battles;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.PopupWindow;

import androidx.databinding.DataBindingUtil;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.model.JutsuInfo;
import com.gutotech.narutogame.databinding.PopupJutsuInfoBinding;

public class JutsuInfoPopupWindow extends PopupWindow {
    private Context mContext;

    private PopupJutsuInfoBinding mBinding;

    public JutsuInfoPopupWindow(Context context) {
        super(context);
        mContext = context;

        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.popup_jutsu_info, null, false);

        setContentView(mBinding.getRoot());

        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(true);
    }

    public void setJutsu(Jutsu jutsu) {
        JutsuInfo jutsuInfo = jutsu.getJutsuInfo();

        mBinding.setJutsu(jutsu);
        mBinding.setJutsuInfo(jutsuInfo);

        if (jutsuInfo.type == Jutsu.Type.DEF) {
            mBinding.atkOrDefTextView.setText(mContext.getString(R.string.label_base_defense, jutsu.getBaseDefense()));

            Drawable drawable = mContext.getResources().getDrawable(R.drawable.layout_icones_shield_fisico);

            mBinding.atkOrDefTextView.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        } else if (jutsuInfo.type == Jutsu.Type.ATK) {
            Drawable drawable;
            if (jutsu.getClasse() == Classe.TAI || jutsu.getClasse() == Classe.BUK) {
                drawable = mContext.getResources().getDrawable(R.drawable.layout_icones_atk_fisico);
                mBinding.atkOrDefTextView.setText(mContext.getString(R.string.label_atk_tai_buk, jutsu.getAtk()));
            } else {
                drawable = mContext.getResources().getDrawable(R.drawable.layout_icones_atk_magico);
                mBinding.atkOrDefTextView.setText(mContext.getString(R.string.label_atk_nin_gen, jutsu.getAtk()));
            }

            mBinding.atkOrDefTextView.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        }
    }
}
