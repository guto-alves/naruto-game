package com.gutotech.narutogame.data.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class Player extends BaseObservable {
    private String id;
    private String name;
    private String email;
    private String password;
    private String dateOfBirth;
    private String address;
    private String zipCode;
    private String state;
    private String neighborhood;
    private String city;
    private boolean signedIn;

    public Player() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        notifyPropertyChanged(BR.dateOfBirth);
    }

    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }

    @Bindable
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
        notifyPropertyChanged(BR.zipCode);
    }

    @Bindable
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Bindable
    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    @Bindable
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isSignedIn() {
        return signedIn;
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
