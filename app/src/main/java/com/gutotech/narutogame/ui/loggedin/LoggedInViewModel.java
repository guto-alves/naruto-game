package com.gutotech.narutogame.ui.loggedin;

import android.view.View;
import android.widget.ExpandableListView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.MenuGroup;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.home.halloffame.HallOfFameFragment;
import com.gutotech.narutogame.ui.home.home.HomeFragment;
import com.gutotech.narutogame.ui.loggedin.accountinfo.UserDataFragment;
import com.gutotech.narutogame.ui.loggedin.changepassword.PasswordChangeFragment;
import com.gutotech.narutogame.ui.loggedin.newcharacteer.CharacterCreateFragment;
import com.gutotech.narutogame.ui.loggedin.selectcharacter.CharacterSelectFragment;
import com.gutotech.narutogame.ui.loggedin.support.SuporteFragment;

import java.util.ArrayList;
import java.util.List;

public class LoggedInViewModel extends ViewModel implements ExpandableListView.OnChildClickListener {
    static final int USER_GROUP = 0;
    static final int CHARACTER_GROUP = 1;
    static final int MAIN_GROUP = 2;

    private MutableLiveData<List<MenuGroup>> mGroups;
    private MutableLiveData<SectionFragment> currentSection = new MutableLiveData<>();

    public LoggedInViewModel() {
        CharOn.character = null;
        mGroups = new MutableLiveData<>(buildMenu());
        goToSelectCharacter();
    }

    LiveData<SectionFragment> getCurrentSection() {
        return currentSection;
    }

    LiveData<List<MenuGroup>> getMenuGroups() {
        return mGroups;
    }

    private void goToSelectCharacter() {
        currentSection.setValue(mGroups.getValue().get(CHARACTER_GROUP).sections.get(0));
    }

    void goToHome() {
        currentSection.setValue(mGroups.getValue().get(MAIN_GROUP).sections.get(0));
    }

    private List<MenuGroup> buildMenu() {
        List<SectionFragment> sections1 = new ArrayList<>();
        sections1.add(new UserDataFragment());
        sections1.add(new PasswordChangeFragment());
        sections1.add(new SuporteFragment());

        List<SectionFragment> sections2 = new ArrayList<>();
        sections2.add(new CharacterSelectFragment());
        sections2.add(new CharacterCreateFragment());

        List<SectionFragment> sections3 = new ArrayList<>();
        sections3.add(new HomeFragment());
        sections3.add(new HallOfFameFragment());

        List<MenuGroup> groups = new ArrayList<>();
        groups.add(new MenuGroup(R.drawable.menu_titles_user, sections1));
        groups.add(new MenuGroup(R.drawable.menu_title_character, sections2));
        groups.add(new MenuGroup(R.drawable.menu_titles_main, sections3));

        return groups;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                                int childPosition, long id) {
        currentSection.setValue(mGroups.getValue().get(groupPosition).sections.get(childPosition));
        return true;
    }
}
