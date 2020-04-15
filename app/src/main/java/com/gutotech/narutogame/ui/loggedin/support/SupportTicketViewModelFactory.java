package com.gutotech.narutogame.ui.loggedin.support;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gutotech.narutogame.data.model.Ticket;

public class SupportTicketViewModelFactory implements ViewModelProvider.Factory {
    private Ticket ticket;

    public SupportTicketViewModelFactory(Ticket ticket) {
        this.ticket = ticket;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SupportTicketViewModel(ticket);
    }
}
