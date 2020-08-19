package com.gutotech.narutogame.ui.playing.currentvillage;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gutotech.narutogame.data.firebase.FirebaseFunctionsUtils;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Mission;
import com.gutotech.narutogame.data.model.MissionInfo;
import com.gutotech.narutogame.data.model.SpecialMission;
import com.gutotech.narutogame.data.model.TimeMission;
import com.gutotech.narutogame.data.repository.MissionRepository;
import com.gutotech.narutogame.ui.adapter.MissionsAdapter;
import com.gutotech.narutogame.utils.NotificationsUtils;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class MissionsViewModel extends AndroidViewModel
        implements MissionsAdapter.OnAcceptClickListener {
    private static final long TIME_BASE = 1800000; // 30 minutes
    public final ObservableField<Mission.Type> typeSelected = new ObservableField<>();
    public final ObservableField<Mission.Rank> rankSelected = new ObservableField<>();
    private MutableLiveData<List<Mission>> mMissions = new MutableLiveData<>();

    private SingleLiveEvent<Void> mShowWarningDialogEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Boolean> mShowProgressBarEvent = new SingleLiveEvent<>();

    public MissionsViewModel(@NonNull Application application) {
        super(application);
        typeSelected.set(Mission.Type.TIME);
        rankSelected.set(Mission.Rank.RANK_D);
        filterMissions();
    }

    public void onTypeSelected(Mission.Type type) {
        if (type == typeSelected.get()) {
            return;
        }
        typeSelected.set(type);
        filterMissions();
    }

    public void onRankSelected(Mission.Rank rank) {
        if (rank == rankSelected.get()) {
            return;
        }
        rankSelected.set(rank);
        filterMissions();
    }

    @Override
    public synchronized void onAcceptClick(Mission mission) {
        mShowProgressBarEvent.setValue(true);

        if (mission instanceof SpecialMission) {
            MissionRepository.getInstance().acceptMission(mission, Mission.Type.SPECIAL);
            CharOn.character.setSpecialMission(true);
            mShowProgressBarEvent.setValue(false);
        } else if (mission instanceof TimeMission && CharOn.character.getTotalDailyMissions() <= 3) {
            FirebaseFunctionsUtils.getServerTime(currentTimestamp -> {
                TimeMission timeMission = (TimeMission) mission;
                timeMission.setInitialTimestamp(currentTimestamp);
                MissionRepository.getInstance().acceptMission(timeMission, Mission.Type.TIME);
                NotificationsUtils.setAlarm(getApplication(),
                        currentTimestamp + timeMission.getDurationMillis());
                CharOn.character.setTimeMission(true);
                mShowProgressBarEvent.setValue(false);
            });
        } else {
            mShowProgressBarEvent.setValue(false);
            mShowWarningDialogEvent.call();
        }
    }

    private void filterMissions() {
        List<Mission> missions = new ArrayList<>();

        if (typeSelected.get() == Mission.Type.TIME) {
            if (rankSelected.get() == Mission.Rank.RANK_D) {
                for (MissionInfo missionInfo : EnumSet.range(MissionInfo.MISSION1, MissionInfo.MISSION91)) {
                    missions.add(new TimeMission(missionInfo.name(), TIME_BASE));
                }
            } else if (rankSelected.get() == Mission.Rank.RANK_C) {
                for (MissionInfo missionInfo : EnumSet.range(MissionInfo.MISSION92, MissionInfo.MISSION167)) {
                    missions.add(new TimeMission(missionInfo.name(), TIME_BASE));
                }
            } else if (rankSelected.get() == Mission.Rank.RANK_B) {
                for (MissionInfo missionInfo : EnumSet.range(MissionInfo.MISSION168, MissionInfo.MISSION238)) {
                    missions.add(new TimeMission(missionInfo.name(), TIME_BASE));
                }
            } else if (rankSelected.get() == Mission.Rank.RANK_A) {
                for (MissionInfo missionInfo : EnumSet.range(MissionInfo.MISSION239, MissionInfo.MISSION297)) {
                    missions.add(new TimeMission(missionInfo.name(), TIME_BASE));
                }
            } else { // Rank S
                for (MissionInfo missionInfo : EnumSet.range(MissionInfo.MISSION298, MissionInfo.MISSION371)) {
                    missions.add(new TimeMission(missionInfo.name(), TIME_BASE));
                }
            }
        } else { // Type == SPECIAL
            if (rankSelected.get() == Mission.Rank.RANK_D) {
                missions.add(new SpecialMission(MissionInfo.MISSION372.name(), 5));
                missions.add(new SpecialMission(MissionInfo.MISSION373.name(), 10));
                missions.add(new SpecialMission(MissionInfo.MISSION374.name(), 10));
                missions.add(new SpecialMission(MissionInfo.MISSION375.name(), 10));
                missions.add(new SpecialMission(MissionInfo.MISSION376.name(), 10));
                missions.add(new SpecialMission(MissionInfo.MISSION377.name(), 10));
                missions.add(new SpecialMission(MissionInfo.MISSION378.name(), 20));
                missions.add(new SpecialMission(MissionInfo.MISSION379.name(), 20));
                missions.add(new SpecialMission(MissionInfo.MISSION380.name(), 20));
                missions.add(new SpecialMission(MissionInfo.MISSION381.name(), 20));
            } else if (rankSelected.get() == Mission.Rank.RANK_C) {
                missions.add(new SpecialMission(MissionInfo.MISSION382.name(), 15));
                missions.add(new SpecialMission(MissionInfo.MISSION383.name(), 20));
                missions.add(new SpecialMission(MissionInfo.MISSION384.name(), 30));
                missions.add(new SpecialMission(MissionInfo.MISSION385.name(), 30));
                missions.add(new SpecialMission(MissionInfo.MISSION386.name(), 30));
                missions.add(new SpecialMission(MissionInfo.MISSION387.name(), 30));
                missions.add(new SpecialMission(MissionInfo.MISSION388.name(), 40));
                missions.add(new SpecialMission(MissionInfo.MISSION389.name(), 40));
                missions.add(new SpecialMission(MissionInfo.MISSION390.name(), 40));
                missions.add(new SpecialMission(MissionInfo.MISSION391.name(), 40));
            } else if (rankSelected.get() == Mission.Rank.RANK_B) {
                missions.add(new SpecialMission(MissionInfo.MISSION392.name(), 25));
            }
        }

        if (missions.size() > 0) {
            Collections.sort(CharOn.character.getMissionsFinishedId());
            removeRepeatedMissions(CharOn.character.getMissionsFinishedId(), missions);
        }

        mMissions.postValue(missions);
    }

    private void removeRepeatedMissions(Collection<Integer> missionIds, Collection<Mission> missions) {
        for (int missionId : missionIds) {
            Iterator<Mission> missionIterator = missions.iterator();

            while (missionIterator.hasNext()) {
                Mission mission = missionIterator.next();
                MissionInfo missionInfo = mission.missionInfo();

                if (missionId == missionInfo.ordinal()) {
                    missionIterator.remove();
                    break;
                }
            }
        }
    }


    LiveData<List<Mission>> getMissions() {
        return mMissions;
    }

    LiveData<Void> getShowWarningDialogEvent() {
        return mShowWarningDialogEvent;
    }

    LiveData<Boolean> getShowProgressBarEvent() {
        return mShowProgressBarEvent;
    }
}
