package com.gutotech.narutogame.data.model;

public class Comment {
    private String id;
    private String by;
    private String message;
    private String date;

    public Comment() {
    }

    public Comment(String id, String by, String message, String date) {
        this.id = id;
        this.by = by;
        this.message = message;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
