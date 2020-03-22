package com.gutotech.narutogame.data.model;

public class TicketResponse {
    private String response;
    private String by;
    private String date;
    private String time;

    public TicketResponse() {
    }

    public TicketResponse(String response, String by, String date, String time) {
        this.response = response;
        this.by = by;
        this.date = date;
        this.time = time;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
