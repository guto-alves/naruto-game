package com.gutotech.narutogame.ui.loggedout.readnews;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.News;
import com.gutotech.narutogame.databinding.FragmentReadNewsBinding;

public class ReadNewsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentReadNewsBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_read_news, container, false);
        View root = binding.getRoot();

        ReadNewsViewModel mReadNewsViewModel = ViewModelProviders.of(this).get(ReadNewsViewModel.class);
        binding.setViewmodel(mReadNewsViewModel);

        Bundle bundle = getArguments();

        if (bundle != null) {
            News news = (News) bundle.getSerializable("news");
            mReadNewsViewModel.setNews(news);
        }

        mReadNewsViewModel.getComments().observe(this, comments -> {

        });

        RecyclerView commentsRecyclerView = root.findViewById(R.id.commentsRecyclerView);
        commentsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        commentsRecyclerView.setHasFixedSize(true);
        commentsRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.HORIZONTAL));

        return root;
    }
}
