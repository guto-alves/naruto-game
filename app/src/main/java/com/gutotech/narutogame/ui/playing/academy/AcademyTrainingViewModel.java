package com.gutotech.narutogame.ui.playing.academy;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Attributes;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Graduation;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.ui.adapter.DistributedPointsAdapter;
import com.gutotech.narutogame.utils.DateCustom;
import com.gutotech.narutogame.utils.SingleLiveEvent;

public class AcademyTrainingViewModel extends AndroidViewModel
        implements DistributedPointsAdapter.OnTrainButtonListener {
    private Character mCharacter;
    private Attributes mAttributes;
    private Formulas mFormulas;

    private String[] mPercents;
    private double mPercent = 0.1;

    private int weeklyLimitOfTraining;

    private MutableLiveData<Integer> mSpentChakra = new MutableLiveData<>();
    private MutableLiveData<Integer> mSpentStamina = new MutableLiveData<>();

    private SingleLiveEvent<Void> mTrainingErrorEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> mTrainingCompletedEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mUpdateDistributedPointsEvent = new SingleLiveEvent<>();

    public AcademyTrainingViewModel(@NonNull Application application) {
        super(application);
        mCharacter = CharOn.character;
        mAttributes = mCharacter.getAttributes();
        mFormulas = mAttributes.getFormulas();
        mPercents = application.getResources().getStringArray(R.array.attribute_percent_list);
        calculateChakraAndStaminaSpent();
        weeklyLimitOfTraining = mCharacter.getAttributes().getWeeklyLimitOfTraining();
    }

    private void calculateChakraAndStaminaSpent() {
        mSpentChakra.setValue((int) (mFormulas.getChakra() * mPercent / 100));
        mSpentStamina.setValue((int) (mFormulas.getStamina() * mPercent / 100));
    }

    public void onItemSelected(int position) {
        mPercent = Double.parseDouble(mPercents[position]);
        calculateChakraAndStaminaSpent();
    }

    public void onTrainButtonPressed() {
        weeklyLimitOfTraining = mCharacter.getAttributes().getWeeklyLimitOfTraining();
        if (mAttributes.getTrainingProgress() < weeklyLimitOfTraining) {
            if (mSpentChakra.getValue() <= mFormulas.getCurrentChakra() &&
                    mSpentStamina.getValue() <= mFormulas.getCurrentStamina()) {
                mFormulas.setCurrentChakra(mFormulas.getCurrentChakra() - mSpentChakra.getValue());
                mFormulas.setCurrentStamina(mFormulas.getCurrentStamina() - mSpentStamina.getValue());

                int trainingPointsEarned = (int) mPercent * 10;

                int newTrainingProgress = trainingPointsEarned + mAttributes.getTrainingProgress();

                if (newTrainingProgress > weeklyLimitOfTraining) {
                    trainingPointsEarned = weeklyLimitOfTraining - mAttributes.getTrainingProgress();
                    newTrainingProgress = weeklyLimitOfTraining;
                }

                mAttributes.setTrainingProgress(newTrainingProgress);
                mAttributes.incrementTraningPoints(trainingPointsEarned);
                mCharacter.getExtrasInformation().incrementTotalTraining(trainingPointsEarned);

                mCharacter.incrementScore(trainingPointsEarned / 100);

                CharacterRepository.getInstance().save(mCharacter);

                mUpdateDistributedPointsEvent.call();

                mTrainingCompletedEvent.setValue(trainingPointsEarned);
            } else {
                mTrainingErrorEvent.call();
            }
        }
    }

    @Override
    public void onTrainButtonClick(int attributePosition, int quantitySelected) {
        mAttributes.train(attributePosition, quantitySelected);
        mCharacter.getExtrasInformation().incrementDistributedPoints(quantitySelected);
        mCharacter.updateFormulas();
        CharacterRepository.getInstance().save(mCharacter);
        mUpdateDistributedPointsEvent.call();
    }

    @Override
    public void onRemoveButtonClick(int attributePosition, int quantitySelected) {
        mAttributes.remove(attributePosition, quantitySelected);
        mCharacter.getExtrasInformation().setDistributedPoints(
                mCharacter.getExtrasInformation().getDistributedPoints() - quantitySelected);
        mCharacter.updateFormulas();
        mCharacter.getFormulas().validateCeil();
        mCharacter.validateJutsus();
        CharacterRepository.getInstance().save(mCharacter);
        mUpdateDistributedPointsEvent.call();
    }


    public LiveData<Integer> getSpentChakra() {
        return mSpentChakra;
    }

    public LiveData<Integer> getSpentStamina() {
        return mSpentStamina;
    }

    public int getWeeklyLimitOfTraining() {
        return weeklyLimitOfTraining;
    }

    public Attributes getAttributes() {
        return mAttributes;
    }

    public Formulas getFormulas() {
        return mFormulas;
    }

    LiveData<Void> getUpdateDistributedPointsEvent() {
        return mUpdateDistributedPointsEvent;
    }

    LiveData<Integer> getTrainingCompletedEvent() {
        return mTrainingCompletedEvent;
    }

    LiveData<Void> getTrainingErrorEvent() {
        return mTrainingErrorEvent;
    }
}
