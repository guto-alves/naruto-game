package com.gutotech.narutogame.data.model;

public class Team {
    private String name;
    private String image;
    private int level;
    private String leaderId;
    private int villageId;
    private int currentExp;
    private int maxExp; // increments of 600 in 600
    private int score;

    public Team() {
    }

    public Team(String name, String leaderId, int villageId) {
        this.name = name;
        this.leaderId = leaderId;
        this.villageId = villageId;
        this.level = 1;
        this.maxExp = 600;
        this.score = 1000;
    }

    public void incrementExp(int expEarned) {
        int newTotalExp = getCurrentExp() + expEarned;

        while (newTotalExp >= getMaxExp()) {
            newTotalExp = newTotalExp - getMaxExp();

            setLevel(getLevel() + 1);
            setMaxExp(getMaxExp() + 600);

            score += Score.LEVEL;
        }

        setCurrentExp(newTotalExp);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public int getVillageId() {
        return villageId;
    }

    public void setVillageId(int villageId) {
        this.villageId = villageId;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
