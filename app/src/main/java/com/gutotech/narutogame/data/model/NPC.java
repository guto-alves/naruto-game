package com.gutotech.narutogame.data.model;

import com.gutotech.narutogame.utils.StorageUtil;

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

        StorageUtil.listAll(String.format("images/profile/%d/", ninja.getId()),
                data -> character.setProfilePath(data.get(data.size()).getPath()));

        character.getAttributes().updateFormulas(character.getClasse(),
                character.getLevel() + (random.nextInt(3) - 1));
        character.full();
        character.setTitle("");
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
