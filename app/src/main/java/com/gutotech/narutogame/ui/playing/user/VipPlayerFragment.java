package com.gutotech.narutogame.ui.playing.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.StorageUtils;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Ninja;
import com.gutotech.narutogame.databinding.FragmentVipPlayerBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SoundUtil;
import com.gutotech.narutogame.utils.SpannableStringBuilderCustom;

import java.util.Objects;

public class VipPlayerFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentVipPlayerBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_vip_player, container, false);

        VipPlayerViewModel viewModel = new ViewModelProvider(this)
                .get(VipPlayerViewModel.class);

        binding.setViewModel(viewModel);

        ArrayAdapter<Ninja> ninjasAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                android.R.layout.simple_spinner_item, viewModel.getNinjas());
        ninjasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<Classe> classesAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, viewModel.getClasses());
        classesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> villagesAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, viewModel.getVillages(getContext()));
        villagesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.ninjasSpinner.setAdapter(ninjasAdapter);
        binding.classesSpinner.setAdapter(classesAdapter);
        binding.villagesSpinner.setAdapter(villagesAdapter);

        binding.actionResultLayout.msgConstraintLayout.setVisibility(View.GONE);

        viewModel.getShowSuccessMessageEvent().observe(getViewLifecycleOwner(), resId -> {
            SpannableStringBuilderCustom builder = new SpannableStringBuilderCustom(getContext());
            builder.append(R.string.you_have_acquired);
            builder.append();
            builder.append(resId, R.color.colorGreen);

            StorageUtils.loadProfileForMsg(getContext(), binding.actionResultLayout.profileImageView);
            binding.actionResultLayout.titleTextView.setText(R.string.successfully_done);
            binding.actionResultLayout.descriptionTextView.setText(builder.getString());
            binding.actionResultLayout.msgConstraintLayout.setVisibility(View.VISIBLE);

            binding.scrollView.post(() -> binding.scrollView.smoothScrollTo(0, 0));

            SoundUtil.play(getContext(), R.raw.get_item02);
        });

        viewModel.getShowWarningDialogEvent().observe(getViewLifecycleOwner(), resid -> {
            WarningDialogFragment dialog = WarningDialogFragment.newInstance(getContext(), resid);
            dialog.openDialog(getParentFragmentManager());
            SoundUtil.play(getContext(), R.raw.attention2);
        });

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_vip_player);

        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.vip_player;
    }
}
