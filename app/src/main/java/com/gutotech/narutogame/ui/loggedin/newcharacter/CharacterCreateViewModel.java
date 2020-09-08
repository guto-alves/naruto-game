package com.gutotech.narutogame.ui.loggedin.newcharacter;

import android.text.TextUtils;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Attributes;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Ninja;
import com.gutotech.narutogame.data.model.NinjaLucky;
import com.gutotech.narutogame.data.model.Village;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.data.repository.JutsuRepository;
import com.gutotech.narutogame.data.repository.NinjaLuckyRepository;
import com.gutotech.narutogame.data.repository.NinjaStatisticsRepository;
import com.gutotech.narutogame.data.repository.PlayerRepository;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.ui.adapter.ChooseNinjaAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class CharacterCreateViewModel extends ViewModel
        implements ChooseNinjaAdapter.NinjaListener {
    public final ObservableInt currentGroupIndex = new ObservableInt(0);
    public final ObservableField<Classe> classSelected = new ObservableField<>(Classe.TAI);

    private CharacterRepository mCharacterRepository;
    private AuthRepository mAuthRepository;

    private Character mChar;

    private List<Ninja> mAllNinjasList;
    private MutableLiveData<List<Ninja>> mCurrentNinjasGroupList = new MutableLiveData<>();

    private ResultListener mListener;

    private SingleLiveEvent<Void> mImpossibleToCreateEvent = new SingleLiveEvent<>();

    private SingleLiveEvent<Void> mShowFastSignDialogEvent = new SingleLiveEvent<>();

    public CharacterCreateViewModel() {
        mCharacterRepository = CharacterRepository.getInstance();
        mAuthRepository = AuthRepository.getInstance();

        mChar = Character.create();

        if (mAuthRepository.isSignedIn()) {
            PlayerRepository.getInstance().getTotalCharacters(totalCharacters -> {
                if (totalCharacters >= 6) {
                    mImpossibleToCreateEvent.call();
                }
            });
        }

        mChar.setJutsus(JutsuRepository.getInstance().getBasicJutsus(Classe.TAI));

        mAllNinjasList = Arrays.asList(Ninja.values());
        loadCurrentGroup();
    }

    public void onVillageSelected(Village village) {
        mChar.setVillage(village);
        mChar.setMapId(village.ordinal());
    }

    public void onClassSelected(Classe classe) {
        classSelected.set(classe);
        mChar.setClasse(classe);
        mChar.setAttributes(new Attributes(classe));
        mChar.updateFormulas();
        mChar.full();
        mChar.setJutsus(JutsuRepository.getInstance().getBasicJutsus(classe));
    }

    @Override
    public void onNinjaClicked(Ninja ninja) {
        mChar.setNinja(ninja);
        mChar.setProfilePath(String.format(Locale.US,
                "images/profile/%d/1.png", ninja.getId()));
    }

    public void onCreateButtonPressed() {
        mChar.setNick(mChar.getNick().trim());

        if (isValidNick()) {
            mListener.onStarted();

            mCharacterRepository.checkByRepeatedNick(mChar.getNick().trim(), isUnique -> {
                if (isUnique) {
                    if (mAuthRepository.isSignedIn()) {
                        createCharacter();
                        mListener.onSuccess();
                    } else {
                        mShowFastSignDialogEvent.call();
                    }
                } else {
                    mListener.onFailure(R.string.name_already_taken);
                }
            });
        }
    }

    public void createCharacter() {
        mChar.setPlayerId(mAuthRepository.getUid());
        mChar.setId(UUID.randomUUID().toString());
        mCharacterRepository.save(mChar);

        NinjaLucky ninjaLucky = new NinjaLucky();
        ninjaLucky.deselectAllDaysPlayed();
        NinjaLuckyRepository.getInstance().save(mChar.getId(), ninjaLucky);

        NinjaStatisticsRepository.getInstance().add(mChar.getNinja());
        PlayerRepository.getInstance().setTotalCharacters(true);
    }

    private void loadCurrentGroup() {
        int from = currentGroupIndex.get() * 6;
        int to = from + 6;
        mCurrentNinjasGroupList.setValue(mAllNinjasList.subList(from, to));
    }

    public void go() {
        currentGroupIndex.set((currentGroupIndex.get() + 1) % 20);
        loadCurrentGroup();
    }

    public void back() {
        if (currentGroupIndex.get() - 1 >= 0) {
            currentGroupIndex.set(currentGroupIndex.get() - 1);
        } else {
            currentGroupIndex.set(19);
        }
        loadCurrentGroup();
    }

    private boolean isValidNick() {
        boolean valid = true;

        if (TextUtils.isEmpty(mChar.getNick())) {
            mListener.onFailure(R.string.name_field_requered);
            valid = false;
        } else if (mChar.getNick().length() > 10) {
            mListener.onFailure(R.string.error_nick_length);
            valid = false;
        } else if (!mChar.getNick().replaceAll("_", "").matches("\\w+")) {
            mListener.onFailure(R.string.error_invalid_nick);
            valid = false;
        }

        return valid;
    }

    public void setListener(ResultListener listener) {
        mListener = listener;
    }

    public Character getCharacter() {
        return mChar;
    }

    LiveData<List<Ninja>> getCurrentNinjasGroupList() {
        return mCurrentNinjasGroupList;
    }

    LiveData<Void> getImpossibleToCreateEvent() {
        return mImpossibleToCreateEvent;
    }

    LiveData<Void> getShowFastSignDialogEvent() {
        return mShowFastSignDialogEvent;
    }
}
