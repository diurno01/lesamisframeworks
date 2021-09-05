package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.SucursalModel;
import com.lesamis.lesAmisSpring.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    SucursalRepository sucursalRepository;

    public ArrayList<SucursalModel> obtenerSucursales(){
        return (ArrayList<SucursalModel>) sucursalRepository.findAll();
    }

    public SucursalModel agregarSucursal(SucursalModel sucursal){
        return sucursalRepository.save(sucursal);
    }

    public Optional<SucursalModel> obtenerSucursalPorId(Long id){
        return sucursalRepository.findById(id);
    }

    public boolean eliminarSucursal(Long id) {
        try{
            sucursalRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
