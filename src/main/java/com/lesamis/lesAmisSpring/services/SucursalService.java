package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.SucursalModel;
import com.lesamis.lesAmisSpring.models.VueloModel;
import com.lesamis.lesAmisSpring.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    SucursalRepository sucursalRepository;

    public List<SucursalModel> obtenerSucursales(){
        return sucursalRepository.findAll();
    }

    public Optional<SucursalModel> obtenerSucursalesPorId(Long id){
        return sucursalRepository.findByAgencia_Id(id);
    }

    public Optional<SucursalModel> obtenerSucursalPorId(Long id){
        return sucursalRepository.findById(id);
    }

    public Optional<SucursalModel> findByIdAgencia(Long idAgencia){
        return sucursalRepository.findByAgencia_Id(idAgencia);
    }

    public void agregarSucursal(SucursalModel sucursal){
        sucursalRepository.save(sucursal);
    }

    public void delete(Long id){
        sucursalRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return sucursalRepository.existsById(id);
    }

    public boolean existsByIdAgencia(Long id){
        return sucursalRepository.existsByAgencia_Id(id);
    }

//    public ArrayList<SucursalModel> obtenerSucursales(){
//        return (ArrayList<SucursalModel>) sucursalRepository.findAll();
//    }
//
//    public SucursalModel agregarSucursal(SucursalModel sucursal){
//        return sucursalRepository.save(sucursal);
//    }
//
//    public Optional<SucursalModel> obtenerSucursalPorId(Long id){
//        return sucursalRepository.findById(id);
//    }
//
//    public boolean eliminarSucursal(Long id) {
//        try{
//            sucursalRepository.deleteById(id);
//            return true;
//        }catch(Exception err){
//            return false;
//        }
//    }
}
