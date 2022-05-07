
package br.com.projetopaciente.model;

public class Cadastro {
    
    private Integer idCadastro;
    private String nome;
    private Endereco endereco;

    public Cadastro() {
    }

    public Cadastro(Integer idCadastro, String nome, Endereco endereco) {
        this.idCadastro = idCadastro;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Integer getIdCadastro() {
        return idCadastro;
    }

    public void setIdCadastro(Integer idCadastro) {
        this.idCadastro = idCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }   

    
    
}
