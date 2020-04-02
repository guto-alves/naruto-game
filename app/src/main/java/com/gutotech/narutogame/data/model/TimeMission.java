package com.gutotech.narutogame.data.model;

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
}
