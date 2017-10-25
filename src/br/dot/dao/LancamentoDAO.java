/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.dao;

import br.dot.conexao.Conexao;
import br.dot.modelo.Lancamento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author bruna
 */
public class LancamentoDAO {
     private Connection conexao;
    private String sql;
    private PreparedStatement p;
    private ResultSet rs;

    public LancamentoDAO() {
        this.conexao = Conexao.getConnection();
    }
    
    
    public List<Lancamento> listarLancamento(){
       
        List<Lancamento> lista = null;
       
        sql = "select idLancamento, altitudeMax, velocidadeMax, tempoPropulsao,picoAceleracao, tempoQueda, tempoEjecao, altitudeEjecao, taxaDescida, duracaoVoo, distanciaAlvo, data from LANCAMENTO";
        try {
            p = conexao.prepareStatement(sql);
            rs = p.executeQuery(); // rs = ...  quando for select no sql, extrair os dados pesquisados
            lista = gerarLista(rs);
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar todos os dados do Lançamento!\n"+e);
        }
        return lista;

    }
        
        private List<Lancamento> gerarLista(ResultSet rs) throws SQLException {
        List<Lancamento> lista = new ArrayList();
        Double altitudeMax, velocidadeMax, tempoPropulsao,picoAceleracao,aceleracaoMedia, tempoQueda, tempoEjecao, altitudeEjecao, taxaDescida, duracaoVoo, distanciaAlvo;
        int idLancamento;
        Date data;
     
        while(rs.next()) {
            idLancamento = rs.getInt("idLancamento");
            altitudeMax = rs.getDouble("altitudeMax");
            velocidadeMax = rs.getDouble("velocidadeMax");
            tempoPropulsao = rs.getDouble("tempoPropulsao");
            picoAceleracao = rs.getDouble("picoAceleracao");
            aceleracaoMedia = rs.getDouble("aceleracaoMedia");
            tempoQueda = rs.getDouble("tempoQueda");
            tempoEjecao = rs.getDouble("tempoEjecao");
            altitudeEjecao = rs.getDouble("altitudeEjecao");
            taxaDescida = rs.getDouble("taxaDescida");
            duracaoVoo = rs.getDouble("duracaoVoo");
            distanciaAlvo = rs.getDouble("distanciaAlvo");
            data = rs.getDate("data");
            
            lista.add(new Lancamento(idLancamento, altitudeMax, velocidadeMax, tempoPropulsao, picoAceleracao,aceleracaoMedia, tempoQueda, tempoEjecao, altitudeEjecao, taxaDescida, duracaoVoo, distanciaAlvo, data));            
        }
        return lista;

    }
}
