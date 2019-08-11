package com.gutotech.narutogame.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
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
import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.adapter.MensagensAdapter;
import com.gutotech.narutogame.adapter.MenuPersonagemLogadoExpandableAdapter;
import com.gutotech.narutogame.config.ConfigFirebase;
import com.gutotech.narutogame.config.Storage;
import com.gutotech.narutogame.fragment.logado.PersonagemCriarFragment;
import com.gutotech.narutogame.fragment.logado.PersonagemSelecionarFragment;
import com.gutotech.narutogame.fragment.logado.SenhaTrocarFragment;
import com.gutotech.narutogame.fragment.logado.SuporteFragment;
import com.gutotech.narutogame.fragment.logado.UsuarioDadosFragment;
import com.gutotech.narutogame.fragment.personagemlogado.TrocarImagemFragment;
import com.gutotech.narutogame.fragment.personagemlogado.academia.AcademiaJustuFragment;
import com.gutotech.narutogame.fragment.personagemlogado.academia.AcademiaTreinamentoFragment;
import com.gutotech.narutogame.fragment.personagemlogado.academia.GraduacoesFragment;
import com.gutotech.narutogame.fragment.personagemlogado.academia.PersonagemJutsuFragment;
import com.gutotech.narutogame.fragment.personagemlogado.combates.ArenaFragment;
import com.gutotech.narutogame.fragment.personagemlogado.combates.Dojo4x4Fragment;
import com.gutotech.narutogame.fragment.personagemlogado.combates.DojoFragment;
import com.gutotech.narutogame.fragment.personagemlogado.equipe.EquipeCriarFragment;
import com.gutotech.narutogame.fragment.personagemlogado.equipe.EquipeParticiparFragment;
import com.gutotech.narutogame.fragment.personagemlogado.personagem.ClasFragment;
import com.gutotech.narutogame.fragment.personagemlogado.personagem.FidelidadeFragment;
import com.gutotech.narutogame.fragment.personagemlogado.personagem.HistoriaFragment;
import com.gutotech.narutogame.fragment.personagemlogado.personagem.InvocacaoFragment;
import com.gutotech.narutogame.fragment.personagemlogado.personagem.PersonagemStatusFragment;
import com.gutotech.narutogame.fragment.personagemlogado.personagem.SorteNinjaFragment;
import com.gutotech.narutogame.fragment.personagemlogado.ranking.Rank4x4Fragment;
import com.gutotech.narutogame.fragment.personagemlogado.ranking.RankEquipesFragment;
import com.gutotech.narutogame.fragment.personagemlogado.ranking.RankNinjasFragment;
import com.gutotech.narutogame.fragment.personagemlogado.sensei.DesafiosFragment;
import com.gutotech.narutogame.fragment.personagemlogado.sensei.SenseiFragment;
import com.gutotech.narutogame.fragment.personagemlogado.usuario.FormulasFragment;
import com.gutotech.narutogame.fragment.personagemlogado.usuario.MensagensFragment;
import com.gutotech.narutogame.fragment.personagemlogado.vilaatual.LicoesFragment;
import com.gutotech.narutogame.fragment.personagemlogado.vilaatual.MapaVilaFragment;
import com.gutotech.narutogame.fragment.personagemlogado.vilaatual.MissoesEsperaFragment;
import com.gutotech.narutogame.fragment.personagemlogado.vilaatual.MissoesFragment;
import com.gutotech.narutogame.fragment.personagemlogado.vilaatual.NinjaShopFragment;
import com.gutotech.narutogame.fragment.personagemlogado.vilaatual.RamenShopFragment;
import com.gutotech.narutogame.model.Bolsa;
import com.gutotech.narutogame.model.Mensagem;
import com.gutotech.narutogame.model.Personagem;
import com.gutotech.narutogame.publicentities.PersonagemOn;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class PersonagemLogadoActivity extends AppCompatActivity {
    private TextView tituloSecao;

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

    private View headerView;

    private boolean chatAberto = false;
    private String channer;
    private List<Mensagem> mensagensList = new ArrayList<>();
    private MensagensAdapter mensagensAdapter;
    private DatabaseReference mensagensReference;
    private ValueEventListener valueEventListenerMensagens;

    private DatabaseReference personagemOnReference;
    private ValueEventListener valueEventListenerPersonagemOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personagem_logado);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PersonagemOn.personagem.setOn(true);
        PersonagemOn.personagem.salvar();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);

        ImageView topoLogadoimageView = headerView.findViewById(R.id.topoLogadoImageView);
        Storage.baixarTopoLogado(getApplicationContext(), topoLogadoimageView, PersonagemOn.personagem.getIdProfile());

        ImageView profileLogadoimageView = findViewById(R.id.profilePersonagemOnImageView);
        Storage.baixarProfile(getApplicationContext(), profileLogadoimageView, PersonagemOn.personagem.getIdProfile(), PersonagemOn.personagem.getFotoAtual());

        TextView nickPersonagemOnTextView = findViewById(R.id.nickPersonagemOnTextView);
        nickPersonagemOnTextView.setText(PersonagemOn.personagem.getNick());

        Button trocarImagem = findViewById(R.id.trocarImagemButton);
        trocarImagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tituloSecao.setText("TROCAR IMAGEM");
                changeFragment(new TrocarImagemFragment());

                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        ImageView bolsaImageView = findViewById(R.id.bolsaImageView);
        bolsaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirBolsa(v);
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // CONFIGURA CHAT
        channer = PersonagemOn.personagem.getVila();
        mensagensReference = ConfigFirebase.getDatabase()
                .child("chat")
                .child(channer);

        ImageView chatTopoImageView = findViewById(R.id.topoChatImageView);
        chatTopoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout chatMensagens = findViewById(R.id.chatMensagens);

                if (chatAberto) {
                    chatMensagens.setVisibility(View.GONE);
                    chatAberto = false;
                } else {
                    chatMensagens.setVisibility(View.VISIBLE);
                    chatAberto = true;
                }
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

                channer = channerSelected.equals("Vila") ? PersonagemOn.personagem.getVila() : "mundo";

                mensagensReference = ConfigFirebase.getDatabase()
                        .child("chat")
                        .child(channer);

                recuperarMensagens();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final EditText mensagemEditText = findViewById(R.id.mensagemEditText);

        FloatingActionButton floatingActionButton = findViewById(R.id.fabEnviarMensagem);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensagem = mensagemEditText.getText().toString();

                if (!mensagem.isEmpty()) {
                    enviarMensagem(new Mensagem(PersonagemOn.personagem.getNick(), mensagem));
                    mensagemEditText.setText("");
                }
            }
        });

        menuExpandableListView = findViewById(R.id.expanded_menu_main);
        buildMenu();
        menuAdapter = new MenuPersonagemLogadoExpandableAdapter(PersonagemLogadoActivity.this, groupListText, groupListImage, childList);
        menuExpandableListView.setAdapter(menuAdapter);
        menuExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if (groupPosition == GROUP_USUARIO) {
                    switch (childPosition) {
                        case 0:
                            tituloSecao.setText("DADOS DA CONTA");
                            changeFragment(new UsuarioDadosFragment());
                            break;
                        case 1:
                            tituloSecao.setText("MENSAGEIRO");
                            changeFragment(new MensagensFragment());
                            break;
                        case 2:
                            tituloSecao.setText("FÓRMULAS");
                            changeFragment(new FormulasFragment());
                            break;
                        case 3:
                            tituloSecao.setText("TROQUE SUA SENHA");
                            changeFragment(new SenhaTrocarFragment());
                            break;
                        case 4:
                            tituloSecao.setText("CRIAR PERSONAGEM");
                            changeFragment(new PersonagemCriarFragment());
                            break;
                        case 5:
                            tituloSecao.setText("SELECIONE SEU PERSONAGEM");
                            changeFragment(new PersonagemSelecionarFragment());
                            break;
                        case 6:
                            tituloSecao.setText("SUPORTE");
                            changeFragment(new SuporteFragment());
                            break;
                        case 7:
                            deslogar();
                            break;
                    }
                } else if (groupPosition == GROUP_PERSONAGEM) {
                    if (PersonagemOn.personagem.isEmMissao()) {
                        switch (childPosition) {
                            case 0:
                                tituloSecao.setText("STATUS DO PERSONAGEM");
                                changeFragment(new PersonagemStatusFragment());
                                break;
                            case 1:
                                tituloSecao.setText("FIDELIDADE NINJA");
                                changeFragment(new FidelidadeFragment());
                                break;
                        }
                    } else {
                        switch (childPosition) {
                            case 0:
                                tituloSecao.setText("STATUS DO PERSONAGEM");
                                changeFragment(new PersonagemStatusFragment());
                                break;
                            case 1:
                                tituloSecao.setText("CLÃS");
                                changeFragment(new ClasFragment());
                                break;
                            case 2:
                                tituloSecao.setText("INVOCAÇÕES");
                                changeFragment(new InvocacaoFragment());
                                break;
                            case 3:
                                tituloSecao.setText("MODO HISTÓRIA");
                                changeFragment(new HistoriaFragment());
                                break;
                            case 4:
                                tituloSecao.setText("SORTE NINJA");
                                changeFragment(new SorteNinjaFragment());
                                break;
                            case 5:
                                tituloSecao.setText("FIDELIDADE NINJA");
                                changeFragment(new FidelidadeFragment());
                                break;
                        }
                    }
                } else if (groupPosition == GROUP_ACADEMIA) {
                    if (!PersonagemOn.personagem.isEmMissao()) {
                        switch (childPosition) {
                            case 0:
                                tituloSecao.setText("GRADUAÇÕES");
                                changeFragment(new GraduacoesFragment());
                                break;
                            case 1:
                                tituloSecao.setText("TREINAMENTO DE ATRIBUTOS");
                                changeFragment(new AcademiaTreinamentoFragment());
                                break;
                            case 2:
                                tituloSecao.setText("TREINAMENTO DE JUTSUS");
                                changeFragment(new PersonagemJutsuFragment());
                                break;
                            case 3:
                                tituloSecao.setText("JUTSUS NINJAS");
                                changeFragment(new AcademiaJustuFragment());
                                break;
                        }
                    }
                } else if (groupPosition == GROUP_SENSEI) {
                    if (PersonagemOn.personagem.isEmMissao()) {
                        switch (childPosition) {
                            case 0:
                                changeFragment(new SenseiFragment());
                                break;
                        }
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
                    if (PersonagemOn.personagem.isEmMissao()) {
                        switch (childPosition) {
                            case 0:
                                tituloSecao.setText("STATUS DA MISSÃO");
                                changeFragment(new MissoesEsperaFragment());
                                break;
                        }
                    } else if (PersonagemOn.personagem.getGraducao().equals("Estudante")) {
                        switch (childPosition) {
                            case 0:
                                tituloSecao.setText("TAREFAS INICIAIS");
                                changeFragment(new LicoesFragment());
                                break;
                            case 1:
                                tituloSecao.setText("RAMEM SHOP");
                                changeFragment(new RamenShopFragment());
                                break;
                            case 2:
                                tituloSecao.setText("NINJA SHOP");
                                changeFragment(new NinjaShopFragment());
                                break;
                        }
                    } else {
                        switch (childPosition) {
                            case 0:
                                tituloSecao.setText("MAPA DA VILA");
                                changeFragment(new MapaVilaFragment());
                                break;
                            case 1:
                                tituloSecao.setText("MISSÕES");
                                changeFragment(new MissoesFragment());
                                break;
                            case 2:
                                tituloSecao.setText("RAMEM SHOP");
                                changeFragment(new RamenShopFragment());
                                break;
                            case 3:
                                tituloSecao.setText("NINJA SHOP");
                                changeFragment(new NinjaShopFragment());
                                break;
                        }
                    }
                } else if (groupPosition == GROUP_COMBATES) {
                    if (!PersonagemOn.personagem.isEmMissao()) {
                        switch (childPosition) {
                            case 0:
                                tituloSecao.setText("DOJO");
                                changeFragment(new DojoFragment());
                                break;
                            case 1:
                                tituloSecao.setText("DOJO 4X4");
                                changeFragment(new Dojo4x4Fragment());
                                break;
                            case 2:
                                tituloSecao.setText("ARENA");
                                changeFragment(new ArenaFragment());
                                break;
                        }
                    }
                } else if (groupPosition == GROUP_EQUIPE) {
                    if (!PersonagemOn.personagem.isEmMissao()) {
                        if (!PersonagemOn.personagem.getGraducao().equals("Estudante")) {
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
                    if (!PersonagemOn.personagem.isEmMissao()) {
                        if (!PersonagemOn.personagem.getGraducao().equals("Estudante")) {
                            switch (childPosition) {
                                case 0:
                                    changeFragment(new UsuarioDadosFragment());
                                    break;
                                case 1:
                                    changeFragment(new SenhaTrocarFragment());
                                    break;
                            }
                        }
                    }
                } else if (groupPosition == GROUP_RANKING) {
                    switch (childPosition) {
                        case 0:
                            tituloSecao.setText("RANKING DE NINJAS");
                            changeFragment(new RankNinjasFragment());
                            break;
                        case 1:
                            tituloSecao.setText("RANKING DE 4x4");
                            changeFragment(new Rank4x4Fragment());
                            break;
                        case 2:
                            tituloSecao.setText("RANKING DE EQUIPES");
                            changeFragment(new RankEquipesFragment());
                            break;
                    }
                }

                closeDrawer();
                return false;
            }
        });

        tituloSecao = findViewById(R.id.tituloSecaoTextView);
        tituloSecao.setText("STATUS DO PERSONAGEM");
        changeFragment(new PersonagemStatusFragment());
    }

    private void enviarMensagem(Mensagem mensagem) {
        DatabaseReference mensagensReference = ConfigFirebase.getDatabase()
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

    private void recuperarPersonagemOn() {
        personagemOnReference = ConfigFirebase.getDatabase().child("personagem").child(PersonagemOn.personagem.getNick());
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

    @SuppressLint("RestrictedApi")
    private void exibirBolsa(View view) {
        MenuBuilder menuBuilder = new MenuBuilder(getApplicationContext());
        MenuInflater menuInflater = new MenuInflater(getApplicationContext());
        menuInflater.inflate(R.menu.pop_menu_bolsa, menuBuilder);

        MenuPopupHelper menuPopupHelper = new MenuPopupHelper(getApplicationContext(), menuBuilder, view);
        menuPopupHelper.setForceShowIcon(true);

        Bolsa bolsa = PersonagemOn.personagem.getBolsa();
        if (bolsa != null) {
            if (bolsa.getRamenList().size() > 0) {
                menuBuilder.add("Ramen");
            } else {

            }
        }

        menuBuilder.setCallback(new MenuBuilder.Callback() {
            @Override
            public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.infoNinja:
                        return true;
                    case R.id.batalharMenu:
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onMenuModeChange(MenuBuilder menuBuilder) {
            }
        });

        menuBuilder.findItem(R.id.nomeJutsu).setTitle("%s       x%d");

        menuBuilder.findItem(R.id.atkOuDefJutsu).setIcon(R.drawable.layout_icones_atk_magico);
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
        groupListText.add("Personagem");
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
        itemsUSUARIO.add("Criar Personagem");
        itemsUSUARIO.add("Trocar Personagem");
        itemsUSUARIO.add("Suporte");
        itemsUSUARIO.add("Logout");
        childList.put(groupListText.get(0), itemsUSUARIO);

        List<String> itemsPersonagem = new ArrayList<>();
        itemsPersonagem.add("Status");
        if (!PersonagemOn.personagem.isEmMissao()) {
            itemsPersonagem.add("Clãs");
            itemsPersonagem.add("Invocações");
            itemsPersonagem.add("Modo História");
            itemsPersonagem.add("Sorte Ninja");
        }
        itemsPersonagem.add("Fidelidade Ninja");
        childList.put(groupListText.get(1), itemsPersonagem);

        List<String> itemsAcademia = new ArrayList<>();
        if (!PersonagemOn.personagem.isEmMissao()) {
            itemsAcademia.add("Graduações");
            itemsAcademia.add("Treinamento de Atributos");
            itemsAcademia.add("Treinamento de Jutsus");
            itemsAcademia.add("Aprender Jutsus");
            itemsAcademia.add("Jutsus de Clã");
        }
        childList.put(groupListText.get(2), itemsAcademia);

        List<String> itemsSensei = new ArrayList<>();
        itemsSensei.add("Sensei");
        if (!PersonagemOn.personagem.isEmMissao()) {
            itemsSensei.add("Desafios");
        }
        childList.put(groupListText.get(3), itemsSensei);

        List<String> itemsVilaAtual = new ArrayList<>();
        if (PersonagemOn.personagem.isEmMissao()) {
            itemsVilaAtual.add("Status da Missão");
        } else if (PersonagemOn.personagem.getGraducao().equals("Estudante")) {
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
        if (!PersonagemOn.personagem.isEmMissao()) {
            itemsCombates.add("Dojo");
            itemsCombates.add("Dojo 4x4");
            itemsCombates.add("Arena");
        }
        childList.put(groupListText.get(5), itemsCombates);

        List<String> itemsEquipe = new ArrayList<>();
        List<String> itemsOrg = new ArrayList<>();

        if (!PersonagemOn.personagem.isEmMissao()) {
            if (!PersonagemOn.personagem.getGraducao().equals("Estudante")) {
                itemsEquipe.add("Participar");
                itemsEquipe.add("Ser Líder");

                itemsOrg.add("Participar");
                itemsOrg.add("Ser Líder");
            }
        }
        childList.put(groupListText.get(6), itemsEquipe);
        childList.put(groupListText.get(7), itemsOrg);

        List<String> itemsRanking = new ArrayList<>();
        itemsRanking.add("Ninjas");
        itemsRanking.add("4x4");
        itemsRanking.add("Equipes");
        childList.put(groupListText.get(8), itemsRanking);
    }

    public void atualizarInformacoes() {
        TextView lvlAtual = headerView.findViewById(R.id.lvlAtualTextView);
        lvlAtual.setText(String.valueOf(PersonagemOn.personagem.getLevel()));

        TextView lvlNext = headerView.findViewById(R.id.lvlProxTextView);
        lvlNext.setText(String.valueOf(PersonagemOn.personagem.getLevel() + 1));

        TextView expTextView = headerView.findViewById(R.id.expTextView);
        expTextView.setText(String.format(Locale.getDefault(), "EXP: %d/%d", PersonagemOn.personagem.getExpAtual(), PersonagemOn.personagem.getExpUpar()));

        ProgressBar expProgressBar = headerView.findViewById(R.id.expProgressBar);
        expProgressBar.setMax(PersonagemOn.personagem.getExpUpar());
        expProgressBar.setProgress(PersonagemOn.personagem.getExpAtual());

        TextView ryous = headerView.findViewById(R.id.ryousTextView);
        ryous.setText(String.valueOf(PersonagemOn.personagem.getRyous()));

        TextView classe = findViewById(R.id.classeTextView);
        classe.setText(String.valueOf(PersonagemOn.personagem.getClasse()));

        TextView vila = findViewById(R.id.vilaTextView);
        vila.setText(String.valueOf(PersonagemOn.personagem.getVila()));

        TextView level = findViewById(R.id.levelTextView);
        level.setText(String.valueOf(PersonagemOn.personagem.getLevel()));

        buildMenu();
        menuAdapter.notifyDataSetChanged();
    }

    public void goFidelidade(View view) {
        tituloSecao.setText("FIDELIDADE NINJA");
        changeFragment(new FidelidadeFragment());
        closeDrawer();
    }

    public void goMensageiro(View view) {
        tituloSecao.setText("MENSAGEIRO");
        changeFragment(new MensagensFragment());
        closeDrawer();
    }

    public void logout(View view) {
        deslogar();
    }

    private void deslogar() {
        FirebaseAuth auth = ConfigFirebase.getAuth();
        auth.signOut();
        startActivity(new Intent(PersonagemLogadoActivity.this, DeslogadoActivity.class));
        finish();
    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment);
        transaction.commit();
    }

    private void closeDrawer() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
    }

    @Override
    protected void onStop() {
        super.onStop();
        personagemOnReference.removeEventListener(valueEventListenerPersonagemOn);
        mensagensReference.removeEventListener(valueEventListenerMensagens);

        PersonagemOn.personagem.setOn(false);
        PersonagemOn.personagem.salvar();
    }
}
