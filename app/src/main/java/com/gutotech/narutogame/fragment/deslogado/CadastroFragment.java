package com.gutotech.narutogame.fragment.deslogado;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.config.ConfigFirebase;
import com.gutotech.narutogame.config.Storage;
import com.gutotech.narutogame.model.Player;
import com.gutotech.narutogame.publicentities.PersonagemOn;

import java.security.SecureRandom;

public class CadastroFragment extends Fragment {
    private EditText nomeCompletoEditText, emailEditText, senhaEditText, confirmarSenhaEditText;
    private String sexo = "Masculino";

    public CadastroFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro, container, false);

        ImageView personagemMsg = view.findViewById(R.id.personagemMsgImagem);
        Storage.baixarImagemParaMsg(getActivity(), personagemMsg);

        nomeCompletoEditText = view.findViewById(R.id.nomeCompletoEditText);
        emailEditText = view.findViewById(R.id.emailEditText);
        senhaEditText = view.findViewById(R.id.senhaEditText);
        confirmarSenhaEditText = view.findViewById(R.id.confirmarSenhaEditText);

        final Spinner sexoSpinner = view.findViewById(R.id.sexo_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.sexos_array1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexoSpinner.setAdapter(adapter);
        sexoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sexo = (String) sexoSpinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Button cadastrarButton = view.findViewById(R.id.cadastrarButton);
        cadastrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });

        return view;
    }

    private void cadastrar() {
        String nome = nomeCompletoEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String senha = senhaEditText.getText().toString();
        String confiSenha = confirmarSenhaEditText.getText().toString();

        if (isValidFields(nome, email, senha, confiSenha))
            cadastrarPlayer(new Player(nome, email, senha, sexo));
    }

    private void cadastrarPlayer(final Player player) {
        final FirebaseAuth auth = ConfigFirebase.getAuth();

        auth.createUserWithEmailAndPassword(player.getEmail(), player.getSenha()
        ).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    player.setId(auth.getCurrentUser().getUid());
                    player.salvar();

                    changeToFragment(new HomeFragment());

                    Toast.makeText(getActivity(), "PARABÉNS SEU CADASTRO FOI CONCLUÍDO COM SUCESSO!", Toast.LENGTH_SHORT).show();
                } else {
                    String message;

                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        message = "Campo 'Senha' com valor inválido!\nNo mínimo são requeridos 6 caractéres e os caractéres permitidos são:\n" +
                                "0-9 A-Z _.";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        message = "Campo 'Email' com valor inválido! Verifique o dado e tente novamente";
                    } catch (FirebaseAuthUserCollisionException e) {
                        message = "O endereço de email especificado ja está cadastrado, por favor use um endereço de e-mail diferente.";
                    } catch (Exception e) {
                        message = "Erro: " + e.getMessage();
                    }

                    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidFields(String nome, String email, String senha, String confSenha) {
        boolean valid = true;

        if (nome.isEmpty()) {
            nomeCompletoEditText.setError("Campo obrigatório");
            valid = false;
        }

        if (email.isEmpty()) {
            emailEditText.setError("Campo obrigatório");
            valid = false;
        }

        if (senha.isEmpty()) {
            senhaEditText.setError("Campo obrigatório");
            valid = false;
        }

        if (confSenha.isEmpty()) {
            confirmarSenhaEditText.setError("Campo obrigatório");
            valid = false;
        }

        if (!senha.equals(confSenha)) {
            Toast.makeText(getActivity(), "Campo 'Senha' e 'Confirmar Senha' com valores diferentes!\nVerifique os dados e tente novamente.", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        return valid;
    }

    private void changeToFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment);
        transaction.commit();
    }
}
