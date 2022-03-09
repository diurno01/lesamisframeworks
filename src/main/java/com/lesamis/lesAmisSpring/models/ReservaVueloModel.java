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
    private Long idVuelo;
    private String clase;
    private Long idSucursal;

    public ReservaVueloModel(){};

    public ReservaVueloModel(Long idUsuario, Long idVuelo, String clase, Long idSucursal) {
        this.idUsuario = idUsuario;
        this.idVuelo = idVuelo;
        this.clase = clase;
        this.idSucursal = idSucursal;
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

    public Long getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Long idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }
}
