package com.lesamis.lesAmisSpring.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vuelos")

public class VueloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Long numeroDeVuelo;

    private LocalDateTime fechaYHora;
    private String origen;
    private String destino;
    private Integer plazasPrimeraClase;
    private Integer plazasClaseTurista;


    public VueloModel(){};

    public VueloModel(Long numeroDeVuelo, LocalDateTime fechaYHora, String origen, String destino, Integer plazasPrimeraClase, Integer plazasClaseTurista) {
        this.numeroDeVuelo = numeroDeVuelo;
        this.fechaYHora = fechaYHora;
        this.origen = origen;
        this.destino = destino;
        this.plazasPrimeraClase = plazasPrimeraClase;
        this.plazasClaseTurista = plazasClaseTurista;
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

    public Integer getPlazasPrimeraClase() {
        return plazasPrimeraClase;
    }

    public void setPlazasPrimeraClase(Integer plazasPrimeraClase) {
        this.plazasPrimeraClase = plazasPrimeraClase;
    }

    public Integer getPlazasClaseTurista() {
        return plazasClaseTurista;
    }

    public void setPlazasClaseTurista(Integer plazasClaseTurista) {
        this.plazasClaseTurista = plazasClaseTurista;
    }

}
