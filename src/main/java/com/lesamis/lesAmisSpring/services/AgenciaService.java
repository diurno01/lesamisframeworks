package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.AgenciaModel;
import com.lesamis.lesAmisSpring.models.SucursalModel;
import com.lesamis.lesAmisSpring.models.UsuarioModel;
import com.lesamis.lesAmisSpring.repositories.AgenciaRepository;
import com.lesamis.lesAmisSpring.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgenciaService {

    @Autowired
    AgenciaRepository agenciaRepository;

    public List<AgenciaModel> obtenerAgencias(){
        return agenciaRepository.findAll();
    }

    public Optional<AgenciaModel> obtenesAgenciaPorId(Long id){
        return agenciaRepository.findById(id);
    }

    public Optional<AgenciaModel> obtenerPorNombre(String nombre){
        return agenciaRepository.findByNombre(nombre);
    }


    public void agregarAgencia(AgenciaModel agencia){
        agenciaRepository.save(agencia);
    }

    public void delete(Long id){
        agenciaRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return agenciaRepository.existsById(id);
    }

    public  boolean existsByNombre(String nombre){
        return  agenciaRepository.existsByNombre(nombre);
    }
//    public ArrayList<AgenciaModel> obtenerAgencias(){
//        return (ArrayList<AgenciaModel>) agenciaRepository.findAll();
//    }
//
//    public Optional<AgenciaModel> obtenerAgenciaPorId(Long id) {
//        return agenciaRepository.findById(id);
//    }
//
//    public ArrayList<SucursalModel> obtenerSucursalesDeAgencia(Long id){
//        return sucursalRepository.findByIdAgencia(id);
//    }

}

