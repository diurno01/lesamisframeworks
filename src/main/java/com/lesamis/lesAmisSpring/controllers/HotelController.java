package com.lesamis.lesAmisSpring.controllers;


import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.MensajeModel;
import com.lesamis.lesAmisSpring.services.HotelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/lista")
    public ResponseEntity<List<HotelModel>> obtenerHoteles(){
        List<HotelModel> list = hotelService.obtenerHoteles();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<HotelModel> obtenerHotelPorId(@PathVariable("id") Long id){
        if(!hotelService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        HotelModel hotel = hotelService.obtenerHotelPorId(id).get();
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @GetMapping("/detalle/{nombre}")
    public ResponseEntity obtenerPorNombre(@PathVariable("nombre") String nombre){
        if(!hotelService.existsByNombre(nombre))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        HotelModel hotel = hotelService.obtenerPorNombre(nombre).get();
        return new ResponseEntity(hotel, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody HotelModel hotel){
        if(StringUtils.isBlank(hotel.getNombre()))
            return new ResponseEntity<>(new MensajeModel("Olvido competar el nombre del Hotel"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(hotel.getDireccion()))
            return new ResponseEntity<>(new MensajeModel("Olvido competar la dirección del Hotel"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(hotel.getCiudad()))
            return new ResponseEntity<>(new MensajeModel("Olvido competar la ciudad del Hotel"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(hotel.getTelefono()))
            return new ResponseEntity<>(new MensajeModel("Olvido competar el telefono del Hotel"), HttpStatus.BAD_REQUEST);
        if(hotel.getNumeroDePlazas() == null || hotel.getNumeroDePlazas() < 0 )
            return new ResponseEntity<>(new MensajeModel("La cantidad de plazas debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(hotel.getPrecioMediaPension() == null || hotel.getPrecioMediaPension() < 0 )
            return new ResponseEntity<>(new MensajeModel("El precio de la media pension debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(hotel.getPrecioPensionCompleta() == null || hotel.getPrecioPensionCompleta() < 0 )
            return new ResponseEntity<>(new MensajeModel("El precio de la pension completa debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(hotel.getPrecioMediaPension() > hotel.getPrecioPensionCompleta() )
            return new ResponseEntity<>(new MensajeModel("El precio de la pension completa tiene que ser superior al de la pension media"), HttpStatus.BAD_REQUEST);
        if(hotelService.existsByNombre(hotel.getNombre()))
            return new ResponseEntity<>(new MensajeModel("El nombre del hotel ya existe"), HttpStatus.BAD_REQUEST);
        HotelModel hotelModel = new HotelModel(hotel.getNombre(),
                hotel.getDireccion(),
                hotel.getCiudad(),
                hotel.getTelefono(),
                hotel.getNumeroDePlazas(),
                hotel.getPrecioPensionCompleta(),
                hotel.getPrecioMediaPension());
        hotelService.agregarHotel(hotel);
        return new ResponseEntity<>(new MensajeModel("El hotel ha sido registrado exitosamente") , HttpStatus.OK);
    }

 //   @GetMapping( path = "/{id}")
   // public Optional<HotelModel> obtenerHotelPorId(@PathVariable("id") Long id) {
     //   return this.hotelService.obtenerHotelPorId(id);
    //}

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
