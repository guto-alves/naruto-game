package com.gutotech.narutogame.data.model;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.firebase.database.Exclude;
import com.gutotech.narutogame.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Character extends BaseObservable implements Serializable {
    private String id;
    private String playerId;
    private String nick;
    private Ninja ninja;
    private String profilePath;
    private Village village;
    private Classe classe;
    private int level;
    private int currentExp;
    private int levelUpExp;
    private long ryous;
    private int titleIndex;
    private List<Integer> titles;
    private int score;
    private int graduationId;
    private String team;
    private Attributes attributes;
    private List<Jutsu> jutsus;
    private int skillPoints;
    private Element element;
    private Bag bag;
    private boolean itemsEnabled;
    private ExtrasInformation extrasInformation;

    private CombatOverview combatOverview;
    private int npcDailyCombat;
    private boolean battle;
    public String battleId;
    private boolean dojoWaitQueue;
    private boolean hospital;

    private ResumeOfMissions resumeOfMissions;
    private int totalDailyMissions;
    private boolean mission;

    private int mapPosition;
    private boolean map;
    private int mapId;

    private int daysOfFidelity;
    private boolean fidelityReward;

    private long lastSeenInMillis;
    private boolean online;
    private int numberOfDaysPlayed;

    public Character() {
    }

    public Character(String playerId) {
        this.playerId = playerId;
        nick = "";
        level = 1;
        setNinja(Ninja.NARUTO);
        setProfilePath("1/1");
        setVillage(Village.FOLHA);
        setClasse(Classe.TAI);
        setAttributes(new Attributes(classe));
        updateFormulas();
        full();
        ryous = 500;
        score = 1000;
        levelUpExp = 1200;
        combatOverview = new CombatOverview();
        resumeOfMissions = new ResumeOfMissions();
        extrasInformation = new ExtrasInformation();
        mapPosition = -1;
        fidelityReward = true;

        bag = new Bag();
        bag.addRamen(new Ramen(
                "nissin", R.string.ninja_snack, R.string.ninja_snack_description,
                25, 100), 10);
        itemsEnabled = true;
    }

    public void updateFormulas() {
        getAttributes().updateFormulas(getClasse(), getLevel());
    }

    public void full() {
        getAttributes().getFormulas().full();
    }

    public void incrementExp(int expEarned) {
        int newTotalExp = getCurrentExp() + expEarned;

        while (newTotalExp >= getLevelUpExp()) {
            newTotalExp = newTotalExp - getLevelUpExp();
            levelUp();
        }

        setCurrentExp(newTotalExp);
    }

    private void levelUp() {
        setLevelUpExp(getLevelUpExp() + 1200);
        setLevel(getLevel() + 1);

        if (getLevel() <= 5) {
            getAttributes().setTotalFreePoints(getAttributes().getTotalFreePoints() + 5);
        } else {
            getAttributes().setTotalFreePoints(getAttributes().getTotalFreePoints() + 2);
        }

        updateFormulas();
        full();
        incrementScore(Score.LEVEL);
    }

    public void incrementScore(int earnedScore) {
        setScore(getScore() + earnedScore);
    }

    public void decrementScore(int lostScore) {
        setScore(getScore() - lostScore);
    }

    public void addRyous(long earnedRyous) {
        setRyous(getRyous() + earnedRyous);
    }

    public void subRyous(long ryousSpent) {
        setRyous(getRyous() - ryousSpent);
    }

    public void addTitle(@StringRes int titleId) {
        titles.add(titleId);
        notifyPropertyChanged(BR.titles);
    }

    @Exclude
    public List<Jutsu> getVisibleJutsus() {
        List<Jutsu> visibleJutsus = new ArrayList<>();

        for (Jutsu jutsu : getJutsus()) {
            if (jutsu.isVisible()) {
                visibleJutsus.add(jutsu);
            }
        }

        return visibleJutsus;
    }

    public void validateJutsus() {
        Iterator<Jutsu> iterator = jutsus.iterator();

        while (iterator.hasNext()) {
            boolean flag = false;

            List<Requirement> requirements = iterator.next().getJutsuInfo().requirements;

            if (requirements == null) {
                continue;
            }

            for (Requirement requirement : requirements) {
                if (!requirement.check()) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                iterator.remove();
            }
        }
    }

    public void incrementSkillPoint() {
        setSkillPoints(getSkillPoints() + 1);
    }

    public void removeSkillPoints() {
        setSkillPoints(getSkillPoints() - 5);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Character)) {
            return false;
        }

        return getId().equals(((Character) obj).getId());
    }

    @Exclude
    public Formulas getFormulas() {
        return getAttributes().getFormulas();
    }

    @Exclude
    public List<Integer> getMissionsFinishedId() {
        return getResumeOfMissions().getMissionsFinishedId();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    @Bindable
    public Ninja getNinja() {
        return ninja;
    }

    public void setNinja(Ninja ninja) {
        this.ninja = ninja;
        notifyPropertyChanged(BR.ninja);
    }

    @Bindable
    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
        notifyPropertyChanged(BR.profilePath);
    }

    @Bindable
    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
        notifyPropertyChanged(BR.village);
    }

    @Bindable
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
        notifyPropertyChanged(BR.nick);
    }

    @Bindable
    public long getRyous() {
        return ryous;
    }

    public void setRyous(long ryous) {
        this.ryous = ryous;
        notifyPropertyChanged(BR.ryous);
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Bindable
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        notifyPropertyChanged(BR.level);
    }

    @Bindable
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        notifyPropertyChanged(BR.score);
    }

    public CombatOverview getCombatOverview() {
        return combatOverview;
    }

    public void setCombatOverview(CombatOverview combatOverview) {
        this.combatOverview = combatOverview;
    }

    public ResumeOfMissions getResumeOfMissions() {
        return resumeOfMissions;
    }

    public void setResumeOfMissions(ResumeOfMissions resumeOfMissions) {
        this.resumeOfMissions = resumeOfMissions;
    }

    public ExtrasInformation getExtrasInformation() {
        return extrasInformation;
    }

    public void setExtrasInformation(ExtrasInformation extrasInformation) {
        this.extrasInformation = extrasInformation;
    }

    @Bindable
    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
        notifyPropertyChanged(BR.currentExp);
    }

    @Bindable
    public int getLevelUpExp() {
        return levelUpExp;
    }

    public void setLevelUpExp(int levelUpExp) {
        this.levelUpExp = levelUpExp;
        notifyPropertyChanged(BR.levelUpExp);
    }

    public int getNpcDailyCombat() {
        return npcDailyCombat;
    }

    public void setNpcDailyCombat(int npcDailyCombat) {
        this.npcDailyCombat = npcDailyCombat;
    }

    public Bag getBag() {
        if (bag == null) {
            bag = new Bag();
        }
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public boolean isItemsEnabled() {
        return itemsEnabled;
    }

    public void setItemsEnabled(boolean itemsEnabled) {
        this.itemsEnabled = itemsEnabled;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    @Bindable
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
        notifyPropertyChanged(BR.team);
    }

    @Bindable
    public int getMapPosition() {
        return mapPosition;
    }

    public void setMapPosition(int mapPosition) {
        this.mapPosition = mapPosition;
        notifyPropertyChanged(BR.mapPosition);
    }

    @Bindable
    public int getGraduationId() {
        return graduationId;
    }

    public void setGraduationId(int graduationId) {
        this.graduationId = graduationId;
        notifyPropertyChanged(BR.graduationId);
    }

    @Bindable
    public int getTitleIndex() {
        return titleIndex;
    }

    public void setTitleIndex(int titleIndex) {
        this.titleIndex = titleIndex;
        notifyPropertyChanged(BR.titleIndex);
    }

    @Bindable
    public List<Integer> getTitles() {
        if (titles == null) {
            titles = new ArrayList<>();
        }
        return titles;
    }

    public void setTitles(List<Integer> titles) {
        this.titles = titles;
    }

    public List<Jutsu> getJutsus() {
        return jutsus;
    }

    public void setJutsus(List<Jutsu> jutsus) {
        this.jutsus = jutsus;
    }

    @Bindable
    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
        notifyPropertyChanged(BR.skillPoints);
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    @Bindable
    public int getNumberOfDaysPlayed() {
        return numberOfDaysPlayed;
    }

    public void setNumberOfDaysPlayed(int numberOfDaysPlayed) {
        this.numberOfDaysPlayed = numberOfDaysPlayed;
        notifyPropertyChanged(BR.numberOfDaysPlayed);
    }

    public int getTotalDailyMissions() {
        return totalDailyMissions;
    }

    public void setTotalDailyMissions(int totalDailyMissions) {
        this.totalDailyMissions = totalDailyMissions;
    }

    @Bindable
    public boolean isMission() {
        return mission;
    }

    public void setMission(boolean mission) {
        this.mission = mission;
        notifyPropertyChanged(BR.mission);
    }

    @Bindable
    public boolean isBattle() {
        return battle;
    }

    public void setBattle(boolean battle) {
        this.battle = battle;
        notifyPropertyChanged(BR.battle);
    }

    @Bindable
    public boolean isHospital() {
        return hospital;
    }

    public void setHospital(boolean hospital) {
        this.hospital = hospital;
        notifyPropertyChanged(BR.hospital);
    }

    public String getBattleId() {
        return battleId;
    }

    public void setBattleId(String battleId) {
        this.battleId = battleId;
    }

    @Bindable
    public boolean isMap() {
        return map;
    }

    public void setMap(boolean map) {
        this.map = map;
        notifyPropertyChanged(BR.map);
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    @Bindable
    public boolean isDojoWaitQueue() {
        return dojoWaitQueue;
    }

    public void setDojoWaitQueue(boolean dojoWaitQueue) {
        this.dojoWaitQueue = dojoWaitQueue;
        notifyPropertyChanged(BR.dojoWaitQueue);
    }

    public int getDaysOfFidelity() {
        return daysOfFidelity;
    }

    public void setDaysOfFidelity(int daysOfFidelity) {
        this.daysOfFidelity = daysOfFidelity;
    }

    @Bindable
    public boolean isFidelityReward() {
        return fidelityReward;
    }

    public boolean hasFidelityReward() {
        return fidelityReward;
    }

    public void setFidelityReward(boolean fidelityReward) {
        this.fidelityReward = fidelityReward;
        notifyPropertyChanged(BR.fidelityReward);
    }

    public long getLastSeenInMillis() {
        return lastSeenInMillis;
    }

    public void setLastSeenInMillis(long lastSeenInMillis) {
        this.lastSeenInMillis = lastSeenInMillis;
    }
}
