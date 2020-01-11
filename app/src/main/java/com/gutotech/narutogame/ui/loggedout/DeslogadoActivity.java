package com.gutotech.narutogame.ui.loggedout;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.adapter.ExpandableAdapter;
import com.gutotech.narutogame.ui.loggedout.registration.RegistrationFragment;
import com.gutotech.narutogame.ui.loggedout.halldafama.HalldafamaFragment;
import com.gutotech.narutogame.ui.loggedout.home.HomeFragment;
import com.gutotech.narutogame.ui.loggedout.recuperarsenha.RecuperarSenhaFragment;
import com.gutotech.narutogame.util.FragmentUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeslogadoActivity extends AppCompatActivity {
    private List<Integer> groupList;
    private HashMap<Integer, List<Integer>> childList;

    private final int GROUP_PRINCIPAL = 0;

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deslogado);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        ImageView logoImageView = headerView.findViewById(R.id.logoImageView);
        logoImageView.setOnClickListener(v -> {
            FragmentUtil.changeToFragment(DeslogadoActivity.this, new HomeFragment());
            drawer.closeDrawer(GravityCompat.START);
        });

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        buildMenu();
        ExpandableListView expandableListView = findViewById(R.id.expanded_menu_main);

        ExpandableAdapter adapter = new ExpandableAdapter(this, groupList, childList);

        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            if (groupPosition == GROUP_PRINCIPAL) {
                switch (childPosition) {
                    case 0:
                        FragmentUtil.changeToFragment(DeslogadoActivity.this, new HomeFragment());
                        break;
                    case 1:
                        FragmentUtil.changeToFragment(DeslogadoActivity.this, new RegistrationFragment());
                        break;
                    case 2:
                        FragmentUtil.changeToFragment(DeslogadoActivity.this, new RecuperarSenhaFragment());
                        break;
                    case 3:
                        FragmentUtil.changeToFragment(DeslogadoActivity.this, new HalldafamaFragment());
                        break;
                }
            }

            drawer.closeDrawer(GravityCompat.START);
            return false;
        });
        expandableListView.expandGroup(0);

        FragmentUtil.changeToFragment(this, new RegistrationFragment());
    }

    private void buildMenu() {
        groupList = new ArrayList<>();
        childList = new HashMap<>();

        groupList.add(R.drawable.layout_principal);

        List<Integer> items = new ArrayList<>();
        items.add(R.string.home);
        items.add(R.string.create_an_account);
        items.add(R.string.forgot_my_password);
        items.add(R.string.hall_da_fama);
        childList.put(0, items);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
