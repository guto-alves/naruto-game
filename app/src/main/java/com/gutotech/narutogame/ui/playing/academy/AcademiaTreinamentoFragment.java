package com.gutotech.narutogame.ui.playing.academy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.PersonagemOn;
import com.gutotech.narutogame.databinding.FragmentAcademyTrainningBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.DistributedPointsRecyclerAdapter;
import com.gutotech.narutogame.ui.MyListener;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.StorageUtil;

public class AcademiaTreinamentoFragment extends Fragment implements MyListener, SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AcademyTrainningViewModel viewModel = ViewModelProviders.of(this)
                .get(AcademyTrainningViewModel.class);

        FragmentAcademyTrainningBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_academy_trainning, container, false);

        binding.setViewModel(viewModel);

        binding.msgLayout.msgTitleTextView.setText(R.string.attribute_training_title);
        binding.msgLayout.msgTextView.setText(R.string.attribute_training_description);
        StorageUtil.downloadProfileForMsg(getContext(), binding.msgLayout.msgProfileImageView,
                PersonagemOn.character.getVillage().id);

        binding.distributedPointsRecyclerView.setHasFixedSize(true);
        DistributedPointsRecyclerAdapter adapter = new DistributedPointsRecyclerAdapter(getContext());
        adapter.setDistributedAttributes(PersonagemOn.character.getAttributes().asList());
        binding.distributedPointsRecyclerView.setAdapter(adapter);

        String[] percents = getResources().getStringArray(R.array.attribute_percent);
        binding.quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                double percent = Integer.parseInt(percents[position]) / 100;
                viewModel.setPercent(percent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, treinos);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_attribute_training);

        return binding.getRoot();
    }

    private void addListener() {
    }

    @Override
    public void callback(int position) {
//        Atributo atributo = PersonagemOn.character.getAtributosDistribuitos().get(position);
//
//        atributo.setTotal(atributo.getTotal() + 1);
//        PersonagemOn.character.salvar();
//
//        pontosDistribuitosAdapter.notifyDataSetChanged();
    }

    @Override
    public int getDescription() {
        return R.string.attribute_training;
    }
}
