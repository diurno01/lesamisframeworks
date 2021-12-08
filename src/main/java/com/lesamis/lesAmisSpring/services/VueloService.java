package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.SucursalModel;
import com.lesamis.lesAmisSpring.models.VueloModel;
import com.lesamis.lesAmisSpring.repositories.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VueloService {
    @Autowired
    VueloRepository vueloRepository;

    public List<VueloModel> obtenerVuelos(){
        return vueloRepository.findAll();
    }
    public Optional<VueloModel> obtenerVueloPorId(Long id){
        return vueloRepository.findById(id);
    }

    public Optional<VueloModel> findByNumeroDeVuelo(Long numeroDeVuelo){
        return vueloRepository.findByNumeroDeVuelo(numeroDeVuelo);
    }

    public void agregarVuelo(VueloModel vuelo){
        vueloRepository.save(vuelo);
    }

    public void delete(Long id){
        vueloRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return vueloRepository.existsById(id);
    }

    public boolean existsByNumeroDeVuelo(Long numeroDevuelo){
        return vueloRepository.existsByNumeroDeVuelo(numeroDevuelo);
    }
//    public ArrayList<VueloModel> obtenerVuelos(){
//        return (ArrayList<VueloModel>) vueloRepository.findAll();
//    }
//
//    public VueloModel agregarVuelo(VueloModel vuelo){
//        return vueloRepository.save(vuelo);
//    }
//
//    public Optional<VueloModel> obtenerVueloPorId(Long id){
//        return vueloRepository.findById(id);
//    }
//
//    public boolean eliminarVuelo(Long id) {
//        try{
//            vueloRepository.deleteById(id);
//            return true;
//        }catch(Exception err){
//            return false;
//        }
//    }
}
