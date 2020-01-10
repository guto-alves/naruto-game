package com.gutotech.narutogame.data.model;

import java.io.Serializable;

public class News implements Serializable {
    private String id;
    private String date;
    private String title;
    private String message;
    private String by;
    private int likes;

    public News() {
    }

    public News(String date, String title, String message) {
        this.date = date;
        this.title = title;
        this.message = message;
    }

    public News(String date, String title, String message, String by) {
        this.date = date;
        this.title = title;
        this.message = message;
        this.by = by;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
