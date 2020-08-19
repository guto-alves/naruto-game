package com.gutotech.narutogame.ui.playing.battles;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gutotech.narutogame.data.model.Battle;

public class DojoBatalhaLutadorViewModelFactory implements ViewModelProvider.Factory {
    private Battle battle;

    DojoBatalhaLutadorViewModelFactory(Battle battle) {
        this.battle = battle;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DojoBatalhaLutadorViewModel.class)) {
            return (T) new DojoBatalhaLutadorViewModel(battle);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
