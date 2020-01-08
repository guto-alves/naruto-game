package com.gutotech.narutogame.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.ui.deslogado.DeslogadoActivity;
import com.gutotech.narutogame.ui.logado.LogadoSelecionarActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseAuth auth = FirebaseConfig.getAuth();

        if (auth.getCurrentUser() != null)
            startActivity(new Intent(SplashActivity.this, LogadoSelecionarActivity.class));
        else
            startActivity(new Intent(this, DeslogadoActivity.class));

        finish();
    }
}
