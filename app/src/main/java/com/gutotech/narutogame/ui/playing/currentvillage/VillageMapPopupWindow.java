package com.gutotech.narutogame.ui.playing.currentvillage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.ui.adapter.CharsInPositionAdapter;

import java.util.List;

public class VillageMapPopupWindow extends PopupWindow {
    private CharsInPositionAdapter charsInPositionAdapter;

    public VillageMapPopupWindow(Context context) {
        super(context);

        View root = LayoutInflater.from(context).inflate(R.layout.popup_village_map, null);
        setContentView(root);

        RecyclerView recyclerView = root.findViewById(R.id.placeRecyclerView);
        recyclerView.setHasFixedSize(true);

        charsInPositionAdapter = new CharsInPositionAdapter(context);
        recyclerView.setAdapter(charsInPositionAdapter);

        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(true);
    }

    public void setCharactersList(List<Character> characters) {
        charsInPositionAdapter.setCharacters(characters);
    }

    public void setBattleClickListener(CharsInPositionAdapter.OnBattleClickListener listener) {
        charsInPositionAdapter.setBattleClickListener(listener);
    }
}
