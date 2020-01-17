package com.gutotech.narutogame.data.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.firebase.database.DatabaseReference;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;

import java.io.Serializable;

public class Character extends BaseObservable implements Serializable {
    private String playerId;
    public String nick;
    private Ninja ninja;
    private int profile;
    private Village village;
    private Classe classe;
    private int level;
    private int exp;
    private int expUpar;
    private long ryous;

    private Attributes attributes;

    private Bag bolsa;

    private CombatOverview combatOverview;
    private ResumeOfMissions resumeOfMissions;
    private ExtrasInformation extrasInformation;

    private String team;

    private int score;

    private boolean online;
    private String lastLogin;

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
    // info combates
    private int combatesNPCDiarios;

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

    private int posicao;

    public Character() {
    }

    public Character(String playerId) {
        this.playerId = playerId;
        level = 1;
        ninja = Ninja.NARUTO;
        profile = 1;
        village = Village.FOLHA;
        setClasse(Classe.TAI);
        getAttributes().updateFormulas(Classe.TAI, level);
        ryous = 500;
        score = 1000;
        combatOverview = new CombatOverview();
        resumeOfMissions = new ResumeOfMissions();
        extrasInformation = new ExtrasInformation();
    }

    public void salvar() {
        DatabaseReference characterRef = FirebaseConfig.getDatabase()
                .child("characters")
                .child(nick);

        characterRef.setValue(this);
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

    @Bindable
    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
        notifyPropertyChanged(BR.village);
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

    @Bindable
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
        notifyPropertyChanged(BR.nick);
    }

//    public String getGraducao() {
//        return graducao;
//    }
//
//    public void setGraducao(String graducao) {
//        this.graducao = graducao;
//    }

    @Bindable
    public long getRyous() {
        return ryous;
    }

    public void setRyous(long ryous) {
        this.ryous = ryous;
        notifyPropertyChanged(BR.ryous);
    }

    public void addRyous(long ryous) {
        setRyous(getRyous() + ryous);
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
        setAttributes(new Attributes(classe));
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Bindable
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        notifyPropertyChanged(BR.level);
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        if (exp >= getExpUpar()) {
            exp = exp - getExpUpar();
            setExpUpar(getExpUpar() + 1200);
            setLevel(getLevel() + 1);
            getAttributes().updateFormulas(classe, level);
            getAttributes().getFormulas().full();
//            atualizarAtributos();
//            atributos.getFormulas().setCurrentHealth(atributos.getFormulas().getHealth());
//            atributos.getFormulas().setChakraAtual(atributos.getFormulas().getChakra());
//            atributos.getFormulas().setStaminaAtual(atributos.getFormulas().getStamina());
        }

        this.exp = exp;
    }

    public void addExp(int exp) {
        setExp(getExp() + exp);
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

    public Bag getBolsa() {
        return bolsa;
    }

    public void setBolsa(Bag bolsa) {
        this.bolsa = bolsa;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

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
}
