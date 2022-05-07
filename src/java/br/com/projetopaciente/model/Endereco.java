
package br.com.projetopaciente.model;

public class Endereco {
    private Integer idEndereco;
    private String endereco;
    private String cep;
    private String cidade;
    private Integer idUf;

    public Endereco() {
    }

    public Endereco(Integer idEndereco, String endereco, String cep, String cidade, Integer idUf) {
        this.idEndereco = idEndereco;
        this.endereco = endereco;
        this.cep = cep;
        this.cidade = cidade;
        this.idUf = idUf;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getIdUf() {
        return idUf;
    }

    public void setIdUf(Integer idUf) {
        this.idUf = idUf;
    }

      
    
           
}
