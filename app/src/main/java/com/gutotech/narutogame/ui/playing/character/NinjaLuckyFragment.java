package com.gutotech.narutogame.ui.playing.character;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentNinjaLuckyBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.ui.adapter.LotteryItemsAdapter;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SoundUtil;

import java.security.SecureRandom;

public class NinjaLuckyFragment extends Fragment implements SectionFragment {
    private NinjaLuckyViewModel mViewModel;
    private FragmentNinjaLuckyBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_ninja_lucky,
                container, false);
        mBinding.setLifecycleOwner(this);

        mViewModel = new ViewModelProvider(this).get(NinjaLuckyViewModel.class);
        mBinding.setViewModel(mViewModel);

        mBinding.lotteryItemsRecyclerView.setHasFixedSize(true);
        LotteryItemsAdapter adapter = new LotteryItemsAdapter(getActivity());
        mBinding.lotteryItemsRecyclerView.setAdapter(adapter);

        mViewModel.getLotteryItems().observe(getViewLifecycleOwner(), adapter::setLotteryItems);

        mViewModel.getStartAnimationEvent().observe(getViewLifecycleOwner(), i -> startAnimation());

        mViewModel.getShowPremiumEvent().observe(getViewLifecycleOwner(),
                mBinding.premiumTextView::setText);

        mViewModel.getShowWarningDialogEvent().observe(getViewLifecycleOwner(), this::showWarningDialog);

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_ninja_lucky);

        mBinding.adView.loadAd(new AdRequest.Builder().build());

        return mBinding.getRoot();
    }

    private void showWarningDialog(@StringRes int resid) {
        WarningDialogFragment dialog = WarningDialogFragment.newInstance(getContext(), resid);
        dialog.openDialog(getParentFragmentManager());
        SoundUtil.play(getContext(), R.raw.attention2);
    }

    private void startAnimation() {
        mAnimationEndCount = 0;
        new AnimationTask(mBinding.slot1ImageView).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        new AnimationTask(mBinding.slot2ImageView).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        new AnimationTask(mBinding.slot3ImageView).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        new AnimationTask(mBinding.slot4ImageView).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private int mAnimationEndCount;

    public class AnimationTask extends AsyncTask<Void, Integer, Void> {
        private final SecureRandom random = new SecureRandom();
        final int INITIAL_SCROLL = -1333;

        private ImageView slotImageView;

        AnimationTask(ImageView slotImageView) {
            this.slotImageView = slotImageView;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            int n = random.nextInt(22) + 1;

            int finalScroll = INITIAL_SCROLL + 115 * n;

            int totalScrolls = Math.abs(Math.abs(finalScroll) - Math.abs(INITIAL_SCROLL));
            int currentScroll = 0;
            int millis = 1;

            for (int i = INITIAL_SCROLL + 1; i < finalScroll; i++) {
                publishProgress(i);

                currentScroll = (currentScroll + 1) % (totalScrolls / 2);

                if (currentScroll == 0) {
                    millis++;
                }

                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            slotImageView.setScrollY(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (++mAnimationEndCount == 4) {
                mViewModel.onAnimationEnd();
            }
        }
    }

    @Override
    public int getDescription() {
        return R.string.ninja_lucky;
    }
}
