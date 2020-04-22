package com.gutotech.narutogame.ui.playing.character;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.core.widget.PopupWindowCompat;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Element;
import com.gutotech.narutogame.utils.SoundUtil;

public class ElementInfoPopupWindow extends PopupWindow {
    private TextView nameTextView, descriptionTextView, beChuuninTextView, cantTaiOrBukTextView;

    public ElementInfoPopupWindow(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_element_info,
                null, false);
        setContentView(view);

        nameTextView = view.findViewById(R.id.nameTextView);
        descriptionTextView = view.findViewById(R.id.descriptionTextView);
        beChuuninTextView = view.findViewById(R.id.beChuunin);
        cantTaiOrBukTextView = view.findViewById(R.id.cantTaiBukTextView);

        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(true);
    }

    public void setElement(Element element) {
        nameTextView.setText(element.name);
        descriptionTextView.setText(element.description);

        if (CharOn.character.getGraduationId() > 1) {
            beChuuninTextView.setPaintFlags(beChuuninTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            beChuuninTextView.setTextColor(Color.WHITE);
        } else {
            beChuuninTextView.setTextColor(Color.RED);
        }

        if (CharOn.character.getClasse() == Classe.NIN ||
                CharOn.character.getClasse() == Classe.GEN) {
            cantTaiOrBukTextView.setPaintFlags(cantTaiOrBukTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            cantTaiOrBukTextView.setTextColor(Color.WHITE);
        } else {
            cantTaiOrBukTextView.setTextColor(Color.RED);
        }
    }

    @Override
    public void showAsDropDown(View anchor) {
        PopupWindowCompat.showAsDropDown(this,
                anchor, 0, 0, Gravity.TOP | Gravity.START);
        SoundUtil.play(anchor.getContext(), R.raw.sound_pop);
    }
}
