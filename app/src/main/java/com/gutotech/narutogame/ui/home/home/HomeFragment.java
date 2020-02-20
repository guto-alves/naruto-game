package com.gutotech.narutogame.ui.home.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
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
import com.gutotech.narutogame.ui.adapter.NinjaStatisticsAdapter;
import com.gutotech.narutogame.ui.adapter.NewsAdapter;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.ui.loggedin.LoggedInActivity;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.ui.home.recuperarsenha.RecuperarSenhaFragment;

import es.dmoral.toasty.Toasty;

public class HomeFragment extends Fragment implements ResultListener, SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        HomeViewModel viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

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
        viewModel.getNews().observe(this, newsAdapter::setNewsList);

        binding.ninjaStatisticsRecyclerView.setHasFixedSize(true);
        NinjaStatisticsAdapter ninjaStatisticsAdapter = new NinjaStatisticsAdapter(getActivity());
        binding.ninjaStatisticsRecyclerView.setAdapter(ninjaStatisticsAdapter);

        viewModel.getNinjaStatistics().observe(this,
                ninjaStatisticsAdapter::setNinjaStatisticsList);

//        ViewPager viewPager = root.findViewById(R.id.kagesAndVilaViewPager);
//        KagesAndVilasViewPagerAdapter viewPagerAdapter = new KagesAndVilasViewPagerAdapter(getActivity());
//        viewPager.setAdapter(viewPagerAdapter);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_home);

        return binding.getRoot();
    }

    private void setUpNewsRecyclerView() {
//        binding.newsRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
//                newsRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
////                Bundle bundle = new Bundle();
////                bundle.putSerializable("noticia", noticiaList.get(position));
////
////                LerNoticiaFragment lerNoticiaFragment = new LerNoticiaFragment();
////                lerNoticiaFragment.setArguments(bundle);
////                changeTo(lerNoticiaFragment);
//        }));
    }

    private ProgressDialog progressDialog = new ProgressDialog();

    @Override
    public void onStarted() {
        progressDialog.show(getFragmentManager(), "ProgressDialog");
    }

    @Override
    public void onSuccess() {
        progressDialog.dismiss();
        startActivity(new Intent(getActivity(), LoggedInActivity.class));
        getActivity().finish();
    }

    @Override
    public void onFailure(int resId) {
        progressDialog.dismiss();
        Toasty.error(getActivity(), resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getDescription() {
        return R.string.home;
    }
}
