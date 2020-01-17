package com.gutotech.narutogame.ui.loggedin.selectcharacter;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.PersonagemOn;
import com.gutotech.narutogame.databinding.FragmentPersonagemSelecionarBinding;
import com.gutotech.narutogame.ui.ResultListener;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.CharacterSelectRecyclerViewAdapter;
import com.gutotech.narutogame.ui.loggedin.newcharacteer.CharacterCreateFragment;
import com.gutotech.narutogame.ui.playing.PersonagemLogadoActivity;
import com.gutotech.narutogame.utils.FragmentUtil;

public class CharacterSelectFragment extends Fragment implements SectionFragment, ResultListener, CharacterSelectRecyclerViewAdapter.CharacterSelecetedListener {
    private CharacterSelectViewModel viewModel;

    private FragmentPersonagemSelecionarBinding binding;

    private CharacterSelectRecyclerViewAdapter charactersAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(getActivity()).get(CharacterSelectViewModel.class);
        viewModel.setListener(this);

        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_personagem_selecionar, container, false);

        binding.setViewModel(viewModel);

        viewModel.getCharactersList().observe(this, characters -> {
            if (characters.size() == 0) {
                FragmentUtil.goTo(getActivity(), new CharacterCreateFragment());
            } else {
                charactersAdapter.setCharactersList(characters);
                onCharacterSelected(characters.get(0));
            }
        });

        charactersAdapter = new CharacterSelectRecyclerViewAdapter(this);
        binding.charactersRecyclerView.setAdapter(charactersAdapter);

        viewModel.getEvent().observe(this, s -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Naruto Game diz:");
            builder.setMessage("Você quer realmente deletar esse ninja?");
            builder.setNegativeButton("Cancelar", null);
            builder.setPositiveButton("OK", (dialog, which) -> {
                if (PersonagemOn.character == null) {
//                    mRepository.deleteCharacter(mCharacterSelected.getValue().getNick());
                } else {
//                    if (mCharacterSelected.getValue().getNick().equals(PersonagemOn.character.getNick())) {
//                        AlertDialog.Builder builder1 = new AlertDialog.Builder(getApplication());
//                        builder1.setTitle("Aviso!");
//                        builder1.setMessage("Você não pode remover esse character estando logado nele!");
//                        builder1.setPositiveButton("Fechar", null);
//                        builder1.create().show();
//                    } else {
//                        mRepository.deleteCharacter(mCharacterSelected.getValue().getNick());
//                    }
                }
            });
            builder.create();
            builder.show();
        });

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_select_your_character);

        return binding.getRoot();
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
        getActivity().startActivity(new Intent(getActivity(), PersonagemLogadoActivity.class));
        getActivity().finish();
    }

    @Override
    public void onFailure(int resId) {
        Toast.makeText(getContext(), resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCharacterSelected(Character character) {
        viewModel.setCharacterSelected(character);
        binding.setCharacterSelected(character);
    }
}
