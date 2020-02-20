package com.gutotech.narutogame.ui.home.signup;

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
import com.gutotech.narutogame.ui.ProgressDialog;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.StorageUtil;

import es.dmoral.toasty.Toasty;

public class SignupFragment extends Fragment implements ResultListener, SectionFragment {
    private FragmentSignupBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SignupViewModel viewModel = ViewModelProviders.of(this).get(SignupViewModel.class);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup,
                container, false);
        binding.setViewModel(viewModel);
        viewModel.setAuthListener(this);

        binding.msgLayout.titleTextView.setText(R.string.just_a_bit_now);
        binding.msgLayout.descriptionTextView.setText(R.string.fullfill_the_form_below);
        StorageUtil.downloadProfileForMsg(getActivity(), binding.msgLayout.profileImageView);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_create_account);

        return binding.getRoot();
    }

    private ProgressDialog progressDialog = new ProgressDialog();

    @Override
    public void onStarted() {
        progressDialog.show(getFragmentManager(), "ProgressDialog");
    }

    @Override
    public void onSuccess() {
        binding.formToSignupLinearLayout.setVisibility(View.GONE);

        StorageUtil.downloadProfileForMsg(getActivity(), binding.accountCreatedMsgLayout.profileImageView);
        binding.accountCreatedMsgLayout.titleTextView.setText(R.string.accont_created_successfuly);
        binding.accountCreatedMsgLayout.descriptionTextView.setText(R.string.email_verification_sent);
        binding.accountCreatedMsgLayout.msgConstraintLayout.setVisibility(View.VISIBLE);

        progressDialog.dismiss();
    }

    @Override
    public void onFailure(int resId) {
        progressDialog.dismiss();
        Toasty.error(getContext(), resId, Toasty.LENGTH_LONG).show();
    }

    @Override
    public int getDescription() {
        return R.string.create_an_account;
    }
}
