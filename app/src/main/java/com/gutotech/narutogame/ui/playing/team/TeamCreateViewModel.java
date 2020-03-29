package com.gutotech.narutogame.ui.playing.team;

import android.text.TextUtils;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Member;
import com.gutotech.narutogame.data.model.Team;
import com.gutotech.narutogame.data.repository.TeamRepository;
import com.gutotech.narutogame.utils.SingleLiveEvent;

public class TeamCreateViewModel extends ViewModel {
    public final ObservableField<String> teamName = new ObservableField<>();

    private TeamRepository mTeamRepository = TeamRepository.getInstance();

    private SingleLiveEvent<Integer> mShowWarningDialogEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mShowProgressDialogEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mDismissProgressDialogEvent = new SingleLiveEvent<>();

    public void onCreateTeamClick() {
        if (isValidName()) {
            mShowProgressDialogEvent.call();

            int price = 5000;

            if (CharOn.character.getGraduationId() >= 2) {
                price = 2000;
            }

            if (CharOn.character.getRyous() < price) {
                mShowWarningDialogEvent.setValue(R.string.failure_to_the_create_team);
                return;
            }

            int finalPrice = price;

            mTeamRepository.isValidName(teamName.get(), result -> {
                mDismissProgressDialogEvent.call();
                if (result) {
                    CharOn.character.subRyous(finalPrice);
                    mTeamRepository.save(new Team(teamName.get(), CharOn.character.getId(),
                            CharOn.character.getVillage().ordinal()));
                    mTeamRepository.saveMember(new Member(CharOn.character.getId()), teamName.get());
                    CharOn.character.setTeam(teamName.get());
                }
            });
        } else {
            mShowWarningDialogEvent.setValue(R.string.error_the_name_of_team_cant_be_empty);
        }
    }

    private boolean isValidName() {
        return !TextUtils.isEmpty(teamName.get());
    }


    LiveData<Integer> getShowWarningDialogEvent() {
        return mShowWarningDialogEvent;
    }

    LiveData<Void> getShowProgressDialogEvent() {
        return mShowProgressDialogEvent;
    }

    LiveData<Void> getDismissProgressDialogEvent() {
        return mDismissProgressDialogEvent;
    }
}
