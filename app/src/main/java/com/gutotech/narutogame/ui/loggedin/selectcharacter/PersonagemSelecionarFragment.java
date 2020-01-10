package com.gutotech.narutogame.ui.loggedin.selectcharacter;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentPersonagemSelecionarBinding;
import com.gutotech.narutogame.ui.adapter.CharactersRecyclerViewAdapter;

public class PersonagemSelecionarFragment extends Fragment {
    private CharactersRecyclerViewAdapter charactersAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentPersonagemSelecionarBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_personagem_selecionar, container, false);
        View root = binding.getRoot();

        PersonagemSelecionarViewModel mViewModel = ViewModelProviders.of(this).get(PersonagemSelecionarViewModel.class);
        binding.setViewModel(mViewModel);

        mViewModel.getCharactersList().observe(this, characters -> {
            charactersAdapter.setCharactersList(characters);
        });

        RecyclerView charactersRecyclerView = root.findViewById(R.id.charactersRecyclerView);
        charactersAdapter = new CharactersRecyclerViewAdapter(getActivity(), mViewModel);
        charactersRecyclerView.setAdapter(charactersAdapter);

        return root;
    }

    private void changeTo(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment);
        transaction.commit();
    }
}
