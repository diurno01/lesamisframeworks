package com.lesamis.lesAmisSpring.controllers;

import com.lesamis.lesAmisSpring.models.MensajeModel;
import com.lesamis.lesAmisSpring.models.ReservaHotelModel;
import com.lesamis.lesAmisSpring.models.ReservaVueloModel;
import com.lesamis.lesAmisSpring.services.ReservaVueloService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservasVuelo")

public class ReservaVueloController {

    @Autowired
    ReservaVueloService reservaVueloService;

    @GetMapping("/lista")
    public ResponseEntity<List<ReservaVueloModel>> obtenerReservasHotel(){
        List<ReservaVueloModel> list = reservaVueloService.obtenerReservasVuelo();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Optional<ReservaVueloModel>> obtenerReservasVueloPorIdUsuario(@PathVariable("id") Long id){
        if(!reservaVueloService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        Optional<ReservaVueloModel> reserva = reservaVueloService.obtenerReservasVueloPorUsuario(id);
        return new ResponseEntity(reserva, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ReservaVueloModel> create(@RequestBody ReservaVueloModel reserva){
        if(StringUtils.isBlank(reserva.getUsuario().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar el usuario de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getVuelo().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar vuelo de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getClase().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar la clase de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getSucursalModel().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar la sucursal de la reserva"), HttpStatus.BAD_REQUEST);

        ReservaVueloModel reservaVueloModel = new ReservaVueloModel(reserva.getUsuario(),
                reserva.getVuelo(),
                reserva.getClase(),
                reserva.getSucursalModel());
        reservaVueloService.agregarReservaVuelo(reservaVueloModel);
        return new ResponseEntity(new MensajeModel("La reserva del hotel ha sido registrada exitosamente") , HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ReservaVueloModel> update(@PathVariable("id")Long id, @RequestBody ReservaVueloModel reserva){
        if(!reservaVueloService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(reserva.getVuelo().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar vuelo de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getClase().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar la clase de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getSucursalModel().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar la sucursal de la reserva"), HttpStatus.BAD_REQUEST);

        ReservaVueloModel reservaVueloModel = reservaVueloService.obtenerReservaVueloPorId(id).get();
        reservaVueloModel.setUsuario(reserva.getUsuario());
        reservaVueloModel.setVuelo(reserva.getVuelo());
        reservaVueloModel.setClase(reserva.getClase());
        reservaVueloModel.setSucursalModel(reserva.getSucursalModel());

        reservaVueloService.agregarReservaVuelo(reservaVueloModel);
        return new ResponseEntity(new MensajeModel("La reserva ha sido actualizada exitosamente"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ReservaVueloModel> delete(@PathVariable("id")Long id){
        if(!reservaVueloService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        reservaVueloService.delete(id);
        return new ResponseEntity(new MensajeModel("Reserva eliminada"), HttpStatus.OK);
    }

}
