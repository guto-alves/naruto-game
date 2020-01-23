package com.gutotech.narutogame.data.model;

public class ExtrasInformation {
    private int totalTraining;
    private int distributedPoints;
    private int totalHoursPlayed;

    public ExtrasInformation() {
    }

    public void incrementTotalTraining(int training) {
        setTotalTraining(getTotalTraining() + training);
    }

    public void incrementDistributedPoints(int quantity) {
        setDistributedPoints(getDistributedPoints() + quantity);
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

    public int getTotalHoursPlayed() {
        return totalHoursPlayed;
    }

    public void setTotalHoursPlayed(int totalHoursPlayed) {
        this.totalHoursPlayed = totalHoursPlayed;
    }
}
