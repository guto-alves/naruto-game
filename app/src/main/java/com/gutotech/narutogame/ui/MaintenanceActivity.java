package com.gutotech.narutogame.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.repository.GameStatusRepository;

public class MaintenanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);

        ImageView goToHomeImageView = findViewById(R.id.goToHomeImageView);

        YoYo.with(Techniques.Pulse)
                .duration(2000)
                .repeat(YoYo.INFINITE)
                .playOn(goToHomeImageView);

        goToHomeImageView.setOnClickListener(v -> finish());

        TextView descriptionTextView = findViewById(R.id.descriptionTextView);

        TextView obsTextView = findViewById(R.id.obsTextView);

        GameStatusRepository.getInstance().getGameStatus(gameStatus -> {
            if (gameStatus.get("status").equals(GameStatusRepository.VERSION_NAME)) {
                finish();
                return;
            }

            String[] params = gameStatus.get("params").split("\\$");

            String description;

            if (gameStatus.get("status").equals("maintenance")) {
                description = getString(R.string.maintenance_status, params[0], params[1]);
            } else {
                description = getString(R.string.new_version_status, gameStatus.get("status"), params[0]);
            }

            descriptionTextView.setText(description);
            obsTextView.setText(gameStatus.get("obs"));
        });
    }
}
