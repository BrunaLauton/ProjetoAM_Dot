/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.dao;

import br.dot.modelo.Componente;
import br.dot.modelo.Grupo;
import br.dot.modelo.Login;
import br.dot.conexao.Conexao;
import br.dot.conexao.Conexao;
import java.sql.Connection;
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
public class ComponenteDAO {
    
    private Connection conexao;
    private String sql;
    private PreparedStatement p;
    private ResultSet rs;

    public ComponenteDAO() {
        this.conexao = Conexao.getConnection();
    }
    
    public boolean cadastrarComponente(Componente componente){
       try{
           sql = "insert into COMPONENTES values (id_generator.nextval,?,?,?,?)";
                p = conexao.prepareStatement(sql);
                p.setString(1, componente.getNome());
                p.setString(2, componente.getRm());
                p.setInt(3, componente.getIdGrupo().getIdGrupo());
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
    
    
         public List<Componente> listarComponente(){
       
        List<Componente> lista = null;
       
        sql = "select idComponentes, nome_componente, rm from COMPONENTES where login = ?";
        try {
            p = conexao.prepareStatement(sql);
            LoginDAO dao = new LoginDAO();
            p.setInt(1, dao.acharLogado().getIdLogin());
            rs = p.executeQuery(); // rs = ...  quando for select no sql, extrair os dados pesquisados
            lista = gerarLista(rs);
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar todos os componentes do grupo!\n"+e);
        }
        return lista;

    }
        
        private List<Componente> gerarLista(ResultSet rs) throws SQLException {
        List<Componente> lista = new ArrayList();
        String nome, rm;
        int idComponente;
     
        while(rs.next()) {
            idComponente = rs.getInt("idComponentes");
            nome = rs.getString("nome_componente");
            rm = rs.getString("rm");
          
            lista.add(new Componente(idComponente, nome, rm));            
        }
        return lista;

    }
        
    public boolean alterarComponente(String nome,String rm/*, String grupo*/) {
        try {
            sql = "update COMPONENTES set rm = ? where nome_componente = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setString(2, nome);
            p.setString(1, rm);
            //p.setString(2, grupo);
            p.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar componente!\n"+e);
        }
        return false;
    }
    
    public boolean excluirComponente(String nome) {
        try {
            sql = "delete from COMPONENTES where nome_componente = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setString(1, nome);
            p.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir componente!\n"+e);
        }
        return false;
    }
    
    public Componente pesquisarComponente(String nome) throws SQLException {
        try {
            sql = "select * from COMPONENTES where nome_componente = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setString(1, nome);
            rs = p.executeQuery();
            rs.next(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar componente!\n"+e);
        }
        Componente componente = new Componente(rs.getString("nome_componente"), rs.getString("rm"));
        
        return componente;
    }

}
