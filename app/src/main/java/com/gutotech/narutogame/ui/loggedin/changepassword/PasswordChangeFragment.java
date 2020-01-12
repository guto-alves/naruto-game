package com.gutotech.narutogame.ui.loggedin.changepassword;


import android.app.AlertDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.util.StorageUtil;

public class PasswordChangeFragment extends Fragment {
    private EditText senhaAtualEditText;
    private EditText novaSenhaEditText;
    private EditText confirmarNovaSenhaEditText;

    private FirebaseAuth auth;

    public PasswordChangeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_senha_trocar, container, false);

        ImageView personagemMsg = view.findViewById(R.id.personagemMsg);
        StorageUtil.downloadProfileForMsg(getActivity(), personagemMsg);

//        auth = FirebaseConfig.getAuth();

        senhaAtualEditText = view.findViewById(R.id.senhaAtualEditText);
        novaSenhaEditText = view.findViewById(R.id.novaSenhaEditText);
        confirmarNovaSenhaEditText = view.findViewById(R.id.confirNovaSenhaEditText);

        Button alterarSenhaButton = view.findViewById(R.id.alterarSenhaButton);
        alterarSenhaButton.setOnClickListener(v -> {
            String senhaAtual = senhaAtualEditText.getText().toString();
            String novaSenha1 = novaSenhaEditText.getText().toString();
            String novaSenha2 = confirmarNovaSenhaEditText.getText().toString();

            if (validarNovaSenha(senhaAtual, novaSenha1, novaSenha2)) {
                // Atualizar a senha
            }
        });


        return view;
    }

    private boolean validarNovaSenha(String senhaAtual, String novaSenha1, String novaSenha2) {
        if (senhaAtual.isEmpty() || novaSenha1.isEmpty() || novaSenha2.isEmpty()) {
            exibirAlerta("Favor preencher todos o campos de senha");
            return false;
        } else {
            if (novaSenha1.equals(novaSenha2))
                return true;

            exibirAlerta("As novas senhas não coincidem, por favor verifique os dados");
            return false;
        }
    }

    private void exibirAlerta(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Naruto game diz:");
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.setCancelable(false);
        builder.create().show();
    }
}
