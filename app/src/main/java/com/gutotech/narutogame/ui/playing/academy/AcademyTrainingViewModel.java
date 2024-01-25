package com.gutotech.narutogame.ui.playing.academy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.Attributes;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.ui.adapter.DistributedPointsAdapter;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.List;

public class AcademyTrainingViewModel extends ViewModel
        implements DistributedPointsAdapter.OnTrainButtonListener {
    private Character mCharacter;
    private Attributes mAttributes;

    private MutableLiveData<Integer> mFreePoints = new MutableLiveData<>();
    private MutableLiveData<List<Integer>> mDistributedPoints = new MutableLiveData<>();

    private SingleLiveEvent<Void> mPlaySound = new SingleLiveEvent<>();

    public AcademyTrainingViewModel() {
        mCharacter = CharOn.character;
        mAttributes = mCharacter.getAttributes();
        updateUI();
    }

    @Override
    public synchronized void onTrainButtonClick(int attributePosition, int quantitySelected) {
        mAttributes.train(attributePosition, quantitySelected);
        mCharacter.updateFormulas();
        mCharacter.getExtrasInformation().incrementDistributedPoints(quantitySelected);
        CharacterRepository.getInstance().save(mCharacter);
        updateUI();
        mPlaySound.call();
    }

    @Override
    public synchronized void onRemoveButtonClick(int attributePosition, int quantitySelected) {
        mAttributes.remove(attributePosition, quantitySelected);
        mCharacter.updateFormulas();
        mCharacter.getFormulas().validateCeil();
        mCharacter.getExtrasInformation().decrementDistributedPoints(quantitySelected);
        mCharacter.validateJutsus();
        CharacterRepository.getInstance().save(mCharacter);
        updateUI();
        mPlaySound.call();
    }

    private void updateUI() {
        mFreePoints.setValue(mAttributes.getTotalFreePoints());
        mDistributedPoints.setValue(mAttributes.getDistributedPoints());
    }

    LiveData<Integer> getFreePoints() {
        return mFreePoints;
    }

    LiveData<List<Integer>> getDistributedPoints() {
        return mDistributedPoints;
    }

    LiveData<Void> getPlaySound() {
        return mPlaySound;
    }
}
