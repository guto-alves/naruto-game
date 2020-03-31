package com.gutotech.narutogame.ui.home.readnews;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.News;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.databinding.FragmentReadNewsBinding;
import com.gutotech.narutogame.ui.adapter.NewsCommentsAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;

public class ReadNewsFragment extends Fragment {
    private ReadNewsViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentReadNewsBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_read_news, container, false);

        if (!AuthRepository.getInstance().isSignedIn()) {
            binding.likeButton.setVisibility(View.GONE);
            binding.leaveCommentConstraintLayout.setVisibility(View.GONE);
        }

        Bundle bundle = getArguments();

        if (bundle != null) {
            News news = (News) bundle.getSerializable("news");

            mViewModel = new ViewModelProvider(
                    this, new ReadNewsViewModelFactory(news))
                    .get(ReadNewsViewModel.class);
            binding.setViewModel(mViewModel);

            mViewModel.getLikeEvent().observe(getViewLifecycleOwner(), liked -> {
                if (liked) {
                    binding.likeButton.setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.ic_check_white_24dp, 0, 0, 0);
                } else {
                    binding.likeButton.setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.ic_like_30dp, 0, 0, 0);
                }
            });

            binding.commentsRecyclerView.setHasFixedSize(true);
            binding.commentsRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                    LinearLayout.HORIZONTAL));
            NewsCommentsAdapter adapter = new NewsCommentsAdapter(getContext());
            binding.commentsRecyclerView.setAdapter(adapter);

            mViewModel.getComments().observe(getViewLifecycleOwner(), adapter::setComments);
        }

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_read_news);

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
