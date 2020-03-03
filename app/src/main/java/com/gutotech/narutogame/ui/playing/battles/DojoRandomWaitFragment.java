package com.gutotech.narutogame.ui.playing.battles;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentDojoRandomWaitBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtil;

public class DojoRandomWaitFragment extends Fragment implements SectionFragment {

    public DojoRandomWaitFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDojoRandomWaitBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_dojo_random_wait, container, false);

        DojoRandomWaitViewModel viewModel = ViewModelProviders.of(getActivity())
                .get(DojoRandomWaitViewModel.class);

        binding.setViewModel(viewModel);

        FragmentUtil.setSectionTitle(getActivity(), R.string.looking_for_opponents);

        return binding.getRoot();
    }

//    private void procurarOponentes() {
//        valueEventListenerProcurar = procurarOponentesReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot data : dataSnapshot.getChildren()) {
//                    Oponente.oponente = data.getValue(Character.class);

//                    if (!Oponente.oponente.getNick().equals(PersonagemOn.character.getNick())) {
//                        if (Oponente.oponente.getIdBatalhaAtual().equals("")) {
//                            if (Oponente.oponente.getLevel() == PersonagemOn.character.getLevel()) {
//                                procurarOponentesReference.removeEventListener(valueEventListenerProcurar);
//
//                                String idBatalha = UUID.randomUUID().toString();
//
//                                PersonagemOn.character.setFuiPego(false);
//                                PersonagemOn.character.setIdBatalhaAtual(idBatalha);
//
//                                Oponente.oponente.setFuiPego(true);
//                                Oponente.oponente.setNickOponente(PersonagemOn.character.getNick());
//                                Oponente.oponente.setIdBatalhaAtual(idBatalha);
//
//                                DatabaseReference batalhaReference = FirebaseConfig.getDatabase()
//                                        .child("batalha_dojo_pvp")
//                                        .child(idBatalha);
//                                BatalhaPVP batalhaPVP = new BatalhaPVP();
//                                batalhaPVP.setQuemAtaca(PersonagemOn.character.getNick());
//                                batalhaPVP.setCurrentPlayer(0);
//                                batalhaPVP.setPlayer1(PersonagemOn.character);
//                                batalhaPVP.setPlayer2(Oponente.oponente);
//                                batalhaReference.setValue(batalhaPVP);
//
//                                euNaFilaReference.setValue(PersonagemOn.character);
//
//                                DatabaseReference oponenteReference = FirebaseConfig.getDatabase()
//                                        .child("dojo_random_wait")
//                                        .child(Oponente.oponente.getNick());
//                                oponenteReference.setValue(Oponente.oponente);
//
//                                changeToFragment(new DojoBatalhaPVPFragment());
//                                break;
//                            }
//                        }
//                    }
//    }
//
//}

//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//            }
//        });
//    }

    @Override
    public int getDescription() {
        return R.string.waiting_room;
    }
}
