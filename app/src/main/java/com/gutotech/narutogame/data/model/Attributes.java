package com.gutotech.narutogame.data.model;

import java.util.ArrayList;
import java.util.List;

/*
    Vida	                Fórmula da Vida	                (ENERGIA * 6)
	Chakra	                Fórmula do Chakra               (ENERGIA * 6) + (NIN * 14) + (GEN * 7)
	Stamina             	Fórmula da Stamina              (ENERGIA * 6) + (TAI * 7) + (BIK * 7)
	Ataque (Tai/Buk)	    +1 de Ataque (Tai/Buk)	        ( FORÇA/ 2 )
	Ataque (Nin/Gen         +1 de Ataque (Nin /Gen)	        ( INTELIGÊNCIA / 2 )
	Defesa (Nin/Gen)        +1 Defesa  (Nin/Gen)	        (RESISTENCIA / 2 )
	Defesa (Tai / Buk)      +1 Defesa (Tai /Buk)	        (RESISTENCIA/ 2 )
	Precisão	            +1 de Precisão	                (SELO * 1)
	Esquiva	                +1% de Esquiva	                (AGILIDADE / 6)
	Incremento de Absorção	1% de Incremento de Absorção	(Level / 4)
	Incremento de Crítico	1% de Incremento de Crítico	    (Level / 4)
 */
public class Attributes {
    private int traningPoints;

    private int nextAbilityPoint;
    private int currentAbiliity;

    private int totalFreePoints;

    public int taijutsu;
    private int bukijutsu;
    private int ninjutsu;
    private int genjutsu;
    private int strength;
    private int agility;
    private int intelligence;
    private int seal;
    private int resistance;
    private int energy;

    private Formulas formulas;

    public Attributes() {
    }

    // Inicializa o atributos com base na classe
    public Attributes(Classe classe) {
        switch (classe) {
            case TAI:
                taijutsu = 10;
                bukijutsu = 1;
                ninjutsu = 1;
                genjutsu = 1;
                intelligence = 1;
                strength = 5;
                break;
            case BUK:
                taijutsu = 1;
                bukijutsu = 10;
                ninjutsu = 1;
                genjutsu = 1;
                intelligence = 1;
                strength = 5;
                break;
            case NIN:
                taijutsu = 1;
                bukijutsu = 1;
                ninjutsu = 10;
                genjutsu = 1;
                intelligence = 5;
                strength = 0;
                break;
            case GEN:
                taijutsu = 1;
                bukijutsu = 1;
                ninjutsu = 1;
                genjutsu = 10;
                intelligence = 5;
                strength = 1;
                break;
        }
        seal = 3;
        agility = 3;
        resistance = 1;
        energy = 10;
    }

    public void updateFormulas(Classe classe, int level) {
        final int adicionalByLevel1 = level * 18;
        final int adicionalByLevel2 = level * 9;

        formulas = new Formulas();

        formulas.setHealth(getEnergy() * 6 + adicionalByLevel1);

        if (classe == Classe.NIN) {
            formulas.setChakra(getEnergy() * 6 + getNinjutsu() * 14 + getGenjutsu() * 7 + adicionalByLevel1);
            formulas.setStamina(getEnergy() * 6 + getTaijutsu() * 7 + getBukijutsu() * 7 + adicionalByLevel2);
        } else if (classe == Classe.GEN) {
            formulas.setChakra(getEnergy() * 6 + getNinjutsu() * 7 + getGenjutsu() * 14 + adicionalByLevel1);
            formulas.setStamina(getEnergy() * 6 + getTaijutsu() * 7 + getBukijutsu() * 7 + adicionalByLevel2);
        } else if (classe == Classe.TAI) {
            formulas.setChakra(getEnergy() * 6 + getNinjutsu() * 7 + getGenjutsu() * 7 + adicionalByLevel2);
            formulas.setStamina(getEnergy() * 6 + getTaijutsu() * 14 + getBukijutsu() * 7 + adicionalByLevel1);
        } else {
            formulas.setChakra(getEnergy() * 6 + getNinjutsu() * 7 + getGenjutsu() * 7 + adicionalByLevel2);
            formulas.setStamina(getEnergy() * 6 + getTaijutsu() * 7 + getBukijutsu() * 14 + adicionalByLevel1);
        }

        formulas.setAtkTaiBuki((int) Math.ceil((double) getStrength() / 2));
        formulas.setAtkNinGen((int) Math.ceil((double) getIntelligence() / 2));

        formulas.setDefNinGen(getResistance() / 2);
        formulas.setDefTaiBuki(getResistance() / 2);

        formulas.setAccuracy(getSeal());

        formulas.setEsquiva((double) getAgility() / 6);

        formulas.setNinjaPower(getEnergy() * 200 +
                (getStrength() + getIntelligence() + getResistance()) * 150 +
                (getNinjutsu() + getGenjutsu() + getTaijutsu() + getBukijutsu()) * 200 +
                (getAgility() + getSeal()) * 100);
    }

    public int getTaijutsu() {
        return taijutsu;
    }

    public void setTaijutsu(int taijutsu) {
        this.taijutsu = taijutsu;
    }

    public int getBukijutsu() {
        return bukijutsu;
    }

    public void setBukijutsu(int bukijutsu) {
        this.bukijutsu = bukijutsu;
    }

    public int getNinjutsu() {
        return ninjutsu;
    }

    public void setNinjutsu(int ninjutsu) {
        this.ninjutsu = ninjutsu;
    }

    public int getGenjutsu() {
        return genjutsu;
    }

    public void setGenjutsu(int genjutsu) {
        this.genjutsu = genjutsu;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getSeal() {
        return seal;
    }

    public void setSeal(int seal) {
        this.seal = seal;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Formulas getFormulas() {
        return formulas;
    }

    public void setFormulas(Formulas formulas) {
        this.formulas = formulas;
    }

    public int getTraningPoints() {
        return traningPoints;
    }

    public void setTraningPoints(int traningPoints) {
        this.traningPoints = traningPoints;
    }

    public void addTraningPoints(int traningPoints) {
        setTraningPoints(getTraningPoints() + traningPoints);
    }

    public int getNextAbilityPoint() {
        return nextAbilityPoint;
    }

    public void setNextAbilityPoint(int nextAbilityPoint) {
        this.nextAbilityPoint = nextAbilityPoint;
    }

    public int getCurrentAbiliity() {
        return currentAbiliity;
    }

    public void setCurrentAbiliity(int currentAbiliity) {
        this.currentAbiliity = currentAbiliity;
    }

    public int getTotalFreePoints() {
        return totalFreePoints;
    }

    public void setTotalFreePoints(int totalFreePoints) {
        this.totalFreePoints = totalFreePoints;
    }

    public List<AttributeItem> asList() {
        List<AttributeItem> attributeItems = new ArrayList<>();

        attributeItems.add(new AttributeItem(Attribute.TAI, taijutsu));
        attributeItems.add(new AttributeItem(Attribute.BUK, bukijutsu));
        attributeItems.add(new AttributeItem(Attribute.NIN, ninjutsu));
        attributeItems.add(new AttributeItem(Attribute.GEN, genjutsu));
        attributeItems.add(new AttributeItem(Attribute.FOR, strength));
        attributeItems.add(new AttributeItem(Attribute.AGI, agility));
        attributeItems.add(new AttributeItem(Attribute.INTE, intelligence));
        attributeItems.add(new AttributeItem(Attribute.SELO, seal));
        attributeItems.add(new AttributeItem(Attribute.RES, resistance));
        attributeItems.add(new AttributeItem(Attribute.ENER, energy));

        return attributeItems;
    }
}
