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
public class PreLancamento {
    
    private int idPreLancameto;
    private double distanciaAlvo;
    private double anguloLanca;
    private double velocidadeVento;
    private double pesoFoguete;
    private Login idLogin;

    public PreLancamento(int idPreLancameto, double distanciaAlvo, double anguloLanca, double velocidadeVento, double pesoFoguete, Login idLogin) {
        this.idPreLancameto = idPreLancameto;
        this.distanciaAlvo = distanciaAlvo;
        this.anguloLanca = anguloLanca;
        this.velocidadeVento = velocidadeVento;
        this.pesoFoguete = pesoFoguete;
        this.idLogin = idLogin;
    }

    public PreLancamento(int idPreLancameto, double distanciaAlvo, double anguloLanca, double velocidadeVento, double pesoFoguete) {
        this.idPreLancameto = idPreLancameto;
        this.distanciaAlvo = distanciaAlvo;
        this.anguloLanca = anguloLanca;
        this.velocidadeVento = velocidadeVento;
        this.pesoFoguete = pesoFoguete;
    }

    public int getIdPreLancameto() {
        return idPreLancameto;
    }

    public void setIdPreLancameto(int idPreLancameto) {
        this.idPreLancameto = idPreLancameto;
    }

    public double getDistanciaAlvo() {
        return distanciaAlvo;
    }

    public void setDistanciaAlvo(double distanciaAlvo) {
        this.distanciaAlvo = distanciaAlvo;
    }

    public double getAnguloLanca() {
        return anguloLanca;
    }

    public void setAnguloLanca(double anguloLanca) {
        this.anguloLanca = anguloLanca;
    }

    public double getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(double velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    public double getPesoFoguete() {
        return pesoFoguete;
    }

    public void setPesoFoguete(double pesoFoguete) {
        this.pesoFoguete = pesoFoguete;
    }

    public Login getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Login idLogin) {
        this.idLogin = idLogin;
    }
    
    
    
}
