package com.gutotech.narutogame.ui.playing.currentvillage;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gutotech.narutogame.data.firebase.FirebaseFunctionsUtils;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Mission;
import com.gutotech.narutogame.data.model.MissionInfo;
import com.gutotech.narutogame.data.model.TimeMission;
import com.gutotech.narutogame.data.repository.MissionRepository;
import com.gutotech.narutogame.ui.adapter.TasksAdapter;
import com.gutotech.narutogame.utils.NotificationsUtils;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class TasksViewModel extends AndroidViewModel implements TasksAdapter.OnAcceptClickListener {
    private static final long DURATION = 30000;

    private MutableLiveData<List<TimeMission>> mTasks = new MutableLiveData<>();
    private SingleLiveEvent<Boolean> mShowProgressBarEvent = new SingleLiveEvent<>();

    public TasksViewModel(@NonNull Application application) {
        super(application);
        loadInitialTasks();
    }

    private void loadInitialTasks() {
        List<TimeMission> tasks = new ArrayList<>();

        for (MissionInfo missionInfo : EnumSet.range(MissionInfo.TASK1, MissionInfo.TASK10)) {
            tasks.add(new TimeMission(missionInfo.name(), DURATION));
        }

        if (CharOn.character.getMissionsFinishedId() != null) {
            Collections.sort(CharOn.character.getMissionsFinishedId());

            int idCountRemoved = 0;

            for (int missionId : CharOn.character.getMissionsFinishedId()) {
                tasks.remove(missionId - idCountRemoved);
                idCountRemoved++;
            }
        }

        mTasks.postValue(tasks);
    }

    @Override
    public void onAcceptClick(Mission task) {
        mShowProgressBarEvent.setValue(true);

        FirebaseFunctionsUtils.getServerTime(currentTimestamp -> {
            TimeMission timeMission = (TimeMission) task;
            timeMission.setInitialTimestamp(currentTimestamp);
            MissionRepository.getInstance().acceptMission(timeMission, Mission.Type.TIME);
            NotificationsUtils.setAlarm(getApplication(),
                    currentTimestamp + timeMission.getDurationMillis());
            CharOn.character.setTimeMission(true);
            mShowProgressBarEvent.setValue(false);
        });
    }

    LiveData<List<TimeMission>> getTasks() {
        return mTasks;
    }

    LiveData<Boolean> getShowProgressBarEvent() {
        return mShowProgressBarEvent;
    }
}
