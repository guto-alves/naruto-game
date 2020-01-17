package com.gutotech.narutogame.ui.playing.character;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.PersonagemOn;
import com.gutotech.narutogame.databinding.FragmentCharacterStatusBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.AttributesRecyclerViewAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;

public class CharacterStatusFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCharacterStatusBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_character_status, container, false);

        View view = binding.getRoot();

        binding.setCharacter(PersonagemOn.character);

        binding.attributesRecyclerView.setHasFixedSize(true);
        binding.attributesRecyclerView.setAdapter(new AttributesRecyclerViewAdapter(
                PersonagemOn.character.getAttributes().asList()));

        binding.formulasRecyclerView.setHasFixedSize(true);
        binding.formulasRecyclerView.setAdapter(new AttributesRecyclerViewAdapter(
                PersonagemOn.character.getAttributes().getFormulas().asList()));

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_character_status);

        return view;
    }

    @Override
    public int getDescription() {
        return R.string.status;
    }
}
