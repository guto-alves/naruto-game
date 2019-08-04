package com.gutotech.narutogame.fragment.logado;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.config.ConfigFirebase;

public class SenhaTrocarFragment extends Fragment {
    private EditText senhaAtualEditText;
    private EditText novaSenhaEditText;
    private EditText confirmarNovaSenhaEditText;
    private Button alterarSenhaButton;

    private FirebaseAuth auth;

    public SenhaTrocarFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_senha_trocar, container, false);

        auth = ConfigFirebase.getAuth();

        senhaAtualEditText = view.findViewById(R.id.senhaAtualEditText);
        novaSenhaEditText = view.findViewById(R.id.novaSenhaEditText);
        confirmarNovaSenhaEditText = view.findViewById(R.id.confirNovaSenhaEditText);

        alterarSenhaButton = view.findViewById(R.id.alterarSenhaButton);
        alterarSenhaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String senha1 = novaSenhaEditText.getText().toString();
                String senha2 = confirmarNovaSenhaEditText.getText().toString();

                if (validarNovaSenha(senha1, senha2)) {
                    // Atualizar a senha
                }
            }
        });


        return view;
    }

    private boolean validarNovaSenha(String senha1, String senha2) {
        return senha1.equals(senha2);
    }
}
