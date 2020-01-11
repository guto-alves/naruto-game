package com.gutotech.narutogame.ui.loggedin.accountinfo;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentUsuarioDadosBinding;
import com.gutotech.narutogame.util.StorageUtil;

public class UserDataFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentUsuarioDadosBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_usuario_dados, container, false);
        View root = binding.getRoot();

        UserDataViewModel mViewModel = ViewModelProviders.of(this).get(UserDataViewModel.class);
        binding.setViewModel(mViewModel);

        SimpleMaskFormatter maskFormatter = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher textWatcher = new MaskTextWatcher(binding.dateOfBirthEditText, maskFormatter);
        binding.dateOfBirthEditText.addTextChangedListener(textWatcher);

        StorageUtil.downloadProfileForMsg(getActivity(), binding.personagemMsg);

        binding.sexoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                sexo = (String) sexoSpinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return root;
    }
}
