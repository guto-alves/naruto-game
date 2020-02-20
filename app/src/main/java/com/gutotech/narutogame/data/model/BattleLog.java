package com.gutotech.narutogame.data.model;

public class BattleLog {
    public enum Type {USES, RECEIVES, BUFF_DEBUFF_WEAPON, MISSED, END}

    public Type type;

    private String nick;

    private Integer action;
    private Jutsu jutsu;
    private int chanceOfSuccess;

    public BattleLog() {
    }

    public BattleLog(Type type) {
        this.type = type;
    }

    public BattleLog(String nick, Type type) {
        this.type = type;
        this.nick = nick;
    }

    public BattleLog(String nick, Type type, Integer action) {
        this.type = type;
        this.nick = nick;
        this.action = action;
    }

    public BattleLog(String nick, Type type, Integer action, Jutsu jutsu) {
        this.type = type;
        this.nick = nick;
        this.action = action;
        this.jutsu = jutsu;
    }

    public BattleLog(String nick, Type type, Integer action, Jutsu jutsu, int chanceOfSuccess) {
        this.type = type;
        this.nick = nick;
        this.action = action;
        this.jutsu = jutsu;
        this.chanceOfSuccess = chanceOfSuccess;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
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
