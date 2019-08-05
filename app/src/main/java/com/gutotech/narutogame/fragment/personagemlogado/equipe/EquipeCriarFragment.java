package com.gutotech.narutogame.fragment.personagemlogado.equipe;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.config.Storage;
import com.gutotech.narutogame.model.Equipe;
import com.gutotech.narutogame.publicentities.PersonagemOn;

public class EquipeCriarFragment extends Fragment {
    private TextInputEditText nomeEquipeTextInput;
    private RadioGroup requerimentoEquipeRadioGroup;

    private RadioButton creditosRadioButton;
    private RadioButton ryousEChunninRadioButton;

    public EquipeCriarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_equipe_criar, container, false);

        ImageView imagemMsg = view.findViewById(R.id.personagemMsg);
        Storage.baixarImagemParaMsg(getActivity(), imagemMsg, PersonagemOn.personagem.getNumVila());

        nomeEquipeTextInput = view.findViewById(R.id.nomeEqpTextInput);

        creditosRadioButton = view.findViewById(R.id.creditosRadioButton);
        ryousEChunninRadioButton = view.findViewById(R.id.ryousEChunninRadioButton);

        Button criarEquipeButton = view.findViewById(R.id.criarEquipeButton);
        criarEquipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeDaEquipe = nomeEquipeTextInput.getText().toString();

                if (validarNomeDaEquipe(nomeDaEquipe)) {
                    if (validarFormaDeCriarEquipe())
                        salvarEquipe(nomeDaEquipe);
                }
            }
        });

        return view;
    }

    private boolean validarNomeDaEquipe(String nomeDaEquipe) {
        if (nomeDaEquipe.isEmpty()) {
            nomeEquipeTextInput.setError("Nome da equipe não pode ficar em branco!");
            return false;
        }

        return true;
    }

    private boolean validarFormaDeCriarEquipe() {
        if (!ryousEChunninRadioButton.isSelected() || !creditosRadioButton.isSelected()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Naruto Game diz:");
            builder.setMessage("Selecione uma forma de criar a equipe!");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.create().show();
        }

        return true;
    }

    private void salvarEquipe(String nomeDaEquipe) {
        Equipe equipe = new Equipe();
        equipe.setNome(nomeDaEquipe);
        equipe.setLevel(1);
        equipe.setLider(PersonagemOn.personagem);
        equipe.salvar();
    }
}
