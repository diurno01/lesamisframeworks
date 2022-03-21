package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.*;
import com.lesamis.lesAmisSpring.models.Requests.ReservaHotelRequest;
import com.lesamis.lesAmisSpring.repositories.HotelRepository;
import com.lesamis.lesAmisSpring.repositories.ReservaHotelRepository;
import com.lesamis.lesAmisSpring.repositories.SucursalRepository;
import com.lesamis.lesAmisSpring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaHotelService {

    @Autowired
    ReservaHotelRepository reservaHotelRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    SucursalRepository sucursalRepository;


    public List<ReservaHotelModel> obtenerReservasHotel(){
        return reservaHotelRepository.findAll();
    }

//    public Optional<ReservaHotelModel> obtenerReservaHotelPorId(Long id){
//        return reservaHotelRepository.findById(id);
//    }

    public List<ReservaHotelModel> obtenerReservasHotelPorUsuario(Long id){
        return reservaHotelRepository.findByUsuario_Id(id);
    }

    public void agregarReservaHotel(ReservaHotelRequest reserva){
        UsuarioModel usuario = usuarioRepository.findById(reserva.getIdUsuario()).get();
        HotelModel hotel = hotelRepository.findById(reserva.getIdHotel()).get();
        SucursalModel sucursal = sucursalRepository.findById(reserva.getIdSucursal()).get();

        reservaHotelRepository.save(new ReservaHotelModel(
                usuario,
                hotel,
                reserva.getPension(),
                sucursal,
                reserva.getFechaDeIngreso(),
                reserva.getFechaDeEgreso()));
    }

    public void delete(Long id){
        reservaHotelRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return reservaHotelRepository.existsById(id);
    }

    public int obtenerReservasHotePorHotel(Long id){
        List<ReservaHotelModel>  list = reservaHotelRepository.findByHotel_Id(id);
        return list.size();
    }

    public boolean existsByHotel_Id(Long id){
        return reservaHotelRepository.existsByHotel_Id(id);
    }
    public boolean existsByUsuario_Id(Long id){
        return reservaHotelRepository.existsByUsuario_Id(id);
    }


}
