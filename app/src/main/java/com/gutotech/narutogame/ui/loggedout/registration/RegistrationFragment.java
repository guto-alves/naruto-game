package com.gutotech.narutogame.ui.loggedout.registration;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentRegistrationBinding;
import com.gutotech.narutogame.ui.loggedout.home.HomeFragment;
import com.gutotech.narutogame.util.FragmentUtil;
import com.gutotech.narutogame.util.StorageUtil;

import es.dmoral.toasty.Toasty;

public class RegistrationFragment extends Fragment implements RegistrationListener {
    private RegistrationViewModel mRegistrationViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRegistrationViewModel = ViewModelProviders.of(this).get(RegistrationViewModel.class);

        FragmentRegistrationBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_registration, container, false);

        binding.setViewModel(mRegistrationViewModel);

        mRegistrationViewModel.setRegistrationListener(this);

        binding.msgConstraintLayout.msgTitleTextView.setText(R.string.just_a_bit_now);
        binding.msgConstraintLayout.msgTextView.setText(R.string.fullfill_the_form_below);
        StorageUtil.downloadProfileForMsg(getActivity(), binding.msgConstraintLayout.msgProfileImageView);

        binding.sexesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mRegistrationViewModel.getPlayer().setSex((String) binding.sexesSpinner.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_create_account);

        return binding.getRoot();
    }

    @Override
    public void onSuccess(int resId) {
        Toasty.success(getActivity(), resId, Toasty.LENGTH_LONG).show();
        FragmentUtil.changeToFragment(getActivity(), new HomeFragment());
    }

    @Override
    public void onFailure(int resId) {
        Toasty.error(getActivity(), resId, Toasty.LENGTH_LONG).show();
    }

}
