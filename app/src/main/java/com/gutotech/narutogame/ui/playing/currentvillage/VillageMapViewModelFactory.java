package com.gutotech.narutogame.ui.playing.currentvillage;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class VillageMapViewModelFactory implements ViewModelProvider.Factory {
    private String villageName;

    public VillageMapViewModelFactory(String villageName) {
        this.villageName = villageName;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(VillageMapViewModel.class)) {
            return (T) new VillageMapViewModel(villageName);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
