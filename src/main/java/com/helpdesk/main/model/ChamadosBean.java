/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpdesk.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Aluno
 */
public class ChamadosBean {
    private Integer id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer funcionarioid;
    private String descricao;
    private String prioridade;
    private String status;
    private String nomefuncionario;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String solucaoAplicada; 

    public ChamadosBean() {
    }

    public ChamadosBean(Integer id, Integer funcionarioid, String descricao, String prioridade, String status, String nomefuncionario, String solucaoAplicada) {
        this.id = id;
        this.funcionarioid = funcionarioid;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.nomefuncionario = nomefuncionario;
        this.solucaoAplicada = solucaoAplicada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFuncionarioid() {
        return funcionarioid;
    }

    public void setFuncionarioid(Integer funcionarioid) {
        this.funcionarioid = funcionarioid;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomefuncionario() {
        return nomefuncionario;
    }

    public void setNomefuncionario(String nomefuncionario) {
        this.nomefuncionario = nomefuncionario;
    }

    public String getSolucaoAplicada() {
        return solucaoAplicada;
    }

    public void setSolucaoAplicada(String solucaoAplicada) {
        this.solucaoAplicada = solucaoAplicada;
    }

    
}
