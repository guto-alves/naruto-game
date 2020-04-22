package com.gutotech.narutogame.data.repository;

import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.model.BattleLogs;

public class BattleLogsRepository {
    private static final BattleLogsRepository sInstance = new BattleLogsRepository();

    private BattleLogsRepository() {
    }

    public static BattleLogsRepository getInstance() {
        return sInstance;
    }

    public void save(BattleLogs battleLogs) {
        FirebaseConfig.getDatabase()
                .child("battle-logs")
                .push()
                .setValue(battleLogs);
    }
}
