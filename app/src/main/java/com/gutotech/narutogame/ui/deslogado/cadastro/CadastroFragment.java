package com.gutotech.narutogame.ui.deslogado.cadastro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.util.StorageUtil;
import com.gutotech.narutogame.databinding.FragmentCadastroBinding;

import es.dmoral.toasty.Toasty;

public class CadastroFragment extends Fragment implements CadastroListener {
    private CadastroViewModel mCadastroViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mCadastroViewModel = ViewModelProviders.of(this).get(CadastroViewModel.class);

        FragmentCadastroBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastro, container, false);
        View root = binding.getRoot();
        binding.setViewmodel(mCadastroViewModel);
        mCadastroViewModel.setCadastroListener(this);

        ImageView personagemMsg = root.findViewById(R.id.personagemMsgImagem);
        StorageUtil.baixarImagemParaMsg(getActivity(), personagemMsg);

        final Spinner sexoSpinner = root.findViewById(R.id.sexosSpinner);
        sexoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mCadastroViewModel.getPlayer().setSexo((String) sexoSpinner.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return root;
    }

    @Override
    public void onSuccess(int resId) {
        Toasty.success(getActivity(), resId, Toasty.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(int resId) {
        Toasty.error(getActivity(), resId, Toasty.LENGTH_LONG).show();
    }

    private void changeToFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment);
        transaction.commit();
    }

}
