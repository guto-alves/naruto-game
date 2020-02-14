package com.gutotech.narutogame.data.model;

import java.io.Serializable;
import java.security.SecureRandom;

public class Npc implements Serializable {
    private static final SecureRandom random = new SecureRandom();

    private Character character;

    public Npc(Character baseCharacter) {
        character = baseCharacter;
    }

    public static void create(Character character) {
        Ninja[] ninjas = Ninja.values();
        Ninja ninja = ninjas[random.nextInt(ninjas.length)];

        character.setNinja(ninja);
        character.setNick(ninja.getName());
        character.updateProfile(random.nextInt(ninja.getTotalProfiles()) + 1);
        character.full();
        character.setTitle("");
    }

    public Jutsu attack() {
//        return character.getJutsus().get(random.nextInt(character.getJutsus().size()));
        return character.getJutsus().get(3);
    }

    public Character getCharacter() {
        return character;
    }
}
