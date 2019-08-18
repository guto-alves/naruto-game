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
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.config.ConfigFirebase;
import com.gutotech.narutogame.config.Storage;
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

        ImageView personagemMsg = view.findViewById(R.id.personagemMsg);
        Storage.baixarImagemParaMsg(getActivity(), personagemMsg);

        playerReference = ConfigFirebase.getDatabase()
                .child("player")
                .child(ConfigFirebase.getAuth().getCurrentUser().getUid());
        recuperarPlayer();

        final ImageView personagemMsg2 = view.findViewById(R.id.imagemMsg2);

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

        final ConstraintLayout mgsSucessoConstraintLayout = view.findViewById(R.id.msgConstraint2);

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

                    Storage.baixarImagemParaMsg(getActivity(), personagemMsg2);
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
                playerReference.removeEventListener(valueEventListenerPlayer);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void exibirDados() {
        nomeEditText.setText(player.getNome());
        emailEditText.setText(player.getEmail());

        ArrayAdapter<CharSequence> adapter;
        sexo = player.getSexo();
        if (sexo.equals("Masculino"))
            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.sexos_array1, android.R.layout.simple_spinner_item);
        else
            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.sexos_array2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexoSpinner.setAdapter(adapter);

        if (player.getDataNascimento() != null)
            dataNascimentoEditText.setText(player.getDataNascimento());

        if (player.getCep() != null)
            cepEditText.setText(player.getCep());

        if (player.getEndereco() != null)
            enderecoEditText.setText(player.getEndereco());

        if (player.getCidade() != null)
            cidadeEditText.setText(player.getCidade());

        if (player.getBairro() != null)
            bairroEditText.setText(player.getBairro());

        if (player.getEstado() != null)
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

        if (!data.isEmpty()) {
            if (!data.matches("\\d{2}/\\d{2}/\\d{4}")) {
                dataNascimentoEditText.setError("Data de nascimento inválida\n(ex.: dd/mm/aaaa)");
                return false;
            }
        }

        return true;
    }
}
