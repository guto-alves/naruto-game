package com.gutotech.narutogame.ui;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.ui.loggedout.DeslogadoActivity;
import com.gutotech.narutogame.ui.loggedin.LogadoSelecionarActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AuthRepository.getInstance().signOut(); // for tests

        if (AuthRepository.getInstance().isSignedin() &&
                AuthRepository.getInstance().getCurrentUser().isEmailVerified())
            startActivity(new Intent(this, LogadoSelecionarActivity.class));
        else
            startActivity(new Intent(this, DeslogadoActivity.class));

        finish();
    }
}
