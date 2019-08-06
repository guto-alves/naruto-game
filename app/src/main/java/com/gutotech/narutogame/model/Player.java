package com.gutotech.narutogame.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.gutotech.narutogame.config.ConfigFirebase;

import java.util.List;

public class Player {
    private String id;
    private String nome;
    private String email;
    private String senha;
    private String sexo;
    private String dataNascimento;
    private String endereco;
    private String cep;
    private String estado;
    private String bairro;
    private String cidade;

    private List<String> personagens;


    public Player() {
    }

    public Player(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Player(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Player(String nome, String email, String senha, String sexo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.sexo = sexo;
    }

    public void salvar() {
        DatabaseReference reference = ConfigFirebase.getDatabase();
        DatabaseReference player = reference.child("player").child(ConfigFirebase.getAuth().getCurrentUser().getUid());

        player.setValue(this);
    }

    @Exclude
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<String> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<String> personagens) {
        this.personagens = personagens;
    }
}
