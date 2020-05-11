package com.gutotech.narutogame.ui.playing.battles;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentHospitalRoomBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.data.firebase.StorageUtils;
import com.gutotech.narutogame.utils.SoundUtil;

import es.dmoral.toasty.Toasty;

public class HospitalRoomFragment extends Fragment implements SectionFragment {
    private RewardedAd mRewardedAd;

    public HospitalRoomFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentHospitalRoomBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_hospital_room, container, false);

        StorageUtils.downloadProfileForMsg(getContext(), binding.profileImageView);

        CharOn.character.setMapId(CharOn.character.getVillage().ordinal());

        int payment = 20 * CharOn.character.getLevel();

        binding.descriptionTextView.setText(getString(R.string.pay_specialist_description, payment));

        binding.payButton.setText(getString(R.string.pay_ry, payment));
        binding.payButton.setOnClickListener(view1 -> {
            if (CharOn.character.getRyous() >= payment) {
                WarningDialogFragment warningDialog = WarningDialogFragment.newInstance(
                        getContext(), R.string.paid_hospital, false,
                        () -> {
                            CharOn.character.subRyous(payment);
                            CharOn.character.full();
                            CharOn.character.setHospital(false);
                        });
                warningDialog.openDialog(getParentFragmentManager());
                SoundUtil.play(getContext(), R.raw.sound_pop);
            } else {
                WarningDialogFragment warningDialog = WarningDialogFragment.newInstance(
                        getContext(), R.string.dont_enough_money_for_treatment);
                warningDialog.openDialog(getParentFragmentManager());
                SoundUtil.play(getContext(), R.raw.attention2);
            }
        });

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_hospital_room);

        mRewardedAd = createAndLoadRewardedAd();

        binding.watchVideoButton.setOnClickListener(v -> {
            if (mRewardedAd.isLoaded()) {
                RewardedAdCallback adCallback = new RewardedAdCallback() {
                    @Override
                    public void onRewardedAdOpened() {
                    }

                    @Override
                    public void onRewardedAdClosed() {
                        mRewardedAd = createAndLoadRewardedAd();
                    }

                    @Override
                    public void onUserEarnedReward(@NonNull RewardItem reward) {
                        CharOn.character.full();
                        CharOn.character.setHospital(false);
                    }

                    @Override
                    public void onRewardedAdFailedToShow(int errorCode) {
                    }
                };
                mRewardedAd.show(getActivity(), adCallback);
            } else {
                Toasty.warning(getContext(), R.string.rewarded_ad_wasnt_loaded_yet_warning).show();
            }
        });

        YoYo.with(Techniques.BounceInLeft)
                .duration(2000)
                .playOn(binding.watchVideoButton);

        return binding.getRoot();
    }

    private RewardedAd createAndLoadRewardedAd() {
        RewardedAd rewardedAd = new RewardedAd(getContext(),
                "ca-app-pub-3940256099942544/5224354917");
        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
            }

            @Override
            public void onRewardedAdFailedToLoad(int errorCode) {
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
        return rewardedAd;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (CharOn.character.getFormulas().isFull()) {
            CharOn.character.setHospital(false);
        }
    }

    @Override
    public int getDescription() {
        return R.string.hospital;
    }
}
