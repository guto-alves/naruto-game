package com.gutotech.narutogame.ui.home;

import android.content.res.Configuration;
import android.os.Bundle;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.navigation.NavigationView;

import android.util.DisplayMetrics;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.adapter.ExpandableAdapter;
import com.gutotech.narutogame.utils.FragmentUtils;
import com.gutotech.narutogame.utils.SettingsUtils;
import com.gutotech.narutogame.utils.BgMusicUtils;
import com.gutotech.narutogame.utils.SoundUtil;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Configuration configuration = getResources().getConfiguration();
        configuration.fontScale = 1f; // 0.85 small size, 1 normal size, 1,15 big etc
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        metrics.scaledDensity = configuration.fontScale * metrics.density;
        configuration.densityDpi = (int) getResources().getDisplayMetrics().xdpi;
        getBaseContext().getResources().updateConfiguration(configuration, metrics);

        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        HomeViewModel viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        ImageView logoImageView = headerView.findViewById(R.id.logoImageView);
        logoImageView.setOnClickListener(v -> viewModel.goToHome());

        YoYo.with(Techniques.Pulse)
                .duration(2000)
                .repeat(YoYo.INFINITE)
                .playOn(logoImageView);

        ExpandableListView expandableListView = findViewById(R.id.menuExpandableListView);
        ExpandableAdapter adapter = new ExpandableAdapter();
        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener(viewModel);
        expandableListView.expandGroup(HomeViewModel.MAIN_GROUP);

        viewModel.getMenuGroups().observe(this, adapter::setMenuGroups);

        viewModel.getCurrentSection().observe(this, sectionFragment -> {
            FragmentUtils.goTo(HomeActivity.this, (Fragment) sectionFragment);
            closeDrawer();
            SoundUtil.play(getApplicationContext(), R.raw.sound_btn06);
        });

        mDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();
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
    protected void onPause() {
        super.onPause();
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
