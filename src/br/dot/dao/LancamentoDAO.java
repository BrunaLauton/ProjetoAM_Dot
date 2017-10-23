/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.dao;

import br.fiap.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    
}
