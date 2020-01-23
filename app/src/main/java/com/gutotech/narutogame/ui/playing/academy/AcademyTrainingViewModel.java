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
import com.gutotech.narutogame.ui.adapter.DistributedPointsRecyclerAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

public class AcademyTrainingViewModel extends AndroidViewModel
        implements DistributedPointsRecyclerAdapter.OnTrainButtonListener {
    private MutableLiveData<Integer> chakra = new MutableLiveData<>();
    private MutableLiveData<Integer> stamina = new MutableLiveData<>();

    private MutableLiveData<Boolean> trainingButtonEnable = new MutableLiveData<>(true);

    public SingleLiveEvent<Void> trainingErrorEvent = new SingleLiveEvent<>();
    public SingleLiveEvent<Integer> trainingCompletedEvent = new SingleLiveEvent<>();

    private MutableLiveData<Integer> maxTraining;
    private MutableLiveData<Integer> progressTraining;

    private MutableLiveData<Integer> maxNextAbilityPoint;
    private MutableLiveData<Integer> progressNextAbilityPoint;

    private String[] percents;
    private double percent = 0.01;

    private Formulas formulas;

    private SingleLiveEvent<Void> updateDistributedPointsEvent = new SingleLiveEvent<>();

    public AcademyTrainingViewModel(@NonNull Application application) {
        super(application);

        if (CharOn.character.getAttributes().getTraningProgress() ==
                CharOn.character.getGraduation().dailyTrainingLimit) {
            trainingButtonEnable.setValue(false);
        }

        maxTraining = new MutableLiveData<>(CharOn.character.getGraduation().dailyTrainingLimit);
        progressTraining = new MutableLiveData<>(CharOn.character.getAttributes().getTraningProgress());

        maxNextAbilityPoint = new MutableLiveData<>(CharOn.character.getAttributes().getTotalTrainingPoints());
        progressNextAbilityPoint = new MutableLiveData<>(CharOn.character.getAttributes().getTrainingPoints());

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

    public LiveData<Boolean> getTrainingButtonEnable() {
        return trainingButtonEnable;
    }

    public LiveData<Integer> getMaxTraining() {
        return maxTraining;
    }

    public LiveData<Integer> getProgressTraining() {
        return progressTraining;
    }

    public MutableLiveData<Integer> getMaxNextAbilityPoint() {
        return maxNextAbilityPoint;
    }

    public MutableLiveData<Integer> getProgressNextAbilityPoint() {
        return progressNextAbilityPoint;
    }

    public SingleLiveEvent<Void> getUpdateDistributedPointsEvent() {
        return updateDistributedPointsEvent;
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
        if (CharOn.character.getAttributes().getTraningProgress() <
                CharOn.character.getGraduation().dailyTrainingLimit) {
            if (chakra.getValue() <= formulas.getChakraAtual() &&
                    stamina.getValue() <= formulas.getStaminaAtual()) {
                formulas.setChakraAtual(formulas.getChakraAtual() - chakra.getValue());
                formulas.setStaminaAtual(formulas.getStaminaAtual() - stamina.getValue());

                int trainingPointsEarned = (int) percent * 12;

                CharOn.character.getAttributes().incrementTraningProgress(trainingPointsEarned);
                CharOn.character.getAttributes().incrementTraningPoints(trainingPointsEarned);
                CharOn.character.getExtrasInformation().incrementTotalTraining(trainingPointsEarned);

                progressTraining.setValue(CharOn.character.getAttributes().getTraningProgress());
                progressNextAbilityPoint.setValue(CharOn.character.getAttributes().getTrainingPoints());
                maxNextAbilityPoint.setValue(CharOn.character.getAttributes().getTotalTrainingPoints());

                CharOn.character.full();
                CharacterRepository.getInstance().saveCharacter(CharOn.character);

                updateDistributedPointsEvent.call();

                trainingCompletedEvent.setValue(trainingPointsEarned);
            } else {
                trainingErrorEvent.call();
            }
        }

        if (CharOn.character.getAttributes().getTraningProgress() ==
                CharOn.character.getGraduation().dailyTrainingLimit) {
            trainingButtonEnable.setValue(false);
        }
    }

    @Override
    public void onTrainButtonClick(int attributePosition, int quantitySelected) {
        CharOn.character.getAttributes().train(attributePosition, quantitySelected);
        CharOn.character.getExtrasInformation().incrementDistributedPoints(quantitySelected);
        CharOn.character.updateFormulas();

        CharacterRepository.getInstance().saveCharacter(CharOn.character);

        updateDistributedPointsEvent.call();
    }
}
