package com.gutotech.narutogame.ui.loggedin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ExpandableListView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.adapter.MenuLogadoExpandableLisViewAdapter;
import com.gutotech.narutogame.ui.loggedout.halldafama.HalldafamaFragment;
import com.gutotech.narutogame.ui.loggedout.home.HomeFragment;
import com.gutotech.narutogame.publicentities.CurrentFragment;
import com.gutotech.narutogame.ui.loggedin.accountinfo.UserDataFragment;
import com.gutotech.narutogame.ui.loggedin.changepassword.PasswordChangeFragment;
import com.gutotech.narutogame.ui.loggedin.newcharacteer.CharacterCreateFragment;
import com.gutotech.narutogame.ui.loggedin.selectcharacter.PersonagemSelecionarFragment;
import com.gutotech.narutogame.ui.loggedin.support.SuporteFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LogadoSelecionarActivity extends AppCompatActivity {
    private List<Integer> groupList;
    private HashMap<Integer, List<String>> childList;

    private final int GROUP_USUARIO = 0;
    private final int GROUP_PERSONAGEM = 1;
    private final int GROUP_PRINCIPAL = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logado_selecionar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        buildMenu();
        ExpandableListView expandableListView = findViewById(R.id.expanded_menu_main);
        MenuLogadoExpandableLisViewAdapter adapter = new MenuLogadoExpandableLisViewAdapter(this, groupList, childList);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            if (groupPosition == GROUP_USUARIO) {
                switch (childPosition) {
                    case 0:
                        changeFragment(new UserDataFragment());
                        break;
                    case 1:
                        changeFragment(new PasswordChangeFragment());
                        break;
                    case 2:
                        changeFragment(new SuporteFragment());
                }
            } else if (groupPosition == GROUP_PERSONAGEM) {
                switch (childPosition) {
                    case 0:
                        changeFragment(new PersonagemSelecionarFragment());
                        break;
                    case 1:
                        changeFragment(new CharacterCreateFragment());
                        break;
                }
            } else if (groupPosition == GROUP_PRINCIPAL) {
                switch (childPosition) {
                    case 0:
                        HomeFragment homeFragment = new HomeFragment();
                        homeFragment.setArguments(new Bundle());
                        changeFragment(homeFragment);
                        break;
                    case 1:
                        changeFragment(new HalldafamaFragment());
                        break;
                }
            }

            DrawerLayout drawer1 = findViewById(R.id.drawer_layout);
            drawer1.closeDrawer(GravityCompat.START);
            return false;
        });
        expandableListView.expandGroup(0);
        expandableListView.expandGroup(1);
        expandableListView.expandGroup(2);

        changeFragment(new PersonagemSelecionarFragment());
    }

    private void buildMenu() {
        groupList = new ArrayList<>();
        childList = new HashMap<>();

        groupList.add(R.drawable.layout_usuario);
        groupList.add(R.drawable.layout_personagem);
        groupList.add(R.drawable.layout_principal);

        List<String> itemsFromUSUARIO = new ArrayList<>();
        itemsFromUSUARIO.add("Meus dados");
        itemsFromUSUARIO.add("Trocar Senha");
        itemsFromUSUARIO.add("Suporte");
        childList.put(groupList.get(0), itemsFromUSUARIO);

        List<String> itemsFromPersonagem = new ArrayList<>();
        itemsFromPersonagem.add("Selecionar");
        itemsFromPersonagem.add("Criar Character");
        childList.put(groupList.get(1), itemsFromPersonagem);

        List<String> itemsFromPrincipal = new ArrayList<>();
        itemsFromPrincipal.add("Home");
        itemsFromPrincipal.add("Hall da Fama");
        childList.put(groupList.get(2), itemsFromPrincipal);
    }

    public void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (CurrentFragment.LER_NOTICIA == 1) {
            CurrentFragment.LER_NOTICIA = 0;
            HomeFragment homeFragment = new HomeFragment();
            homeFragment.setArguments(new Bundle());
            changeFragment(homeFragment);
        } else
            super.onBackPressed();
    }
}
