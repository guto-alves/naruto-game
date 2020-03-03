package com.gutotech.narutogame.ui.playing.character;

import androidx.annotation.IntDef;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Attribute;
import com.gutotech.narutogame.data.model.LotteryItem;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.NinjaLucky;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.data.repository.NinjaLuckyRepository;
import com.gutotech.narutogame.utils.DateCustom;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class NinjaLuckyViewModel extends ViewModel {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({RYOUS_DAILY, RYOUS_WEEKLY})
    @interface PlayMode {
    }

    public static final int RYOUS_DAILY = 500;
    public static final int RYOUS_WEEKLY = 1500;

    private MutableLiveData<Integer> playModeSelected;

    private static final int TOTAL_ITEMS = 22;

    private int[] intervals = new int[TOTAL_ITEMS];

    private MutableLiveData<List<LotteryItem>> lotteryItems;
    private LotteryItem lotteryItemReceived;

    private SingleLiveEvent<Integer> startAnimationEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<String> showPremiumEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> showWarningDialogEvent = new SingleLiveEvent<>();

    private MutableLiveData<List<Boolean>> daysOfWeek = new MutableLiveData<>();

    private NinjaLucky ninjaLucky;

    public NinjaLuckyViewModel() {
        NinjaLuckyRepository.getInstance().get(CharOn.character.getNick(), data -> {
            ninjaLucky = data;
            daysOfWeek.postValue(ninjaLucky.getDaysOfWeek());
        });

        playModeSelected = new MutableLiveData<>(RYOUS_DAILY);

        lotteryItems = new MutableLiveData<>(buildItems());

        calculateIntervals();
    }

    LiveData<List<LotteryItem>> getLotteryItems() {
        return lotteryItems;
    }

    public LiveData<Integer> getPlayModeSelected() {
        return playModeSelected;
    }

    public LiveData<List<Boolean>> getDaysOfWeek() {
        return daysOfWeek;
    }

    LiveData<Integer> getStartAnimationEvent() {
        return startAnimationEvent;
    }

    LiveData<String> getShowPremiumEvent() {
        return showPremiumEvent;
    }

    LiveData<Integer> getShowWarningDialogEvent() {
        return showWarningDialogEvent;
    }

    public void onPlayModeSeleted(@PlayMode int mode) {
        playModeSelected.setValue(mode);
    }

    public void onPlayButtonPressed() {
        if (validatePlay()) {
            play();
        }
    }

    private boolean validatePlay() {
        int currentDay = DateCustom.getDayOfWeek();

        if (ninjaLucky != null) {
            if (playModeSelected.getValue() == RYOUS_DAILY) {
                if (!ninjaLucky.played(currentDay)) {
                    if (CharOn.character.getRyous() >= RYOUS_DAILY) {
                        CharOn.character.subRyous(RYOUS_DAILY);
                        return true;
                    } else {
                        showWarningDialogEvent.setValue(R.string.warning_dont_have_enough_ryous);
                    }
                } else {
                    showWarningDialogEvent.setValue(R.string.warning_already_played_today);
                }
            } else {
                if (ninjaLucky.playedAllDays()) {
                    if (CharOn.character.getRyous() >= RYOUS_WEEKLY) {
                        CharOn.character.subRyous(RYOUS_WEEKLY);
                        return true;
                    } else {
                        showWarningDialogEvent.setValue(R.string.warning_dont_have_enough_ryous);
                    }
                } else {
                    showWarningDialogEvent.setValue(R.string.warning_havent_played_the_entire_week_yet);
                }
            }
        }

        return false;
    }

    private void play() {
        startAnimationEvent.call();

        lotteryItemReceived = generatePremium();

        lotteryItemReceived.getPremium().receive();
        CharacterRepository.getInstance().save(CharOn.character);

        ninjaLucky.selectDayAsPlayed(DateCustom.getDayOfWeek());
        ninjaLucky.setLastDayPlayed(DateCustom.getDayOfWeek());
        NinjaLuckyRepository.getInstance().save(ninjaLucky, CharOn.character.getNick());
    }

    void onAnimationEnd() {
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
                () -> CharOn.character.getAttributes().earn(Attribute.TAI.id)));
        lotteryItems.add(new LotteryItem("30", "1 Ninjustu Point", 30,
                () -> CharOn.character.getAttributes().earn(Attribute.NIN.id)));
        lotteryItems.add(new LotteryItem("31", "1 Genjutsu Point", 30,
                () -> CharOn.character.getAttributes().earn(Attribute.GEN.id)));
        lotteryItems.add(new LotteryItem("20388", "1 Bukijutsu Point", 30,
                () -> CharOn.character.getAttributes().earn(Attribute.BUK.id)));
        lotteryItems.add(new LotteryItem("32", "1 Agility Point", 30,
                () -> CharOn.character.getAttributes().earn(Attribute.AGI.id)));
        lotteryItems.add(new LotteryItem("33", "1 Seal Point", 30,
                () -> CharOn.character.getAttributes().earn(Attribute.SEAL.id)));
        lotteryItems.add(new LotteryItem("34", "1 Strenght Point", 30,
                () -> CharOn.character.getAttributes().earn(Attribute.FOR.id)));
        lotteryItems.add(new LotteryItem("35", "1 Intelligence Point", 30,
                () -> CharOn.character.getAttributes().earn(Attribute.INTE.id)));
        lotteryItems.add(new LotteryItem("36", "1 Resistance Point", 30,
                () -> CharOn.character.getAttributes().earn(Attribute.RES.id)));
        lotteryItems.add(new LotteryItem("20392", "1 Energy Point", 30,
                () -> CharOn.character.getAttributes().earn(Attribute.ENER.id)));

        return lotteryItems;
    }
}
