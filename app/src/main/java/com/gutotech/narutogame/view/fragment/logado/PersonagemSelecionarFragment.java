package com.gutotech.narutogame.view.fragment.logado;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.view.activity.PersonagemLogadoActivity;
import com.gutotech.narutogame.view.adapter.ProfilesPequenasAdapter;
import com.gutotech.narutogame.config.FirebaseConfig;
import com.gutotech.narutogame.config.StorageUtil;
import com.gutotech.narutogame.model.Personagem;
import com.gutotech.narutogame.model.PersonagemOn;

import java.util.ArrayList;
import java.util.List;

public class PersonagemSelecionarFragment extends Fragment {
    private ImageView profileImageView;
    private TextView nick, level, graducao, ryous, vila;

    private GridView profilesPequenasGridView;
    private ProfilesPequenasAdapter adapter;
    private List<Integer> profilesPequenaList = new ArrayList<>();
    private Personagem personagemSelecionado;

    private List<Personagem> personagensList = new ArrayList<>();

    private Query personagensQuery;
    private ValueEventListener valueEventListenerPersonagens;

    public PersonagemSelecionarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personagem_selecionar, container, false);

        DatabaseReference personagensReference = FirebaseConfig.getDatabase().child("personagem");
        personagensQuery = personagensReference.orderByChild("idPlayer")
                .equalTo(FirebaseConfig.getAuth().getCurrentUser().getUid());

        profileImageView = view.findViewById(R.id.profileSelecionarImageView);
        nick = view.findViewById(R.id.nickTextView);
        level = view.findViewById(R.id.levelTextView);
        graducao = view.findViewById(R.id.graducaoTextView);
        ryous = view.findViewById(R.id.ryousTextView);
        vila = view.findViewById(R.id.vilaTextView);

        Button jogarSelecionarButton = view.findViewById(R.id.jogarSelecionarButton);
        jogarSelecionarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (personagemSelecionado != null) {
                    PersonagemOn.personagem = personagemSelecionado;
                    startActivity(new Intent(getActivity(), PersonagemLogadoActivity.class));
                    getActivity().finish();
                } else
                    Toast.makeText(getActivity(), "Nenhum personagem selecionado", Toast.LENGTH_SHORT).show();
            }
        });

        Button removerButton = view.findViewById(R.id.removerButton);
        removerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (personagemSelecionado != null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Naruto Game diz:");
                    builder.setMessage("Você quer realmente deletar esse ninja?");
                    builder.setNegativeButton("Cancelar", null);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (PersonagemOn.personagem == null)
                                deletarNinja();
                            else {
                                if (personagemSelecionado.getNick().equals(PersonagemOn.personagem.getNick())) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Aviso!");
                                    builder.setMessage("Você não pode remover esse personagem estando logado nele!");
                                    builder.setPositiveButton("Fechar", null);
                                    builder.create().show();
                                } else
                                    deletarNinja();
                            }

                        }
                    });
                    builder.create();
                    builder.show();
                } else
                    Toast.makeText(getActivity(), "Nenhum personagem selecionado", Toast.LENGTH_SHORT).show();
            }
        });

        profilesPequenasGridView = view.findViewById(R.id.profilesPequenasGridView);
        configurarGridView();

        return view;
    }

    private void configurarGridView() {
        adapter = new ProfilesPequenasAdapter(getActivity(), profilesPequenaList);
        profilesPequenasGridView.setAdapter(adapter);
        profilesPequenasGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                personagemSelecionado = personagensList.get(position);
                mudarDePersonagem();
            }
        });
    }

    private void mudarDePersonagem() {
        StorageUtil.baixarProfile(getActivity(), profileImageView, personagemSelecionado.getIdProfile(), personagemSelecionado.getFotoAtual());

        nick.setText(personagemSelecionado.getNick());
        level.setText(String.valueOf(personagemSelecionado.getLevel()));
        graducao.setText(personagemSelecionado.getGraducao());
        ryous.setText(String.valueOf(personagemSelecionado.getRyous()));
        vila.setText(personagemSelecionado.getVila());
    }

    private void deletarNinja() {
        DatabaseReference personagem = FirebaseConfig.getDatabase()
                .child("personagem")
                .child(personagemSelecionado.getNick());

        personagem.removeValue();
        changeTo(new PersonagemSelecionarFragment());
    }

    private void recuperarPersonagens() {
        valueEventListenerPersonagens = personagensQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                personagensList.clear();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Personagem personagem = data.getValue(Personagem.class);
                    personagensList.add(personagem);
                }

                personagensQuery.removeEventListener(valueEventListenerPersonagens);

                if (personagensList.size() == 0) {
                    mudarTituloSecao("CRIAR PERSONAGEM");
                    changeTo(new PersonagemCriarFragment());
                } else {
                    classificarPersonagensPorLvl();

                    for (int i = 0; i < personagensList.size(); i++)
                        profilesPequenaList.add(personagensList.get(i).getIdProfile());

                    adapter.notifyDataSetChanged();

                    personagemSelecionado = personagensList.get(0);
                    mudarDePersonagem();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void classificarPersonagensPorLvl() {
        final int QTD_PERSONAGENS = personagensList.size();

        for (int i = 0; i < QTD_PERSONAGENS - 1; i++) {
            for (int j = i + 1; j < QTD_PERSONAGENS; j++) {
                if (personagensList.get(i).getLevel() < personagensList.get(j).getLevel()) {
                    Personagem temp_personagem = personagensList.get(i);
                    personagensList.set(i, personagensList.get(j));
                    personagensList.set(j, temp_personagem);
                }
            }
        }
    }

    private void changeTo(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment);
        transaction.commit();
    }

    private void mudarTituloSecao(String titulo) {
        TextView tituloSecao = getActivity().findViewById(R.id.tituloSecaoTextView);
        tituloSecao.setText(titulo);
    }

    @Override
    public void onStart() {
        super.onStart();
        recuperarPersonagens();
    }
}
