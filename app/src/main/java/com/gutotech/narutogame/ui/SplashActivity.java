package com.gutotech.narutogame.ui;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.ui.home.HomeActivity;
import com.gutotech.narutogame.ui.loggedin.LoggedInActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        AuthRepository.getInstance().signOut(); // for tests

        if (AuthRepository.getInstance().isSignedin() &&
                AuthRepository.getInstance().getCurrentUser().isEmailVerified())
            startActivity(new Intent(this, LoggedInActivity.class));
        else
            startActivity(new Intent(this, HomeActivity.class));

        finish();
    }
}
