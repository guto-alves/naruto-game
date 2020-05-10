package com.gutotech.narutogame.data.model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class TimeMission extends Mission {
    private long durationMillis;
    private long initialTimestamp;

    public TimeMission() {
    }

    public TimeMission(String missionInfo, long durationMillis) {
        super(missionInfo);
        this.durationMillis = durationMillis;
    }

    public long getDurationMillis() {
        return durationMillis;
    }

    public void setDurationMillis(long durationMillis) {
        this.durationMillis = durationMillis;
    }

    public long getInitialTimestamp() {
        return initialTimestamp;
    }

    public void setInitialTimestamp(long initialTimestamp) {
        this.initialTimestamp = initialTimestamp;
    }

    @Exclude
    public Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<>();
        result.put("missionInfo", getMissionInfo());
        result.put("durationMillis", durationMillis);
        result.put("initialTimestamp", initialTimestamp);

        return result;
    }
}
