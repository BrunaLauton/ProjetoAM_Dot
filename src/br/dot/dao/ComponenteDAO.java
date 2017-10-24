/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.dao;

import br.dot.modelo.Componente;
import br.dot.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

}
