package com.gutotech.narutogame.ui.playing.user;

import android.content.Context;
import android.text.TextUtils;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Ninja;
import com.gutotech.narutogame.data.model.Village;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.data.repository.NinjaStatisticsRepository;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;

public class VipPlayerViewModel extends ViewModel {
    public final int PRICE_TO_CHANGE_NAME = 2000;
    public final int PRICE_TO_CHANGE_CHARACTER = 2000;
    public final int PRICE_TO_CHANGE_CLASS = 2000;
    public final int PRICE_TO_CHANGE_VILLAGE = 5000;
    public final int PRICE_TO_REDISTRIBUTE_5_POINTS = 1000;
    public final int PRICE_TO_REDISTRIBUTE_10_POINTS = 1500;
    public final int PRICE_TO_REDISTRIBUTE_15_POINTS = 2000;
    public final int PRICE_TO_REDISTRIBUTE_POINTS = 3000;

    public final ObservableField<String> name = new ObservableField<>("");

    private SingleLiveEvent<Integer> mShowSuccessMessageEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> mShowWarningDialogEvent = new SingleLiveEvent<>();

    private int mNinjaSelectedIndex;
    private int mClassesSelectedIndex;
    private int mVillageSelectedIndex;

    private List<Ninja> mNinjas;
    private List<Classe> mClasses;
    private List<Village> mVillages;

    private Character mCharacter;

    public VipPlayerViewModel() {
        mCharacter = CharOn.character;

        mNinjas = new ArrayList<>(Arrays.asList(Ninja.values()));
        mClasses = new ArrayList<>(Arrays.asList(Classe.values()));
        mVillages = new ArrayList<>();
        mVillages.addAll(EnumSet.range(Village.FOLHA, Village.CHUVA));

        mNinjas.remove(mCharacter.getNinja().ordinal());
        mClasses.remove(mCharacter.getClasse().ordinal());
        mVillages.remove(mCharacter.getVillage().ordinal());
    }

    public void onNinjaSelected(int position) {
        mNinjaSelectedIndex = position;
    }

    public void onClassSelected(int position) {
        mClassesSelectedIndex = position;
    }

    public void onVillageSelected(int position) {
        mVillageSelectedIndex = position;
    }

    private boolean makePayment(int price, long myRyous) {
        if (hasEnoughRyous(price, myRyous)) {
            CharOn.character.subRyous(price);
            return true;
        }

        mShowWarningDialogEvent.setValue(R.string.dont_have_enough_ryous);

        return false;
    }

    private boolean hasEnoughRyous(int price, long myRyous) {
        return myRyous >= price;
    }


    public void onBuyChangeNameClick() {
        name.set(name.get().trim());

        if (!TextUtils.isEmpty(name.get())) {
            if (makePayment(PRICE_TO_CHANGE_NAME, mCharacter.getRyous())) {
                CharacterRepository.getInstance().checkByRepeatedNick(name.get(), result -> {
                    if (result) {
                        mCharacter.setNick(name.get());
                        CharacterRepository.getInstance().save(mCharacter);
                        mShowSuccessMessageEvent.setValue(R.string.change_name_of_the_character);
                    } else {
                        mShowWarningDialogEvent.setValue(R.string.name_already_taken);
                    }
                });
            }
        }
    }

    public void onBuyCharacterChangeClick() {
        if (makePayment(PRICE_TO_CHANGE_CHARACTER, mCharacter.getRyous())) {
            Ninja newNinja = mNinjas.get(mNinjaSelectedIndex);

            NinjaStatisticsRepository.getInstance().add(newNinja);
            NinjaStatisticsRepository.getInstance().remove(mCharacter.getNinja().getId());

            mCharacter.setNinja(newNinja);
            mCharacter.setProfilePath(
                    String.format(Locale.US, "images/profile/%d/1.png", newNinja.getId())
            );

            mShowSuccessMessageEvent.setValue(R.string.character_change);
        }
    }

    public void onBuyClassChangeClick() {
        if (makePayment(PRICE_TO_CHANGE_CLASS, mCharacter.getRyous())) {
            Classe newClass = mClasses.get(mClassesSelectedIndex);
            mCharacter.setClasse(newClass);
            mCharacter.getAttributes().changeBasePoints(newClass);
            mCharacter.updateFormulas();
            mCharacter.full();
            mCharacter.validateJutsus();

            mShowSuccessMessageEvent.setValue(R.string.class_change);
        }
    }

    public void onBuyChangeVillageClick() {
        if (!TextUtils.isEmpty(mCharacter.getTeam())) {
            return;
        }

        if (mCharacter.getLevel() > 10) {
            return;
        }

        if (makePayment(PRICE_TO_CHANGE_VILLAGE, mCharacter.getRyous())) {
            mCharacter.setVillage(mVillages.get(mVillageSelectedIndex));
            if (!mCharacter.isMap()) {
                mCharacter.setMapId(mCharacter.getVillage().ordinal());
            }
            CharacterRepository.getInstance().save(mCharacter);

            mShowSuccessMessageEvent.setValue(R.string.change_village);
        }
    }

    public void onBuyRedistribute5PointsClick() {
        if (makePayment(PRICE_TO_REDISTRIBUTE_5_POINTS, mCharacter.getRyous())) {
            mCharacter.getAttributes().setTotalRedistributePoints(
                    mCharacter.getAttributes().getTotalRedistributePoints() + 5);

            mShowSuccessMessageEvent.setValue(R.string.redistribute_5_points);
        }
    }

    public void onBuyRedistribute10PointsClick() {
        if (makePayment(PRICE_TO_REDISTRIBUTE_10_POINTS, mCharacter.getRyous())) {
            mCharacter.getAttributes().setTotalRedistributePoints(
                    mCharacter.getAttributes().getTotalRedistributePoints() + 10);

            mShowSuccessMessageEvent.setValue(R.string.redistribute_10_points);
        }
    }

    public void onBuyRedistribute15PointsClick() {
        if (makePayment(PRICE_TO_REDISTRIBUTE_15_POINTS, mCharacter.getRyous())) {
            mCharacter.getAttributes().setTotalRedistributePoints(
                    mCharacter.getAttributes().getTotalRedistributePoints() + 15);

            mShowSuccessMessageEvent.setValue(R.string.redistribute_15_points);
        }
    }

    public void onBuyRedistributePoints() {
        if (makePayment(PRICE_TO_REDISTRIBUTE_POINTS, mCharacter.getRyous())) {
            int totalDistributedPoints = mCharacter.getExtrasInformation().getDistributedPoints();
            mCharacter.getExtrasInformation().setDistributedPoints(0);
            mCharacter.getAttributes().setTotalFreePoints(totalDistributedPoints);
            Collections.fill(mCharacter.getAttributes().getDistributedPoints(), 0);
            mCharacter.updateFormulas();
            mCharacter.getFormulas().validateCeil();
            mCharacter.validateJutsus();

            mShowSuccessMessageEvent.setValue(R.string.redistribute_points);
        }
    }


    List<Ninja> getNinjas() {
        return mNinjas;
    }

    List<Classe> getClasses() {
        return mClasses;
    }

    String[] getVillages(Context context) {
        String[] mVillageNames = new String[7];

        int i = 0;

        for (Village village : mVillages) {
            mVillageNames[i++] = context.getString(village.getName());
        }

        return mVillageNames;
    }

    LiveData<Integer> getShowSuccessMessageEvent() {
        return mShowSuccessMessageEvent;
    }

    LiveData<Integer> getShowWarningDialogEvent() {
        return mShowWarningDialogEvent;
    }
}
