package com.gutotech.narutogame.ui.playing.academy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Element;
import com.gutotech.narutogame.data.model.ElementalJutsu;
import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.Jutsu;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.data.repository.JutsuRepository;
import com.gutotech.narutogame.ui.adapter.JutsusLearnAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.List;

public class ElementalJutsusViewModel extends ViewModel
        implements JutsusLearnAdapter.OnTrainClickListener {
    private MutableLiveData<List<Jutsu>> mJutsus = new MutableLiveData<>();

    private MutableLiveData<Element> mElementSelected = new MutableLiveData<>();

    private SingleLiveEvent<Integer> mShowCongratulationsEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> mShowWarningEvent = new SingleLiveEvent<>();

    private JutsuRepository mJutsuRepository;

    public ElementalJutsusViewModel() {
        mJutsuRepository = JutsuRepository.getInstance();
        mElementSelected.setValue(CharOn.character.getElement() != null ?
                CharOn.character.getElement() : Element.SUITON
        );
        filterJutsus();
    }

    public void onElementButtonPressed(Element element) {
        if (element == mElementSelected.getValue()) {
            return;
        }
        mElementSelected.setValue(element);
        filterJutsus();
    }

    private void filterJutsus() {
        mJutsuRepository.filterJutsus(mElementSelected.getValue(), mJutsus::postValue);
    }

    @Override
    public synchronized void onTrainClick(Jutsu jutsu) {
        Formulas formulas = CharOn.character.getAttributes().getFormulas();

        if (formulas.getCurrentChakra() >= jutsu.getConsumesChakra() * 2) {
            if (formulas.getCurrentStamina() >= jutsu.getConsumesStamina() * 2) {
                formulas.subChakra(jutsu.getConsumesChakra() * 2);
                formulas.subStamina(jutsu.getConsumesStamina() * 2);

                CharOn.character.getElementalJutsus().add((ElementalJutsu) jutsu);
                CharacterRepository.getInstance().save(CharOn.character);

                mShowCongratulationsEvent.setValue(jutsu.getJutsuInfo().name);
                filterJutsus();
            } else {
                mShowWarningEvent.setValue(R.string.stamina);
            }
        } else {
            mShowWarningEvent.setValue(R.string.chakra);
        }
    }

    public LiveData<Element> getElementSelected() {
        return mElementSelected;
    }

    LiveData<List<Jutsu>> getJutsus() {
        return mJutsus;
    }

    LiveData<Integer> getShowCongratulationsEvent() {
        return mShowCongratulationsEvent;
    }

    LiveData<Integer> getShowWarningEvent() {
        return mShowWarningEvent;
    }
}
