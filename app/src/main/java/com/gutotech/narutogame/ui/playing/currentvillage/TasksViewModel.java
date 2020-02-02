package com.gutotech.narutogame.ui.playing.currentvillage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.TimeMission;
import com.gutotech.narutogame.data.model.Mission;
import com.gutotech.narutogame.data.model.MissionInfo;
import com.gutotech.narutogame.data.repository.MissionRepository;
import com.gutotech.narutogame.ui.adapter.TasksRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TasksViewModel extends ViewModel implements TasksRecyclerViewAdapter.OnAcceptClickListener {
    private static final long ONE_MINUTE = 60000;

    private MutableLiveData<List<TimeMission>> mTasks = new MutableLiveData<>();

    public TasksViewModel() {
        loadInitialTasks();
    }

    LiveData<List<TimeMission>> getTasks() {
        return mTasks;
    }

    private void loadInitialTasks() {
        List<TimeMission> tasks = new ArrayList<>();

        tasks.add(new TimeMission(MissionInfo.TASK1.name(), ONE_MINUTE));
        tasks.add(new TimeMission(MissionInfo.TASK2.name(), ONE_MINUTE));
        tasks.add(new TimeMission(MissionInfo.TASK3.name(), ONE_MINUTE));
        tasks.add(new TimeMission(MissionInfo.TASK4.name(), ONE_MINUTE));
        tasks.add(new TimeMission(MissionInfo.TASK5.name(), ONE_MINUTE));
        tasks.add(new TimeMission(MissionInfo.TASK6.name(), ONE_MINUTE));
        tasks.add(new TimeMission(MissionInfo.TASK7.name(), ONE_MINUTE));
        tasks.add(new TimeMission(MissionInfo.TASK8.name(), ONE_MINUTE));
        tasks.add(new TimeMission(MissionInfo.TASK9.name(), ONE_MINUTE));
        tasks.add(new TimeMission(MissionInfo.TASK10.name(), ONE_MINUTE));

        if (CharOn.character.getResumeOfMissions().getMissionsFinishedId() != null) {
            Collections.sort(CharOn.character.getResumeOfMissions().getMissionsFinishedId());

            int idCountRemoved = 0;

            for (int missionId : CharOn.character.getResumeOfMissions().getMissionsFinishedId()) {
                tasks.remove(missionId - idCountRemoved);
                idCountRemoved++;
            }
        }

        mTasks.setValue(tasks);
    }

    @Override
    public void onAcceptClick(Mission task) {
        TimeMission timeMission = (TimeMission) task;
        MissionRepository.getInstance().acceptTimeMission(timeMission);
        CharOn.character.setMission(true);
    }
}
