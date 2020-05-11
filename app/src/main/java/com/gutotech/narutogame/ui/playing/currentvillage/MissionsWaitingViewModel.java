package com.gutotech.narutogame.ui.playing.currentvillage;

import android.app.Application;
import android.os.CountDownTimer;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gutotech.narutogame.data.firebase.FirebaseFunctionsUtils;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Mission;
import com.gutotech.narutogame.data.model.MissionInfo;
import com.gutotech.narutogame.data.model.Reward;
import com.gutotech.narutogame.data.model.Score;
import com.gutotech.narutogame.data.model.TimeMission;
import com.gutotech.narutogame.data.repository.MissionRepository;
import com.gutotech.narutogame.utils.NotificationsUtils;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MissionsWaitingViewModel extends AndroidViewModel {
    public final ObservableField<String> countDown = new ObservableField<>("--:--:--");

    private TimeMission mTimeMission;

    private MissionRepository mMissionRepository;

    private SingleLiveEvent<List<Integer>> mShowMissionCompletedMsg = new SingleLiveEvent<>();

    private MutableLiveData<MissionInfo> mMissionInfo = new MutableLiveData<>();

    private Character mCharacter;

    public MissionsWaitingViewModel(@NonNull Application application) {
        super(application);
        mCharacter = CharOn.character;
        mMissionRepository = MissionRepository.getInstance();

        mMissionRepository.getMission(Mission.Type.TIME, mission -> {
            mTimeMission = (TimeMission) mission;
            mMissionInfo.setValue(mTimeMission.missionInfo());

            FirebaseFunctionsUtils.getServerTime(currentTimestamp ->
                    startTimer(mTimeMission.getDurationMillis() -
                            (currentTimestamp - mTimeMission.getInitialTimestamp())
                    )
            );
        });
    }

    private void startTimer(long millisInFuture) {
        new CountDownTimer(millisInFuture, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int hours = (int) millisUntilFinished / 1000 / 60 / 60;
                int minutes = (int) millisUntilFinished / 1000 / 60;
                int seconds = (int) millisUntilFinished / 1000 % 60;
                countDown.set(String.format(Locale.US,
                        "%02d:%02d:%02d", hours, minutes, seconds));
            }

            @Override
            public void onFinish() {
                mShowMissionCompletedMsg.setValue(getRewardValues(mMissionInfo.getValue().rewards));
            }
        }.start();
    }

    private List<Integer> getRewardValues(List<Reward> rewards) {
        List<Integer> rewardValues = new ArrayList<>();

        for (Reward reward : rewards) {
            rewardValues.add(reward.value());
        }

        return rewardValues;
    }

    void onCancelMissionButtonPressed() {
        NotificationsUtils.cancelAlarm(getApplication());
        mMissionRepository.finishMission(Mission.Type.TIME);
        CharOn.character.setTimeMission(false);
    }

    public void onFinishButtonPressed() {
        MissionInfo missionInfo = mMissionInfo.getValue();

        for (Reward reward : missionInfo.rewards) {
            reward.receive();
        }

        if (missionInfo.rank == Mission.Rank.TASK) {
            mCharacter.getResumeOfMissions().setTasks(mCharacter.getResumeOfMissions().getTasks() + 1);
            mCharacter.incrementScore(Score.TASK);
        } else if (missionInfo.rank == Mission.Rank.RANK_D) {
            mCharacter.getResumeOfMissions().setRankD(mCharacter.getResumeOfMissions().getRankD() + 1);
            mCharacter.incrementScore(Score.RANK_D);
        } else if (missionInfo.rank == Mission.Rank.RANK_C) {
            mCharacter.getResumeOfMissions().setRankC(mCharacter.getResumeOfMissions().getRankC() + 1);
            mCharacter.incrementScore(Score.RANK_C);
        } else if (missionInfo.rank == Mission.Rank.RANK_B) {
            mCharacter.getResumeOfMissions().setRankB(mCharacter.getResumeOfMissions().getRankB() + 1);
            mCharacter.incrementScore(Score.RANK_B);
        } else if (missionInfo.rank == Mission.Rank.RANK_A) {
            mCharacter.getResumeOfMissions().setRankA(mCharacter.getResumeOfMissions().getRankA() + 1);
            mCharacter.incrementScore(Score.RANK_A);
        } else if (missionInfo.rank == Mission.Rank.RANK_S) {
            mCharacter.getResumeOfMissions().setRankS(mCharacter.getResumeOfMissions().getRankS() + 1);
            mCharacter.incrementScore(Score.RANK_S);
        }

        if (mCharacter.getResumeOfMissions().getMissionsFinishedId() == null) {
            mCharacter.getResumeOfMissions().setMissionsFinishedId(new ArrayList<>());
        }

        mCharacter.getResumeOfMissions().getMissionsFinishedId().add(missionInfo.ordinal());

        if (missionInfo.rank != Mission.Rank.TASK) {
            mCharacter.setTotalDailyMissions(mCharacter.getTotalDailyMissions() + 1);
        }

        mMissionRepository.finishMission(Mission.Type.TIME);
        mCharacter.setTimeMission(false);
    }


    LiveData<MissionInfo> getMissionInfo() {
        return mMissionInfo;
    }

    LiveData<List<Integer>> getShowMissionCompletedMsg() {
        return mShowMissionCompletedMsg;
    }
}
