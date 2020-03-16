package com.gutotech.narutogame.ui.playing;

import android.app.Application;
import android.os.Bundle;
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
import com.gutotech.narutogame.data.model.MenuGroup;
import com.gutotech.narutogame.data.model.Message;
import com.gutotech.narutogame.data.model.Ramen;
import com.gutotech.narutogame.data.model.Scroll;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.data.repository.ChatRepository;
import com.gutotech.narutogame.data.repository.MapRepository;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.BagItemsAdapter;
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
import com.gutotech.narutogame.ui.playing.battles.DojoRandomWaitFragment;
import com.gutotech.narutogame.ui.playing.battles.HospitalRoomFragment;
import com.gutotech.narutogame.ui.playing.battles.LogBatalhaFragment;
import com.gutotech.narutogame.ui.playing.character.CharacterStatusFragment;
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
import com.gutotech.narutogame.utils.MusicSettingsUtils;
import com.gutotech.narutogame.utils.SingleLiveEvent;
import com.gutotech.narutogame.utils.MusicUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PlayingViewModel extends AndroidViewModel implements ExpandableListView.OnChildClickListener {
    private final static int USER_GROUP = 0;
    private final static int CHARACTER_GROUP = 1;
    private final static int ACADEMY_GROUP = 2;
    private final static int CURRENT_VILLAGE_GROUP = 3;
    private final static int BATTLES_GROUP = 4;
    private final static int TEAM_GROUP = 5;
    private final static int RANKING_GROUP = 6;

    private MutableLiveData<List<MenuGroup>> menuGroups = new MutableLiveData<>();
    private MutableLiveData<SectionFragment> mCurrentSection = new MutableLiveData<>();

    private Character mCharacter;

    private MutableLiveData<List<Integer>> mTitles;

    public PlayingViewModel(@NonNull Application application) {
        super(application);

        mCharacter = CharOn.character;
        mTitles = new MutableLiveData<>(mCharacter.getTitles());

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
                        if (musicEnabled.get()) {
                            mMusicUtil.setMusicType(MusicUtils.MusicType.BATTLE);
                        }
                    } else {
                        if (musicEnabled.get()) {
                            mMusicUtil.setMusicType(MusicUtils.MusicType.NORMAL);
                        }
                    }
                } else if (propertyId == BR.hospital) {
                    buildMenu();
                    if (mCharacter.isHospital()) {
                        setCurrentSection(BATTLES_GROUP, 0);
                    } else {
                        setCurrentSection(CHARACTER_GROUP, 0);
                    }
                } else if (propertyId == BR.map) {
                    buildMenu();
                    if (!mCharacter.isMap()) {
                        setCurrentSection(CHARACTER_GROUP, 0);
                    }
                } else if (propertyId == BR.dojoWaitQueue) {
                    CharacterRepository.getInstance().save(mCharacter);
                    buildMenu();
                    if (mCharacter.isDojoWaitQueue()) {
                        setCurrentSection(BATTLES_GROUP, 0);
                    } else if (TextUtils.isEmpty(mCharacter.battleId)) {
                        setCurrentSection(CHARACTER_GROUP, 0);
                    }
                } else if (propertyId == BR.titles) {
                    mTitles.postValue(mCharacter.getTitles());
                } else if (propertyId == BR.graduationId) {
                    buildMenu();
                }
            }
        });

        mChatRepository = ChatRepository.getInstance();
        channel = mCharacter.getVillage().name();

        buildMenu();
        setCurrentSection(CHARACTER_GROUP, 0);

        if (mCharacter.getLastSeenInMillis() == 0) {
            mCharacter.setLastSeenInMillis(DateCustom.getTimeInMillis());
            mCharacter.setNumberOfDaysPlayed(1);
        }

        long lastSeenInMillis = mCharacter.getLastSeenInMillis();
        long currentMillis = DateCustom.getTimeInMillis();
        long diffMillis = currentMillis - lastSeenInMillis;
        long TOTAL_INCREMENTS = diffMillis / 120000;

        if (TOTAL_INCREMENTS > 5) {
            TOTAL_INCREMENTS = 5;
        }

        execHealing((int) TOTAL_INCREMENTS);
        execVariousRoutines();

        startGameRoutines();
    }

    public Character getCharacter() {
        return mCharacter;
    }

    LiveData<List<Integer>> getTitles() {
        return mTitles;
    }

    LiveData<List<MenuGroup>> getMenuGroups() {
        return menuGroups;
    }

    LiveData<SectionFragment> getCurrentSection() {
        return mCurrentSection;
    }

    // Bag
    private MutableLiveData<List<Ramen>> mRamens = new MutableLiveData<>();
    private MutableLiveData<List<Scroll>> mScrolls = new MutableLiveData<>();
    private SingleLiveEvent<Void> mDismissBagDialogEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> mShowWarningDialogEvent = new SingleLiveEvent<>();

    LiveData<List<Ramen>> getRamens() {
        return mRamens;
    }

    LiveData<List<Scroll>> getScrolls() {
        return mScrolls;
    }

    LiveData<Void> getDismissBagDialog() {
        return mDismissBagDialogEvent;
    }

    public LiveData<Integer> getShowWarningDialogEvent() {
        return mShowWarningDialogEvent;
    }

    void updateBag() {
        mRamens.postValue(mCharacter.getBag().getRamenList());
        mScrolls.postValue(mCharacter.getBag().getScrollList());
    }

    BagItemsAdapter.OnItemClickListener onRamenClickListener = (itemClicked, position) -> {
        Ramen ramen = (Ramen) itemClicked;

        if (CharOn.character.getFormulas().isFull()) {
            mDismissBagDialogEvent.call();
            mShowWarningDialogEvent.setValue(R.string.attributes_are_already_full);
            return;
        }

        CharOn.character.getFormulas().addHeath(ramen.getRecovers());
        CharOn.character.getFormulas().addChakra(ramen.getRecovers());
        CharOn.character.getFormulas().addStamina(ramen.getRecovers());

        ramen.setInventory(ramen.getInventory() - 1);

        List<Ramen> ramens = mRamens.getValue();

        if (ramen.getInventory() > 0) {
            ramens.set(position, ramen);
        } else {
            ramens.remove(position);

            if (ramens.size() == 0) {
                ramens = null;
            }
        }

        CharacterRepository.getInstance().save(CharOn.character);
        mRamens.setValue(ramens);
    };

    BagItemsAdapter.OnItemClickListener onScrollClickListener = (itemClicked, position) -> {
        Scroll scroll = (Scroll) itemClicked;

        if (mCharacter.getMapId() == scroll.getVillage().ordinal()) {
            return;
        }

        scroll.setInventory(scroll.getInventory() - 1);

        List<Scroll> scrolls = mScrolls.getValue();

        if (scroll.getInventory() > 0) {
            scrolls.set(position, scroll);
        } else {
            scrolls.remove(position);

            if (scrolls.size() == 0) {
                scrolls = null;
            }
        }

        mScrolls.setValue(scrolls);

        if (CharOn.character.isMap()) {
            MapRepository.getInstance().exit(CharOn.character.getMapId());
        }

        CharacterRepository.getInstance().save(CharOn.character);
        mDismissBagDialogEvent.call();

        VillageMapFragment villageMapFragment = new VillageMapFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("village", scroll.getVillage());
        villageMapFragment.setArguments(bundle);
        setCurrentSection(villageMapFragment);
    };


    public void onTitleSelected(int position) {
        if (position == 0) {
            mCharacter.setTitle(0);
        } else {
            mCharacter.setTitle(mCharacter.getTitles().get(position));
        }
    }


    // Menu
    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        setCurrentSection(groupPosition, childPosition);
        return false;
    }

    public void goToMessenger() {
        setCurrentSection(USER_GROUP, 1);
    }

    public void goToFidelity() {
        if (mCharacter.isMap() || mCharacter.isMission()) {
            setCurrentSection(CHARACTER_GROUP, 1);
        } else {
            setCurrentSection(CHARACTER_GROUP, 2);
        }
    }

    public void onChangeImageButtonPressed() {
        mCurrentSection.setValue(new ChangeImageFragment());
    }

    private void setCurrentSection(int groupPosition, int childPosition) {
        mCurrentSection.setValue(menuGroups.getValue().get(groupPosition)
                .sections.get(childPosition));
    }

    private void setCurrentSection(SectionFragment section) {
        mCurrentSection.setValue(section);
    }

    private void buildMenu() {
        List<SectionFragment> sections0 = new ArrayList<>();
        sections0.add(new UserDataFragment());
        sections0.add(new MensagensFragment());
        sections0.add(new VipPlayerFragment());
        sections0.add(new FormulasFragment());
        sections0.add(new PasswordChangeFragment());
        if (!mCharacter.isBattle() && !mCharacter.isDojoWaitQueue() && !mCharacter.isMap()) {
            sections0.add(new CharacterCreateFragment());
            sections0.add(new CharacterSelectFragment());
        }
        sections0.add(new SuporteFragment());

        List<SectionFragment> sections1 = new ArrayList<>();
        sections1.add(new CharacterStatusFragment());
        if (!mCharacter.isMission() && !mCharacter.isBattle() && !mCharacter.isHospital() &&
                !mCharacter.isMap()) {
            sections1.add(new NinjaLuckyFragment());
        }
        sections1.add(new FidelityFragment());

        List<SectionFragment> sections2 = new ArrayList<>();
        if (!mCharacter.isMission() && !mCharacter.isBattle() && !mCharacter.isHospital()
                && !mCharacter.isMap() && !mCharacter.isDojoWaitQueue()) {
            sections2.add(new GraduationsFragment());
            sections2.add(new AcademyTrainingFragment());
            sections2.add(new PersonagemJutsuFragment());
            sections2.add(new AcademyJutsuFragment());
        }

        List<SectionFragment> sections3 = new ArrayList<>();
        if (mCharacter.isMap()) {
            sections3.add(new VillageMapFragment());
        } else if (!mCharacter.isHospital() && !mCharacter.isBattle() && !mCharacter.isDojoWaitQueue()) {
            if (!mCharacter.isMission()) {
                if (mCharacter.getGraduationId() == 0) {
                    sections3.add(new TasksFragment());
                } else {
                    sections3.add(new MissionsFragment());
                    sections3.add(new VillageMapFragment());
                }

                sections3.add(new RamenShopFragment());
                sections3.add(new NinjaShopFragment());
            } else {
                sections3.add(new MissionsWaitingFragment());
            }
        }

        List<SectionFragment> sections4 = new ArrayList<>();
        if (mCharacter.isHospital()) {
            sections4.add(new HospitalRoomFragment());
        } else if (mCharacter.isBattle()) {
            if (mCharacter.battleId.contains("DOJO-NPC")) {
                sections4.add(new DojoBatalhaLutadorFragment());
            } else {
                sections4.add(new DojoBattlePvpFragment());
            }
        } else if (mCharacter.isDojoWaitQueue()) {
            sections4.add(new DojoRandomWaitFragment());
        } else if (!mCharacter.isMission() && !mCharacter.isMap()) {
            sections4.add(new DojoFragment());
            sections4.add(new LogBatalhaFragment());
        }

        List<SectionFragment> sections5 = new ArrayList<>();
        if (!mCharacter.isMission() && !mCharacter.isBattle() && !mCharacter.isHospital() &&
                !mCharacter.isMap() && !mCharacter.isDojoWaitQueue() && mCharacter.getGraduationId() > 0) {
            if (TextUtils.isEmpty(mCharacter.getTeam())) {
                sections5.add(new TeamParticipateFragment());
                sections5.add(new TeamCreateFragment());
            } else {
                sections5.add(new TeamDetailsFragment());
            }
        }

        List<SectionFragment> sections6 = new ArrayList<>();
        if (!mCharacter.isBattle() && !mCharacter.isDojoWaitQueue()) {
            sections6.add(new RankNinjasFragment());
            sections6.add(new RankEquipesFragment());
        }

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
            channel = mCharacter.getVillage().name();
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


    // Game Routines
    public final ObservableField<String> healing = new ObservableField<>("--:--:--");
    public final ObservableField<String> variousRoutines = new ObservableField<>("--:--:--");

    private Handler mHandler;

    private void startGameRoutines() {
        mHandler = new Handler();
        Runnable mRunnable = new Runnable() {
            @Override
            public void run() {
                Calendar calendar = Calendar.getInstance();

                checkHealing(calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));

                checkVariousRoutines(calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));

                mCharacter.getExtrasInformation().setTotalSecondsPlayed(
                        mCharacter.getExtrasInformation().getTotalSecondsPlayed() + 1);

                mHandler.postDelayed(this, 1000);
            }
        };

        mHandler.post(mRunnable);
    }

    private void checkHealing(int currentMinute, int currentSecond) {
        int minutesRemaining = currentMinute % 2 == 0 ? 1 : 0;
        int secondsRemaining = 59 - currentSecond;

        healing.set(String.format("00:%02d:%02d", minutesRemaining, secondsRemaining));

        if (!mCharacter.isBattle()) {
            if (minutesRemaining == 0 && secondsRemaining == 0) {
                execHealing(1);
            }
        }
    }

    private void execHealing(int totalIncrements) {
        for (int i = 0; i < totalIncrements; i++) {
            mCharacter.getFormulas().addHeath((int) Math.ceil(mCharacter.getFormulas().getHealth() * 0.2));
            mCharacter.getFormulas().addChakra((int) Math.ceil(mCharacter.getFormulas().getChakra() * 0.2));
            mCharacter.getFormulas().addStamina((int) Math.ceil(mCharacter.getFormulas().getStamina() * 0.2));
        }
    }

    private void checkVariousRoutines(int hoursOfDay, int minute, int second) {
        int hoursRemaining = 23 - hoursOfDay;
        int minutesRemaining = 59 - minute;
        int secondsRemaining = 59 - second;

        variousRoutines.set(String.format("%02d:%02d:%02d",
                hoursRemaining, minutesRemaining, secondsRemaining));

        if (hoursRemaining == 0 && minutesRemaining == 0 && secondsRemaining == 0) {
            execVariousRoutines();
        }
    }

    private void execVariousRoutines() {
        Calendar calendar = Calendar.getInstance();

        int currentDayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        long lastSeenInMillis = CharOn.character.getLastSeenInMillis();
        calendar.setTimeInMillis(lastSeenInMillis);
        int lastDayOfYearSeen = calendar.get(Calendar.DAY_OF_YEAR);
        int lastDayOfWeekSeen = calendar.get(Calendar.DAY_OF_WEEK);

        if (lastDayOfYearSeen != currentDayOfYear) {
            if ((currentDayOfWeek - lastDayOfWeekSeen == 0) ||
                    (lastDayOfWeekSeen < Calendar.TUESDAY && currentDayOfWeek > Calendar.TUESDAY) ||
                    (lastDayOfWeekSeen > currentDayOfWeek && currentDayOfWeek > Calendar.TUESDAY) ||
                    (currentDayOfWeek == Calendar.TUESDAY)) {
                mCharacter.getAttributes().setTrainingProgress(0);
            }

            if (Math.abs(currentDayOfYear - lastDayOfYearSeen) == 1) {
                CharOn.character.setDaysOfFidelity((CharOn.character.getDaysOfFidelity() + 1) % 8);
            } else {
                mCharacter.setDaysOfFidelity(1);
            }

            mCharacter.setTotalDailyMissions(0);
            mCharacter.setFidelityReward(true);
            mCharacter.setNpcDailyCombat(0);
            mCharacter.setNumberOfDaysPlayed(mCharacter.getNumberOfDaysPlayed() + 1);
        }
    }


    // Background Music
    public final ObservableBoolean musicEnabled = new ObservableBoolean(true);
    private MusicUtils mMusicUtil;

    public void onVolumeClick() {
        musicEnabled.set(!MusicSettingsUtils.enabled(getApplication()));

        MusicSettingsUtils.set(getApplication(), musicEnabled.get());

        if (musicEnabled.get()) {
            mMusicUtil = new MusicUtils(getApplication());
            if (mCharacter.isBattle()) {
                mMusicUtil.setMusicType(MusicUtils.MusicType.BATTLE);
            }
            mMusicUtil.start();
        } else {
            if (mMusicUtil != null) {
                mMusicUtil.release();
            }
        }
    }

    void start() {
        musicEnabled.set(MusicSettingsUtils.enabled(getApplication()));

        if (musicEnabled.get()) {
            if (mMusicUtil == null) {
                mMusicUtil = new MusicUtils(getApplication());
            }

            mMusicUtil.start();
        }

        mCharacter.setOnline(true);
        CharacterRepository.getInstance().save(mCharacter);
    }

    void stop() {
        if (musicEnabled.get()) {
            mMusicUtil.pause();
        }

        mCharacter.setOnline(false);
        mCharacter.setLastSeenInMillis(DateCustom.getTimeInMillis());
        CharacterRepository.getInstance().save(mCharacter);
    }

    void destroy() {
        if (mMusicUtil != null) {
            mMusicUtil.release();
        }
    }


    void logout() {
        mChatRepository.removeEventListener();
    }
}
