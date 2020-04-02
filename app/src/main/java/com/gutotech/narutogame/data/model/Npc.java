package com.gutotech.narutogame.data.model;

import com.gutotech.narutogame.data.firebase.StorageUtils;

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
        character.setProfilePath("");

        StorageUtils.listAll(String.format("images/profile/%d/", ninja.getId()),
                profiles -> character.setProfilePath(
                        profiles.get(random.nextInt(profiles.size()))
                                .getPath()));

        character.getAttributes().updateFormulas(character.getClasse(),
                character.getLevel() - (random.nextInt(2) + 1));
        character.full();
        character.setTitle(0);
    }

    public Jutsu attack() {
        final int TOTAL_JUTSUS = character.getJutsus().size();

        Jutsu jutsu;

        do {
            jutsu = character.getJutsus().get(random.nextInt(TOTAL_JUTSUS));
        } while (jutsu.getJutsuInfo().type != Jutsu.Type.ATK && jutsu.getJutsuInfo().type != Jutsu.Type.DEF);

        return jutsu;
    }

    public Character getCharacter() {
        return character;
    }
}
