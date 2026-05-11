/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpdesk.main.controller;

import com.helpdesk.main.model.FuncionariosBean;
import com.helpdesk.main.service.FuncionariosService;
import com.helpdesk.main.service.TokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno*/
 @RestController
 @RequestMapping("api/funcionarios")
public class FuncionariosController {
    
    @Autowired
    private FuncionariosService service;
    
    @Autowired
    private TokenService tservice;
    
    @GetMapping
    public List<FuncionariosBean> listarFuncionarios(@RequestHeader("Authorization")String auth) {
        String token = auth.replace("Bearer ", "");
        if(tservice.validarToken(token)) {
        return service.listarFuncionarios();
        } else {
            return null;
        }
    }   
     
}
