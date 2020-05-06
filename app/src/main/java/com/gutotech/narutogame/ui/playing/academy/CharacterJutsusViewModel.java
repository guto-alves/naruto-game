package com.gutotech.narutogame.ui.playing.academy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.ElementalJutsu;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.model.JutsuInfo;
import com.gutotech.narutogame.ui.adapter.LearnedJutsusAdapter;

import java.util.ArrayList;
import java.util.Collections;
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
        mJutsusFilteredBuffer.clear();

        List<Jutsu> allJutsus = mCharacter.getAllJutsus();

        int totalJutsus = allJutsus.size();

        for (int i = 0; i < totalJutsus; i++) {
            Jutsu jutsu = allJutsus.get(i);
            JutsuInfo jutsuInfo = jutsu.getJutsuInfo();

            if (jutsuInfo.requirements == null) {
                continue;
            }

            if (mClassSelected.getValue() == null && jutsu.isBuffOrDebuff(jutsuInfo)) {
                mJutsusFilteredBuffer.add(jutsu);
            } else if (jutsu.getClasse() == mClassSelected.getValue() &&
                    !jutsu.isBuffOrDebuff(jutsuInfo)) {
                mJutsusFilteredBuffer.add(jutsu);
            }
        }

        Collections.sort(mJutsusFilteredBuffer, (j1, j2) -> {
            int graduation1;
            int graduation2;

            if (j1 instanceof ElementalJutsu) {
                graduation1 = j1.getJutsuInfo().requirements.get(1).getValue();
            } else {
                graduation1 = j1.getJutsuInfo().requirements.get(0).getValue();
            }

            if (j2 instanceof ElementalJutsu) {
                graduation2 = j2.getJutsuInfo().requirements.get(1).getValue();
            } else {
                graduation2 = j2.getJutsuInfo().requirements.get(0).getValue();
            }

            if (graduation1 == graduation2) {
                return 0;
            }
            return graduation1 > graduation2 ? 1 : -1;
        });

        mJutsusFiltered.postValue(mJutsusFilteredBuffer);
    }

    public void onClassButtonPressed(Object classeObject) {
        Classe classe = (Classe) classeObject;

        if (classe == mClassSelected.getValue()) {
            return;
        }

        mClassSelected.setValue(classe);
        updateJutsus();
    }

    @Override
    public void onVisibilityChanged(Jutsu jutsu) {
        mCharacter.setJutsu(jutsu);
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
