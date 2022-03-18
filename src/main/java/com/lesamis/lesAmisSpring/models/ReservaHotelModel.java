package com.lesamis.lesAmisSpring.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ReservasHotel")
public class ReservaHotelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    private UsuarioModel usuario;

    @ManyToOne
    private HotelModel hotel;

    private String pension;

    @ManyToOne
    private SucursalModel sucursal;

    private LocalDate fechaDeIngreso;
    private LocalDate fechaDeEgreso;

    public ReservaHotelModel(){};

    public ReservaHotelModel(UsuarioModel usuario, HotelModel hotel, String pension, SucursalModel sucursal, LocalDate fechaDeIngreso, LocalDate fechaDeEgreso) {
        this.usuario = usuario;
        this.hotel = hotel;
        this.pension = pension;
        this.sucursal = sucursal;
        this.fechaDeIngreso = fechaDeIngreso;
        this.fechaDeEgreso = fechaDeEgreso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public HotelModel getHotel() {
        return hotel;
    }

    public void setHotel(HotelModel hotel) {
        this.hotel = hotel;
    }

    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
    }

    public SucursalModel getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalModel sucursal) {
        this.sucursal = sucursal;
    }

    public LocalDate getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public LocalDate getFechaDeEgreso() {
        return fechaDeEgreso;
    }

    public void setFechaDeEgreso(LocalDate fechaDeEgreso) {
        this.fechaDeEgreso = fechaDeEgreso;
    }
}
