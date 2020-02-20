package com.gutotech.narutogame.ui.playing.academy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.model.JutsuInfo;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.data.repository.JutsuRepository;
import com.gutotech.narutogame.ui.adapter.JutsusLearnAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.List;

public class AcademyJutsuViewModel extends ViewModel
        implements JutsusLearnAdapter.OnTrainClickListener {
    private MutableLiveData<List<Jutsu>> mJutsus;

    private MutableLiveData<Classe> mClassSelected;

    private SingleLiveEvent<Integer> showCongratulationsEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> showWarningEvent = new SingleLiveEvent<>();

    public AcademyJutsuViewModel() {
        mJutsus = new MutableLiveData<>();
        mClassSelected = new MutableLiveData<>(CharOn.character.getClasse());
        filterJutsus();
    }

    LiveData<List<Jutsu>> getJutsus() {
        return mJutsus;
    }

    public LiveData<Classe> getClassSelected() {
        return mClassSelected;
    }

    LiveData<Integer> getShowCongratulationsEvent() {
        return showCongratulationsEvent;
    }

    LiveData<Integer> getShowWarningEvent() {
        return showWarningEvent;
    }

    public void onClassButtonPressed(Classe classe) {
        mClassSelected.setValue(classe);
        filterJutsus();
    }

    private void filterJutsus() {
        JutsuRepository.getInstance().filterJutsus(mClassSelected.getValue(),
                jutsus -> mJutsus.postValue(jutsus));
    }

    @Override
    public void onTrainClick(Jutsu jutsu) {
        Formulas formulas = CharOn.character.getAttributes().getFormulas();
        if (formulas.getCurrentChakra() >= jutsu.getConsumesChakra() * 2) {
            if (formulas.getCurrentStamina() >= jutsu.getConsumesStamina() * 2) {
                formulas.subChakra(jutsu.getConsumesChakra() * 2);
                formulas.subStamina(jutsu.getConsumesStamina() * 2);
                CharOn.character.getJutsus().add(jutsu);
                CharacterRepository.getInstance().save(CharOn.character);

                showCongratulationsEvent.setValue(JutsuInfo.valueOf(jutsu.getName()).name);
                filterJutsus();
            } else {
                showWarningEvent.setValue(R.string.stamina);
            }
        } else {
            showWarningEvent.setValue(R.string.chakra);
        }
    }
}
