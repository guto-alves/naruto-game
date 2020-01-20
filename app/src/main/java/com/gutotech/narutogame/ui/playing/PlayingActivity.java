package com.gutotech.narutogame.ui.playing;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.databinding.ActivityPlayingBinding;
import com.gutotech.narutogame.ui.adapter.ChatMessageAdapter;
import com.gutotech.narutogame.ui.adapter.ExpandableLoggedinAdapter;
import com.gutotech.narutogame.ui.adapter.BagRamensItemAdapter;
import com.gutotech.narutogame.ui.loggedout.DeslogadoActivity;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.StorageUtil;
import com.gutotech.narutogame.ui.playing.character.FidelityFragment;
import com.gutotech.narutogame.ui.playing.user.MensagensFragment;
import com.gutotech.narutogame.utils.DateCustom;
import com.gutotech.narutogame.data.model.CharOn;

import java.util.Locale;

public class PlayingActivity extends AppCompatActivity {
    private ImageButton fidelityImageButton;

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

    private PlayingViewModel mViewModel;

    private ActivityPlayingBinding binding;

    private View headerView;

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PlayingViewModel.class);

        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_playing);

        binding.setLifecycleOwner(this);
        binding.setViewModel(mViewModel);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawerLayout);

        headerView = binding.navView.getHeaderView(0);

        fidelityImageButton = headerView.findViewById(R.id.goToNinjaFidelityImageButton);

        ImageView topoLogadoimageView = headerView.findViewById(R.id.topoLogadoImageView);
        StorageUtil.baixarTopoLogado(getApplicationContext(), topoLogadoimageView,
                CharOn.character.getNinja().getId());

        // Char settings
        StorageUtil.downloadProfile(getApplicationContext(), binding.profileImageView,
                CharOn.character.getNinja().getId(), CharOn.character.getProfile());

        TextView nickPersonagemOnTextView = findViewById(R.id.nickTextView);
        nickPersonagemOnTextView.setText(CharOn.character.getNick());

        binding.bagImageView.setOnClickListener(this::showBag);

        // Menu settings
        ExpandableLoggedinAdapter menuAdapter = new ExpandableLoggedinAdapter();
        binding.expandableListView.setAdapter(menuAdapter);
        mViewModel.getMenuGroups().observe(this, menuAdapter::setMenuGroups);
        binding.expandableListView.setOnChildClickListener(mViewModel.getOnChildClickListener());


//        rotinasDialog = new Dialog(this);
//        rotinasDialog.setContentView(R.layout.dialog_rotinas_do_jogo);
//        rotinasDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        heallingTextView = rotinasDialog.findViewById(R.id.heallingTextView);
//        rankNinjaTextView = rotinasDialog.findViewById(R.id.rankNinjaTextView);
//        diversasRotinasTextView = rotinasDialog.findViewById(R.id.diversasRotinasTextView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mViewModel.getCurrentSection().observe(this, sectionFragment -> {
            FragmentUtil.goTo(this, (Fragment) sectionFragment);
            closeDrawer();
        });

        setUpChat();
    }

    private void setUpChat() {
        mViewModel.getStartChatAnimationEvent().observe(this, openChat -> {
            Animation animation;

            if (openChat) {
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                binding.chatLinearLayout.setVisibility(View.VISIBLE);
            } else {
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                binding.chatLinearLayout.setVisibility(View.GONE);
            }

            binding.chatTopImageView.startAnimation(animation);
        });

        binding.messagesRecyclerView.setHasFixedSize(true);
        ChatMessageAdapter adapter = new ChatMessageAdapter(this);
        binding.messagesRecyclerView.setAdapter(adapter);
        mViewModel.getChatMessages().observe(this, adapter::setMessageList);

        binding.messageEditText.setOnEditorActionListener((v, actionId, event) -> {
            mViewModel.onSendMessageButtonPressed();
            return false;
        });
    }

    public void showPopupRotinas(View view) {
//        rotinasDialog.show();
    }

    public void showBag(View view) {
        Dialog bagDialog = new Dialog(this);
        bagDialog.setContentView(R.layout.dialog_bag);

        RecyclerView ramensRecyclerView = bagDialog.findViewById(R.id.ramensRecyclerView);
        ramensRecyclerView.setHasFixedSize(true);
        ramensRecyclerView.setAdapter(new BagRamensItemAdapter(this));

        bagDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        bagDialog.show();
    }

    public void atualizarInformacoes() {
//        if (PersonagemOn.character.isTemRecompensaFidelidade())
//            fidelityImageButton.setImageResource(R.drawable.layout_icones_gift);
//        else
        fidelityImageButton.setImageResource(R.drawable.layout_icones_gift2);

        TextView lvlAtual = headerView.findViewById(R.id.lvlAtualTextView);
        lvlAtual.setText(String.valueOf(CharOn.character.getLevel()));

        TextView lvlNext = headerView.findViewById(R.id.lvlProxTextView);
        lvlNext.setText(String.valueOf(CharOn.character.getLevel() + 1));

        TextView expTextView = headerView.findViewById(R.id.expTextView);
        expTextView.setText(String.format(Locale.getDefault(), "EXP: %d/%d", CharOn.character.getExp(), CharOn.character.getExpUpar()));

        ProgressBar expProgressBar = headerView.findViewById(R.id.expProgressBar);
        expProgressBar.setMax(CharOn.character.getExpUpar());
        expProgressBar.setProgress(CharOn.character.getExp());

        TextView ryous = headerView.findViewById(R.id.ryousTextView);
        ryous.setText(String.valueOf(CharOn.character.getRyous()));

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
        classe.setText(String.valueOf(CharOn.character.getClasse()));

        TextView vila = findViewById(R.id.vilaTextView);
        vila.setText(String.valueOf(CharOn.character.getVillage()));

        TextView level = findViewById(R.id.levelTextView);
        level.setText(String.valueOf(CharOn.character.getLevel()));
    }

    public void goMensageiro(View view) {
        FragmentUtil.goTo(this, new MensagensFragment());
        closeDrawer();
    }

    public void logout(View view) {
        logout();
    }

    public void goFidelidade(View view) {
        FragmentUtil.goTo(this, new FidelityFragment());
        closeDrawer();
    }

    private void logout() {
        mViewModel.logout();
        startActivity(new Intent(PlayingActivity.this, DeslogadoActivity.class));
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

        CharOn.character.setOnline(true);
        CharacterRepository.getInstance().saveCharacter(CharOn.character);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
                diversasRotinasTextView.setText(String.format(Locale.getDefault(), "Diversas Rotinas: %s", DateCustom.getTime(millisUntilFinished)));
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}
