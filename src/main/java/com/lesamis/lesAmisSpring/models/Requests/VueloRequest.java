package com.lesamis.lesAmisSpring.models.Requests;

import java.time.LocalDateTime;

public class VueloRequest {

    private Long id;
    private Long numeroDeVuelo;
    private LocalDateTime fechaYHora;
    private String origen;
    private String destino;
    private Integer plazasTotales;
    private Integer plazasClaseTuristaDisponible;

    public VueloRequest() {

    }

    public VueloRequest(Long id, Long numeroDeVuelo, LocalDateTime fechaYHora, String origen, String destino, Integer plazasTotales, Integer plazasClaseTuristaDisponible) {
        this.id = id;
        this.numeroDeVuelo = numeroDeVuelo;
        this.fechaYHora = fechaYHora;
        this.origen = origen;
        this.destino = destino;
        this.plazasTotales = plazasTotales;
        this.plazasClaseTuristaDisponible = plazasClaseTuristaDisponible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroDeVuelo() {
        return numeroDeVuelo;
    }

    public void setNumeroDeVuelo(Long numeroDeVuelo) {
        this.numeroDeVuelo = numeroDeVuelo;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Integer getPlazasTotales() {
        return plazasTotales;
    }

    public void setPlazasTotales(Integer plazasTotales) {
        this.plazasTotales = plazasTotales;
    }

    public Integer getPlazasClaseTuristaDisponible() {
        return plazasClaseTuristaDisponible;
    }

    public void setPlazasClaseTuristaDisponible(Integer plazasClaseTuristaDisponible) {
        this.plazasClaseTuristaDisponible = plazasClaseTuristaDisponible;
    }
}
