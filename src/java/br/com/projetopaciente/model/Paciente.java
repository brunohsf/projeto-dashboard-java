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
public class Paciente extends Cadastro{

    private int idPaciente;
    private TipoSanguineo tipoSanguineo;
    private double peso;

    public Paciente() {
    }

    public Paciente(int idPaciente, TipoSanguineo tipoSanguineo, double peso) {
        this.idPaciente = idPaciente;
        this.tipoSanguineo = tipoSanguineo;
        this.peso = peso;
    }    

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
    
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    
    
    
    
}
