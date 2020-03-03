package com.gutotech.narutogame.ui.loggedin.newcharacteer;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentPersonagemCriarBinding;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.ChooseNinjaAdapter;
import com.gutotech.narutogame.ui.loggedin.selectcharacter.CharacterSelectFragment;
import com.gutotech.narutogame.utils.FragmentUtil;

public class CharacterCreateFragment extends Fragment implements SectionFragment, ResultListener {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CharacterCreateViewModel viewModel = new ViewModelProvider(this)
                .get(CharacterCreateViewModel.class);
        viewModel.setListener(this);

        FragmentPersonagemCriarBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_personagem_criar, container, false);

        binding.setViewModel(viewModel);

        ChooseNinjaAdapter ninjasAdapter = new ChooseNinjaAdapter(viewModel);
        binding.ninjasRecyclerView.setAdapter(ninjasAdapter);

        viewModel.getCurrentNinjasGroupList().observe(getViewLifecycleOwner(),
                ninjasAdapter::setNinjasId);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_create_character);

        return binding.getRoot();
    }

    private void showAlert(@StringRes int titleId, @StringRes int messageId) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle(titleId);
        alert.setMessage(messageId);
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
        showAlert(R.string.ninja_successfully_created, R.string.congratulations_character_created);
        FragmentUtil.goTo(getActivity(), new CharacterSelectFragment());
    }

    @Override
    public void onFailure(int resId) {
        showAlert(R.string.warning, resId);
    }
}
