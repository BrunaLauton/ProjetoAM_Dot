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
           sql = "insert into COMPONENTES values (id_generator.nextval,?,?,?,?);";
                p = conexao.prepareStatement(sql);
                p.setString(1, componente.getNome());
                p.setString(2, componente.getRm());
               //p.setInt(3, componente.getIdGrupo());
               // p.setString(4, componente.getIdLogin());
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
       
        sql = "select nome_componente, rm from COMPONENTES";
        try {
            p = conexao.prepareStatement(sql);
            rs = p.executeQuery(); // rs = ...  quando for select no sql, extrair os dados pesquisados
            lista = gerarLista(rs);
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar todos os clientes\n"+e);
        }
        return lista;

    }
        
        private List<Componente> gerarLista(ResultSet rs) throws SQLException {
        List<Componente> lista = new ArrayList();
        String nome, rm;
     
        while(rs.next()) {
            nome = rs.getString("nome_componente");
            rm = rs.getString("rm");
          
            lista.add(new Componente(nome, rm));            
        }
        return lista;

    }

}
