package com.gutotech.narutogame.ui.loggedin.accountinfo;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gutotech.narutogame.data.model.Player;

public class UserDataViewModelFactory implements ViewModelProvider.Factory {
    private Player player;

    UserDataViewModelFactory(Player player) {
        this.player = player;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(UserDataViewModel.class)) {
            return (T) new UserDataViewModel(player);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
