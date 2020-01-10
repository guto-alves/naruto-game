package com.gutotech.narutogame.ui.loggedin.support;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.adapter.TicketsAdapter;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.util.StorageUtil;
import com.gutotech.narutogame.data.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class SuporteFragment extends Fragment {

    private TicketsAdapter adapter;
    private List<Ticket> ticketsList = new ArrayList<>();

    private Query myTickets;
    private ValueEventListener valueEventListenerTickets;

    public SuporteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_suporte, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            ImageView personagemMsg2 = view.findViewById(R.id.personagemMsg2);
            StorageUtil.baixarImagemParaMsg(getActivity(), personagemMsg2);
            ConstraintLayout msgConstraint2 = view.findViewById(R.id.msgConstraint2);
            msgConstraint2.setVisibility(View.VISIBLE);
        }

        ImageView personagemMsg = view.findViewById(R.id.personagemMsg);
        StorageUtil.baixarImagemParaMsg(getActivity(), personagemMsg);

        DatabaseReference ticketsReference = FirebaseConfig.getDatabase().child("tickets");
        myTickets = ticketsReference.orderByChild("email").equalTo(FirebaseConfig.getAuth().getCurrentUser().getEmail());
        recuperarTickets();

        Button abrirTicketButton = view.findViewById(R.id.abrirTictketButton);
        abrirTicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToFragment(new SuporteNovoFragment());
            }
        });

        RecyclerView ticketsRecyclerView = view.findViewById(R.id.ticketsRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ticketsRecyclerView.setLayoutManager(layoutManager);
        ticketsRecyclerView.setHasFixedSize(true);
        adapter = new TicketsAdapter(getActivity(), ticketsList);
        ticketsRecyclerView.setAdapter(adapter);

        return view;
    }

    private void recuperarTickets() {
        valueEventListenerTickets = myTickets.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ticketsList.clear();

                for (DataSnapshot data : dataSnapshot.getChildren())
                    ticketsList.add(data.getValue(Ticket.class));

                adapter.notifyDataSetChanged();
                myTickets.removeEventListener(valueEventListenerTickets);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void changeToFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment).commit();
    }
}
