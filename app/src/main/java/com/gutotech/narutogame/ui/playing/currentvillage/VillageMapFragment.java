package com.gutotech.narutogame.ui.playing.currentvillage;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Village;
import com.gutotech.narutogame.databinding.FragmentVillageMapBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.VillageMapRecyclerViewAdapter;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.utils.FragmentUtil;

public class VillageMapFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentVillageMapBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_village_map, container, false);

        String villageName;

        Bundle bundle = getArguments();

        if (bundle != null) {
            Village village = (Village) bundle.getSerializable("village");
            villageName = village.name;
            binding.villageMapRecyclerView.setBackgroundResource(village.mapResId);
        } else {
            villageName = CharOn.character.getVillage().name;
            binding.villageMapRecyclerView.setBackgroundResource(
                    CharOn.character.getVillage().mapResId);
        }

        VillageMapViewModel viewModel = ViewModelProviders.of(this,
                new VillageMapViewModelFactory(villageName)).get(VillageMapViewModel.class);

        binding.setViewModel(viewModel);

        VillageMapRecyclerViewAdapter adapter = new VillageMapRecyclerViewAdapter(getActivity(),
                VillageMapViewModel.MAP_LENGTH, viewModel);

        binding.villageMapRecyclerView.setHasFixedSize(true);
        binding.villageMapRecyclerView.setAdapter(adapter);

        viewModel.getCharactersOnTheMap().observe(this, adapter::setMap);

        viewModel.getShowWarningDialogEvent().observe(this, this::showDialog);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_village_map);

        return binding.getRoot();
    }

    private void showDialog(@StringRes int messageId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(messageId);
        builder.setPositiveButton("OK", null);
        builder.create().show();
    }

    @Override
    public int getDescription() {
        return R.string.village_map;
    }
}
