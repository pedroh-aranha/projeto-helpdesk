/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpdesk.main.repository;

import com.helpdesk.main.model.UsuarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */@Repository
public class UsuarioDAO {
    
    public UsuarioBean login(String email, String senha) {
    UsuarioBean auth = new UsuarioBean();
        try {
            Connection conn = Conexao.conectar();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("select * from usuarios where email = ? and senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
            auth.setNome(rs.getString("nome"));
            auth.setEmail(rs.getString("email"));
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    return auth;
    }
          
    public UsuarioBean register(UsuarioBean usuario) {
        try {
            Connection conn = Conexao.conectar();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("INSERT INTO usuarios (nome, email, senha) VALUES (?,?,?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return usuario;
    }
     
       
}
