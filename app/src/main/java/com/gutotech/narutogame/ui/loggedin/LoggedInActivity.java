package com.gutotech.narutogame.ui.loggedin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.adapter.ExpandableAdapter;
import com.gutotech.narutogame.utils.FragmentUtil;
import com.gutotech.narutogame.utils.SoundsUtil;

public class LoggedInActivity extends AppCompatActivity {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LoggedInViewModel viewModel = ViewModelProviders.of(this)
                .get(LoggedInViewModel.class);

        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        ImageView logoImageView = headerView.findViewById(R.id.logoImageView);
        logoImageView.setOnClickListener(v -> viewModel.goToHome());

        ExpandableListView expandableListView = findViewById(R.id.menuExpandableListView);
        ExpandableAdapter adapter = new ExpandableAdapter();
        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener(viewModel);
        expandableListView.expandGroup(LoggedInViewModel.USER_GROUP);
        expandableListView.expandGroup(LoggedInViewModel.CHARACTER_GROUP);
        expandableListView.expandGroup(LoggedInViewModel.MAIN_GROUP);

        viewModel.getMenuGroups().observe(this, adapter::setMenuGroups);

        viewModel.getCurrentSection().observe(this, sectionFragment -> {
            FragmentUtil.goTo(this, (Fragment) sectionFragment);
            closeDrawer();
        });

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        sounds = new SoundsUtil(this);
    }

    private void closeDrawer() {
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private SoundsUtil sounds;

    @Override
    protected void onStart() {
        super.onStart();
        sounds.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        sounds.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sounds.release();
    }
}
