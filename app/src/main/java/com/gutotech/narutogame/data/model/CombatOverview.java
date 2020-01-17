package com.gutotech.narutogame.data.model;

import java.io.Serializable;

public class CombatOverview implements Serializable {
    private int winsNpc;
    private int winsDojoPvp;
    private int winsMapPvp;

    private int lossesNpc;
    private int lossesDojoPvp;
    private int lossesMapPvp;

    private int drawsNpc;
    private int drawsPvp;

    public CombatOverview() {
    }

    public int getWinsNpc() {
        return winsNpc;
    }

    public void setWinsNpc(int winsNpc) {
        this.winsNpc = winsNpc;
    }

    public int getWinsDojoPvp() {
        return winsDojoPvp;
    }

    public void setWinsDojoPvp(int winsDojoPvp) {
        this.winsDojoPvp = winsDojoPvp;
    }

    public int getWinsMapPvp() {
        return winsMapPvp;
    }

    public void setWinsMapPvp(int winsMapPvp) {
        this.winsMapPvp = winsMapPvp;
    }

    public int getLossesNpc() {
        return lossesNpc;
    }

    public void setLossesNpc(int lossesNpc) {
        this.lossesNpc = lossesNpc;
    }

    public int getLossesDojoPvp() {
        return lossesDojoPvp;
    }

    public void setLossesDojoPvp(int lossesDojoPvp) {
        this.lossesDojoPvp = lossesDojoPvp;
    }

    public int getLossesMapPvp() {
        return lossesMapPvp;
    }

    public void setLossesMapPvp(int lossesMapPvp) {
        this.lossesMapPvp = lossesMapPvp;
    }

    public int getDrawsNpc() {
        return drawsNpc;
    }

    public void setDrawsNpc(int drawsNpc) {
        this.drawsNpc = drawsNpc;
    }

    public int getDrawsPvp() {
        return drawsPvp;
    }

    public void setDrawsPvp(int drawsPvp) {
        this.drawsPvp = drawsPvp;
    }
}
