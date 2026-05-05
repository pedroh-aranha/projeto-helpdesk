/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpdesk.main.repository;

import com.helpdesk.main.model.ChamadosBean;
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
public class ChamadosDAO {

    // POST /chamados
    public void addChamado(ChamadosBean chamado) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO chamados (funcionario_id, descricao, prioridade, status) VALUES (?,?,?,?)"
            );
            stmt.setInt(1, chamado.getFuncionarioid());
            stmt.setString(2, chamado.getDescricao());
            stmt.setString(3, chamado.getPrioridade());
            stmt.setString(4, chamado.getStatus());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ChamadosBean> getChamadosAbertos() {
        List<ChamadosBean> lista = new ArrayList<>();
        try {
            Connection conn = Conexao.conectar();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
             stmt = conn.prepareStatement(
                "SELECT c.id, c.descricao, c.prioridade, c.status, f.nome AS nomeFuncionario FROM chamados c " +
                "JOIN funcionarios f ON c.funcionario_id = f.id " +
                "WHERE c.status = 'Pendente'");
             
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                ChamadosBean c = new ChamadosBean();
                c.setId(rs.getInt("id"));
                c.setDescricao(rs.getString("descricao"));
                c.setPrioridade(rs.getString("prioridade"));
                c.setStatus(rs.getString("status"));
                c.setNomefuncionario(rs.getString("nomeFuncionario"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public String pegartStatusporId(Integer id) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT status FROM chamados WHERE id = ?"
            );
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("status");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void concluirChamado(Integer id) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                "UPDATE chamados SET status = 'Resolvido' WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

