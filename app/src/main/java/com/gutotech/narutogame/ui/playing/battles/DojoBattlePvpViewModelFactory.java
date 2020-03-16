package com.gutotech.narutogame.ui.playing.battles;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gutotech.narutogame.data.model.Battle;

public class DojoBattlePvpViewModelFactory implements ViewModelProvider.Factory {
    private Application application;

    DojoBattlePvpViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DojoBattlePvpViewModel.class)) {
            return (T) new DojoBattlePvpViewModel(application);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
