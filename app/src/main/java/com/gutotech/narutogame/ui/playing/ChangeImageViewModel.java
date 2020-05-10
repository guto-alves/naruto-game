package com.gutotech.narutogame.ui.playing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.firebase.StorageUtils;

import java.util.List;

public class ChangeImageViewModel extends ViewModel {
    private MutableLiveData<List<StorageReference>> mStorageRefs = new MutableLiveData<>();

    public ChangeImageViewModel() {
        loadReferences();
    }

    LiveData<List<StorageReference>> getStorageRefs() {
        return mStorageRefs;
    }

    private void loadReferences() {
        StorageUtils.listAll(
                String.format("images/profile/%s/", CharOn.character.getNinja().getId()),
                data -> mStorageRefs.setValue(data)
        );
    }
}
