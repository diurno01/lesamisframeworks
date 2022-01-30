package com.lesamis.lesAmisSpring.controllers;

import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.MensajeModel;
import com.lesamis.lesAmisSpring.models.ReservaHotelModel;
import com.lesamis.lesAmisSpring.services.ReservaHotelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/reservasHotel")
public class ReservaHotelController {
    @Autowired
    ReservaHotelService reservaHotelService;

    @GetMapping("/lista")
    public ResponseEntity<List<ReservaHotelModel>> obtenerReservasHotel(){
        List<ReservaHotelModel> list = reservaHotelService.obtenerReservasHotel();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Optional<ReservaHotelModel>> obtenerReservasHotelPorIdUsuario(@PathVariable("id") Long id){
        if(!reservaHotelService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        Optional<ReservaHotelModel> reserva = reservaHotelService.obtenerReservasHotelPorUsuario(id);
        return new ResponseEntity(reserva, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ReservaHotelModel> create(@RequestBody ReservaHotelModel reserva){
        if(StringUtils.isBlank(reserva.getIdUsuario().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar el usuario de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getHotel().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar Hotel de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getPension().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar la pension de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getSucursal().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar la sucursal de la reserva"), HttpStatus.BAD_REQUEST);

        ReservaHotelModel reservaHotelModel = new ReservaHotelModel(reserva.getIdUsuario(),
                reserva.getHotel(),
                reserva.getPension(),
                reserva.getSucursal());
        reservaHotelService.agregarReservaHotel(reservaHotelModel);
        return new ResponseEntity(new MensajeModel("La reserva del hotel ha sido registrada exitosamente") , HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ReservaHotelModel> update(@PathVariable("id")Long id, @RequestBody ReservaHotelModel reserva){
        if(!reservaHotelService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(reserva.getIdUsuario().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar el usuario de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getHotel().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar Hotel de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getPension().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar la pension de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getSucursal().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar la sucursal de la reserva"), HttpStatus.BAD_REQUEST);

        ReservaHotelModel reservaHotelModel = reservaHotelService.obtenerReservaHotelPorId(id).get();
        reservaHotelModel.setIdUsuario(reserva.getIdUsuario());
        reservaHotelModel.setHotel(reserva.getHotel());
        reservaHotelModel.setPension(reserva.getPension());
        reservaHotelModel.setSucursal(reserva.getSucursal());

        reservaHotelService.agregarReservaHotel(reservaHotelModel);
        return new ResponseEntity(new MensajeModel("La reserva ha sido actualizada exitosamente"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ReservaHotelModel> delete(@PathVariable("id")Long id){
        if(!reservaHotelService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        reservaHotelService.delete(id);
        return new ResponseEntity(new MensajeModel("Reserva eliminada"), HttpStatus.OK);
    }
}
