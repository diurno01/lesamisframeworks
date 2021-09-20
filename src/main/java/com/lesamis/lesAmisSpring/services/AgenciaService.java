package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.AgenciaModel;
import com.lesamis.lesAmisSpring.models.SucursalModel;
import com.lesamis.lesAmisSpring.models.UsuarioModel;
import com.lesamis.lesAmisSpring.repositories.AgenciaRepository;
import com.lesamis.lesAmisSpring.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AgenciaService {

    @Autowired
    AgenciaRepository agenciaRepository;

    @Autowired
    SucursalRepository sucursalRepository;

    public ArrayList<AgenciaModel> obtenerAgencias(){
        return (ArrayList<AgenciaModel>) agenciaRepository.findAll();
    }

    public Optional<AgenciaModel> obtenerAgenciaPorId(Long id) {
        return agenciaRepository.findById(id);
    }

    public ArrayList<SucursalModel> obtenerSucursalesDeAgencia(Long id){
        return sucursalRepository.findByIdAgencia(id);
    }

}

