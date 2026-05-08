/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpdesk.main.service;

import com.helpdesk.main.model.UsuarioBean;
import com.helpdesk.main.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDAO repository;
    
    public String register(UsuarioBean usuario) {
        repository.register(usuario);
        return "cadastrado com sucesso";
    }
    
    public UsuarioBean login(String email, String senha) {
        return repository.login(email, senha);
    }
    
}
