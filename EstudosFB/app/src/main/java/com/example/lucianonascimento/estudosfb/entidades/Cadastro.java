package com.example.lucianonascimento.estudosfb.entidades;

import java.io.Serializable;

/**
 * Created by Fabiano Costa on 09/12/2016.
 */

public class Cadastro implements Serializable {
    private static final long serialVersionUID = 1633833011084400384L;

    public static final String TABLE_NAME = "cadastro";

    int id;
    String nome;
    String email;
    String contaGit;
    String curso;
    String senha;
    String matricula;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getContaGit() {
        return contaGit;
    }

    public void setContaGit(String contaGit) {
        this.contaGit = contaGit;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return this.nome + " (" + this.email + ")";
    }
}
