package com.gutotech.narutogame.data.model;

import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.firebase.database.Exclude;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.repository.JutsuRepository;

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
    private List<Integer> titles = new ArrayList<>();
    private int selectedTitle;
    private int score;
    private int graduationId;
    private String team;
    private Attributes attributes;
    private List<Jutsu> jutsus;
    private List<ElementalJutsu> elementalJutsus;
    private int skillPoints;
    private Element element;
    private Bag bag;
    private boolean itemsEnabled;
    private ExtrasInformation extrasInformation;

    private CombatOverview combatOverview;
    private int npcDailyCombat;
    private boolean battle;
    private String battleId;
    private boolean dojoWaitQueue;
    private boolean hospital;

    private ResumeOfMissions resumeOfMissions;
    private int totalDailyMissions;
    private boolean timeMission;
    private boolean specialMission;

    private boolean map;
    private int mapId;
    private int mapPosition;

    private int daysOfFidelity;
    private boolean fidelityReward;

    private long lastSeenInMillis;
    private boolean online;
    private int numberOfDaysPlayed;

    public Character() {
    }

    public static Character create() {
        Character character = new Character();
        character.setNick("");
        character.setLevel(1);
        character.setNinja(Ninja.NARUTO);
        character.setProfilePath("1/1");
        character.setVillage(Village.FOLHA);
        character.setClasse(Classe.TAI);
        character.setAttributes(new Attributes(character.getClasse()));
        character.updateFormulas();
        character.full();
        character.setRyous(500);
        character.setScore(1000);
        character.setLevelUpExp(1200);
        character.setCombatOverview(new CombatOverview());
        character.setResumeOfMissions(new ResumeOfMissions());
        character.setExtrasInformation(new ExtrasInformation());
        character.setMapPosition(-1);
        character.setFidelityReward(true);
        character.getTitles().add(Title.NONE.ordinal());

        Bag bag = new Bag();
        bag.addRamen(new Ramen(
                "nissin", R.string.ninja_snack, R.string.ninja_snack_description,
                25, 100), 10);
        character.setBag(bag);
        character.setItemsEnabled(true);

        return character;
    }

    @Exclude
    public int getSelectedTitleIndex() {
        return titles.get(selectedTitle);
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
            getAttributes().setTotalFreePoints(getAttributes().getTotalFreePoints() + 3);
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

    public void addTitle(int titleIndex) {
        titles.add(titleIndex);
        notifyPropertyChanged(BR.titles);
    }

    @Exclude
    public List<Jutsu> getAllJutsus() {
        List<Jutsu> allJutsus = new ArrayList<>();
        allJutsus.addAll(getJutsus());
        allJutsus.addAll(getElementalJutsus());
        JutsuRepository.getInstance().sort(allJutsus);
        return allJutsus;
    }

    @Exclude
    public List<Jutsu> getVisibleJutsus() {
        List<Jutsu> visibleJutsus = new ArrayList<>();

        for (Jutsu jutsu : getJutsus()) {
            if (jutsu.isVisible()) {
                visibleJutsus.add(jutsu);
            }
        }

        for (Jutsu jutsu : getElementalJutsus()) {
            if (jutsu.isVisible()) {
                visibleJutsus.add(jutsu);
            }
        }

        JutsuRepository.getInstance().sort(visibleJutsus);

        return visibleJutsus;
    }

    public void validateJutsus() {
        validateJutsus(getJutsus());
        validateElementalJutsus(getElementalJutsus());
    }

    private void validateJutsus(List<Jutsu> jutsus) {
        Iterator<Jutsu> iterator = jutsus.iterator();

        while (iterator.hasNext()) {
            Jutsu jutsu = iterator.next();

            List<Requirement> requirements = jutsu.getJutsuInfo().requirements;

            if (requirements == null) {
                continue;
            }

            boolean folded = jutsu.getClasse() != getClasse();

            for (Requirement requirement : requirements) {
                if (!requirement.check(folded)) {
                    int pointsSpent = jutsu.getEnhancements().keySet().size() * 5;
                    incrementSkillPoint(pointsSpent);
                    iterator.remove();
                    break;
                }
            }
        }
    }

    private void validateElementalJutsus(List<ElementalJutsu> jutsus) {
        Iterator<ElementalJutsu> iterator = jutsus.iterator();

        while (iterator.hasNext()) {
            Jutsu jutsu = iterator.next();
            jutsu.setClasse(getClasse());

            List<Requirement> requirements = jutsu.getJutsuInfo().requirements;

            for (Requirement requirement : requirements) {
                if (!requirement.check()) {
                    int pointsSpent = jutsu.getEnhancements().keySet().size() * 5;
                    incrementSkillPoint(pointsSpent);
                    iterator.remove();
                    break;
                }
            }
        }
    }

    public void setJutsu(Jutsu jutsu) {
        if (jutsu instanceof ElementalJutsu) {
            int index = getElementalJutsus().indexOf(jutsu);
            getElementalJutsus().set(index, (ElementalJutsu) jutsu);
        } else {
            int index = getJutsus().indexOf(jutsu);
            getJutsus().set(index, jutsu);
        }
    }

    public void incrementSkillPoint() {
        incrementSkillPoint(1);
    }

    private void incrementSkillPoint(int quantity) {
        setSkillPoints(getSkillPoints() + quantity);
    }

    public void removeSkillPoints() {
        setSkillPoints(getSkillPoints() - 5);
    }

    @Exclude
    public int getClassPoints() {
        return getClasse() == Classe.NIN ? getAttributes().getNinjutsu() :
                getClasse() == Classe.GEN ? getAttributes().getGenjutsu() :
                        getClasse() == Classe.TAI ? getAttributes().getTaijutsu() :
                                getClasse() == Classe.BUK ? getAttributes().getBukijutsu() : 0;
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

    @Bindable
    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
        notifyPropertyChanged(BR.classe);
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

    public boolean isNotItemsEnabled() {
        return !itemsEnabled;
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
    public int getSelectedTitle() {
        return selectedTitle;
    }

    public void setSelectedTitle(int selectedTitle) {
        this.selectedTitle = selectedTitle;
        notifyPropertyChanged(BR.selectedTitle);
    }

    @Bindable
    public List<Integer> getTitles() {
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

    public List<ElementalJutsu> getElementalJutsus() {
        if (elementalJutsus == null) {
            elementalJutsus = new ArrayList<>();
        }
        return elementalJutsus;
    }

    public void setElementalJutsus(List<ElementalJutsu> elementalJutsus) {
        this.elementalJutsus = elementalJutsus;
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
    public boolean isTimeMission() {
        return timeMission;
    }

    public void setTimeMission(boolean timeMission) {
        this.timeMission = timeMission;
        notifyPropertyChanged(BR.timeMission);
    }

    @Bindable
    public boolean isSpecialMission() {
        return specialMission;
    }

    public void setSpecialMission(boolean specialMission) {
        this.specialMission = specialMission;
        notifyPropertyChanged(BR.specialMission);
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

    public void setFidelityReward(boolean fidelityReward) {
        this.fidelityReward = fidelityReward;
        notifyPropertyChanged(BR.fidelityReward);
    }

    public boolean hasFidelityReward() {
        return fidelityReward;
    }

    public long getLastSeenInMillis() {
        return lastSeenInMillis;
    }

    public void setLastSeenInMillis(long lastSeenInMillis) {
        this.lastSeenInMillis = lastSeenInMillis;
    }
}
