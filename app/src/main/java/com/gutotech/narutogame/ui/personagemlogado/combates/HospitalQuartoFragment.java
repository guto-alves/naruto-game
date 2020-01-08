package com.gutotech.narutogame.ui.personagemlogado.combates;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.personagemlogado.personagem.PersonagemStatusFragment;
import com.gutotech.narutogame.data.model.Formulas;
import com.gutotech.narutogame.data.model.PersonagemOn;

public class HospitalQuartoFragment extends Fragment {

    public HospitalQuartoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hospital_quarto, container, false);
        TextView tituloSecao = getActivity().findViewById(R.id.tituloSecaoTextView);
        tituloSecao.setText("QUARTO DO HOSPITAL");

        Button pagarMedicoButton = view.findViewById(R.id.pagarMedicoButton);
        pagarMedicoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PersonagemOn.personagem.getRyous() >= 25) {
                    PersonagemOn.personagem.setRyous(PersonagemOn.personagem.getRyous() - 25);
                    Formulas formulas = PersonagemOn.personagem.getAtributos().getFormulas();
                    formulas.setVidaAtual(formulas.getVida());
                    formulas.setChakraAtual(formulas.getChakra());
                    formulas.setStaminaAtual(formulas.getStamina());
                    PersonagemOn.personagem.salvar();

                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Aviso!");
                    builder.setMessage("Após ter feito o pagamento a enfermeira trouxe o especialista designado e você foi curado completamente.");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Fechar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            changeToFragment(new PersonagemStatusFragment());
                        }
                    });
                    builder.create();
                    builder.show();
                }
            }
        });

        return view;
    }

    private void changeToFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment).commit();
    }
}
