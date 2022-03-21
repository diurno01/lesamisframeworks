package com.lesamis.lesAmisSpring.models.Requests;

public class HotelRequest {
    private Long id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String telefono;
    private Integer numeroDePlazasDisponibles;

    public HotelRequest() {
    }

    public HotelRequest(Long id, String nombre, String direccion, String ciudad, String telefono, Integer numeroDePlazasDisponibles) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.numeroDePlazasDisponibles = numeroDePlazasDisponibles;
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

    public Integer getNumeroDePlazasDisponibles() {
        return numeroDePlazasDisponibles;
    }

    public void setNumeroDePlazasDisponibles(Integer numeroDePlazasDisponibles) {
        this.numeroDePlazasDisponibles = numeroDePlazasDisponibles;
    }
}
