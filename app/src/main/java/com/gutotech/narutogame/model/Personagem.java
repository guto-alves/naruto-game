package com.gutotech.narutogame.model;

import com.google.firebase.database.DatabaseReference;
import com.gutotech.narutogame.config.ConfigFirebase;

import java.io.Serializable;
import java.util.List;

public class Personagem implements Serializable {
    private String idPlayer;
    private String nick;
    private String titulo;
    private int level;
    private String graducao;
    private int idGraducao;
    private String classe;
    private String vila;
    private int numVila;
    private long ryous;
    private int idProfile;
    private int fotoAtual;

    private int diasLogadosFidelidade;
    private boolean temRecompensaFidelidade;

    private List<String> titulos;

    private Atributos atributos;

    private int expAtual;
    private int expUpar;

    private int combatesNPCDiarios;
    private ResumoCombates resumoCombates;

    private ResumoMissoes resumoMissoes;
    private boolean emMissao;
    private MissaoDeTempo missaoDeTempo;
    private MissaoEspecial missaoEspecial;
    private List<Integer> tarefasConcluidasIDs;

    private List<Atributo> atributosDistribuitos;

    // informações extras
    private int totalTreino;
    private int totalPontosDistribuitos;
    private int totalPontosLivres;
    private long totalHorasJogadas;

    private boolean fuiPego;
    private String nickOponente;
    private int mapa_posicao;
    private String idBatalhaAtual;

    private List<Jutsu> jutsus;
    private Jutsu jutsuSelecionado;

    private Bolsa bolsa;

    private String equipe;
    private String org;

    private int rankVila;
    private int rankGeral;
    private int pontos;
    private int posicao;
    private boolean on;

    private String ultimoLogin;

    public Personagem() {
    }

    public void salvar() {
        DatabaseReference personagemReference = ConfigFirebase.getDatabase()
                .child("personagem")
                .child(nick);
        personagemReference.setValue(this);
    }

    public List<String> getTitulos() {
        return titulos;
    }

    public void setTitulos(List<String> titulos) {
        this.titulos = titulos;
    }

    public void atualizarAtributos() {
        atributos.atualizarFormula();
    }

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
        if (expAtual >= getExpUpar()) {
            expAtual = expAtual - getExpUpar();
            setExpUpar(getExpUpar() + 1200);
            setLevel(getLevel() + 1);
            atualizarAtributos();
            atributos.getFormulas().setVidaAtual(atributos.getFormulas().getVida());
            atributos.getFormulas().setChakraAtual(atributos.getFormulas().getChakra());
            atributos.getFormulas().setStaminaAtual(atributos.getFormulas().getStamina());
        }

        this.expAtual = expAtual;
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

    public List<Integer> getTarefasConcluidas() {
        return tarefasConcluidasIDs;
    }

    public void setTarefasConcluidas(List<Integer> tarefasConcluidas) {
        this.tarefasConcluidasIDs = tarefasConcluidas;
    }

    public boolean isEmMissao() {
        return emMissao;
    }

    public void setEmMissao(boolean emMissao) {
        this.emMissao = emMissao;
    }

    public MissaoDeTempo getMissaoDeTempo() {
        return missaoDeTempo;
    }

    public void setMissaoDeTempo(MissaoDeTempo missaoDeTempo) {
        this.missaoDeTempo = missaoDeTempo;
    }

    public MissaoEspecial getMissaoEspecial() {
        return missaoEspecial;
    }

    public void setMissaoEspecial(MissaoEspecial missaoEspecial) {
        this.missaoEspecial = missaoEspecial;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public int getDiasLogadosFidelidade() {
        return diasLogadosFidelidade;
    }

    public void setDiasLogadosFidelidade(int diasLogadosFidelidade) {
        this.diasLogadosFidelidade = diasLogadosFidelidade;
    }

    public boolean isTemRecompensaFidelidade() {
        return temRecompensaFidelidade;
    }

    public void setTemRecompensaFidelidade(boolean temRecompensaFidelidade) {
        this.temRecompensaFidelidade = temRecompensaFidelidade;
    }

    public List<Atributo> getAtributosDistribuitos() {
        return atributosDistribuitos;
    }

    public void setAtributosDistribuitos(List<Atributo> atributosDistribuitos) {
        this.atributosDistribuitos = atributosDistribuitos;
    }

    public int getTotalTreino() {
        return totalTreino;
    }

    public void setTotalTreino(int totalTreino) {
        this.totalTreino = totalTreino;
    }

    public int getTotalPontosDistribuitos() {
        return totalPontosDistribuitos;
    }

    public void setTotalPontosDistribuitos(int totalPontosDistribuitos) {
        this.totalPontosDistribuitos = totalPontosDistribuitos;
    }

    public int getTotalPontosLivres() {
        return totalPontosLivres;
    }

    public void setTotalPontosLivres(int totalPontosLivres) {
        this.totalPontosLivres = totalPontosLivres;
    }

    public long getTotalHorasJogadas() {
        return totalHorasJogadas;
    }

    public void setTotalHorasJogadas(long totalHorasJogadas) {
        this.totalHorasJogadas = totalHorasJogadas;
    }

    public int getIdGraducao() {
        return idGraducao;
    }

    public void setIdGraducao(int idGraducao) {
        this.idGraducao = idGraducao;
    }

    public String getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(String ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
