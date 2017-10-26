/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.dao;

import br.dot.modelo.Componente;
import br.dot.modelo.Grupo;
import br.dot.conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author bruna
 */
public class GrupoDAO {
    
    private Connection conexao;
    private String sql;
    private PreparedStatement p;
    private ResultSet rs;

    public GrupoDAO() {
        this.conexao = Conexao.getConnection();
    }
    
     public boolean inserirGrupo(Grupo grupo){
        
        boolean status = false;
        sql = "insert into GRUPO values (?, ?, ?, ?, ?, ?, ?)";
        try{
           p = conexao.prepareStatement(sql);
           p.setString(1,grupo.getNome());
           p.setString(3, grupo.getTurma());
           p.setInt (4, grupo.getQtdLancamentos());
           p.setInt(5, grupo.getLogin().getIdLogin());
           p.execute();
           status = true;   
                       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o grupo no banco! \n"+ex);
            
        }
        
        return status;
    }
     
     public List<Grupo> listarGrupo(){
       
        List<Grupo> lista = null;
       
        sql = "select idGrupo, nome, turma, qtdLancamento from GRUPO where login = ?";
        try {
            p = conexao.prepareStatement(sql);
            LoginDAO dao = new LoginDAO();
            p.setInt(1, dao.acharLogado().getIdLogin());
            rs = p.executeQuery(); // rs = ...  quando for select no sql, extrair os dados pesquisados
            lista = gerarLista(rs);
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar todos os grupos!\n"+e);
        }
        return lista;

    }
        
        private List<Grupo> gerarLista(ResultSet rs) throws SQLException {
        List<Grupo> lista = new ArrayList();
        String nome, rm;
        int idGrupo,  qtdLancamento;
     
        while(rs.next()) {
            idGrupo = rs.getInt("idGrupo");
            nome = rs.getString("nome");
            rm = rs.getString("turma");
            qtdLancamento = rs.getInt("qtdLancamento");
          
            lista.add(new Grupo(idGrupo, nome, rm, qtdLancamento));            
        }
        return lista;

    }
     
    public boolean cadastrarGrupo(Grupo grupo) {
        try{
           sql = "insert into GRUPO values (id_generator.nextval,?,?,?,?)";
                p = conexao.prepareStatement(sql);
                p.setString(1, grupo.getNome());
                p.setString(2, grupo.getTurma());                
                p.setInt(3, grupo.getQtdLancamentos());
                LoginDAO dao = new LoginDAO();
                p.setInt(4, dao.acharLogado().getIdLogin());
                p.execute();
                return true;
       } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

    public List pegarGrupos() {
        List myList = new ArrayList();
        
        try {
            sql = "select * from GRUPO where login = ?";
            p = conexao.prepareStatement(sql);
            LoginDAO dao = new LoginDAO();
            p.setInt(1, dao.acharLogado().getIdLogin());
            rs = p.executeQuery();             
            while(rs.next()){
                myList.add(rs.getString("nome"));
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return myList;
    }

    public Grupo pegarGrupoPeloNome(String nomeGrupo) throws SQLException {
        try {
            sql = "select * from GRUPO where nome = ? and login = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql); 
            p.setString(1, nomeGrupo);
            LoginDAO dao = new LoginDAO();
            p.setInt(2, dao.acharLogado().getIdLogin());
            rs = p.executeQuery();
            rs.next();    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        Grupo grupo = new Grupo(rs.getInt("IDGRUPO"), rs.getString("NOME"), rs.getString("TURMA"), rs.getInt("QTDLANCAMENTO"));
        return grupo;
    }
    
     public boolean alterarGrupo(String nome,String turma, String qtdLancamento) {
        try {
            sql = "update GRUPO set turma = ?, qtdLancamento = ?  where nome = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setString(3, nome);
            p.setString(1, turma);
            p.setString(2, qtdLancamento);
            p.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar grupo!\n"+e);
        }
        return false;
    }
     
     public boolean excluirGrupo(String nome) {
        try {
            sql = "delete from GRUPO where nome = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setString(1, nome);
            p.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir GRUPO!\n"+e);
        }
        return false;
    }
     
     public Grupo pesquisarGrupo(String nome) throws SQLException {
        try {
            sql = "select * from GRUPO where nome = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setString(1, nome);
            rs = p.executeQuery();
            rs.next(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Grupo!\n"+e);
        }
        Grupo grupo = new Grupo(rs.getString("nome"), rs.getString("turma"), rs.getInt("qtdLancamento"));
        
        return grupo;
    }
}
