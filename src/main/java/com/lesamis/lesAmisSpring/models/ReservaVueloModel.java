package com.lesamis.lesAmisSpring.models;



import javax.persistence.*;

@Entity
@Table(name = "ReservasVuelos")
public class ReservaVueloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Long idUsuario;

    @OneToOne
    private VueloModel vuelo;
    private ClaseVuelo clase;

    @OneToOne
    private SucursalModel sucursalModel;

    public ReservaVueloModel(){};

    public ReservaVueloModel(Long idUsuario, VueloModel vuelo, ClaseVuelo clase, SucursalModel sucursalModel) {
        this.idUsuario = idUsuario;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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
