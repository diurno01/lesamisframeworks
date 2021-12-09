package com.lesamis.lesAmisSpring.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "vuelos")
public class VueloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Long numeroDeVuelo;
    private Date fechaYHora;
    private String origen;
    private String destino;
    private Integer plazasPrimeraClase;
    private Integer plazasClaseTurista;
    private Float precioPrimeraClase;
    private Float precioClaseturista;

    public VueloModel(){};

    public VueloModel(Long numeroDeVuelo, Date fechaYHora, String origen, String destino, Integer plazasPrimeraClase, Integer plazasClaseTurista, Float precioPrimeraClase, Float precioClaseturista) {
        this.numeroDeVuelo = numeroDeVuelo;
        this.fechaYHora = fechaYHora;
        this.origen = origen;
        this.destino = destino;
        this.plazasPrimeraClase = plazasPrimeraClase;
        this.plazasClaseTurista = plazasClaseTurista;
        this.precioPrimeraClase = precioPrimeraClase;
        this.precioClaseturista = precioClaseturista;
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

    public Date getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(Date fechaYHora) {
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

    public Float getPrecioPrimeraClase() {
        return precioPrimeraClase;
    }

    public void setPrecioPrimeraClase(Float precioPrimeraClase) {
        this.precioPrimeraClase = precioPrimeraClase;
    }

    public Float getPrecioClaseturista() {
        return precioClaseturista;
    }

    public void setPrecioClaseturista(Float precioClaseturista) {
        this.precioClaseturista = precioClaseturista;
    }
}
