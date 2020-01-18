package com.gutotech.narutogame.ui.playing.character;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentNinjaLuckyBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.LotteryItemsRecyclerAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NinjaLuckyFragment extends Fragment implements SectionFragment {
    private FragmentNinjaLuckyBinding mBinding;
    private NinjaLuckyViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this)
                .get(NinjaLuckyViewModel.class);

        mBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_ninja_lucky, container, false);
        mBinding.setViewModel(mViewModel);

        mBinding.lotteryItemsRecyclerView.setHasFixedSize(true);

        LotteryItemsRecyclerAdapter adapter = new LotteryItemsRecyclerAdapter(getActivity());
        mBinding.lotteryItemsRecyclerView.setAdapter(adapter);

        mViewModel.getLotteryItems().observe(this, adapter::setLotteryItems);

        mViewModel.getStartAnimationEvent().observe(this, i -> startAnimation());

        mViewModel.getShowPremiumEvent().observe(this, premiun -> {
            mBinding.premiumTextView.setText(premiun);
        });

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_ninja_lucky);

        return mBinding.getRoot();
    }

    private int i;

    public void startAnimation() {
        // A cada 112 começa a mostrar outro personagem
        final int initialScroll = -1345;
        final int finalScroll = 1330;

        mBinding.slot1ImageView.setScrollY(initialScroll);
        mBinding.slot2ImageView.setScrollY(initialScroll);
        mBinding.slot3ImageView.setScrollY(initialScroll);
        mBinding.slot4ImageView.setScrollY(initialScroll);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            for (i = initialScroll; i < finalScroll; i++) {
                try {
                    Thread.sleep(3);

                    mBinding.slot1ImageView.post(() -> {
                        mBinding.slot1ImageView.setScrollY(i);
                        Log.i("NinjaLucky", "scrollY = " + i);
                    });

                    mBinding.slot2ImageView.post(() -> {
                        mBinding.slot2ImageView.setScrollY(i);
                    });

                    mBinding.slot3ImageView.post(() -> {
                        mBinding.slot3ImageView.setScrollY(i);
                    });

                    mBinding.slot4ImageView.post(() -> {
                        mBinding.slot4ImageView.setScrollY(i);
                        if (i == finalScroll - 1)
                            mViewModel.onAnimationEnd();
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getDescription() {
        return R.string.ninja_lucky;
    }
}
