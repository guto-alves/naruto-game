package com.gutotech.narutogame.ui.playing.character;

import androidx.annotation.IntDef;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.FirebaseFunctionsUtils;
import com.gutotech.narutogame.data.model.Attribute;
import com.gutotech.narutogame.data.model.LotteryItem;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.NinjaLucky;
import com.gutotech.narutogame.data.repository.Callback;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.data.repository.NinjaLuckyRepository;
import com.gutotech.narutogame.utils.DateCustom;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NinjaLuckyViewModel extends ViewModel {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({RYOUS_DAILY, RYOUS_WEEKLY})
    @interface PlayMode {
    }

    public static final int RYOUS_DAILY = 500;
    public static final int RYOUS_WEEKLY = 1500;

    private static final int TOTAL_ITEMS = 22;

    private int[] mIntervals = new int[TOTAL_ITEMS];

    private MutableLiveData<Integer> mPlayModeSelected;

    private MutableLiveData<List<LotteryItem>> mLotteryItems;
    private LotteryItem mLotteryItemReceived;

    private SingleLiveEvent<Void> mStartAnimationEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> mShowPremiumEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> mShowWarningDialogEvent = new SingleLiveEvent<>();

    private MutableLiveData<List<Boolean>> mDaysOfWeek = new MutableLiveData<>();

    private NinjaLucky mNinjaLucky;

    private int mDayOfWeek;

    public NinjaLuckyViewModel() {
        NinjaLuckyRepository.getInstance().get(CharOn.character.getId(), data -> {
            mNinjaLucky = data;
            mDaysOfWeek.postValue(mNinjaLucky.getDaysOfWeek());
        });

        mPlayModeSelected = new MutableLiveData<>(RYOUS_DAILY);

        mLotteryItems = new MutableLiveData<>(buildItems());

        calculateIntervals();
    }

    public void onPlayModeSeleted(@PlayMode int mode) {
        mPlayModeSelected.setValue(mode);
    }

    public void onPlayButtonPressed() {
        validatePlay(result -> {
            if (result) {
                play();
            }
        });
    }

    private void validatePlay(Callback<Boolean> callback) {
        FirebaseFunctionsUtils.getServerTime(currentTimestamp -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(currentTimestamp);
            mDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            if (mNinjaLucky == null) {
                callback.call(false);
            }

            if (mPlayModeSelected.getValue() == RYOUS_DAILY) {
                if (mNinjaLucky.played(mDayOfWeek)) {
                    mShowWarningDialogEvent.setValue(R.string.warning_already_played_today);
                    callback.call(false);
                }

                if (CharOn.character.getRyous() >= RYOUS_DAILY) {
                    CharOn.character.subRyous(RYOUS_DAILY);
                    callback.call(true);
                } else {
                    mShowWarningDialogEvent.setValue(R.string.warning_dont_have_enough_ryous);
                }
            } else if (mNinjaLucky.playedAllDays()) {
                if (CharOn.character.getRyous() >= RYOUS_WEEKLY) {
                    CharOn.character.subRyous(RYOUS_WEEKLY);
                    callback.call(true);
                } else {
                    mShowWarningDialogEvent.setValue(R.string.warning_dont_have_enough_ryous);
                }
            } else {
                mShowWarningDialogEvent.setValue(R.string.warning_havent_played_the_entire_week_yet);
            }

            callback.call(false);
        });
    }

    private void play() {
        mStartAnimationEvent.call();

        mLotteryItemReceived = generatePremium();

        mLotteryItemReceived.getPremium().receive();
        CharacterRepository.getInstance().save(CharOn.character);

        mNinjaLucky.selectDayAsPlayed(mDayOfWeek);
        NinjaLuckyRepository.getInstance().save(CharOn.character.getId(), mNinjaLucky);
    }

    void onAnimationEnd() {
        mShowPremiumEvent.setValue(mLotteryItemReceived.getDescription());
    }

    private void calculateIntervals() {
        mIntervals[0] = mLotteryItems.getValue().get(0).getChancesOfWin();

        for (int i = 1; i < TOTAL_ITEMS; i++) {
            mIntervals[i] = mIntervals[i - 1] + mLotteryItems.getValue().get(i).getChancesOfWin();
        }
    }

    private LotteryItem generatePremium() {
        int n = new SecureRandom().nextInt(mIntervals[TOTAL_ITEMS - 1]) + 1;

        int winnerItemIndex = 0;

        if (n > mIntervals[0]) {
            for (int i = 1; i < TOTAL_ITEMS; i++) {
                if (n > mIntervals[i - 1] && n <= mIntervals[i]) {
                    winnerItemIndex = i;
                    break;
                }
            }
        }

        return mLotteryItems.getValue().get(winnerItemIndex);
    }

    private List<LotteryItem> buildItems() {
        List<LotteryItem> mLotteryItems = new ArrayList<>();

        mLotteryItems.add(new LotteryItem("1", R.string.ryou1, 1,
                () -> CharOn.character.addRyous(1)));
        mLotteryItems.add(new LotteryItem("3", R.string.ryous2000, 50,
                () -> CharOn.character.addRyous(2000)));
        mLotteryItems.add(new LotteryItem("4", R.string.ryous5000, 20,
                () -> CharOn.character.addRyous(5000)));
        mLotteryItems.add(new LotteryItem("5", R.string.ryous10000, 10,
                () -> CharOn.character.addRyous(10000)));
        mLotteryItems.add(new LotteryItem("6", R.string.ryous25000, 5,
                () -> CharOn.character.addRyous(25000)));
        mLotteryItems.add(new LotteryItem("7", R.string.ryous50000, 1,
                () -> CharOn.character.addRyous(50000)));

        mLotteryItems.add(new LotteryItem("9", R.string.exppoints1, 1,
                () -> CharOn.character.incrementExp(1)));
        mLotteryItems.add(new LotteryItem("11", R.string.exppoints1500, 50,
                () -> CharOn.character.incrementExp(1500)));
        mLotteryItems.add(new LotteryItem("12", R.string.exppoints2000, 40,
                () -> CharOn.character.incrementExp(2000)));
        mLotteryItems.add(new LotteryItem("13", R.string.exppoints2500, 30,
                () -> CharOn.character.incrementExp(2500)));
        mLotteryItems.add(new LotteryItem("14", R.string.exppoints3000, 20,
                () -> CharOn.character.incrementExp(3000)));
        mLotteryItems.add(new LotteryItem("15", R.string.exppoints15000, 1,
                () -> CharOn.character.incrementExp(15000)));

        mLotteryItems.add(new LotteryItem("29", R.string.tai1, 30,
                () -> CharOn.character.getAttributes().earn(Attribute.TAI.id)));
        mLotteryItems.add(new LotteryItem("30", R.string.nin1, 30,
                () -> CharOn.character.getAttributes().earn(Attribute.NIN.id)));
        mLotteryItems.add(new LotteryItem("31", R.string.gen1, 30,
                () -> CharOn.character.getAttributes().earn(Attribute.GEN.id)));
        mLotteryItems.add(new LotteryItem("20388", R.string.buki1, 30,
                () -> CharOn.character.getAttributes().earn(Attribute.BUK.id)));
        mLotteryItems.add(new LotteryItem("32", R.string.agility1, 30,
                () -> CharOn.character.getAttributes().earn(Attribute.AGI.id)));
        mLotteryItems.add(new LotteryItem("33", R.string.seal1, 30,
                () -> CharOn.character.getAttributes().earn(Attribute.SEAL.id)));
        mLotteryItems.add(new LotteryItem("34", R.string.strenght1, 30,
                () -> CharOn.character.getAttributes().earn(Attribute.FOR.id)));
        mLotteryItems.add(new LotteryItem("35", R.string.inte1, 30,
                () -> CharOn.character.getAttributes().earn(Attribute.INTE.id)));
        mLotteryItems.add(new LotteryItem("36", R.string.res1, 30,
                () -> CharOn.character.getAttributes().earn(Attribute.RES.id)));
        mLotteryItems.add(new LotteryItem("20392", R.string.energy1, 30,
                () -> CharOn.character.getAttributes().earn(Attribute.ENER.id)));

        return mLotteryItems;
    }

    LiveData<List<LotteryItem>> getLotteryItems() {
        return mLotteryItems;
    }

    public LiveData<Integer> getPlayModeSelected() {
        return mPlayModeSelected;
    }

    public LiveData<List<Boolean>> getDaysOfWeek() {
        return mDaysOfWeek;
    }

    LiveData<Void> getStartAnimationEvent() {
        return mStartAnimationEvent;
    }

    LiveData<Integer> getShowPremiumEvent() {
        return mShowPremiumEvent;
    }

    LiveData<Integer> getShowWarningDialogEvent() {
        return mShowWarningDialogEvent;
    }
}
