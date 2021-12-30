package com.lesamis.lesAmisSpring.controllers;

import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.MensajeModel;
import com.lesamis.lesAmisSpring.models.SucursalModel;
import com.lesamis.lesAmisSpring.models.VueloModel;
import com.lesamis.lesAmisSpring.services.SucursalService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    SucursalService sucursalService;

    @GetMapping("/lista")
    public ResponseEntity<List<SucursalModel>> obtenerSucursales(){
        List<SucursalModel> list = sucursalService.obtenerSucursales();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<SucursalModel> obtenerSucursalPorId(@PathVariable("id") Long id){
        if(!sucursalService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        SucursalModel sucursal = sucursalService.obtenerSucursalPorId(id).get();
        return new ResponseEntity(sucursal, HttpStatus.OK);
    }
    @GetMapping("/detalle/agencia/{id}")
    public ResponseEntity<SucursalModel> obtenerSucursalesPorAgencia(@PathVariable("idAgencia") Long idAgencia){
        if(!sucursalService.existsByIdAgencia(idAgencia))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        SucursalModel sucursal = sucursalService.obtenerSucursalesPorId(idAgencia).get();
        return new ResponseEntity(sucursal, HttpStatus.OK);
    }

//    @GetMapping("/detalle/{nombre}")
//    public ResponseEntity<SucursalModel> obtenerPorCodigo(@PathVariable("nombre") Long numeroDeVuelo){
//        if(!sucursalService.existsByNumeroDeVuelo(numeroDeVuelo))
//            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
//        VueloModel vuelo = sucursalService.obtenerVueloPorId(numeroDeVuelo).get();
//        return new ResponseEntity(vuelo, HttpStatus.OK);
//    }

    @PostMapping("/crear")
    public ResponseEntity<SucursalModel> create(@RequestBody SucursalModel sucursal){
        if(StringUtils.isBlank(sucursal.getCodigo()))
            return new ResponseEntity(new MensajeModel("Olvido competar el codigo de sucursal"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(sucursal.getDireccion()))
            return new ResponseEntity(new MensajeModel("Olvido competar la direccion de la sucursal"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(sucursal.getTelefono()))
            return new ResponseEntity(new MensajeModel("Olvido competar el telefono de la sucursal"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(sucursal.getAgencia().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar la agencia de la sucursal"), HttpStatus.BAD_REQUEST);

        SucursalModel sucursalModel = new SucursalModel(sucursal.getCodigo(),
                sucursal.getDireccion(),
                sucursal.getTelefono(),
                sucursal.getAgencia());
        sucursalService.agregarSucursal(sucursalModel);
        return new ResponseEntity(new MensajeModel("La sucursal ha sido registrado exitosamente") , HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<SucursalModel> update(@PathVariable("id")Long id, @RequestBody SucursalModel sucursal){
        if(!sucursalService.existsById(id))
            return new ResponseEntity(new MensajeModel("La sucursal no existe"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(sucursal.getCodigo()))
            return new ResponseEntity(new MensajeModel("Olvido competar el codigo de sucursal"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(sucursal.getDireccion()))
            return new ResponseEntity(new MensajeModel("Olvido competar la direccion de la sucursal"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(sucursal.getTelefono()))
            return new ResponseEntity(new MensajeModel("Olvido competar el telefono de la sucursal"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(sucursal.getAgencia().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar la agencia de la sucursal"), HttpStatus.BAD_REQUEST);

        SucursalModel sucursalModel = sucursalService.obtenerSucursalPorId(id).get();
        sucursalModel.setCodigo(sucursal.getCodigo());
        sucursalModel.setDireccion(sucursal.getDireccion());
        sucursalModel.setTelefono(sucursal.getTelefono());
        sucursalModel.setAgencia(sucursal.getAgencia());

        sucursalService.agregarSucursal(sucursalModel);
        return new ResponseEntity(new MensajeModel("Sucursal actualizada exitosamente"), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SucursalModel> delete(@PathVariable("id")Long id){
        if(!sucursalService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        sucursalService.delete(id);
        return new ResponseEntity(new MensajeModel("Vuelo eliminado"), HttpStatus.OK);
    }


//    @GetMapping()
//    public ArrayList<SucursalModel> obtenerSucursales(){
//        return sucursalService.obtenerSucursales();
//    }
//
//    @PostMapping()
//    public SucursalModel guardarSucursal(@RequestBody SucursalModel sucursal){
//        return this.sucursalService.agregarSucursal(sucursal);
//    }
//
//    @GetMapping( path = "/{id}")
//    public Optional<SucursalModel> obtenerSucursalPorId(@PathVariable("id") Long id) {
//        return this.sucursalService.obtenerSucursalPorId(id);
//    }
//
//    @DeleteMapping( path = "/{id}")
//    public String eliminarSucursalPorId(@PathVariable("id") Long id){
//        boolean ok = this.sucursalService.eliminarSucursal(id);
//        if (ok){
//            return "Se eliminó el sucursal con id " + id;
//        }else{
//            return "No pudo eliminar el sucursal con id" + id;
//        }
//    }
}
