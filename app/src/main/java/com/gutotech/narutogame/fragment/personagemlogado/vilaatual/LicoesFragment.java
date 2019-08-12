package com.gutotech.narutogame.fragment.personagemlogado.vilaatual;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.model.MissaoDeTempo;
import com.gutotech.narutogame.myinterface.MyListener;
import com.gutotech.narutogame.adapter.MissaoTempoAdapter;
import com.gutotech.narutogame.publicentities.PersonagemOn;

import java.util.ArrayList;
import java.util.List;

public class LicoesFragment extends Fragment implements MyListener {
    private List<MissaoDeTempo> tarefas = new ArrayList<>();

    public LicoesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_licoes, container, false);

        RecyclerView tarefasRecyclerView = view.findViewById(R.id.tarefasRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        tarefasRecyclerView.setLayoutManager(layoutManager);
        tarefasRecyclerView.setHasFixedSize(true);
        carregarTarefas();
        MissaoTempoAdapter adapter = new MissaoTempoAdapter(getActivity(), tarefas);
        tarefasRecyclerView.setAdapter(adapter);

        return view;
    }

    private void carregarTarefas() {
        tarefas.add(new MissaoDeTempo(1, "Primeira Lição",
                "Seja bem vindo estudante. Hoje vamos dar início a sua vida como ninja. Se você realmente deseja se tornar um dos melhores ninjas do seu vilarejo terá que estudar muito e praticar bastante. Comece a estudar desde já e siga os passos necessários para se tornar um Genin.",
                PersonagemOn.personagem.getGraducao(), 1, "tarefa", "", "", this, 60000, 800, 25));

        tarefas.add(new MissaoDeTempo(2, "Segunda Lição",
                "Quem disse que sua caminhada para se tornar um Shinobi seria fácil? Você ainda tem muito que aprender, vá para a segunda lição.",
                PersonagemOn.personagem.getGraducao(), 1, "tarefa", "", "", this, 60000, 800, 25));

        tarefas.add(new MissaoDeTempo(3, "Terceira Lição",
                "Você esta indo bem! Mais algumas lições e quem sabe você pode se tornar um Genin. Continue sua árdua jornada de sucesso.",
                PersonagemOn.personagem.getGraducao(), 2, "tarefa", "", "", this, 60000, 1000, 25));

        tarefas.add(new MissaoDeTempo(4, "Quarta Lição",
                "Parabéns, você esta indo muito bem, esta aprendendo rápido e logo se tornará um grande ninja! Continue estudando.",
                PersonagemOn.personagem.getGraducao(), 2, "tarefa", "", "", this, 60000, 1000, 25));

        tarefas.add(new MissaoDeTempo(5, "Quinta Lição",
                "Treinar é tudo. Um ninja que não treina possui a mente e o corpo fracos. Você precisa treinar suas habilidades sempre que puder. Continue aprendendo, ler também faz parte do seu aprendizado.",
                PersonagemOn.personagem.getGraducao(), 3, "tarefa", "", "", this, 60000, 1200, 25));

        tarefas.add(new MissaoDeTempo(6, "Sexta Lição",
                "Você esta perto de se tornar um Genin, mas para isso ainda falta completar algumas aulas. Seja paciente pois se tornar um \"Kage\" demora muitos anos pra se tornar o líder da vila. Quem sabe estudando bastante você não se torna o \"Kage\" da sua Vila.",
                PersonagemOn.personagem.getGraducao(), 3, "tarefa", "", "", this, 60000, 1200, 25));

        tarefas.add(new MissaoDeTempo(7, "Sétima Lição",
                "Para se tornar um dos melhores ninjas você deve também ser educado com os seus companheiros, respeitar o próximo e ajudar sempre. Esses também são passos importantes na sua caminhada para se tornar um Ninja.",
                PersonagemOn.personagem.getGraducao(), 4, "tarefa", "", "", this, 60000, 1400, 25));

        tarefas.add(new MissaoDeTempo(8, "Oitava Lição",
                "Quem diria! Há pouco tempo atrás você não passava de um simples estudante e agora esta perto de se tornar um Genin. Parabéns, você esta indo muito bem e falta pouco para se tornar um grande Ninja.",
                PersonagemOn.personagem.getGraducao(), 4, "tarefa", "", "", this, 60000, 1400, 25));

        tarefas.add(new MissaoDeTempo(9, "Nona Lição",
                "Posso ver que tem praticado bastante e, com isso, tem se tornado mais forte. Você esta seguindo corretamente o caminho ninja e dentro de pouco tempo já estará recebendo sua bandana.",
                PersonagemOn.personagem.getGraducao(), 4, "tarefa", "", "", this, 60000, 1600, 25));

        tarefas.add(new MissaoDeTempo(10, "Décima Lição",
                "Como um velho Sensei, me emociona sempre quando um aluno se forma! Você passou por muitas coisas e superou todos os obstáculos. Agora não tenho mais nada a ensinar. Vamos fazer sua última lição e, com isso, você estará bem perto de se tornar um ninja. Continue praticando para o exame Genin. Treine suas habilidades o máximo que puder e muito em breve estará se tornando um Genin, recebendo então sua Bandana.",
                PersonagemOn.personagem.getGraducao(), 4, "tarefa", "", "", this, 60000, 1600, 25));

        if (PersonagemOn.personagem.getTarefasConcluidas() != null) {
            for (int idConcluida : PersonagemOn.personagem.getTarefasConcluidas()) {
                for (int i = 0; i < tarefas.size(); i++) {
                    if (tarefas.get(i).getId() == idConcluida) {
                        tarefas.remove(i);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void callback(int idMissao) {
        PersonagemOn.personagem.setEmMissao(true);
        PersonagemOn.personagem.setMissaoDeTempo(tarefas.get(idMissao));
        PersonagemOn.personagem.salvar();
        changeFragment(new MissoesEsperaFragment());
    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment);
        transaction.commit();
    }
}
