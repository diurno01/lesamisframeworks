package com.lesamis.lesAmisSpring.models.Requests;

public class ReservaVueloRequest {
    private String clase;
    private Long idUsuario;
    private Long idVuelo;
    private Long idSucursal;

    public ReservaVueloRequest(String clase, Long idUsuario, Long idVuelo, Long idSucursal) {
        this.clase = clase;
        this.idUsuario = idUsuario;
        this.idVuelo = idVuelo;
        this.idSucursal = idSucursal;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Long idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }
}
