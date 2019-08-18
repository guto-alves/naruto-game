package com.gutotech.narutogame.model;

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

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Atributos implements Serializable {
    private int taijutsu;
    private int bukijutsu;
    private int ninjutsu;
    private int genjutsu;
    private int forca;
    private int agilidade;
    private int inteligencia;
    private int selo;
    private int resistencia;
    private int energia;

    private Formulas formulas;

    public Atributos() {
        formulas = new Formulas();
    }

    @Exclude
    public void atualizarFormula() {
        int adicionalPorLevel_18 = PersonagemOn.personagem.getLevel() * 18;
        int adicionalPorLevel_9 = PersonagemOn.personagem.getLevel() * 9;

        formulas.setVida(getEnergia() * 6 + (adicionalPorLevel_18));

        if (PersonagemOn.personagem.getClasse().equals("Ninjutsu") || PersonagemOn.personagem.getClasse().equals("Genjutsu")) {
            formulas.setChakra(getEnergia() * 6 + getNinjutsu() * 14 + getGenjutsu() * 7 + adicionalPorLevel_18);
            formulas.setStamina(getEnergia() * 6 + getTaijutsu() * 7 + getBukijutsu() * 7 + adicionalPorLevel_9);
        } else {
            formulas.setChakra(getEnergia() * 6 + getNinjutsu() * 14 + getGenjutsu() * 7 + adicionalPorLevel_9);
            formulas.setStamina(getEnergia() * 6 + getTaijutsu() * 7 + getBukijutsu() * 7 + adicionalPorLevel_18);
        }

        formulas.setAtkTaiBuki((int) Math.ceil((double) getForca() / 2));
        formulas.setAtkNinGen((int) Math.ceil((double) getInteligencia() / 2));

        formulas.setDefNinGen(getResistencia() / 2);
        formulas.setDefTaiBuki(getResistencia() / 2);

        formulas.setPrecisao(getSelo());
        formulas.setEsquiva((double) getAgilidade() / 6);
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

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getSelo() {
        return selo;
    }

    public void setSelo(int selo) {
        this.selo = selo;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public Formulas getFormulas() {
        return formulas;
    }

    public void setFormulas(Formulas formulas) {
        this.formulas = formulas;
    }
}
