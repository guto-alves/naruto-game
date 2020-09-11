package com.gutotech.narutogame.ui.playing.battles;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gutotech.narutogame.data.model.Battle;

public class DojoNpcBattleViewModelFactory implements ViewModelProvider.Factory {
    private Battle battle;

    DojoNpcBattleViewModelFactory(Battle battle) {
        this.battle = battle;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DojoNpcBattleViewModel.class)) {
            return (T) new DojoNpcBattleViewModel(battle);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
