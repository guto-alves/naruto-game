package com.gutotech.narutogame.data.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;

public class Player {
    private String id;
    private String name;
    private String email;
    private String password;
    private String sex;
    private String dateOfBirth;
    private String address;
    private String zipCode;
    private String state;
    private String neighborhood;
    private String city;
    private int vipCredits;

    public Player() {
    }

    public Player(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Player(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Player(String name, String email, String password, String sex) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.sex = sex;
    }

    @Exclude
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getVipCredits() {
        return vipCredits;
    }

    public void setVipCredits(int vipCredits) {
        this.vipCredits = vipCredits;
    }
}
