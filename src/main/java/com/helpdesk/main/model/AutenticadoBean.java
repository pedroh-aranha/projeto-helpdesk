/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpdesk.main.model;

/**
 *
 * @author Aluno
 */
public class AutenticadoBean {
    private String nome;
    private String email;
    private String senha;
    private String token;

    public AutenticadoBean() {
    }

    public AutenticadoBean(String nome, String email, String senha, String token) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.token = token;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    
}
