package com.gutotech.narutogame.ui.home.halloffame;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.repository.HallOfFameRepository;
import com.gutotech.narutogame.ui.adapter.RoundsAdapter;

import java.util.List;

public class HallOfFameViewModel extends ViewModel implements RoundsAdapter.RoundClickListener {
    private HallOfFameRepository mHallOfFameRepository;

    private MutableLiveData<List<String>> mRounds = new MutableLiveData<>();
    private MutableLiveData<List<Character>> mKages = new MutableLiveData<>();

    public HallOfFameViewModel() {
        mHallOfFameRepository = HallOfFameRepository.getInstance();
        mHallOfFameRepository.getRounds(mRounds::postValue);
    }

    @Override
    public void onRoundClick(String round) {
        mHallOfFameRepository.get(round, mKages::postValue);
    }

    LiveData<List<String>> getRounds() {
        return mRounds;
    }

    LiveData<List<Character>> getKages() {
        return mKages;
    }
}
