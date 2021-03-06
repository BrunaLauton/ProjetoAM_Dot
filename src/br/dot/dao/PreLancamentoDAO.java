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

    public List pegarPreLancamentos() {
        List myList = new ArrayList();
        
        try {
            sql = "select * from prelancamento where login = ?";
            p = conexao.prepareStatement(sql);
            LoginDAO dao = new LoginDAO();
            p.setInt(1, dao.acharLogado().getIdLogin());
            rs = p.executeQuery();             
            while(rs.next()){
                myList.add(rs.getInt("idprelancamento"));
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return myList;
    }

    public PreLancamento pegarPrePeloId(String idPre) throws SQLException {
        try {
            sql = "select * from PreLancamento where idprelancamento = ? and login = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql); 
            p.setString(1, idPre);
            LoginDAO dao = new LoginDAO();
            p.setInt(2, dao.acharLogado().getIdLogin());
            rs = p.executeQuery();
            rs.next();    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        PreLancamento preLancamento = new PreLancamento(rs.getInt("IDPRELANCAMENTO"), rs.getInt("distanciaAlvo"), rs.getInt("anguloLancamento"), rs.getInt("velocidadeVento"), rs.getInt("pesoFoguete"));
        return preLancamento;
    }

    public PreLancamento PesquisarPreLancamentoPelaDist(double dist) throws SQLException {
        try {
            sql = "select * from PreLancamento where distanciaalvo = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setDouble(1, dist);
            rs = p.executeQuery();
            rs.next(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar usuarío!\n"+e);
        }
        PreLancamento preLancamento = new PreLancamento(rs.getInt("IDPRELANCAMENTO"), rs.getDouble("DISTANCIAALVO"), rs.getDouble("ANGULOLANCAMENTO"), rs.getDouble("VELOCIDADEVENTO"), rs.getDouble("PESOFOGUETE"));
        return preLancamento;//To change body of generated methods, choose Tools | Templates.
    }

    public boolean ExcluirPreLancamentoPelaDist(double dist) {
        try {
            sql = "delete from PreLancamento where distanciaalvo = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setDouble(1, dist);
            p.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuarío!\n"+e);
        }
        return false;
    }
    
    public boolean AlterarPreLancamentoPelaDist(double dist, double ang, double vel, double peso) {
        try {
            sql = "update PreLancamento set ANGULOLANCAMENTO = ?, VELOCIDADEVENTO = ?, PESOFOGUETE = ? where distanciaalvo = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setDouble(1, ang);
            p.setDouble(2, vel);
            p.setDouble(3, peso);
            p.setDouble(4, dist);
            p.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar PreLancamento!\n"+e);
        }
        return false;
    }
    
}
