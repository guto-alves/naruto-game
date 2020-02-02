package com.gutotech.narutogame.ui.playing.currentvillage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentTasksBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.TasksRecyclerViewAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;

public class TasksFragment extends Fragment implements SectionFragment {

    public TasksFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTasksBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tasks,
                container, false);

        TasksViewModel viewModel = ViewModelProviders.of(this).get(TasksViewModel.class);
        binding.setViewModel(viewModel);

        binding.tasksRecyclerView.setHasFixedSize(true);
        TasksRecyclerViewAdapter adapter = new TasksRecyclerViewAdapter(getActivity(), viewModel);
        binding.tasksRecyclerView.setAdapter(adapter);

        viewModel.getTasks().observe(this, adapter::setTasks);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_initial_tasks);
        return binding.getRoot();
    }


    @Override
    public int getDescription() {
        return R.string.tasks;
    }
}
