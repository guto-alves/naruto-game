package com.gutotech.narutogame.ui.playing.currentvillage;

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
import com.gutotech.narutogame.data.model.Ramen;
import com.gutotech.narutogame.databinding.PopupRamenInfoBinding;

public class RamenInfoPopupWindow extends PopupWindow {
    private PopupRamenInfoBinding mBinding;

    public RamenInfoPopupWindow(Context context) {
        super(context);
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.popup_ramen_info,
                null, false);
        setContentView(mBinding.getRoot());

        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(true);
    }

    @Override
    public void showAsDropDown(View anchor) {
        PopupWindowCompat.showAsDropDown(this, anchor, 0, 0,
                Gravity.TOP | Gravity.START);
    }

    public void setRamen(Ramen ramen) {
        mBinding.setRamen(ramen);
    }
}
