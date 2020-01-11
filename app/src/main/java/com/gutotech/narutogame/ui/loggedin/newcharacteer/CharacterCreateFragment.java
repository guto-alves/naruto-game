package com.gutotech.narutogame.ui.loggedin.newcharacteer;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.ui.adapter.CharactersRecyclerViewAdapter;
import com.gutotech.narutogame.data.model.Atributos;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Vilas;

import java.util.ArrayList;
import java.util.List;

public class CharacterCreateFragment extends Fragment {
    private Character character;
    private Atributos atributos;

    private TextView vilaSelecionadaTextView;
    private String vilaSelecionada;
    private int numVila;

    private String classeSelecionada;

    private ImageView profileImageView;
    private TextView nomePersonagemSelecionadoTextView;

    private RecyclerView profilesRecyclerView;
    private CharactersRecyclerViewAdapter adapter;
    private List<Integer> pequenasLista = new ArrayList<>();
    private List<Integer> profilesGrupoAtual = new ArrayList<>();

    private TextView grupoAtualTextView;
    private int grupoAtual = 0;

    private ValueEventListener valueEventListenerNickRepetido;
    private Query nickRepetidoQuery;

    public CharacterCreateFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personagem_criar, container, false);

        character = new Character();
        atributos = new Atributos();
        atributos.setTaijutsu(10);
        atributos.setBukijutsu(1);
        atributos.setNinjutsu(1);
        atributos.setGenjutsu(1);
        atributos.setForca(5);
        atributos.setAgilidade(3);
        atributos.setInteligencia(1);
        atributos.setSelo(3);
        atributos.setResistencia(1);
        atributos.setEnergia(10);
        vilaSelecionada = Vilas.FOLHA.name;
        numVila = 1;
        classeSelecionada = Classe.TAI;
        character.setIdProfile(1);

        vilaSelecionadaTextView = view.findViewById(R.id.vilaSelecionadaTextView);
        RadioGroup vilasRadioGroup = view.findViewById(R.id.vilasRadioGroup);
        vilasRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.folhaRadioButton:
//                        vilaSelecionada = Vilas.FOLHA;
//                        numVila = 1;
//                        vilaSelecionadaTextView.setText(vilaSelecionada);
//                        break;
//                    case R.id.areiaRadioButton:
//                        vilaSelecionada = Vilas.AREIA;
//                        numVila = 2;
//                        vilaSelecionadaTextView.setText(vilaSelecionada);
//                        break;
//                    case R.id.nevoaRadioButton:
//                        vilaSelecionada = Vilas.NEVOA;
//                        numVila = 3;
//                        vilaSelecionadaTextView.setText(vilaSelecionada);
//                        break;
//                    case R.id.pedraRadioButton:
//                        vilaSelecionada = Vilas.PEDRA;
//                        numVila = 4;
//                        vilaSelecionadaTextView.setText(vilaSelecionada);
//                        break;
//                    case R.id.nuvemRadioButton:
//                        vilaSelecionada = Vilas.NUVEM;
//                        numVila = 5;
//                        vilaSelecionadaTextView.setText(vilaSelecionada);
//                        break;
//                    case R.id.akatsukiRadioButton:
//                        vilaSelecionada = Vilas.AKATSUKI;
//                        numVila = 6;
//                        vilaSelecionadaTextView.setText(vilaSelecionada);
//                        break;
//                    case R.id.somRadioButton:
//                        vilaSelecionada = Vilas.SOM;
//                        numVila = 7;
//                        vilaSelecionadaTextView.setText(vilaSelecionada);
//                        break;
//                    case R.id.chuvaRadioButton:
//                        vilaSelecionada = Vilas.CHUVA;
//                        numVila = 8;
//                        vilaSelecionadaTextView.setText(vilaSelecionada);
//                        break;
//                }
            }
        });

        RadioGroup classesRadioGroup = view.findViewById(R.id.classesRadioGroup);
        classesRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.taiRadioButton:
                        classeSelecionada = Classe.TAI;
                        atributos.setTaijutsu(10);
                        atributos.setBukijutsu(1);
                        atributos.setNinjutsu(1);
                        atributos.setGenjutsu(1);
                        atributos.setForca(5);
                        atributos.setAgilidade(3);
                        atributos.setInteligencia(1);
                        atributos.setSelo(3);
                        break;
                    case R.id.ninRadioButton:
                        classeSelecionada = Classe.NIN;
                        atributos.setTaijutsu(1);
                        atributos.setBukijutsu(1);
                        atributos.setNinjutsu(10);
                        atributos.setGenjutsu(1);
                        atributos.setForca(1);
                        atributos.setAgilidade(3);
                        atributos.setInteligencia(5);
                        atributos.setSelo(3);
                        break;
                    case R.id.genRadioButton:
                        classeSelecionada = Classe.GEN;
                        atributos.setTaijutsu(1);
                        atributos.setBukijutsu(1);
                        atributos.setNinjutsu(1);
                        atributos.setGenjutsu(10);
                        atributos.setForca(1);
                        atributos.setAgilidade(3);
                        atributos.setInteligencia(5);
                        atributos.setSelo(3);
                        break;
                    case R.id.bukRadioButton:
                        classeSelecionada = Classe.BUK;
                        atributos.setTaijutsu(1);
                        atributos.setBukijutsu(10);
                        atributos.setNinjutsu(1);
                        atributos.setGenjutsu(1);
                        atributos.setForca(5);
                        atributos.setAgilidade(3);
                        atributos.setInteligencia(1);
                        atributos.setSelo(3);
                        break;
                }
                atributos.setResistencia(1);
                atributos.setEnergia(10);
            }
        });

        nomePersonagemSelecionadoTextView = view.findViewById(R.id.nomePersonagemSelecionadoTextView);
        profileImageView = view.findViewById(R.id.profileCriarImageView);

        profilesRecyclerView = view.findViewById(R.id.profilesRecyclerView);
        grupoAtualTextView = view.findViewById(R.id.grupoAtualTextView);
        configurarGriView();

        ImageButton voltarButton = view.findViewById(R.id.voltarImageButton);
        voltarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (grupoAtual - 1 >= 0)
                    grupoAtual--;
                else
                    grupoAtual = 19;

                carregarGrupoAtual();
            }
        });

        ImageButton avancarButton = view.findViewById(R.id.avancarImageButton);
        avancarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (grupoAtual + 1 < 20)
                    grupoAtual++;
                else
                    grupoAtual = 0;

                carregarGrupoAtual();
            }
        });

        return view;
    }

    private void carregarGrupoAtual() {
        int from = grupoAtual * 6;
        int to = from + 6;

        profilesGrupoAtual.clear();

        profilesGrupoAtual.addAll(pequenasLista.subList(from, to));

        adapter.notifyDataSetChanged();

        grupoAtualTextView.setText(String.valueOf(grupoAtual + 1));
    }

    private void configurarGriView() {
//        adapter = new CharactersRecyclerViewAdapter(getActivity(), );
        carregarGrupoAtual();
        profilesRecyclerView.setAdapter(adapter);
//        profilesRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                StorageUtil.downloadProfile(getActivity(), profileImageView, profilesGrupoAtual.get(position));
//
//                character.setIdProfile(profilesGrupoAtual.get(position));
//                nomePersonagemSelecionadoTextView.setText(Helper.nomeDoPersonagem(character.getIdProfile()));
//            }
//        });
    }

    private void exibirAlerta(String titulo, String mensagem) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle(titulo);
        alert.setMessage(mensagem);
        alert.create();
        alert.show();
    }

    private void changeToFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}
