package com.gutotech.narutogame.data.model;

import java.util.ArrayList;
import java.util.List;

/*
            Formulas
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
    private int traningProgress;

    // Total training points for next ability point
    private int totalTrainingPoints;

    private int trainingPoints;

    private int totalFreePoints;

    private List<Integer> basePoints;
    private List<Integer> distributedPoints;
    private List<Integer> pointsEarned;

    private Formulas formulas;

    public Attributes() {
    }

    public Attributes(Classe classe) {
        totalTrainingPoints = 150;

        basePoints = new ArrayList<>();
        distributedPoints = new ArrayList<>();
        pointsEarned = new ArrayList<>();

        switch (classe) {
            case TAI:
                basePoints.add(Attribute.TAI.id, 10);
                basePoints.add(Attribute.BUK.id, 1);
                basePoints.add(Attribute.NIN.id, 1);
                basePoints.add(Attribute.GEN.id, 1);
                basePoints.add(Attribute.INTE.id, 1);
                basePoints.add(Attribute.FOR.id, 5);
                break;
            case BUK:
                basePoints.add(Attribute.TAI.id, 1);
                basePoints.add(Attribute.BUK.id, 10);
                basePoints.add(Attribute.NIN.id, 1);
                basePoints.add(Attribute.GEN.id, 1);
                basePoints.add(Attribute.INTE.id, 1);
                basePoints.add(Attribute.FOR.id, 5);
                break;
            case NIN:
                basePoints.add(Attribute.TAI.id, 1);
                basePoints.add(Attribute.BUK.id, 1);
                basePoints.add(Attribute.NIN.id, 10);
                basePoints.add(Attribute.GEN.id, 1);
                basePoints.add(Attribute.INTE.id, 5);
                basePoints.add(Attribute.FOR.id, 1);
                break;
            case GEN:
                basePoints.add(Attribute.TAI.id, 1);
                basePoints.add(Attribute.BUK.id, 1);
                basePoints.add(Attribute.NIN.id, 1);
                basePoints.add(Attribute.GEN.id, 10);
                basePoints.add(Attribute.INTE.id, 5);
                basePoints.add(Attribute.FOR.id, 5);
                break;
        }
        basePoints.add(Attribute.SEAL.id, 3);
        basePoints.add(Attribute.AGI.id, 3);
        basePoints.add(Attribute.RES.id, 1);
        basePoints.add(Attribute.ENER.id, 10);

        final int TOTAL_ATTRIBUTES = 9;

        for (int i = 0; i < TOTAL_ATTRIBUTES; i++) {
            distributedPoints.add(i, 0);
            pointsEarned.add(i, 0);
        }
    }

    public void updateFormulas(Classe classe, int level) {
        final int additionalPerLevel1 = level * 18;
        final int additionalPerLevel2 = level * 9;

        formulas = new Formulas();

        formulas.setHealth(getEnergy() * 6 + additionalPerLevel1);

        if (classe == Classe.NIN) {
            formulas.setChakra(getEnergy() * 6 + getNinjutsu() * 14 + getGenjutsu() * 7 + additionalPerLevel1);
            formulas.setStamina(getEnergy() * 6 + getTaijutsu() * 7 + getBukijutsu() * 7 + additionalPerLevel2);
        } else if (classe == Classe.GEN) {
            formulas.setChakra(getEnergy() * 6 + getNinjutsu() * 7 + getGenjutsu() * 14 + additionalPerLevel1);
            formulas.setStamina(getEnergy() * 6 + getTaijutsu() * 7 + getBukijutsu() * 7 + additionalPerLevel2);
        } else if (classe == Classe.TAI) {
            formulas.setChakra(getEnergy() * 6 + getNinjutsu() * 7 + getGenjutsu() * 7 + additionalPerLevel2);
            formulas.setStamina(getEnergy() * 6 + getTaijutsu() * 14 + getBukijutsu() * 7 + additionalPerLevel1);
        } else {
            formulas.setChakra(getEnergy() * 6 + getNinjutsu() * 7 + getGenjutsu() * 7 + additionalPerLevel2);
            formulas.setStamina(getEnergy() * 6 + getTaijutsu() * 7 + getBukijutsu() * 14 + additionalPerLevel1);
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

    public void incrementTraningProgress(int trainingPointsEarned) {
        int newTotalTrainingProgress = trainingPointsEarned + getTraningProgress();

        if (newTotalTrainingProgress > CharOn.character.getGraduation().dailyTrainingLimit) {
            newTotalTrainingProgress = CharOn.character.getGraduation().dailyTrainingLimit;
        }

        setTraningProgress(newTotalTrainingProgress);
    }

    public void incrementTraningPoints(int trainingPointsEarned) {
        int newTotalTrainingPoints = getTrainingPoints() + trainingPointsEarned;

        while (newTotalTrainingPoints >= totalTrainingPoints) {
            newTotalTrainingPoints = newTotalTrainingPoints - totalTrainingPoints;

            totalTrainingPoints += 150;
            totalFreePoints++;
        }

        setTrainingPoints(newTotalTrainingPoints);
    }

    public void earn(int attributeId) {
        earn(attributeId, 1);
    }

    public void earn(int attributeId, int quantity) {
        int current = getPointsEarned().get(attributeId);
        getPointsEarned().set(attributeId, current + quantity);
    }

    public void train(int attributeId, int quantity) {
        int current = getDistributedPoints().get(attributeId);
        getDistributedPoints().set(attributeId, current + quantity);
    }

    public int getTaijutsu() {
        return basePoints.get(Attribute.TAI.id) + distributedPoints.get(Attribute.TAI.id)
                + pointsEarned.get(Attribute.TAI.id);
    }


    public int getBukijutsu() {
        return basePoints.get(Attribute.BUK.id) + distributedPoints.get(Attribute.BUK.id)
                + pointsEarned.get(Attribute.BUK.id);
    }

    public int getNinjutsu() {
        return basePoints.get(Attribute.NIN.id) + distributedPoints.get(Attribute.NIN.id)
                + pointsEarned.get(Attribute.NIN.id);
    }

    public int getGenjutsu() {
        return basePoints.get(Attribute.GEN.id) + distributedPoints.get(Attribute.GEN.id)
                + pointsEarned.get(Attribute.GEN.id);
    }


    public int getStrength() {
        return basePoints.get(Attribute.FOR.id) + distributedPoints.get(Attribute.FOR.id)
                + pointsEarned.get(Attribute.FOR.id);
    }

    public int getAgility() {
        return basePoints.get(Attribute.AGI.id) + distributedPoints.get(Attribute.AGI.id)
                + pointsEarned.get(Attribute.AGI.id);
    }

    public int getIntelligence() {
        return basePoints.get(Attribute.INTE.id) + distributedPoints.get(Attribute.INTE.id)
                + pointsEarned.get(Attribute.INTE.id);
    }

    public int getSeal() {
        return basePoints.get(Attribute.SEAL.id) + distributedPoints.get(Attribute.SEAL.id)
                + pointsEarned.get(Attribute.SEAL.id);
    }

    public int getResistance() {
        return basePoints.get(Attribute.RES.id) + distributedPoints.get(Attribute.RES.id)
                + pointsEarned.get(Attribute.RES.id);
    }

    public int getEnergy() {
        return basePoints.get(Attribute.ENER.id) + distributedPoints.get(Attribute.ENER.id)
                + pointsEarned.get(Attribute.ENER.id);
    }

    public Formulas getFormulas() {
        return formulas;
    }

    public void setFormulas(Formulas formulas) {
        this.formulas = formulas;
    }

    public int getTraningProgress() {
        return traningProgress;
    }

    public void setTraningProgress(int traningProgress) {
        this.traningProgress = traningProgress;
    }

    public int getTotalTrainingPoints() {
        return totalTrainingPoints;
    }

    public void setTotalTrainingPoints(int totalTrainingPoints) {
        this.totalTrainingPoints = totalTrainingPoints;
    }

    public int getTrainingPoints() {
        return trainingPoints;
    }

    public void setTrainingPoints(int trainingPoints) {
        this.trainingPoints = trainingPoints;
    }

    public int getTotalFreePoints() {
        return totalFreePoints;
    }

    public void setTotalFreePoints(int totalFreePoints) {
        this.totalFreePoints = totalFreePoints;
    }

    public List<Integer> getBasePoints() {
        return basePoints;
    }

    public void setBasePoints(List<Integer> basePoints) {
        this.basePoints = basePoints;
    }

    public List<Integer> getDistributedPoints() {
        return distributedPoints;
    }

    public void setDistributedPoints(List<Integer> distributedPoints) {
        this.distributedPoints = distributedPoints;
    }

    public List<Integer> getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(List<Integer> pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public List<Integer> asList() {
        List<Integer> attributes = new ArrayList<>();

        attributes.add(getTaijutsu());
        attributes.add(getBukijutsu());
        attributes.add(getNinjutsu());
        attributes.add(getGenjutsu());
        attributes.add(getStrength());
        attributes.add(getAgility());
        attributes.add(getIntelligence());
        attributes.add(getSeal());
        attributes.add(getResistance());
        attributes.add(getEnergy());

        return attributes;
    }
}
