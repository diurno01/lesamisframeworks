package com.lesamis.lesAmisSpring.models;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "ReservasVuelos")
public class ReservaVueloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;


    private String clase;

    @ManyToOne
    private UsuarioModel usuario;

    @ManyToOne
    private VueloModel vuelo;

    @ManyToOne
    private SucursalModel sucursal;


    public ReservaVueloModel(){};

    public ReservaVueloModel(String clase, UsuarioModel usuario, VueloModel vuelo, SucursalModel sucursal) {
        this.clase = clase;
        this.usuario = usuario;
        this.vuelo = vuelo;
        this.sucursal = sucursal;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public VueloModel getVuelo() {
        return vuelo;
    }

    public void setVuelo(VueloModel vuelo) {
        this.vuelo = vuelo;
    }

    public SucursalModel getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalModel sucursal) {
        this.sucursal = sucursal;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
