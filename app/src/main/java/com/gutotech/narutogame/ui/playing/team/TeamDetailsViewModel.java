package com.gutotech.narutogame.ui.playing.team;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Team;
import com.gutotech.narutogame.data.repository.TeamRepository;
import com.gutotech.narutogame.ui.adapter.TeamMembersAdapter;
import com.gutotech.narutogame.ui.adapter.TeamRequestersAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.ArrayList;
import java.util.List;

public class TeamDetailsViewModel extends ViewModel implements
        TeamRequestersAdapter.RequestersClickListener, TeamMembersAdapter.RemoveMemberClickListener {
    private Team mTeam;

    private MutableLiveData<List<Character>> mMembers = new MutableLiveData<>();
    private MutableLiveData<List<Character>> mRequesters = new MutableLiveData<>();

    private SingleLiveEvent<Void> mShowQuestionDialogEvent = new SingleLiveEvent<>();

    private TeamRepository mTeamRepository;

    private List<String> acceptedRequestersId = new ArrayList<>();
    private List<String> refusedRequestersId = new ArrayList<>();

    TeamDetailsViewModel(Team team) {
        mTeam = team;
        mTeamRepository = TeamRepository.getInstance();
    }

    void loadMembers() {
        List<Character> members = new ArrayList<>();

        for (String memberId : mTeam.getMemberIds()) {
            mTeamRepository.getMember(memberId, member -> {
                members.add(member);
                mMembers.postValue(members);
            });
        }
    }

    void loadRequesters() {
        if (mTeam.getRequesterIds() == null) {
            return;
        }

        List<Character> requesters = new ArrayList<>();

        for (String requesterId : mTeam.getRequesterIds()) {
            mTeamRepository.getMember(requesterId, requester -> {
                requesters.add(requester);
                mRequesters.postValue(requesters);
            });
        }
    }

    public void onSubmitChanges() {
        for (String acceptedRequesterId : acceptedRequestersId) {
            if (mTeam.getMemberIds().size() < 4) {
                mTeam.getMemberIds().add(acceptedRequesterId);
            }
        }

        for (String refusedRequesterId : refusedRequestersId) {
            mTeam.getMemberIds().remove(refusedRequesterId);
        }

        loadRequesters();
        mTeamRepository.save(mTeam);
    }

    public void onLeaveTeamClick() {
        mShowQuestionDialogEvent.call();
    }

    public void onDeleteTeamClick() {
        mTeamRepository.remove(mTeam);
        CharOn.character.setTeam("");
    }

    public void onSendMessage() {

    }

    void leaveTeam(String memberId) {
        int memberIndex = mTeam.getMemberIds().indexOf(memberId);
        mTeam.getMemberIds().remove(memberIndex);
        mTeamRepository.save(mTeam);
        mTeamRepository.leaveTeam(memberId);
    }

    void deleteTeam() {
        mTeamRepository.remove(mTeam);
        CharOn.character.setTeam("");
    }

    public Team getTeam() {
        return mTeam;
    }

    LiveData<List<Character>> getMembers() {
        return mMembers;
    }

    LiveData<List<Character>> getRequesters() {
        return mRequesters;
    }

    LiveData<Void> getShowQuestionDialogEvent() {
        return mShowQuestionDialogEvent;
    }

    @Override
    public void onAcceptClick(int index, boolean checked) {
        String requesterId = mTeam.getRequesterIds().get(index);

        if (checked) {
            refusedRequestersId.remove(requesterId);

            acceptedRequestersId.add(requesterId);
        } else {
            acceptedRequestersId.remove(requesterId);
        }


    }

    @Override
    public void onRefuseClick(int index, boolean checked) {
        String requesterId = mTeam.getRequesterIds().get(index);

        if (checked) {
            acceptedRequestersId.remove(requesterId);

            refusedRequestersId.add(mTeam.getRequesterIds().get(index));
        } else {
            refusedRequestersId.remove(requesterId);
        }
    }

    @Override
    public void onRemoveMemberClick(String memberId) {
        leaveTeam(memberId);
    }
}
