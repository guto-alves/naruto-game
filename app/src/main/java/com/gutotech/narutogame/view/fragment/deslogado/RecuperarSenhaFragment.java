package com.gutotech.narutogame.view.fragment.deslogado;

import android.app.AlertDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gutotech.narutogame.R;

public class RecuperarSenhaFragment extends Fragment {
    private EditText emailEditText;
    private Button recuperarSenhaButton;

    public RecuperarSenhaFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recuperar_senha, container, false);

        emailEditText = view.findViewById(R.id.recuperarSenhaEmailEditText);
        recuperarSenhaButton = view.findViewById(R.id.recuperarSenhaButton);
        recuperarSenhaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recuperarSenha();
            }
        });

        return view;
    }

    private void recuperarSenha() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("SENHA ENVIADA COM SUCESSO!");
        builder.setMessage("Em alguns instantes você recebará sua nova senha em seu email.");
        builder.create();
        builder.show();
    }
}
