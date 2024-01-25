package com.gutotech.narutogame.data.model;

import com.google.firebase.storage.StorageReference;
import com.gutotech.narutogame.data.firebase.StorageUtils;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Locale;

public class Npc implements Serializable {
    private static final SecureRandom random = new SecureRandom();

    public static void create(Character character) {
        character.setCombatOverview(null);
        character.setExtrasInformation(null);
        character.setResumeOfMissions(null);
        character.setTitles(null);
        character.setId(null);
        character.setBag(null);

        Ninja[] ninjas = Ninja.values();
        Ninja ninja = ninjas[random.nextInt(ninjas.length)];
        character.setNinja(ninja);
        character.setNick(ninja.getName());
        character.setProfilePath("");

        StorageUtils.listAll(String.format(Locale.US, "images/profile/%d/", ninja.getId()),
                profiles -> {
                    if (profiles.isEmpty()) {
                        character.setProfilePath("images/profile/1/1.png");
                    } else {
                        int index = random.nextInt(profiles.size());
                        StorageReference reference = profiles.get(index);
                        character.setProfilePath(reference.getPath());
                    }
                }
        );

        character.getAttributes().updateFormulas(character.getClasse(),
                character.getLevel() - (random.nextInt(2) + 1));
        character.full();
        character.setSelectedTitle(0);
    }

    private Character mCharacter;

    public Npc(Character baseCharacter) {
        mCharacter = baseCharacter;
    }

    public Jutsu attack() {
        final int TOTAL_JUTSUS = mCharacter.getAllJutsus().size();

        Jutsu jutsu;

        do {
            jutsu = mCharacter.getAllJutsus().get(random.nextInt(TOTAL_JUTSUS));
        } while (jutsu.getJutsuInfo().type != Jutsu.Type.ATK &&
                jutsu.getJutsuInfo().type != Jutsu.Type.DEF);

        return jutsu;
    }

    public Character getCharacter() {
        return mCharacter;
    }
}
