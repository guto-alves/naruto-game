package com.gutotech.narutogame.data.model;

public class Team {
    private String id;
    private String name;
    private int level;
    private int currentExp;
    private int expUpar;

    private int score;
    private int villageId;

    private String leader;
    private String member1;
    private String member2;
    private String member3;
    private int membersQuantity;

    public Team() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public int getExpUpar() {
        return expUpar;
    }

    public void setExpUpar(int expUpar) {
        this.expUpar = expUpar;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getVillageId() {
        return villageId;
    }

    public void setVillageId(int villageId) {
        this.villageId = villageId;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getMember1() {
        return member1;
    }

    public void setMember1(String member1) {
        this.member1 = member1;
    }

    public String getMember2() {
        return member2;
    }

    public void setMember2(String member2) {
        this.member2 = member2;
    }

    public String getMember3() {
        return member3;
    }

    public void setMember3(String member3) {
        this.member3 = member3;
    }

    public int getMembersQuantity() {
        return membersQuantity;
    }

    public void setMembersQuantity(int membersQuantity) {
        this.membersQuantity = membersQuantity;
    }
}
