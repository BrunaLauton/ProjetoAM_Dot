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
public class Login {
    
    private int idLogin;
    private String usuario;
    private String senha;
    private String logado;

    public Login(int idLogin, String usuario, String senha, String logado) {
        this.idLogin = idLogin;
        this.usuario = usuario;
        this.senha = senha;
        this.logado = logado;
    }
    
    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogado() {
        return logado;
    }

    public void setLogado(String logado) {
        this.logado = logado;
    }
}
