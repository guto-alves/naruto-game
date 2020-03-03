package com.gutotech.narutogame.ui.playing.character;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentNinjaLuckyBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialog;
import com.gutotech.narutogame.ui.adapter.LotteryItemsAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;

import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NinjaLuckyFragment extends Fragment implements SectionFragment {
    private FragmentNinjaLuckyBinding mBinding;
    private NinjaLuckyViewModel mViewModel;

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

        mViewModel.getShowPremiumEvent().observe(getViewLifecycleOwner(), premiun ->
                mBinding.premiumTextView.setText(premiun));

        mViewModel.getShowWarningDialogEvent().observe(getViewLifecycleOwner(), resId ->
                showWarningDialog(getString(resId)));

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_ninja_lucky);

        return mBinding.getRoot();
    }

    private void showWarningDialog(String warning) {
        DialogFragment warningDialog = new WarningDialog(warning);
        warningDialog.show(getParentFragmentManager(), "WarningDialog");
    }

    private void startAnimation() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        new AnimationTask(mBinding.slot1ImageView).executeOnExecutor(executorService);
        new AnimationTask(mBinding.slot2ImageView).executeOnExecutor(executorService);
        new AnimationTask(mBinding.slot3ImageView).executeOnExecutor(executorService);
        new AnimationTask(mBinding.slot4ImageView).executeOnExecutor(executorService);
    }

    private int animationEndCount;

    public class AnimationTask extends AsyncTask<Void, Integer, Void> {
        private final SecureRandom random = new SecureRandom();
        final int INITIAL_SCROLL = -1333;
        final int FINAL_SCROLL = 1333;

        private ImageView slotImageView;

        AnimationTask(ImageView slotImageView) {
            this.slotImageView = slotImageView;
        }

        @Override
        protected void onPreExecute() {
            animationEndCount = 0;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            int n = random.nextInt(22) + 1;

            int totalScroll = INITIAL_SCROLL + 115 * n;

            for (int i = INITIAL_SCROLL + 1; i < totalScroll; i++) {
                publishProgress(i);

                try {
                    Thread.sleep(3);
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
            if (++animationEndCount == 4) {
                mViewModel.onAnimationEnd();
            }
        }
    }

    @Override
    public int getDescription() {
        return R.string.ninja_lucky;
    }
}
