package com.gutotech.narutogame.data.model;

public class Message {
    private String who;
    private String message;

    public Message() {
    }

    public Message(String who, String message) {
        this.who = who;
        this.message = message;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
