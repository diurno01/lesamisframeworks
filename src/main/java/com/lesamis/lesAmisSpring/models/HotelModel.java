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
    private int numeroDePlazas;
    private int precioPensionCompleta;
    private int precioMediaPension;

    public HotelModel(){};

    public HotelModel(String nombre, String direccion, String ciudad, String telefono, int numeroDePlazas, int precioPensionCompleta, int precioMediaPension) {
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

    public int getNumeroDePlazas() {
        return numeroDePlazas;
    }

    public void setNumeroDePlazas(int numeroDePlazas) {
        this.numeroDePlazas = numeroDePlazas;
    }

    public int getPrecioPensionCompleta() {
        return precioPensionCompleta;
    }

    public void setPrecioPensionCompleta(int precioPensionCompleta) {
        this.precioPensionCompleta = precioPensionCompleta;
    }

    public int getPrecioMediaPension() {
        return precioMediaPension;
    }

    public void setPrecioMediaPension(int precioMediaPension) {
        this.precioMediaPension = precioMediaPension;
    }
}
