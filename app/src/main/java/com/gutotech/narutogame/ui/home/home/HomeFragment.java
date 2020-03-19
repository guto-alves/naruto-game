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
import android.widget.Toast;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.databinding.FragmentHomeBinding;
import com.gutotech.narutogame.ui.ProgressDialog;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.KagesSliderAdapter;
import com.gutotech.narutogame.ui.adapter.NinjaStatisticsAdapter;
import com.gutotech.narutogame.ui.adapter.NewsAdapter;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.ui.loggedin.LoggedInActivity;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.ui.home.recuperarsenha.RecuperarSenhaFragment;
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
        }

        binding.passwordEditText.setOnEditorActionListener((v, actionId, event) -> {
            viewModel.onPlayButtonPressed();
            return true;
        });

        binding.forgotPasswordTextView.setOnClickListener(v ->
                FragmentUtil.goTo(getActivity(), new RecuperarSenhaFragment()));

        binding.newsRecyclerView.setHasFixedSize(true);
        binding.newsRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                LinearLayout.HORIZONTAL));
        NewsAdapter newsAdapter = new NewsAdapter(getActivity());
        binding.newsRecyclerView.setAdapter(newsAdapter);
        viewModel.getNews().observe(getViewLifecycleOwner(), newsAdapter::setNewsList);

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
        viewModel.getKages().observe(getViewLifecycleOwner(), kagesSliderAdapter::renewItems);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_home);

        return binding.getRoot();
    }

    private ProgressDialog mProgressDialog = new ProgressDialog();

    @Override
    public void onStarted() {
        mProgressDialog.openDialog(getParentFragmentManager());
    }

    @Override
    public void onSuccess() {
        mProgressDialog.dismiss();
        startActivity(new Intent(getActivity(), LoggedInActivity.class));
        getActivity().finish();
    }

    @Override
    public void onFailure(int resId) {
        mProgressDialog.dismiss();
        Toasty.error(getActivity(), resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getDescription() {
        return R.string.home;
    }
}
