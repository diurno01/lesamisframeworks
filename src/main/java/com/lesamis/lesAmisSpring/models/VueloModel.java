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
    private int plazasPrimeraClase;
    private int plazasClaseTurista;
    private int precioPrimeraClase;
    private int precioClaseturista;

    public VueloModel(){};

    public VueloModel(Long numeroDeVuelo, Date fechaYHora, String origen, String destino, int plazasPrimeraClase, int plazasClaseTurista, int precioPrimeraClase, int precioClaseturista) {
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

    public int getPlazasPrimeraClase() {
        return plazasPrimeraClase;
    }

    public void setPlazasPrimeraClase(int plazasPrimeraClase) {
        this.plazasPrimeraClase = plazasPrimeraClase;
    }

    public int getPlazasClaseTurista() {
        return plazasClaseTurista;
    }

    public void setPlazasClaseTurista(int plazasClaseTurista) {
        this.plazasClaseTurista = plazasClaseTurista;
    }

    public int getPrecioPrimeraClase() {
        return precioPrimeraClase;
    }

    public void setPrecioPrimeraClase(int precioPrimeraClase) {
        this.precioPrimeraClase = precioPrimeraClase;
    }

    public int getPrecioClaseturista() {
        return precioClaseturista;
    }

    public void setPrecioClaseturista(int precioClaseturista) {
        this.precioClaseturista = precioClaseturista;
    }
}
