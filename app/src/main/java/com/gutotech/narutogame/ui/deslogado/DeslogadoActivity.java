package com.gutotech.narutogame.ui.deslogado;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.adapter.MenuLogadoExpandableLisViewAdapter;
import com.gutotech.narutogame.ui.deslogado.cadastro.CadastroFragment;
import com.gutotech.narutogame.ui.deslogado.halldafama.HalldafamaFragment;
import com.gutotech.narutogame.ui.deslogado.home.HomeFragment;
import com.gutotech.narutogame.ui.deslogado.recuperarsenha.RecuperarSenhaFragment;
import com.gutotech.narutogame.publicentities.CurrentFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeslogadoActivity extends AppCompatActivity {
    private List<Integer> groupList;
    private HashMap<Integer, List<String>> childList;

    private TextView tituloSecaoTextView;
    private final int GROUP_PRINCIPAL = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deslogado);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        ImageView logoImageView = headerView.findViewById(R.id.logoImageView);
        logoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new HomeFragment());
                closeDrawer();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        tituloSecaoTextView = findViewById(R.id.tituloSecaoTextView);

        buildMenu();
        ExpandableListView expandableListView = findViewById(R.id.expanded_menu_main);
        MenuLogadoExpandableLisViewAdapter adapter = new MenuLogadoExpandableLisViewAdapter(this, groupList, childList);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if (groupPosition == GROUP_PRINCIPAL) {
                    switch (childPosition) {
                        case 0:
                            tituloSecaoTextView.setText(R.string.secao_home);
                            changeFragment(new HomeFragment());
                            break;
                        case 1:
                            tituloSecaoTextView.setText(R.string.secao_cadastro);
                            changeFragment(new CadastroFragment());
                            break;
                        case 2:
                            tituloSecaoTextView.setText(R.string.secao_esqueci_minha_senha);
                            changeFragment(new RecuperarSenhaFragment());
                            break;
                        case 3:
                            tituloSecaoTextView.setText(R.string.secao_hall_da_fama);
                            changeFragment(new HalldafamaFragment());
                            break;
                    }
                }

                closeDrawer();
                return false;
            }
        });
        expandableListView.expandGroup(0);

        changeFragment(new CadastroFragment());
    }

    private void buildMenu() {
        groupList = new ArrayList<>();
        childList = new HashMap<>();

        groupList.add(R.drawable.layout_principal);

        List<String> itemsFromTitle1 = new ArrayList<>();
        itemsFromTitle1.add("Home");
        itemsFromTitle1.add("Crie sua conta");
        itemsFromTitle1.add("Esqueci minha senha");
        itemsFromTitle1.add("Hall da fama");
        childList.put(groupList.get(GROUP_PRINCIPAL), itemsFromTitle1);
    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment);
        transaction.commit();
    }

    private void closeDrawer() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (CurrentFragment.LER_NOTICIA == 1) {
            tituloSecaoTextView.setText(R.string.secao_home);
            CurrentFragment.LER_NOTICIA = 0;
            changeFragment(new HomeFragment());
        } else {
            super.onBackPressed();
        }
    }
}
