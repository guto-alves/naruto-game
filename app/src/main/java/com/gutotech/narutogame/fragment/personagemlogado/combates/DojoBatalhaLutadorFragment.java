package com.gutotech.narutogame.fragment.personagemlogado.combates;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.adapter.JutsusAdapter;
import com.gutotech.narutogame.config.Storage;
import com.gutotech.narutogame.helper.RecyclerItemClickListener;
import com.gutotech.narutogame.model.Formulas;
import com.gutotech.narutogame.model.Jutsu;
import com.gutotech.narutogame.model.Personagem;
import com.gutotech.narutogame.model.NPC;
import com.gutotech.narutogame.model.PersonagemOn;

import java.util.Locale;

public class DojoBatalhaLutadorFragment extends Fragment {
    private ImageView statusOpoImageView;
    private ProgressBar hpOpoProgressBar;
    private TextView hpOpoTextView;
    private ProgressBar chakraOpoProgressBar;
    private TextView chakraOpoTextView;
    private ProgressBar staminaOpoProgressBar;
    private TextView staminaOpoTextView;
    private Formulas npcFormulas;

    private Personagem player;
    private ImageView statusPlayerImageView;
    private ProgressBar hpPlayerProgressBar;
    private TextView hpPlayerTextView;
    private ProgressBar chakraPlayerProgressBar;
    private TextView chakraPlayerTextView;
    private ProgressBar staminaPlayerProgressBar;
    private TextView staminaPlayerTextView;
    private Formulas playerFormulas;

    private RecyclerView meusJutsusRecyclerView;

    private RecyclerView logCombateRecycler;

    private TextView timerTextView;
    private final long TEMPO_PARA_ATACAR = 30000;
    CountDownTimer countDownTimer;
    private TextView vezDeQuemTextView;

    private JutsusAdapter jutsusAdapter;

    private enum Status {GANHOU, PERDEU, EMPATOU, CONTINUA}

    private Status LUTA_STATUS = Status.CONTINUA;

    private ConstraintLayout msgLinear2;
    private ImageView imagemMsg;
    private TextView titleMsg;
    private TextView messageMsg;
    private TextView linkMsg;
    private TextView textoParaLinkMsg;

    public DojoBatalhaLutadorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dojo_batalha_lutador, container, false);
        TextView tituloSecao = getActivity().findViewById(R.id.tituloSecaoTextView);
        tituloSecao.setText("DESAFIO DOJO");

        // CONFIGURA NPC
        npcFormulas = NPC.npc.getAtributos().getFormulas();
        statusOpoImageView = view.findViewById(R.id.statusOpoImageView);
        statusOpoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirStatus(v, npcFormulas);
            }
        });
        ImageView profileOpoImageView = view.findViewById(R.id.profileOpoImageView);
        Storage.baixarProfile(getActivity(), profileOpoImageView, NPC.npc.getIdProfile(), NPC.npc.getFotoAtual());

        TextView nickOpoTextView = view.findViewById(R.id.nickOpoTextView);
        nickOpoTextView.setText(NPC.npc.getNick());
        TextView graduELvlOpoTextView = view.findViewById(R.id.gradELvlOpoTextView);
        graduELvlOpoTextView.setText(String.format(Locale.getDefault(), "-- - Lvl %d", NPC.npc.getLevel()));

        hpOpoProgressBar = view.findViewById(R.id.hpOpoProgressBar);
        hpOpoProgressBar.setMax(npcFormulas.getVidaAtual());
        hpOpoTextView = view.findViewById(R.id.hpOpoTextView);
        chakraOpoProgressBar = view.findViewById(R.id.chakraOpoProgressBar);
        chakraOpoProgressBar.setMax(npcFormulas.getChakraAtual());
        chakraOpoTextView = view.findViewById(R.id.chakraOpoTextView);
        staminaOpoProgressBar = view.findViewById(R.id.staminaOpoProgressBar);
        staminaOpoProgressBar.setMax(npcFormulas.getStaminaAtual());
        staminaOpoTextView = view.findViewById(R.id.staminaOpoTextView);

        // CONFIGURA PLAYER
        player = PersonagemOn.personagem;
        playerFormulas = PersonagemOn.personagem.getAtributos().getFormulas();
        statusPlayerImageView = view.findViewById(R.id.statusMeImageView);
        statusPlayerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirStatus(v, playerFormulas);
            }
        });
        ImageView profilePlayerImageView = view.findViewById(R.id.profileMeImageView);
        Storage.baixarProfile(getActivity(), profilePlayerImageView, player.getIdProfile(), player.getFotoAtual());

        TextView nickPlayerTextView = view.findViewById(R.id.nickMeTextView);
        nickPlayerTextView.setText(player.getNick());
        TextView graduELvlPlayerTextView = view.findViewById(R.id.gradELvlMeTextView);
        graduELvlPlayerTextView.setText(String.format(Locale.getDefault(), "%s - Lvl %d", player.getGraducao(), player.getLevel()));

        hpPlayerProgressBar = view.findViewById(R.id.hpMeProgressBar);
        hpPlayerProgressBar.setMax(player.getAtributos().getFormulas().getVidaAtual());
        hpPlayerTextView = view.findViewById(R.id.hpMeTextView);
        chakraPlayerProgressBar = view.findViewById(R.id.chakraMeProgressBar);
        chakraPlayerProgressBar.setMax(playerFormulas.getChakraAtual());
        chakraPlayerTextView = view.findViewById(R.id.chakraMeTextView);
        staminaPlayerProgressBar = view.findViewById(R.id.staminaMeProgressBar);
        staminaPlayerProgressBar.setMax(playerFormulas.getStaminaAtual());
        staminaPlayerTextView = view.findViewById(R.id.staminaMeTextView);

        atualizarLuta();

        meusJutsusRecyclerView = view.findViewById(R.id.meusJutsusRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        meusJutsusRecyclerView.setLayoutManager(layoutManager);
        meusJutsusRecyclerView.setHasFixedSize(true);
        jutsusAdapter = new JutsusAdapter(getActivity(), player.getJutsus());
        meusJutsusRecyclerView.setAdapter(jutsusAdapter);
        meusJutsusRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getActivity(), meusJutsusRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                countDownTimer.cancel();

                realizarAtaques(player.getJutsus().get(position), NPC.atacar());
                atualizarLuta();
                atualizarStatusLuta();

                if (LUTA_STATUS != Status.CONTINUA) {

                    if (LUTA_STATUS == Status.GANHOU) {
                        titleMsg.setText("COMBATE ENCERRADO!");
                        messageMsg.setText("Parabéns! Você venceu o combate!Como recompensa você estará recebendo RY$ 0 e 315 pontos de experiência");
                        textoParaLinkMsg.setText("Voltar ao ");
                        linkMsg.setText("Dojo");
                        linkMsg.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                changeToFragment(new DojoFragment());
                            }
                        });
                    } else if (LUTA_STATUS == Status.PERDEU) {
                        titleMsg.setText("QUE PENA!");
                        messageMsg.setText("Você perdeu o combate.");
                        textoParaLinkMsg.setText("Ir para o ");
                        linkMsg.setText("Hospital");
                        linkMsg.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                changeToFragment(new HospitalQuartoFragment());
                            }
                        });
                    } else if (LUTA_STATUS == Status.EMPATOU) {
                        titleMsg.setText("EMPATES!");
                        messageMsg.setText("Por ambos estarem muito cansados, o combate terminou em empate!");
                        textoParaLinkMsg.setText("Ir para o ");
                        linkMsg.setText("Hospital");
                        linkMsg.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                changeToFragment(new HospitalQuartoFragment());
                            }
                        });
                    }

                    finalizarLuta();
                }

                startTimer();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                exibirJutsu(view, position);
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        }
        ));

        logCombateRecycler = view.findViewById(R.id.logCombateRecycler);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        logCombateRecycler.setLayoutManager(layoutManager);
        logCombateRecycler.setHasFixedSize(true);
        //logCombateRecycler.setAdapter();

        // Configura msg
        msgLinear2 = view.findViewById(R.id.msgConstraint2);
        imagemMsg = view.findViewById(R.id.imagemMsg2);
        titleMsg = view.findViewById(R.id.msgTitleTextView2);
        messageMsg = view.findViewById(R.id.msgMensagem2);
        linkMsg = view.findViewById(R.id.linkTextView);
        textoParaLinkMsg = view.findViewById(R.id.textoParaLinkTextView);

        timerTextView = view.findViewById(R.id.countDownTimer);

        vezDeQuemTextView = view.findViewById(R.id.vezDeQuemTextView);
        vezDeQuemTextView.setText("Aguardando a sua ação");

        startTimer();
        return view;
    }

    private void realizarAtaques(Jutsu acaoPlayer, Jutsu acaoNpc) {
        int ataquePlayer = 0;
        int ataqueNpc = 0;

        if (player.getClasse().equals("Ninjutsu") || player.getClasse().equals("Genjutsu")) {
            if (acaoPlayer.getTipo().equals("atk") && acaoNpc.getTipo().equals("atk")) {
                ataquePlayer = (acaoPlayer.getAtkNinGen() + playerFormulas.getAtkNinGen()) - npcFormulas.getDefNinGen();
                ataqueNpc = (acaoNpc.getAtkNinGen() + npcFormulas.getAtkNinGen()) - playerFormulas.getDefNinGen();
            } else if (acaoPlayer.getTipo().equals("atk") && acaoNpc.getTipo().equals("def"))
                ataquePlayer = (playerFormulas.getAtkNinGen() + acaoPlayer.getAtkNinGen()) - (npcFormulas.getDefNinGen() - acaoNpc.getDefesa_base());
            else if (acaoPlayer.getTipo().equals("def") && acaoNpc.getTipo().equals("atk"))
                ataqueNpc = (npcFormulas.getAtkNinGen() + acaoPlayer.getAtkNinGen()) - (playerFormulas.getDefNinGen() - acaoPlayer.getDefesa_base());
        } else {
            if (acaoPlayer.getTipo().equals("atk") && acaoNpc.getTipo().equals("atk")) {
                ataquePlayer = (acaoPlayer.getAtkTaiBuk() + playerFormulas.getAtkTaiBuki()) - npcFormulas.getDefTaiBuki();
                ataqueNpc = (acaoNpc.getAtkTaiBuk() + npcFormulas.getAtkTaiBuki()) - playerFormulas.getDefTaiBuki();
            } else if (acaoPlayer.getTipo().equals("atk") && acaoNpc.getTipo().equals("def"))
                ataquePlayer = (playerFormulas.getAtkTaiBuki() + acaoPlayer.getAtkTaiBuk()) - (npcFormulas.getDefTaiBuki() - acaoNpc.getDefesa_base());
            else if (acaoPlayer.getTipo().equals("def") && acaoNpc.getTipo().equals("atk"))
                ataqueNpc = (npcFormulas.getAtkTaiBuki() + acaoPlayer.getAtkTaiBuk()) - (playerFormulas.getDefTaiBuki() - acaoPlayer.getDefesa_base());
        }

        playerFormulas.setVidaAtual(playerFormulas.getVidaAtual() - ataqueNpc);
        playerFormulas.setChakraAtual(playerFormulas.getChakraAtual() - acaoPlayer.getConsomeChakra());
        playerFormulas.setStaminaAtual(playerFormulas.getStaminaAtual() - acaoPlayer.getConsomeStamina());

        npcFormulas.setVidaAtual(npcFormulas.getVidaAtual() - ataquePlayer);
        npcFormulas.setChakraAtual(npcFormulas.getChakraAtual() - acaoNpc.getConsomeChakra());
        npcFormulas.setStaminaAtual(npcFormulas.getStaminaAtual() - acaoNpc.getConsomeStamina());
    }

    private void atualizarLuta() {
        hpPlayerProgressBar.setProgress(playerFormulas.getVidaAtual());
        hpPlayerTextView.setText(String.format(Locale.getDefault(), "Vida: %d", playerFormulas.getVidaAtual()));
        chakraPlayerProgressBar.setProgress(playerFormulas.getChakraAtual());
        chakraPlayerTextView.setText(String.format(Locale.getDefault(), "Chakra: %d", playerFormulas.getChakraAtual()));
        staminaPlayerProgressBar.setProgress(playerFormulas.getStaminaAtual());
        staminaPlayerTextView.setText(String.format(Locale.getDefault(), "Stamina: %d", playerFormulas.getStaminaAtual()));

        hpOpoProgressBar.setProgress(npcFormulas.getVidaAtual());
        hpOpoTextView.setText(String.format(Locale.getDefault(), "Vida: %d", npcFormulas.getVidaAtual()));
        chakraOpoProgressBar.setProgress(npcFormulas.getChakraAtual());
        chakraOpoTextView.setText(String.format(Locale.getDefault(), "Chakra: %d", npcFormulas.getChakraAtual()));
        staminaOpoProgressBar.setProgress(npcFormulas.getStaminaAtual());
        staminaOpoTextView.setText(String.format(Locale.getDefault(), "Stamina: %d", npcFormulas.getStaminaAtual()));
    }

    private void atualizarStatusLuta() {
        if ((npcFormulas.getVidaAtual() < 10 || npcFormulas.getChakraAtual() < 10 || npcFormulas.getStaminaAtual() < 10)
                && playerFormulas.getVidaAtual() < 10 || playerFormulas.getChakraAtual() < 10 || playerFormulas.getStaminaAtual() < 10)
            LUTA_STATUS = Status.EMPATOU;
        else if (npcFormulas.getVidaAtual() < 10 || npcFormulas.getChakraAtual() < 10 || npcFormulas.getStaminaAtual() < 10)
            LUTA_STATUS = Status.GANHOU;
        else if (playerFormulas.getVidaAtual() < 10 || playerFormulas.getChakraAtual() < 10 || playerFormulas.getStaminaAtual() < 10)
            LUTA_STATUS = Status.PERDEU;
        else
            LUTA_STATUS = Status.CONTINUA;
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(TEMPO_PARA_ATACAR, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int minutos = (int) millisUntilFinished / 1000 / 60;
                int segundos = (int) millisUntilFinished / 1000 % 60;
                timerTextView.setText(String.format(Locale.getDefault(), "%02d:%02d", minutos, segundos));
            }

            @Override
            public void onFinish() {
                timerTextView.setText("--:--");

                if (LUTA_STATUS == Status.CONTINUA) {
                    playerFormulas.setVidaAtual(0);
                    hpPlayerProgressBar.setProgress(0);
                    hpPlayerTextView.setText("Vida: 0");

                    titleMsg.setText("OPS!");
                    messageMsg.setText("Por ficar muito tempo sem efetuar nenhuma ação, você perdeu o combate!");
                    textoParaLinkMsg.setText("Ir para o ");
                    linkMsg.setText("Hospital");
                    linkMsg.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            changeToFragment(new HospitalQuartoFragment());
                        }
                    });

                    LUTA_STATUS = Status.PERDEU;

                    finalizarLuta();
                }
            }
        }.start();
    }

    private void finalizarLuta() {
        NPC.npc = null;
        meusJutsusRecyclerView.setVisibility(View.INVISIBLE);
        msgLinear2.setVisibility(View.VISIBLE);

        if (LUTA_STATUS == Status.GANHOU) {
            PersonagemOn.personagem.getResumoCombates().setVitNPC(PersonagemOn.personagem.getResumoCombates().getVitNPC() + 1);
            PersonagemOn.personagem.setExpAtual(PersonagemOn.personagem.getExpAtual() + 315);

        } else if (LUTA_STATUS == Status.PERDEU) {
            PersonagemOn.personagem.getResumoCombates().setDerNPC(PersonagemOn.personagem.getResumoCombates().getDerNPC() + 1);
        } else
            PersonagemOn.personagem.getResumoCombates().setEmpNPC(PersonagemOn.personagem.getResumoCombates().getEmpNPC() + 1);

        PersonagemOn.personagem.setCombatesNPCDiarios(PersonagemOn.personagem.getCombatesNPCDiarios() + 1);

        PersonagemOn.personagem.salvar();
    }

    private void exibirStatus(View view, Formulas formulas) {
        PopupMenu menu = new PopupMenu(getActivity(), view);

        menu.getMenu().add("Resumo dos Atributos");
        menu.getMenu().add("Ataque ( Tai / Buk ): %d");
        menu.getMenu().add("Ataque ( Nin / Gen ): %d");
        menu.getMenu().add("Defesa ( Tai / Buk ): %d");
        menu.getMenu().add("Defesa ( Nin / Gen ): %d");
        menu.getMenu().add("Precisão: %d");
        menu.getMenu().add("Determinação: %d %%");
        menu.getMenu().add("Percepção: %d %% ( 0 %% - 0 %% ) ");
        menu.getMenu().add("Incremento de Absorção: 11.25%%");
        menu.getMenu().add("Concentração: %d %% ( 0 %% - 0 %% )");
        menu.getMenu().add("Incremento de Crítico: 11.25%%");
        menu.getMenu().add("Esquiva: %,.2f%");
                /*
                 npcFormulas.getAtkTaiBuki(), npcFormulas.getAtkNinGen(),
                        npcFormulas.getDefTaiBuki(), npcFormulas.getDefNinGen(),
                        npcFormulas.getPrecisao(), npcFormulas.getDeterminacao(),
                        npcFormulas.getConviccao(), npcFormulas.getPercepcao(),
                        npcFormulas.getConcentracao(), npcFormulas.getEsquiva()
                 */
        menu.show();
    }

    @SuppressLint("RestrictedApi")
    private void exibirJutsu(View view, int position) {
        MenuBuilder menuBuilder = new MenuBuilder(getActivity());
        MenuInflater menuInflater = new MenuInflater(getActivity());
        menuInflater.inflate(R.menu.pop_menu_jutsu, menuBuilder);

        MenuPopupHelper optionsMenu = new MenuPopupHelper(getActivity(), menuBuilder, view);
        optionsMenu.setForceShowIcon(true);

        Jutsu jutsu = PersonagemOn.personagem.getJutsus().get(position);
        menuBuilder.findItem(R.id.nomeJutsu).setTitle(String.format("%s       x%d", jutsu.getNome(), jutsu.getQuantidade()));
        menuBuilder.findItem(R.id.atkOuDefJutsu).setTitle(String.format("%s       x%d", jutsu.getNome(), jutsu.getQuantidade()));
        menuBuilder.findItem(R.id.precisaoJutsu).setTitle(String.format("Precisão: %d%%", jutsu.getPrecisao()));
        menuBuilder.findItem(R.id.intervaloJutsu).setTitle(String.format("Intervalo de uso: %d turno(s)", jutsu.getIntervaloDeUso()));
        menuBuilder.findItem(R.id.consomeChakraJutsu).setTitle(String.format("Consome: %d", jutsu.getConsomeChakra()));
        menuBuilder.findItem(R.id.consomeStaminaJutsu).setTitle(String.format("Consome: %d", jutsu.getConsomeStamina()));
        optionsMenu.show();
    }

    private void changeToFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment).commit();
    }
}
