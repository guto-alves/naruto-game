package com.gutotech.narutogame.ui;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;

import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.GameStatusRepository;
import com.gutotech.narutogame.ui.home.HomeActivity;
import com.gutotech.narutogame.ui.loggedin.LoggedInActivity;
import com.gutotech.narutogame.utils.NotificationsUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            GameStatusRepository.setGameVersion(
                    getPackageManager().getPackageInfo(getPackageName(), 0).versionName
            );
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        GameStatusRepository.getInstance().getStatus(status -> {
            if (status.equals(GameStatusRepository.VERSION_NAME)
                    && AuthRepository.getInstance().isSignedIn()) {
                startActivity(new Intent(SplashActivity.this, LoggedInActivity.class));
            } else {
                AuthRepository.getInstance().signOut();
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
            }

            finish();
        });

        NotificationsUtils.createNotificationChannel(this);
    }

}
