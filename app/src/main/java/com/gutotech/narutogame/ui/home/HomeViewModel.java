package com.gutotech.narutogame.ui.home;

import android.view.View;
import android.widget.ExpandableListView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.MenuGroup;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.home.halloffame.HallOfFameFragment;
import com.gutotech.narutogame.ui.home.home.HomeFragment;
import com.gutotech.narutogame.ui.home.recuperarsenha.RecuperarSenhaFragment;
import com.gutotech.narutogame.ui.home.signup.SignupFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel implements ExpandableListView.OnChildClickListener {
    static final int MAIN_GROUP = 0;

    private MutableLiveData<List<MenuGroup>> menuGroups;

    private MutableLiveData<SectionFragment> currentSection = new MutableLiveData<>();

    public HomeViewModel() {
        menuGroups = new MutableLiveData<>(buildMenu());
        goToHome();
    }

    LiveData<SectionFragment> getCurrentSection() {
        return currentSection;
    }

    LiveData<List<MenuGroup>> getMenuGroups() {
        return menuGroups;
    }

    void goToHome() {
        currentSection.setValue(menuGroups.getValue().get(MAIN_GROUP).sections.get(0));
    }

    private List<MenuGroup> buildMenu() {
        List<SectionFragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new SignupFragment());
        fragments.add(new RecuperarSenhaFragment());
        fragments.add(new HallOfFameFragment());

        List<MenuGroup> menuGroups = new ArrayList<>();
        menuGroups.add(MAIN_GROUP, new MenuGroup(R.drawable.menu_titles_main, fragments));

        return menuGroups;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                                int childPosition, long id) {
        currentSection.setValue(menuGroups.getValue().get(groupPosition).sections.get(childPosition));
        return false;
    }
}
