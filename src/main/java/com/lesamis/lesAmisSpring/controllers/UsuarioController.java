package com.lesamis.lesAmisSpring.controllers;


import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.MensajeModel;
import com.lesamis.lesAmisSpring.models.Tipo;
import com.lesamis.lesAmisSpring.models.UsuarioModel;
import com.lesamis.lesAmisSpring.services.UsuarioService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/lista")
    public ResponseEntity<List<UsuarioModel>> obtenerUsuarios(){
        List<UsuarioModel> list = usuarioService.obtenerUsuarios();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        if(!usuarioService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        UsuarioModel usuario = usuarioService.obtenerUsuarioPorId(id).get();
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<UsuarioModel> obtenerUsuarioPorDni(@PathVariable("dni") Long dni){
        if(!usuarioService.existsByDni(dni))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        UsuarioModel usuario = usuarioService.findByDni(dni).get();
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

//    @PostMapping("/crear")
//    public ResponseEntity<?> create(@RequestBody UsuarioModel usuario){
//        if(StringUtils.isBlank(hotel.getNombre()))
//            return new ResponseEntity<>(new MensajeModel("Olvido competar el nombre del Hotel"), HttpStatus.BAD_REQUEST);
//        if(StringUtils.isBlank(hotel.getDireccion()))
//            return new ResponseEntity<>(new MensajeModel("Olvido competar la dirección del Hotel"), HttpStatus.BAD_REQUEST);
//        if(StringUtils.isBlank(hotel.getCiudad()))
//            return new ResponseEntity<>(new MensajeModel("Olvido competar la ciudad del Hotel"), HttpStatus.BAD_REQUEST);
//        if(StringUtils.isBlank(hotel.getTelefono()))
//            return new ResponseEntity<>(new MensajeModel("Olvido competar el telefono del Hotel"), HttpStatus.BAD_REQUEST);
//        if(hotel.getNumeroDePlazas() == null || hotel.getNumeroDePlazas() < 0 )
//            return new ResponseEntity<>(new MensajeModel("La cantidad de plazas debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(hotel.getPrecioMediaPension() == null || hotel.getPrecioMediaPension() < 0 )
//            return new ResponseEntity<>(new MensajeModel("El precio de la media pension debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(hotel.getPrecioPensionCompleta() == null || hotel.getPrecioPensionCompleta() < 0 )
//            return new ResponseEntity<>(new MensajeModel("El precio de la pension completa debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(hotel.getPrecioMediaPension() > hotel.getPrecioPensionCompleta() )
//            return new ResponseEntity<>(new MensajeModel("El precio de la pension completa tiene que ser superior al de la pension media"), HttpStatus.BAD_REQUEST);
//        if(hotelService.existsByNombre(hotel.getNombre()))
//            return new ResponseEntity<>(new MensajeModel("El nombre del hotel ya existe"), HttpStatus.BAD_REQUEST);
//        HotelModel hotelModel = new HotelModel(hotel.getNombre(),
//                hotel.getDireccion(),
//                hotel.getCiudad(),
//                hotel.getTelefono(),
//                hotel.getNumeroDePlazas(),
//                hotel.getPrecioPensionCompleta(),
//                hotel.getPrecioMediaPension());
//        hotelService.agregarHotel(hotelModel);
//        return new ResponseEntity<>(new MensajeModel("El hotel ha sido registrado exitosamente") , HttpStatus.OK);
//    }

//    @GetMapping()
//    public List<UsuarioModel> obtenerUsuarios(){
//        return usuarioService.obtenerUsuarios();
//    }
//
//    @PostMapping()
//    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
//        return this.usuarioService.guardarUsuario(usuario);
//    }
//
//    @GetMapping( path = "/{id}")
//    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
//        return this.usuarioService.obtenerUsuarioPorId(id);
//    }
//
//    @GetMapping("/query")
//    public Optional<UsuarioModel> obtenerUsuariosPorTipo(@RequestParam("tipo") Tipo tipo){
//        return this.usuarioService.obtenerUsuariosPorTipo(tipo);
//    }
//
//    @DeleteMapping( path = "/{id}")
//    public String eliminarPorId(@PathVariable("id") Long id){
//        boolean ok = this.usuarioService.eliminarUsuario(id);
//        if (ok){
//            return "Se eliminó el usuario con id " + id;
//        }else{
//            return "No pudo eliminar el usuario con id" + id;
//        }
//    }

}
