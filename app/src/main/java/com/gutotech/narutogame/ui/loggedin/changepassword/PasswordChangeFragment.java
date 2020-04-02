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
import com.gutotech.narutogame.ui.ProgressDialogFragment;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.data.firebase.StorageUtils;

public class PasswordChangeFragment extends Fragment implements SectionFragment, ResultListener {
    private FragmentPasswordChangeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        PasswordChangeViewModel viewModel = ViewModelProviders.of(this)
                .get(PasswordChangeViewModel.class);
        viewModel.setListener(this);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_password_change,
                container, false);
        binding.setViewModel(viewModel);

        StorageUtils.downloadProfileForMsg(getActivity(), binding.msgLayout.profileImageView);
        binding.msgLayout.titleTextView.setText(R.string.be_advised);
        binding.msgLayout.descriptionTextView.setText(R.string.be_advised_description);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_change_password);

        return binding.getRoot();
    }

    private void showAlert(@StringRes int resId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.naruto_game_says);
        builder.setMessage(resId);
        builder.setPositiveButton("OK", null);
        builder.setCancelable(false);
        builder.create().show();
    }

    private ProgressDialogFragment progressDialog = new ProgressDialogFragment();

    @Override
    public void onStarted() {
        progressDialog.show(getFragmentManager(), "ProgressDialog");
    }

    @Override
    public void onSuccess() {
        StorageUtils.downloadProfileForMsg(getActivity(), binding.passwordChangedMsgLayout.profileImageView);
        binding.passwordChangedMsgLayout.titleTextView.setText(R.string.congratulations);
        binding.passwordChangedMsgLayout.descriptionTextView.setText(R.string.password_changed);
        binding.passwordChangedMsgLayout.msgConstraintLayout.setVisibility(View.VISIBLE);
        progressDialog.dismiss();
    }

    @Override
    public void onFailure(int resId) {
        progressDialog.dismiss();
        showAlert(resId);
    }

    @Override
    public int getDescription() {
        return R.string.change_password;
    }
}
