package com.gutotech.narutogame.ui.playing.currentvillage;

import android.graphics.Point;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.PersonagemOn;
import com.gutotech.narutogame.data.repository.MapRepository;
import com.gutotech.narutogame.ui.adapter.VillageMapRecyclerViewAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.security.SecureRandom;
import java.util.List;

public class VillageMapViewModel extends ViewModel implements VillageMapRecyclerViewAdapter.OnMapClickListener {
    static final int MAP_LENGTH = 110;

    private String villageName;

    private MapRepository mMapRepository;

    private SingleLiveEvent<String> showDialogEvent = new SingleLiveEvent<>();

    public VillageMapViewModel(String villageName) {
        this.villageName = villageName;

        mMapRepository = MapRepository.getInstance();

        if (PersonagemOn.character.getMapPosition() == -1) {
            PersonagemOn.character.setMapPosition(new SecureRandom().nextInt(MAP_LENGTH));
            mMapRepository.enterTheMap(villageName);
        }
    }

    public LiveData<String> getShowDialogEvent() {
        return showDialogEvent;
    }

    public LiveData<List<Character>> getCharactersOnTheMap() {
        return mMapRepository.loadCharactersOnTheMap(villageName);
    }

    public void close() {
        mMapRepository.close();
    }

    @Override
    public void onSingleClick(int position) {

    }

    @Override
    public void onDoubleClick(int newPosition) {
        if (isMovementValid(newPosition)) {
            PersonagemOn.character.setMapPosition(newPosition);
            mMapRepository.enterTheMap(villageName);
        } else {
            showDialogEvent.setValue("O ponto onde você quer ir é muito longe!");
        }
    }

    private boolean isMovementValid(int newPosition) {
        int currentPosition = PersonagemOn.character.getMapPosition();

        Point currentPoint = indexToPoint(currentPosition);
        Point newPoint = indexToPoint(newPosition);

        int distance = distance(currentPoint, newPoint);

        Log.i("VillageMap", "distance: " + distance + currentPoint + " " + newPoint);

        return distance <= 2;
    }

    public static final int TOTAL_COLUMNS = 10;

    private Point indexToPoint(int index) {
        return new Point(index / TOTAL_COLUMNS, index % TOTAL_COLUMNS);
    }

    private int distance(Point point1, Point point2) {
        return (int) Math.sqrt(Math.pow(point2.x - point1.x, 2) + Math.pow(point2.y - point1.y, 2));
    }
}
