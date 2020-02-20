package com.gutotech.narutogame.ui;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.ui.home.HomeActivity;
import com.gutotech.narutogame.ui.loggedin.LoggedInActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();

        DatabaseReference maintenanceReference = FirebaseConfig.getDatabase()
                .child("maintenance");

        maintenanceReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean maintenance = dataSnapshot.getValue(Boolean.class);

                if (maintenance) {
                    startActivity(new Intent(SplashActivity.this, MaintenanceActivity.class));
                } else if (AuthRepository.getInstance().isSignedIn() &&
                        AuthRepository.getInstance().getCurrentUser().isEmailVerified()) {
                    startActivity(new Intent(SplashActivity.this, LoggedInActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                }

                finish();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
