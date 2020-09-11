package com.gutotech.narutogame.ui.home.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.databinding.FragmentHomeBinding;
import com.gutotech.narutogame.ui.MaintenanceActivity;
import com.gutotech.narutogame.ui.ProgressDialogFragment;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.KagesSliderAdapter;
import com.gutotech.narutogame.ui.adapter.NewsAdapter;
import com.gutotech.narutogame.ui.adapter.NinjaStatisticsAdapter;
import com.gutotech.narutogame.ui.home.passwordrecovery.PasswordRecoveryFragment;
import com.gutotech.narutogame.ui.home.readnews.ReadNewsFragment;
import com.gutotech.narutogame.ui.loggedin.LoggedInActivity;
import com.gutotech.narutogame.ui.loggedin.newcharacter.CharacterCreateFragment;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SoundUtil;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;

import es.dmoral.toasty.Toasty;

public class HomeFragment extends Fragment implements ResultListener, SectionFragment {
    private static final int RC_SIGN_IN = 9001;

    private HomeViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())
        ).get(HomeViewModel.class);

        FragmentHomeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,
                container, false);
        binding.setViewModel(mViewModel);

        mViewModel.setAuthListener(this);

        if (AuthRepository.getInstance().isSignedIn()) {
            binding.loginLinearLayout.setVisibility(View.GONE);
        } else {
            binding.passwordEditText.setOnEditorActionListener((v, actionId, event) -> {
                mViewModel.onPlayButtonPressed();
                return true;
            });

            binding.forgotPasswordButton.setOnClickListener(v -> {
                SoundUtil.play(getContext(), R.raw.sound_btn06);
                FragmentUtils.goTo(getActivity(), new PasswordRecoveryFragment(), true);
            });

            binding.createAccountButton.setOnClickListener(v -> {
                SoundUtil.play(getContext(), R.raw.sound_btn06);
                FragmentUtils.goTo(getActivity(), new CharacterCreateFragment(), true);
            });

            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build();

            GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
            binding.signInButton.setSize(SignInButton.SIZE_STANDARD);
            binding.signInButton.setColorScheme(SignInButton.COLOR_DARK);
            binding.signInButton.setOnClickListener(v -> {
                Intent signInIntent = googleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            });
        }

        mViewModel.getStartMaintenanceActivityEvent().observe(getViewLifecycleOwner(), aVoid ->
                startActivity(new Intent(getActivity(), MaintenanceActivity.class)));

        binding.newsRecyclerView.setHasFixedSize(true);
        binding.newsRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                LinearLayout.HORIZONTAL));
        NewsAdapter newsAdapter = new NewsAdapter(getActivity(), mOnNewsClickListener);
        binding.newsRecyclerView.setAdapter(newsAdapter);
        mViewModel.getNews().observe(getViewLifecycleOwner(),
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
        mViewModel.getNinjaStatistics().observe(getViewLifecycleOwner(),
                ninjaStatisticsAdapter::setNinjaStatisticsList);

        KagesSliderAdapter kagesSliderAdapter = new KagesSliderAdapter(getContext());
        binding.kagesSliderView.setSliderAdapter(kagesSliderAdapter);
        binding.kagesSliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        binding.kagesSliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.kagesSliderView.startAutoCycle();
        mViewModel.getKages().observe(getViewLifecycleOwner(), kages -> {
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
        FragmentUtils.goTo(getActivity(), readNewsFragment, true);
    };

    private final ProgressDialogFragment mProgressDialog = new ProgressDialogFragment();

    @Override
    public void onStarted() {
        mProgressDialog.openDialog(getChildFragmentManager());
    }

    @Override
    public void onSuccess() {
        mProgressDialog.close();
        startActivity(new Intent(getActivity(), LoggedInActivity.class));
        getActivity().finish();
        SoundUtil.play(getContext(), R.raw.sound_btn03);
    }

    @Override
    public void onFailure(int resId) {
        mProgressDialog.close();

        if (resId != 0) {
            Toasty.error(getActivity(), resId).show();
        }

        SoundUtil.play(getContext(), R.raw.attention2);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                mViewModel.signWithGoogle(getActivity(), account);
            } catch (ApiException e) {
                if (e.getStatusCode() != 12501) {
                    Toast.makeText(getContext(), R.string.google_sign_in_failed, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public int getDescription() {
        return R.string.home;
    }
}
