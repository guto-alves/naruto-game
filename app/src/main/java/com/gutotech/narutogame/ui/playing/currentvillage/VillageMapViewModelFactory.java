package com.gutotech.narutogame.ui.playing.currentvillage;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class VillageMapViewModelFactory implements ViewModelProvider.Factory {
    private int villageId;

    public VillageMapViewModelFactory(int villageId) {
        this.villageId = villageId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(VillageMapViewModel.class)) {
            return (T) new VillageMapViewModel(villageId);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
