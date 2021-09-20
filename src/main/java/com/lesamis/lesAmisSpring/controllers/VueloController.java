package com.lesamis.lesAmisSpring.controllers;


import com.lesamis.lesAmisSpring.models.SucursalModel;
import com.lesamis.lesAmisSpring.models.VueloModel;
import com.lesamis.lesAmisSpring.services.SucursalService;
import com.lesamis.lesAmisSpring.services.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/vuelo")
public class VueloController {
    @Autowired
    VueloService vueloService;

    @GetMapping()
    public ArrayList<VueloModel> obtenerVuelos(){
        return vueloService.obtenerVuelos();
    }

    @PostMapping()
    public VueloModel guardarVuelo(@RequestBody VueloModel vuelo){
        return this.vueloService.agregarVuelo(vuelo);
    }

    @GetMapping( path = "/{id}")
    public Optional<VueloModel> obtenerVueloPorId(@PathVariable("id") Long id) {
        return this.vueloService.obtenerVueloPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarVueloPorId(@PathVariable("id") Long id){
        boolean ok = this.vueloService.eliminarVuelo(id);
        if (ok){
            return "Se eliminó el vuelo con id " + id;
        }else{
            return "No pudo eliminar el vuelo con id" + id;
        }
    }

}
