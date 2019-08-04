package com.gutotech.narutogame.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.gutotech.narutogame.config.ConfigFirebase;

import java.io.Serializable;
import java.util.List;

public class Personagem implements Serializable {
    private String idPlayer;
    private String nick;
    private int level;
    private String graducao;
    private String classe;
    private String vila;
    private int numVila;
    private long ryous;
    private int idProfile;
    private int fotoAtual;
    private int expAtual;
    private int expUpar;

    private int pontos;
    private int posicao;
    private boolean on;

    private int combatesNPCDiarios;
    private ResumoCombates resumoCombates;
    private ResumoMissoes resumoMissoes;
    private Atributos atributos;

    private boolean fuiPego;
    private String nickOponente;
    private int numFuiPego;
    private int mapa_posicao;
    private String idBatalhaAtual;


    private List<Jutsu> jutsus;
    private Jutsu jutsuSelecionado;

    private Bolsa bolsa;

    public Personagem() {
    }

    public void salvar() {
        DatabaseReference reference = ConfigFirebase.getDatabase();
        DatabaseReference personagens = reference
                .child("personagem")
                .child(ConfigFirebase.getAuth().getCurrentUser().getUid())
                .child(nick);

        personagens.setValue(this);
    }

    public void atualizarAtributos() {
        atributos.atualizarFormula();
    }

    @Exclude
    public String getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(String idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getGraducao() {
        return graducao;
    }

    public void setGraducao(String graducao) {
        this.graducao = graducao;
    }

    public long getRyous() {
        return ryous;
    }

    public void setRyous(long ryous) {
        this.ryous = ryous;
    }

    public String getVila() {
        return vila;
    }

    public void setVila(String vila) {
        this.vila = vila;
    }

    public int getNumVila() {
        return numVila;
    }

    public void setNumVila(int numVila) {
        this.numVila = numVila;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAtributos(Atributos atributos) {
        this.atributos = atributos;
    }

    public Atributos getAtributos() {
        return atributos;
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public int getFotoAtual() {
        return fotoAtual;
    }

    public void setFotoAtual(int fotoAtual) {
        this.fotoAtual = fotoAtual;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getMapa_posicao() {
        return mapa_posicao;
    }

    public void setMapa_posicao(int mapa_posicao) {
        this.mapa_posicao = mapa_posicao;
    }

    public ResumoCombates getResumoCombates() {
        return resumoCombates;
    }

    public void setResumoCombates(ResumoCombates resumoCombates) {
        this.resumoCombates = resumoCombates;
    }

    public ResumoMissoes getResumoMissoes() {
        return resumoMissoes;
    }

    public void setResumoMissoes(ResumoMissoes resumoMissoes) {
        this.resumoMissoes = resumoMissoes;
    }

    public int getExpAtual() {
        return expAtual;
    }

    public void setExpAtual(int expAtual) {
        if (getExpAtual() + expAtual > getExpUpar()) {
            setLevel(getLevel() + 1);
            setExpUpar(getExpUpar() + 1200);
            setExpAtual(getExpAtual() + expAtual - getExpUpar());
            atualizarAtributos();
            atributos.getFormulas().setVidaAtual(atributos.getFormulas().getVida());
            atributos.getFormulas().setChakraAtual(atributos.getFormulas().getChakra());
            atributos.getFormulas().setStaminaAtual(atributos.getFormulas().getStamina());
            salvar();
        } else {
            this.expAtual = expAtual;
        }
    }

    public int getExpUpar() {
        return expUpar;
    }

    public void setExpUpar(int expUpar) {
        this.expUpar = expUpar;
    }

    public List<Jutsu> getJutsus() {
        return jutsus;
    }

    public void setJutsus(List<Jutsu> jutsus) {
        this.jutsus = jutsus;
    }

    public int getCombatesNPCDiarios() {
        return combatesNPCDiarios;
    }

    public void setCombatesNPCDiarios(int combatesNPCDiarios) {
        this.combatesNPCDiarios = combatesNPCDiarios;
    }

    public boolean getFuiPego() {
        return fuiPego;
    }

    public void setFuiPego(boolean fuiPego) {
        this.fuiPego = fuiPego;
    }

    public String getNickOponente() {
        return nickOponente;
    }

    public void setNickOponente(String nickOponente) {
        this.nickOponente = nickOponente;
    }

    public Jutsu getJutsuSelecionado() {
        return jutsuSelecionado;
    }

    public void setJutsuSelecionado(Jutsu jutsuSelecionado) {
        this.jutsuSelecionado = jutsuSelecionado;
    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public void setBolsa(Bolsa bolsa) {
        this.bolsa = bolsa;
    }

    public String getIdBatalhaAtual() {
        return idBatalhaAtual;
    }

    public void setIdBatalhaAtual(String idBatalhaAtual) {
        this.idBatalhaAtual = idBatalhaAtual;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}
