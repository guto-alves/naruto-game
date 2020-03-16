package com.gutotech.narutogame.ui.playing.currentvillage;

import android.os.CountDownTimer;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Mission;
import com.gutotech.narutogame.data.model.MissionInfo;
import com.gutotech.narutogame.data.model.Reward;
import com.gutotech.narutogame.data.model.Score;
import com.gutotech.narutogame.data.model.TimeMission;
import com.gutotech.narutogame.data.repository.MissionRepository;
import com.gutotech.narutogame.utils.DateCustom;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MissionsWaitingViewModel extends ViewModel {
    private TimeMission mTimeMission;

    private CountDownTimer mCountDownTimer;
    public final ObservableField<String> countDown = new ObservableField<>("--:--:--");

    private SingleLiveEvent<List<Integer>> showMissionCompletedMsg = new SingleLiveEvent<>();

    private MissionRepository mMissionRepository;

    private Character mCharacter;

    MissionsWaitingViewModel(TimeMission mission) {
        mTimeMission = mission;

        mCharacter = CharOn.character;

        mMissionRepository = MissionRepository.getInstance();

        init();
    }

    void init() {
        if (mTimeMission.getMillisStopped() > 0) {
            mTimeMission.setMillisStopped(DateCustom.getTimeInMillis() - mTimeMission.getMillisStopped());
        }

        if (mTimeMission.getMillisStopped() >= mTimeMission.getMillisDuration()) {
            showMissionCompletedMsg.setValue(getRewardValues(mTimeMission.missionInfo().rewards));
        } else {
            if (mCountDownTimer == null) {
                startTimer();
            }
        }
    }

    LiveData<List<Integer>> getShowMissionCompletedMsg() {
        return showMissionCompletedMsg;
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeMission.getMillisDuration() -
                mTimeMission.getMillisStopped(), 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeMission.setMillisDuration(millisUntilFinished);
                int hours = (int) millisUntilFinished / 1000 / 60 / 60;
                int minutes = (int) millisUntilFinished / 1000 / 60;
                int seconds = (int) millisUntilFinished / 1000 % 60;
                countDown.set(String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds));
            }

            @Override
            public void onFinish() {
                showMissionCompletedMsg.setValue(getRewardValues(mTimeMission.missionInfo().rewards));
                mCountDownTimer = null;
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
        mMissionRepository.finishTimeMission();
        CharOn.character.setMission(false);
    }

    public void onFinishButtonPressed() {
        mMissionRepository.finishTimeMission();

        MissionInfo missionInfo = mTimeMission.missionInfo();

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

        mCharacter.setMission(false);
    }

    void stop() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
            mCountDownTimer = null;

            mTimeMission.setMillisStopped(DateCustom.getTimeInMillis());
            mMissionRepository.acceptTimeMission(mTimeMission);
        }
    }
}
