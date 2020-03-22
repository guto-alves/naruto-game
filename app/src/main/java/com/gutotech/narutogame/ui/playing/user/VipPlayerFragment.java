package com.gutotech.narutogame.ui.playing.user;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentVipPlayerBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.SpannableStringBuilderCustom;
import com.gutotech.narutogame.utils.StorageUtil;

public class VipPlayerFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentVipPlayerBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_vip_player, container, false);

        VipPlayerViewModel viewModel = new ViewModelProvider(this)
                .get(VipPlayerViewModel.class);

        binding.setViewModel(viewModel);

        ArrayAdapter ninjasAdapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_spinner_item, viewModel.getNinjas());
        ninjasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter classesAdapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_spinner_item, viewModel.getClasses());
        classesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter villagesAdapter = new ArrayAdapter(getActivity(),
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

            StorageUtil.downloadProfileForMsg(getContext(), binding.actionResultLayout.profileImageView);
            binding.actionResultLayout.titleTextView.setText(R.string.successfully_done);
            binding.actionResultLayout.descriptionTextView.setText(builder.getString());
            binding.actionResultLayout.msgConstraintLayout.setVisibility(View.VISIBLE);

            binding.scrollView.post(() -> binding.scrollView.smoothScrollTo(0, 0));
        });

        viewModel.getShowWarningDialogEvent().observe(getViewLifecycleOwner(), resid -> {
            WarningDialogFragment dialog = WarningDialogFragment.newInstance(resid);
            dialog.openDialog(getParentFragmentManager());
        });

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_vip_player);

        return binding.getRoot();
    }

    @Override
    public int getDescription() {
        return R.string.vip_player;
    }
}
