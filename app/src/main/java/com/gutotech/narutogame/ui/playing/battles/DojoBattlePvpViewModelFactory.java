package com.gutotech.narutogame.ui.playing.battles;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gutotech.narutogame.data.model.Battle;

public class DojoBattlePvpViewModelFactory implements ViewModelProvider.Factory {
    private Application application;
    private Battle battle;

    DojoBattlePvpViewModelFactory(Application application, Battle battle) {
        this.application = application;
        this.battle = battle;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DojoBattlePvpViewModel.class)) {
            return (T) new DojoBattlePvpViewModel(application, battle);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
