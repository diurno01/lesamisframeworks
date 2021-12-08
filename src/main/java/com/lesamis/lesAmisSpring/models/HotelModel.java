package com.lesamis.lesAmisSpring.models;

import javax.persistence.*;

@Entity
@Table(name = "hoteles")
public class HotelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String direccion;
    private String ciudad;
    private String telefono;

    private Integer numeroDePlazas;
    private Float precioPensionCompleta;
    private Float precioMediaPension;

    public HotelModel(){};

    public HotelModel(String nombre, String direccion, String ciudad, String telefono, Integer numeroDePlazas, Float precioPensionCompleta, Float precioMediaPension) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.numeroDePlazas = numeroDePlazas;
        this.precioPensionCompleta = precioPensionCompleta;
        this.precioMediaPension = precioMediaPension;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getNumeroDePlazas() {
        return numeroDePlazas;
    }

    public void setNumeroDePlazas(Integer numeroDePlazas) {
        this.numeroDePlazas = numeroDePlazas;
    }

    public Float getPrecioPensionCompleta() {
        return precioPensionCompleta;
    }

    public void setPrecioPensionCompleta(Float precioPensionCompleta) {
        this.precioPensionCompleta = precioPensionCompleta;
    }

    public Float getPrecioMediaPension() {
        return precioMediaPension;
    }

    public void setPrecioMediaPension(Float precioMediaPension) {
        this.precioMediaPension = precioMediaPension;
    }
}
