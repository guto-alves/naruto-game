package com.gutotech.narutogame.ui.playing.team;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gutotech.narutogame.data.model.Team;

public class TeamDetailsViewModelFactory implements ViewModelProvider.Factory {
    private Team mTeam;

    TeamDetailsViewModelFactory(Team team) {
        mTeam = team;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TeamDetailsViewModel.class)) {
            return (T) new TeamDetailsViewModel(mTeam);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
