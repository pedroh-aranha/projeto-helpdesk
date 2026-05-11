/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpdesk.main.controller;


import com.helpdesk.main.model.AutenticadoBean;
import com.helpdesk.main.model.UsuarioBean;
import com.helpdesk.main.service.TokenService;
import com.helpdesk.main.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService uservice;
    
    @Autowired
    private TokenService tservice;
    
    @PostMapping("/cadastrar")
    public void register(@RequestBody UsuarioBean usuario) {
        uservice.register(usuario);      
    }
    
    
    @PostMapping("/login")
    public AutenticadoBean login(@RequestBody AutenticadoBean autenticado) {
        UsuarioBean usuario = uservice.login(autenticado.getEmail(), autenticado.getSenha());
        String token = tservice.gerarToken(usuario.getNome());
        AutenticadoBean retorno = new AutenticadoBean();
        retorno.setNome(usuario.getNome());
        retorno.setToken(token);
        return retorno;
    }
}
