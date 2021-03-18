package com.gutotech.narutogame.data.model;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

public class Message {
    private String id;
    private String sender;
    private String message;
    private long timestamp;

    public Message() {
    }

    public Message(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Message)) {
            return false;
        }
        return getId().equals(((Message) obj).getId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("sender", sender);
        map.put("message", message);
        map.put("timestamp", timestamp);
        return map;
    }
}
