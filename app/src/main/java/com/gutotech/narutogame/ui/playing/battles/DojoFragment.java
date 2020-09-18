package com.gutotech.narutogame.ui.playing.battles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.ads.AdRequest;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.databinding.FragmentDojoBinding;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.playing.PlayingActivity;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.OnSwipeGestureListener;

public class DojoFragment extends Fragment implements SectionFragment {
    private FragmentDojoBinding mBinding;

    public DojoFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dojo, container, false);

        mBinding.dojoNpcButton.setOnClickListener(v -> goToDojoNpc());

        mBinding.dojoPvpButton.setOnClickListener(v -> goToDojoPvp());

        Bundle bundle = getArguments();

        if (bundle != null) {
            String battleType = bundle.getString("battleType");

            if (battleType.equals("PVP-DOJO")) {
                goToDojoPvp();
            } else {
                goToDojoNpc();
            }
        } else {
            mBinding.dojoNpcButton.setBackgroundResource(R.drawable.bg_button_orange);
            goTo(new DojoNpcFragment());
        }

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_dojo);

        GestureDetectorCompat gestureDetector = new GestureDetectorCompat(
                getContext(), new OnSwipeGestureListener() {
            @Override
            public void onSwipeLeft() {
                goToDojoPvp();
            }

            @Override
            public void onSwipeRight() {
                goToDojoNpc();
            }
        });

        ((PlayingActivity) getActivity()).registerGestureListener(gestureDetector);

        mBinding.adView.loadAd(new AdRequest.Builder().build());

        return mBinding.getRoot();
    }

    private void goToDojoNpc() {
        goTo(new DojoNpcFragment());
        mBinding.dojoNpcButton.setBackgroundResource(R.drawable.bg_button_orange);
        mBinding.dojoPvpButton.setBackgroundResource(R.drawable.bg_button);
    }

    private void goToDojoPvp() {
        goTo(new DojoPvpFragment());
        mBinding.dojoNpcButton.setBackgroundResource(R.drawable.bg_button);
        mBinding.dojoPvpButton.setBackgroundResource(R.drawable.bg_button_orange);
    }

    private void goTo(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameContainer, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public int getDescription() {
        return R.string.dojo;
    }
}
