
package br.com.projetopaciente.model;

public class TipoSanguineo {
    private Integer idTipoSanguineo;
    private String tipoSanguineo;

    public TipoSanguineo() {
    }

    public TipoSanguineo(Integer idTipoSanguineo, String tipoSanguineo) {
        this.idTipoSanguineo = idTipoSanguineo;
        this.tipoSanguineo = tipoSanguineo;
    }

    public Integer getIdTipoSanguineo() {
        return idTipoSanguineo;
    }

    public void setIdTipoSanguineo(Integer idTipoSanguineo) {
        this.idTipoSanguineo = idTipoSanguineo;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
    
    
}
