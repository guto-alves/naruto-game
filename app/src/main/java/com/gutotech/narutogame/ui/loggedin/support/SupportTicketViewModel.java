package com.gutotech.narutogame.ui.loggedin.support;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.firebase.FirebaseFunctionsUtils;
import com.gutotech.narutogame.data.model.Ticket;
import com.gutotech.narutogame.data.model.TicketResponse;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.SupportRepository;
import com.gutotech.narutogame.utils.DateCustom;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.List;

public class SupportTicketViewModel extends ViewModel {
    public final ObservableField<String> response = new ObservableField<>("");
    private Ticket mTicket;
    private SupportRepository mSupportRepository;
    private MutableLiveData<List<TicketResponse>> mTicketResponses = new MutableLiveData<>();

    private SingleLiveEvent<Void> mAnswerAddedEvent = new SingleLiveEvent<>();

    public SupportTicketViewModel(Ticket ticket) {
        mTicket = ticket;
        mSupportRepository = SupportRepository.getInstance();
    }

    private boolean awaiting = false;

    public void addAnswer() {
        if (response.get().trim().isEmpty() || awaiting) {
            return;
        }

        awaiting = true;

        String answer = response.get();
        response.set("");

        FirebaseFunctionsUtils.getServerTime(currentTimestamp -> {
            if (mTicket.getStatus() == Ticket.Status.NEW) {
                mTicket.setStatus(Ticket.Status.AWAITING);
            }

            mTicket.setLastToAnswer(AuthRepository.getInstance().getCurrentUser().getDisplayName());
            mTicket.setDateUpdated(DateCustom.getDate(currentTimestamp));
            mTicket.setTimeUpdated(DateCustom.getTime(currentTimestamp));
            mSupportRepository.save(mTicket);

            mSupportRepository.addAnswer(mTicket.getId(), new TicketResponse(
                    answer, AuthRepository.getInstance().getCurrentUser().getDisplayName(),
                    DateCustom.getDate(currentTimestamp), DateCustom.getTime(currentTimestamp))
            );

            mAnswerAddedEvent.call();
            awaiting = false;
        });
    }

    void start() {
        mSupportRepository.getTicketResponses(mTicket.getId(), mTicketResponses::setValue);
    }

    void stop() {
        mSupportRepository.removeTicketResponsesListener();
    }

    public Ticket getTicket() {
        return mTicket;
    }

    LiveData<List<TicketResponse>> getTicketResponses() {
        return mTicketResponses;
    }

    LiveData<Void> getAnswerAddedEvent() {
        return mAnswerAddedEvent;
    }
}
