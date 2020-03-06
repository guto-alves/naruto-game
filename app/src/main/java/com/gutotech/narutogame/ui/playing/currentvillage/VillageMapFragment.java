package com.gutotech.narutogame.ui.playing.currentvillage;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Village;
import com.gutotech.narutogame.databinding.FragmentVillageMapBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.VillageMapAdapter;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.ui.playing.PlayingActivity;
import com.gutotech.narutogame.utils.FragmentUtil;

public class VillageMapFragment extends Fragment implements SectionFragment {
    private float mScaleFactor = 1.0f;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentVillageMapBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_village_map, container, false);

        Village village;

        Bundle bundle = getArguments();

        if (bundle != null) {
            village = (Village) bundle.getSerializable("village");
        } else {
            village = CharOn.character.getVillage();
        }

        binding.villageMapRecyclerView.setBackgroundResource(village.mapResId);

        VillageMapViewModel viewModel = new ViewModelProvider(this,
                new VillageMapViewModelFactory(village)).get(VillageMapViewModel.class);

        binding.setViewModel(viewModel);

        VillageMapAdapter adapter = new VillageMapAdapter(getActivity(),
                village.placeEntries, viewModel);

        binding.villageMapRecyclerView.setHasFixedSize(true);
        binding.villageMapRecyclerView.setAdapter(adapter);

        viewModel.getCharactersOnTheMap().observe(getViewLifecycleOwner(), adapter::setMap);

        viewModel.getShowWarningDialogEvent().observe(getViewLifecycleOwner(), this::showDialog);

        ScaleGestureDetector mScaleGestureDetector = new ScaleGestureDetector(getActivity(),
                new ScaleGestureDetector.SimpleOnScaleGestureListener() {
                    @Override
                    public boolean onScale(ScaleGestureDetector detector) {
                        mScaleFactor *= detector.getScaleFactor();
                        mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 2.0f));
                        binding.villageMapRecyclerView.setScaleX(mScaleFactor);
                        binding.villageMapRecyclerView.setScaleY(mScaleFactor);
                        return true;
                    }
                });

        ((PlayingActivity) getActivity()).registerScaleGestureDetector(mScaleGestureDetector);

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
