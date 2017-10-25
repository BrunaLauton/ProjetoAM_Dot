/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.modelo;

/**
 *
 * @author bruna
 */
public class Componente {
    
    private int idComponente;
    private String nome;
    private Grupo idGrupo;
    private String rm;
    private Login idLogin;

    public Componente(String nome, Grupo idGrupo, String rm) {
        this.nome = nome;
        this.idGrupo = idGrupo;
        this.rm = rm;
    }

    public Componente(String nome, String rm) {
        this.nome = nome;
        this.rm = rm;
    }
    

    public Componente(int idComponente, String nome, Grupo idGrupo, String rm, Login idLogin) {
        this.idComponente = idComponente;
        this.nome = nome;
        this.idGrupo = idGrupo;
        this.rm = rm;
        this.idLogin = idLogin;
    }

    public int getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(int idComponente) {
        this.idComponente = idComponente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Grupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public Login getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Login idLogin) {
        this.idLogin = idLogin;
    }
    
    
   

   

    
    
}
