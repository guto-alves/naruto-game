package com.gutotech.narutogame.ui.playing.currentvillage;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gutotech.narutogame.data.model.TimeMission;

public class MissionsWaitingViewModelFactory implements ViewModelProvider.Factory {
    private TimeMission mission;

    MissionsWaitingViewModelFactory(TimeMission mission) {
        this.mission = mission;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MissionsWaitingViewModel.class)) {
            return (T) new MissionsWaitingViewModel(mission);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
