package com.gutotech.narutogame.ui.playing.currentvillage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentTasksBinding;
import com.gutotech.narutogame.ui.ProgressDialogFragment;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.TasksAdapter;
import com.gutotech.narutogame.utils.FragmentUtils;

public class TasksFragment extends Fragment implements SectionFragment {
    private ProgressDialogFragment mProgressDialog;

    public TasksFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTasksBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tasks,
                container, false);

        TasksViewModel viewModel = new ViewModelProvider(this).get(TasksViewModel.class);
        binding.setViewModel(viewModel);

        binding.tasksRecyclerView.setHasFixedSize(true);
        TasksAdapter adapter = new TasksAdapter(getActivity(), viewModel);
        binding.tasksRecyclerView.setAdapter(adapter);

        viewModel.getTasks().observe(getViewLifecycleOwner(), adapter::setTasks);

        mProgressDialog = new ProgressDialogFragment();

        viewModel.getShowProgressBarEvent().observe(getViewLifecycleOwner(), show -> {
            if (show) {
                mProgressDialog.show(getParentFragmentManager());
            } else {
                mProgressDialog.dismiss();
            }
        });

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_initial_tasks);

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adView.loadAd(adRequest);

        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.tasks;
    }
}
