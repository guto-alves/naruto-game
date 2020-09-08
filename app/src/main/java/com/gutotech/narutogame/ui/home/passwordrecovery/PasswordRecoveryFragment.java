package com.gutotech.narutogame.ui.home.passwordrecovery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentRecuperarSenhaBinding;
import com.gutotech.narutogame.ui.ProgressDialogFragment;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SoundUtil;

import es.dmoral.toasty.Toasty;

public class PasswordRecoveryFragment extends Fragment implements ResultListener, SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        PasswordRecoveryViewModel viewModel = new ViewModelProvider(this)
                .get(PasswordRecoveryViewModel.class);

        FragmentRecuperarSenhaBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_recuperar_senha, container, false);

        binding.setViewModel(viewModel);

        viewModel.setAuthListener(this);

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_i_forgot_my_password);

        return binding.getRoot();
    }

    private ProgressDialogFragment mProgressDialogFragment = new ProgressDialogFragment();

    @Override
    public void onStarted() {
        mProgressDialogFragment.openDialog(getFragmentManager());
    }

    @Override
    public void onSuccess() {
        mProgressDialogFragment.dismiss();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.password_was_sent);
        builder.setMessage(R.string.password_sent_description);
        builder.create();
        builder.show();
        SoundUtil.play(getContext(), R.raw.sound_pop);
    }

    @Override
    public void onFailure(int resId) {
        mProgressDialogFragment.dismiss();
        Toasty.error(getActivity(), resId, Toasty.LENGTH_SHORT).show();
        SoundUtil.play(getContext(), R.raw.attention2);
    }

    @Override
    public int getDescription() {
        return R.string.recover_password;
    }
}
