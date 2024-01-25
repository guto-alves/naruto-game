package com.gutotech.narutogame.ui.playing.currentvillage;

import android.graphics.Point;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Village;
import com.gutotech.narutogame.data.repository.BattleRepository;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.data.repository.MapRepository;
import com.gutotech.narutogame.ui.adapter.VillageMapAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VillageMapViewModel extends ViewModel implements VillageMapAdapter.OnMapClickListener {
    public static final int TOTAL_COLUMNS = 10;
    public static final int MAP_SIZE = 110;

    private Village mVillage;

    private MapRepository mMapRepository;
    private BattleRepository mBattleRepository;

    private Map<String, Integer> mDuelCounter = new HashMap<>();

    private SingleLiveEvent<Integer> mShowWarningDialogEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mShowProgressDialogEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mDismissProgressDialogEvent = new SingleLiveEvent<>();

    VillageMapViewModel(Village village) {
        mVillage = village;
        mMapRepository = MapRepository.getInstance();
        mBattleRepository = BattleRepository.getInstance();

        if (!CharOn.character.isMap()) {
            CharOn.character.setMap(true);
        }

        if (CharOn.character.getMapPosition() == -1) {
            CharOn.character.setMapPosition(new SecureRandom().nextInt(MAP_SIZE));
        }

        mMapRepository.getDuelCounters(CharOn.character.getId(),
                duelCounter -> mDuelCounter = duelCounter
        );

        mMapRepository.move(mVillage.ordinal());

        mMapRepository.addBattleRequestListener(CharOn.character.getId(), this::goToBattle);
    }

    private void goToBattle(String battleId) {
        mMapRepository.exit(mVillage.ordinal(), CharOn.character.getId());
        mDismissProgressDialogEvent.call();
        CharOn.character.setBattleId(battleId);
        CharacterRepository.getInstance().save(CharOn.character);
        CharOn.character.setBattle(true);
    }

    @Override
    public void onDoubleClick(int newPosition) {
        if (isMovementValid(CharOn.character.getMapPosition(), newPosition)) {
            CharOn.character.setMapPosition(newPosition);

            if (isPlaceEntry(newPosition) && mVillage == CharOn.character.getVillage()) {
                mMapRepository.exit(mVillage.ordinal(), CharOn.character.getId());
                CharOn.character.setMap(false);
            } else {
                mMapRepository.move(mVillage.ordinal());
            }
        } else {
            mShowWarningDialogEvent.setValue(R.string.this_place_is_far_away);
        }
    }

    @Override
    public synchronized void onBattleClick(Character opponent) {
        if (opponent.getPlayerId().equals(CharOn.character.getPlayerId())) {
            return;
        }

        int levelDifference = Math.abs(opponent.getLevel() - CharOn.character.getLevel());

        if (levelDifference > 2) {
            mShowWarningDialogEvent.setValue(R.string.is_not_at_a_level_suitable_for_you);
            return;
        }

        if (opponent.getVillage() == CharOn.character.getVillage()) {
            mShowWarningDialogEvent.setValue(R.string.you_cannot_battle_with_an_ally);
            return;
        }

        if (getOrDefault(opponent.getId()) > 5) {
            mShowWarningDialogEvent.setValue(R.string.limit_battles_for_today);
            return;
        }

        mShowProgressDialogEvent.call();

        mMapRepository.requestBattle(CharOn.character.getId(), opponent.getId(),
                requestResult -> {
                    mDismissProgressDialogEvent.call();

                    if (requestResult) {
                        mMapRepository.exit(mVillage.ordinal(), CharOn.character.getId());
                        mMapRepository.exit(mVillage.ordinal(), opponent.getId());

                        String battleId = mBattleRepository.generateId("MAP-PVP");

                        mBattleRepository.create(battleId, CharOn.character, opponent);
                        mMapRepository.saveBattleRequestForListeners(battleId,
                                CharOn.character.getId(), opponent.getId());

                        mMapRepository.incrementDuelCount(CharOn.character.getId(), opponent.getId());
                    } else {
                        mShowWarningDialogEvent.setValue(R.string.player_unavailable_to_fight);
                    }
                });
    }

    private int getOrDefault(String key) {
        Integer value;
        return (((value = mDuelCounter.get(key)) != null) || mDuelCounter.containsKey(key))
                ? value : 0;
    }

    private boolean isMovementValid(int currentPosition, int newPosition) {
        Point currentPoint = indexToPoint(currentPosition);
        Point newPoint = indexToPoint(newPosition);

        return distance(currentPoint, newPoint) <= 2;
    }

    private Point indexToPoint(int index) {
        return new Point(index / TOTAL_COLUMNS, index % TOTAL_COLUMNS);
    }

    private int distance(Point point1, Point point2) {
        return (int) Math.sqrt(Math.pow(point2.x - point1.x, 2) + Math.pow(point2.y - point1.y, 2));
    }

    private boolean isPlaceEntry(int position) {
        return mVillage.placeEntries.contains(position);
    }

    void stop() {
        mMapRepository.close();
    }


    LiveData<Map<Integer, List<Character>>> getCharactersOnTheMap() {
        return mMapRepository.load(mVillage.ordinal());
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
