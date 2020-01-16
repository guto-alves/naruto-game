package com.gutotech.narutogame.data.model;

public class ExtrasInformation {
    private int totalTraining;
    private int distributedPoints;
    private int totalFreePoints;
    private int totalHoursPlayed;

    public ExtrasInformation() {
    }

    public int getTotalTraining() {
        return totalTraining;
    }

    public void setTotalTraining(int totalTraining) {
        this.totalTraining = totalTraining;
    }

    public int getDistributedPoints() {
        return distributedPoints;
    }

    public void setDistributedPoints(int distributedPoints) {
        this.distributedPoints = distributedPoints;
    }

    public int getTotalFreePoints() {
        return totalFreePoints;
    }

    public void setTotalFreePoints(int totalFreePoints) {
        this.totalFreePoints = totalFreePoints;
    }

    public int getTotalHoursPlayed() {
        return totalHoursPlayed;
    }

    public void setTotalHoursPlayed(int totalHoursPlayed) {
        this.totalHoursPlayed = totalHoursPlayed;
    }
}
