package com.lesamis.lesAmisSpring.controllers;

import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.MensajeModel;
import com.lesamis.lesAmisSpring.models.Requests.ReservaHotelRequest;
import com.lesamis.lesAmisSpring.models.Requests.ReservaVueloRequest;
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
    public ResponseEntity<ReservaHotelModel> create(@RequestBody ReservaHotelRequest reserva){
        if(StringUtils.isBlank(reserva.getIdHotel().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar el usuario de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getIdHotel().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar Hotel de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getPension()))
            return new ResponseEntity(new MensajeModel("Olvido competar la pension de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getIdSucursal().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar la sucursal de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getFechaDeIngreso().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar la fecha de ingreso de la reserva"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(reserva.getFechaDeEgreso().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar la fecha de egreso de la reserva"), HttpStatus.BAD_REQUEST);


        ReservaHotelRequest reservaHotelModel = new ReservaHotelRequest(
               reserva.getIdUsuario(),
               reserva.getIdHotel(),
               reserva.getPension(),
               reserva.getIdSucursal(),
               reserva.getFechaDeIngreso(),
               reserva.getFechaDeEgreso()
                );
        reservaHotelService.agregarReservaHotel(reservaHotelModel);
        return new ResponseEntity(new MensajeModel("La reserva del hotel ha sido registrada exitosamente") , HttpStatus.OK);
    }

//    @PutMapping("/actualizar/{id}")
//    public ResponseEntity<ReservaHotelModel> update(@PathVariable("id")Long id, @RequestBody ReservaHotelModel reserva){
//        if(!reservaHotelService.existsById(id))
//            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
//        if(StringUtils.isBlank(reserva.getIdUsuario().toString()))
//            return new ResponseEntity(new MensajeModel("Olvido competar el usuario de la reserva"), HttpStatus.BAD_REQUEST);
//        if(StringUtils.isBlank(reserva.getIdHotel().toString()))
//            return new ResponseEntity(new MensajeModel("Olvido competar Hotel de la reserva"), HttpStatus.BAD_REQUEST);
//        if(StringUtils.isBlank(reserva.getPension()))
//            return new ResponseEntity(new MensajeModel("Olvido competar la pension de la reserva"), HttpStatus.BAD_REQUEST);
//        if(StringUtils.isBlank(reserva.getIdSucursal().toString()))
//            return new ResponseEntity(new MensajeModel("Olvido competar la sucursal de la reserva"), HttpStatus.BAD_REQUEST);
//        if(StringUtils.isBlank(reserva.getFechaDeIngreso().toString()))
//            return new ResponseEntity(new MensajeModel("Olvido competar la fecha de ingreso de la reserva"), HttpStatus.BAD_REQUEST);
//        if(StringUtils.isBlank(reserva.getFechaDeEgreso().toString()))
//            return new ResponseEntity(new MensajeModel("Olvido competar la fecha de egreso de la reserva"), HttpStatus.BAD_REQUEST);
//
//        ReservaHotelModel reservaHotelModel = reservaHotelService.obtenerReservaHotelPorId(id).get();
//        reservaHotelModel.setIdUsuario(reserva.getIdUsuario());
//        reservaHotelModel.setIdHotel(reserva.getIdHotel());
//        reservaHotelModel.setPension(reserva.getPension());
//        reservaHotelModel.setIdSucursal(reserva.getIdSucursal());
//        reservaHotelModel.setFechaDeIngreso(reserva.getFechaDeIngreso());
//        reservaHotelModel.setFechaDeEgreso(reserva.getFechaDeEgreso());
//
//        reservaHotelService.agregarReservaHotel(reservaHotelModel);
//        return new ResponseEntity(new MensajeModel("La reserva ha sido actualizada exitosamente"), HttpStatus.OK);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ReservaHotelModel> delete(@PathVariable("id")Long id){
        if(!reservaHotelService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        reservaHotelService.delete(id);
        return new ResponseEntity(new MensajeModel("Reserva eliminada"), HttpStatus.OK);
    }
}
