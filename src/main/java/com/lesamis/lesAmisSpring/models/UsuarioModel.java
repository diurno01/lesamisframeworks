package com.lesamis.lesAmisSpring.models;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lesamis.lesAmisSpring.models.ReservaVueloModel;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String usuario;
    private String password;
    private Long dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private String sucursal;
    private String tipo;

    public UsuarioModel(){}

    public UsuarioModel(String usuario, String password, Long dni, String nombre, String apellido, String direccion, String telefono, String email, String sucursal, String tipo) {
        this.usuario = usuario;
        this.password = password;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.sucursal = sucursal;
        this.tipo = tipo;
    }

    //----------------------------reservas------------------------------------

//    public void agregarReservaVuelo(ReservaVueloModel reservaVueloModel){
//        if(this.reservasVuelo == null) this.reservasVuelo = new ArrayList<>();
//        this.reservasVuelo.add(reservaVueloModel);
//        reservaVueloModel.setUsuario(this);
//    }

//    public void agregarReservaHotel(ReservaHotelModel reservaHotelModel){
//        if(this.reservasHotel == null) this.reservasHotel = new ArrayList<>();
//        this.reservasHotel.add(reservaHotelModel);
//        reservaHotelModel.setUsuario(this);
//    }

//    public void eliminarReservaVuelo(ReservaVueloModel reservaVueloModel){
//        this.reservasVuelo.remove(reservaVueloModel);
//    }
//
//    public void eliminarReservaHotel(ReservaHotelModel reservaHotelModel){
//        this.reservasHotel.remove(reservaHotelModel);
//    }


//    public List<ReservaVueloModel> getReservasVuelo() {
//        return reservasVuelo;
//    }
//
//    public void setReservasVuelo(List<ReservaVueloModel> reservasVuelo) {
//        this.reservasVuelo = reservasVuelo;
//    }

//    public List<ReservaHotelModel> getReservasHotel() {
//        return reservasHotel;
//    }
//
//    public void setReservasHotel(List<ReservaHotelModel> reservasHotel) {
//        this.reservasHotel = reservasHotel;
//    }

//---------------------------------------------------------------------------


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
