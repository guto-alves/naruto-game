package com.gutotech.narutogame.ui.loggedin.selectcharacter;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.databinding.FragmentPersonagemSelecionarBinding;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.CharacterSelectRecyclerViewAdapter;
import com.gutotech.narutogame.ui.loggedin.newcharacteer.CharacterCreateFragment;
import com.gutotech.narutogame.ui.playing.PlayingActivity;
import com.gutotech.narutogame.utils.FragmentUtil;

public class CharacterSelectFragment extends Fragment implements SectionFragment, ResultListener,
        CharacterSelectRecyclerViewAdapter.CharacterSelecetedListener {
    private CharacterSelectViewModel mViewModel;

    private FragmentPersonagemSelecionarBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_personagem_selecionar,
                container, false);

        mViewModel = new ViewModelProvider(this).get(CharacterSelectViewModel.class);
        mViewModel.setListener(this);

        mBinding.setViewModel(mViewModel);

        CharacterSelectRecyclerViewAdapter charactersAdapter = new CharacterSelectRecyclerViewAdapter(this);
        mBinding.charactersRecyclerView.setHasFixedSize(true);
        mBinding.charactersRecyclerView.setAdapter(charactersAdapter);

        mViewModel.getCharactersList().observe(getViewLifecycleOwner(), characters -> {
            if (characters.size() == 0) {
                FragmentUtil.goTo(getActivity(), new CharacterCreateFragment());
            } else {
                charactersAdapter.setCharactersList(characters);
                onCharacterSelected(characters.get(0));
            }
        });

        mViewModel.getRemoveCharacterEvent().observe(getViewLifecycleOwner(), onClickListener -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle(R.string.naruto_game_says);
            builder.setMessage(R.string.want_to_delete_this_ninja);
            builder.setNegativeButton(R.string.button_cancel, null);
            builder.setPositiveButton("OK", onClickListener);
            builder.create();
            builder.show();
        });

        mViewModel.getShowRemovingErrorDialog().observe(getViewLifecycleOwner(), aVoid -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
            builder1.setTitle(R.string.warning);
            builder1.setMessage(R.string.remove_character_while_logged_in);
            builder1.setPositiveButton(R.string.close, null);
            builder1.create().show();
        });

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_select_your_character);

        return mBinding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.select_character;
    }

    @Override
    public void onStarted() {
    }

    @Override
    public void onSuccess() {
        startActivity(new Intent(getActivity(), PlayingActivity.class));
        getActivity().finish();
    }

    @Override
    public void onFailure(int resId) {
        Toast.makeText(getContext(), resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCharacterSelected(Character character) {
        mBinding.setCharacterSelected(character);
        mViewModel.setCharacterSelected(character);
    }
}
