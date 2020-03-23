package com.gutotech.narutogame.data.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import java.util.ArrayList;
import java.util.List;

public class Team extends BaseObservable {
    private String id;
    private String name;
    private int level;
    private int villageId;
    private int currentExp;
    private int expUpar;
    private int score;

    private List<String> memberIds;

    private List<String> requesterIds;

    public Team() {
    }

    public Team(String id, String name, int level, int villageId, int currentExp, int expUpar,
                int score, String leader) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.villageId = villageId;
        this.currentExp = currentExp;
        this.expUpar = expUpar;
        this.score = score;

        memberIds = new ArrayList<>();
        memberIds.add(leader);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
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

    public List<String> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<String> memberIds) {
        this.memberIds = memberIds;
    }

    public List<String> getRequesterIds() {
        return requesterIds;
    }

    public void setRequesterIds(List<String> requesterIds) {
        this.requesterIds = requesterIds;
    }
}
