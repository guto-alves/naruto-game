package com.gutotech.narutogame.data.model;

public class TimeMission extends Mission {
    private long millisDuration;
    private long millisStopped;

    public TimeMission() {
    }

    public TimeMission(String missionInfo, long millisDuration) {
        super(missionInfo);
        this.millisDuration = millisDuration;
    }

    public TimeMission(String missionInfo, long millisDuration, long millisStopped) {
        super(missionInfo);
        this.millisDuration = millisDuration;
        this.millisStopped = millisStopped;
    }

    public long getMillisDuration() {
        return millisDuration;
    }

    public void setMillisDuration(long millisDuration) {
        this.millisDuration = millisDuration;
    }

    public long getMillisStopped() {
        return millisStopped;
    }

    public void setMillisStopped(long millisStopped) {
        this.millisStopped = millisStopped;
    }
}
