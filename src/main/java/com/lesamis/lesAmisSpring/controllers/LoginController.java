package com.lesamis.lesAmisSpring.controllers;

import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.LoginModel;
import com.lesamis.lesAmisSpring.models.MensajeModel;
import com.lesamis.lesAmisSpring.models.UsuarioModel;
import com.lesamis.lesAmisSpring.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/login")
public class LoginController {
    LoginService loginService;


    @GetMapping("/get")
    public ResponseEntity<?> login(@RequestBody LoginModel loginModel){
        if(!loginService.existByUsuarioAndPassword(loginModel.getNombreUsuario(), loginModel.getPassword()))
            return new ResponseEntity(new MensajeModel("Este usuario no existe, vuelva a intentar."), HttpStatus.NOT_FOUND);
        UsuarioModel user = loginService.login(loginModel.getNombreUsuario(), loginModel.getPassword()).get();
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> loginUser(@RequestBody LoginModel loginModel){
        if(!loginService.existByUsuarioAndPassword(loginModel.getNombreUsuario(), loginModel.getPassword()))
            return new ResponseEntity(new MensajeModel("Este usuario no existe, vuelva a intentar."), HttpStatus.NOT_FOUND);
        UsuarioModel usuario = loginService.login(loginModel.getNombreUsuario(), loginModel.getPassword()).get();
        return new ResponseEntity(usuario, HttpStatus.OK);
    }
}
