package com.lesamis.lesAmisSpring.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "vuelos")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class VueloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Long numeroDeVuelo;
//    @Temporal(TemporalType.DATE)
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//     @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
//     @JsonSerialize(using = DateSerializer.class)
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaYHora;
    private String origen;
    private String destino;
    private Integer plazasPrimeraClase;
    private Integer plazasClaseTurista;
    private Float precioPrimeraClase;
    private Float precioClaseturista;

    public VueloModel(){};

    public VueloModel(Long numeroDeVuelo, LocalDate fechaYHora, String origen, String destino, Integer plazasPrimeraClase, Integer plazasClaseTurista, Float precioPrimeraClase, Float precioClaseturista) {
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

    public LocalDate getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDate fechaYHora) {
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
