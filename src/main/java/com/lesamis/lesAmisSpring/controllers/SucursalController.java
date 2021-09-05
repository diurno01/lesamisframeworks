package com.lesamis.lesAmisSpring.controllers;

import com.lesamis.lesAmisSpring.models.SucursalModel;
import com.lesamis.lesAmisSpring.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    SucursalService sucursalService;

    @GetMapping()
    public ArrayList<SucursalModel> obtenerSucursales(){
        return sucursalService.obtenerSucursales();
    }

    @PostMapping()
    public SucursalModel guardarSucursal(@RequestBody SucursalModel sucursal){
        return this.sucursalService.agregarSucursal(sucursal);
    }

    @GetMapping( path = "/{id}")
    public Optional<SucursalModel> obtenerSucursalPorId(@PathVariable("id") Long id) {
        return this.sucursalService.obtenerSucursalPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarSucursalPorId(@PathVariable("id") Long id){
        boolean ok = this.sucursalService.eliminarSucursal(id);
        if (ok){
            return "Se eliminó el sucursal con id " + id;
        }else{
            return "No pudo eliminar el sucursal con id" + id;
        }
    }
}
