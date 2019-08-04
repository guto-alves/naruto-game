package com.gutotech.narutogame.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.gutotech.narutogame.config.ConfigFirebase;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseAuth auth = ConfigFirebase.getAuth();

        if (auth.getCurrentUser() != null)
            startActivity(new Intent(SplashActivity.this, LogadoSelecionarActivity.class));
        else
            startActivity(new Intent(this, DeslogadoActivity.class));

        finish();
    }
}
