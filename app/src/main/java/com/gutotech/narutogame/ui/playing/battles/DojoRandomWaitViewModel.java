package com.gutotech.narutogame.ui.playing.battles;

import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.Battle;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.repository.BattleRepository;
import com.gutotech.narutogame.data.repository.DojoWaitingRoomRepository;

public class DojoRandomWaitViewModel extends ViewModel {
    private final DojoWaitingRoomRepository mDojoWaitingRoomRepository;
    private final BattleRepository mBattleRepository;

    public DojoRandomWaitViewModel() {
        mDojoWaitingRoomRepository = DojoWaitingRoomRepository.getInstance();
        mBattleRepository = BattleRepository.getInstance();
    }

    void init() {
        mDojoWaitingRoomRepository.isWaitingRoom(isWaitingRoom -> {
            if (!isWaitingRoom) {
                mDojoWaitingRoomRepository.findOpponent(opponent -> {
                    if (opponent != null) {
                        String battleId = mBattleRepository.generateId(Battle.DOJO_PVP);
                        mBattleRepository.create(battleId, opponent, CharOn.character);
                        mDojoWaitingRoomRepository.saveBattleIdForListeners(battleId,
                                opponent.getId(), CharOn.character.getId());
                    }
                });
            }
        });

        mDojoWaitingRoomRepository.addListener(battleId -> {
            mDojoWaitingRoomRepository.removeListener();
            mDojoWaitingRoomRepository.removeBattleId();

            CharOn.character.setDojoWaitQueue(false);
            CharOn.character.setBattleId(battleId);
            CharOn.character.setBattle(true);
        });
    }

    public void onCancelClick() {
        mDojoWaitingRoomRepository.getOut();
        mDojoWaitingRoomRepository.removeListener();
        CharOn.character.setDojoWaitQueue(false);
    }
}
