package com.gutotech.narutogame.ui.loggedin.support;

import android.text.TextUtils;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Ticket;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.SupportRepository;
import com.gutotech.narutogame.utils.DateCustom;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.ArrayList;
import java.util.List;

public class SupportNewViewModel extends ViewModel {
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();

    private Ticket mTicket;
    private SupportRepository mSupportRepository;

    private SingleLiveEvent<List<Integer>> mShowWarningDialogEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mTicketCreatedEvent = new SingleLiveEvent<>();

    public SupportNewViewModel() {
        mSupportRepository = SupportRepository.getInstance();
        mTicket = new Ticket(mSupportRepository.generateId(),
                AuthRepository.getInstance().getCurrentUser().getEmail(),
                Ticket.Status.NEW);
    }

    public void onCategorySelected(int position) {
        mTicket.setCategory(position);
    }

    public void onCreateClick() {
        if (validateFields()) {
            if (CharOn.character != null) {
                mTicket.setCharId(CharOn.character.getId());
            }
            mTicket.setTitle(title.get());
            mTicket.setDescription(description.get());
            mTicket.setDateCreation(DateCustom.getDate());
            mTicket.setTimeCreation(DateCustom.getTime());
            mTicket.setDateUpdated(DateCustom.getDate());
            mTicket.setTimeUpdated(DateCustom.getTime());

            mSupportRepository.save(mTicket);

            mTicket = new Ticket(mSupportRepository.generateId(),
                    AuthRepository.getInstance().getCurrentUser().getEmail(),
                    Ticket.Status.NEW);

            mTicketCreatedEvent.call();
        }
    }

    private boolean validateFields() {
        List<Integer> errorMessages = new ArrayList<>();

        if (TextUtils.isEmpty(title.get())) {
            errorMessages.add(R.string.invalid_title);
        }

        if (TextUtils.isEmpty(description.get())) {
            errorMessages.add(R.string.invalid_description);
        }

        if (errorMessages.size() == 0) {
            return true;
        } else {
            mShowWarningDialogEvent.setValue(errorMessages);
            return false;
        }
    }

    Ticket getTicket() {
        return mTicket;
    }

    LiveData<List<Integer>> getShowWarningDialogEvent() {
        return mShowWarningDialogEvent;
    }

    LiveData<Void> getTicketCreatedEvent() {
        return mTicketCreatedEvent;
    }
}

