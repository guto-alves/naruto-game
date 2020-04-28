package com.gutotech.narutogame.ui.playing.ranking;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Village;
import com.gutotech.narutogame.data.repository.RankNinjasRepository;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.List;

public class RankNinjasViewModel extends ViewModel {
    public final ObservableField<String> nick = new ObservableField<>("");

    private Village[] mVillages;
    private Village mVillageSelected;
    private boolean mOnline = false;

    private MutableLiveData<List<Character>> mNinjas = new MutableLiveData<>();

    private SingleLiveEvent<Void> mProgressBarEvent = new SingleLiveEvent<>();

    public RankNinjasViewModel() {
        mVillages = Village.values();
        filter();
    }

    private void filter() {
        mProgressBarEvent.call();
        RankNinjasRepository.getInstance().filter(
                mVillageSelected, nick.get(), mOnline, ninjas -> {
                    mNinjas.postValue(ninjas);
                    mProgressBarEvent.call();
                }
        );
    }

    public void onVillageSelected(int position) {
        if (position == 0) {
            mVillageSelected = null;
        } else {
            mVillageSelected = mVillages[position - 1];
        }
    }

    public void onOnlineSelected(int position) {
        mOnline = position == 1;
    }

    public void onFilterClick() {
        filter();
    }

    LiveData<List<Character>> getNinjas() {
        return mNinjas;
    }

    LiveData<Void> getProgressBarEvent() {
        return mProgressBarEvent;
    }
}
