package com.lesamis.lesAmisSpring.controllers;

import com.lesamis.lesAmisSpring.models.HotelModel;
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


    @GetMapping("")
    public ResponseEntity<UsuarioModel> login(@PathVariable("usuario") String usuario,@PathVariable("password") String password){
        if(!loginService.existByUsuarioAndPassword(usuario, password))
            return new ResponseEntity(new MensajeModel("Este usuario no existe, vuelva a intentar."), HttpStatus.NOT_FOUND);
        UsuarioModel user = loginService.login(usuario, password).get();
        return new ResponseEntity(user, HttpStatus.OK);
    }

}
