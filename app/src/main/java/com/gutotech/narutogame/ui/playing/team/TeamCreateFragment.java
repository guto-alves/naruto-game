package com.gutotech.narutogame.ui.playing.team;

import android.app.AlertDialog;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.StorageUtil;
import com.gutotech.narutogame.data.model.Equipe;
import com.gutotech.narutogame.data.model.PersonagemOn;

public class TeamCreateFragment extends Fragment implements SectionFragment {
    private TextInputEditText nomeEquipeTextInput;
    private RadioGroup requerimentoEquipeRadioGroup;

    private RadioButton creditosRadioButton;
    private RadioButton ryousEChunninRadioButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team_create, container, false);

        ImageView imagemMsg = view.findViewById(R.id.personagemMsg);
        StorageUtil.downloadProfileForMsg(getActivity(), imagemMsg, PersonagemOn.character.getVillage().id);

        nomeEquipeTextInput = view.findViewById(R.id.nomeEqpTextInput);

        creditosRadioButton = view.findViewById(R.id.creditosRadioButton);
        ryousEChunninRadioButton = view.findViewById(R.id.ryousEChunninRadioButton);

        Button criarEquipeButton = view.findViewById(R.id.criarEquipeButton);
        criarEquipeButton.setOnClickListener(v -> {
            String nomeDaEquipe = nomeEquipeTextInput.getText().toString();

            if (validarNomeDaEquipe(nomeDaEquipe)) {
                if (validarFormaDeCriarEquipe())
                    salvarEquipe(nomeDaEquipe);
            }
        });

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_create_a_team);
        return view;
    }

    private boolean validarNomeDaEquipe(String nomeDaEquipe) {
        if (nomeDaEquipe.isEmpty()) {
            nomeEquipeTextInput.setError(getString(R.string.error_the_name_of_team_cant_be_empty));
            return false;
        }

        return true;
    }

    private boolean validarFormaDeCriarEquipe() {
        if (!ryousEChunninRadioButton.isSelected() || !creditosRadioButton.isSelected()) {
            showDialog(R.string.error_select_an_method_to_create_team);
        }

        return true;
    }

    private void showDialog(@StringRes int resId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.naruto_game_says);
        builder.setMessage(resId);
        builder.setPositiveButton("OK", null);
        builder.create().show();
    }

    private void salvarEquipe(String nomeDaEquipe) {
        Equipe equipe = new Equipe();
        equipe.setNome(nomeDaEquipe);
        equipe.setLevel(1);
        equipe.setLider(PersonagemOn.character);
        equipe.salvar();
    }

    @Override
    public int getDescription() {
        return R.string.being_a_leader;
    }
}
