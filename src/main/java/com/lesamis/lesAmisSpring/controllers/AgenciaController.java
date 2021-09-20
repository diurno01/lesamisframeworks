package com.lesamis.lesAmisSpring.controllers;

import com.lesamis.lesAmisSpring.models.AgenciaModel;
import com.lesamis.lesAmisSpring.models.SucursalModel;
import com.lesamis.lesAmisSpring.services.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/agencia")
public class AgenciaController {
    @Autowired
    AgenciaService agenciaService;

    @GetMapping()
    public ArrayList<AgenciaModel> obtenerAgencias(){
        return agenciaService.obtenerAgencias();
    }

    @GetMapping()
    public ArrayList<SucursalModel> obtenerSucursalesDeAgencia(Long id){
        return agenciaService.obtenerSucursalesDeAgencia(id);
    }
}
