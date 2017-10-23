/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.dao;

import br.dot.modelo.Login;
import br.fiap.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author bruna
 */
public class LoginDAO {
    
    private Connection conexao;
    private String sql;
    private PreparedStatement p;
    private ResultSet rs;
    
    
    public LoginDAO(){       
        conexao = Conexao.getConnection();   
    }

    
    public boolean logarSistema(Login usuario){
        
        boolean achou = false;
        
        try {
            sql = "select * from LOGIN where usuario = ? and senha = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setString(1,usuario.getUsuario());
            p.setString(2, usuario.getSenha());
            rs = p.executeQuery();
            achou = rs.next();
            usuario.setIdLogin(rs.getInt("idLogin"));
            achou = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar usuário!\n"+ex);
        }
        
        return achou;
        
    }
}
