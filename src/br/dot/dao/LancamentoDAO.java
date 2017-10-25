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
       
        sql = "select idLancamento, altitudeMax, velocidadeMax, tempoPropulsao, picoAceleracao, aceleracaoMedia, tempoQueda, tempoEjecao, altitudeEjecao, taxaDescida, duracaoVoo, distanciaAlvo, data from LANCAMENTO";
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
        Double altitudeMax, velocidadeMax, tempoPropulsao, picoAceleracao, aceleracaoMedia, tempoQueda, tempoEjecao, altitudeEjecao, taxaDescida, duracaoVoo, distanciaAlvo;
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

    public boolean cadastrarLancamento(Lancamento lancamento) {
        try{
           sql = "insert into LANCAMENTO values (id_generator.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                p = conexao.prepareStatement(sql);
                p.setDouble(1, lancamento.getAltitudeMax());
                p.setDouble(2, lancamento.getVelocidadeMax());
                p.setDouble(3, lancamento.getTempoPropulsao());
                p.setDouble(4, lancamento.getPicoAceleracao());
                p.setDouble(5, lancamento.getAceleracaoMedia());
                p.setDouble(6, lancamento.getTempoQueda());
                p.setDouble(7, lancamento.getTempoEjecao());
                p.setDouble(8, lancamento.getAltitudeEjecao());
                p.setDouble(9, lancamento.getTaxaDescida());
                p.setDouble(10, lancamento.getDuracaoVoo());
                p.setDouble(11, lancamento.getDistanciaDoAlvo());
                p.setDate(12, lancamento.getData());
                p.setInt(13, lancamento.getGrupo().getIdGrupo());
                p.setInt(14, lancamento.getPreLanca().getIdPreLancameto());
                LoginDAO dao = new LoginDAO();
                p.setInt(15, dao.acharLogado().getIdLogin());
                p.execute();
                return true;
       } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
}
