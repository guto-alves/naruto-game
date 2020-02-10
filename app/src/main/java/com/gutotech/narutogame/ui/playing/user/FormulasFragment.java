package com.gutotech.narutogame.ui.playing.user;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentFormulasBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.StorageUtil;

public class FormulasFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFormulasBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_formulas, container, false);

        StorageUtil.downloadProfileForMsg(getActivity(), binding.msgLayout.profileImageView);
        binding.msgLayout.titleTextView.setText(R.string.about_formulas);
        binding.msgLayout.descriptionTextView.setText(R.string.about_formulas_description);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_formulas);

        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.game_formulas;
    }
}
