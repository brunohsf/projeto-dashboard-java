
package br.com.projetopaciente.model;

public class Endereco {
    private Integer idEndereco;
    private String endereco;
    private String cep;
    private String cidade;
    private Uf uf;

    public Endereco() {
    }

    public Endereco(Integer idEndereco, String endereco, String cep, String cidade, Uf uf) {
        this.idEndereco = idEndereco;
        this.endereco = endereco;
        this.cep = cep;
        this.cidade = cidade;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    

    

      
    
           
}
