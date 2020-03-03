package com.gutotech.narutogame.ui.playing.currentvillage;

import android.graphics.Point;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Battle;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Village;
import com.gutotech.narutogame.data.repository.BattleRepository;
import com.gutotech.narutogame.data.repository.MapRepository;
import com.gutotech.narutogame.ui.adapter.VillageMapAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

public class VillageMapViewModel extends ViewModel implements VillageMapAdapter.OnMapClickListener {
    public static final int TOTAL_COLUMNS = 10;
    public static final int MAP_SIZE = 110;

    private Village mVillage;

    private MapRepository mMapRepository;

    private SingleLiveEvent<Integer> mShowWarningDialogEvent = new SingleLiveEvent<>();

    VillageMapViewModel(Village village) {
        mVillage = village;

        mMapRepository = MapRepository.getInstance();

        CharOn.character.setMapId(mVillage.id);

        if (!CharOn.character.isMap()) {
            CharOn.character.setMap(true);
        }

        if (CharOn.character.getMapPosition() == -1) {
            CharOn.character.setMapPosition(new SecureRandom().nextInt(MAP_SIZE));
        }

        mMapRepository.enter(mVillage.id);

        observe();
    }

    LiveData<Integer> getShowWarningDialogEvent() {
        return mShowWarningDialogEvent;
    }

    LiveData<Map<Integer, List<Character>>> getCharactersOnTheMap() {
        return mMapRepository.load(mVillage.id);
    }

    @Override
    public void onDoubleClick(int newPosition) {
        if (isMovementValid(newPosition)) {
            if (isPlaceEntry(newPosition)) {
                mMapRepository.exit(mVillage.id);
                CharOn.character.setMap(false);
                return;
            }

            CharOn.character.setMapPosition(newPosition);
            mMapRepository.enter(mVillage.id);
        } else {
            mShowWarningDialogEvent.setValue(R.string.this_place_is_far_away);
        }
    }

    private boolean isPlaceEntry(int position) {
        return mVillage.placeEntries.contains(position);
    }

    @Override
    public void onBattleClick(Character opponent) {
        int levelDifference = Math.abs(opponent.getLevel() - CharOn.character.getLevel());

        if (opponent.getPlayerId().equals(CharOn.character.getPlayerId())) {
            //
        } else if (levelDifference <= 2) {
            mMapRepository.check(opponent.getNick(), mVillage.id, result -> {
                if (result) {
                    BattleRepository.getInstance().create(new Battle(CharOn.character, opponent));
                } else {
                    mShowWarningDialogEvent.setValue(R.string.player_unavailable_to_fight);
                }
            });
        } else {
            mShowWarningDialogEvent.setValue(R.string.is_not_at_a_level_suitable_for_you);
        }
    }

    private void observe() {
        BattleRepository.getInstance().observeIds(battleId -> {
            mMapRepository.exit(mVillage.id);
            BattleRepository.getInstance().removeId(CharOn.character.getNick(), battleId);
            CharOn.character.battleId = battleId;
            CharOn.character.setBattle(true);
        });
    }

    public void exit() {
        mMapRepository.exit(mVillage.id);
    }

    private boolean isMovementValid(int newPosition) {
        int currentPosition = CharOn.character.getMapPosition();

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

    public void stop() {
        mMapRepository.close();
    }
}
