
package br.com.projetopaciente.model;

public class Endereco {
    private Integer idEndereco;
    private String endereco;
    private String cep;
    private Uf uf;

    public Endereco() {
    }

    public Endereco(Integer idEndereco, String endereco, String cep, Uf uf) {
        this.idEndereco = idEndereco;
        this.endereco = endereco;
        this.cep = cep;
        this.uf = uf;
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

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }
    
    
           
}
