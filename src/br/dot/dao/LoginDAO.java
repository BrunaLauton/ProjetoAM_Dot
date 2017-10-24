/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.dao;

import br.dot.modelo.Login;
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
            rs.next();
            usuario.setIdLogin(rs.getInt("idLogin"));
            achou = true;
         
            LoginDAO dao = new LoginDAO();
            dao.updateLoginON(usuario);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar usuário!\n"+ex);
        }
        
        return achou;
        
    }

    public void updateLoginON(Login usuario) {
        try {
            sql = "update LOGIN set logado = 'S' where idlogin = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setInt(1, usuario.getIdLogin());
            p.execute();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao logar usuarío!\n"+ex);
        }
    }

    public void updateLoginOFF() {
        try {
            sql = "update LOGIN set logado = 'N'"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.execute();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deslogar usuarío!\n"+ex);
        }
    }

    public Login acharLogado() throws SQLException {
        try {
            sql = "select * from LOGIN where logado = 'S'"; //MUDAR AQUI
            p = conexao.prepareStatement(sql); 
            rs = p.executeQuery();
            rs.next();    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        Login login = new Login(rs.getInt("idLogin"), rs.getString("usuario"), rs.getString("senha"), rs.getString("logado"));
        return login;
    }
}
