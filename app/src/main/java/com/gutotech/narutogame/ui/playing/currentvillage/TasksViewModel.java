package com.gutotech.narutogame.ui.playing.currentvillage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.firebase.FirebaseFunctionsUtils;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.TimeMission;
import com.gutotech.narutogame.data.model.Mission;
import com.gutotech.narutogame.data.model.MissionInfo;
import com.gutotech.narutogame.data.repository.MissionRepository;
import com.gutotech.narutogame.ui.adapter.TasksAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class TasksViewModel extends ViewModel implements TasksAdapter.OnAcceptClickListener {
    private static final long ONE_MINUTE = 60000;

    private MutableLiveData<List<TimeMission>> mTasks = new MutableLiveData<>();

    public TasksViewModel() {
        loadInitialTasks();
    }

    private void loadInitialTasks() {
        List<TimeMission> tasks = new ArrayList<>();

        for (MissionInfo missionInfo : EnumSet.range(MissionInfo.TASK1, MissionInfo.TASK10)) {
            tasks.add(new TimeMission(missionInfo.name(), ONE_MINUTE));
        }

        if (CharOn.character.getMissionsFinishedId() != null) {
            Collections.sort(CharOn.character.getMissionsFinishedId());

            int idCountRemoved = 0;

            for (int missionId : CharOn.character.getMissionsFinishedId()) {
                tasks.remove(missionId - idCountRemoved);
                idCountRemoved++;
            }
        }

        mTasks.setValue(tasks);
    }

    @Override
    public void onAcceptClick(Mission task) {
        FirebaseFunctionsUtils.getServerTime(currentTimestamp -> {
            TimeMission timeMission = (TimeMission) task;
            timeMission.setInitialTimestamp(currentTimestamp);
            MissionRepository.getInstance().acceptTimeMission(timeMission);
            CharOn.character.setMission(true);
        });
    }


    LiveData<List<TimeMission>> getTasks() {
        return mTasks;
    }
}
