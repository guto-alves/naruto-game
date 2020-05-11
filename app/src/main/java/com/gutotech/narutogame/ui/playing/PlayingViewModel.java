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
import com.gutotech.narutogame.data.firebase.FirebaseFunctionsUtils;
import com.gutotech.narutogame.data.model.Battle;
import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.MenuGroup;
import com.gutotech.narutogame.data.model.Message;
import com.gutotech.narutogame.data.model.Ramen;
import com.gutotech.narutogame.data.model.Scroll;
import com.gutotech.narutogame.data.network.NetworkUtils;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.data.repository.CharacterRepository;
import com.gutotech.narutogame.data.repository.ChatRepository;
import com.gutotech.narutogame.data.repository.GlobalAlertRepository;
import com.gutotech.narutogame.data.repository.MapRepository;
import com.gutotech.narutogame.data.repository.PlayerRepository;
import com.gutotech.narutogame.data.repository.TeamRepository;
import com.gutotech.narutogame.ui.SectionFragment;
import com.gutotech.narutogame.ui.adapter.BagItemsAdapter;
import com.gutotech.narutogame.ui.loggedin.accountinfo.UserDataFragment;
import com.gutotech.narutogame.ui.loggedin.changepassword.PasswordChangeFragment;
import com.gutotech.narutogame.ui.loggedin.newcharacteer.CharacterCreateFragment;
import com.gutotech.narutogame.ui.loggedin.selectcharacter.CharacterSelectFragment;
import com.gutotech.narutogame.ui.loggedin.support.SupportFragment;
import com.gutotech.narutogame.ui.playing.academy.AcademyJutsuFragment;
import com.gutotech.narutogame.ui.playing.academy.AcademyTrainingFragment;
import com.gutotech.narutogame.ui.playing.academy.ElementalJutsusFragment;
import com.gutotech.narutogame.ui.playing.academy.GraduationsFragment;
import com.gutotech.narutogame.ui.playing.academy.CharacterJutsusFragment;
import com.gutotech.narutogame.ui.playing.battles.DojoBatalhaLutadorFragment;
import com.gutotech.narutogame.ui.playing.battles.DojoBattlePvpFragment;
import com.gutotech.narutogame.ui.playing.battles.DojoFragment;
import com.gutotech.narutogame.ui.playing.battles.DojoRandomWaitFragment;
import com.gutotech.narutogame.ui.playing.battles.HospitalRoomFragment;
import com.gutotech.narutogame.ui.playing.battles.LogBatalhaFragment;
import com.gutotech.narutogame.ui.playing.character.CharacterStatusFragment;
import com.gutotech.narutogame.ui.playing.character.ElementsFragment;
import com.gutotech.narutogame.ui.playing.character.FidelityFragment;
import com.gutotech.narutogame.ui.playing.character.NinjaLuckyFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.MissionsFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.MissionsWaitingFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.NinjaShopFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.RamenShopFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.SpecialMissionsStatusFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.TasksFragment;
import com.gutotech.narutogame.ui.playing.currentvillage.VillageMapFragment;
import com.gutotech.narutogame.ui.playing.ranking.RankEquipesFragment;
import com.gutotech.narutogame.ui.playing.ranking.RankNinjasFragment;
import com.gutotech.narutogame.ui.playing.team.TeamCreateFragment;
import com.gutotech.narutogame.ui.playing.team.TeamDetailsFragment;
import com.gutotech.narutogame.ui.playing.team.TeamParticipateFragment;
import com.gutotech.narutogame.ui.playing.user.FormulasFragment;
import com.gutotech.narutogame.ui.playing.user.MenssengerFragment;
import com.gutotech.narutogame.ui.playing.user.VipPlayerFragment;
import com.gutotech.narutogame.utils.SettingsUtils;
import com.gutotech.narutogame.utils.SingleLiveEvent;
import com.gutotech.narutogame.utils.BgMusicUtils;
import com.gutotech.narutogame.utils.SoundUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PlayingViewModel extends AndroidViewModel implements ExpandableListView.OnChildClickListener {
    private final static int USER_GROUP = 0;
    private final static int CHARACTER_GROUP = 1;
    private final static int ACADEMY_GROUP = 2;
    private final static int CURRENT_VILLAGE_GROUP = 3;
    private final static int BATTLES_GROUP = 4;
    private final static int TEAM_GROUP = 5;
    private final static int RANKING_GROUP = 6;

    private MutableLiveData<List<MenuGroup>> mMenuGroups = new MutableLiveData<>();
    private MutableLiveData<SectionFragment> mCurrentSection = new MutableLiveData<>();

    private Character mCharacter;
    private CharacterRepository mCharacterRepository;

    private MutableLiveData<List<Integer>> mTitles;

    private SingleLiveEvent<Boolean> mFidelityAnimationEvent = new SingleLiveEvent<>();

    private GlobalAlertRepository mGlobalAlertRepository = GlobalAlertRepository.getInstance();
    private SingleLiveEvent<Map<String, String>> mShowAlerterEvent = new SingleLiveEvent<>();

    private MutableLiveData<Boolean> mShowConnectionWarning = new MutableLiveData<>();

    public PlayingViewModel(@NonNull Application application) {
        super(application);
        mCharacter = CharOn.character;
        mCharacterRepository = CharacterRepository.getInstance();
        mTitles = new MutableLiveData<>(mCharacter.getTitles());
        mChannel = String.valueOf(mCharacter.getVillage().ordinal());

        mFidelityAnimationEvent.setValue(CharOn.character.isFidelityReward());

        mCharacter.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {

            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == BR.level) {
                    SoundUtil.play(getApplication(), R.raw.levelup);
                } else if (propertyId == BR.fidelityReward) {
                    mFidelityAnimationEvent.setValue(CharOn.character.isFidelityReward());
                } else if (propertyId == BR.timeMission) {
                    mCharacterRepository.save(mCharacter);
                    buildMenu();
                    if (mCharacter.isTimeMission()) {
                        setCurrentSection(CURRENT_VILLAGE_GROUP, 0);
                    } else {
                        setCurrentSection(CHARACTER_GROUP, 0);
                    }
                } else if (propertyId == BR.specialMission) {
                    mCharacterRepository.save(mCharacter);
                    buildMenu();
                    if (mCharacter.isSpecialMission() && mCharacter.isTimeMission()) {
                        setCurrentSection(CURRENT_VILLAGE_GROUP, 1);
                    } else if (mCharacter.isSpecialMission() && !mCharacter.isTimeMission()) {
                        setCurrentSection(CURRENT_VILLAGE_GROUP, 0);
                    } else {
                        setCurrentSection(CHARACTER_GROUP, 0);
                    }
                } else if (propertyId == BR.battle) {
                    mCharacterRepository.save(mCharacter);
                    buildMenu();
                    if (mCharacter.isBattle()) {
                        if (mBgMusicEnabled) {
                            mBgMusicUtils.setMusicType(BgMusicUtils.MusicType.BATTLE);
                        }
                        setCurrentSection(BATTLES_GROUP, 0);
                    } else {
                        if (mBgMusicEnabled) {
                            mBgMusicUtils.setMusicType(BgMusicUtils.MusicType.NORMAL);
                        }
                    }
                } else if (propertyId == BR.hospital) {
                    mCharacterRepository.save(mCharacter);
                    buildMenu();
                    if (mCharacter.isHospital()) {
                        setCurrentSection(BATTLES_GROUP, 0);
                    } else {
                        setCurrentSection(CHARACTER_GROUP, 0);
                    }
                } else if (propertyId == BR.map) {
                    mCharacterRepository.save(CharOn.character);
                    buildMenu();
                    if (!mCharacter.isMap() && !mCharacter.isBattle()) {
                        setCurrentSection(CHARACTER_GROUP, 0);
                    }
                } else if (propertyId == BR.dojoWaitQueue) {
                    mCharacterRepository.save(mCharacter);
                    buildMenu();
                    if (mCharacter.isDojoWaitQueue()) {
                        setCurrentSection(BATTLES_GROUP, 0);
                    } else {
                        setCurrentSection(CHARACTER_GROUP, 0);
                    }
                } else if (propertyId == BR.titles) {
                    mTitles.postValue(mCharacter.getTitles());
                } else if (propertyId == BR.graduationId) {
                    buildMenu();
                } else if (propertyId == BR.team) {
                    buildMenu();
                    mUpdateChannelsEvent.call();
                    if (TextUtils.isEmpty(mCharacter.getTeam())) {
                        setCurrentSection(CHARACTER_GROUP, 0);
                    } else if (!mCharacter.isBattle()) {
                        setCurrentSection(TEAM_GROUP, 0);
                    }
                }
            }
        });

        FirebaseFunctionsUtils.getServerTime(currentTimestamp -> {
            if (mCharacter.getLastSeenInMillis() == 0) {
                mCharacter.setLastSeenInMillis(currentTimestamp);
                mCharacter.setNumberOfDaysPlayed(1);
            } else {
                long elapsedTime = currentTimestamp - mCharacter.getLastSeenInMillis();
                long TOTAL_INCREMENTS = elapsedTime / 120000;

                if (TOTAL_INCREMENTS > 5) {
                    TOTAL_INCREMENTS = 5;
                }

                execHealing((int) TOTAL_INCREMENTS);
                execVariousRoutines();
            }

            startGameRoutines();
        });

        buildMenu();
        setCurrentSection(CHARACTER_GROUP, 0);

        NetworkUtils.getInstance().addListener(mShowConnectionWarning::setValue);
    }

    public Character getCharacter() {
        return mCharacter;
    }

    LiveData<Boolean> getFidelityAnimationEvent() {
        return mFidelityAnimationEvent;
    }

    LiveData<Map<String, String>> getShowAlerterEvent() {
        return mShowAlerterEvent;
    }

    LiveData<Boolean> getShowConnectionWarning() {
        return mShowConnectionWarning;
    }

    // Bag
    private MutableLiveData<List<Ramen>> mRamens = new MutableLiveData<>();
    private MutableLiveData<List<Scroll>> mScrolls = new MutableLiveData<>();
    private SingleLiveEvent<Void> mDismissBagDialogEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> mShowWarningDialogEvent = new SingleLiveEvent<>();

    void updateBag() {
        mRamens.postValue(mCharacter.getBag().getRamenList());
        mScrolls.postValue(mCharacter.getBag().getScrollList());
    }

    final BagItemsAdapter.OnItemClickListener onRamenClickListener = (itemClicked, position) -> {
        if (mCharacter.isHospital()) {
            return;
        }

        if (!mCharacter.isItemsEnabled()) {
            mDismissBagDialogEvent.call();
            mShowWarningDialogEvent.setValue(R.string.cannot_use_items_during_the_battle);
            return;
        }

        if (mCharacter.getFormulas().isFull()) {
            mDismissBagDialogEvent.call();
            mShowWarningDialogEvent.setValue(R.string.attributes_are_already_full);
            return;
        }

        Ramen ramen = (Ramen) itemClicked;

        mCharacter.getFormulas().addHeath(ramen.getRecovers());
        mCharacter.getFormulas().addChakra(ramen.getRecovers());
        mCharacter.getFormulas().addStamina(ramen.getRecovers());

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

        if (mCharacter.isMap()) {
            MapRepository.getInstance().move(mCharacter.getMapId());
        }

        mCharacterRepository.save(mCharacter);
        mRamens.setValue(ramens);
    };

    final BagItemsAdapter.OnItemClickListener onScrollClickListener = (itemClicked, position) -> {
        if (mCharacter.isBattle()) {
            mDismissBagDialogEvent.call();
            mShowWarningDialogEvent.setValue(R.string.cannot_use_items_during_the_battle);
            return;
        }

        Scroll scroll = (Scroll) itemClicked;

        if (mCharacter.isTimeMission() || mCharacter.isDojoWaitQueue() || mCharacter.isHospital() ||
                mCharacter.getGraduationId() == 0 || mCharacter.getMapId() == scroll.getVillage().ordinal()) {
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

        mDismissBagDialogEvent.call();

        if (mCharacter.isMap()) {
            MapRepository.getInstance().exit(mCharacter.getMapId(), mCharacter.getId());
        }

        mCharacter.setMapId(scroll.getVillage().ordinal());
        mCharacterRepository.save(mCharacter);
        setCurrentSection(new VillageMapFragment());
    };

    LiveData<List<Ramen>> getRamens() {
        return mRamens;
    }

    LiveData<List<Scroll>> getScrolls() {
        return mScrolls;
    }

    LiveData<Void> getDismissBagDialog() {
        return mDismissBagDialogEvent;
    }

    LiveData<Integer> getShowWarningDialogEvent() {
        return mShowWarningDialogEvent;
    }


    // Menu
    public void onChangeImageButtonPressed() {
        mCurrentSection.setValue(new ChangeImageFragment());
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                                int childPosition, long id) {
        setCurrentSection(groupPosition, childPosition);
        return false;
    }

    public void goToMessenger() {
        setCurrentSection(USER_GROUP, 1);
    }

    public void goToFidelity() {
        if (!mCharacter.isTimeMission() && !mCharacter.isBattle() && !mCharacter.isHospital() &&
                !mCharacter.isMap()) {
            setCurrentSection(CHARACTER_GROUP, 3);
        } else {
            setCurrentSection(CHARACTER_GROUP, 1);
        }
    }

    private void setCurrentSection(int groupPosition, int childPosition) {
        mCurrentSection.setValue(mMenuGroups.getValue().get(groupPosition)
                .sections.get(childPosition));
    }

    private void setCurrentSection(SectionFragment section) {
        mCurrentSection.setValue(section);
    }

    private void buildMenu() {
        List<SectionFragment> sections0 = new ArrayList<>();
        sections0.add(new UserDataFragment());
        sections0.add(new MenssengerFragment());
        sections0.add(new VipPlayerFragment());
        sections0.add(new FormulasFragment());
        sections0.add(new PasswordChangeFragment());
        if (!mCharacter.isBattle() && !mCharacter.isDojoWaitQueue() && !mCharacter.isMap()) {
            sections0.add(new CharacterCreateFragment());
            sections0.add(new CharacterSelectFragment());
        }
        sections0.add(new SupportFragment());

        List<SectionFragment> sections1 = new ArrayList<>();
        sections1.add(new CharacterStatusFragment());
        if (!mCharacter.isTimeMission() && !mCharacter.isBattle() && !mCharacter.isHospital() &&
                !mCharacter.isMap()) {
            sections1.add(new NinjaLuckyFragment());
            sections1.add(new ElementsFragment());
        }
        sections1.add(new FidelityFragment());

        List<SectionFragment> sections2 = new ArrayList<>();
        if (!mCharacter.isTimeMission() && !mCharacter.isBattle() && !mCharacter.isHospital()
                && !mCharacter.isMap() && !mCharacter.isDojoWaitQueue()) {
            sections2.add(new GraduationsFragment());
            sections2.add(new AcademyTrainingFragment());
            sections2.add(new CharacterJutsusFragment());
            sections2.add(new AcademyJutsuFragment());
            sections2.add(new ElementalJutsusFragment());
        }

        List<SectionFragment> sections3 = new ArrayList<>();
        if (mCharacter.isMap()) {
            sections3.add(new VillageMapFragment());
        } else if (!mCharacter.isHospital() && !mCharacter.isBattle() && !mCharacter.isDojoWaitQueue()) {
            if (mCharacter.isTimeMission()) {
                sections3.add(new MissionsWaitingFragment());
            }
            if (mCharacter.isSpecialMission()) {
                sections3.add(new SpecialMissionsStatusFragment());
            }

            if (!mCharacter.isTimeMission()) {
                if (mCharacter.getGraduationId() == 0) {
                    sections3.add(new TasksFragment());
                } else {
                    sections3.add(new MissionsFragment());
                    sections3.add(new VillageMapFragment());
                }

                sections3.add(new RamenShopFragment());
                sections3.add(new NinjaShopFragment());
            }
        }

        List<SectionFragment> sections4 = new ArrayList<>();
        if (mCharacter.isHospital()) {
            sections4.add(new HospitalRoomFragment());
        } else if (mCharacter.isBattle()) {
            if (mCharacter.getBattleId().contains(Battle.DOJO_NPC)) {
                sections4.add(new DojoBatalhaLutadorFragment());
            } else {
                sections4.add(new DojoBattlePvpFragment());
            }
        } else if (mCharacter.isDojoWaitQueue()) {
            sections4.add(new DojoRandomWaitFragment());
        } else if (!mCharacter.isTimeMission() && !mCharacter.isMap()) {
            sections4.add(new DojoFragment());
            sections4.add(new LogBatalhaFragment());
        }

        List<SectionFragment> sections5 = new ArrayList<>();
        if (!mCharacter.isTimeMission() && !mCharacter.isBattle() && !mCharacter.isHospital() &&
                !mCharacter.isMap() && !mCharacter.isDojoWaitQueue() &&
                mCharacter.getGraduationId() > 0) {
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

        mMenuGroups.setValue(groups);
    }

    LiveData<List<Integer>> getTitles() {
        return mTitles;
    }

    LiveData<List<MenuGroup>> getMenuGroups() {
        return mMenuGroups;
    }

    LiveData<SectionFragment> getCurrentSection() {
        return mCurrentSection;
    }


    // Chat
    public final ObservableBoolean chatOpened = new ObservableBoolean(false);
    public final ObservableField<String> message = new ObservableField<>("");
    private ChatRepository mChatRepository = ChatRepository.getInstance();
    private String mChannel;
    private MutableLiveData<List<Message>> mMessages = new MutableLiveData<>();
    private SingleLiveEvent<Boolean> mStartChatAnimationEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mUpdateChannelsEvent = new SingleLiveEvent<>();

    public void onChatClick() {
        chatOpened.set(!chatOpened.get());

        if (chatOpened.get()) {
            mStartChatAnimationEvent.setValue(true);
            addMessagesListener();
        } else {
            mStartChatAnimationEvent.setValue(false);
            mChatRepository.removeMessagesListener();
            mMessages.setValue(null);
        }
    }

    public void onChannelChanged(int position) {
        if (position == 0) {
            mChannel = "World";
        } else if (position == 1) {
            mChannel = String.valueOf(mCharacter.getVillage().ordinal());
        } else {
            mChannel = "Team-" + mCharacter.getTeam();
        }

        mMessages.setValue(null);
        addMessagesListener();
    }

    public void onSendMessageButtonPressed() {
        message.set(message.get().trim());
        if (!TextUtils.isEmpty(message.get())) {
            ChatRepository.getInstance().sendMessage(
                    new Message(mCharacter.getNick(), message.get()), mChannel);
            message.set("");
        }
    }

    private void addMessagesListener() {
        mChatRepository.addOnMessagesListener(mChannel, mMessages::setValue);
    }

    LiveData<List<Message>> getChatMessages() {
        return mMessages;
    }

    LiveData<Boolean> getStartChatAnimationEvent() {
        return mStartChatAnimationEvent;
    }

    LiveData<Void> getUpdateChannelsEvent() {
        return mUpdateChannelsEvent;
    }


    // Game Routines
    public final ObservableField<String> healing = new ObservableField<>("--:--:--");
    public final ObservableField<String> variousRoutines = new ObservableField<>("--:--:--");
    private Handler mHandler;
    private long mCurrentTimestamp;

    private void startGameRoutines() {
        FirebaseFunctionsUtils.getServerTime(currentTimestamp -> {
            mCurrentTimestamp = currentTimestamp;

            mHandler = new Handler();
            Runnable mRunnable = new Runnable() {
                @Override
                public void run() {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(mCurrentTimestamp);

                    checkHealing(
                            calendar.get(Calendar.MINUTE),
                            calendar.get(Calendar.SECOND)
                    );

                    checkVariousRoutines(
                            calendar.get(Calendar.HOUR_OF_DAY),
                            calendar.get(Calendar.MINUTE),
                            calendar.get(Calendar.SECOND)
                    );

                    mCharacter.getExtrasInformation().setTotalSecondsPlayed(
                            mCharacter.getExtrasInformation().getTotalSecondsPlayed() + 1);

                    mCurrentTimestamp += 1002;
                    mHandler.postDelayed(this, 1000);
                }
            };
            mHandler.post(mRunnable);
        });
    }

    private void checkHealing(int currentMinute, int currentSecond) {
        int minutesRemaining = currentMinute % 2 == 0 ? 1 : 0;
        int secondsRemaining = 59 - currentSecond;

        healing.set(String.format(Locale.US, "00:%02d:%02d", minutesRemaining, secondsRemaining));

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

        variousRoutines.set(String.format(Locale.US, "%02d:%02d:%02d",
                hoursRemaining, minutesRemaining, secondsRemaining));

        if (hoursRemaining == 0 && minutesRemaining == 0 && secondsRemaining == 0) {
            execVariousRoutines();
        }
    }

    private void execVariousRoutines() {
        FirebaseFunctionsUtils.getServerTime(currentTimestamp -> {
            Calendar calendar = Calendar.getInstance();

            calendar.setTimeInMillis(currentTimestamp);
            int currentDayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

            calendar.setTimeInMillis(CharOn.character.getLastSeenInMillis());
            int lastDayOfYearSeen = calendar.get(Calendar.DAY_OF_YEAR);

            if (lastDayOfYearSeen != currentDayOfYear) {
                if (currentDayOfYear - lastDayOfYearSeen == 1) {
                    CharOn.character.setDaysOfFidelity((CharOn.character.getDaysOfFidelity() + 1) % 8);
                } else {
                    mCharacter.setDaysOfFidelity(0);
                }

                MapRepository.getInstance().clearDuelsCount();
                mCharacter.setFidelityReward(true);
                mCharacter.setTotalDailyMissions(0);
                mCharacter.setNpcDailyCombat(0);
                mCharacter.setNumberOfDaysPlayed(mCharacter.getNumberOfDaysPlayed() + 1);
            }
        });
    }


    // Background Music
    private BgMusicUtils mBgMusicUtils;
    private boolean mBgMusicEnabled;

    void checkForSettingsChanged() {
        mBgMusicEnabled = SettingsUtils.get(getApplication(), SettingsUtils.BG_MUSIC_KEY);

        if (mBgMusicEnabled) {
            if (mBgMusicUtils == null) {
                mBgMusicUtils = new BgMusicUtils(getApplication());
            }
            if (mCharacter.isBattle()) {
                mBgMusicUtils.setMusicType(BgMusicUtils.MusicType.BATTLE);
            }
            mBgMusicUtils.start();
        } else if (mBgMusicUtils != null) {
            mBgMusicUtils.release();
            mBgMusicUtils = null;
        }
    }

    void start() {
        mBgMusicEnabled = SettingsUtils.get(getApplication(), SettingsUtils.BG_MUSIC_KEY);

        if (mBgMusicEnabled) {
            if (mBgMusicUtils == null) {
                mBgMusicUtils = new BgMusicUtils(getApplication());
            }

            mBgMusicUtils.start();
        }

        mCharacter.setOnline(true);
        mCharacterRepository.save(mCharacter);
        TeamRepository.getInstance().registerMyTeamChangeListener();
        mGlobalAlertRepository.addListener(mShowAlerterEvent::postValue);
    }

    void stop() {
        if (mBgMusicEnabled) {
            mBgMusicUtils.pause();
        }

        mCharacter.setOnline(false);
        mCharacterRepository.save(mCharacter);
        mCharacterRepository.setLastSeen(mCharacter.getId());

        TeamRepository.getInstance().removeMyTeamChangeListener();
        mGlobalAlertRepository.removeListener();
    }

    void destroy() {
        if (mBgMusicUtils != null) {
            mBgMusicUtils.release();
            mBgMusicUtils = null;
        }
    }


    void logout() {
        mChatRepository.removeMessagesListener();
        PlayerRepository.getInstance().setSignedIn(false, null);
        AuthRepository.getInstance().signOut();
    }
}
