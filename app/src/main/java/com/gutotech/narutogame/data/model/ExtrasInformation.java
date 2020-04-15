package com.gutotech.narutogame.data.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.gutotech.narutogame.BR;

public class ExtrasInformation extends BaseObservable {
    private int distributedPoints;
    private int totalSecondsPlayed;

    public ExtrasInformation() {
    }

    public void incrementDistributedPoints(int quantity) {
        setDistributedPoints(getDistributedPoints() + quantity);
    }

    public void decrementDistributedPoints(int quantity) {
        setDistributedPoints(getDistributedPoints() - quantity);
    }

    public int getDistributedPoints() {
        return distributedPoints;
    }

    public void setDistributedPoints(int distributedPoints) {
        this.distributedPoints = distributedPoints;
    }

    @Bindable
    public int getTotalSecondsPlayed() {
        return totalSecondsPlayed;
    }

    public void setTotalSecondsPlayed(int totalSecondsPlayed) {
        this.totalSecondsPlayed = totalSecondsPlayed;
        notifyPropertyChanged(BR.totalSecondsPlayed);
    }
}
