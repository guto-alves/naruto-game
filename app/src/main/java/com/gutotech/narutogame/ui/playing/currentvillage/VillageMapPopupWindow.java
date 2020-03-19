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
    private CharsInPositionAdapter mCharsInPositionAdapter;
    private int mPosition;

    public VillageMapPopupWindow(Context context) {
        super(context);

        View root = LayoutInflater.from(context).inflate(R.layout.popup_village_map,
                null, false);
        setContentView(root);

        RecyclerView recyclerView = root.findViewById(R.id.placeRecyclerView);
        recyclerView.setHasFixedSize(true);

        mCharsInPositionAdapter = new CharsInPositionAdapter(context);
        recyclerView.setAdapter(mCharsInPositionAdapter);

        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(true);
    }

    public void setCharactersList(List<Character> characters, int position) {
        mCharsInPositionAdapter.setCharacters(characters);
        mPosition = position;
    }

    public void setBattleClickListener(CharsInPositionAdapter.OnBattleClickListener listener) {
        mCharsInPositionAdapter.setBattleClickListener(listener);
    }

    public int getPosition() {
        return mPosition;
    }
}
