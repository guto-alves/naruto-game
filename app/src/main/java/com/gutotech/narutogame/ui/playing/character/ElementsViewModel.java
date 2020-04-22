package com.gutotech.narutogame.ui.playing.character;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Element;
import com.gutotech.narutogame.utils.SingleLiveEvent;

public class ElementsViewModel extends ViewModel {
    private MutableLiveData<Element> mElementSelected = new MutableLiveData<>();
    private SingleLiveEvent<Object[]> mShowElementInfoEvent = new SingleLiveEvent<>();
    private MutableLiveData<Boolean> mLearnButtonVisible = new MutableLiveData<>();
    private MutableLiveData<Boolean> mUnlearnButtonVisible = new MutableLiveData<>();

    public ElementsViewModel() {
        if (CharOn.character.getElement() == null) {
            mLearnButtonVisible.setValue(true);
            mUnlearnButtonVisible.setValue(false);
        } else {
            mElementSelected.setValue(CharOn.character.getElement());
            mLearnButtonVisible.setValue(false);
            mUnlearnButtonVisible.setValue(true);
        }
    }

    public void onElementClicked(View view, Element element) {
        if (element == CharOn.character.getElement()) {
            mUnlearnButtonVisible.setValue(true);
        } else {
            mUnlearnButtonVisible.setValue(false);
        }

        mElementSelected.setValue(element);
        mShowElementInfoEvent.setValue(new Object[]{element, view});
    }

    void learnElement() {
        CharOn.character.setElement(mElementSelected.getValue());
        mLearnButtonVisible.setValue(false);
        mUnlearnButtonVisible.setValue(true);
    }

    void unlearnElement() {
        CharOn.character.setElement(null);
        mLearnButtonVisible.setValue(true);
        mUnlearnButtonVisible.setValue(false);
    }

    public LiveData<Element> getElementSelected() {
        return mElementSelected;
    }

    LiveData<Object[]> getShowElementInfoEvent() {
        return mShowElementInfoEvent;
    }

    public LiveData<Boolean> getLearnButtonVisible() {
        return mLearnButtonVisible;
    }

    public LiveData<Boolean> getUnlearningButtonVisible() {
        return mUnlearnButtonVisible;
    }

}
