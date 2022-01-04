package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.ReservaHotelModel;
import com.lesamis.lesAmisSpring.models.ReservaVueloModel;
import com.lesamis.lesAmisSpring.repositories.ReservaVueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaVueloService {

    @Autowired
    ReservaVueloRepository reservaVueloRepository;

    public List<ReservaVueloModel> obtenerReservasVuelo(){
        return reservaVueloRepository.findAll();
    }

    public Optional<ReservaVueloModel> obtenerReservaVueloPorId(Long id){
        return reservaVueloRepository.findById(id);
    }


    public Optional<ReservaVueloModel> obtenerReservasVueloPorUsuario(Long id){
        return reservaVueloRepository.findByUsuario_Id(id);
    }

    public void agregarReservaVuelo(ReservaVueloModel reserva){
        reservaVueloRepository.save(reserva);
    }

    public void delete(Long id){
        reservaVueloRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return reservaVueloRepository.existsById(id);
    }
}

