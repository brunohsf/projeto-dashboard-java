
package br.com.projetopaciente.model;

public class Uf {
    private Integer idUf;
    private String uf;

    public Uf() {
        
    }    
    
    public Uf(Integer idUf, String uf) {
        this.idUf = idUf;
        this.uf = uf;
    }

    public Uf(Integer idUf) {
        this.idUf = idUf;
    }

    public Uf(String uf) {
        this.uf = uf;
    }    

    public Integer getIdUf() {
        return idUf;
    }

    public void setIdUf(Integer idUf) {
        this.idUf = idUf;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    
    
    
            
}
