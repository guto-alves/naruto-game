package com.gutotech.narutogame.ui.playing.currentvillage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentRamemShopBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialog;
import com.gutotech.narutogame.ui.adapter.ItemShopAdapter;
import com.gutotech.narutogame.data.model.ShopUtils;
import com.gutotech.narutogame.utils.FragmentUtil;

public class RamenShopFragment extends Fragment implements SectionFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentRamemShopBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_ramem_shop, container, false);

        RamenShopViewModel viewModel = new ViewModelProvider(this)
                .get(RamenShopViewModel.class);
        binding.setViewModel(viewModel);

        ItemShopAdapter adapter = new ItemShopAdapter(getActivity(),
                getParentFragmentManager(), viewModel);
        binding.ramensRecyclerView.setHasFixedSize(true);
        binding.ramensRecyclerView.setAdapter(adapter);
        adapter.setItemsList(ShopUtils.getRamens());

        viewModel.getShowWarningEvent().observe(getViewLifecycleOwner(), resId ->
                showWarningDialog(resId));

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_ramen_shop);
        return binding.getRoot();
    }

    private void showWarningDialog(@StringRes int resid) {
        WarningDialog dialog = WarningDialog.newInstance(resid);
        dialog.openDialog(getParentFragmentManager());
    }

    @Override
    public int getDescription() {
        return R.string.ramen_shop;
    }
}
