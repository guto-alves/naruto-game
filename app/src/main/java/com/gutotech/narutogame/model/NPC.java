package com.gutotech.narutogame.model;

import com.gutotech.narutogame.helper.Helper;

import java.security.SecureRandom;

public class NPC {
    private static final SecureRandom random = new SecureRandom();
    public static Personagem npc;

    public static Jutsu atacar() {
        return npc.getJutsus().get(random.nextInt(npc.getJutsus().size()));
    }

    public static void configurarNPC() {
        int idProfile;

        while (true) {
            idProfile = random.nextInt(266) + 1;

            if (Helper.nomeDoPersonagem(idProfile) != null)
                break;
        }

        npc.setIdProfile(idProfile);
        npc.setNick(Helper.nomeDoPersonagem(idProfile));
        npc.setFotoAtual(random.nextInt(2) + 1);
        npc.setGraducao("--");
    }
}
