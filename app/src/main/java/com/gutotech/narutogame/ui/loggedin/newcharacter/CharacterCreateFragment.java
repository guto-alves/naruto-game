package com.gutotech.narutogame.ui.loggedin.newcharacter;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdRequest;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.databinding.FragmentPersonagemCriarBinding;
import com.gutotech.narutogame.ui.ProgressDialogFragment;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.ui.adapter.ChooseNinjaAdapter;
import com.gutotech.narutogame.ui.home.signup.FastSignUpDialogFragment;
import com.gutotech.narutogame.ui.loggedin.LoggedInActivity;
import com.gutotech.narutogame.ui.loggedin.selectcharacter.CharacterSelectFragment;
import com.gutotech.narutogame.ui.playing.character.CharacterStatusFragment;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SoundUtil;

public class CharacterCreateFragment extends Fragment implements SectionFragment, ResultListener,
        WarningDialogFragment.WarningDialogListener, FastSignUpDialogFragment.SignUpDialogListener {
    private CharacterCreateViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this)
                .get(CharacterCreateViewModel.class);
        mViewModel.setListener(this);

        FragmentPersonagemCriarBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_personagem_criar, container, false);

        binding.setViewModel(mViewModel);

        ChooseNinjaAdapter ninjasAdapter = new ChooseNinjaAdapter(mViewModel);
        binding.ninjasRecyclerView.setAdapter(ninjasAdapter);

        mViewModel.getCurrentNinjasGroupList().observe(getViewLifecycleOwner(),
                ninjasAdapter::setNinjasId);

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_create_character);

        YoYo.with(Techniques.Pulse)
                .duration(1200)
                .repeat(YoYo.INFINITE)
                .playOn(binding.goImageButton);

        YoYo.with(Techniques.Pulse)
                .duration(1200)
                .repeat(YoYo.INFINITE)
                .playOn(binding.backImageButton);

        mViewModel.getImpossibleToCreateEvent().observe(getViewLifecycleOwner(), aVoid -> {
            WarningDialogFragment.newInstance(getContext(), R.string.problem,
                    R.string.max_limit_of_character_warning, this, 0)
                    .openDialog(getParentFragmentManager());
            SoundUtil.play(getContext(), R.raw.attention2);
        });

        mViewModel.getShowFastSignDialogEvent().observe(getViewLifecycleOwner(), aVoid ->
                FastSignUpDialogFragment.show(this));

        binding.adView.loadAd(new AdRequest.Builder().build());

        return binding.getRoot();
    }

    @Override
    public void onCloseClick(int requestCode) {
        if (CharOn.character != null) {
            FragmentUtils.goTo(getActivity(), new CharacterStatusFragment());
        } else {
            FragmentUtils.goTo(getActivity(), new CharacterSelectFragment());
        }
    }

    private void showAlert(@StringRes int titleId, @StringRes int messageId) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle(titleId);
        alert.setMessage(messageId);
        alert.create();
        alert.show();
    }

    private final ProgressDialogFragment mProgressDialog = new ProgressDialogFragment();

    @Override
    public void onStarted() {
        mProgressDialog.openDialog(getParentFragmentManager());
    }

    @Override
    public void onSuccess() {
        mProgressDialog.dismiss();
        showAlert(R.string.ninja_successfully_created, R.string.congratulations_character_created);
        FragmentUtils.goTo(getActivity(), new CharacterSelectFragment());
    }

    @Override
    public void onFailure(int resId) {
        if (mProgressDialog.isVisible()) {
            mProgressDialog.dismiss();
        }
        showAlert(R.string.warning, resId);
        SoundUtil.play(getContext(), R.raw.attention2);
    }

    @Override
    public int getDescription() {
        return R.string.create_character;
    }

    @Override
    public void onAccountCreated() {
        mViewModel.createCharacter();
        showAlert(R.string.ninja_successfully_created, R.string.congratulations_character_created);
        startActivity(new Intent(getActivity(), LoggedInActivity.class));
        getActivity().finish();
        SoundUtil.play(getContext(), R.raw.sound_btn03);
    }
}
