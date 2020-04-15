package com.gutotech.narutogame.ui.home.signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentSignupBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.ProgressDialogFragment;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.data.firebase.StorageUtils;

import es.dmoral.toasty.Toasty;

public class SignupFragment extends Fragment implements ResultListener, SectionFragment {
    private FragmentSignupBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SignupViewModel viewModel = new ViewModelProvider(this).get(SignupViewModel.class);

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup,
                container, false);
        mBinding.setViewModel(viewModel);
        viewModel.setAuthListener(this);

        mBinding.msgLayout.titleTextView.setText(R.string.just_a_bit_now);
        mBinding.msgLayout.descriptionTextView.setText(R.string.fullfill_the_form_below);
        StorageUtils.downloadProfileForMsg(getActivity(), mBinding.msgLayout.profileImageView);

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_create_account);

        return mBinding.getRoot();
    }

    private ProgressDialogFragment mProgressDialog = new ProgressDialogFragment();

    @Override
    public void onStarted() {
        mProgressDialog.show(getParentFragmentManager(), "ProgressDialog");
    }

    @Override
    public void onSuccess() {
        mBinding.formToSignupLinearLayout.setVisibility(View.GONE);

        StorageUtils.downloadProfileForMsg(getActivity(), mBinding.accountCreatedMsgLayout.profileImageView);
        mBinding.accountCreatedMsgLayout.titleTextView.setText(R.string.accont_created_successfuly);
        mBinding.accountCreatedMsgLayout.descriptionTextView.setText(R.string.email_verification_sent);
        mBinding.accountCreatedMsgLayout.msgConstraintLayout.setVisibility(View.VISIBLE);

        mProgressDialog.dismiss();
    }

    @Override
    public void onFailure(int resId) {
        mProgressDialog.dismiss();
        Toasty.error(getContext(), resId, Toasty.LENGTH_LONG).show();
    }

    @Override
    public int getDescription() {
        return R.string.create_an_account;
    }
}
