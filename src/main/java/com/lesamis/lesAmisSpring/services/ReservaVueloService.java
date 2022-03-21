package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.Requests.ReservaVueloRequest;
import com.lesamis.lesAmisSpring.models.ReservaVueloModel;
import com.lesamis.lesAmisSpring.models.SucursalModel;
import com.lesamis.lesAmisSpring.models.UsuarioModel;
import com.lesamis.lesAmisSpring.models.VueloModel;
import com.lesamis.lesAmisSpring.repositories.ReservaVueloRepository;
import com.lesamis.lesAmisSpring.repositories.SucursalRepository;
import com.lesamis.lesAmisSpring.repositories.UsuarioRepository;
import com.lesamis.lesAmisSpring.repositories.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaVueloService {

    @Autowired
    ReservaVueloRepository reservaVueloRepository;

    @Autowired
    VueloRepository vueloRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    SucursalRepository sucursalRepository;

    public List<ReservaVueloModel> obtenerReservasVuelo(){
        return reservaVueloRepository.findAll();
    }

    public Optional<ReservaVueloModel> obtenerReservaVueloPorId(Long id){
        return reservaVueloRepository.findById(id);
    }


    public List<ReservaVueloModel> obtenerReservasVueloPorUsuario(Long id){
        return reservaVueloRepository.findByUsuario_Id(id);
    }

    public int obtenerReservasVueloTurista(Long id){
                List<ReservaVueloModel>  list = reservaVueloRepository.findByVuelo_IdAndClase(id,"CLASE_TURISTA");
        return list.size();
    }

    public void agregarReservaVuelo(ReservaVueloRequest reserva){
        VueloModel vuelo = vueloRepository.findById(reserva.getIdVuelo()).get();
        UsuarioModel usuario = usuarioRepository.findById(reserva.getIdUsuario()).get();
        SucursalModel sucursal = sucursalRepository.findById(reserva.getIdSucursal()).get();

        reservaVueloRepository.save(new ReservaVueloModel(reserva.getClase(),usuario,vuelo,sucursal));
    }



    public void delete(Long id){
        reservaVueloRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return reservaVueloRepository.existsById(id);
    }

    public boolean existsByVuelo_Id(Long id){
        return reservaVueloRepository.existsByVuelo_Id(id);
    }

    public boolean existsByVuelo_NumeroDeVuelo(Long numeroDeVuelo){
        return reservaVueloRepository.existsByVuelo_NumeroDeVuelo(numeroDeVuelo);
    }
    public boolean existsByIdUsuario(Long id){
        return reservaVueloRepository.existsByUsuario_Id(id);
    }
}

