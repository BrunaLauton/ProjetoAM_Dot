/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.dao;

import br.dot.modelo.Grupo;
import br.fiap.conexao.Conexao;
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
     
//     public boolean alterarCliente(Cliente cliente){
//        boolean status = false;
//        sql = "update JAVA_CLIENTE set nome = ?, endereco = ?, nascimento = ?, fone = ?, foto = ? where cpf = ?";
//                try {
//            p = conexao.prepareStatement(sql);            
//            p.setString(1, cliente.getNome());
//            p.setString(2, cliente.getEndereco());
//            p.setDate(3, cliente.getNascimento());
//            p.setString(4, cliente.getFone());
//            p.setString(5, cliente.getCaminho());
//            p.setString(6, cliente.getCpf());
//            p.execute();
//            status = true;
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados do cliente no banco\n"+ex);
//        }
//        return status;
//    }
//     
//         public Cliente pesquisarCPF(String cpf){
//        Cliente aux = null;
//        
//        sql = "select * from JAVA_CLIENTE where cpf = ?";
//        
//        try{
//            
//         p = conexao.prepareStatement(sql);
//         p.setString(1, cpf);
//         rs = p.executeQuery();
//         
//         if(rs.next()){
//             String nome = rs.getString("nome");
//             String endereco = rs.getString("endereco");
//             Date nascimento = rs.getDate("nascimento");
//             String fone = rs.getString("fone");
//             String caminho = rs.getString("foto");
//             aux = new Cliente(cpf, nome, endereco, nascimento, fone, caminho);
//         }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return aux;
//    }
//    
//    public List<Cliente> listarCliente(){
//       
//        List<Cliente> lista = null;
//       
//        sql = "select * from java_cliente";
//        try {
//            p = conexao.prepareStatement(sql);
//            rs = p.executeQuery(); // rs = ...  quando for select no sql, extrair os dados pesquisados
//            lista = gerarLista(rs);
//        }
//        catch(SQLException e) {
//            JOptionPane.showMessageDialog(null, "Erro ao pesquisar todos os clientes\n"+e);
//        }
//        return lista;
//
//    }
//
//    
//    public boolean excluirCliente(String cpf){
//        boolean status = false;
//         sql = "delete from java_cliente where cpf = ?";
//        try {
//            p = conexao.prepareStatement(sql);    
//            p.setString(1, cpf);            
//            p.execute();
//            status = true;
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao excluir dados do cliente no banco\n"+ex);
//        }
//        return status;
//    }
//     
//     private List<Cliente> gerarLista(ResultSet rs) throws SQLException {
//        List<Cliente> lista = new ArrayList();
//        String cpf, nome, endereco, foto, fone;
//        Date nascimento;
//        while(rs.next()) {
//            cpf = rs.getString("cpf");
//            nome = rs.getString("nome");
//            endereco = rs.getString("endereco");
//            nascimento = rs.getDate("nascimento");
//            fone = rs.getString("fone");
//            foto = rs.getString("foto");
//            lista.add(new Cliente(cpf, nome, endereco, nascimento, fone, foto));            
//        }
//        return lista;
//
//    }
}
