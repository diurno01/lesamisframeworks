package com.lesamis.lesAmisSpring.controllers;

import com.lesamis.lesAmisSpring.models.AgenciaModel;
import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.MensajeModel;
import com.lesamis.lesAmisSpring.models.SucursalModel;
import com.lesamis.lesAmisSpring.services.AgenciaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/agencia")
public class AgenciaController {
    @Autowired
    AgenciaService agenciaService;

    @GetMapping("/lista")
    public ResponseEntity<List<AgenciaModel>> obtenerAgencias(){
        List<AgenciaModel> list = agenciaService.obtenerAgencias();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<AgenciaModel> obtenerHotelPorId(@PathVariable("id") Long id){
        if(!agenciaService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        AgenciaModel agencia = agenciaService.obtenesAgenciaPorId(id).get();
        return new ResponseEntity(agencia, HttpStatus.OK);
    }

    @GetMapping("/detalle/{nombre}")
    public ResponseEntity<AgenciaModel> obtenerPorNombre(@PathVariable("nombre") String nombre){
        if(!agenciaService.existsByNombre(nombre))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        AgenciaModel agencia = agenciaService.obtenerPorNombre(nombre).get();
        return new ResponseEntity(agencia, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<AgenciaModel> create(@RequestBody AgenciaModel agencia){
        if(StringUtils.isBlank(agencia.getNombre()))
            return new ResponseEntity(new MensajeModel("Olvido competar el nombre de la agencia"), HttpStatus.BAD_REQUEST);

        AgenciaModel agenciaModel = new AgenciaModel(agencia.getNombre());
        agenciaService.agregarAgencia(agenciaModel);
        return new ResponseEntity(new MensajeModel("La agencia se ha sido registrado exitosamente") , HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<AgenciaModel> update(@PathVariable("id")Long id, @RequestBody AgenciaModel agencia){
        if(!agenciaService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(agencia.getNombre()))
            return new ResponseEntity(new MensajeModel("Olvido competar el nombre de la agencia"), HttpStatus.BAD_REQUEST);

        AgenciaModel agenciaModel = agenciaService.obtenesAgenciaPorId(id).get();
        agenciaModel.setNombre(agencia.getNombre());


        agenciaService.agregarAgencia(agenciaModel);
        return new ResponseEntity(new MensajeModel("Agencia actualizada exitosamente"), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AgenciaModel> delete(@PathVariable("id")Long id){
        if(!agenciaService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        agenciaService.delete(id);
        return new ResponseEntity(new MensajeModel("Hotel eliminado"), HttpStatus.OK);
    }

//    @GetMapping()
//    public List<AgenciaModel> obtenerAgencias(){
//        return agenciaService.obtenerAgencias();
//    }

//    @GetMapping()
//    public ArrayList<SucursalModel> obtenerSucursalesDeAgencia(Long id){
//        return agenciaService.obtenerSucursalesDeAgencia(id);
//    }
}
