package com.gutotech.narutogame.ui.loggedin.newcharacteer;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentPersonagemCriarBinding;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.ChooseNinjaRecyclerViewAdapter;
import com.gutotech.narutogame.ui.loggedin.selectcharacter.CharacterSelectFragment;
import com.gutotech.narutogame.utils.FragmentUtil;

public class CharacterCreateFragment extends Fragment implements SectionFragment, ResultListener {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CharacterCreateViewModel viewModel = ViewModelProviders.of(getActivity())
                .get(CharacterCreateViewModel.class);
        viewModel.setListener(this);

        FragmentPersonagemCriarBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_personagem_criar, container, false);

        binding.setViewModel(viewModel);

        ChooseNinjaRecyclerViewAdapter ninjasAdapter = new ChooseNinjaRecyclerViewAdapter(viewModel);
        binding.ninjasRecyclerView.setAdapter(ninjasAdapter);

        viewModel.getCurrentNinjasGroupList().observe(this, ninjasAdapter::setNinjasId);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_create_character);

        return binding.getRoot();
    }

    private void showAlert(String title, String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle(title);
        alert.setMessage(message);
        alert.create();
        alert.show();
    }

    @Override
    public int getDescription() {
        return R.string.create_character;
    }

    @Override
    public void onStarted() {
    }

    @Override
    public void onSuccess() {
        showAlert("NINJA CRIADO COM SUCESSO", "Parabéns você acaba de criar seu character no Naruto Game.\n" +
                "Selecione seu character e comece agora mesmo seu treinamento");
        FragmentUtil.goTo(getActivity(), new CharacterSelectFragment());
    }

    @Override
    public void onFailure(int resId) {
        showAlert(getString(R.string.warning), getString(resId));
    }
}
