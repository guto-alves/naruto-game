package com.gutotech.narutogame.ui.playing.battles;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.gutotech.narutogame.utils.OnSwipeTouchListener;

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
            goTo(new DojoNPCFightersFragment());
        }

        FragmentUtils.setSectionTitle(getActivity(), R.string.section_dojo);

//        OnSwipeTouchListener onSwipeTouchListener = new OnSwipeTouchListener(getActivity()) {
//            @Override
//            public void onSwipeLeft() {
//                goToDojoNpc();
//            }
//
//            @Override
//            public void onSwipeRight() {
//                goToDojoPvp();
//            }
//        };

        GestureDetectorCompat gestureDetector = new GestureDetectorCompat(
                getContext(), new OnSwipeGestureListener());

        ((PlayingActivity) getActivity()).registerGestureListener(gestureDetector);

        mBinding.adView.loadAd(new AdRequest.Builder().build());

        return mBinding.getRoot();
    }

    private void goToDojoNpc() {
        goTo(new DojoNPCFightersFragment());
        mBinding.dojoNpcButton.setBackgroundResource(R.drawable.bg_button_orange);
        mBinding.dojoPvpButton.setBackgroundResource(R.drawable.bg_button);
    }

    private void goToDojoPvp() {
        goTo(new DojoPvpBattlesFragment());
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

    private final class OnSwipeGestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;

            Log.e("MyTag", "onFling");

            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();

                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            goToDojoPvp();
                        } else {
                            goToDojoNpc();
                        }
                        result = true;
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            return result;
        }
    }
}
