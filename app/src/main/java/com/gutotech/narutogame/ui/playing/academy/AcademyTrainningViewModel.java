package com.gutotech.narutogame.ui.playing.academy;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.PersonagemOn;
import com.gutotech.narutogame.data.repository.CharacterRepository;

public class AcademyTrainningViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> chakra = new MutableLiveData<>();
    private MutableLiveData<Integer> stamina = new MutableLiveData<>();

    public MutableLiveData<Integer> titleMsg = new MutableLiveData<>();
    public MutableLiveData<Integer> descriptionMsg = new MutableLiveData<>();

    private String[] percents;
    private double percent = 0.01;

    private Formulas formulas;

    public AcademyTrainningViewModel(@NonNull Application application) {
        super(application);

        formulas = PersonagemOn.character.getAttributes().getFormulas();

        percents = application.getResources().getStringArray(R.array.attribute_percent);

        calcuteChakraAndStamina();
    }

    public LiveData<Integer> getChakra() {
        return chakra;
    }

    public LiveData<Integer> getStamina() {
        return stamina;
    }

    public void onItemSelected(int position) {
        percent = Double.parseDouble(percents[position]);
        calcuteChakraAndStamina();
    }

    private void calcuteChakraAndStamina() {
        chakra.setValue((int) (formulas.getChakra() * percent / 100));
        stamina.setValue((int) (formulas.getStamina() * percent / 100));
    }

    public void onTrainButtonPressed() {
        if (chakra.getValue() <= formulas.getChakraAtual() &&
                stamina.getValue() <= formulas.getStaminaAtual()) {

            formulas.setChakraAtual(formulas.getChakraAtual() - chakra.getValue());
            formulas.setStaminaAtual(formulas.getStaminaAtual() - stamina.getValue());

            PersonagemOn.character.getAttributes().addTraningPoints((int) percent * 12);

            CharacterRepository.getInstance().saveCharacter(PersonagemOn.character);

            titleMsg.setValue(R.string.training_completed);
            descriptionMsg.setValue(R.string.you_earned_ability_points);
        } else {
            titleMsg.setValue(R.string.problem);
            descriptionMsg.setValue(R.string.you_do_not_have_chakra_for_this_training);
        }
    }
}
