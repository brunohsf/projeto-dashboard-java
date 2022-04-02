/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetopaciente.model;

/**
 *
 * @author Aluno
 */
public class Paciente {
    
    private int id;
    private String nome;
    private String endereco;
    private String tipoSanguineo;
    private double peso;
    private String cidade;
    private String uf;
    private String cep;

    
           

    public Paciente() {
        
    }

    public Paciente(int id, String nome, String endereco, String tipoSanguineo, double peso, String cidade, String uf, String cep) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.tipoSanguineo = tipoSanguineo;
        this.peso = peso;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
    
    
}
