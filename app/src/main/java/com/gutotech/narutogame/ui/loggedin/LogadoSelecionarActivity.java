package com.gutotech.narutogame.ui.loggedin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ExpandableListView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.ExpandableAdapter;
import com.gutotech.narutogame.ui.loggedout.halloffame.HallOfFameFragment;
import com.gutotech.narutogame.ui.loggedout.home.HomeFragment;
import com.gutotech.narutogame.ui.loggedin.accountinfo.UserDataFragment;
import com.gutotech.narutogame.ui.loggedin.changepassword.PasswordChangeFragment;
import com.gutotech.narutogame.ui.loggedin.newcharacteer.CharacterCreateFragment;
import com.gutotech.narutogame.ui.loggedin.selectcharacter.CharacterSelectFragment;
import com.gutotech.narutogame.ui.loggedin.support.SuporteFragment;
import com.gutotech.narutogame.utils.FragmentUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LogadoSelecionarActivity extends AppCompatActivity {
    private List<Integer> groupList;
    private HashMap<Integer, List<SectionFragment>> sectionList;

    private final int GROUP_USUARIO = 0;
    private final int GROUP_PERSONAGEM = 1;
    private final int GROUP_PRINCIPAL = 2;

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logado_selecionar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        buildMenu();
        ExpandableListView expandableListView = findViewById(R.id.expanded_menu_main);
        ExpandableAdapter adapter = new ExpandableAdapter(groupList, sectionList);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            FragmentUtil.goTo(this, (Fragment) sectionList.get(groupPosition).get(childPosition));

            drawer.closeDrawer(GravityCompat.START);
            return false;
        });
        expandableListView.expandGroup(0);
        expandableListView.expandGroup(1);
        expandableListView.expandGroup(2);

        FragmentUtil.goTo(this, new CharacterSelectFragment());
    }

    private void buildMenu() {
        groupList = new ArrayList<>();
        sectionList = new HashMap<>();

        groupList.add(R.drawable.layout_usuario);
        groupList.add(R.drawable.layout_personagem);
        groupList.add(R.drawable.layout_principal);

        List<SectionFragment> sections1 = new ArrayList<>();
        sections1.add(new UserDataFragment());
        sections1.add(new PasswordChangeFragment());
        sections1.add(new SuporteFragment());
        sectionList.put(0, sections1);

        List<SectionFragment> sections2 = new ArrayList<>();
        sections2.add(new CharacterSelectFragment());
        sections2.add(new CharacterCreateFragment());
        sectionList.put(1, sections2);

        List<SectionFragment> sections3 = new ArrayList<>();
        sections3.add(new HomeFragment());
        sections3.add(new HallOfFameFragment());
        sectionList.put(2, sections3);
    }

    @Override
    public void onBackPressed() {
        drawer = findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
