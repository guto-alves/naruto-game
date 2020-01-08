package com.gutotech.narutogame.view.fragment.personagemlogado.combates;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.config.FirebaseConfig;
import com.gutotech.narutogame.config.StorageUtil;
import com.gutotech.narutogame.model.Formulas;
import com.gutotech.narutogame.model.Personagem;
import com.gutotech.narutogame.model.NPC;
import com.gutotech.narutogame.model.PersonagemOn;

public class BatalhasDojoNPCFragment extends Fragment {
    private final int MAX_NPC_DIARIO = 5;

    private TextView statusDojoNPC;

    private ImageView profileNPCImageView;
    private TextView nickNPCTextView;
    private LinearLayout linearLutador;

    private ValueEventListener valueEventListener;

    public BatalhasDojoNPCFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_batalhas_dojo_npc, container, false);

        // Confjgura msg
        ImageView imagemMsg = view.findViewById(R.id.personagemMsg);
        StorageUtil.baixarImagemParaMsg(getActivity(), imagemMsg, PersonagemOn.personagem.getNumVila());

        ProgressBar combatesNPCDiarioProgressBar = view.findViewById(R.id.combatesNPCDiarioProgressBar);
        combatesNPCDiarioProgressBar.setMax(MAX_NPC_DIARIO);
        combatesNPCDiarioProgressBar.setProgress(PersonagemOn.personagem.getCombatesNPCDiarios());
        TextView combatesNPCDiarioTextView = view.findViewById(R.id.combatesNPCDiarioTextView);
        combatesNPCDiarioTextView.setText(String.format("%d de %d Combates NPC Diários", PersonagemOn.personagem.getCombatesNPCDiarios(), MAX_NPC_DIARIO));

        if (PersonagemOn.personagem.getCombatesNPCDiarios() < MAX_NPC_DIARIO) {
            Formulas formulas = PersonagemOn.personagem.getAtributos().getFormulas();

            statusDojoNPC = view.findViewById(R.id.statusDojoNPCTextView);
            statusDojoNPC.setVisibility(View.VISIBLE);

            if ((double) formulas.getVidaAtual() / formulas.getVida() < 0.5 ||
                    (double) formulas.getChakraAtual() / formulas.getChakra() < 0.5 ||
                    (double) formulas.getStaminaAtual() / formulas.getStamina() < 0.5) {

                statusDojoNPC.setText("Você está muito fraco para lutar, recupere seus atributos e tente novamente!");
                statusDojoNPC.setVisibility(View.VISIBLE);
            } else {
                statusDojoNPC.setVisibility(View.VISIBLE);

                recuperarPersonagem();

                // config EU
                ImageView profileMeImageView = view.findViewById(R.id.profileMeImageView);
                StorageUtil.baixarProfile(getActivity(), profileMeImageView, PersonagemOn.personagem.getIdProfile(), PersonagemOn.personagem.getFotoAtual());

                TextView nickMeTextView = view.findViewById(R.id.nickMeTextView);
                nickMeTextView.setText(PersonagemOn.personagem.getNick());

                // config NPC
                profileNPCImageView = view.findViewById(R.id.profileNPCImageView);
                nickNPCTextView = view.findViewById(R.id.nickNPCTextView);
                linearLutador = view.findViewById(R.id.linearLutador);

                Button aceitarButton = view.findViewById(R.id.aceitarDojoButton);
                aceitarButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeToFragment(new DojoBatalhaLutadorFragment());
                    }
                });
            }
        }

        return view;
    }

    private void recuperarPersonagem() {
        final DatabaseReference reference = FirebaseConfig.getDatabase()
                .child("personagem")
                .child(PersonagemOn.personagem.getNick());

        valueEventListener = reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                NPC.npc = dataSnapshot.getValue(Personagem.class);

                NPC.configurarNPC();
                atualizarTela();
                reference.removeEventListener(valueEventListener);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void atualizarTela() {
        StorageUtil.baixarProfile(getActivity(), profileNPCImageView, NPC.npc.getIdProfile(), NPC.npc.getFotoAtual());

        nickNPCTextView.setText(NPC.npc.getNick());

        statusDojoNPC.setVisibility(View.GONE);
        linearLutador.setVisibility(View.VISIBLE);
    }

    private void changeToFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment).commit();
    }
}
