package com.gutotech.narutogame.ui.loggedin.changepassword;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.StorageUtils;
import com.gutotech.narutogame.databinding.FragmentPasswordChangeBinding;
import com.gutotech.narutogame.ui.ProgressDialogFragment;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SoundUtil;

public class PasswordChangeFragment extends Fragment implements SectionFragment, ResultListener {
    private FragmentPasswordChangeBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        PasswordChangeViewModel viewModel = new ViewModelProvider(this)
                .get(PasswordChangeViewModel.class);
        viewModel.setListener(this);

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_password_change,
                container, false);
        mBinding.setViewModel(viewModel);

        StorageUtils.loadProfileForMsg(getActivity(), mBinding.msgLayout.profileImageView);
        mBinding.msgLayout.titleTextView.setText(R.string.be_advised);
        mBinding.msgLayout.descriptionTextView.setText(R.string.be_advised_description);

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_change_password);

        return mBinding.getRoot();
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
        StorageUtils.loadProfileForMsg(getActivity(), mBinding.passwordChangedMsgLayout.profileImageView);
        mBinding.passwordChangedMsgLayout.titleTextView.setText(R.string.congratulations);
        mBinding.passwordChangedMsgLayout.descriptionTextView.setText(R.string.password_changed);
        mBinding.passwordChangedMsgLayout.msgConstraintLayout.setVisibility(View.VISIBLE);
        progressDialog.dismiss();
    }

    @Override
    public void onFailure(int resId) {
        progressDialog.dismiss();
        showAlert(resId);
        SoundUtil.play(getContext(), R.raw.attention2);
    }

    @Override
    public int getDescription() {
        return R.string.change_password;
    }
}
