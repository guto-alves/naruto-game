package com.gutotech.narutogame.fragment.deslogado;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.activity.LogadoSelecionarActivity;
import com.gutotech.narutogame.adapter.NoticiasAdapter;
import com.gutotech.narutogame.config.ConfigFirebase;
import com.gutotech.narutogame.helper.RecyclerItemClickListener;
import com.gutotech.narutogame.model.Noticia;
import com.gutotech.narutogame.model.Player;
import com.gutotech.narutogame.publicentities.CurrentFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private EditText emailEditText, senhaEditText;

    private RecyclerView noticiasRecyclerView;
    private NoticiasAdapter noticiasAdapter;
    private List<Noticia> noticiaList = new ArrayList<>();

    private Query noticiasQuery;
    private ValueEventListener valueEventListener;

    private FirebaseAuth auth;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        emailEditText = view.findViewById(R.id.emailLoginEditText);
        senhaEditText = view.findViewById(R.id.senhaLoginEditText);
        TextView esqueceuSenhaTextView = view.findViewById(R.id.esqueceuASenhaTextView);
        ImageButton jogarButton = view.findViewById(R.id.jogarImageButton);

        Bundle bundle = getArguments();
        if (bundle == null) {
            esqueceuSenhaTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView textView = getActivity().findViewById(R.id.tituloSecaoTextView);
                    textView.setText("ESQUECI MINHA SENHA");
                    changeTo(new RecuperarSenhaFragment());
                }
            });

            jogarButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = emailEditText.getText().toString();
                    String senha = senhaEditText.getText().toString();

                    if (validarCampos(email, senha))
                        logarPlayer(new Player(email, senha));
                }
            });
        } else {
            emailEditText.setVisibility(View.GONE);
            senhaEditText.setVisibility(View.GONE);
            esqueceuSenhaTextView.setVisibility(View.GONE);
            jogarButton.setVisibility(View.GONE);
        }

        noticiasRecyclerView = view.findViewById(R.id.noticiasRecyclerView);
        configurarRecyclerNoticias();

        auth = ConfigFirebase.getAuth();
        DatabaseReference referenceNoticia = ConfigFirebase.getDatabase().child("noticia");
        noticiasQuery = referenceNoticia.orderByKey();

        return view;
    }

    private void configurarRecyclerNoticias() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        noticiasRecyclerView.setLayoutManager(layoutManager);
        noticiasRecyclerView.setHasFixedSize(true);
        noticiasRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));

        noticiasAdapter = new NoticiasAdapter(getActivity(), noticiaList);

        noticiasRecyclerView.setAdapter(noticiasAdapter);
        noticiasRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), noticiasRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                CurrentFragment.LER_NOTICIA = 1;
                TextView textView = getActivity().findViewById(R.id.tituloSecaoTextView);
                textView.setText("LER NOTÍCIA");

                Bundle bundle = new Bundle();
                bundle.putSerializable("noticia", noticiaList.get(position));

                LerNoticiaFragment lerNoticiaFragment = new LerNoticiaFragment();
                lerNoticiaFragment.setArguments(bundle);
                changeTo(lerNoticiaFragment);
            }

            @Override
            public void onLongItemClick(View view, int position) {
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        }));
    }

    public void logarPlayer(Player player) {
        auth.signInWithEmailAndPassword(
                player.getEmail(), player.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(getActivity(), LogadoSelecionarActivity.class));
                    getActivity().finish();
                } else {
                    String excecao;

                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e) {
                        excecao = "Conta não está cadastrada";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "Email e senha não correspendem";
                    } catch (Exception e) {
                        excecao = "Erro ao entrar: " + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(getActivity(), excecao, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validarCampos(String email, String senha) {
        boolean valid = true;

        if (email.isEmpty()) {
            emailEditText.setError("Preencha o email");
            valid = false;
        }

        if (senha.isEmpty()) {
            senhaEditText.setError("Preencha a senha");
            valid = false;
        }
        return valid;
    }

    public void changeTo(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment);
        transaction.commit();
    }

    private void recuperarNoticias() {
        valueEventListener = noticiasQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                noticiaList.clear();

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Noticia noticia = data.getValue(Noticia.class);
                    noticiaList.add(0, noticia);
                }
                noticiasAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        recuperarNoticias();
    }

    @Override
    public void onStop() {
        super.onStop();
        noticiasQuery.removeEventListener(valueEventListener);
    }
}
