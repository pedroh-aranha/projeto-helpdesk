/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpdesk.main.controller;

import com.helpdesk.main.model.ChamadosBean;
import com.helpdesk.main.service.ChamadosService;
import com.helpdesk.main.service.TokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("api/chamados")
public class ChamadosController {
    
    @Autowired
    private ChamadosService service;
    
    @Autowired
    private TokenService tservice;
    
    @GetMapping("/abertos")
    public List<ChamadosBean> getChamadosAbertos(@RequestHeader("Authorization") String auth) {
        String token = auth.replace("Bearer ", "");
        if(tservice.validarToken(token)) {
        return service.getChamadosAbertos();
        } else {
            return null;
        }
    }
    
    @PostMapping
    public ResponseEntity<String> addChamado(@RequestBody ChamadosBean novoChamado, @RequestHeader("Authorization")String auth) {
        String token = auth.replace("Bearer ", "");
        if(tservice.validarToken(token)) {
            if (novoChamado.getFuncionarioid() == null) {
                return ResponseEntity.badRequest().body("id do funcionario é obrigatório");
            }
            service.addChamado(novoChamado);
            return ResponseEntity.ok("Chamado feito com sucesso!");
        } else {
            return null;
        }
    }

    @PutMapping("/{id}/concluir")
    public ResponseEntity<String> concluirChamado(@PathVariable Integer id, @RequestBody(required = false) ChamadosBean body, @RequestHeader("Authorization")String auth) {
        String token = auth.replace("Bearer ", "");
        if(tservice.validarToken(token)) {
        
            if (body.getSolucaoAplicada() == null || body.getSolucaoAplicada().isBlank()) {
                return ResponseEntity.badRequest().body("solucao Aplicada é obrigatória");
            }
            String resposta = service.concluirChamado(id, body.getSolucaoAplicada());
            if (resposta.equals("Chamado concluído com sucesso!")) {
                return ResponseEntity.ok(resposta);
            }
            return ResponseEntity.badRequest().body(resposta);
        } else {
            return null;
        }
    }
}





