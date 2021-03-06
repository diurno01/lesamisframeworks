package com.lesamis.lesAmisSpring.models;

import javax.persistence.*;

@Entity
@Table(name = "ReservasVuelos")
public class ReservaVuelaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @OneToOne
    private UsuarioModel usuario;

    @OneToOne
    private VueloModel vuelo;
    private ClaseVuelo clase;

    @OneToOne
    private SucursalModel sucursalModel;

    public ReservaVuelaModel(){};

    public ReservaVuelaModel(UsuarioModel usuario, VueloModel vuelo, ClaseVuelo clase, SucursalModel sucursalModel) {
        this.usuario = usuario;
        this.vuelo = vuelo;
        this.clase = clase;
        this.sucursalModel = sucursalModel;
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

    public VueloModel getVuelo() {
        return vuelo;
    }

    public void setVuelo(VueloModel vuelo) {
        this.vuelo = vuelo;
    }

    public ClaseVuelo getClase() {
        return clase;
    }

    public void setClase(ClaseVuelo clase) {
        this.clase = clase;
    }

    public SucursalModel getSucursalModel() {
        return sucursalModel;
    }

    public void setSucursalModel(SucursalModel sucursalModel) {
        this.sucursalModel = sucursalModel;
    }
}
