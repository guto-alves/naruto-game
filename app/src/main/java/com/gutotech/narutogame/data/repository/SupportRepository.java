package com.gutotech.narutogame.data.repository;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class SupportRepository {
    private static SupportRepository sInstance = new SupportRepository();

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
}
