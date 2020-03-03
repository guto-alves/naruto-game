package com.gutotech.narutogame.ui.playing.team;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Team;
import com.gutotech.narutogame.data.repository.TeamRepository;
import com.gutotech.narutogame.ui.adapter.TeamsParticipateAdapter;

import java.util.List;

public class TeamParticipateViewModel extends ViewModel implements
        TeamsParticipateAdapter.OnParticipateClickListener {
    public final ObservableField<String> teamName = new ObservableField<>();

    private final int VILLAGE_ID = CharOn.character.getVillage().id;

    private MutableLiveData<List<Team>> mTeams = new MutableLiveData<>();

    public TeamParticipateViewModel() {
        teamName.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                filterTeams();
            }
        });
    }

    LiveData<List<Team>> getTeams() {
        return mTeams;
    }

    private void filterTeams() {
        TeamRepository.getInstance().filterTeams(teamName.get(), VILLAGE_ID, mTeams::postValue);
    }

    @Override
    public void onParticipateClick(Team team) {

    }
}
