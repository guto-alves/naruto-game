package com.gutotech.narutogame.ui.playing.currentvillage;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gutotech.narutogame.data.model.Village;

public class VillageMapViewModelFactory implements ViewModelProvider.Factory {
    private Village village;

    VillageMapViewModelFactory(Village village) {
        this.village = village;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(VillageMapViewModel.class)) {
            return (T) new VillageMapViewModel(village);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
