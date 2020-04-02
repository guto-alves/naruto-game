package com.gutotech.narutogame.data.model;

import androidx.annotation.StringRes;

public class LotteryItem {
    private String image;

    @StringRes
    private int description;

    private int ChancesOfWin;

    private Premium premium;

    public LotteryItem(String image, @StringRes int description, int ChancesOfWin, Premium premium) {
        this.image = image;
        this.description = description;
        this.ChancesOfWin = ChancesOfWin;
        this.premium = premium;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @StringRes
    public int getDescription() {
        return description;
    }

    public void setDescription(@StringRes int description) {
        this.description = description;
    }

    public int getChancesOfWin() {
        return ChancesOfWin;
    }

    public void setChancesOfWin(int chancesOfWin) {
        ChancesOfWin = chancesOfWin;
    }

    public Premium getPremium() {
        return premium;
    }

    public void setPremium(Premium premium) {
        this.premium = premium;
    }

    public interface Premium {
        void receive();
    }
}
