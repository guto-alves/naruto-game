package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Ticket;
import com.gutotech.narutogame.data.model.TicketResponse;

import java.util.ArrayList;
import java.util.List;

public class SupportRepository {
    private static final SupportRepository sInstance = new SupportRepository();

    private SupportRepository() {
    }

    public static SupportRepository getInstance() {
        return sInstance;
    }

    public String generateId() {
        return FirebaseConfig.getDatabase().child("tickets").push().getKey();
    }

    public void save(Ticket ticket) {
        DatabaseReference ticketsReference = FirebaseConfig.getDatabase()
                .child("tickets")
                .child(ticket.getId());

        ticketsReference.setValue(ticket);
    }

    public void getAll(String email, Callback<List<Ticket>> callback) {
        DatabaseReference ticketsReference = FirebaseConfig.getDatabase()
                .child("tickets");

        Query ticketsQuery = ticketsReference.orderByChild("email").equalTo(email);

        ticketsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Ticket> tickets = new ArrayList<>();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    tickets.add(data.getValue(Ticket.class));
                }

                callback.call(tickets);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }


    public void addAnswer(String ticketId, TicketResponse ticketResponse) {
        DatabaseReference ticketsReference = FirebaseConfig.getDatabase()
                .child("ticket-responses")
                .child(ticketId)
                .push();

        ticketsReference.setValue(ticketResponse);
    }

    private DatabaseReference mTicketResponsesReference;
    private ChildEventListener mTicketResponseEventListener;

    public void getTicketResponses(String ticketId, Callback<List<TicketResponse>> callback) {
        removeTicketResponsesListener();

        mTicketResponsesReference = FirebaseConfig.getDatabase()
                .child("ticket-responses")
                .child(ticketId);

        List<TicketResponse> ticketResponses = new ArrayList<>();

        mTicketResponsesReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ticketResponses.add(dataSnapshot.getValue(TicketResponse.class));
                callback.call(ticketResponses);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void removeTicketResponsesListener() {
        if (mTicketResponseEventListener != null) {
            mTicketResponsesReference.removeEventListener(mTicketResponseEventListener);
            mTicketResponseEventListener = null;
        }
    }
}
