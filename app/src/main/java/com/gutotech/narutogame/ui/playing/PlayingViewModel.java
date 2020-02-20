package com.gutotech.narutogame.ui.playing;

import android.app.Application;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.Graduation;
import com.gutotech.narutogame.data.model.MenuGroup;
import com.gutotech.narutogame.data.model.Message;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.data.repository.ChatRepository;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.loggedin.accountinfo.UserDataFragment;
import com.gutotech.narutogame.ui.loggedin.changepassword.PasswordChangeFragment;
import com.gutotech.narutogame.ui.loggedin.newcharacteer.CharacterCreateFragment;
import com.gutotech.narutogame.ui.loggedin.selectcharacter.CharacterSelectFragment;
import com.gutotech.narutogame.ui.loggedin.support.SuporteFragment;
import com.gutotech.narutogame.ui.playing.academy.AcademyJutsuFragment;
import com.gutotech.narutogame.ui.playing.academy.AcademyTrainingFragment;
import com.gutotech.narutogame.ui.playing.academy.GraduationsFragment;
import com.gutotech.narutogame.ui.playing.academy.PersonagemJutsuFragment;
import com.gutotech.narutogame.ui.playing.battles.DojoBatalhaLutadorFragment;
import com.gutotech.narutogame.ui.playing.battles.DojoBattlePvpFragment;
import com.gutotech.narutogame.ui.playing.battles.DojoFragment;
import com.gutotech.narutogame.ui.playing.battles.HospitalRoomFragment;
import com.gutotech.narutogame.ui.playing.battles.LogBatalhaFragment;
import com.gutotech.narutogame.ui.playing.character.CharacterStatusFragment;
import com.gutotech.narutogame.ui.playing.character.ClansFragment;
import com.gutotech.narutogame.ui.playing.character.FidelityFragment;
import com.gutotech.narutogame.ui.playing.character.NinjaLuckyFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.MissionsFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.MissionsWaitingFragment;
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
import com.gutotech.narutogame.utils.SoundsUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class PlayingViewModel extends AndroidViewModel implements ExpandableListView.OnChildClickListener {
    private final static int USER_GROUP = 0;
    private final static int CHARACTER_GROUP = 1;
    public final static int ACADEMY_GROUP = 2;
    private final static int CURRENT_VILLAGE_GROUP = 3;
    private final static int BATTLES_GROUP = 4;
    public final static int TEAM_GROUP = 5;
    public final static int RANKING_GROUP = 6;

    private MutableLiveData<List<MenuGroup>> menuGroups = new MutableLiveData<>();
    private MutableLiveData<SectionFragment> currentSection = new MutableLiveData<>();

    private Character mCharacter;

    public PlayingViewModel(@NonNull Application application) {
        super(application);

        mCharacter = CharOn.character;

        mCharacter.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == BR.mission) {
                    CharacterRepository.getInstance().save(mCharacter);
                    buildMenu();
                    if (mCharacter.isMission()) {
                        setCurrentSection(CURRENT_VILLAGE_GROUP, 0);
                    } else {
                        setCurrentSection(CHARACTER_GROUP, 0);
                    }
                } else if (propertyId == BR.battle) {
                    CharacterRepository.getInstance().save(mCharacter);
                    buildMenu();
                    if (mCharacter.isBattle()) {
                        setCurrentSection(BATTLES_GROUP, 0);
                        sounds.setMusicType(SoundsUtil.MusicType.BATTLE);
                    } else {
                        sounds.setMusicType(SoundsUtil.MusicType.NORMAL);
                    }
                } else if (propertyId == BR.hospital) {
                    buildMenu();
                    if (mCharacter.isHospital()) {
                        setCurrentSection(BATTLES_GROUP, 0);
                    } else {
                        setCurrentSection(CHARACTER_GROUP, 0);
                    }
                }
            }
        });

        mChatRepository = ChatRepository.getInstance();
        channel = String.valueOf(mCharacter.getVillage().id);

        buildMenu();
        setCurrentSection(CHARACTER_GROUP, 0);

        startGameRoutines();
    }

    public Character getCharacter() {
        return mCharacter;
    }

    LiveData<List<MenuGroup>> getMenuGroups() {
        return menuGroups;
    }

    LiveData<SectionFragment> getCurrentSection() {
        return currentSection;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        setCurrentSection(groupPosition, childPosition);
        return false;
    }

    public void goToMessenger() {
        setCurrentSection(USER_GROUP, 1);
    }

    public void goToFidelity() {
        setCurrentSection(CHARACTER_GROUP, 3);
    }

    private void setCurrentSection(int groupPosition, int childPosition) {
        currentSection.setValue(menuGroups.getValue().get(groupPosition)
                .sections.get(childPosition));
    }

    private void buildMenu() {
        List<SectionFragment> sections0 = new ArrayList<>();
        sections0.add(new UserDataFragment());
        sections0.add(new MensagensFragment());
        sections0.add(new VipPlayerFragment());
        sections0.add(new FormulasFragment());
        sections0.add(new PasswordChangeFragment());
        sections0.add(new CharacterCreateFragment());
        sections0.add(new CharacterSelectFragment());
        sections0.add(new SuporteFragment());

        List<SectionFragment> sections1 = new ArrayList<>();
        sections1.add(new CharacterStatusFragment());
        sections1.add(new ClansFragment());
        sections1.add(new NinjaLuckyFragment());
        sections1.add(new FidelityFragment());

        List<SectionFragment> sections2 = new ArrayList<>();
        if (!mCharacter.isMission() && !mCharacter.isBattle() && !mCharacter.isHospital()) {
            sections2.add(new GraduationsFragment());
            sections2.add(new AcademyTrainingFragment());
            sections2.add(new PersonagemJutsuFragment());
            sections2.add(new AcademyJutsuFragment());
        }

        List<SectionFragment> sections3 = new ArrayList<>();
        if (!mCharacter.isHospital() && !mCharacter.isBattle()) {
            if (!mCharacter.isMission()) {
                if (mCharacter.getGraduation() == Graduation.ESTUDANTE) {
                    sections3.add(new TasksFragment());
                } else {
                    sections3.add(new MissionsFragment());
                }

                sections3.add(new VillageMapFragment());
                sections3.add(new RamenShopFragment());
                sections3.add(new NinjaShopFragment());
            } else {
                sections3.add(new MissionsWaitingFragment());
            }
        }

        List<SectionFragment> sections4 = new ArrayList<>();
        if (mCharacter.isHospital()) {
            sections4.add(new HospitalRoomFragment());
        } else if (!mCharacter.isMission() && !mCharacter.isBattle()) {
            sections4.add(new DojoFragment());
            sections4.add(new LogBatalhaFragment());
        } else if (mCharacter.isBattle()) {
            if (mCharacter.battleId.contains("DOJO")) {
                sections4.add(new DojoBatalhaLutadorFragment());
            } else {
                sections4.add(new DojoBattlePvpFragment());
            }
        }

        List<SectionFragment> sections5 = new ArrayList<>();
        if (!mCharacter.isMission() && !mCharacter.isBattle() && !mCharacter.isHospital()) {
            if (TextUtils.isEmpty(mCharacter.getTeam())) {
                sections5.add(new TeamParticipateFragment());
                sections5.add(new TeamCreateFragment());
            } else {
                sections5.add(new TeamDetailsFragment());
            }
        }

        List<SectionFragment> sections6 = new ArrayList<>();
        sections6.add(new RankNinjasFragment());
        sections6.add(new RankEquipesFragment());

        List<MenuGroup> groups = new ArrayList<>();

        groups.add(new MenuGroup(R.string.user, R.drawable.layout_categorias_topo_3, sections0));
        groups.add(new MenuGroup(R.string.character, R.drawable.layout_categorias_topo_4, sections1));
        groups.add(new MenuGroup(R.string.academy, R.drawable.layout_categorias_topo_7, sections2));
        groups.add(new MenuGroup(R.string.current_village, R.drawable.layout_categorias_topo_1_11, sections3));
        if (mCharacter.isHospital()) {
            groups.add(new MenuGroup(R.string.hospital, R.drawable.layout_categorias_topo_14, sections4));
        } else {
            groups.add(new MenuGroup(R.string.battles, R.drawable.layout_categorias_topo_12, sections4));
        }
        groups.add(new MenuGroup(R.string.team, R.drawable.layout_categorias_topo_6, sections5));
        groups.add(new MenuGroup(R.string.ranking, R.drawable.layout_categorias_topo_9, sections6));

        menuGroups.setValue(groups);
    }

    // Chat
    private ChatRepository mChatRepository;
    public ObservableBoolean chatOpened = new ObservableBoolean(false);
    public ObservableField<String> message = new ObservableField<>();
    private String channel;
    private MutableLiveData<List<Message>> mMessages = new MutableLiveData<>();
    private SingleLiveEvent<Boolean> startChatAnimationEvent = new SingleLiveEvent<>();

    LiveData<List<Message>> getChatMessages() {
        return mMessages;
    }

    private void getMessages() {
        mChatRepository.getMessages(channel, messages -> mMessages.setValue(messages));
    }

    LiveData<Boolean> getStartChatAnimationEvent() {
        return startChatAnimationEvent;
    }

    public void onChatClick() {
        chatOpened.set(!chatOpened.get());

        if (chatOpened.get()) {
            getMessages();
            startChatAnimationEvent.setValue(true);
        } else {
            startChatAnimationEvent.setValue(false);
            mChatRepository.removeEventListener();
            mMessages.setValue(null);
        }
    }

    public void onChannelChanged(int position) {
        if (position == 0) {
            channel = String.valueOf(mCharacter.getVillage().id);
        } else {
            channel = "World";
        }

        getMessages();
    }

    public void onSendMessageButtonPressed() {
        if (!TextUtils.isEmpty(message.get())) {
            ChatRepository.getInstance().sendMessage(
                    new Message(mCharacter.getNick(), message.get()), channel);
            message.set("");
        }
    }


    public void onChangeImageButtonPressed() {
        currentSection.setValue(new ChangeImageFragment());
    }


    // Game Routines
    private final long millis_DiversasRotinas = 86400000L;
    private final long millis_Healling = 120000;
    private final long millis_RANKNINJA = 7200000;
    private Handler mHandler;
    private Runnable mRunnable;

    public final ObservableField<String> healing = new ObservableField<>("--:--:--");
    public final ObservableField<String> variousRoutines = new ObservableField<>("--:--:--");

    private void startGameRoutines() {
        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                Calendar calendar = Calendar.getInstance();
                calendar.get(Calendar.HOUR_OF_DAY);

                checkHealing(calendar.getTime().getTime());
                checkVariousRoutines();

                mHandler.postDelayed(this, 1000);
            }
        };

        mHandler.post(mRunnable);
    }

    private void checkHealing(long millis) {
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(minutes);

        minutes = minutes % 2 == 0 ? 1 : 0;
        seconds = 59 - seconds;

        healing.set(String.format("00:%02d:%02d", minutes, seconds));

        if (!mCharacter.isBattle()) {
            if (minutes == 0 && seconds == 0) {
                mCharacter.getFormulas().addHeath((int) (mCharacter.getFormulas().getHealth() * 0.2));
                mCharacter.getFormulas().addChakra((int) (mCharacter.getFormulas().getChakra() * 0.2));
                mCharacter.getFormulas().addStamina((int) (mCharacter.getFormulas().getStamina() * 0.2));
            }
        }
    }

    private void checkVariousRoutines() {
//        long hours = TimeUnit.MILLISECONDS.toHours(millis);
//        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(hours);
//        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(minutes) - TimeUnit.HOURS.toSeconds(hours);

//        variousRoutines.set(String.format("%02d:%02d:%02d",
//                (SystemClock.elapsedRealtime() / (1000 * 60 * 60)) % 24, minutes, seconds));

        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        hours = 23 - hours;
        minutes = 59 - minutes;
        seconds = 59 - seconds;

        variousRoutines.set(String.format("%02d:%02d:%02d", hours, minutes, seconds));


        if (hours == 0 && minutes == 0 && seconds == 0) {
            mCharacter.setNpcDailyCombat(0);
        }
    }

    private void stopRoutines() {
        mHandler.removeCallbacks(mRunnable);
    }

    // Background Music
    private SoundsUtil sounds;

    public void onVolumeClick() {
        if (sounds != null) {
            sounds.release();
        } else {
            sounds = new SoundsUtil(getApplication());
            sounds.start();
        }
    }

    void start() {
        mCharacter.setOnline(true);
        CharacterRepository.getInstance().save(mCharacter);

        if (sounds == null) {
            sounds = new SoundsUtil(getApplication());
        }

        sounds.start();
    }

    void stop() {
        sounds.pause();
    }

    void destroy() {
        sounds.release();
    }

    void logout() {
        mChatRepository.removeEventListener();

        mCharacter.setOnline(false);
        mCharacter.setLastLogin(String.format(Locale.getDefault(), "%s às %s",
                DateCustom.getDate(), DateCustom.getTime()));
        CharacterRepository.getInstance().save(mCharacter);
    }
}
