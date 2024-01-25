package com.gutotech.narutogame.ui.loggedin.support;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Ticket;
import com.gutotech.narutogame.databinding.FragmentSupportTicketBinding;
import com.gutotech.narutogame.ui.adapter.TicketResponsesAdapter;

import es.dmoral.toasty.Toasty;

public class SupportTicketFragment extends Fragment {
    private SupportTicketViewModel mViewModel;

    public SupportTicketFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSupportTicketBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_support_ticket, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Ticket ticket = (Ticket) bundle.getSerializable("ticket");

            mViewModel = new ViewModelProvider(this,
                    new SupportTicketViewModelFactory(ticket))
                    .get(SupportTicketViewModel.class);

            binding.setViewModel(mViewModel);

            if (ticket.getStatus() == Ticket.Status.CLOSED) {
                binding.addAnswerConstraintLayout.setVisibility(View.GONE);
            }

            binding.categoryTextView.setText(
                    getResources().getStringArray(
                            R.array.ticket_categories_list)[ticket.getCategory()]
            );

            binding.responsesRecyclerView.setHasFixedSize(true);
            TicketResponsesAdapter adapter = new TicketResponsesAdapter();
            binding.responsesRecyclerView.setAdapter(adapter);

            mViewModel.getTicketResponses().observe(getViewLifecycleOwner(), responses -> {
                adapter.setTicketResponses(responses);
                binding.responsesRecyclerView.post(() ->
                        binding.responsesRecyclerView.smoothScrollToPosition(adapter.getItemCount())
                );
            });

            mViewModel.getAnswerAddedEvent().observe(getViewLifecycleOwner(), aVoid ->
                    Toasty.success(getContext(), R.string.answer_added, Toasty.LENGTH_LONG).show()
            );
        }

        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mViewModel != null) {
            mViewModel.start();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mViewModel != null) {
            mViewModel.stop();
        }
    }
}
