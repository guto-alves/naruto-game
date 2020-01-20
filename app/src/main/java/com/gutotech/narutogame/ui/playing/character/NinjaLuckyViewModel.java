package com.gutotech.narutogame.ui.playing.character;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.LotteryItem;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class NinjaLuckyViewModel extends ViewModel {
    private static final int TOTAL_ITEMS = 13;

    private int[] intervals = new int[TOTAL_ITEMS];

    private MutableLiveData<List<LotteryItem>> lotteryItems;
    private LotteryItem lotteryItemReceived;

    private SingleLiveEvent<Integer> startAnimationEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<String> showPremiumEvent = new SingleLiveEvent<>();

    public NinjaLuckyViewModel() {
        lotteryItems = new MutableLiveData<>(buildItems());
        calculateIntervals();
    }

    public void onPlayButtonPressed() {
        if (CharOn.character.getRyous() >= 50) {
            CharOn.character.subRyous(50);

            startAnimationEvent.call();

            lotteryItemReceived = generatePremium();

            lotteryItemReceived.getPremium().receive();
            CharacterRepository.getInstance().saveCharacter(CharOn.character);
        }
    }

    public SingleLiveEvent<Integer> getStartAnimationEvent() {
        return startAnimationEvent;
    }

    public SingleLiveEvent<String> getShowPremiumEvent() {
        return showPremiumEvent;
    }

    public void onAnimationEnd() {
        showPremiumEvent.setValue(lotteryItemReceived.getDescription());
    }

    private void calculateIntervals() {
        intervals[0] = lotteryItems.getValue().get(0).getChancesOfWin();

        for (int i = 1; i < TOTAL_ITEMS; i++) {
            intervals[i] = intervals[i - 1] + lotteryItems.getValue().get(i).getChancesOfWin();
        }
    }

    private LotteryItem generatePremium() {
        int n = new SecureRandom().nextInt(intervals[TOTAL_ITEMS - 1]) + 1;

        int winnerItemIndex = 0;

        if (n > intervals[0]) {
            for (int i = 1; i < TOTAL_ITEMS; i++) {
                if (n > intervals[i - 1] && n <= intervals[i]) {
                    winnerItemIndex = i;
                    break;
                }
            }
        }

        return lotteryItems.getValue().get(winnerItemIndex);
    }

    public LiveData<List<LotteryItem>> getLotteryItems() {
        return lotteryItems;
    }

    private List<LotteryItem> buildItems() {
        List<LotteryItem> lotteryItems = new ArrayList<>();

        lotteryItems.add(new LotteryItem("1", "1 Ryou", 1,
                () -> CharOn.character.addRyous(1)));
        lotteryItems.add(new LotteryItem("3", "2000 Ryous", 50,
                () -> CharOn.character.addRyous(2000)));
        lotteryItems.add(new LotteryItem("4", "5000 Ryous", 20,
                () -> CharOn.character.addRyous(5000)));
        lotteryItems.add(new LotteryItem("5", "10000 Ryous", 10,
                () -> CharOn.character.addRyous(10000)));
        lotteryItems.add(new LotteryItem("6", "25000 Ryous", 5,
                () -> CharOn.character.addRyous(25000)));
        lotteryItems.add(new LotteryItem("7", "50000 Ryous", 1,
                () -> CharOn.character.addRyous(50000)));

        lotteryItems.add(new LotteryItem("9", "1 Experience Points", 1,
                () -> CharOn.character.incrementExp(1)));
        lotteryItems.add(new LotteryItem("11", "1500 Experience Points", 50,
                () -> CharOn.character.incrementExp(1500)));
        lotteryItems.add(new LotteryItem("12", "2000 Experience Points", 40,
                () -> CharOn.character.incrementExp(2000)));
        lotteryItems.add(new LotteryItem("13", "2500 Experience Points", 30,
                () -> CharOn.character.incrementExp(2500)));
        lotteryItems.add(new LotteryItem("14", "3000 Experience Points", 20,
                () -> CharOn.character.incrementExp(3000)));
        lotteryItems.add(new LotteryItem("15", "15000 Experience Points", 1,
                () -> CharOn.character.incrementExp(15000)));

        lotteryItems.add(new LotteryItem("29", "1 Taijutsu Point", 30,
                () -> CharOn.character.getAttributes().taijutsu++));

        return lotteryItems;
    }
}
