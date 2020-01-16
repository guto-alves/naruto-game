package com.gutotech.narutogame.ui.loggedout.signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentSignupBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WaitDialogFragment;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.StorageUtil;

import es.dmoral.toasty.Toasty;

public class SignupFragment extends Fragment implements ResultListener, SectionFragment {
    private FragmentSignupBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SignupViewModel mViewModel = ViewModelProviders.of(getActivity()).get(SignupViewModel.class);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup,
                container, false);

        binding.setViewModel(mViewModel);

        mViewModel.setAuthListener(this);

        binding.msgLayout.msgTitleTextView.setText(R.string.just_a_bit_now);
        binding.msgLayout.msgTextView.setText(R.string.fullfill_the_form_below);
        StorageUtil.downloadProfileForMsg(getActivity(), binding.msgLayout.msgProfileImageView);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_create_account);

        return binding.getRoot();
    }

    private DialogFragment waitDialog = new WaitDialogFragment();

    @Override
    public void onStarted() {
        waitDialog.show(getFragmentManager(), "WaitDialogFragment");
    }

    @Override
    public void onSuccess() {
        binding.formToSignupLinearLayout.setVisibility(View.GONE);

        StorageUtil.downloadProfileForMsg(getActivity(), binding.accountCreatedMsgLayout.msgProfileImageView);
        binding.accountCreatedMsgLayout.msgTitleTextView.setText(R.string.accont_created_successfuly);
        binding.accountCreatedMsgLayout.msgTextView.setText(R.string.email_verification_sent);
        binding.accountCreatedMsgLayout.msgConstraintLayout.setVisibility(View.VISIBLE);

        waitDialog.dismiss();
    }

    @Override
    public void onFailure(int resId) {
        waitDialog.dismiss();
        Toasty.error(getActivity(), resId, Toasty.LENGTH_LONG).show();
    }

    @Override
    public int getDescription() {
        return R.string.create_an_account;
    }
}
