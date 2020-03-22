package com.gutotech.narutogame.ui.loggedin.support;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.Ticket;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.SupportRepository;

import java.util.List;

public class SupportViewModel extends ViewModel {
    private SupportRepository mSupportRepository;

    private MutableLiveData<List<Ticket>> mTickets = new MutableLiveData<>();

    public SupportViewModel() {
        mSupportRepository = SupportRepository.getInstance();

        mSupportRepository.getAll(
                AuthRepository.getInstance().getCurrentUser().getEmail(),
                mTickets::postValue);
    }

    LiveData<List<Ticket>> getTickets() {
        return mTickets;
    }
}
