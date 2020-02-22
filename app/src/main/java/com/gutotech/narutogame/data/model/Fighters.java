package com.gutotech.narutogame.data.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class Fighters extends BaseObservable {
    private Character player;
    private Character opponent;

    public Fighters() {
    }

    public Fighters(Character player, Character opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    @Bindable
    public Character getPlayer() {
        return player;
    }

    public void setPlayer(Character player) {
        this.player = player;
        notifyPropertyChanged(BR.player);
    }

    @Bindable
    public Character getOpponent() {
        return opponent;
    }

    public void setOpponent(Character opponent) {
        this.opponent = opponent;
        notifyPropertyChanged(BR.opponent);
    }
}
