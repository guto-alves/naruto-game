package com.gutotech.narutogame.ui.onlinecharacter;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

import androidx.annotation.NonNull;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.adapter.MensagensAdapter;
import com.gutotech.narutogame.ui.adapter.MenuPersonagemLogadoExpandableAdapter;
import com.gutotech.narutogame.ui.adapter.BolsaRamensAdapter;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.ui.loggedout.DeslogadoActivity;
import com.gutotech.narutogame.ui.loggedin.newcharacteer.CharacterCreateFragment;
import com.gutotech.narutogame.util.StorageUtil;
import com.gutotech.narutogame.ui.loggedin.selectcharacter.PersonagemSelecionarFragment;
import com.gutotech.narutogame.ui.loggedin.changepassword.PasswordChangeFragment;
import com.gutotech.narutogame.ui.loggedin.support.SuporteFragment;
import com.gutotech.narutogame.ui.loggedin.accountinfo.UserDataFragment;
import com.gutotech.narutogame.ui.onlinecharacter.academia.AcademiaJustuFragment;
import com.gutotech.narutogame.ui.onlinecharacter.academia.AcademiaTreinamentoFragment;
import com.gutotech.narutogame.ui.onlinecharacter.academia.GraduacoesFragment;
import com.gutotech.narutogame.ui.onlinecharacter.academia.PersonagemJutsuFragment;
import com.gutotech.narutogame.ui.onlinecharacter.combates.ArenaFragment;
import com.gutotech.narutogame.ui.onlinecharacter.combates.Dojo4x4Fragment;
import com.gutotech.narutogame.ui.onlinecharacter.combates.DojoFragment;
import com.gutotech.narutogame.ui.onlinecharacter.combates.LogBatalhaFragment;
import com.gutotech.narutogame.ui.onlinecharacter.equipe.EquipeCriarFragment;
import com.gutotech.narutogame.ui.onlinecharacter.equipe.EquipeParticiparFragment;
import com.gutotech.narutogame.ui.onlinecharacter.personagem.ClasFragment;
import com.gutotech.narutogame.ui.onlinecharacter.personagem.FidelidadeFragment;
import com.gutotech.narutogame.ui.onlinecharacter.personagem.HistoriaFragment;
import com.gutotech.narutogame.ui.onlinecharacter.personagem.InvocacaoFragment;
import com.gutotech.narutogame.ui.onlinecharacter.personagem.PersonagemStatusFragment;
import com.gutotech.narutogame.ui.onlinecharacter.personagem.SorteNinjaFragment;
import com.gutotech.narutogame.ui.onlinecharacter.ranking.Rank4x4Fragment;
import com.gutotech.narutogame.ui.onlinecharacter.ranking.RankEquipesFragment;
import com.gutotech.narutogame.ui.onlinecharacter.ranking.RankNinjasFragment;
import com.gutotech.narutogame.ui.onlinecharacter.sensei.DesafiosFragment;
import com.gutotech.narutogame.ui.onlinecharacter.sensei.SenseiFragment;
import com.gutotech.narutogame.ui.onlinecharacter.usuario.FormulasFragment;
import com.gutotech.narutogame.ui.onlinecharacter.usuario.MensagensFragment;
import com.gutotech.narutogame.ui.onlinecharacter.vilaatual.LicoesFragment;
import com.gutotech.narutogame.ui.onlinecharacter.vilaatual.MapaVilaFragment;
import com.gutotech.narutogame.ui.onlinecharacter.vilaatual.MissoesEsperaFragment;
import com.gutotech.narutogame.ui.onlinecharacter.vilaatual.MissoesFragment;
import com.gutotech.narutogame.ui.onlinecharacter.vilaatual.NinjaShopFragment;
import com.gutotech.narutogame.ui.onlinecharacter.vilaatual.RamenShopFragment;
import com.gutotech.narutogame.util.DateCustom;
import com.gutotech.narutogame.data.model.Mensagem;
import com.gutotech.narutogame.data.model.PersonagemOn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class PersonagemLogadoActivity extends AppCompatActivity {
    private View headerView;
    private ImageButton fidelidadeImageButton;

    private ExpandableListView menuExpandableListView;

    final int GROUP_USUARIO = 0;
    final int GROUP_PERSONAGEM = 1;
    final int GROUP_ACADEMIA = 2;
    final int GROUP_SENSEI = 3;
    final int GROUP_VILA_ATUAL = 4;
    final int GROUP_COMBATES = 5;
    final int GROUP_EQUIPE = 6;
    final int GROUP_ORG = 7;
    final int GROUP_RANKING = 8;

    private List<Integer> groupListImage = new ArrayList<>();
    private List<String> groupListText = new ArrayList<>();
    private HashMap<String, List<String>> childList = new HashMap<>();
    private MenuPersonagemLogadoExpandableAdapter menuAdapter;

    private boolean chatAberto = false;
    private String channer;
    private List<Mensagem> mensagensList = new ArrayList<>();
    private MensagensAdapter mensagensAdapter;
    private DatabaseReference mensagensReference;
    private ValueEventListener valueEventListenerMensagens;

    private DatabaseReference personagemOnReference;
    private ValueEventListener valueEventListenerPersonagemOn;

    private Dialog rotinasDialog;
    private TextView heallingTextView;
    private TextView rankNinjaTextView;
    private TextView diversasRotinasTextView;

    private final long millis_DiversasRotinas = 86400000l;
    private final long millis_Healling = 120000;
    private final long millis_RANKNINJA = 7200000;

    private CountDownTimer heallingTimer;
    private CountDownTimer rankNinjaTimer;
    private CountDownTimer diversasRotinasTimer;

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personagem_logado);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PersonagemOn.character.setOn(true);
        PersonagemOn.character.salvar();

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);

        fidelidadeImageButton = headerView.findViewById(R.id.irFidelidadeImageButton);

        ImageView topoLogadoimageView = headerView.findViewById(R.id.topoLogadoImageView);
        StorageUtil.baixarTopoLogado(getApplicationContext(), topoLogadoimageView, PersonagemOn.character.getIdProfile());

        ImageView profileLogadoimageView = findViewById(R.id.profilePersonagemOnImageView);
        StorageUtil.downloadProfile(getApplicationContext(), profileLogadoimageView, PersonagemOn.character.getIdProfile(), PersonagemOn.character.getFotoAtual());

        TextView nickPersonagemOnTextView = findViewById(R.id.nickPersonagemOnTextView);
        nickPersonagemOnTextView.setText(PersonagemOn.character.getNick());

        Button trocarImagem = findViewById(R.id.trocarImagemButton);
        trocarImagem.setOnClickListener(v -> {
            changeFragment(new TrocarImagemFragment());

            drawer.closeDrawer(GravityCompat.START);
        });

        ImageView bolsaImageView = findViewById(R.id.bolsaImageView);
        bolsaImageView.setOnClickListener(this::exibirBolsa);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        configurarChat();

        menuExpandableListView = findViewById(R.id.expanded_menu_main);
        buildMenu();
        menuAdapter = new MenuPersonagemLogadoExpandableAdapter(PersonagemLogadoActivity.this, groupListText, groupListImage, childList);
        configurarMenuExpandable();

        rotinasDialog = new Dialog(this);
        rotinasDialog.setContentView(R.layout.dialog_rotinas_do_jogo);
        rotinasDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        heallingTextView = rotinasDialog.findViewById(R.id.heallingTextView);
        rankNinjaTextView = rotinasDialog.findViewById(R.id.rankNinjaTextView);
        diversasRotinasTextView = rotinasDialog.findViewById(R.id.diversasRotinasTextView);

        changeFragment(new PersonagemStatusFragment());
    }

    private void configurarChat() {
        channer = PersonagemOn.character.getVila();
        mensagensReference = FirebaseConfig.getDatabase()
                .child("chat")
                .child(channer);

        final ImageView chatTopoImageView = findViewById(R.id.topoChatImageView);
        chatTopoImageView.setOnClickListener(v -> {
            LinearLayout chatMensagens = findViewById(R.id.chatMensagens);

            Animation animation;

            if (chatAberto) {
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                chatTopoImageView.startAnimation(animation);
                chatMensagens.setVisibility(View.GONE);
                chatAberto = false;

            } else {
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                chatTopoImageView.startAnimation(animation);
                chatMensagens.setVisibility(View.VISIBLE);
                chatAberto = true;
            }
        });

        RecyclerView mensagensRecyclerView = findViewById(R.id.mensagensRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mensagensRecyclerView.setLayoutManager(layoutManager);
        mensagensRecyclerView.setHasFixedSize(true);
        mensagensAdapter = new MensagensAdapter(mensagensList);
        mensagensRecyclerView.setAdapter(mensagensAdapter);

        final Spinner channelSpinner = findViewById(R.id.chatChannerSpinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.chat_channel_array, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        channelSpinner.setAdapter(arrayAdapter);
        channelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mensagensReference.removeEventListener(valueEventListenerMensagens);

                String channerSelected = (String) channelSpinner.getSelectedItem();

                channer = channerSelected.equals("Vila") ? PersonagemOn.character.getVila() : "mundo";

                mensagensReference = FirebaseConfig.getDatabase()
                        .child("chat")
                        .child(channer);

                recuperarMensagens();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final EditText mensagemEditText = findViewById(R.id.mensagemEditText);
        mensagemEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String mensagem = mensagemEditText.getText().toString();

                if (!mensagem.isEmpty()) {
                    enviarMensagem(new Mensagem(PersonagemOn.character.getNick(), mensagem));
                    mensagemEditText.setText("");
                }

                return false;
            }
        });

        FloatingActionButton floatingActionButton = findViewById(R.id.fabEnviarMensagem);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensagem = mensagemEditText.getText().toString();

                if (!mensagem.isEmpty()) {
                    enviarMensagem(new Mensagem(PersonagemOn.character.getNick(), mensagem));
                    mensagemEditText.setText("");
                }
            }
        });
    }

    private void configurarMenuExpandable() {
        menuExpandableListView.setAdapter(menuAdapter);
        menuExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if (groupPosition == GROUP_USUARIO) {
                    switch (childPosition) {
                        case 0:
                            changeFragment(new UserDataFragment());
                            break;
                        case 1:
                            changeFragment(new MensagensFragment());
                            break;
                        case 2:
                            changeFragment(new FormulasFragment());
                            break;
                        case 3:
                            changeFragment(new PasswordChangeFragment());
                            break;
                        case 4:
                            changeFragment(new CharacterCreateFragment());
                            break;
                        case 5:
                            changeFragment(new PersonagemSelecionarFragment());
                            break;
                        case 6:
                            changeFragment(new SuporteFragment());
                            break;
                        case 7:
                            deslogar();
                            break;
                    }
                } else if (groupPosition == GROUP_PERSONAGEM) {
                    if (PersonagemOn.character.isEmMissao()) {
                        switch (childPosition) {
                            case 0:
                                changeFragment(new PersonagemStatusFragment());
                                break;
                            case 1:
                                changeFragment(new FidelidadeFragment());
                                break;
                        }
                    } else {
                        switch (childPosition) {
                            case 0:
                                changeFragment(new PersonagemStatusFragment());
                                break;
                            case 1:
                                changeFragment(new ClasFragment());
                                break;
                            case 2:
                                changeFragment(new InvocacaoFragment());
                                break;
                            case 3:
                                changeFragment(new HistoriaFragment());
                                break;
                            case 4:
                                changeFragment(new SorteNinjaFragment());
                                break;
                            case 5:
                                changeFragment(new FidelidadeFragment());
                                break;
                        }
                    }
                } else if (groupPosition == GROUP_ACADEMIA) {
                    if (!PersonagemOn.character.isEmMissao()) {
                        switch (childPosition) {
                            case 0:
                                changeFragment(new GraduacoesFragment());
                                break;
                            case 1:
                                changeFragment(new AcademiaTreinamentoFragment());
                                break;
                            case 2:
                                changeFragment(new PersonagemJutsuFragment());
                                break;
                            case 3:
                                changeFragment(new AcademiaJustuFragment());
                                break;
                        }
                    }
                } else if (groupPosition == GROUP_SENSEI) {
                    if (PersonagemOn.character.isEmMissao()) {
                        changeFragment(new SenseiFragment());
                    } else {
                        switch (childPosition) {
                            case 0:
                                changeFragment(new SenseiFragment());
                                break;
                            case 1:
                                changeFragment(new DesafiosFragment());
                                break;
                        }
                    }

                } else if (groupPosition == GROUP_VILA_ATUAL) {
                    if (PersonagemOn.character.isEmMissao()) {
                        changeFragment(new MissoesEsperaFragment());
                    } else if (PersonagemOn.character.getGraducao().equals("Estudante")) {
                        switch (childPosition) {
                            case 0:
                                changeFragment(new LicoesFragment());
                                break;
                            case 1:
                                changeFragment(new RamenShopFragment());
                                break;
                            case 2:
                                changeFragment(new NinjaShopFragment());
                                break;
                        }
                    } else {
                        switch (childPosition) {
                            case 0:
                                changeFragment(new MapaVilaFragment());
                                break;
                            case 1:
                                changeFragment(new MissoesFragment());
                                break;
                            case 2:
                                changeFragment(new RamenShopFragment());
                                break;
                            case 3:
                                changeFragment(new NinjaShopFragment());
                                break;
                        }
                    }
                } else if (groupPosition == GROUP_COMBATES) {
                    if (!PersonagemOn.character.isEmMissao()) {
                        switch (childPosition) {
                            case 0:
                                changeFragment(new DojoFragment());
                                break;
                            case 1:
                                changeFragment(new Dojo4x4Fragment());
                                break;
                            case 2:
                                changeFragment(new ArenaFragment());
                                break;
                            case 3:
                                changeFragment(new LogBatalhaFragment());
                                break;
                        }
                    }
                } else if (groupPosition == GROUP_EQUIPE) {
                    if (!PersonagemOn.character.isEmMissao()) {
                        if (!PersonagemOn.character.getGraducao().equals("Estudante")) {
                            switch (childPosition) {
                                case 0:
                                    changeFragment(new EquipeParticiparFragment());
                                    break;
                                case 1:
                                    changeFragment(new EquipeCriarFragment());
                                    break;
                            }
                        }
                    }
                } else if (groupPosition == GROUP_ORG) {
                    if (!PersonagemOn.character.isEmMissao()) {
                        if (!PersonagemOn.character.getGraducao().equals("Estudante")) {
                            switch (childPosition) {
                                case 0:
                                    changeFragment(new UserDataFragment());
                                    break;
                                case 1:
                                    changeFragment(new PasswordChangeFragment());
                                    break;
                            }
                        }
                    }
                } else if (groupPosition == GROUP_RANKING) {
                    switch (childPosition) {
                        case 0:
                            changeFragment(new RankNinjasFragment());
                            break;
                        case 1:
                            changeFragment(new Rank4x4Fragment());
                            break;
                        case 2:
                            changeFragment(new RankEquipesFragment());
                            break;
                    }
                }

                closeDrawer();
                return false;
            }
        });
    }

    private void enviarMensagem(Mensagem mensagem) {
        DatabaseReference mensagensReference = FirebaseConfig.getDatabase()
                .child("chat")
                .child(channer)
                .push();
        mensagensReference.setValue(mensagem);
    }

    private void recuperarMensagens() {
        valueEventListenerMensagens = mensagensReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mensagensList.clear();

                for (DataSnapshot data : dataSnapshot.getChildren())
                    mensagensList.add(data.getValue(Mensagem.class));

                mensagensAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void startHeallingTimer(long millis) {
        heallingTimer = new CountDownTimer(millis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startHeallingTimer(120000);
            }
        }.start();
    }

    private void startRankNinjaTimer(long millis) {
        rankNinjaTimer = new CountDownTimer(millis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startRankNinjaTimer(7200000);
            }
        }.start();
    }

    private void startDiversasRotinasTimer(long millis) {
        diversasRotinasTimer = new CountDownTimer(millis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                diversasRotinasTextView.setText(String.format(Locale.getDefault(), "Diversas Rotinas: %s", DateCustom.getHorario(millisUntilFinished)));
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public void showPopupRotinas(View view) {
        rotinasDialog.show();
    }

    public void exibirBolsa(View view) {
        Dialog dialogBolsa = new Dialog(this);
        dialogBolsa.setContentView(R.layout.dialog_bolsa);
        RecyclerView ramensRecyclerView = dialogBolsa.findViewById(R.id.ramensRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ramensRecyclerView.setLayoutManager(layoutManager);
        ramensRecyclerView.setHasFixedSize(true);
        ramensRecyclerView.setAdapter(new BolsaRamensAdapter(this));
        dialogBolsa.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogBolsa.show();
    }

    private void buildMenu() {
        groupListImage.add(R.drawable.layout_categorias_topo_3);
        groupListImage.add(R.drawable.layout_categorias_topo_4);
        groupListImage.add(R.drawable.layout_categorias_topo_7);
        groupListImage.add(R.drawable.layout_categorias_topo_16);
        groupListImage.add(R.drawable.layout_categorias_topo_1_11);
        groupListImage.add(R.drawable.layout_categorias_topo_12);
        groupListImage.add(R.drawable.layout_categorias_topo_6);
        groupListImage.add(R.drawable.layout_categorias_topo_5);
        groupListImage.add(R.drawable.layout_categorias_topo_9);

        groupListText.add("Usuário");
        groupListText.add("Character");
        groupListText.add("Academia");
        groupListText.add("Sensei");
        groupListText.add("Vila Atual");
        groupListText.add("Combates");
        groupListText.add("Equipe");
        groupListText.add("Organização");
        groupListText.add("Ranking");

        List<String> itemsUSUARIO = new ArrayList<>();
        itemsUSUARIO.add("Meus dados");
        itemsUSUARIO.add("Mensageiro");
        itemsUSUARIO.add("Formulas do Jogo");
        itemsUSUARIO.add("Trocar Senha");
        itemsUSUARIO.add("Criar Character");
        itemsUSUARIO.add("Trocar Character");
        itemsUSUARIO.add("Suporte");
        itemsUSUARIO.add("Logout");
        childList.put(groupListText.get(0), itemsUSUARIO);

        List<String> itemsPersonagem = new ArrayList<>();
        itemsPersonagem.add("Status");
        if (!PersonagemOn.character.isEmMissao()) {
            itemsPersonagem.add("Clãs");
            itemsPersonagem.add("Invocações");
            itemsPersonagem.add("Modo História");
            itemsPersonagem.add("Sorte Ninja");
        }
        itemsPersonagem.add("Fidelidade Ninja");
        childList.put(groupListText.get(1), itemsPersonagem);

        List<String> itemsAcademia = new ArrayList<>();
        if (!PersonagemOn.character.isEmMissao()) {
            itemsAcademia.add("Graduações");
            itemsAcademia.add("Treinamento de Atributos");
            itemsAcademia.add("Treinamento de Jutsus");
            itemsAcademia.add("Aprender Jutsus");
            itemsAcademia.add("Jutsus de Clã");
        }
        childList.put(groupListText.get(2), itemsAcademia);

        List<String> itemsSensei = new ArrayList<>();
        itemsSensei.add("Sensei");
        if (!PersonagemOn.character.isEmMissao()) {
            itemsSensei.add("Desafios");
        }
        childList.put(groupListText.get(3), itemsSensei);

        List<String> itemsVilaAtual = new ArrayList<>();
        if (PersonagemOn.character.isEmMissao()) {
            itemsVilaAtual.add("Status da Missão");
        } else if (PersonagemOn.character.getGraducao().equals("Estudante")) {
            itemsVilaAtual.add("Taferas");
            itemsVilaAtual.add("Ramen Shop");
            itemsVilaAtual.add("Ninja Shop");
        } else {
            itemsVilaAtual.add("Mapa da Vila");
            itemsVilaAtual.add("Missões");
            itemsVilaAtual.add("Ramen Shop");
            itemsVilaAtual.add("Ninja Shop");
        }
        childList.put(groupListText.get(4), itemsVilaAtual);

        List<String> itemsCombates = new ArrayList<>();
        if (!PersonagemOn.character.isEmMissao()) {
            itemsCombates.add("Dojo");
            itemsCombates.add("Dojo 4x4");
            itemsCombates.add("Arena");
        }
        childList.put(groupListText.get(5), itemsCombates);

        List<String> itemsEquipe = new ArrayList<>();
        List<String> itemsOrg = new ArrayList<>();
        if (!PersonagemOn.character.isEmMissao()) {
            if (!PersonagemOn.character.getGraducao().equals("Estudante")) {
                itemsEquipe.add("Participar");
                itemsEquipe.add("Ser Líder");

                itemsOrg.add("Participar");
                itemsOrg.add("Ser Líder");
            }
        }
        childList.put(groupListText.get(6), itemsEquipe);
        childList.put(groupListText.get(7), itemsOrg);

        List<String> itemsRanking = new ArrayList<>();
        itemsRanking.add("Ninja");
        itemsRanking.add("4x4");
        itemsRanking.add("Equipes");
        childList.put(groupListText.get(8), itemsRanking);
    }

    private void recuperarPersonagemOn() {
        personagemOnReference = FirebaseConfig.getDatabase().child("character").child(PersonagemOn.character.getNick());
        valueEventListenerPersonagemOn = personagemOnReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                atualizarInformacoes();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void atualizarInformacoes() {
        if (PersonagemOn.character.isTemRecompensaFidelidade())
            fidelidadeImageButton.setImageResource(R.drawable.layout_icones_gift);
        else
            fidelidadeImageButton.setImageResource(R.drawable.layout_icones_gift2);

        TextView lvlAtual = headerView.findViewById(R.id.lvlAtualTextView);
        lvlAtual.setText(String.valueOf(PersonagemOn.character.getLevel()));

        TextView lvlNext = headerView.findViewById(R.id.lvlProxTextView);
        lvlNext.setText(String.valueOf(PersonagemOn.character.getLevel() + 1));

        TextView expTextView = headerView.findViewById(R.id.expTextView);
        expTextView.setText(String.format(Locale.getDefault(), "EXP: %d/%d", PersonagemOn.character.getExpAtual(), PersonagemOn.character.getExpUpar()));

        ProgressBar expProgressBar = headerView.findViewById(R.id.expProgressBar);
        expProgressBar.setMax(PersonagemOn.character.getExpUpar());
        expProgressBar.setProgress(PersonagemOn.character.getExpAtual());

        TextView ryous = headerView.findViewById(R.id.ryousTextView);
        ryous.setText(String.valueOf(PersonagemOn.character.getRyous()));

        TextView vidaTextView = headerView.findViewById(R.id.vidaTextView);
        vidaTextView.setText(String.format(Locale.getDefault(), "%d/%d",
                PersonagemOn.character.getAtributos().getFormulas().getVidaAtual(),
                PersonagemOn.character.getAtributos().getFormulas().getVida()));

        TextView chakraTextView = headerView.findViewById(R.id.chakraTextView);
        chakraTextView.setText(String.format(Locale.getDefault(), "%d/%d",
                PersonagemOn.character.getAtributos().getFormulas().getChakraAtual(),
                PersonagemOn.character.getAtributos().getFormulas().getChakra()));

        TextView staminaTextView = headerView.findViewById(R.id.staminaTextView);
        staminaTextView.setText(String.format(Locale.getDefault(), "%d/%d",
                PersonagemOn.character.getAtributos().getFormulas().getStaminaAtual(),
                PersonagemOn.character.getAtributos().getFormulas().getStamina()));

        ProgressBar vidaProgressBar = headerView.findViewById(R.id.vidaProgressBar);
        vidaProgressBar.setMax(PersonagemOn.character.getAtributos().getFormulas().getVida());
        vidaProgressBar.setProgress(PersonagemOn.character.getAtributos().getFormulas().getVidaAtual());

        ProgressBar chakraProgressBar = headerView.findViewById(R.id.chakraProgressBar);
        chakraProgressBar.setMax(PersonagemOn.character.getAtributos().getFormulas().getChakra());
        chakraProgressBar.setProgress(PersonagemOn.character.getAtributos().getFormulas().getChakraAtual());

        ProgressBar staminaProgressBar = headerView.findViewById(R.id.staminaProgressBar);
        staminaProgressBar.setMax(PersonagemOn.character.getAtributos().getFormulas().getStamina());
        staminaProgressBar.setProgress(PersonagemOn.character.getAtributos().getFormulas().getStaminaAtual());

        TextView classe = findViewById(R.id.classeTextView);
        classe.setText(String.valueOf(PersonagemOn.character.getClasse()));

        TextView vila = findViewById(R.id.vilaTextView);
        vila.setText(String.valueOf(PersonagemOn.character.getVila()));

        TextView level = findViewById(R.id.levelTextView);
        level.setText(String.valueOf(PersonagemOn.character.getLevel()));

        buildMenu();
        menuAdapter.notifyDataSetChanged();
    }

    public void goFidelidade(View view) {
        changeFragment(new FidelidadeFragment());
        closeDrawer();
    }

    public void goMensageiro(View view) {
        changeFragment(new MensagensFragment());
        closeDrawer();
    }

    public void logout(View view) {
        deslogar();
    }

    private void deslogar() {
//        FirebaseAuth auth = FirebaseConfig.getAuth();
//        auth.signOut();
        startActivity(new Intent(PersonagemLogadoActivity.this, DeslogadoActivity.class));
        finish();
    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    private void closeDrawer() {
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        recuperarPersonagemOn();
        recuperarMensagens();

        long millis = millis_DiversasRotinas;
        startDiversasRotinasTimer(millis);

        inicializarCounterHorasJogadas();
    }

    private void inicializarCounterHorasJogadas() {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                PersonagemOn.character.setTotalHorasJogadas(PersonagemOn.character.getTotalHorasJogadas() + 1);
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        personagemOnReference.removeEventListener(valueEventListenerPersonagemOn);
        mensagensReference.removeEventListener(valueEventListenerMensagens);

        PersonagemOn.character.setOn(false);
        PersonagemOn.character.setUltimoLogin(String.format(Locale.getDefault(), "%s às %s", DateCustom.getData(), DateCustom.getHorario()));

        PersonagemOn.character.salvar();
    }
}
