package com.gutotech.narutogame.ui.playing.team;

import android.text.TextUtils;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Team;
import com.gutotech.narutogame.data.repository.TeamRepository;
import com.gutotech.narutogame.utils.SingleLiveEvent;

public class TeamCreateViewModel extends ViewModel {
    public final ObservableField<String> teamName = new ObservableField<>();

    private SingleLiveEvent<Integer> mShowWarningDialogEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mShowProgressDialogEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mDismissProgressDialogEvent = new SingleLiveEvent<>();

    private TeamRepository mTeamRepository = TeamRepository.getInstance();

    LiveData<Integer> getShowWarningDialogEvent() {
        return mShowWarningDialogEvent;
    }

    LiveData<Void> getShowProgressDialogEvent() {
        return mShowProgressDialogEvent;
    }

    LiveData<Void> getDismissProgressDialogEvent() {
        return mDismissProgressDialogEvent;
    }

    public void onCreateTeamClick() {
        if (isValidName()) {
            mShowProgressDialogEvent.call();

            // if (CharOn.character.getGraduationId() > 1 && CharOn.character.getRyous() > 1000)

            mTeamRepository.isValidName(teamName.get(), result -> {
                if (result) {
                    mTeamRepository.save(new Team(mTeamRepository.generateId(), teamName.get(),
                            1, CharOn.character.getVillage().ordinal(), 0, 5000,
                            1000, CharOn.character.getId()));

                    mDismissProgressDialogEvent.call();
                    CharOn.character.setTeam(teamName.get());
                }
            });
        }
    }

    private boolean isValidName() {
        if (TextUtils.isEmpty(teamName.get())) {
            mShowWarningDialogEvent.setValue(R.string.error_the_name_of_team_cant_be_empty);
            return false;
        }

        return true;
    }
}
