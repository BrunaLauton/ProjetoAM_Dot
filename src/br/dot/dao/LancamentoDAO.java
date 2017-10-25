/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.dao;

import br.dot.conexao.Conexao;
import br.dot.modelo.Lancamento;
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
public class LancamentoDAO {
     private Connection conexao;
    private String sql;
    private PreparedStatement p;
    private ResultSet rs;

    public LancamentoDAO() {
        this.conexao = Conexao.getConnection();
    }
    
    
    public List<Lancamento> listarLancamento(){
       
        List<Lancamento> lista = null;
       
        sql = "select idComponentes, nome_componente, rm from LANCAMENto";
        try {
            p = conexao.prepareStatement(sql);
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
}
