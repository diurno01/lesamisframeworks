package com.lesamis.lesAmisSpring.models;

import javax.persistence.*;

@Entity
@Table(name = "sucursales")
public class SucursalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String codigo;
    private String direccion;
    private String telefono;
    @OneToOne
    private AgenciaModel agencia;

    public SucursalModel(){};

    public SucursalModel(String codigo, String direccion, String telefono, AgenciaModel agencia) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.agencia = agencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public AgenciaModel getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaModel agencia) {
        this.agencia = agencia;
    }
}
