package com.gutotech.narutogame.ui.deslogado.home;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.gutotech.narutogame.ui.logado.LogadoSelecionarActivity;
import com.gutotech.narutogame.ui.adapter.EstatisticasNinjaRecyclerAdapter;
import com.gutotech.narutogame.ui.adapter.NoticiasAdapter;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.util.Helper;
import com.gutotech.narutogame.util.RecyclerItemClickListener;
import com.gutotech.narutogame.data.model.EstatisticaNinja;
import com.gutotech.narutogame.data.model.Noticia;
import com.gutotech.narutogame.data.model.Personagem;
import com.gutotech.narutogame.data.model.Player;
import com.gutotech.narutogame.publicentities.CurrentFragment;
import com.gutotech.narutogame.ui.deslogado.lernoticia.LerNoticiaFragment;
import com.gutotech.narutogame.ui.deslogado.recuperarsenha.RecuperarSenhaFragment;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class HomeFragment extends Fragment {
    private TextInputEditText emailEditText, senhaEditText;
    private ImageButton jogarButton;
    private TextView esqueceuSenhaTextView;

    private RecyclerView noticiasRecyclerView;
    private NoticiasAdapter noticiasAdapter;
    private List<Noticia> noticiaList = new ArrayList<>();
    private Query noticiasQuery;
    private ValueEventListener valueEventListenerNoticias;

    private RecyclerView estatisticasNinjasRecyclerView;
    private EstatisticasNinjaRecyclerAdapter estatisticasAdapter;
    private DatabaseReference jogadoresReference;
    private ValueEventListener valueEventListenerJogadores;
    private final int TOTAL_NINJAS = 121;
    private EstatisticaNinja[] estatisticasNinja = new EstatisticaNinja[TOTAL_NINJAS];

    private int kageEVilaAtual = 1;
    private CountDownTimer timer;
    private ImageView vilaImageView;
    private TextView nomeKageTextView;
    private TextView levelKageTextView;

    private Dialog aguardeDialog;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        emailEditText = view.findViewById(R.id.emailLoginEditText);
        senhaEditText = view.findViewById(R.id.senhaLoginEditText);
        esqueceuSenhaTextView = view.findViewById(R.id.esqueceuASenhaTextView);
        jogarButton = view.findViewById(R.id.jogarImageButton);

        Bundle bundle = getArguments();
        if (bundle == null)
            configurarLogin();
        else {
            emailEditText.setVisibility(View.GONE);
            senhaEditText.setVisibility(View.GONE);
            esqueceuSenhaTextView.setVisibility(View.GONE);
            jogarButton.setVisibility(View.GONE);
        }

        noticiasRecyclerView = view.findViewById(R.id.noticiasRecyclerView);
        configurarNoticias();

        estatisticasNinjasRecyclerView = view.findViewById(R.id.estatisticasRecyclerView);
        configurarEstatisticas();

        vilaImageView = view.findViewById(R.id.vilaImageView);
        nomeKageTextView = view.findViewById(R.id.nomeKageTextView);
        levelKageTextView = view.findViewById(R.id.levelKageTextView);
        configurarKagesEVilas();

        return view;
    }

    public void configurarLogin() {
        jogarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String senha = senhaEditText.getText().toString();

                if (validarCampos(email, senha)) {
                    aguardeDialog = new Dialog(getActivity());
                    aguardeDialog.setContentView(R.layout.dialog_progressbar);
                    aguardeDialog.setCancelable(false);
                    aguardeDialog.show();
                    logarPlayer(new Player(email, senha));
                }
            }
        });

        esqueceuSenhaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = getActivity().findViewById(R.id.tituloSecaoTextView);
                textView.setText("ESQUECI MINHA SENHA");
                changeTo(new RecuperarSenhaFragment());
            }
        });
    }

    public void configurarNoticias() {
        DatabaseReference referenceNoticia = FirebaseConfig.getDatabase().child("noticia");
        noticiasQuery = referenceNoticia.orderByKey();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        noticiasRecyclerView.setLayoutManager(layoutManager);
        noticiasRecyclerView.setHasFixedSize(true);
        noticiasRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.HORIZONTAL));
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

    public void configurarEstatisticas() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        estatisticasNinjasRecyclerView.setLayoutManager(layoutManager);
        estatisticasNinjasRecyclerView.setHasFixedSize(true);
        estatisticasAdapter = new EstatisticasNinjaRecyclerAdapter(getActivity(), estatisticasNinja);
        estatisticasNinjasRecyclerView.setAdapter(estatisticasAdapter);
    }

    public void configurarKagesEVilas() {
        changeKagesEVilas();
    }

    public void logarPlayer(final Player player) {
        FirebaseAuth auth = FirebaseConfig.getAuth();

        auth.signInWithEmailAndPassword(
                player.getEmail(), player.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                aguardeDialog.dismiss();
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

                    Toasty.error(getActivity(), excecao, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void recuperarNoticias() {
        valueEventListenerNoticias = noticiasQuery.addValueEventListener(new ValueEventListener() {
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

    private void carregarEstatiscasNinjas() {
        int counter = 0;
        for (int i = 1; i < 266; i++) {
            if (Helper.nomeDoPersonagem(i) != null) {
                estatisticasNinja[counter] = new EstatisticaNinja();
                estatisticasNinja[counter].setIdProfile(i);
                counter++;
            }
        }

        jogadoresReference = FirebaseConfig.getDatabase().child("personagem");

        valueEventListenerJogadores = jogadoresReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Personagem personagem = data.getValue(Personagem.class);

                    int idProfile = personagem.getIdProfile();

                    for (int i = 0; i < TOTAL_NINJAS; i++) {
                        if (estatisticasNinja[i].getIdProfile() == idProfile)
                            estatisticasNinja[i].setFrequencia(estatisticasNinja[i].getFrequencia() + 1);
                    }
                }
                classificarEstatisticas();
                estatisticasAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void classificarEstatisticas() {
        for (int i = 0; i < TOTAL_NINJAS - 1; i++) {
            for (int j = 0; j < TOTAL_NINJAS; j++) {
                if (estatisticasNinja[i].getFrequencia() > estatisticasNinja[j].getFrequencia()) {
                    EstatisticaNinja aux = estatisticasNinja[i];
                    estatisticasNinja[i] = estatisticasNinja[j];
                    estatisticasNinja[j] = aux;
                }
            }
        }
    }

    private void changeKagesEVilas() {
        timer = new CountDownTimer(5000, 5000) {
            @Override
            public void onTick(long millisUntilFinished) {
                switch (kageEVilaAtual) {
                    case 1:
                        vilaImageView.setImageResource(R.drawable.layout_home_kages_1);
                        levelKageTextView.setText("Hokage - Level 1");
                        break;
                    case 2:
                        vilaImageView.setImageResource(R.drawable.layout_home_kages_2);
                        levelKageTextView.setText("Kazekage - Level 1");
                        break;
                    case 3:
                        vilaImageView.setImageResource(R.drawable.layout_home_kages_3);
                        levelKageTextView.setText("Mizukage - Level 1");
                        break;
                    case 4:
                        vilaImageView.setImageResource(R.drawable.layout_home_kages_4);
                        levelKageTextView.setText("Tsuchikage - Level 1");
                        break;
                    case 5:
                        vilaImageView.setImageResource(R.drawable.layout_home_kages_5);
                        levelKageTextView.setText("Raikage - Level 1");
                        break;
                    case 6:
                        vilaImageView.setImageResource(R.drawable.layout_home_kages_6);
                        levelKageTextView.setText("Líder - Level 1");
                        break;
                    case 7:
                        vilaImageView.setImageResource(R.drawable.layout_home_kages_7);
                        levelKageTextView.setText("Otokage - Level 1");
                        break;
                    case 8:
                        vilaImageView.setImageResource(R.drawable.layout_home_kages_8);
                        levelKageTextView.setText("Amekage - Level 1");
                        break;
                }
            }

            @Override
            public void onFinish() {
                if (++kageEVilaAtual > 8)
                    kageEVilaAtual = 1;

                changeKagesEVilas();
            }
        }.start();
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

    @Override
    public void onStart() {
        super.onStart();
        recuperarNoticias();
        carregarEstatiscasNinjas();
    }

    @Override
    public void onStop() {
        super.onStop();

        timer.cancel();

        jogadoresReference.removeEventListener(valueEventListenerJogadores);
        noticiasQuery.removeEventListener(valueEventListenerNoticias);
    }
}
