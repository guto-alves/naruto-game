package com.gutotech.narutogame.ui.playing.battles;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.playing.character.CharacterStatusFragment;
import com.gutotech.narutogame.data.model.PersonagemOn;

public class HospitalQuartoFragment extends Fragment {

    public HospitalQuartoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hospital_quarto, container, false);

        Button pagarMedicoButton = view.findViewById(R.id.pagarMedicoButton);
        pagarMedicoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PersonagemOn.character.getRyous() >= 25) {
                    PersonagemOn.character.setRyous(PersonagemOn.character.getRyous() - 25);
//                    Formulas formulas = PersonagemOn.character.getAtributos().getFormulas();
//                    formulas.setCurrentHealth(formulas.getHealth());
//                    formulas.setChakraAtual(formulas.getChakra());
//                    formulas.setStaminaAtual(formulas.getStamina());
                    PersonagemOn.character.salvar();

                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Aviso!");
                    builder.setMessage("Após ter feito o pagamento a enfermeira trouxe o especialista designado e você foi curado completamente.");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Fechar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            changeToFragment(new CharacterStatusFragment());
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
        transaction.replace(R.id.container, fragment).commit();
    }
}
