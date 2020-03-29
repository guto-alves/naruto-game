package com.gutotech.narutogame.data.model;

public class Member {
    private String memberId;
    private int currentExp;
    private int maxExp;

    public Member() {
    }

    public Member(String memberId) {
        this.memberId = memberId;
        maxExp = 4900;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }
}
