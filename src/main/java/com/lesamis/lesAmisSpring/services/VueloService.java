package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.SucursalModel;
import com.lesamis.lesAmisSpring.models.VueloModel;
import com.lesamis.lesAmisSpring.repositories.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VueloService {
    @Autowired
    VueloRepository vueloRepository;

    public ArrayList<VueloModel> obtenerVuelos(){
        return (ArrayList<VueloModel>) vueloRepository.findAll();
    }

    public VueloModel agregarVuelo(VueloModel vuelo){
        return vueloRepository.save(vuelo);
    }

    public Optional<VueloModel> obtenerVueloPorId(Long id){
        return vueloRepository.findById(id);
    }

    public boolean eliminarVuelo(Long id) {
        try{
            vueloRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
