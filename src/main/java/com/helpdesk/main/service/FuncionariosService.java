/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpdesk.main.service;

import com.helpdesk.main.model.FuncionariosBean;
import com.helpdesk.main.repository.FuncionariosDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class FuncionariosService {
    
    @Autowired
    private FuncionariosDAO repository;
    
    public List<FuncionariosBean> listarFuncionarios() {
        return repository.listarFuncionarios();
    }
    
}
