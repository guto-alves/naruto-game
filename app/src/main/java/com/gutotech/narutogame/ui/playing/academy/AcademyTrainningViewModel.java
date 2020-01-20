package com.gutotech.narutogame.ui.playing.academy;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.utils.SingleLiveEvent;

public class AcademyTrainningViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> chakra = new MutableLiveData<>();
    private MutableLiveData<Integer> stamina = new MutableLiveData<>();

    private MutableLiveData<Boolean> showMsg = new MutableLiveData<>(false);
    public SingleLiveEvent<Void> trainingErrorEvent = new SingleLiveEvent<>();
    public SingleLiveEvent<Integer> trainingCompletedEvent = new SingleLiveEvent<>();

    private String[] percents;
    private double percent = 0.01;

    private Formulas formulas;

    public AcademyTrainningViewModel(@NonNull Application application) {
        super(application);

        formulas = CharOn.character.getAttributes().getFormulas();

        percents = application.getResources().getStringArray(R.array.attribute_percent);

        calcuteChakraAndStamina();
    }

    public LiveData<Integer> getChakra() {
        return chakra;
    }

    public LiveData<Integer> getStamina() {
        return stamina;
    }

    public LiveData<Boolean> getShowMsg() {
        return showMsg;
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

            int trainingPointsEarned = (int) percent * 12;

            CharOn.character.getAttributes().incrementDailyTraningPoints(trainingPointsEarned);
            CharOn.character.getAttributes().incrementTraningPoints(trainingPointsEarned);
            CharOn.character.getExtrasInformation().incrementTotalTraining(trainingPointsEarned);

            CharacterRepository.getInstance().saveCharacter(CharOn.character);

            trainingCompletedEvent.setValue(trainingPointsEarned);
        } else {
            trainingErrorEvent.call();
        }

        showMsg.setValue(true);
    }
}
