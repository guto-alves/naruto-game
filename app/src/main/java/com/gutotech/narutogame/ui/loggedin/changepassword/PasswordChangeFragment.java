package com.gutotech.narutogame.ui.loggedin.changepassword;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentPasswordChangeBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.StorageUtil;

public class PasswordChangeFragment extends Fragment implements SectionFragment, ResultListener {
    private FragmentPasswordChangeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        PasswordChangeViewModel viewModel = ViewModelProviders.of(this)
                .get(PasswordChangeViewModel.class);

        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_password_change, container, false);
        binding.setViewModel(viewModel);

        viewModel.setListener(this);

        binding.msgLayout.msgTitleTextView.setText(R.string.be_advised);
        binding.msgLayout.msgTextView.setText(R.string.be_advised_description);
        StorageUtil.downloadProfileForMsg(getActivity(), binding.msgLayout.msgProfileImageView);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_change_password);

        return binding.getRoot();
    }

    private void showAlert(@StringRes int resId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Naruto Game says:");
        builder.setMessage(resId);
        builder.setPositiveButton("OK", null);
        builder.setCancelable(false);
        builder.create().show();
    }

    @Override
    public void onStarted() {

    }

    @Override
    public void onSuccess() {
        binding.passwordChangedMsgLayout.msgTitleTextView.setText(R.string.congratulations);
        binding.passwordChangedMsgLayout.msgTextView.setText(R.string.password_changed);
        StorageUtil.downloadProfileForMsg(getActivity(), binding.passwordChangedMsgLayout.msgProfileImageView);
        binding.passwordChangedMsgLayout.msgConstraintLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFailure(int resId) {
        showAlert(resId);
    }

    @Override
    public int getDescription() {
        return R.string.change_password;
    }
}
