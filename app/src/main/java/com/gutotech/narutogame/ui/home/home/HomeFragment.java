package com.gutotech.narutogame.ui.home.home;

import android.content.Intent;
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
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.databinding.FragmentHomeBinding;
import com.gutotech.narutogame.ui.MaintenanceActivity;
import com.gutotech.narutogame.ui.ProgressDialogFragment;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.KagesSliderAdapter;
import com.gutotech.narutogame.ui.adapter.NinjaStatisticsAdapter;
import com.gutotech.narutogame.ui.adapter.NewsAdapter;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.ui.home.readnews.ReadNewsFragment;
import com.gutotech.narutogame.ui.loggedin.LoggedInActivity;
import com.gutotech.narutogame.ui.loggedin.newcharacter.CharacterCreateFragment;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.ui.home.passwordrecovery.PasswordRecoveryFragment;
import com.gutotech.narutogame.utils.SoundUtil;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;

import es.dmoral.toasty.Toasty;

public class HomeFragment extends Fragment implements ResultListener, SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        HomeViewModel viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        FragmentHomeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,
                container, false);
        binding.setViewModel(viewModel);

        viewModel.setAuthListener(this);

        if (AuthRepository.getInstance().isSignedIn()) {
            binding.loginLinearLayout.setVisibility(View.GONE);
        } else {
            binding.passwordEditText.setOnEditorActionListener((v, actionId, event) -> {
                viewModel.onPlayButtonPressed();
                return true;
            });

            binding.forgotPasswordTextView.setOnClickListener(v -> {
                SoundUtil.play(getContext(), R.raw.sound_btn06);
                FragmentUtils.goTo(getActivity(), new PasswordRecoveryFragment());
            });

            binding.createAccountTextView.setOnClickListener(v -> {
                SoundUtil.play(getContext(), R.raw.sound_btn06);
                FragmentUtils.goTo(getActivity(), new CharacterCreateFragment());
            });
        }

        viewModel.getStartMaintenanceActivityEvent().observe(getViewLifecycleOwner(), aVoid ->
                startActivity(new Intent(getActivity(), MaintenanceActivity.class)));

        binding.newsRecyclerView.setHasFixedSize(true);
        binding.newsRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                LinearLayout.HORIZONTAL));
        NewsAdapter newsAdapter = new NewsAdapter(getActivity(), mOnNewsClickListener);
        binding.newsRecyclerView.setAdapter(newsAdapter);
        viewModel.getNews().observe(getViewLifecycleOwner(),
                news -> {
                    if (news.size() > 0) {
                        binding.newsRecyclerView.setVisibility(View.VISIBLE);
                    } else {
                        binding.newsRecyclerView.setVisibility(View.GONE);
                    }
                    newsAdapter.setNewsList(news);
                });

        binding.ninjaStatisticsRecyclerView.setHasFixedSize(true);
        NinjaStatisticsAdapter ninjaStatisticsAdapter = new NinjaStatisticsAdapter(getActivity());
        binding.ninjaStatisticsRecyclerView.setAdapter(ninjaStatisticsAdapter);
        viewModel.getNinjaStatistics().observe(getViewLifecycleOwner(),
                ninjaStatisticsAdapter::setNinjaStatisticsList);

        KagesSliderAdapter kagesSliderAdapter = new KagesSliderAdapter(getContext());
        binding.kagesSliderView.setSliderAdapter(kagesSliderAdapter);
        binding.kagesSliderView.startAutoCycle();
        binding.kagesSliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        binding.kagesSliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        viewModel.getKages().observe(getViewLifecycleOwner(), kages -> {
            if (kages.size() > 0) {
                binding.kagesCardView.setVisibility(View.VISIBLE);
            }
            kagesSliderAdapter.renewItems(kages);
        });

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_home);

        return binding.getRoot();
    }

    private final NewsAdapter.OnNewsClickListener mOnNewsClickListener = news -> {
        Bundle args = new Bundle();
        args.putSerializable("news", news);
        ReadNewsFragment readNewsFragment = new ReadNewsFragment();
        readNewsFragment.setArguments(args);
        FragmentUtils.goTo(getActivity(), readNewsFragment);
    };

    private final ProgressDialogFragment mProgressDialog = new ProgressDialogFragment();

    @Override
    public void onStarted() {
        mProgressDialog.openDialog(getParentFragmentManager());
    }

    @Override
    public void onSuccess() {
        mProgressDialog.dismiss();
        startActivity(new Intent(getActivity(), LoggedInActivity.class));
        getActivity().finish();
        SoundUtil.play(getContext(), R.raw.sound_btn03);
    }

    @Override
    public void onFailure(int resId) {
        mProgressDialog.dismiss();

        if (resId != 0) {
            Toasty.error(getActivity(), resId).show();
        }

        SoundUtil.play(getContext(), R.raw.attention2);
    }

    @Override
    public int getDescription() {
        return R.string.home;
    }
}
