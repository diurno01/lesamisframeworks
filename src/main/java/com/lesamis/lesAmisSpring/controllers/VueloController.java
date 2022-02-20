package com.lesamis.lesAmisSpring.controllers;


import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.MensajeModel;
import com.lesamis.lesAmisSpring.models.VueloModel;
import com.lesamis.lesAmisSpring.services.VueloService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/vuelo")
public class VueloController {
    @Autowired
    VueloService vueloService;

    @GetMapping("/lista")
    public ResponseEntity<List<VueloModel>> obtenerVuelos(){
        List<VueloModel> list = vueloService.obtenerVuelos();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<VueloModel> obtenerVueloPorId(@PathVariable("id") Long id){
        if(!vueloService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        VueloModel vuelo = vueloService.obtenerVueloPorId(id).get();
        return new ResponseEntity(vuelo, HttpStatus.OK);
    }
    @GetMapping("/detalle/numero/{id}")
    public ResponseEntity<VueloModel> obtenerVueloPorNumeroDeVuelo(@PathVariable("nomeroDeVuelo") Long nomeroDeVuelo){
        if(!vueloService.existsByNumeroDeVuelo(nomeroDeVuelo))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        VueloModel vuelo = vueloService.findByNumeroDeVuelo(nomeroDeVuelo).get();
        return new ResponseEntity(vuelo, HttpStatus.OK);
    }

//    @GetMapping("/detalle/{nombre}")
//    public ResponseEntity<HotelModel> obtenerPorNumeroDeVuelo(@PathVariable("nombre") Long numeroDeVuelo){
//        if(!vueloService.existsByNumeroDeVuelo(numeroDeVuelo))
//            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
//        VueloModel vuelo = vueloService.obtenerVueloPorId(numeroDeVuelo).get();
//        return new ResponseEntity(vuelo, HttpStatus.OK);
//    }

    @PostMapping("/crear")
    public ResponseEntity<VueloModel> create(@RequestBody VueloModel vuelo){
        if(StringUtils.isBlank(vuelo.getNumeroDeVuelo().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar el numero de vuelo"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(vuelo.getFechaYHora().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar la hora y fecha del vuelo"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(vuelo.getOrigen()))
            return new ResponseEntity(new MensajeModel("Olvido competar el origen del vuelo"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(vuelo.getDestino()))
            return new ResponseEntity(new MensajeModel("Olvido competar el destino del vuelo"), HttpStatus.BAD_REQUEST);
        if(vuelo.getPlazasPrimeraClase() == null || vuelo.getPlazasPrimeraClase() < 0 )
            return new ResponseEntity(new MensajeModel("La cantidad de plazas de primera clase debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(vuelo.getPlazasClaseTurista() == null || vuelo.getPlazasClaseTurista() < 0 )
            return new ResponseEntity(new MensajeModel("La cantidad de plazas de clase turista debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(vuelo.getPrecioPrimeraClase() == null || vuelo.getPrecioPrimeraClase() < 0 )
            return new ResponseEntity(new MensajeModel("El precio de primera clase debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(vuelo.getPrecioClaseturista() == null || vuelo.getPrecioClaseturista() < 0 )
            return new ResponseEntity(new MensajeModel("El precio de clase turista debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(vuelo.getPrecioClaseturista() > vuelo.getPrecioPrimeraClase() )
            return new ResponseEntity(new MensajeModel("El precio de primeraclase tiene que ser superior al de la clase turista"), HttpStatus.BAD_REQUEST);
        if(vueloService.existsByNumeroDeVuelo(vuelo.getNumeroDeVuelo()))
            return new ResponseEntity(new MensajeModel("El numero de vuelo ya existe"), HttpStatus.BAD_REQUEST);
        VueloModel vueloModel = new VueloModel(vuelo.getNumeroDeVuelo(),
                vuelo.getFechaYHora(),
                vuelo.getOrigen(),
                vuelo.getDestino(),
                vuelo.getPlazasPrimeraClase(),
                vuelo.getPlazasClaseTurista(),
                vuelo.getPrecioPrimeraClase(),
                vuelo.getPrecioClaseturista());
        vueloService.agregarVuelo(vueloModel);
        return new ResponseEntity(new MensajeModel("El vuelo ha sido registrado exitosamente") , HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<VueloModel> update(@PathVariable("id")Long id, @RequestBody VueloModel vuelo){
        if(!vueloService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(vuelo.getNumeroDeVuelo().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar el numero de vuelo"), HttpStatus.BAD_REQUEST);
        if(vueloService.existsByNumeroDeVuelo(vuelo.getNumeroDeVuelo()))// revisar, hay verificar que no haya otro vuelo con el mismo numero
            return new ResponseEntity(new MensajeModel("Ese numero de vuelo ya existe ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(vuelo.getFechaYHora().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar la hora y fecha del vuelo"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(vuelo.getOrigen()))
            return new ResponseEntity(new MensajeModel("Olvido competar el origen del vuelo"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(vuelo.getDestino()))
            return new ResponseEntity(new MensajeModel("Olvido competar el destino del vuelo"), HttpStatus.BAD_REQUEST);
        if(vuelo.getPlazasPrimeraClase() == null || vuelo.getPlazasPrimeraClase() < 0 )
            return new ResponseEntity(new MensajeModel("La cantidad de plazas de primera clase debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(vuelo.getPlazasClaseTurista() == null || vuelo.getPlazasClaseTurista() < 0 )
            return new ResponseEntity(new MensajeModel("La cantidad de plazas de clase turista debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(vuelo.getPrecioPrimeraClase() == null || vuelo.getPrecioPrimeraClase() < 0 )
            return new ResponseEntity(new MensajeModel("El precio de primera clase debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(vuelo.getPrecioClaseturista() == null || vuelo.getPrecioClaseturista() < 0 )
            return new ResponseEntity(new MensajeModel("El precio de clase turista debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(vuelo.getPrecioClaseturista() > vuelo.getPrecioPrimeraClase() )
            return new ResponseEntity(new MensajeModel("El precio de primeraclase tiene que ser superior al de la clase turista"), HttpStatus.BAD_REQUEST);
        if(vueloService.existsByNumeroDeVuelo(vuelo.getNumeroDeVuelo()))
            return new ResponseEntity(new MensajeModel("El numero de vuelo ya existe"), HttpStatus.BAD_REQUEST);

        VueloModel vueloModel = vueloService.obtenerVueloPorId(id).get();
        vueloModel.setNumeroDeVuelo(vuelo.getNumeroDeVuelo());
        vueloModel.setFechaYHora(vuelo.getFechaYHora());
        vueloModel.setOrigen(vuelo.getOrigen());
        vueloModel.setDestino(vuelo.getDestino());
        vueloModel.setPlazasPrimeraClase(vuelo.getPlazasPrimeraClase());
        vueloModel.setPrecioClaseturista(vuelo.getPrecioClaseturista());
        vueloModel.setPrecioPrimeraClase(vueloModel.getPrecioPrimeraClase());
        vueloModel.setPlazasClaseTurista(vuelo.getPlazasClaseTurista());

        vueloService.agregarVuelo(vueloModel);
        return new ResponseEntity(new MensajeModel("Vuelo actualizado exitosamente"), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<VueloModel> delete(@PathVariable("id")Long id){
        if(!vueloService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        vueloService.delete(id);
        return new ResponseEntity(new MensajeModel("Vuelo eliminado"), HttpStatus.OK);
    }


//    @GetMapping()
//    public ArrayList<VueloModel> obtenerVuelos(){
//        return vueloService.obtenerVuelos();
//    }
//
//    @PostMapping()
//    public VueloModel guardarVuelo(@RequestBody VueloModel vuelo){
//        return this.vueloService.agregarVuelo(vuelo);
//    }
//
//    @GetMapping( path = "/{id}")
//    public Optional<VueloModel> obtenerVueloPorId(@PathVariable("id") Long id) {
//        return this.vueloService.obtenerVueloPorId(id);
//    }
//
//    @DeleteMapping( path = "/{id}")
//    public String eliminarVueloPorId(@PathVariable("id") Long id){
//        boolean ok = this.vueloService.eliminarVuelo(id);
//        if (ok){
//            return "Se eliminó el vuelo con id " + id;
//        }else{
//            return "No pudo eliminar el vuelo con id" + id;
//        }
//    }

}
