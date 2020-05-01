package com.gutotech.narutogame.data.model;

public class BattleLog {
    public enum Action {USES, RECEIVES, BUFF_DEBUFF_WEAPON, MISSED, END}

    public Action action;

    private String nick;

    private Integer value;
    private Jutsu jutsu;
    private int chanceOfSuccess;

    public BattleLog() {
    }

    public BattleLog(Action action) {
        this.action = action;
    }

    public BattleLog(String nick, Action action) {
        this.action = action;
        this.nick = nick;
    }

    public BattleLog(String nick, Action action, Integer value) {
        this.action = action;
        this.nick = nick;
        this.value = value;
    }

    public BattleLog(String nick, Action action, Integer value, Jutsu jutsu) {
        this.action = action;
        this.nick = nick;
        this.value = value;
        this.jutsu = jutsu;
    }

    public BattleLog(String nick, Action action, Integer value, Jutsu jutsu, int chanceOfSuccess) {
        this.action = action;
        this.nick = nick;
        this.value = value;
        this.jutsu = jutsu;
        this.chanceOfSuccess = chanceOfSuccess;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Jutsu getJutsu() {
        return jutsu;
    }

    public void setJutsu(Jutsu jutsu) {
        this.jutsu = jutsu;
    }

    public int getChanceOfSuccess() {
        return chanceOfSuccess;
    }

    public void setChanceOfSuccess(int chanceOfSuccess) {
        this.chanceOfSuccess = chanceOfSuccess;
    }
}
