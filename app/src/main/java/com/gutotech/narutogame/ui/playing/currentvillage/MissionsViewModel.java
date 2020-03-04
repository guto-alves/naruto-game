package com.gutotech.narutogame.ui.playing.currentvillage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Mission;
import com.gutotech.narutogame.data.model.MissionInfo;
import com.gutotech.narutogame.data.model.TimeMission;
import com.gutotech.narutogame.data.repository.MissionRepository;
import com.gutotech.narutogame.ui.adapter.MissionsAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class MissionsViewModel extends ViewModel implements MissionsAdapter.OnAcceptClickListener {
    private static final long TIME_BASE = 1800000; // 30 minutes

    private Mission.Type mTypeSelected;
    private Mission.Rank mRankSelected;

    private MutableLiveData<List<Mission>> mMissions = new MutableLiveData<>();

    public MissionsViewModel() {
        mTypeSelected = Mission.Type.TIME;
        mRankSelected = Mission.Rank.RANK_D;

        filterMissions(mTypeSelected, mRankSelected);
    }

    LiveData<List<Mission>> getMissions() {
        return mMissions;
    }

    public Mission.Type getTypeSelected() {
        return mTypeSelected;
    }

    public Mission.Rank getRankSelected() {
        return mRankSelected;
    }

    public void onTypeSelected(Mission.Type typeSelected) {
        mTypeSelected = typeSelected;
        filterMissions(mTypeSelected, mRankSelected);
    }

    public void onRankSelected(Mission.Rank rankSelected) {
        mRankSelected = rankSelected;
        filterMissions(mTypeSelected, mRankSelected);
    }

    private void filterMissions(Mission.Type typeSelected, Mission.Rank rankSelected) {
        List<Mission> missions = new ArrayList<>();

        if (typeSelected == Mission.Type.TIME) {
            if (rankSelected == Mission.Rank.RANK_D) {
                for (MissionInfo missionInfo : EnumSet.range(MissionInfo.MISSION1, MissionInfo.MISSION91)) {
                    missions.add(new TimeMission(missionInfo.name(), TIME_BASE));
                }
            } else if (rankSelected == Mission.Rank.RANK_C) {
                for (MissionInfo missionInfo : EnumSet.range(MissionInfo.MISSION92, MissionInfo.MISSION167)) {
                    missions.add(new TimeMission(missionInfo.name(), TIME_BASE));
                }
            } else if (rankSelected == Mission.Rank.RANK_B) {
                for (MissionInfo missionInfo : EnumSet.range(MissionInfo.MISSION168, MissionInfo.MISSION238)) {
                    missions.add(new TimeMission(missionInfo.name(), TIME_BASE));
                }
            } else if (rankSelected == Mission.Rank.RANK_A) {
                for (MissionInfo missionInfo : EnumSet.range(MissionInfo.MISSION239, MissionInfo.MISSION297)) {
                    missions.add(new TimeMission(missionInfo.name(), TIME_BASE));
                }
            } else { // Rank S
                for (MissionInfo missionInfo : EnumSet.range(MissionInfo.MISSION298, MissionInfo.MISSION371)) {
                    missions.add(new TimeMission(missionInfo.name(), TIME_BASE));
                }
            }
        } else { // Type == Special
            if (rankSelected == Mission.Rank.RANK_D) {

            } else if (rankSelected == Mission.Rank.RANK_C) {

            } else if (rankSelected == Mission.Rank.RANK_B) {

            } else if (rankSelected == Mission.Rank.RANK_A) {

            } else { // Rank S

            }
        }

        if (CharOn.character.getResumeOfMissions().getMissionsFinishedId() != null) {
            Collections.sort(CharOn.character.getResumeOfMissions().getMissionsFinishedId());

            int idCountRemoved = 0;

            for (int missionId : CharOn.character.getResumeOfMissions().getMissionsFinishedId()) {
                if (missionId > 9) {
                    missions.remove((missionId - 10) - idCountRemoved);
                    idCountRemoved++;
                }
            }
        }

        mMissions.setValue(missions);
    }

    @Override
    public void onAcceptClick(Mission task) {
        TimeMission timeMission = (TimeMission) task;
        MissionRepository.getInstance().acceptTimeMission(timeMission);
        CharOn.character.setMission(true);
    }
}
