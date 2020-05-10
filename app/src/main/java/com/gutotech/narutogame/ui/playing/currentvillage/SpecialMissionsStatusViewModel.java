package com.gutotech.narutogame.ui.playing.currentvillage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Mission;
import com.gutotech.narutogame.data.model.MissionInfo;
import com.gutotech.narutogame.data.model.Reward;
import com.gutotech.narutogame.data.model.Score;
import com.gutotech.narutogame.data.model.SpecialMission;
import com.gutotech.narutogame.data.repository.MissionRepository;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.ArrayList;

public class SpecialMissionsStatusViewModel extends ViewModel {
    private Character mCharacter;
    private SpecialMission mSpecialMission;
    private MissionRepository mMissionRepository;
    private MutableLiveData<MissionInfo> mMissionInfo = new MutableLiveData<>();
    private SingleLiveEvent<Integer> mShowMissionCompletedMsg = new SingleLiveEvent<>();

    public SpecialMissionsStatusViewModel() {
        mCharacter = CharOn.character;
        mMissionRepository = MissionRepository.getInstance();

        mMissionRepository.getMission(Mission.Type.SPECIAL, specialMission -> {
            mSpecialMission = (SpecialMission) specialMission;
            mMissionInfo.setValue(mSpecialMission.missionInfo());
            if (mSpecialMission.getDefeated() == mSpecialMission.getDefeat()) {
                mShowMissionCompletedMsg.postValue(
                        mSpecialMission.missionInfo().rewards.get(0).value());
            }
        });
    }

    void onCancelMissionButtonPressed() {
        finishMission();
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

        finishMission();
    }

    private void finishMission() {
        mMissionRepository.finishMission(Mission.Type.SPECIAL);
        CharOn.character.setSpecialMission(false);
    }


    SpecialMission getSpecialMission() {
        return mSpecialMission;
    }

    LiveData<MissionInfo> getMissionInfo() {
        return mMissionInfo;
    }

    LiveData<Integer> getShowMissionCompletedMsg() {
        return mShowMissionCompletedMsg;
    }
}
