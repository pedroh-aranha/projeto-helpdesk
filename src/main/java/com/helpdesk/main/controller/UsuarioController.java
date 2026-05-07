/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpdesk.main.controller;

import com.helpdesk.main.model.UsuarioBean;
import com.helpdesk.main.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;
    
    @PostMapping("/cadastrar")
    public void register(@RequestBody UsuarioBean usuario) {
        service.register(usuario);      
    }
    
    
    @PostMapping("/login")
    public void login() {

    }
}
