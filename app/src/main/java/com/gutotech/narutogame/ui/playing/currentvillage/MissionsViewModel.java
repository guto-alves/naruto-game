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

public class MissionsViewModel extends AndroidViewModel implements MissionsAdapter.OnAcceptClickListener {
    public final ObservableField<Mission.Type> typeSelected = new ObservableField<>(Mission.Type.TIME);
    public final ObservableField<Mission.Rank> rankSelected = new ObservableField<>(Mission.Rank.RANK_D);

    private static final long TIME_BASE = 1800000; // 30 minutes

    private MutableLiveData<List<Mission>> mMissions = new MutableLiveData<>();

    private SingleLiveEvent<Void> mShowWarningDialogEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Boolean> mShowProgressBarEvent = new SingleLiveEvent<>();

    public MissionsViewModel(@NonNull Application application) {
        super(application);
        filterMissions();
    }

    public void onTypeSelected(Mission.Type type) {
        typeSelected.set(type);
        filterMissions();
    }

    public void onRankSelected(Mission.Rank rank) {
        rankSelected.set(rank);
        filterMissions();
    }

    @Override
    public synchronized void onAcceptClick(Mission mission) {
        mShowProgressBarEvent.setValue(true);

        if (CharOn.character.getTotalDailyMissions() <= 3) {
            FirebaseFunctionsUtils.getServerTime(currentTimestamp -> {
                TimeMission timeMission = (TimeMission) mission;
                timeMission.setInitialTimestamp(currentTimestamp);
                MissionRepository.getInstance().acceptTimeMission(timeMission);
                NotificationsUtils.setAlarm(getApplication(),
                        currentTimestamp + timeMission.getDurationMillis());
                CharOn.character.setMission(true);
                mShowProgressBarEvent.setValue(false);
            });
        } else {
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
        } else { // Type == Special
            if (rankSelected.get() == Mission.Rank.RANK_D) {

            } else if (rankSelected.get() == Mission.Rank.RANK_C) {

            } else if (rankSelected.get() == Mission.Rank.RANK_B) {

            } else if (rankSelected.get() == Mission.Rank.RANK_A) {

            } else { // Rank S

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
