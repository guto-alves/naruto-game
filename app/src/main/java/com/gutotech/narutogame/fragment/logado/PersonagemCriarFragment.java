package com.gutotech.narutogame.fragment.logado;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.adapter.PequenasAdapter;
import com.gutotech.narutogame.config.ConfigFirebase;
import com.gutotech.narutogame.helper.RecyclerItemClickListener;
import com.gutotech.narutogame.model.Atributos;
import com.gutotech.narutogame.model.Jutsu;
import com.gutotech.narutogame.model.Personagem;
import com.gutotech.narutogame.model.ResumoCombates;
import com.gutotech.narutogame.model.ResumoMissoes;
import com.gutotech.narutogame.publicentities.Helper;
import com.gutotech.narutogame.publicentities.PersonagemOn;

import java.util.ArrayList;
import java.util.List;

public class PersonagemCriarFragment extends Fragment {
    private Personagem personagem;
    private Atributos atributos;

    private EditText nickEditText;

    private TextView vilaEscolhidaTextView;
    private String vilaSelecionada = "Folha";
    private int numVila = 1;

    private String classeSelecionada;

    private ImageView profileImageView;
    private TextView nomePersonagemSelecionadoTextView;

    private RecyclerView personagensRecyclerView;
    private PequenasAdapter adapter;
    private List<Integer> pequenasLista = new ArrayList<>();

    private FirebaseAuth auth;

    public PersonagemCriarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personagem_criar, container, false);

        auth = ConfigFirebase.getAuth();

        personagem = new Personagem();
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
        classeSelecionada = "Taijutsu";
        personagem.setIdProfile(1);

        nickEditText = view.findViewById(R.id.nickCriarEditText);

        vilaEscolhidaTextView = view.findViewById(R.id.vilaEscolhidaTextView);
        RadioGroup vilasRadioGroup = view.findViewById(R.id.vilasRadioGroup);
        vilasRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.folhaRadioButton:
                        vilaSelecionada = "Folha";
                        numVila = 1;
                        vilaEscolhidaTextView.setText(vilaSelecionada);
                        break;
                    case R.id.areiaRadioButton:
                        vilaSelecionada = "Areia";
                        numVila = 2;
                        vilaEscolhidaTextView.setText(vilaSelecionada);
                        break;
                    case R.id.nevoaRadioButton:
                        vilaSelecionada = "Névoa";
                        numVila = 3;
                        vilaEscolhidaTextView.setText(vilaSelecionada);
                        break;
                    case R.id.pedraRadioButton:
                        vilaSelecionada = "Pedra";
                        numVila = 4;
                        vilaEscolhidaTextView.setText(vilaSelecionada);
                        break;
                    case R.id.nuvemRadioButton:
                        vilaSelecionada = "Nuvem";
                        numVila = 5;
                        vilaEscolhidaTextView.setText(vilaSelecionada);
                        break;
                    case R.id.akatsukiRadioButton:
                        vilaSelecionada = "Akatsuki";
                        numVila = 6;
                        vilaEscolhidaTextView.setText(vilaSelecionada);
                        break;
                    case R.id.somRadioButton:
                        vilaSelecionada = "Som";
                        numVila = 7;
                        vilaEscolhidaTextView.setText(vilaSelecionada);
                        break;
                    case R.id.chuvaRadioButton:
                        vilaSelecionada = "Chuva";
                        numVila = 8;
                        vilaEscolhidaTextView.setText(vilaSelecionada);
                        break;
                }
            }
        });

        RadioGroup classesRadioGroup = view.findViewById(R.id.classesRadioGroup);
        classesRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.taiRadioButton:
                        classeSelecionada = "Taijutsu";
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
                        classeSelecionada = "Ninjutsu";
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
                        classeSelecionada = "Genjutsu";
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
                        classeSelecionada = "Bukijutsu";
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

        personagensRecyclerView = view.findViewById(R.id.personagensCriarRecyclerView);
        configurarRecycler();

        Button criarPersonagemButton = view.findViewById(R.id.criarPersonagemButton);
        criarPersonagemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nick = nickEditText.getText().toString();

                if (validarNick(nick)) {
                    salvarPersonagem(nick);
                    changeToFragment(new PersonagemSelecionarFragment());
                }
            }
        });

        return view;
    }

    private void configurarRecycler() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        personagensRecyclerView.setLayoutManager(layoutManager);
        personagensRecyclerView.setHasFixedSize(true);
        adapter = new PequenasAdapter(getActivity(), pequenasLista);
        personagensRecyclerView.setAdapter(adapter);
        personagensRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getActivity(), personagensRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                StorageReference imagemRef = ConfigFirebase.getStorage()
                        .child("images")
                        .child("profile")
                        .child(String.valueOf(pequenasLista.get(position)))
                        .child("1.png");

                Glide.with(getActivity())
                        .using(new FirebaseImageLoader())
                        .load(imagemRef)
                        .into(profileImageView);

                personagem.setIdProfile(pequenasLista.get(position));

                nomePersonagemSelecionadoTextView.setText(Helper.nomeDoPersonagem(personagem.getIdProfile()));
            }

            @Override
            public void onLongItemClick(View view, int position) {
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        }
        ));
    }

    private void salvarPersonagem(String nick) {
        personagem.setIdPlayer(auth.getCurrentUser().getUid());
        personagem.setNick(nick);
        personagem.setLevel(1);
        personagem.setGraducao("Estudante");
        personagem.setRyous(500);
        personagem.setVila(vilaSelecionada);
        personagem.setNumVila(numVila);
        personagem.setClasse(classeSelecionada);
        personagem.setAtributos(atributos);
        personagem.setFotoAtual(1);
        personagem.setExpUpar(1200);
        personagem.setPontos(1000);
        personagem.setResumoCombates(new ResumoCombates());
        personagem.setResumoMissoes(new ResumoMissoes());
        personagem.setMapa_posicao(-1);

        PersonagemOn.personagem = personagem;
        personagem.atualizarAtributos();
        personagem.getAtributos().getFormulas().setVidaAtual(personagem.getAtributos().getFormulas().getVida());
        personagem.getAtributos().getFormulas().setChakraAtual(personagem.getAtributos().getFormulas().getChakra());
        personagem.getAtributos().getFormulas().setStaminaAtual(personagem.getAtributos().getFormulas().getStamina());

        List<Jutsu> jutsus = new ArrayList<>();
        if (personagem.getClasse().equals("Ninjutsu") || personagem.getClasse().equals("Genjutsu")) {
            jutsus.add(new Jutsu(0, "defesa_2_mao", 1, 0, 0, 5, 0, 3, 10, 3, "def", "basico"));
            jutsus.add(new Jutsu(1, "defesa_acrobatica", 1, 0, 0, 5, 0, 3, 15, 4, "def", "basico"));
            jutsus.add(new Jutsu(2, "soco", 1, 0, 5, 0, 0, 3, 8, 1, "atk", "basico"));
            jutsus.add(new Jutsu(3, "chute", 1, 0, 8, 0, 0, 3, 11, 2, "atk", "basico"));
        } else {
            jutsus.add(new Jutsu(0, "defesa_2_mao", 1, 0, 0, 5, 0, 3, 3, 10, "def", "basico"));
            jutsus.add(new Jutsu(1, "defesa_acrobatica", 1, 0, 0, 5, 0, 3, 4, 15, "def", "basico"));
            jutsus.add(new Jutsu(2, "soco", 1, 5, 0, 0, 0, 3, 1, 8, "atk", "basico"));
            jutsus.add(new Jutsu(3, "chute", 1, 8, 0, 0, 0, 3, 2, 11, "atk", "basico"));
        }
        personagem.setJutsus(jutsus);
        personagem.salvar();

        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle("NINJA CRIADO COM SUCESSO");
        alert.setMessage("Parabéns você acaba de criar seu personagem no Naruto Game.\n" +
                "Selecione seu personagem e comece agora mesmo seu treinamento");
        alert.create();
        alert.show();
    }


    private boolean validarNick(String nick) {
        if (nick.isEmpty()) {
            nickEditText.setError("Campo obrigatório");
            return false;
        }

        String message = "";

        if (nick.length() > 18)
            message = "O nome do seu personagem não pode ter mais de 18 caractéres\n";

        String nickSemPontuacao = nick.replaceAll("(?!_)\\p{P}", "");

        if (!nickSemPontuacao.equals(nick))
            message += "O nome do seu personagem só pode conter letras, números e underlines";

        if (message.isEmpty())
            return true;
        else {
            AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
            alert.setTitle("Aviso!");
            alert.setMessage("Os seguintes problemas evitaram que a operação fosse completada:\n\n" + message);
            alert.create();
            alert.show();
            return false;
        }
    }

    private void changeToFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment);
        transaction.commit();
    }

    private void recuperarImagensPequenas() {
        pequenasLista.clear();

        for (int i = 1; i < 265; i++) {
            if (Helper.isValidIdProfile(i))
                pequenasLista.add(i);
        }

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onStart() {
        super.onStart();
        recuperarImagensPequenas();
    }
}
