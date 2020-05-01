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
import com.gutotech.narutogame.ui.home.passwordrecovery.PasswordRecoveryFragment;
import com.gutotech.narutogame.ui.home.signup.SignUpFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel implements ExpandableListView.OnChildClickListener {
    static final int MAIN_GROUP = 0;

    private MutableLiveData<List<MenuGroup>> mMenuGroups;

    private MutableLiveData<SectionFragment> mCurrentSection = new MutableLiveData<>();

    public HomeViewModel() {
        mMenuGroups = new MutableLiveData<>(buildMenu());
        goToHome();
    }

    LiveData<SectionFragment> getCurrentSection() {
        return mCurrentSection;
    }

    LiveData<List<MenuGroup>> getMenuGroups() {
        return mMenuGroups;
    }

    void goToHome() {
        mCurrentSection.setValue(mMenuGroups.getValue().get(MAIN_GROUP).sections.get(0));
    }

    private List<MenuGroup> buildMenu() {
        List<SectionFragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new SignUpFragment());
        fragments.add(new PasswordRecoveryFragment());
        fragments.add(new HallOfFameFragment());

        List<MenuGroup> mMenuGroups = new ArrayList<>();
        mMenuGroups.add(MAIN_GROUP, new MenuGroup(R.drawable.menu_titles_main, fragments));

        return mMenuGroups;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                                int childPosition, long id) {
        mCurrentSection.setValue(mMenuGroups.getValue().get(groupPosition).sections.get(childPosition));
        return false;
    }
}
