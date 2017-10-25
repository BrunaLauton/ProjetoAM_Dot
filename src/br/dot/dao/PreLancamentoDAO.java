/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.dao;

import br.dot.conexao.Conexao;
import br.dot.modelo.Lancamento;
import br.dot.modelo.PreLancamento;
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
public class PreLancamentoDAO {
    
    private Connection conexao;
    private String sql;
    private PreparedStatement p;
    private ResultSet rs;

    public PreLancamentoDAO() {
        this.conexao = Conexao.getConnection();
    }
    
    public List<PreLancamento> listarPreLancamento(){
       
        List<PreLancamento> lista = null;
       
        sql = "select idPreLancamento, distanciaAlvo, anguloLancamento, velocidadeVento, pesoFoguete from PRELANCAMENTO";
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
        
        private List<PreLancamento> gerarLista(ResultSet rs) throws SQLException {
        List<PreLancamento> lista = new ArrayList();
        Double distanciaAlvo, anguloLancamento, velocidadeVento, pesoFoguete;
        int idPreLancamento;
     
        while(rs.next()) {
            idPreLancamento = rs.getInt("idPreLancamento");
            distanciaAlvo = rs.getDouble("distanciaAlvo");
            anguloLancamento = rs.getDouble("anguloLancamento");
            velocidadeVento = rs.getDouble("velocidadeVento");
            pesoFoguete = rs.getDouble("pesoFoguete");
            
            
            lista.add(new PreLancamento(idPreLancamento, distanciaAlvo, anguloLancamento, velocidadeVento, pesoFoguete));            
        }
        return lista;

    }
    
    public boolean cadastrarPreLancamento(PreLancamento preLancamento){
       try{
           sql = "insert into PRELANCAMENTO values (id_generator.nextval,?,?,?,?,?)";
                p = conexao.prepareStatement(sql);
                p.setDouble(1, preLancamento.getDistanciaAlvo());
                p.setDouble(2, preLancamento.getAnguloLanca());                
                p.setDouble(3, preLancamento.getVelocidadeVento());            
                p.setDouble(4, preLancamento.getPesoFoguete());
                LoginDAO dao = new LoginDAO();
                p.setInt(5, dao.acharLogado().getIdLogin());
                p.execute();
                return true;
       } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
}
