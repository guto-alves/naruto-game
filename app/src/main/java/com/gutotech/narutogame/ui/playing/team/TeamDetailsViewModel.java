package com.gutotech.narutogame.ui.playing.team;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Team;
import com.gutotech.narutogame.data.repository.TeamRepository;

import java.util.List;

public class TeamDetailsViewModel extends ViewModel {
    private Team mTeam;

    private MutableLiveData<List<Character>> mMembers = new MutableLiveData<>();

    private TeamRepository mTeamRepository;

    TeamDetailsViewModel(Team team) {
        mTeam = team;
        mTeamRepository = TeamRepository.getInstance();
    }

    public void onLeaveOrDeleteTeamClick() {
        if (mTeam.getMemberIds().get(0).equals(CharOn.character.getId())) { // delete team
            if (mTeam.getMemberIds().size() > 1) {
                return;
            }
        } else { // leave the team
            int memberIndex = mTeam.getMemberIds().indexOf(CharOn.character.getId());
            mTeam.getMemberIds().remove(memberIndex);
            mTeamRepository.save(mTeam);
        }
    }

    public void onSendMessage() {

    }

    public Team getTeam() {
        return mTeam;
    }

    public LiveData<List<Character>> getMembers() {
        return mMembers;
    }
}
