package com.gutotech.narutogame.ui.loggedin.newcharacteer;

import android.text.TextUtils;

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
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.ui.adapter.ChooseNinjaAdapter;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CharacterCreateViewModel extends ViewModel
        implements ChooseNinjaAdapter.NinjaListener {
    public final ObservableInt currentGroupIndex = new ObservableInt(0);

    private Character mChar;

    private List<Ninja> mAllNinjasList;
    private MutableLiveData<List<Ninja>> mCurrentNinjasGroupList = new MutableLiveData<>();

    private CharacterRepository mCharacterRepository;

    private ResultListener mListener;

    public CharacterCreateViewModel() {
        mChar = new Character(AuthRepository.getInstance().getUid());
        mChar.setJutsus(JutsuRepository.getInstance().getJutsusDefault(Classe.TAI));

        mAllNinjasList = Arrays.asList(Ninja.values());
        loadCurrentGroup();

        mCharacterRepository = CharacterRepository.getInstance();
    }

    public void setListener(ResultListener listener) {
        mListener = listener;
    }

    LiveData<List<Ninja>> getCurrentNinjasGroupList() {
        return mCurrentNinjasGroupList;
    }

    public Character getCharacter() {
        return mChar;
    }

    public void onVillageSelected(Village vila) {
        mChar.setVillage(vila);
    }

    public void onClassSelected(Classe classe) {
        mChar.setClasse(classe);
        mChar.setAttributes(new Attributes(classe));
        mChar.updateFormulas();
        mChar.full();
        mChar.setJutsus(JutsuRepository.getInstance().getJutsusDefault(classe));
    }

    @Override
    public void onNinjaClick(Ninja ninja) {
        mChar.setNinja(ninja);
        mChar.setProfilePath(String.format("images/profile/%d/1.png", ninja.getId()));
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

    public void onCreateButtonPressed() {
        mChar.setNick(mChar.getNick().trim());

        if (isValidNick()) {
            mCharacterRepository.checkByRepeatedNick(mChar.getNick().trim(), result -> {
                if (result) {
                    mChar.setId(UUID.randomUUID().toString());
                    mCharacterRepository.save(mChar);

                    NinjaLucky ninjaLucky = new NinjaLucky();
                    ninjaLucky.deselectAllDaysPlayed();
                    NinjaLuckyRepository.getInstance().save(ninjaLucky, mChar.getNick());

                    NinjaStatisticsRepository.getInstance().add(mChar.getNinja().getId());

                    mListener.onSuccess();
                } else {
                    mListener.onFailure(R.string.name_already_taken);
                }
            });
        }
    }

    private boolean isValidNick() {
        boolean valid = true;

        if (TextUtils.isEmpty(mChar.getNick())) {
            mListener.onFailure(R.string.name_field_requered);
            valid = false;
        } else if (mChar.getNick().length() > 10) {
            mListener.onFailure(R.string.error_nick_length);
            valid = false;
        } else {
            String nickSemPontuacao = mChar.getNick().replaceAll("(?!_)\\p{P}", "");

            if (!nickSemPontuacao.equals(mChar.getNick())) {
                mListener.onFailure(R.string.error_invalid_nick);
            }
        }

        return valid;
    }
}
