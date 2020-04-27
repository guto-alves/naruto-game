package com.gutotech.narutogame.ui.playing.battles;

import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.repository.DojoRandomWaitRepository;

public class DojoRandomWaitViewModel extends ViewModel {
    private DojoRandomWaitRepository mDojoRandomWaitRepository;

    public DojoRandomWaitViewModel() {
        mDojoRandomWaitRepository = DojoRandomWaitRepository.getInstance();
    }

    void init() {
        mDojoRandomWaitRepository.goToQueue();

        mDojoRandomWaitRepository.observe(battleId -> {
            mDojoRandomWaitRepository.removeObserver();
            mDojoRandomWaitRepository.removeId();

            CharOn.character.setDojoWaitQueue(false);
            CharOn.character.battleId = battleId;
            CharOn.character.setBattle(true);
        });
    }

    public void onCancelClick() {
        mDojoRandomWaitRepository.exit();
        CharOn.character.setDojoWaitQueue(false);
    }
}
