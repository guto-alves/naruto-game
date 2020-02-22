package com.gutotech.narutogame.ui.playing.currentvillage;

import android.graphics.Point;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Battle;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.repository.BattleRepository;
import com.gutotech.narutogame.data.repository.MapRepository;
import com.gutotech.narutogame.ui.adapter.VillageMapRecyclerViewAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

public class VillageMapViewModel extends ViewModel implements VillageMapRecyclerViewAdapter.OnMapClickListener {
    public static final int TOTAL_COLUMNS = 10;
    static final int MAP_LENGTH = 110;

    private int mVillageId;

    private MapRepository mMapRepository;

    private SingleLiveEvent<Integer> mShowWarningDialogEvent = new SingleLiveEvent<>();

    VillageMapViewModel(int villageId) {
        mVillageId = villageId;

        CharOn.character.setMap(true);

        mMapRepository = MapRepository.getInstance();

        if (CharOn.character.getMapPosition() == -1) {
            CharOn.character.setMapPosition(new SecureRandom().nextInt(MAP_LENGTH));
        }

        observe();

        mMapRepository.enter(mVillageId);
    }

    LiveData<Integer> getShowWarningDialogEvent() {
        return mShowWarningDialogEvent;
    }

    LiveData<Map<Integer, List<Character>>> getCharactersOnTheMap() {
        return mMapRepository.load(mVillageId);
    }

    @Override
    public void onDoubleClick(int newPosition) {
        if (isMovementValid(newPosition)) {
            CharOn.character.setMapPosition(newPosition);
            mMapRepository.enter(mVillageId);
        } else {
            mShowWarningDialogEvent.setValue(R.string.this_place_is_far_away);
        }
    }

    @Override
    public void onBattleClick(Character opponent) {
        int levelDifference = Math.abs(opponent.getLevel() - CharOn.character.getLevel());

        if (levelDifference <= 3) {
            mMapRepository.check(opponent.getNick(), mVillageId, result -> {
                if (result) {
                    BattleRepository.getInstance().create(new Battle(CharOn.character, opponent));
                }
            });

        } else {
            // show error message by diff level
        }
    }

    private void observe() {
        BattleRepository.getInstance().observeIds(battleId -> {
            mMapRepository.exit(mVillageId);
            BattleRepository.getInstance().removeId(CharOn.character.getNick(), battleId);
            CharOn.character.battleId = battleId;
            CharOn.character.setBattle(true);
        });
    }

    public void exit() {
        mMapRepository.exit(mVillageId);
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
