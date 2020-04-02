package com.gutotech.narutogame.ui.home;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

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
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.MusicSettingsUtils;
import com.gutotech.narutogame.utils.MusicUtils;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        HomeViewModel viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        ImageView logoImageView = headerView.findViewById(R.id.logoImageView);
        logoImageView.setOnClickListener(v -> viewModel.goToHome());

        ExpandableListView expandableListView = findViewById(R.id.menuExpandableListView);
        ExpandableAdapter adapter = new ExpandableAdapter();
        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener(viewModel);
        expandableListView.expandGroup(HomeViewModel.MAIN_GROUP);

        viewModel.getMenuGroups().observe(this, adapter::setMenuGroups);

        viewModel.getCurrentSection().observe(this, sectionFragment -> {
            FragmentUtil.goTo(HomeActivity.this, (Fragment) sectionFragment);
            closeDrawer();
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

    private MusicUtils mMusicUtils;

    @Override
    protected void onStart() {
        super.onStart();
        if (MusicSettingsUtils.enabled(this)) {
            mMusicUtils = new MusicUtils(this);
            mMusicUtils.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mMusicUtils != null) {
            mMusicUtils.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMusicUtils != null) {
            mMusicUtils.release();
        }
    }
}
