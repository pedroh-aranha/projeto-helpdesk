/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpdesk.main.repository;

import com.helpdesk.main.model.FuncionariosBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class FuncionariosDAO {
    
    public List<FuncionariosBean> listarFuncionarios() {
        List<FuncionariosBean> lista = new ArrayList<>();
        try {
            Connection conn = Conexao.conectar();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("select * from funcionarios" );
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                FuncionariosBean Funcionarios = new FuncionariosBean();
                Funcionarios.setId(rs.getInt("id"));
                Funcionarios.setNome(rs.getString("nome"));
                Funcionarios.setEmail(rs.getString("email"));
               
                lista.add(Funcionarios);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
