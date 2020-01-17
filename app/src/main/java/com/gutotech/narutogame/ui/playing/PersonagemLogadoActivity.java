package com.gutotech.narutogame.ui.playing;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.MenuGroup;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.ExpandableLoggedinAdapter;
import com.gutotech.narutogame.ui.adapter.BolsaRamensAdapter;
import com.gutotech.narutogame.ui.loggedout.DeslogadoActivity;
import com.gutotech.narutogame.ui.loggedin.newcharacteer.CharacterCreateFragment;
import com.gutotech.narutogame.ui.playing.team.EquipeDetalheFragment;
import com.gutotech.narutogame.ui.playing.user.VipPlayerFragment;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.StorageUtil;
import com.gutotech.narutogame.ui.loggedin.selectcharacter.CharacterSelectFragment;
import com.gutotech.narutogame.ui.loggedin.changepassword.PasswordChangeFragment;
import com.gutotech.narutogame.ui.loggedin.support.SuporteFragment;
import com.gutotech.narutogame.ui.loggedin.accountinfo.UserDataFragment;
import com.gutotech.narutogame.ui.playing.academy.AcademiaJustuFragment;
import com.gutotech.narutogame.ui.playing.academy.AcademiaTreinamentoFragment;
import com.gutotech.narutogame.ui.playing.academy.GraduacoesFragment;
import com.gutotech.narutogame.ui.playing.academy.PersonagemJutsuFragment;
import com.gutotech.narutogame.ui.playing.battles.ArenaFragment;
import com.gutotech.narutogame.ui.playing.battles.DojoFragment;
import com.gutotech.narutogame.ui.playing.battles.LogBatalhaFragment;
import com.gutotech.narutogame.ui.playing.team.EquipeCriarFragment;
import com.gutotech.narutogame.ui.playing.team.EquipeParticiparFragment;
import com.gutotech.narutogame.ui.playing.character.ClansFragment;
import com.gutotech.narutogame.ui.playing.character.FidelityFragment;
import com.gutotech.narutogame.ui.playing.character.CharacterStatusFragment;
import com.gutotech.narutogame.ui.playing.character.NinjaLuckyFragment;
import com.gutotech.narutogame.ui.playing.ranking.RankEquipesFragment;
import com.gutotech.narutogame.ui.playing.ranking.RankNinjasFragment;
import com.gutotech.narutogame.ui.playing.user.FormulasFragment;
import com.gutotech.narutogame.ui.playing.user.MensagensFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.LicoesFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.MapaVilaFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.MissoesEsperaFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.MissoesFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.NinjaShopFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.RamenShopFragment;
import com.gutotech.narutogame.utils.DateCustom;
import com.gutotech.narutogame.data.model.PersonagemOn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class PersonagemLogadoActivity extends AppCompatActivity {
    private View headerView;
    private ImageButton fidelidadeImageButton;

    public final int GROUP_USUARIO = 0;
    public final int GROUP_PERSONAGEM = 1;
    public final int GROUP_ACADEMIA = 2;
    public final int GROUP_SENSEI = 3;
    public final int GROUP_VILA_ATUAL = 4;
    public final int GROUP_COMBATES = 5;
    public final int GROUP_EQUIPE = 6;
    public final int GROUP_ORG = 7;
    public final int GROUP_RANKING = 8;

    private ExpandableLoggedinAdapter menuAdapter;

    private List<MenuGroup> menuGroups = new ArrayList<>();
    private HashMap<Integer, List<SectionFragment>> sections = new HashMap<>();

    private boolean chatAberto = false;
    private String channer;

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

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);

        fidelidadeImageButton = headerView.findViewById(R.id.irFidelidadeImageButton);

        ImageView topoLogadoimageView = headerView.findViewById(R.id.topoLogadoImageView);
        StorageUtil.baixarTopoLogado(getApplicationContext(), topoLogadoimageView,
                PersonagemOn.character.getNinja().getId());

        ImageView profileLogadoimageView = findViewById(R.id.profilePersonagemOnImageView);
        StorageUtil.downloadProfile(getApplicationContext(), profileLogadoimageView,
                PersonagemOn.character.getNinja().getId(), PersonagemOn.character.getProfile());

        TextView nickPersonagemOnTextView = findViewById(R.id.nickPersonagemOnTextView);
        nickPersonagemOnTextView.setText(PersonagemOn.character.getNick());

        Button trocarImagem = findViewById(R.id.trocarImagemButton);
        trocarImagem.setOnClickListener(v -> {
            FragmentUtil.goTo(this, new TrocarImagemFragment());

            drawer.closeDrawer(GravityCompat.START);
        });

        ImageView bolsaImageView = findViewById(R.id.bolsaImageView);
        bolsaImageView.setOnClickListener(this::showBag);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        ExpandableListView menuExpandableListView = findViewById(R.id.expanded_menu_main);
        menuExpandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            FragmentUtil.goTo(this, (Fragment) sections.get(groupPosition).get(childPosition));

            closeDrawer();
            return false;
        });

        buildMenu();
        menuAdapter = new ExpandableLoggedinAdapter(menuGroups, sections);
        menuExpandableListView.setAdapter(menuAdapter);

        rotinasDialog = new Dialog(this);
        rotinasDialog.setContentView(R.layout.dialog_rotinas_do_jogo);
        rotinasDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        heallingTextView = rotinasDialog.findViewById(R.id.heallingTextView);
        rankNinjaTextView = rotinasDialog.findViewById(R.id.rankNinjaTextView);
        diversasRotinasTextView = rotinasDialog.findViewById(R.id.diversasRotinasTextView);

        FragmentUtil.goTo(this, new CharacterStatusFragment());
    }

//    private void configurarChat() {
//        channer = PersonagemOn.character.getVillage().name;
//        mensagensReference = FirebaseConfig.getDatabase()
//                .child("chat")
//                .child(channer);
//
//        final ImageView chatTopoImageView = findViewById(R.id.topoChatImageView);
//        chatTopoImageView.setOnClickListener(v -> {
//            LinearLayout chatMensagens = findViewById(R.id.chatMensagens);
//
//            Animation animation;
//
//            if (chatAberto) {
//                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
//                chatTopoImageView.startAnimation(animation);
//                chatMensagens.setVisibility(View.GONE);
//                chatAberto = false;
//
//            } else {
//                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
//                chatTopoImageView.startAnimation(animation);
//                chatMensagens.setVisibility(View.VISIBLE);
//                chatAberto = true;
//            }
//        });
//
//        RecyclerView mensagensRecyclerView = findViewById(R.id.mensagensRecycler);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        mensagensRecyclerView.setLayoutManager(layoutManager);
//        mensagensRecyclerView.setHasFixedSize(true);
//        MensagensAdapter mensagensAdapter = new MensagensAdapter(mensagensList);
//        mensagensRecyclerView.setAdapter(mensagensAdapter);
//
//        final Spinner channelSpinner = findViewById(R.id.chatChannerSpinner);
//        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.chat_channel_array, android.R.layout.simple_spinner_item);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        channelSpinner.setAdapter(arrayAdapter);
//        channelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                mensagensReference.removeEventListener(valueEventListenerMensagens);
//
//                String channerSelected = (String) channelSpinner.getSelectedItem();
//
//                channer = channerSelected.equals("Vila") ? PersonagemOn.character.getVillage().name : "mundo";
//
//                mensagensReference = FirebaseConfig.getDatabase()
//                        .child("chat")
//                        .child(channer);
//
//                recuperarMensagens();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//
//        final EditText mensagemEditText = findViewById(R.id.mensagemEditText);
//        mensagemEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                String mensagem = mensagemEditText.getText().toString();
//
//                if (!mensagem.isEmpty()) {
//                    enviarMensagem(new Message(PersonagemOn.character.getNick(), mensagem));
//                    mensagemEditText.setText("");
//                }
//
//                return false;
//            }
//        });
//
//        FloatingActionButton floatingActionButton = findViewById(R.id.fabEnviarMensagem);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String mensagem = mensagemEditText.getText().toString();
//
//                if (!mensagem.isEmpty()) {
//                    enviarMensagem(new Message(PersonagemOn.character.getNick(), mensagem));
//                    mensagemEditText.setText("");
//                }
//            }
//        });
//    }


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

    public void showBag(View view) {
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

    public void atualizarInformacoes() {
//        if (PersonagemOn.character.isTemRecompensaFidelidade())
//            fidelidadeImageButton.setImageResource(R.drawable.layout_icones_gift);
//        else
        fidelidadeImageButton.setImageResource(R.drawable.layout_icones_gift2);

        TextView lvlAtual = headerView.findViewById(R.id.lvlAtualTextView);
        lvlAtual.setText(String.valueOf(PersonagemOn.character.getLevel()));

        TextView lvlNext = headerView.findViewById(R.id.lvlProxTextView);
        lvlNext.setText(String.valueOf(PersonagemOn.character.getLevel() + 1));

        TextView expTextView = headerView.findViewById(R.id.expTextView);
        expTextView.setText(String.format(Locale.getDefault(), "EXP: %d/%d", PersonagemOn.character.getExp(), PersonagemOn.character.getExpUpar()));

        ProgressBar expProgressBar = headerView.findViewById(R.id.expProgressBar);
        expProgressBar.setMax(PersonagemOn.character.getExpUpar());
        expProgressBar.setProgress(PersonagemOn.character.getExp());

        TextView ryous = headerView.findViewById(R.id.ryousTextView);
        ryous.setText(String.valueOf(PersonagemOn.character.getRyous()));

        TextView vidaTextView = headerView.findViewById(R.id.vidaTextView);
//        vidaTextView.setText(String.format(Locale.getDefault(), "%d/%d",
//                PersonagemOn.character.getAtributos().getFormulas().getCurrentHealth(),
//                PersonagemOn.character.getAtributos().getFormulas().getHealth()));
//
//        TextView chakraTextView = headerView.findViewById(R.id.chakraTextView);
//        chakraTextView.setText(String.format(Locale.getDefault(), "%d/%d",
//                PersonagemOn.character.getAtributos().getFormulas().getChakraAtual(),
//                PersonagemOn.character.getAtributos().getFormulas().getChakra()));
//
//        TextView staminaTextView = headerView.findViewById(R.id.staminaTextView);
//        staminaTextView.setText(String.format(Locale.getDefault(), "%d/%d",
//                PersonagemOn.character.getAtributos().getFormulas().getStaminaAtual(),
//                PersonagemOn.character.getAtributos().getFormulas().getStamina()));
//
//        ProgressBar vidaProgressBar = headerView.findViewById(R.id.vidaProgressBar);
//        vidaProgressBar.setMax(PersonagemOn.character.getAtributos().getFormulas().getHealth());
//        vidaProgressBar.setProgress(PersonagemOn.character.getAtributos().getFormulas().getCurrentHealth());
//
//        ProgressBar chakraProgressBar = headerView.findViewById(R.id.chakraProgressBar);
//        chakraProgressBar.setMax(PersonagemOn.character.getAtributos().getFormulas().getChakra());
//        chakraProgressBar.setProgress(PersonagemOn.character.getAtributos().getFormulas().getChakraAtual());
//
//        ProgressBar staminaProgressBar = headerView.findViewById(R.id.staminaProgressBar);
//        staminaProgressBar.setMax(PersonagemOn.character.getAtributos().getFormulas().getStamina());
//        staminaProgressBar.setProgress(PersonagemOn.character.getAtributos().getFormulas().getStaminaAtual());

        TextView classe = findViewById(R.id.classeTextView);
        classe.setText(String.valueOf(PersonagemOn.character.getClasse()));

        TextView vila = findViewById(R.id.vilaTextView);
        vila.setText(String.valueOf(PersonagemOn.character.getVillage()));

        TextView level = findViewById(R.id.levelTextView);
        level.setText(String.valueOf(PersonagemOn.character.getLevel()));

        buildMenu();
        menuAdapter.notifyDataSetChanged();
    }

    public void goMensageiro(View view) {
        FragmentUtil.goTo(this, new MensagensFragment());
        closeDrawer();
    }

    public void logout(View view) {
        deslogar();
    }

    public void goFidelidade(View view) {
        FragmentUtil.goTo(this, new FidelityFragment());
        closeDrawer();
    }

    private void deslogar() {
        AuthRepository.getInstance().signOut();
        startActivity(new Intent(PersonagemLogadoActivity.this, DeslogadoActivity.class));
        finish();
    }

    public void closeDrawer() {
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
//        recuperarPersonagemOn();
//        recuperarMensagens();
//
//        long millis = millis_DiversasRotinas;
//        startDiversasRotinasTimer(millis);
//
//        inicializarCounterHorasJogadas();

        PersonagemOn.character.setOnline(true);
        CharacterRepository.getInstance().saveCharacter(PersonagemOn.character);
    }

    private void inicializarCounterHorasJogadas() {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
//                PersonagemOn.character.setTotalHorasJogadas(PersonagemOn.character.getTotalHorasJogadas() + 1);
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        personagemOnReference.removeEventListener(valueEventListenerPersonagemOn);

        PersonagemOn.character.setOnline(false);
        PersonagemOn.character.setLastLogin(String.format(Locale.getDefault(), "%s às %s", DateCustom.getData(), DateCustom.getHorario()));
        CharacterRepository.getInstance().saveCharacter(PersonagemOn.character);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        PersonagemOn.character.setOnline(false);
        PersonagemOn.character.setLastLogin(String.format(Locale.getDefault(), "%s às %s", DateCustom.getData(), DateCustom.getHorario()));
        CharacterRepository.getInstance().saveCharacter(PersonagemOn.character);
    }

    private void buildMenu() {
        menuGroups.clear();
        sections.clear();

        menuGroups.add(new MenuGroup(R.string.user, R.drawable.layout_categorias_topo_3));
        menuGroups.add(new MenuGroup(R.string.character, R.drawable.layout_categorias_topo_4));
        menuGroups.add(new MenuGroup(R.string.academy, R.drawable.layout_categorias_topo_7));
        menuGroups.add(new MenuGroup(R.string.current_village, R.drawable.layout_categorias_topo_1_11));
        menuGroups.add(new MenuGroup(R.string.battles, R.drawable.layout_categorias_topo_12));
        menuGroups.add(new MenuGroup(R.string.team, R.drawable.layout_categorias_topo_6));
        menuGroups.add(new MenuGroup(R.string.ranking, R.drawable.layout_categorias_topo_9));

        List<SectionFragment> fragments1 = new ArrayList<>();
        fragments1.add(new UserDataFragment());
        fragments1.add(new MensagensFragment());
        fragments1.add(new VipPlayerFragment());
        fragments1.add(new FormulasFragment());
        fragments1.add(new PasswordChangeFragment());
        fragments1.add(new CharacterCreateFragment());
        fragments1.add(new CharacterSelectFragment());
        fragments1.add(new SuporteFragment());

        List<SectionFragment> fragments2 = new ArrayList<>();
        fragments2.add(new CharacterStatusFragment());
        fragments2.add(new ClansFragment());
        fragments2.add(new NinjaLuckyFragment());
        fragments2.add(new FidelityFragment());

        List<SectionFragment> fragments3 = new ArrayList<>();
        fragments3.add(new GraduacoesFragment());
        fragments3.add(new AcademiaTreinamentoFragment());
        fragments3.add(new PersonagemJutsuFragment()); // talvez
        fragments3.add(new AcademiaJustuFragment());

        List<SectionFragment> fragments5 = new ArrayList<>();
        fragments5.add(new LicoesFragment());
        fragments5.add(new MissoesEsperaFragment());
        fragments5.add(new MapaVilaFragment());
        fragments5.add(new MissoesFragment());
        fragments5.add(new RamenShopFragment());
        fragments5.add(new NinjaShopFragment());

        List<SectionFragment> fragments6 = new ArrayList<>();
        fragments6.add(new DojoFragment());
        fragments6.add(new ArenaFragment());
        fragments6.add(new LogBatalhaFragment());

        List<SectionFragment> fragments7 = new ArrayList<>();
        if (PersonagemOn.character.getTeam().equals("")) {
            fragments7.add(new EquipeParticiparFragment());
            fragments7.add(new EquipeCriarFragment());
        } else {
            fragments7.add(new EquipeDetalheFragment());
        }

        List<SectionFragment> fragments8 = new ArrayList<>();
        fragments8.add(new RankNinjasFragment());
        fragments8.add(new RankEquipesFragment());

        sections.put(0, fragments1);
        sections.put(1, fragments2);
        sections.put(2, fragments3);
        sections.put(3, fragments5);
        sections.put(4, fragments6);
        sections.put(5, fragments7);
        sections.put(6, fragments8);
    }
}
