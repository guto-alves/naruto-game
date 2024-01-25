package com.gutotech.narutogame.ui.loggedin;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.navigation.NavigationView;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.network.NetworkUtils;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.GameStatusRepository;
import com.gutotech.narutogame.data.repository.PlayerRepository;
import com.gutotech.narutogame.ui.MaintenanceActivity;
import com.gutotech.narutogame.ui.WarningDialogFragment;
import com.gutotech.narutogame.ui.adapter.ExpandableListAdapter;
import com.gutotech.narutogame.utils.BgMusicUtils;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SettingsUtils;
import com.gutotech.narutogame.utils.SoundUtil;

public class LoggedInActivity extends AppCompatActivity
        implements WarningDialogFragment.WarningDialogListener {
    private DrawerLayout mDrawer;
    private boolean mInitialization = true;
    private WarningDialogFragment mConnectionWarningDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Configuration configuration = getResources().getConfiguration();
        configuration.fontScale = 1f; // 0.85 small size, 1 normal size, 1,15 big etc
        DisplayMetrics metrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getDisplay().getMetrics(metrics);
        }
        metrics.scaledDensity = configuration.fontScale * metrics.density;
        configuration.densityDpi = (int) getResources().getDisplayMetrics().xdpi;
        getBaseContext().getResources().updateConfiguration(configuration, metrics);

        setContentView(R.layout.activity_logged_in);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LoggedInViewModel viewModel = new ViewModelProvider(this)
                .get(LoggedInViewModel.class);

        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        ImageView logoImageView = headerView.findViewById(R.id.logoImageView);
        logoImageView.setOnClickListener(v -> viewModel.goToHome());

        YoYo.with(Techniques.Pulse)
                .duration(2000)
                .repeat(YoYo.INFINITE)
                .playOn(logoImageView);

        ExpandableListView expandableListView = findViewById(R.id.menuExpandableListView);
        ExpandableListAdapter adapter = new ExpandableListAdapter();
        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener(viewModel);
        expandableListView.expandGroup(LoggedInViewModel.CHARACTER_GROUP);
        expandableListView.expandGroup(LoggedInViewModel.MAIN_GROUP);

        viewModel.getMenuGroups().observe(this, adapter::setMenuGroups);

        viewModel.getCurrentSection().observe(this, sectionFragment -> {
            FragmentUtils.goTo(this, (Fragment) sectionFragment);
            closeDrawer();
            if (!mInitialization) {
                SoundUtil.play(getApplicationContext(), R.raw.sound_btn06);
            } else {
                mInitialization = false;
            }
        });

        GameStatusRepository.getInstance().registerGameStatusListener(status -> {
            if (!status.equals(GameStatusRepository.VERSION_NAME)) {
                GameStatusRepository.getInstance().removeGameStatusListener();
                PlayerRepository.getInstance().setSignedIn(false, null);
                AuthRepository.getInstance().signOut();
                finish();
                startActivity(new Intent(this, MaintenanceActivity.class));
            }
        });

        mDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        mConnectionWarningDialog = WarningDialogFragment.newInstance(
                this, R.string.communication_error,
                R.string.communication_error_description,
                R.string.ok, 11);

        viewModel.getShowConnectionWarning().observe(this, connected -> {
            if (connected) {
                if (mConnectionWarningDialog.isVisible()) {
                    mConnectionWarningDialog.dismiss();
                }
            } else {
                mConnectionWarningDialog.show(getSupportFragmentManager());
            }
        });
    }

    @Override
    public void onCloseClick(int requestCode) {
        if (!NetworkUtils.CONNECTED) {
            mConnectionWarningDialog.show(getSupportFragmentManager());
        }
    }

    private void closeDrawer() {
        mDrawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    private BgMusicUtils mBgMusicUtils;

    @Override
    protected void onStart() {
        super.onStart();
        if (SettingsUtils.get(this, SettingsUtils.BG_MUSIC_KEY)) {
            if (mBgMusicUtils == null) {
                mBgMusicUtils = new BgMusicUtils(this);
            }
            mBgMusicUtils.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBgMusicUtils != null) {
            mBgMusicUtils.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBgMusicUtils != null) {
            mBgMusicUtils.release();
        }
    }
}
