/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.dao;

import br.dot.conexao.Conexao;
import br.dot.modelo.PreLancamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
