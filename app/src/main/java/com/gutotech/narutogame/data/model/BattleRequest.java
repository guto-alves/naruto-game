package com.gutotech.narutogame.data.model;

import androidx.annotation.Nullable;

import java.util.List;

public class BattleRequest {
    public String battleId;
    public List<String> fightersIds;

    public BattleRequest() {
    }

    public BattleRequest(String battleId, List<String> fightersIds) {
        this.battleId = battleId;
        this.fightersIds = fightersIds;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof BattleRequest)) {
            return false;
        }
        return battleId.equals(((BattleRequest) obj).battleId);
    }
}
