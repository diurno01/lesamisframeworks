package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.ReservaHotelModel;
import com.lesamis.lesAmisSpring.repositories.ReservaHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaHotelService {

    @Autowired
    ReservaHotelRepository reservaHotelRepository;

    public List<ReservaHotelModel> obtenerReservasHotel(){
        return reservaHotelRepository.findAll();
    }

    public Optional<ReservaHotelModel> obtenerReservaHotelPorId(Long id){
        return reservaHotelRepository.findById(id);
    }

    public Optional<ReservaHotelModel> obtenerReservasHotelPorUsuario(Long id){
        return reservaHotelRepository.findByUsuario_Id(id);
    }

    public void agregarReservaHotel(ReservaHotelModel reserva){
        reservaHotelRepository.save(reserva);
    }

    public void delete(Long id){
        reservaHotelRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return reservaHotelRepository.existsById(id);
    }
}
