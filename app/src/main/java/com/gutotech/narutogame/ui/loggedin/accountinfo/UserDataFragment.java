package com.gutotech.narutogame.ui.loggedin.accountinfo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.repository.PlayerRepository;
import com.gutotech.narutogame.databinding.FragmentUsuarioDadosBinding;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.StorageUtil;

import es.dmoral.toasty.Toasty;

public class UserDataFragment extends Fragment implements SectionFragment, ResultListener {
    private FragmentUsuarioDadosBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        PlayerRepository.getInstance().getCurrentPlayer(player -> {
            UserDataViewModelFactory viewModelFactory = new UserDataViewModelFactory(player);

            UserDataViewModel viewModel = ViewModelProviders.of(this, viewModelFactory)
                    .get(UserDataViewModel.class);
            viewModel.setResultListener(this);

            mBinding.setViewModel(viewModel);
        });

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_usuario_dados,
                container, false);

        mBinding.msgLayout.titleTextView.setText(R.string.keep_your_info_updated);
        mBinding.msgLayout.descriptionTextView.setText(R.string.user_info_updated_description);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_account_info);

        return mBinding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.my_Info;
    }

    @Override
    public void onStarted() {
    }

    @Override
    public void onSuccess() {
        StorageUtil.downloadProfileForMsg(getActivity(), mBinding.updatedAccountMsgLayout.profileImageView);
        mBinding.updatedAccountMsgLayout.titleTextView.setText(R.string.user_info_updated);
        mBinding.updatedAccountMsgLayout.descriptionTextView.setText(R.string.user_info_updated_description);
        mBinding.updatedAccountMsgLayout.msgConstraintLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFailure(int resId) {
        Toasty.warning(getContext(), resId, Toasty.LENGTH_SHORT).show();
    }
}
