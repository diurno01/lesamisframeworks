package com.lesamis.lesAmisSpring.controllers;


import com.lesamis.lesAmisSpring.models.MensajeModel;
import com.lesamis.lesAmisSpring.models.UsuarioModel;
import com.lesamis.lesAmisSpring.services.UsuarioService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/lista")
    public ResponseEntity<List<UsuarioModel>> obtenerUsuarios(){
        List<UsuarioModel> list = usuarioService.obtenerUsuarios();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        if(!usuarioService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        UsuarioModel usuario = usuarioService.obtenerUsuarioPorId(id).get();
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<UsuarioModel> obtenerUsuarioPorDni(@PathVariable("dni") Long dni){
        if(!usuarioService.existsByDni(dni))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        UsuarioModel usuario = usuarioService.obtenerPorDni(dni).get();
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuarioModel> create(@RequestBody UsuarioModel usuario){
        if(!usuarioService.existsByUsuario(usuario.getUsuario()))
            return new ResponseEntity(new MensajeModel("Este usuario ya existe"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(usuario.getUsuario()))
            return new ResponseEntity(new MensajeModel("Olvido competar el Login del usuario"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuario.getPassword()))
            return new ResponseEntity(new MensajeModel("Olvido competar la contraseña del usuario"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuario.getDni().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar el DNI del usuario"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuario.getNombre()))
            return new ResponseEntity(new MensajeModel("Olvido competar el Nombre del usuario"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuario.getApellido()))
            return new ResponseEntity(new MensajeModel("Olvido competar el Apellido del usuario"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuario.getTelefono()))
            return new ResponseEntity(new MensajeModel("Olvido competar el Telefono del usuario"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuario.getEmail()))
            return new ResponseEntity(new MensajeModel("Olvido competar el Email del usuario"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuario.getTipo().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar el Tipo de usuario"), HttpStatus.BAD_REQUEST);

        UsuarioModel usuarioModel = new UsuarioModel(usuario.getUsuario(),
                usuario.getPassword(),
                usuario.getDni(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getDireccion(),
                usuario.getTelefono(),
                usuario.getEmail(),
                usuario.getTipo());
        usuarioService.agregarUsuario(usuarioModel);
        return new ResponseEntity(new MensajeModel("El usuario ha sido registrado exitosamente") , HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UsuarioModel> update(@PathVariable("id")Long id, @RequestBody UsuarioModel usuario){
        if(!usuarioService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        if(usuarioService.obtenerPorUsuario(usuario.getUsuario()).get().getId() != id)
            return new ResponseEntity(new MensajeModel("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(!usuarioService.existsByUsuario(usuario.getUsuario()))
            return new ResponseEntity(new MensajeModel("Este usuario ya existe"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(usuario.getUsuario()))
            return new ResponseEntity(new MensajeModel("Olvido competar el Login del usuario"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuario.getPassword()))
            return new ResponseEntity(new MensajeModel("Olvido competar la contraseña del usuario"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuario.getDni().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar el DNI del usuario"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuario.getNombre()))
            return new ResponseEntity(new MensajeModel("Olvido competar el Nombre del usuario"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuario.getApellido()))
            return new ResponseEntity(new MensajeModel("Olvido competar el Apellido del usuario"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuario.getTelefono()))
            return new ResponseEntity(new MensajeModel("Olvido competar el Telefono del usuario"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuario.getEmail()))
            return new ResponseEntity(new MensajeModel("Olvido competar el Email del usuario"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuario.getTipo().toString()))
            return new ResponseEntity(new MensajeModel("Olvido competar el Tipo de usuario"), HttpStatus.BAD_REQUEST);

        UsuarioModel usuarioModel = usuarioService.obtenerUsuarioPorId(id).get();
        usuarioModel.setUsuario(usuario.getUsuario());
        usuarioModel.setPassword(usuario.getPassword());
        usuarioModel.setDni(usuario.getDni());
        usuarioModel.setNombre(usuario.getNombre());
        usuarioModel.setApellido(usuario.getApellido());
        usuarioModel.setDireccion(usuario.getDireccion());
        usuarioModel.setTelefono(usuario.getTelefono());
        usuarioModel.setEmail(usuario.getEmail());
        usuarioModel.setTipo(usuario.getTipo());

        usuarioService.agregarUsuario(usuarioModel);
        return new ResponseEntity(new MensajeModel("Usuario actualizado exitosamente"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UsuarioModel> delete(@PathVariable("id")Long id){
        if(!usuarioService.existsById(id))
            return new ResponseEntity(new MensajeModel("no existe"), HttpStatus.NOT_FOUND);
        usuarioService.eliminarUsuario(id);
        return new ResponseEntity(new MensajeModel("Hotel eliminado"), HttpStatus.OK);
    }






    //   @Get
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
