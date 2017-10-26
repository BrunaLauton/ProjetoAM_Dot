/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.dao;

import br.dot.conexao.Conexao;
import br.dot.modelo.Login;
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
    
    public boolean cadastrarLogin(Login login){
        try {
            sql = "insert into LOGIN values (id_generator.nextval,?, ?, ?)";
            p = conexao.prepareStatement(sql);
            p.setString(1, login.getUsuario());
            p.setString(2, login.getSenha());            
            p.setString(3, "N");
            p.execute();
            return true;
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    public List<Login> listarLogin(){
       
        List<Login> lista = null;
       
        sql = "select idLogin, usuario, senha from LOGIN";
        try {
            p = conexao.prepareStatement(sql);
            rs = p.executeQuery(); // rs = ...  quando for select no sql, extrair os dados pesquisados
            lista = gerarLista(rs);
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar todos os logins cadastrados!\n"+e);
        }
        return lista;

    }
        
    private List<Login> gerarLista(ResultSet rs) throws SQLException {
        List<Login> lista = new ArrayList();
        String usuario, senha;
        int idUsuario;
        
        while(rs.next()) {
            idUsuario = Integer.parseInt(rs.getString("idLogin"));
            usuario = rs.getString("usuario");
            senha = rs.getString("senha");
          
            lista.add(new Login(idUsuario ,usuario, senha, "N"));            
        }
        return lista;
    }

    public void updateLoginON(Login usuario) {
        try {
            sql = "update LOGIN set logado = ? where idlogin = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setString(1, "S");
            p.setInt(2, usuario.getIdLogin());
            p.execute();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao logar usuarío!\n"+ex);
        }
    }

    public void updateLoginOFF() {
        try {
            sql = "update LOGIN set logado = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setString(1, "N");
            p.execute();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deslogar usuarío!\n"+ex);
        }
    }

    public Login acharLogado() throws SQLException {
        try {
            sql = "select * from LOGIN where logado = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql); 
            p.setString(1, "S");
            rs = p.executeQuery();
            rs.next();    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        Login login = new Login(rs.getInt("idLogin"), rs.getString("usuario"), rs.getString("senha"), rs.getString("logado"));
        return login;
    }

    public boolean acharLogadoBoolean() {
        try {
            sql = "select * from LOGIN where logado = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql); 
            p.setString(1, "S");
            rs = p.executeQuery();
            if(rs.next())
                return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return false;
    }

    public Login PesquisarLoginPeloNome(String nome) throws SQLException {
        try {
            sql = "select * from LOGIN where usuario = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setString(1, nome);
            rs = p.executeQuery();
            rs.next(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar usuarío!\n"+e);
        }
        Login login = new Login(rs.getInt("idLogin"), rs.getString("usuario"), rs.getString("senha"), rs.getString("logado"));
        return login;
    }

    public boolean ExcluirLoginPeloNome(String nome) {
        try {
            sql = "delete from LOGIN where usuario = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setString(1, nome);
            p.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuarío!\n"+e);
        }
        return false;
    }

    public boolean AlterarLoginPeloNome(String nome, String senha) {
        try {
            sql = "update LOGIN set senha = ? where usuario = ?"; //MUDAR AQUI
            p = conexao.prepareStatement(sql);
            p.setString(1, senha);
            p.setString(2, nome);
            p.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar usuarío!\n"+e);
        }
        return false;
    }
}

