package com.gutotech.narutogame.fragment.logado;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.adapter.ProfilesPequenasAdapter;
import com.gutotech.narutogame.config.ConfigFirebase;
import com.gutotech.narutogame.config.Storage;
import com.gutotech.narutogame.model.Atributo;
import com.gutotech.narutogame.model.Atributos;
import com.gutotech.narutogame.model.Classe;
import com.gutotech.narutogame.model.Jutsu;
import com.gutotech.narutogame.model.Personagem;
import com.gutotech.narutogame.model.ResumoCombates;
import com.gutotech.narutogame.model.ResumoMissoes;
import com.gutotech.narutogame.helper.Helper;
import com.gutotech.narutogame.model.PersonagemOn;
import com.gutotech.narutogame.model.Vilas;

import java.util.ArrayList;
import java.util.List;

public class PersonagemCriarFragment extends Fragment {
    private Personagem personagem;
    private Atributos atributos;

    private EditText nickEditText;

    private TextView vilaSelecionadaTextView;
    private String vilaSelecionada;
    private int numVila;

    private String classeSelecionada;

    private ImageView profileImageView;
    private TextView nomePersonagemSelecionadoTextView;

    private GridView profilesPequenasGridView;
    private ProfilesPequenasAdapter adapter;
    private List<Integer> pequenasLista = new ArrayList<>();
    private List<Integer> profilesGrupoAtual = new ArrayList<>();

    private TextView grupoAtualTextView;
    private int grupoAtual = 0;

    private ValueEventListener valueEventListenerNickRepetido;
    private Query nickRepetidoQuery;

    public PersonagemCriarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personagem_criar, container, false);

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
        vilaSelecionada = Vilas.FOLHA;
        numVila = 1;
        classeSelecionada = Classe.TAI;
        personagem.setIdProfile(1);

        nickEditText = view.findViewById(R.id.nickCriarEditText);

        vilaSelecionadaTextView = view.findViewById(R.id.vilaSelecionadaTextView);
        RadioGroup vilasRadioGroup = view.findViewById(R.id.vilasRadioGroup);
        vilasRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.folhaRadioButton:
                        vilaSelecionada = Vilas.FOLHA;
                        numVila = 1;
                        vilaSelecionadaTextView.setText(vilaSelecionada);
                        break;
                    case R.id.areiaRadioButton:
                        vilaSelecionada = Vilas.AREIA;
                        numVila = 2;
                        vilaSelecionadaTextView.setText(vilaSelecionada);
                        break;
                    case R.id.nevoaRadioButton:
                        vilaSelecionada = Vilas.NEVOA;
                        numVila = 3;
                        vilaSelecionadaTextView.setText(vilaSelecionada);
                        break;
                    case R.id.pedraRadioButton:
                        vilaSelecionada = Vilas.PEDRA;
                        numVila = 4;
                        vilaSelecionadaTextView.setText(vilaSelecionada);
                        break;
                    case R.id.nuvemRadioButton:
                        vilaSelecionada = Vilas.NUVEM;
                        numVila = 5;
                        vilaSelecionadaTextView.setText(vilaSelecionada);
                        break;
                    case R.id.akatsukiRadioButton:
                        vilaSelecionada = Vilas.AKATSUKI;
                        numVila = 6;
                        vilaSelecionadaTextView.setText(vilaSelecionada);
                        break;
                    case R.id.somRadioButton:
                        vilaSelecionada = Vilas.SOM;
                        numVila = 7;
                        vilaSelecionadaTextView.setText(vilaSelecionada);
                        break;
                    case R.id.chuvaRadioButton:
                        vilaSelecionada = Vilas.CHUVA;
                        numVila = 8;
                        vilaSelecionadaTextView.setText(vilaSelecionada);
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

        profilesPequenasGridView = view.findViewById(R.id.profilesPequenasGridView);
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

        Button criarPersonagemButton = view.findViewById(R.id.criarPersonagemButton);
        criarPersonagemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nick = nickEditText.getText().toString();

                if (validarNick(nick))
                    verificarNickRepetido(nick);
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
        recuperarImagensPequenas();
        adapter = new ProfilesPequenasAdapter(getActivity(), profilesGrupoAtual);
        carregarGrupoAtual();
        profilesPequenasGridView.setAdapter(adapter);
        profilesPequenasGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Storage.baixarProfile(getActivity(), profileImageView, profilesGrupoAtual.get(position));

                personagem.setIdProfile(profilesGrupoAtual.get(position));
                nomePersonagemSelecionadoTextView.setText(Helper.nomeDoPersonagem(personagem.getIdProfile()));
            }
        });
    }

    private void recuperarImagensPequenas() {
        for (int i = 1; i <= 265; i++) {
            if (Helper.nomeDoPersonagem(i) != null)
                pequenasLista.add(i);
        }
    }

    private void verificarNickRepetido(final String nick) {
        DatabaseReference personagensRef = ConfigFirebase.getDatabase().child("personagem");

        nickRepetidoQuery = personagensRef.orderByKey().equalTo(nick);

        valueEventListenerNickRepetido = nickRepetidoQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Personagem personagemResult = dataSnapshot.getValue(Personagem.class);

                nickRepetidoQuery.removeEventListener(valueEventListenerNickRepetido);

                if (personagemResult == null) {
                    salvarPersonagem(nick);
                    changeToFragment(new PersonagemSelecionarFragment());
                } else
                    exibirAlerta("Aviso!", "Os seguintes problemas evitaram que a operação fosse completada:\n" +
                            "\nJá existe um personagem com o nome escolhido");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void salvarPersonagem(String nick) {
        personagem.setIdPlayer(ConfigFirebase.getAuth().getCurrentUser().getUid());
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
        personagem.setDiasLogadosFidelidade(1);
        personagem.setTemRecompensaFidelidade(true);

        List<Atributo> atributosDistribuidos = new ArrayList<>();
        atributosDistribuidos.add(new Atributo(Atributo.TAI, R.drawable.layout_icones_ene, 0));
        atributosDistribuidos.add(new Atributo(Atributo.BUK, R.drawable.layout_icones_ken, 0));
        atributosDistribuidos.add(new Atributo(Atributo.NIN, R.drawable.layout_icones_nin, 0));
        atributosDistribuidos.add(new Atributo(Atributo.GEN, R.drawable.layout_icones_gen, 0));
        atributosDistribuidos.add(new Atributo(Atributo.SELO, R.drawable.layout_icones_conhe, 0));
        atributosDistribuidos.add(new Atributo(Atributo.AGI, R.drawable.layout_icones_agi, 0));
        atributosDistribuidos.add(new Atributo(Atributo.FOR, R.drawable.layout_icones_forc, 0));
        atributosDistribuidos.add(new Atributo(Atributo.INTE, R.drawable.layout_icones_inte, 0));
        atributosDistribuidos.add(new Atributo(Atributo.ENER, R.drawable.layout_icones_ene, 0));
        atributosDistribuidos.add(new Atributo(Atributo.RES, R.drawable.layout_icones_defense, 0));
        personagem.setAtributosDistribuitos(atributosDistribuidos);

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

        personagem.setOn(false);
        personagem.salvar();

        exibirAlerta("NINJA CRIADO COM SUCESSO", "Parabéns você acaba de criar seu personagem no Naruto Game.\n" +
                "Selecione seu personagem e comece agora mesmo seu treinamento");
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
            exibirAlerta("Aviso!", "Os seguintes problemas evitaram que a operação fosse completada:\n\n" + message);
            return false;
        }
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
        transaction.replace(R.id.conteiner, fragment);
        transaction.commit();
    }
}
