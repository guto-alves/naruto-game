package com.gutotech.narutogame.ui.playing.team;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Member;
import com.gutotech.narutogame.data.model.Team;
import com.gutotech.narutogame.data.repository.TeamRepository;
import com.gutotech.narutogame.ui.adapter.TeamMembersAdapter;
import com.gutotech.narutogame.ui.adapter.TeamRequestersAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.ArrayList;
import java.util.List;

public class TeamDetailsViewModel extends ViewModel implements
        TeamRequestersAdapter.RequestersClickListener, TeamMembersAdapter.RemoveMemberClickListener {
    private MutableLiveData<Team> mTeam = new MutableLiveData<>();

    private MutableLiveData<List<Member>> mMembers = new MutableLiveData<>();
    private MutableLiveData<List<Character>> mRequesters = new MutableLiveData<>();

    private SingleLiveEvent<Void> mShowQuestionDialogEvent = new SingleLiveEvent<>();

    private TeamRepository mTeamRepository = TeamRepository.getInstance();

    private List<String> mAcceptedRequestersId = new ArrayList<>();
    private List<String> mRefusedRequestersId = new ArrayList<>();

    public TeamDetailsViewModel() {
        mTeamRepository.getTeam(CharOn.character.getTeam(), team -> {
            mTeam.setValue(team);

            if (team.getLeaderId().equals(CharOn.character.getId())) {
                loadRequesters();
            }

            mTeamRepository.getMembers(team.getName(),
                    members -> mMembers.postValue(members));
        });
    }

    private void loadRequesters() {
        mTeamRepository.onRequestersChangeListener(mTeam.getValue().getName(),
                requesterIds -> {
                    List<Character> requesters = new ArrayList<>();
                    mRequesters.setValue(requesters);

                    for (String requesterId : requesterIds) {
                        mTeamRepository.getMemberChar(requesterId, requesterChar -> {
                            requesters.add(requesterChar);
                            mRequesters.postValue(requesters);
                        });
                    }
                });
    }


    void leaveTeam(String memberId) {
        mTeamRepository.notifyMember(memberId, "");
        mTeamRepository.removeMember(memberId, mTeam.getValue().getName());
    }

    private void deleteTeam() {
        mTeamRepository.remove(mTeam.getValue().getName());
        mTeamRepository.removeMember(CharOn.character.getId(), mTeam.getValue().getName());
        CharOn.character.setTeam("");
    }

    public void setTeamImage(String imagePath) {
        mTeam.getValue().setImage(imagePath);
        mTeamRepository.save(mTeam.getValue());
    }


    public void onSendMessage() {

    }

    public void onLeaveTeamClick() {
        mShowQuestionDialogEvent.call();
    }

    public void onDeleteTeamClick() {
        deleteTeam();
    }

    @Override
    public void onRemoveMemberClick(String memberId) {
        leaveTeam(memberId);
    }

    @Override
    public void onAcceptClick(String requesterId, boolean checked) {
        if (checked) {
            mRefusedRequestersId.remove(requesterId);
            mAcceptedRequestersId.add(requesterId);
        } else {
            mAcceptedRequestersId.remove(requesterId);
        }
    }

    @Override
    public void onRefuseClick(String requesterId, boolean checked) {
        if (checked) {
            mAcceptedRequestersId.remove(requesterId);
            mRefusedRequestersId.add(requesterId);
        } else {
            mRefusedRequestersId.remove(requesterId);
        }
    }

    public void onSubmitChanges() {
        int totalMembers = mMembers.getValue().size();

        for (String acceptedRequesterId : mAcceptedRequestersId) {
            if (totalMembers++ == 4) {
                break;
            }

            mTeamRepository.removeAllRequests(acceptedRequesterId);
            mTeamRepository.saveMember(new Member(acceptedRequesterId), mTeam.getValue().getName());
            mTeamRepository.notifyMember(acceptedRequesterId, mTeam.getValue().getName());
        }

        for (String refusedRequesterId : mRefusedRequestersId) {
            mTeamRepository.removeRequester(refusedRequesterId, mTeam.getValue().getName());
        }

        mAcceptedRequestersId.clear();
        mRefusedRequestersId.clear();
    }


    public LiveData<Team> getTeam() {
        return mTeam;
    }

    LiveData<List<Member>> getMembers() {
        return mMembers;
    }

    LiveData<List<Character>> getRequesters() {
        return mRequesters;
    }

    LiveData<Void> getShowQuestionDialogEvent() {
        return mShowQuestionDialogEvent;
    }
}
