package com.gutotech.narutogame.ui.playing.currentvillage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Requirement;
import com.gutotech.narutogame.databinding.FragmentRamemShopBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialog;
import com.gutotech.narutogame.ui.adapter.ItemShopRecyclerAdapter;
import com.gutotech.narutogame.data.model.ShopUtils;
import com.gutotech.narutogame.ui.playing.RequirementDialogFragment;
import com.gutotech.narutogame.utils.FragmentUtil;

import java.util.List;

public class RamenShopFragment extends Fragment implements SectionFragment,
        ItemShopRecyclerAdapter.OnRequirementsClickListener {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentRamemShopBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_ramem_shop, container, false);

        RamenShopViewModel viewModel = ViewModelProviders.of(this)
                .get(RamenShopViewModel.class);
        binding.setViewModel(viewModel);

        binding.ramensRecyclerView.setHasFixedSize(true);
        ItemShopRecyclerAdapter adapter = new ItemShopRecyclerAdapter(getActivity(),
                ShopUtils.getRamens(), viewModel, this);
        binding.ramensRecyclerView.setAdapter(adapter);

        viewModel.getShowWarningEvent().observe(this, resId -> {
            showWarningDialog(getString(resId));
        });

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_ramen_shop);
        return binding.getRoot();
    }

    private void showWarningDialog(String warning) {
        DialogFragment warningDialog = new WarningDialog(warning);
        warningDialog.show(getFragmentManager(), "WarningDialog");
    }

    @Override
    public void onRequirementsClick(List<Requirement> requirements) {
        DialogFragment dialog = new RequirementDialogFragment(requirements);
        dialog.show(getFragmentManager(), "RequirementDialogFragment");
    }

    @Override
    public int getDescription() {
        return R.string.ramen_shop;
    }
}
