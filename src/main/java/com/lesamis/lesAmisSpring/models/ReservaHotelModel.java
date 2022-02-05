package com.lesamis.lesAmisSpring.models;


import javax.persistence.*;

@Entity
@Table(name = "ReservasHotel")
public class ReservaHotelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;


    private Long idUsuario;

    @OneToOne
    private HotelModel hotel;
    private Pension pension;

    @OneToOne
    private SucursalModel sucursal;

    public ReservaHotelModel(){};

    public ReservaHotelModel(Long idUsuario, HotelModel hotel, Pension pension, SucursalModel sucursal) {
        this.idUsuario = idUsuario;
        this.hotel = hotel;
        this.pension = pension;
        this.sucursal = sucursal;
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

    public HotelModel getHotel() {
        return hotel;
    }

    public void setHotel(HotelModel hotel) {
        this.hotel = hotel;
    }

    public Pension getPension() {
        return pension;
    }

    public void setPension(Pension pension) {
        this.pension = pension;
    }

    public SucursalModel getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalModel sucursal) {
        this.sucursal = sucursal;
    }
}
