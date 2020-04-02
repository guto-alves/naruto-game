package com.gutotech.narutogame.data.model;

import java.util.List;

public class MapRequests {
    public int villageId;

    public List<BattleRequest> requests;

    public MapRequests() {
    }

    public MapRequests(int villageId, List<BattleRequest> requests) {
        this.villageId = villageId;
        this.requests = requests;
    }
}
