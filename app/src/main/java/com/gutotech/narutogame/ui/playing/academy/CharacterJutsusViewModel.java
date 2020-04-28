package com.gutotech.narutogame.ui.playing.academy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.ui.adapter.LearnedJutsusAdapter;

import java.util.ArrayList;
import java.util.List;

public class CharacterJutsusViewModel extends ViewModel
        implements LearnedJutsusAdapter.LearnedJutsusListener {
    private MutableLiveData<Classe> mClassSelected = new MutableLiveData<>();
    private MutableLiveData<List<Jutsu>> mJutsusFiltered = new MutableLiveData<>();
    private MutableLiveData<Jutsu> mJutsuSelected = new MutableLiveData<>();

    private List<Jutsu> mJutsusFilteredBuffer = new ArrayList<>();

    private Character mCharacter;

    public CharacterJutsusViewModel() {
        mCharacter = CharOn.character;
        onClassButtonPressed(mCharacter.getClasse());
    }

    void updateJutsus() {
        onClassButtonPressed(mClassSelected.getValue());
    }

    public void onClassButtonPressed(Object classeObject) {
        Classe classe = (Classe) classeObject;

        if (classe == mClassSelected.getValue()) {
            return;
        }

        mClassSelected.setValue(classe);

        mJutsusFilteredBuffer.clear();

        for (Jutsu jutsu : mCharacter.getJutsus()) {
            if (jutsu.getAccuracy() == 0) {
                continue;
            }

            if (classe == null && jutsu.isBuffOrDebuff()) {
                mJutsusFilteredBuffer.add(jutsu);
            } else if (jutsu.getClasse() == classe && !jutsu.isBuffOrDebuff()) {
                mJutsusFilteredBuffer.add(jutsu);
            }
        }

        mJutsusFiltered.postValue(mJutsusFilteredBuffer);
    }

    @Override
    public void onVisibilityChanged(Jutsu jutsu) {
        int index = mCharacter.getJutsus().indexOf(jutsu);
        mCharacter.getJutsus().set(index, jutsu);
    }

    @Override
    public void onJutsuSelected(Jutsu jutsu) {
        mJutsuSelected.setValue(jutsu);
    }


    public Character getCharacter() {
        return mCharacter;
    }

    public LiveData<Classe> getClassSelected() {
        return mClassSelected;
    }

    LiveData<List<Jutsu>> getJutsusFiltered() {
        return mJutsusFiltered;
    }

    LiveData<Jutsu> getJutsuSelected() {
        return mJutsuSelected;
    }
}
