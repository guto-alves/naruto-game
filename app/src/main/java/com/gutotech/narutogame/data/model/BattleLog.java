package com.gutotech.narutogame.data.model;

public class BattleLog {
    public enum Type {USES, RECEIVES, BUFF_DEBUFF_WEAPON, MISSED, END}

    public Type type;

    private String nick;

    private Integer action;
    private Jutsu jutsu;

    public BattleLog() {
    }

    public BattleLog(Type type) {
        this.type = type;
    }

    public BattleLog(Type type, String nick) {
        this.type = type;
        this.nick = nick;
    }

    public BattleLog(Type type, String nick, Integer action) {
        this.type = type;
        this.nick = nick;
        this.action = action;
    }

    public BattleLog(Type type, String nick, Integer action, Jutsu jutsu) {
        this.type = type;
        this.nick = nick;
        this.action = action;
        this.jutsu = jutsu;
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
}
