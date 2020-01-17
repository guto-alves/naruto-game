package com.gutotech.narutogame.ui.playing.academy;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.PersonagemOn;
import com.gutotech.narutogame.data.repository.CharacterRepository;

public class AcademyTrainningViewModel extends ViewModel {
    private MutableLiveData<Integer> chakra = new MutableLiveData<>(0);
    private MutableLiveData<Integer> stamina = new MutableLiveData<>(0);

    private double percent = 0.01;

    private Formulas formulas;

    public AcademyTrainningViewModel() {
        formulas = PersonagemOn.character.getAttributes().getFormulas();

        calcuteChakraAndStamina();
    }

    public LiveData<Integer> getChakra() {
        return chakra;
    }

    public LiveData<Integer> getStamina() {
        return stamina;
    }

    public void setPercent(double percent) {
        this.percent = percent;
        calcuteChakraAndStamina();
    }

    private void calcuteChakraAndStamina() {
        chakra.setValue((int) (formulas.getChakra() * percent));
        stamina.setValue((int) (formulas.getStamina() * percent));
        Log.i("AcademyTrainning", "chakra: " + chakra.getValue());
        Log.i("AcademyTrainning", "stamina: " + chakra.getValue());
    }

    public void onTrainButtonPressed() {
        if (chakra.getValue() <= formulas.getChakraAtual() &&
                stamina.getValue() <= formulas.getStaminaAtual()) {

            formulas.setChakraAtual(formulas.getChakraAtual() - chakra.getValue());
            formulas.setStaminaAtual(formulas.getStaminaAtual() - stamina.getValue());

            CharacterRepository.getInstance().saveCharacter(PersonagemOn.character);
        } else {

        }
    }
}
