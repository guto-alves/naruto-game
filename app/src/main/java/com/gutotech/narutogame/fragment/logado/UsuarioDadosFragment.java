package com.gutotech.narutogame.fragment.logado;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.config.ConfigFirebase;
import com.gutotech.narutogame.model.Player;

public class UsuarioDadosFragment extends Fragment {
    private Player player;

    private EditText nomeEditText;
    private EditText emailEditText;
    private Spinner sexoSpinner;
    private String sexo;
    private EditText dataNascimentoEditText;
    private EditText cepEditText;
    private EditText enderecoEditText;
    private EditText cidadeEditText;
    private EditText bairroEditText;
    private EditText estadoEditText;

    private DatabaseReference playerReference;
    private ValueEventListener valueEventListenerPlayer;

    public UsuarioDadosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_usuario_dados, container, false);

        player = new Player();

        playerReference = ConfigFirebase.getDatabase()
                .child("player")
                .child(ConfigFirebase.getAuth().getCurrentUser().getUid());
        recuperarPlayer();

        nomeEditText = view.findViewById(R.id.editTextNome);
        emailEditText = view.findViewById(R.id.editTextEmail);
        dataNascimentoEditText = view.findViewById(R.id.editTextData);
        cepEditText = view.findViewById(R.id.EditTextCep);
        enderecoEditText = view.findViewById(R.id.editTextEndereco);
        cidadeEditText = view.findViewById(R.id.editTextCidade);
        estadoEditText = view.findViewById(R.id.EditTextEstado);
        bairroEditText = view.findViewById(R.id.editTextBairro);

        sexoSpinner = view.findViewById(R.id.sexoSpinner);
        sexoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sexo = (String) sexoSpinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final ConstraintLayout mgsSucessoConstraintLayout = view.findViewById(R.id.msgLinear2);

        Button enviarAlteracoesButton = view.findViewById(R.id.enviarAlteracoesButton);
        enviarAlteracoesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nomeEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String data = dataNascimentoEditText.getText().toString();

                if (validarCampos(nome, email, data)) {
                    player.setId(ConfigFirebase.getAuth().getCurrentUser().getUid());
                    player.setNome(nome);
                    player.setEmail(email);
                    player.setSexo(sexo);
                    player.setDataNascimento(data);
                    player.setEndereco(enderecoEditText.getText().toString());
                    player.setCidade(cidadeEditText.getText().toString());
                    player.setCep(cepEditText.getText().toString());
                    player.setBairro(bairroEditText.getText().toString());
                    player.setEstado(estadoEditText.getText().toString());
                    player.salvar();

                    mgsSucessoConstraintLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;
    }

    private void recuperarPlayer() {
        valueEventListenerPlayer = playerReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                player = dataSnapshot.getValue(Player.class);
                exibirDados();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void exibirDados() {
        if (!player.getNome().isEmpty())
            nomeEditText.setText(player.getNome());

        if (!player.getEmail().isEmpty())
            emailEditText.setText(player.getEmail());

        ArrayAdapter<CharSequence> adapter;
        sexo = player.getSexo();
        if (sexo.equals("Masculino"))
            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.sexos_array1, android.R.layout.simple_spinner_item);
        else
            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.sexos_array2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexoSpinner.setAdapter(adapter);

        if (!player.getDataNascimento().isEmpty())
            dataNascimentoEditText.setText(player.getDataNascimento());

        if (!player.getCep().isEmpty())
            cepEditText.setText(player.getCep());

        if (!player.getEndereco().isEmpty())
            enderecoEditText.setText(player.getEndereco());

        if (!player.getCidade().isEmpty())
            cidadeEditText.setText(player.getCidade());

        if (!player.getBairro().isEmpty())
            bairroEditText.setText(player.getBairro());

        if (!player.getEstado().isEmpty())
            estadoEditText.setText(player.getEstado());
    }

    private boolean validarCampos(String nome, String email, String data) {
        if (nome.isEmpty()) {
            nomeEditText.setError("Nome inválido");
            return false;
        }

        if (email.isEmpty()) {
            emailEditText.setError("Email inválido");
            return false;
        }

        if (data.isEmpty()) {
            dataNascimentoEditText.setError("Data de nascimento inválida");
            return false;
        }

        return true;
    }

    @Override
    public void onStop() {
        super.onStop();
        playerReference.removeEventListener(valueEventListenerPlayer);
    }
}
