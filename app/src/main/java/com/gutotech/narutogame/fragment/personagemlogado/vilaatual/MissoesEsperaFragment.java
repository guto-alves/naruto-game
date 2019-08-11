package com.gutotech.narutogame.fragment.personagemlogado.vilaatual;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.fragment.personagemlogado.personagem.PersonagemStatusFragment;
import com.gutotech.narutogame.model.Missao;
import com.gutotech.narutogame.model.MissaoDeTempo;
import com.gutotech.narutogame.model.Personagem;
import com.gutotech.narutogame.model.Tarefa;
import com.gutotech.narutogame.publicentities.PersonagemOn;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MissoesEsperaFragment extends Fragment {
    private ConstraintLayout msgMissaoEspera;
    private Button cancelarMissaoButton;
    private TextView tempoConclusaoTextView;
    private CountDownTimer timer;

    private ConstraintLayout msgMissaoConcluida;
    private TextView expRecompensaTextView;
    private TextView ryRecompensaTextView;
    private Button finalizarMissaoButton;

    private Missao missao;

    public MissoesEsperaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_missoes_espera, container, false);

        missao = PersonagemOn.personagem.getMissaoAtual();


        msgMissaoConcluida = view.findViewById(R.id.msgConstraint2);
        expRecompensaTextView = view.findViewById(R.id.expRecompensaTextView);
        ryRecompensaTextView = view.findViewById(R.id.ryRecompensaTextView);
        finalizarMissaoButton = view.findViewById(R.id.finalizarMissaoButton);

        msgMissaoEspera = view.findViewById(R.id.msgConstraint1);
        tempoConclusaoTextView = view.findViewById(R.id.tempoConclusaoTextView);
        cancelarMissaoButton = view.findViewById(R.id.cancelarMissaoButton);

        if (missao. () >= 0){
            mudarTituloSecao("STATUS DA MISSÃO");

            TextView tituloTarefa = view.findViewById(R.id.msgTitleTextView);
            tituloTarefa.setText(missao.getTitulo());

            TextView descricaoTarefa = view.findViewById(R.id.msgMensagem);
            descricaoTarefa.setText(missao.getDescricao());

            cancelarMissaoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Naruto Game diz:");
                    builder.setMessage("Você que realmente cancelar essa missão ? Todo o seu tempo gasto até agora será perdido.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            PersonagemOn.personagem.setEmMissao(false);
                            PersonagemOn.personagem.setMissaoAtual(null);
                            PersonagemOn.personagem.salvar();
                            mudarTituloSecao("STATUS DO PERSONAGEM");
                            changeToFragment(new PersonagemStatusFragment());
                        }
                    });
                    builder.setNegativeButton("Cancelar", null);
                    builder.create().show();
                }
            });

            startTimer();
        } else
        configurarMsgMissaoConcluida();

        return view;
    }

    private void startTimer() {
        timer = new CountDownTimer(missao.getMillisDuracao(), 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                PersonagemOn.personagem.getMissaoAtual().setMillisDuracao(millisUntilFinished);
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
                PersonagemOn.personagem.setEmMissao(false);
                PersonagemOn.personagem.setExpAtual(PersonagemOn.personagem.getExpAtual() + missao.getExpRecompensa());
                PersonagemOn.personagem.setRyous(PersonagemOn.personagem.getRyous() + (long) missao.getRyousRecompensa());

                List<Integer> tarefasConcluidas = PersonagemOn.personagem.getTarefasConcluidas();
                if (tarefasConcluidas == null)
                    tarefasConcluidas = new ArrayList<>();

                tarefasConcluidas.add(missao.getId());

                PersonagemOn.personagem.setTarefasConcluidas(tarefasConcluidas);

                PersonagemOn.personagem.setMissaoAtual(null);
                PersonagemOn.personagem.salvar();
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
    public void onStop() {
        super.onStop();
        timer.cancel();
        PersonagemOn.personagem.salvar();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
        PersonagemOn.personagem.salvar();
    }
}
