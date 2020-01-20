package com.gutotech.narutogame.ui.playing;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Graduation;
import com.gutotech.narutogame.data.model.MenuGroup;
import com.gutotech.narutogame.data.model.Message;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.data.repository.ChatRepository;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.loggedin.accountinfo.UserDataFragment;
import com.gutotech.narutogame.ui.loggedin.changepassword.PasswordChangeFragment;
import com.gutotech.narutogame.ui.loggedin.newcharacteer.CharacterCreateFragment;
import com.gutotech.narutogame.ui.loggedin.selectcharacter.CharacterSelectFragment;
import com.gutotech.narutogame.ui.loggedin.support.SuporteFragment;
import com.gutotech.narutogame.ui.playing.academy.AcademiaJustuFragment;
import com.gutotech.narutogame.ui.playing.academy.AcademiaTreinamentoFragment;
import com.gutotech.narutogame.ui.playing.academy.GraduacoesFragment;
import com.gutotech.narutogame.ui.playing.academy.PersonagemJutsuFragment;
import com.gutotech.narutogame.ui.playing.battles.ArenaFragment;
import com.gutotech.narutogame.ui.playing.battles.DojoFragment;
import com.gutotech.narutogame.ui.playing.battles.LogBatalhaFragment;
import com.gutotech.narutogame.ui.playing.character.CharacterStatusFragment;
import com.gutotech.narutogame.ui.playing.character.ClansFragment;
import com.gutotech.narutogame.ui.playing.character.FidelityFragment;
import com.gutotech.narutogame.ui.playing.character.NinjaLuckyFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.MissionsFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.MissoesEsperaFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.NinjaShopFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.RamenShopFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.TasksFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.VillageMapFragment;
import com.gutotech.narutogame.ui.playing.ranking.RankEquipesFragment;
import com.gutotech.narutogame.ui.playing.ranking.RankNinjasFragment;
import com.gutotech.narutogame.ui.playing.team.TeamCreateFragment;
import com.gutotech.narutogame.ui.playing.team.TeamDetailsFragment;
import com.gutotech.narutogame.ui.playing.team.TeamParticipateFragment;
import com.gutotech.narutogame.ui.playing.user.FormulasFragment;
import com.gutotech.narutogame.ui.playing.user.MensagensFragment;
import com.gutotech.narutogame.ui.playing.user.VipPlayerFragment;
import com.gutotech.narutogame.utils.DateCustom;
import com.gutotech.narutogame.utils.SingleLiveEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PlayingViewModel extends AndroidViewModel {
    private MutableLiveData<List<MenuGroup>> menuGroups = new MutableLiveData<>();

    private MutableLiveData<SectionFragment> currentSection;

    public PlayingViewModel(@NonNull Application application) {
        super(application);

        mChatRepository = ChatRepository.getInstance();
        channel = CharOn.character.getVillage().name;

        buildMenu();
        currentSection = new MutableLiveData<>((menuGroups.getValue().get(1).sections.get(0)));
    }

    public LiveData<List<MenuGroup>> getMenuGroups() {
        return menuGroups;
    }

    public LiveData<SectionFragment> getCurrentSection() {
        return currentSection;
    }

    private final ExpandableListView.OnChildClickListener onChildClickListener =
            (parent, v, groupPosition, childPosition, id) -> {
                currentSection.setValue(
                        menuGroups.getValue().get(groupPosition).sections.get(childPosition));
                return false;
            };

    public ExpandableListView.OnChildClickListener getOnChildClickListener() {
        return onChildClickListener;
    }

    public void logout() {
        AuthRepository.getInstance().signOut();
    }

    public void onChangeImageButtonPressed() {
        currentSection.setValue(new ChangeImageFragment());
    }

    public final int GROUP_USUARIO = 0;
    public final int GROUP_PERSONAGEM = 1;
    public final int GROUP_ACADEMIA = 2;
    public final int GROUP_VILA_ATUAL = 3;
    public final int GROUP_COMBATES = 4;
    public final int GROUP_TEAM = 5;
    public final int GROUP_RANKING = 6;

    private void buildMenu() {
        List<SectionFragment> fragments1 = new ArrayList<>();
        fragments1.add(new UserDataFragment());
        fragments1.add(new MensagensFragment());
        fragments1.add(new VipPlayerFragment());
        fragments1.add(new FormulasFragment());
        fragments1.add(new PasswordChangeFragment());
        fragments1.add(new CharacterCreateFragment());
        fragments1.add(new CharacterSelectFragment());
        fragments1.add(new SuporteFragment());

        List<SectionFragment> fragments2 = new ArrayList<>();
        fragments2.add(new CharacterStatusFragment());
        fragments2.add(new ClansFragment());
        fragments2.add(new NinjaLuckyFragment());
        fragments2.add(new FidelityFragment());

        List<SectionFragment> fragments3 = new ArrayList<>();
        fragments3.add(new GraduacoesFragment());
        fragments3.add(new AcademiaTreinamentoFragment());
        fragments3.add(new PersonagemJutsuFragment());
        fragments3.add(new AcademiaJustuFragment());

        List<SectionFragment> fragments4 = new ArrayList<>();
        if (CharOn.character.getGraduation() == Graduation.ESTUDANTE) {
            fragments4.add(new TasksFragment());
        } else {
            fragments4.add(new MissionsFragment());
        }

        fragments4.add(new MissoesEsperaFragment());
        fragments4.add(new VillageMapFragment());
        fragments4.add(new RamenShopFragment());
        fragments4.add(new NinjaShopFragment());

        List<SectionFragment> fragments5 = new ArrayList<>();
        fragments5.add(new DojoFragment());
        fragments5.add(new ArenaFragment());
        fragments5.add(new LogBatalhaFragment());

        List<SectionFragment> fragments6 = new ArrayList<>();
        if (TextUtils.isEmpty(CharOn.character.getTeam())) {
            fragments6.add(new TeamParticipateFragment());
            fragments6.add(new TeamCreateFragment());
        } else {
            fragments6.add(new TeamDetailsFragment());
        }

        List<SectionFragment> fragments7 = new ArrayList<>();
        fragments7.add(new RankNinjasFragment());
        fragments7.add(new RankEquipesFragment());

        List<MenuGroup> groups = new ArrayList<>();

        groups.add(new MenuGroup(R.string.user, R.drawable.layout_categorias_topo_3, fragments1));
        groups.add(new MenuGroup(R.string.character, R.drawable.layout_categorias_topo_4, fragments2));
        groups.add(new MenuGroup(R.string.academy, R.drawable.layout_categorias_topo_7, fragments3));
        groups.add(new MenuGroup(R.string.current_village, R.drawable.layout_categorias_topo_1_11, fragments4));
        groups.add(new MenuGroup(R.string.battles, R.drawable.layout_categorias_topo_12, fragments5));
        groups.add(new MenuGroup(R.string.team, R.drawable.layout_categorias_topo_6, fragments6));
        groups.add(new MenuGroup(R.string.ranking, R.drawable.layout_categorias_topo_9, fragments7));

        menuGroups.setValue(groups);
    }


    // Chat
    private ChatRepository mChatRepository;
    public String message;
    public String channel;

    private MutableLiveData<List<Message>> mMessages = new MutableLiveData<>();

    private boolean chatOpened;
    private SingleLiveEvent<Boolean> startChatAnimationEvent = new SingleLiveEvent<>();

    public LiveData<List<Message>> getChatMessages() {
        return mMessages;
    }

    private void getMessages() {
        mMessages = mChatRepository.getMessages(channel);
    }

    public LiveData<Boolean> getStartChatAnimationEvent() {
        return startChatAnimationEvent;
    }

    public void onChatClick() {
        chatOpened = !chatOpened;

        if (chatOpened) {
            getMessages();
            startChatAnimationEvent.setValue(true);
        } else {
            startChatAnimationEvent.setValue(false);
            mChatRepository.removeEventListener();
            mMessages.setValue(null);
        }
    }

    public void onChannelChanged(int position) {
        Log.i("ChatTest", "channel position:" + position);
        if (position == 0) { // world
            channel = CharOn.character.getVillage().name;
        } else { // current village
            channel = "World";
        }

        getMessages();
    }

    public void onSendMessageButtonPressed() {
        if (!TextUtils.isEmpty(message)) {
            ChatRepository.getInstance().send(
                    new Message(CharOn.character.getNick(), message), channel);
            Log.i("ChatTest", "message sent:" + message);
            message = "";
        }
    }

    public void close() {
        CharOn.character.setOnline(false);
        CharOn.character.setLastLogin(String.format(Locale.getDefault(), "%s às %s",
                DateCustom.getDate(), DateCustom.getTime()));
        CharacterRepository.getInstance().saveCharacter(CharOn.character);
    }
}
