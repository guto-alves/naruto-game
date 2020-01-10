package com.gutotech.narutogame.ui.onlinecharacter.vilaatual;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.onlinecharacter.personagem.PersonagemStatusFragment;
import com.gutotech.narutogame.data.model.MissaoDeTempo;
import com.gutotech.narutogame.data.model.PersonagemOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MissoesEsperaFragment extends Fragment {
    private ConstraintLayout msgMissaoEspera;
    private TextView tituloMissao;
    private TextView descricaoMissao;
    private Button cancelarMissaoButton;
    private TextView tempoConclusaoTextView;
    private CountDownTimer timer;

    private ConstraintLayout msgMissaoConcluida;
    private TextView expRecompensaTextView;
    private TextView ryRecompensaTextView;
    private Button finalizarMissaoButton;

    private MissaoDeTempo missao;

    private boolean esperandoFinalizar;

    public MissoesEsperaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_missoes_espera, container, false);

        missao = PersonagemOn.character.getMissaoDeTempo();

        msgMissaoEspera = view.findViewById(R.id.msgConstraint1);
        tituloMissao = view.findViewById(R.id.msgTitleTextView);
        descricaoMissao = view.findViewById(R.id.msgMensagem);
        tempoConclusaoTextView = view.findViewById(R.id.tempoConclusaoTextView);
        cancelarMissaoButton = view.findViewById(R.id.cancelarMissaoButton);

        msgMissaoConcluida = view.findViewById(R.id.msgConstraint2);
        expRecompensaTextView = view.findViewById(R.id.expRecompensaTextView);
        ryRecompensaTextView = view.findViewById(R.id.ryRecompensaTextView);
        finalizarMissaoButton = view.findViewById(R.id.finalizarMissaoButton);

        return view;
    }

    private void startTimer() {
        timer = new CountDownTimer(missao.getMillisDuracao(), 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                missao.setMillisDuracao(millisUntilFinished);
                int horas = (int) millisUntilFinished / 1000 / 60 / 60;
                int minutos = (int) millisUntilFinished / 1000 / 60;
                int segundos = (int) millisUntilFinished / 1000 % 60;
                tempoConclusaoTextView.setText(String.format(Locale.getDefault(), "Conclusão da missão em: %02d:%02d:%02d", horas, minutos, segundos));
            }

            @Override
            public void onFinish() {
                configurarMsgMissaoConcluida();
            }
        }.start();
    }

    private void configurarMsgMissaoEspera() {
        mudarTituloSecao("STATUS DA MISSÃO");
        tituloMissao.setText(missao.getTitulo());
        descricaoMissao.setText(missao.getDescricao());

        cancelarMissaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Naruto Game diz:");
                builder.setMessage("Você que realmente cancelar essa missão ? Todo o seu tempo gasto até agora será perdido.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PersonagemOn.character.setEmMissao(false);
                        PersonagemOn.character.setMissaoDeTempo(null);
                        PersonagemOn.character.salvar();
                        mudarTituloSecao("STATUS DO PERSONAGEM");
                        changeToFragment(new PersonagemStatusFragment());
                    }
                });
                builder.setNegativeButton("Cancelar", null);
                builder.create().show();
            }
        });
    }

    private void configurarMsgMissaoConcluida() {
        mudarTituloSecao("MISSÃO CONCLUÍDA");
        msgMissaoEspera.setVisibility(View.GONE);
        cancelarMissaoButton.setVisibility(View.GONE);

        expRecompensaTextView.setText(String.valueOf(missao.getExpRecompensa()));
        ryRecompensaTextView.setText(String.format(Locale.getDefault(), "RY$ %,.2f", missao.getRyousRecompensa()));
        msgMissaoConcluida.setVisibility(View.VISIBLE);

        finalizarMissaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonagemOn.character.setEmMissao(false);
                PersonagemOn.character.setExpAtual(PersonagemOn.character.getExpAtual() + missao.getExpRecompensa());
                PersonagemOn.character.setRyous(PersonagemOn.character.getRyous() + (long) missao.getRyousRecompensa());

                if (missao.getRank().equals("tarefa")) {
                    List<Integer> tarefasConcluidas = PersonagemOn.character.getTarefasConcluidas();

                    if (tarefasConcluidas == null)
                        tarefasConcluidas = new ArrayList<>();

                    tarefasConcluidas.add(missao.getId());
                    PersonagemOn.character.setTarefasConcluidas(tarefasConcluidas);

                    PersonagemOn.character.getResumoMissoes().setTarefas(PersonagemOn.character.getResumoMissoes().getTarefas() + 1);

                } else if (missao.getRank().equals("D")) {
                    PersonagemOn.character.getResumoMissoes().setRankD(PersonagemOn.character.getResumoMissoes().getRankD() + 1);

                } else if (missao.getRank().equals("C")) {
                    PersonagemOn.character.getResumoMissoes().setRankC(PersonagemOn.character.getResumoMissoes().getRankC() + 1);

                } else if (missao.getRank().equals("B")) {
                    PersonagemOn.character.getResumoMissoes().setRankB(PersonagemOn.character.getResumoMissoes().getRankB() + 1);

                } else if (missao.getRank().equals("A")) {
                    PersonagemOn.character.getResumoMissoes().setRankA(PersonagemOn.character.getResumoMissoes().getRankA() + 1);

                } else if (missao.getRank().equals("S")) {
                    PersonagemOn.character.getResumoMissoes().setRankS(PersonagemOn.character.getResumoMissoes().getRankS() + 1);
                }

                PersonagemOn.character.setMissaoDeTempo(null);
                PersonagemOn.character.salvar();
                changeToFragment(new PersonagemStatusFragment());
            }
        });
    }

    private void mudarTituloSecao(String titulo) {
        TextView tituloSecao = getActivity().findViewById(R.id.tituloSecaoTextView);
        tituloSecao.setText(titulo);
    }

    private void changeToFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment);
        transaction.commit();
    }

    @Override
    public void onStart() {
        super.onStart();

        missao.setMillisStopped(missao.getMillisStopped() > 0 ? System.currentTimeMillis() - missao.getMillisStopped() : 0);

        if (missao.getMillisStopped() > missao.getMillisDuracao()) {
            missao.setMillisDuracao(0);
            configurarMsgMissaoConcluida();
            esperandoFinalizar = true;
        } else {
            configurarMsgMissaoEspera();
            missao.setMillisDuracao(missao.getMillisDuracao() - missao.getMillisStopped());
            missao.setMillisStopped(0);
            startTimer();
            esperandoFinalizar = false;
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        if (!esperandoFinalizar) {
            timer.cancel();
            missao.setMillisStopped(System.currentTimeMillis());
            PersonagemOn.character.salvar();
        }
    }
}
