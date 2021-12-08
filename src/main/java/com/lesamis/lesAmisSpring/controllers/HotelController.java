package com.lesamis.lesAmisSpring.controllers;

import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.VueloModel;
import com.lesamis.lesAmisSpring.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;


//    @GetMapping()
//    public ArrayList<HotelModel> obtenerHoteles(){
//        return hotelService.obtenerHoteles();
//    }

//    @PostMapping()
//    public HotelModel guardarHotel(@RequestBody HotelModel hotel){
//        return this.hotelService.agregarHotel(hotel);
//    }

    @GetMapping( path = "/{id}")
    public Optional<HotelModel> obtenerHotelPorId(@PathVariable("id") Long id) {
        return this.hotelService.obtenerHotelPorId(id);
    }

//    @DeleteMapping( path = "/{id}")
//    public String eliminarHotelPorId(@PathVariable("id") Long id){
//        boolean ok = this.hotelService.eliminarHotel(id);
//        if (ok){
//            return "Se eliminó el hotel con id " + id;
//        }else{
//            return "No pudo eliminar el hotel con id" + id;
//        }
//    }
}
