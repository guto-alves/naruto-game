package com.gutotech.narutogame.ui;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.gms.ads.MobileAds;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.network.NetworkUtils;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.GameStatusRepository;
import com.gutotech.narutogame.ui.home.HomeActivity;
import com.gutotech.narutogame.ui.loggedin.LoggedInActivity;
import com.gutotech.narutogame.utils.NotificationsUtils;

public class SplashActivity extends AppCompatActivity {
    private WarningDialogFragment mConnectionWarningDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            GameStatusRepository.VERSION_NAME =
                    getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        mConnectionWarningDialog = WarningDialogFragment.newInstance(
                this, R.string.communication_error, R.string.failed_to_connect_description,
                R.string.ok, () -> {
                    if (!NetworkUtils.CONNECTED) {
                        mConnectionWarningDialog.show(getSupportFragmentManager());
                    }
                });

        NetworkUtils.getInstance().addListener(null);

        NotificationsUtils.createNotificationChannel(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            NetworkUtils.getInstance().addListener(connected -> {
                if (connected) {
                    if (mConnectionWarningDialog.isVisible()) {
                        mConnectionWarningDialog.dismiss();
                    }
                    GameStatusRepository.getInstance().getStatus(status -> {
                        if (status.equals(GameStatusRepository.VERSION_NAME) &&
                                AuthRepository.getInstance().isSignedIn()) {
                            startActivity(new Intent(SplashActivity.this, LoggedInActivity.class));
                        } else {
                            AuthRepository.getInstance().signOut();
                            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                        }
                        finish();
                    });
                } else {
                    mConnectionWarningDialog.show(getSupportFragmentManager());
                }
            });
        }, 4000);
    }

}
