package com.gutotech.narutogame.ui.playing.team;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Team;
import com.gutotech.narutogame.data.repository.TeamRepository;
import com.gutotech.narutogame.ui.adapter.TeamsParticipateAdapter;

import java.util.List;

public class TeamParticipateViewModel extends ViewModel implements
        TeamsParticipateAdapter.OnParticipateClickListener {
    public final ObservableField<String> teamName = new ObservableField<>("");

    private final int VILLAGE_ID = CharOn.character.getVillage().ordinal();

    private MutableLiveData<List<Team>> mTeams = new MutableLiveData<>();

    private MutableLiveData<Integer> mShowWarningDialogEvent = new MutableLiveData<>();

    private TeamRepository mTeamRepository = TeamRepository.getInstance();

    public TeamParticipateViewModel() {
        teamName.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                filterTeams();
            }
        });

        filterTeams();
    }

    LiveData<List<Team>> getTeams() {
        return mTeams;
    }

    public LiveData<Integer> getShowWarningDialogEvent() {
        return mShowWarningDialogEvent;
    }

    private void filterTeams() {
        mTeamRepository.filterTeams(teamName.get(), VILLAGE_ID, mTeams::postValue);
    }

    @Override
    public void onParticipateClick(Team team) {
        mTeamRepository.requested(CharOn.character.getId(), team.getName(), requested -> {
            if (requested) {
                mShowWarningDialogEvent.setValue(R.string.already_sent_an_request_to_this_team);
            } else {
                mTeamRepository.saveRequester(CharOn.character.getId(), team.getName());
                mShowWarningDialogEvent.setValue(R.string.team_request_sent);
            }
        });
    }
}
