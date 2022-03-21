package com.lesamis.lesAmisSpring.controllers;


import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.MensajeModel;
import com.lesamis.lesAmisSpring.models.Requests.HotelRequest;
import com.lesamis.lesAmisSpring.models.Requests.VueloRequest;
import com.lesamis.lesAmisSpring.models.VueloModel;
import com.lesamis.lesAmisSpring.services.HotelService;
import com.lesamis.lesAmisSpring.services.ReservaHotelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @Autowired
    ReservaHotelService reservaHotelService;


//    @GetMapping("/lista")
//    public ResponseEntity<List<HotelModel>> obtenerHoteles(){
//        List<HotelModel> list = hotelService.obtenerHoteles();
//        return new ResponseEntity(list, HttpStatus.OK);
//    }

    @GetMapping("/lista")
    public ResponseEntity<List<HotelRequest>> obtenerVuelos(){
        List<HotelModel> list = hotelService.obtenerHoteles();
        List<HotelRequest> lista = new ArrayList<HotelRequest>();

        //Long id, String nombre, String direccion, String ciudad, String telefono, Integer numeroDePlazasDisponibles
        for(HotelModel hotel :list) {
            HotelRequest hr = new HotelRequest(
                    hotel.getId(),
                    hotel.getNombre(),
                    hotel.getDireccion(),
                    hotel.getCiudad(),
                    hotel.getTelefono(),
                    (hotel.getNumeroDePlazas()- reservaHotelService.obtenerReservasHotePorHotel(hotel.getId()))
            );
            lista.add(hr);
        }

        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<HotelModel> obtenerHotelPorId(@PathVariable("id") Long id){
        if(!hotelService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        HotelModel hotel = hotelService.obtenerHotelPorId(id).get();
        return new ResponseEntity(hotel, HttpStatus.OK);
    }

    @GetMapping("/detalleNombre/{nombre}")
    public ResponseEntity<HotelModel> obtenerPorNombre(@PathVariable("nombre") String nombre){
        if(!hotelService.existsByNombre(nombre))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        HotelModel hotel = hotelService.obtenerPorNombre(nombre).get();
        return new ResponseEntity(hotel, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<HotelModel> create(@RequestBody HotelModel hotel){
        if(StringUtils.isBlank(hotel.getNombre()))
            return new ResponseEntity(new MensajeModel("Olvido competar el nombre del Hotel"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(hotel.getDireccion()))
            return new ResponseEntity(new MensajeModel("Olvido competar la dirección del Hotel"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(hotel.getCiudad()))
            return new ResponseEntity(new MensajeModel("Olvido competar la ciudad del Hotel"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(hotel.getTelefono()))
            return new ResponseEntity(new MensajeModel("Olvido competar el telefono del Hotel"), HttpStatus.BAD_REQUEST);
        if(hotel.getNumeroDePlazas() == null || hotel.getNumeroDePlazas() < 0 )
            return new ResponseEntity(new MensajeModel("La cantidad de plazas debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(hotel.getPrecioMediaPension() == null || hotel.getPrecioMediaPension() < 0 )
//            return new ResponseEntity(new MensajeModel("El precio de la media pension debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(hotel.getPrecioPensionCompleta() == null || hotel.getPrecioPensionCompleta() < 0 )
//            return new ResponseEntity(new MensajeModel("El precio de la pension completa debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(hotel.getPrecioMediaPension() > hotel.getPrecioPensionCompleta() )
//            return new ResponseEntity(new MensajeModel("El precio de la pension completa tiene que ser superior al de la pension media"), HttpStatus.BAD_REQUEST);
        if(hotelService.existsByNombre(hotel.getNombre()))
            return new ResponseEntity(new MensajeModel("El nombre del hotel ya existe"), HttpStatus.BAD_REQUEST);
        HotelModel hotelModel = new HotelModel(hotel.getNombre(),
                hotel.getDireccion(),
                hotel.getCiudad(),
                hotel.getTelefono(),
                hotel.getNumeroDePlazas()
                );
        hotelService.agregarHotel(hotelModel);
        return new ResponseEntity(new MensajeModel("El hotel ha sido registrado exitosamente") , HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<HotelModel> update(@PathVariable("id")Long id, @RequestBody HotelModel hotel){
        if(!hotelService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(hotel.getNombre()))
            return new ResponseEntity(new MensajeModel("Olvido competar el nombre del Hotel"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(hotel.getDireccion()))
            return new ResponseEntity(new MensajeModel("Olvido competar la dirección del Hotel"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(hotel.getCiudad()))
            return new ResponseEntity(new MensajeModel("Olvido competar la ciudad del Hotel"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(hotel.getTelefono()))
            return new ResponseEntity(new MensajeModel("Olvido competar el telefono del Hotel"), HttpStatus.BAD_REQUEST);
        if(hotel.getNumeroDePlazas() == null || hotel.getNumeroDePlazas() < 0 )
            return new ResponseEntity(new MensajeModel("La cantidad de plazas debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(hotel.getPrecioMediaPension() == null || hotel.getPrecioMediaPension() < 0 )
//            return new ResponseEntity(new MensajeModel("El precio de la media pension debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(hotel.getPrecioPensionCompleta() == null || hotel.getPrecioPensionCompleta() < 0 )
//            return new ResponseEntity(new MensajeModel("El precio de la pension completa debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(hotel.getPrecioMediaPension() > hotel.getPrecioPensionCompleta() )
//            return new ResponseEntity(new MensajeModel("El precio de la pension completa tiene que ser superior al de la pension media"), HttpStatus.BAD_REQUEST);
//        if(hotelService.existsByNombre(hotel.getNombre()))
//            return new ResponseEntity(new MensajeModel("El nombre del hotel ya existe"), HttpStatus.BAD_REQUEST);

        HotelModel hotelModel = hotelService.obtenerHotelPorId(id).get();
        hotelModel.setNombre(hotel.getNombre());
        hotelModel.setDireccion(hotel.getDireccion());
        hotelModel.setCiudad(hotelModel.getCiudad());
        hotelModel.setNumeroDePlazas(hotel.getNumeroDePlazas());

        hotelService.agregarHotel(hotelModel);
        return new ResponseEntity(new MensajeModel("Hotel actualizado exitosamente"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HotelModel> delete(@PathVariable("id")Long id){
        if(!hotelService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        hotelService.delete(id);
        return new ResponseEntity(new MensajeModel("Hotel eliminado"), HttpStatus.OK);
    }

}
