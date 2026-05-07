/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpdesk.main.service;

import com.helpdesk.main.model.ChamadosBean;
import com.helpdesk.main.repository.ChamadosDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author Aluno
 */
@Service
public class ChamadosService {
    
    @Autowired
    private ChamadosDAO repository;
    
    public List<ChamadosBean> getChamadosAbertos() {
        return repository.getChamadosAbertos();
    }
    
    public void addChamado(ChamadosBean chamado) {
        if (chamado.getDescricao() != null &&
            chamado.getDescricao().toLowerCase().contains("urgente")) {
            chamado.setPrioridade("Alta");
        }
        chamado.setStatus("Pendente");
        repository.addChamado(chamado);
    }
    
    public String concluirChamado(Integer id, String solucaoAplicada) {
    String statusAtual = repository.pegartStatusporId(id);

    if (statusAtual == null) {
        return "Chamado não encontrado";
    }
    if (statusAtual.equals("Resolvido")) {
        return "Chamado já resolvido e não pode ser editado";
    }

    repository.concluirChamado(id, solucaoAplicada);
    return "Chamado concluído com sucesso!";
    }
     
     
}
