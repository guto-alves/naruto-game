package com.gutotech.narutogame.ui.playing.ranking;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Village;
import com.gutotech.narutogame.data.repository.RankNinjasRepository;

import java.util.List;

public class RankNinjasViewModel extends ViewModel {
    public final ObservableField<String> nick = new ObservableField<>();
    public final ObservableBoolean online = new ObservableBoolean(false);

    public RankNinjasViewModel() {
    }

    public LiveData<List<Character>> getCharacters() {
        return RankNinjasRepository.getInstance().filter(Village.FOLHA, nick.get(), false);
    }

    public void onFilterClick() {
        getCharacters();
    }
}
