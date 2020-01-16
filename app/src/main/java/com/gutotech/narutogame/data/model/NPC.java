package com.gutotech.narutogame.data.model;

import java.security.SecureRandom;

public class NPC {
    private static final SecureRandom random = new SecureRandom();
    public static Character npc;

    public static Jutsu atacar() {
//        return npc.getJutsus().get(random.nextInt(npc.getJutsus().size()));
        return new Jutsu();
    }

    public static void configurarNPC() {
        Ninja[] ninjas = Ninja.values();

        Ninja ninja = ninjas[random.nextInt(ninjas.length)];

        npc.setNinja(ninja);
        npc.setNick(ninja.getName());
        npc.setProfile(random.nextInt(2) + 1);
//        npc.setGraducao("--");
    }
}
