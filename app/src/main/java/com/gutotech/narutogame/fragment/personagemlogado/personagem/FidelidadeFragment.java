package com.gutotech.narutogame.fragment.personagemlogado.personagem;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.adapter.RecompensasFidelidadeAdapter;
import com.gutotech.narutogame.config.ConfigFirebase;
import com.gutotech.narutogame.config.Storage;
import com.gutotech.narutogame.model.Player;
import com.gutotech.narutogame.model.RecompensaFidelidade;
import com.gutotech.narutogame.myinterface.MyListener;
import com.gutotech.narutogame.model.PersonagemOn;

import java.util.ArrayList;
import java.util.List;

public class FidelidadeFragment extends Fragment implements MyListener {
    private List<RecompensaFidelidade> recompensas = new ArrayList<>();

    public FidelidadeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fidelidade, container, false);

        ImageView personagemMsgImageView = view.findViewById(R.id.personagemMsg);
        Storage.baixarImagemParaMsg(getActivity(), personagemMsgImageView, PersonagemOn.personagem.getNumVila());

        GridView recompensasReceberGridView = view.findViewById(R.id.recompensasReceberGridView);

        recompensas.add(new RecompensaFidelidade(RecompensaFidelidade.Tipo.RY, 100, "de Ryous", this));
        recompensas.add(new RecompensaFidelidade(RecompensaFidelidade.Tipo.EXP, 200, "de Experiência", this));
        recompensas.add(new RecompensaFidelidade(RecompensaFidelidade.Tipo.RY, 300, "de Ryous", this));
        recompensas.add(new RecompensaFidelidade(RecompensaFidelidade.Tipo.EXP, 400, "de Experiência", this));
        recompensas.add(new RecompensaFidelidade(RecompensaFidelidade.Tipo.RY, 1000, "de Ryous", this));
        recompensas.add(new RecompensaFidelidade(RecompensaFidelidade.Tipo.RAMEM, 5, "Shio Tyashu-Ramen", this));
        recompensas.add(new RecompensaFidelidade(RecompensaFidelidade.Tipo.PONTO_BIJUU, 5, "Pontos para o Sorteio de Bijuu", this));
        recompensas.add(new RecompensaFidelidade(RecompensaFidelidade.Tipo.CREDITO, 5, "Crédito VIP ( uma vez por conta )", this));

        RecompensasFidelidadeAdapter adapter = new RecompensasFidelidadeAdapter(getActivity(), recompensas);
        recompensasReceberGridView.setAdapter(adapter);

        return view;
    }

    @Override
    public void callback(int position) {
        final RecompensaFidelidade recompensa = recompensas.get(position);

        switch (recompensa.getTipo()) {
            case RY:
                PersonagemOn.personagem.setRyous(PersonagemOn.personagem.getRyous() + recompensa.getQuantidade());
                break;
            case EXP:
                PersonagemOn.personagem.setExpAtual(PersonagemOn.personagem.getExpAtual() + recompensa.getQuantidade());
                break;
            case RAMEM:
                break;
            case PONTO_BIJUU:
                break;
            case CREDITO:
                DatabaseReference playerReference = ConfigFirebase.getDatabase()
                        .child("player").child(ConfigFirebase.getAuth().getCurrentUser().getUid());
                playerReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Player player = dataSnapshot.getValue(Player.class);
                        player.setCreditosVip(player.getCreditosVip() + recompensa.getQuantidade());
                        player.salvar();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
                break;
        }

        int diasLogadosFidelidade = PersonagemOn.personagem.getDiasLogadosFidelidade();

        PersonagemOn.personagem.setDiasLogadosFidelidade(diasLogadosFidelidade + 1 > 8 ? 1 : diasLogadosFidelidade + 1);
        PersonagemOn.personagem.setTemRecompensaFidelidade(false);

        PersonagemOn.personagem.salvar();

        changeTo(new FidelidadeFragment());
    }

    private void changeTo(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment);
        transaction.commit();
    }
}
