package com.gutotech.narutogame.data.model;

import androidx.annotation.StringRes;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.gutotech.narutogame.R;

import java.io.Serializable;

public class Ticket extends BaseObservable implements Serializable {
    public enum Status implements Serializable {
        NEW(R.string.new_status), AWAITING(R.string.awaiting_staff_reply), CLOSED(R.string.closed);

        @StringRes
        public final int statusId;

        Status(int statusId) {
            this.statusId = statusId;
        }
    }

    private String id;
    private String email;
    private int category;
    private String title;
    private String dateOccurred;
    private String timeOccurred;
    private String description;
    private String image;

    private Status status;
    private String dateCreation;
    private String timeCreation;
    private String dateUpdated;
    private String timeUpdated;

    private String lastToAnswer;

    public Ticket() {
    }

    public Ticket(String id, String email, Status status) {
        this.id = id;
        this.email = email;
        this.status = status;
        lastToAnswer = "--";
    }

    public Ticket(String email, int category, String title, String dateOccurred,
                  String timeOccurred, String description, String image, Status status,
                  String dateCreation, String timeCreation, String dateUpdated, String timeUpdated,
                  String lastToAnswer) {
        this.email = email;
        this.category = category;
        this.title = title;
        this.dateOccurred = dateOccurred;
        this.timeOccurred = timeOccurred;
        this.description = description;
        this.image = image;
        this.status = status;
        this.dateCreation = dateCreation;
        this.timeCreation = timeCreation;
        this.dateUpdated = dateUpdated;
        this.timeUpdated = timeUpdated;
        this.lastToAnswer = lastToAnswer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public String getDateOccurred() {
        return dateOccurred;
    }

    public void setDateOccurred(String dateOccurred) {
        this.dateOccurred = dateOccurred;
    }

    public String getTimeOccurred() {
        return timeOccurred;
    }

    public void setTimeOccurred(String timeOccurred) {
        this.timeOccurred = timeOccurred;
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Bindable
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        notifyPropertyChanged(BR.status);
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getTimeCreation() {
        return timeCreation;
    }

    public void setTimeCreation(String timeCreation) {
        this.timeCreation = timeCreation;
    }

    @Bindable
    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
        notifyPropertyChanged(BR.dateUpdated);
    }

    @Bindable
    public String getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(String timeUpdated) {
        this.timeUpdated = timeUpdated;
        notifyPropertyChanged(BR.timeUpdated);
    }

    @Bindable
    public String getLastToAnswer() {
        return lastToAnswer;
    }

    public void setLastToAnswer(String lastToAnswer) {
        this.lastToAnswer = lastToAnswer;
        notifyPropertyChanged(BR.lastToAnswer);
    }
}
