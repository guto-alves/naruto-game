package com.gutotech.narutogame.data.model;

import com.google.firebase.database.DatabaseReference;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;

import java.io.Serializable;

public class Character implements Serializable {
    private String playerId;

    private String nick;
    private Ninja ninja;
    private int profile;
    private Village village;
    private Classe classe;
    private int level;
    private long ryous;

    private boolean online;
    private String lastLogin;

    private CombatOverview combatOverview;

    private ResumeOfMissions resumeOfMissions;

    private ExtrasInformation extrasInformation;

    private Bag bolsa;

    private String team;

    /// -------------------- OK ------------------------

    // info gerais
//    private String title;
//    private List<String> titles;
//
//    private String graducao;
//    private int idGraducao;
//
//    private int diasLogadosFidelidade;
//    private boolean temRecompensaFidelidade;
//
//    private Atributos atributos;
//    private List<Atributo> atributosDistribuitos;

    private int expAtual;
    private int expUpar;

    // info combates
    private int combatesNPCDiarios;
//
//
//    private boolean fuiPego;
//    private String nickOponente;
//    private int mapa_posicao;
//    private String idBatalhaAtual;
//
//    // missões
//    private boolean emMissao;
//    private MissaoDeTempo missaoDeTempo;
//    private MissaoEspecial missaoEspecial;
//    private List<Integer> tarefasConcluidasIDs;
//
//    private List<Jutsu> jutsus;
//    private Jutsu jutsuSelecionado;

    private int rankVila;
    private int rankGeral;
    private int pontos;
    private int posicao;

    public Character() {
    }

    public Character(String playerId) {
        this.playerId = playerId;
        ninja = Ninja.NARUTO;
        profile = 1;
        village = Village.FOLHA;
        classe = Classe.NIN;
        ryous = 500;
    }

    public void salvar() {
        DatabaseReference personagemReference = FirebaseConfig.getDatabase()
                .child("character")
                .child(nick);
        personagemReference.setValue(this);
    }

    public ExtrasInformation getExtrasInformation() {
        return extrasInformation;
    }

    public void setExtrasInformation(ExtrasInformation extrasInformation) {
        this.extrasInformation = extrasInformation;
    }

    public Ninja getNinja() {
        return ninja;
    }

    public void setNinja(Ninja ninja) {
        this.ninja = ninja;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

//    public List<String> getTitles() {
//        return titles;
//    }
//
//    public void setTitles(List<String> titles) {
//        this.titles = titles;
//    }
//
//    public void atualizarAtributos() {
//        atributos.atualizarFormula();
//    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

//    public String getGraducao() {
//        return graducao;
//    }
//
//    public void setGraducao(String graducao) {
//        this.graducao = graducao;
//    }

    public long getRyous() {
        return ryous;
    }

    public void setRyous(long ryous) {
        this.ryous = ryous;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

//    public void setAtributos(Atributos atributos) {
//        this.atributos = atributos;
//    }
//
//    public Atributos getAtributos() {
//        return atributos;
//    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
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

    public CombatOverview getCombatOverview() {
        return combatOverview;
    }

    public void setCombatOverview(CombatOverview combatOverview) {
        this.combatOverview = combatOverview;
    }

    public ResumeOfMissions getResumeOfMissions() {
        return resumeOfMissions;
    }

    public void setResumeOfMissions(ResumeOfMissions resumeOfMissions) {
        this.resumeOfMissions = resumeOfMissions;
    }

    public int getExpAtual() {
        return expAtual;
    }

    public void setExpAtual(int expAtual) {
        if (expAtual >= getExpUpar()) {
            expAtual = expAtual - getExpUpar();
            setExpUpar(getExpUpar() + 1200);
            setLevel(getLevel() + 1);
//            atualizarAtributos();
//            atributos.getFormulas().setVidaAtual(atributos.getFormulas().getVida());
//            atributos.getFormulas().setChakraAtual(atributos.getFormulas().getChakra());
//            atributos.getFormulas().setStaminaAtual(atributos.getFormulas().getStamina());
        }

        this.expAtual = expAtual;
    }

    public int getExpUpar() {
        return expUpar;
    }

    public void setExpUpar(int expUpar) {
        this.expUpar = expUpar;
    }

//    public List<Jutsu> getJutsus() {
//        return jutsus;
//    }
//
//    public void setJutsus(List<Jutsu> jutsus) {
//        this.jutsus = jutsus;
//    }

    public int getCombatesNPCDiarios() {
        return combatesNPCDiarios;
    }

    public void setCombatesNPCDiarios(int combatesNPCDiarios) {
        this.combatesNPCDiarios = combatesNPCDiarios;
    }
//
//    public boolean getFuiPego() {
//        return fuiPego;
//    }
//
//    public void setFuiPego(boolean fuiPego) {
//        this.fuiPego = fuiPego;
//    }
//
//    public String getNickOponente() {
//        return nickOponente;
//    }
//
//    public void setNickOponente(String nickOponente) {
//        this.nickOponente = nickOponente;
//    }
//
//    public Jutsu getJutsuSelecionado() {
//        return jutsuSelecionado;
//    }
//
//    public void setJutsuSelecionado(Jutsu jutsuSelecionado) {
//        this.jutsuSelecionado = jutsuSelecionado;
//    }

    public Bag getBolsa() {
        return bolsa;
    }

    public void setBolsa(Bag bolsa) {
        this.bolsa = bolsa;
    }

//    public String getIdBatalhaAtual() {
//        return idBatalhaAtual;
//    }
//
//    public void setIdBatalhaAtual(String idBatalhaAtual) {
//        this.idBatalhaAtual = idBatalhaAtual;
//    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

//    public List<Integer> getTarefasConcluidas() {
//        return tarefasConcluidasIDs;
//    }
//
//    public void setTarefasConcluidas(List<Integer> tarefasConcluidas) {
//        this.tarefasConcluidasIDs = tarefasConcluidas;
//    }

//    public boolean isEmMissao() {
//        return emMissao;
//    }
//
//    public void setEmMissao(boolean emMissao) {
//        this.emMissao = emMissao;
//    }
//
//    public MissaoDeTempo getMissaoDeTempo() {
//        return missaoDeTempo;
//    }
//
//    public void setMissaoDeTempo(MissaoDeTempo missaoDeTempo) {
//        this.missaoDeTempo = missaoDeTempo;
//    }
//
//    public MissaoEspecial getMissaoEspecial() {
//        return missaoEspecial;
//    }
//
//    public void setMissaoEspecial(MissaoEspecial missaoEspecial) {
//        this.missaoEspecial = missaoEspecial;
//    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
//
//    public int getDiasLogadosFidelidade() {
//        return diasLogadosFidelidade;
//    }
//
//    public void setDiasLogadosFidelidade(int diasLogadosFidelidade) {
//        this.diasLogadosFidelidade = diasLogadosFidelidade;
//    }
//
//    public boolean isTemRecompensaFidelidade() {
//        return temRecompensaFidelidade;
//    }
//
//    public void setTemRecompensaFidelidade(boolean temRecompensaFidelidade) {
//        this.temRecompensaFidelidade = temRecompensaFidelidade;
//    }
//
//    public List<Atributo> getAtributosDistribuitos() {
//        return atributosDistribuitos;
//    }
//
//    public void setAtributosDistribuitos(List<Atributo> atributosDistribuitos) {
//        this.atributosDistribuitos = atributosDistribuitos;
//    }
//
//    public int getIdGraducao() {
//        return idGraducao;
//    }
//
//    public void setIdGraducao(int idGraducao) {
//        this.idGraducao = idGraducao;
//    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getRankVila() {
        return rankVila;
    }

    public void setRankVila(int rankVila) {
        this.rankVila = rankVila;
    }

    public int getRankGeral() {
        return rankGeral;
    }

    public void setRankGeral(int rankGeral) {
        this.rankGeral = rankGeral;
    }

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
}
