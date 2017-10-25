 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.modelo;

import java.awt.List;
import java.sql.Date;

/**
 *
 * @author bruna
 */
public class Grupo {
    
    private int idGrupo;
    private String nome;
    private String turma;
    private int qtdLancamentos;
    private Login login;

    public Grupo(int idGrupo, String nome, String turma, int qtdLancamentos, Login login) {
        this.idGrupo = idGrupo;
        this.nome = nome;
        this.turma = turma;
        this.qtdLancamentos = qtdLancamentos;
        this.login = login;
    }

    public Grupo(String nome, String turma, int qtdLancamentos) {
        this.nome = nome;
        this.turma = turma;
        this.qtdLancamentos = qtdLancamentos;
    }
    
    

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public int getQtdLancamentos() {
        return qtdLancamentos;
    }

    public void setQtdLancamentos(int qtdLancamentos) {
        this.qtdLancamentos = qtdLancamentos;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    
    

        
}
