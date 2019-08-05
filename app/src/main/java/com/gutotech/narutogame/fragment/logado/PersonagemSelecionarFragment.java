package com.gutotech.narutogame.fragment.logado;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.activity.LogadoSelecionarActivity;
import com.gutotech.narutogame.activity.PersonagemLogadoActivity;
import com.gutotech.narutogame.adapter.ProfilesPequenasAdapter;
import com.gutotech.narutogame.config.ConfigFirebase;
import com.gutotech.narutogame.helper.RecyclerItemClickListener;
import com.gutotech.narutogame.model.Personagem;

import java.util.ArrayList;
import java.util.List;

public class PersonagemSelecionarFragment extends Fragment {
    private TextView nick, level, graducao, ryous, vila;
    private ImageView profile;

    private RecyclerView pequenasRecyclerView;
    private ProfilesPequenasAdapter adapter;
    private List<Integer> pequenasLista = new ArrayList<>();
    private Personagem personagemSelecionado;

    private List<Personagem> personagensList = new ArrayList<>();

    private FirebaseAuth auth;
    private DatabaseReference personagensRef;
    private ValueEventListener valueEventListenerPersonagens;

    public PersonagemSelecionarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personagem_selecionar, container, false);

        auth = ConfigFirebase.getAuth();
        personagensRef = ConfigFirebase.getDatabase()
                .child("personagem")
                .child(auth.getCurrentUser().getUid());

        profile = view.findViewById(R.id.profileSelecionarImageView);
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
                    Intent intent = new Intent(getActivity(), PersonagemLogadoActivity.class);
                    intent.putExtra("personagemlogado", personagemSelecionado);
                    startActivity(intent);
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
                            deletarNinja();
                        }
                    });
                    builder.create();
                    builder.show();
                } else
                    Toast.makeText(getActivity(), "Nenhum personagem selecionado", Toast.LENGTH_SHORT).show();
            }
        });

        pequenasRecyclerView = view.findViewById(R.id.pequenasSelecionarRecyclerView);
        configurarRecyclerView();

        return view;
    }

    private void configurarRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        pequenasRecyclerView.setLayoutManager(layoutManager);
        pequenasRecyclerView.setHasFixedSize(true);
        adapter = new ProfilesPequenasAdapter(getActivity(), pequenasLista);
        pequenasRecyclerView.setAdapter(adapter);
        pequenasRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getActivity(), pequenasRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                personagemSelecionado = personagensList.get(position);
                mudarDePersonagem();
            }

            @Override
            public void onLongItemClick(View view, int position) {
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        }
        ));
    }

    private void mudarDePersonagem() {
        StorageReference imagemProfileRef = ConfigFirebase.getStorage()
                .child("images")
                .child("profile")
                .child(String.valueOf(personagemSelecionado.getIdProfile()))
                .child(personagemSelecionado.getFotoAtual() + ".png");

        Glide.with(getActivity())
                .using(new FirebaseImageLoader())
                .load(imagemProfileRef)
                .into(profile);

        nick.setText(personagemSelecionado.getNick());
        level.setText(String.valueOf(personagemSelecionado.getLevel()));
        graducao.setText(personagemSelecionado.getGraducao());
        ryous.setText(String.valueOf(personagemSelecionado.getRyous()));
        vila.setText(personagemSelecionado.getVila());
    }

    private void deletarNinja() {
        DatabaseReference personagem = ConfigFirebase.getDatabase()
                .child("personagem")
                .child(auth.getCurrentUser().getUid())
                .child(personagemSelecionado.getNick());

        personagem.removeValue();
        changeTo(new PersonagemSelecionarFragment());
    }

    private void changeTo(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment);
        transaction.commit();
    }

    private void recuperarPersonagens() {
        valueEventListenerPersonagens = personagensRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                personagensList.clear();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Personagem personagem = data.getValue(Personagem.class);
                    personagensList.add(personagem);
                }

                if (personagensList.size() == 0) {
                    LogadoSelecionarActivity.tituloSecaoTextView.setText("CRIAR PERSONAGEM");
                    changeTo(new PersonagemCriarFragment());
                } else {
                    LogadoSelecionarActivity.tituloSecaoTextView.setText("SELECIONE SEU PERSONAGEM");
                    for (int i = 0; i < personagensList.size(); i++)
                        pequenasLista.add(personagensList.get(i).getIdProfile());

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

    @Override
    public void onStart() {
        super.onStart();
        recuperarPersonagens();
    }

    @Override
    public void onStop() {
        super.onStop();
        personagensRef.removeEventListener(valueEventListenerPersonagens);
    }
}
