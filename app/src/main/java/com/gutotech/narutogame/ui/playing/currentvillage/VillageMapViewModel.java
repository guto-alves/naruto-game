package com.gutotech.narutogame.ui.playing.currentvillage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.PersonagemOn;
import com.gutotech.narutogame.data.repository.MapRepository;

import java.security.SecureRandom;
import java.util.List;

public class VillageMapViewModel extends ViewModel {
    static final int MAP_LENGTH = 110;

    private String villageName;

    private MapRepository mMapRepository;

    public VillageMapViewModel(String villageName) {
        this.villageName = villageName;

        mMapRepository = MapRepository.getInstance();

        if (PersonagemOn.character.getMapPosition() == -1) {
            PersonagemOn.character.setMapPosition(new SecureRandom().nextInt(MAP_LENGTH));
            mMapRepository.enterTheMap(villageName);
        }
    }

    public LiveData<List<Character>> getCharactersOnTheMap() {
        return mMapRepository.loadCharactersOnTheMap(villageName);
    }

    public void close() {
        mMapRepository.close();
    }
}
