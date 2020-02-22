package com.gutotech.narutogame.ui.playing.ranking;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Village;
import com.gutotech.narutogame.data.repository.RankNinjasRepository;

import java.util.List;

public class RankNinjasViewModel extends ViewModel {
    public final ObservableField<String> nick = new ObservableField<>("");

    private Village[] mVillages;
    private Village mVillageSelected;
    private boolean mOnline = false;

    private MutableLiveData<List<Character>> mNinjas = new MutableLiveData<>();

    public RankNinjasViewModel() {
        mVillages = Village.values();
        filter();
    }

    LiveData<List<Character>> getNinjas() {
        return mNinjas;
    }

    private void filter() {
        RankNinjasRepository.getInstance().filter(mVillageSelected, nick.get(), mOnline,
                mNinjas::setValue);
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
}
