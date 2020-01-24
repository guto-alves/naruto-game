package com.gutotech.narutogame.ui.loggedin.newcharacteer;

import android.text.TextUtils;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Ninja;
import com.gutotech.narutogame.data.model.NinjaLucky;
import com.gutotech.narutogame.data.model.Village;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.data.repository.NinjaLuckyRepository;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.ui.adapter.ChooseNinjaRecyclerViewAdapter;

import java.util.Arrays;
import java.util.List;

public class CharacterCreateViewModel extends ViewModel implements ChooseNinjaRecyclerViewAdapter.NinjaListener {
    public ObservableField<Village> village = new ObservableField<>(Village.FOLHA);
    public ObservableField<Ninja> ninja = new ObservableField<>(Ninja.NARUTO);
    public ObservableInt currentGroupIndex = new ObservableInt(0);

    public Character mCharacter;

    private List<Ninja> mAllNinjasList;
    private MutableLiveData<List<Ninja>> mCurrentNinjasGroupList = new MutableLiveData<>();

    private CharacterRepository mCharacterRepository;

    private ResultListener mListener;

    public CharacterCreateViewModel() {
        mCharacter = new Character(AuthRepository.getInstance().getUid());

        mAllNinjasList = Arrays.asList(Ninja.values());
        loadCurrentGroup();

        mCharacterRepository = CharacterRepository.getInstance();
    }

    public void setListener(ResultListener listener) {
        mListener = listener;
    }

    public LiveData<List<Ninja>> getCurrentNinjasGroupList() {
        return mCurrentNinjasGroupList;
    }

    public void onVillageSelected(Village vila) {
        village.set(vila);
        mCharacter.setVillage(vila);
    }

    public void onClassSelected(Classe classe) {
        mCharacter.setClasse(classe);
        mCharacter.updateFormulas();
        mCharacter.full();
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

    @Override
    public void onNinjaClick(Ninja ninja) {
        this.ninja.set(ninja);
        mCharacter.setNinja(ninja);
    }

    public void onCreateButtonPressed() {
        if (isValidNick()) {
            if (mCharacterRepository.checkByRepeatedNick(mCharacter.getNick())) {
                mCharacterRepository.saveCharacter(mCharacter);

                NinjaLucky ninjaLucky = new NinjaLucky();
                ninjaLucky.deselectAllDaysPlayed();
                NinjaLuckyRepository.getInstance().save(ninjaLucky, mCharacter.getNick());
                mListener.onSuccess();
            } else {
                mListener.onFailure(R.string.name_already_taken);
            }
        }
    }

    private boolean isValidNick() {
        boolean valid = true;

        if (TextUtils.isEmpty(mCharacter.getNick())) {
            mListener.onFailure(R.string.name_field_requered);
            valid = false;
        } else if (mCharacter.getNick().length() > 18) {
            mListener.onFailure(R.string.error_nick_length);
            valid = false;
        } else {
            String nickSemPontuacao = mCharacter.getNick().replaceAll("(?!_)\\p{P}", "");

            if (!nickSemPontuacao.equals(mCharacter.getNick()))
                mListener.onFailure(R.string.error_invalid_nick);
        }

        return valid;
    }

//    private void salvarPersonagem(String nick)
//        character.setDiasLogadosFidelidade(1);
//        character.setTemRecompensaFidelidade(true);
//
//        List<Jutsu> jutsus = new ArrayList<>();
//        if (character.getClasse().equals(Classe.NIN) || character.getClasse().equals(Classe.GEN)) {
//            jutsus.add(new Jutsu(0, "defesa_2_mao", 1, 0, 0, 5, 0, 3, 10, 3, "def", "basico"));
//            jutsus.add(new Jutsu(1, "defesa_acrobatica", 1, 0, 0, 5, 0, 3, 15, 4, "def", "basico"));
//            jutsus.add(new Jutsu(2, "soco", 1, 0, 5, 0, 0, 3, 8, 1, "atk", "basico"));
//            jutsus.add(new Jutsu(3, "chute", 1, 0, 8, 0, 0, 3, 11, 2, "atk", "basico"));
//        } else {
//            jutsus.add(new Jutsu(0, "defesa_2_mao", 1, 0, 0, 5, 0, 3, 3, 10, "def", "basico"));
//            jutsus.add(new Jutsu(1, "defesa_acrobatica", 1, 0, 0, 5, 0, 3, 4, 15, "def", "basico"));
//            jutsus.add(new Jutsu(2, "soco", 1, 5, 0, 0, 0, 3, 1, 8, "atk", "basico"));
//            jutsus.add(new Jutsu(3, "chute", 1, 8, 0, 0, 0, 3, 2, 11, "atk", "basico"));
//        }
//        character.setJutsus(jutsus);
}
