package com.gutotech.narutogame.ui.loggedin.selectcharacter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.ui.adapter.CharactersRecyclerViewAdapter;

import java.util.List;

public class PersonagemSelecionarViewModel extends ViewModel implements CharactersRecyclerViewAdapter.CharacterSelecetedListener {
    private MutableLiveData<List<Character>> charactersList;
    private Character characterSelected;

    private CharacterRepository mRepository;

    public PersonagemSelecionarViewModel() {
        mRepository = CharacterRepository.getInstance();
    }

    public LiveData<List<Character>> getCharactersList() {
        return charactersList;
    }

    public Character getCharacterSelected() {
        return characterSelected;
    }

    public void setCharacterSelected(Character characterSelected) {
        this.characterSelected = characterSelected;
    }

    public void onPlayButtonPressed() {
//        if (characterSelected != null) {
//            PersonagemOn.character = characterSelecionado;
//            startActivity(new Intent(getActivity(), PersonagemLogadoActivity.class));
//            getActivity().finish();
//        } else
//            Toast.makeText(getActivity(), "Nenhum character selecionado", Toast.LENGTH_SHORT).show();
    }

    public void onRemoveButtonPressed() {
//        if (characterSelected != null) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//            builder.setTitle("Naruto Game diz:");
//            builder.setMessage("Você quer realmente deletar esse ninja?");
//            builder.setNegativeButton("Cancelar", null);
//            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    if (PersonagemOn.character == null)
//                        deletarNinja();
//                    else {
//                        if (characterSelecionado.getNick().equals(PersonagemOn.character.getNick())) {
//                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                            builder.setTitle("Aviso!");
//                            builder.setMessage("Você não pode remover esse character estando logado nele!");
//                            builder.setPositiveButton("Fechar", null);
//                            builder.create().show();
//                        } else
//                            deletarNinja();
//                    }
//                }
//            });
//            builder.create();
//            builder.show();
//        } else
//            Toast.makeText(getActivity(), "Nenhum character selecionado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCharacterSelected(Character characterSelected) {
        this.characterSelected = characterSelected;
    }
}
