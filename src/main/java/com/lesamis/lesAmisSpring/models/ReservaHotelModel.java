package com.lesamis.lesAmisSpring.models;


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


    private Long idUsuario;


    private Long idHotel;
    private String pension;
    private Long idSucursal;
    private LocalDate fechaDeIngreso;
    private LocalDate fechaDeEgreso;

    public ReservaHotelModel(){};

    public ReservaHotelModel(Long idUsuario, Long idHotel, String pension, Long idSucursal, LocalDate fechaDeIngreso, LocalDate fechaDeEgreso) {
        this.idUsuario = idUsuario;
        this.idHotel = idHotel;
        this.pension = pension;
        this.idSucursal = idSucursal;
        this.fechaDeIngreso = fechaDeIngreso;
        this.fechaDeEgreso = fechaDeEgreso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
    }

    public Long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
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
