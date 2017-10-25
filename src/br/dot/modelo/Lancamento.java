/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.modelo;

import java.sql.Date;

/**
 *
 * @author bruna
 */
public class Lancamento {
    
    private int idLancamento;
    private double altitudeMax;
    private double velocidadeMax;
    private double tempoPropulsao;
    private double picoAceleracao;
    private double aceleracaoMedia;
    private double tempoQueda; //mesmo que apogeu
    private double tempoEjecao;
    private double altitudeEjecao;
    private double taxaDescida;
    private double duracaoVoo;
    private double distanciaDoAlvo;
    private Date data;
    private PreLancamento preLanca;
    private Grupo grupo;
    private Login idLogin;

    public Lancamento(int idLancamento, double altitudeMax, double velocidadeMax, double tempoPropulsao, double picoAceleracao, double aceleracaoMedia, double tempoQueda, double tempoEjecao, double altitudeEjecao, double taxaDescida, double duracaoVoo, double distanciaDoAlvo, Date data) {
        this.idLancamento = idLancamento;
        this.altitudeMax = altitudeMax;
        this.velocidadeMax = velocidadeMax;
        this.tempoPropulsao = tempoPropulsao;
        this.picoAceleracao = picoAceleracao;
        this.aceleracaoMedia = aceleracaoMedia;
        this.tempoQueda = tempoQueda;
        this.tempoEjecao = tempoEjecao;
        this.altitudeEjecao = altitudeEjecao;
        this.taxaDescida = taxaDescida;
        this.duracaoVoo = duracaoVoo;
        this.distanciaDoAlvo = distanciaDoAlvo;
        this.data = data;
    }
    
    

    public Lancamento(int idLancamento, double altitudeMax, double velocidadeMax, double tempoPropulsao, double picoAceleracao, double aceleracaoMedia, double tempoQueda, double tempoEjecao, double altitudeEjecao, double taxaDescida, double duracaoVoo, double distanciaDoAlvo, Date data, PreLancamento preLanca, Grupo grupo, Login idLogin) {
        this.idLancamento = idLancamento;
        this.altitudeMax = altitudeMax;
        this.velocidadeMax = velocidadeMax;
        this.tempoPropulsao = tempoPropulsao;
        this.picoAceleracao = picoAceleracao;
        this.aceleracaoMedia = aceleracaoMedia;
        this.tempoQueda = tempoQueda;
        this.tempoEjecao = tempoEjecao;
        this.altitudeEjecao = altitudeEjecao;
        this.taxaDescida = taxaDescida;
        this.duracaoVoo = duracaoVoo;
        this.distanciaDoAlvo = distanciaDoAlvo;
        this.data = data;
        this.preLanca = preLanca;
        this.grupo = grupo;
        this.idLogin = idLogin;
    }

    public int getIdLancamento() {
        return idLancamento;
    }

    public void setIdLancamento(int idLancamento) {
        this.idLancamento = idLancamento;
    }

    public double getAltitudeMax() {
        return altitudeMax;
    }

    public void setAltitudeMax(double altitudeMax) {
        this.altitudeMax = altitudeMax;
    }

    public double getVelocidadeMax() {
        return velocidadeMax;
    }

    public void setVelocidadeMax(double velocidadeMax) {
        this.velocidadeMax = velocidadeMax;
    }

    public double getTempoPropulsao() {
        return tempoPropulsao;
    }

    public void setTempoPropulsao(double tempoPropulsao) {
        this.tempoPropulsao = tempoPropulsao;
    }

    public double getPicoAceleracao() {
        return picoAceleracao;
    }

    public void setPicoAceleracao(double picoAceleracao) {
        this.picoAceleracao = picoAceleracao;
    }

    public double getAceleracaoMedia() {
        return aceleracaoMedia;
    }

    public void setAceleracaoMedia(double aceleracaoMedia) {
        this.aceleracaoMedia = aceleracaoMedia;
    }

    public double getTempoQueda() {
        return tempoQueda;
    }

    public void setTempoQueda(double tempoQueda) {
        this.tempoQueda = tempoQueda;
    }

    public double getTempoEjecao() {
        return tempoEjecao;
    }

    public void setTempoEjecao(double tempoEjecao) {
        this.tempoEjecao = tempoEjecao;
    }

    public double getAltitudeEjecao() {
        return altitudeEjecao;
    }

    public void setAltitudeEjecao(double altitudeEjecao) {
        this.altitudeEjecao = altitudeEjecao;
    }

    public double getTaxaDescida() {
        return taxaDescida;
    }

    public void setTaxaDescida(double taxaDescida) {
        this.taxaDescida = taxaDescida;
    }

    public double getDuracaoVoo() {
        return duracaoVoo;
    }

    public void setDuracaoVoo(double duracaoVoo) {
        this.duracaoVoo = duracaoVoo;
    }

    public double getDistanciaDoAlvo() {
        return distanciaDoAlvo;
    }

    public void setDistanciaDoAlvo(double distanciaDoAlvo) {
        this.distanciaDoAlvo = distanciaDoAlvo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public PreLancamento getPreLanca() {
        return preLanca;
    }

    public void setPreLanca(PreLancamento preLanca) {
        this.preLanca = preLanca;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Login getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Login idLogin) {
        this.idLogin = idLogin;
    }
    
    
    
    

}
