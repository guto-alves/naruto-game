package com.gutotech.narutogame.ui.playing.character;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentNinjaLuckyBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.LotteryItemsRecyclerAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
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

        mViewModel.getStartAnimationEvent().observe(this, i -> {
            startAnimation();
        });

        mViewModel.getShowPremiumEvent().observe(this, premiun ->
                mBinding.premiumTextView.setText(premiun));

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_ninja_lucky);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Toast.makeText(getActivity(), "" + calendar.get(Calendar.DAY_OF_WEEK), Toast.LENGTH_LONG).show();

        return mBinding.getRoot();
    }

    public void startAnimation() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        new AnimationTask(mBinding.slot1ImageView).executeOnExecutor(executorService);
        new AnimationTask(mBinding.slot2ImageView).executeOnExecutor(executorService);
        new AnimationTask(mBinding.slot3ImageView).executeOnExecutor(executorService);
        new AnimationTask(mBinding.slot4ImageView).executeOnExecutor(executorService);
    }

    private int animationEndCount;

    private class AnimationTask extends AsyncTask<Void, Integer, Void> {
        private final SecureRandom random = new SecureRandom();
        final int INITIAL_SCROLL = -1333;
        final int FINAL_SCROLL = 1333;

        private ImageView slotImageView;

        public AnimationTask(ImageView slotImageView) {
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
