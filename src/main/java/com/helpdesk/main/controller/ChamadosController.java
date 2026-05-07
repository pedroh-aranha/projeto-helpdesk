/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpdesk.main.controller;

import com.helpdesk.main.model.ChamadosBean;
import com.helpdesk.main.service.ChamadosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping("/abertos")
    public List<ChamadosBean> getChamadosAbertos() {
        return service.getChamadosAbertos();
    }
    
    @PostMapping
    public ResponseEntity<String> addChamado(@RequestBody ChamadosBean novoChamado) {
        if (novoChamado.getFuncionarioid() == null) {
            return ResponseEntity.badRequest().body("funcionarioId é obrigatório");
        }
        service.addChamado(novoChamado);
        return ResponseEntity.ok("Chamado feito com sucesso!");
    }

    @PutMapping("/{id}/concluir")
    public ResponseEntity<String> concluirChamado(@PathVariable Integer id, @RequestBody(required = false) ChamadosBean body) {
        if (body.getSolucaoAplicada() == null || body.getSolucaoAplicada().isBlank()) {
            return ResponseEntity.badRequest().body("solucao Aplicada é obrigatória");
        }
        String resposta = service.concluirChamado(id, body.getSolucaoAplicada());
        if (resposta.equals("Chamado concluído com sucesso!")) {
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.badRequest().body(resposta);
    }
}





